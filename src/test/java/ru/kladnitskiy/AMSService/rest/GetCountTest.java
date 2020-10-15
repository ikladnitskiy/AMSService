package ru.kladnitskiy.AMSService.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.rest.utils.TestHelper;

import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "classpath:testPopulateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class GetCountTest extends AbstractTest {

    private final TestHelper testHelper = new TestHelper();

    @Before
    @Override
    public void setup() {
        super.setup();
    }

    //test1
    @Test
    public void getCountWithoutFiltersReturnAllAms() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testHelper.getAllAms().size();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count.", actual == expected);
    }

    //test2
    @Test
    public void getCountWithFiltersMinHeightAfterServiceDateAfterReportDate() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count?minHeight=20.0&afterServiceDate=2020-03-01&afterReportDate=2020-02-15")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);

        LocalDate afterServiceDate = LocalDate.of(2020, 3, 1);
        LocalDate afterReportDate = LocalDate.of(2020, 2, 15);
        long expected = testHelper.getAllAms().stream()
                .filter(ams -> ams.getHeight() >= 20d)
                .filter(ams -> ams.getServiceDate() != null && (ams.getServiceDate().isAfter(afterServiceDate) || ams.getServiceDate().equals(afterReportDate)))
                .filter(ams -> ams.getReportDate() != null && (ams.getReportDate().isAfter(afterReportDate) || ams.getReportDate().equals(afterReportDate)))
                .count();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count с параметрами minHeight, afterServiceDate, afterReportDate.", actual == expected);
    }

    //test3
    @Test
    public void getCountWithFiltersMaxHeightBeforeServiceDate() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count?maxHeight=90.0&beforeServiceDate=2020-05-01")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);

        LocalDate beforeServiceDate = LocalDate.of(2020, 5, 1);
        long expected = testHelper.getAllAms().stream()
                .filter(ams -> ams.getHeight() <= 90d)
                .filter(ams -> ams.getServiceDate() != null && (ams.getServiceDate().isBefore(beforeServiceDate) || ams.getServiceDate().equals(beforeServiceDate)))
                .count();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count с параметрами maxHeight, beforeServiceDate.", actual == expected);
    }

    //test4
    @Test
    public void getCountWithFiltersAddressBeforeReportDate() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count?address=ska&beforeReportDate=2020-04-01")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);

        LocalDate beforeReportDate = LocalDate.of(2020, 4, 1);
        long expected = testHelper.getAllAms().stream()
                .filter(ams -> ams.getAddress().contains("ska"))
                .filter(ams -> ams.getReportDate() != null && (ams.getReportDate().isBefore(beforeReportDate) || ams.getReportDate().equals(beforeReportDate)))
                .count();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count с параметрами address, beforeReportDate.", actual == expected);
    }

    //test5
    @Test
    public void getCountWithFiltersCodeServiceContractor() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count?code=LE&serviceContractor=Butorin")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        long expected = testHelper.getAllAms().stream()
                .filter(ams -> ams.getCode().equals("LE"))
                .filter(ams -> ams.getServiceContractor().equals("Butorin"))
                .count();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count с параметрами code, serviceContractor.", actual == expected);
    }

    //test6
    @Test
    public void getCountWithFiltersClusterType() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count?cluster=Ekaterinburg&type=TOWER")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        long expected = testHelper.getAllAms().stream()
                .filter(ams -> ams.getCluster().equals("Ekaterinburg"))
                .filter(ams -> ams.getType().equals(TypeAms.TOWER))
                .count();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count с параметрами cluster, type.", actual == expected);
    }

    //test7
    @Test
    public void getCountWithFiltersNumber() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count?number=1020")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        long expected = testHelper.getAllAms().stream()
                .filter(ams -> ams.getNumber().equals(1020))
                .count();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count с параметром number.", actual == expected);
    }

    //test8
    @Test
    public void getCountWithFiltersReportContractorAfterReportDateBeforeReportDate() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count?reportContractor=Idealniy&afterReportDate=2020-01-01&beforeReportDate=2020-05-01")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);

        LocalDate afterReportDate = LocalDate.of(2020, 1, 1);
        LocalDate beforeReportDate = LocalDate.of(2020, 5, 1);
        long expected = testHelper.getAllAms().stream()
                .filter(ams -> ams.getReportContractor() != null && ams.getReportContractor().equals("Idealniy"))
                .filter(ams -> ams.getReportDate() != null && (ams.getReportDate().isAfter(afterReportDate) || ams.getReportDate().equals(afterReportDate)))
                .filter(ams -> ams.getReportDate().isBefore(beforeReportDate) || ams.getReportDate().equals(beforeReportDate))
                .count();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count с параметрами reportContractor, afterReportDate, beforeReportDate.", actual == expected);
    }

    //test9
    @Test
    public void getCountWithFiltersCodeAccessStatus() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams/count?code=EK&accessStatus=true")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        long expected = testHelper.getAllAms().stream()
                .filter(ams -> ams.getCode().equals("EK"))
                .filter(ams -> ams.getAccessStatus().equals(true))
                .count();
        assertTrue("Возвращается неверный результат при запросе GET /api/ams/count с параметрами code, accessStatus.", actual == expected);
    }
}
