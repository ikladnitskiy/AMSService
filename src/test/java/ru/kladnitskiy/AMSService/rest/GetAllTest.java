package ru.kladnitskiy.AMSService.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.rest.utils.AmsInfoTest;
import ru.kladnitskiy.AMSService.rest.utils.TestHelper;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "classpath:testPopulateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class GetAllTest extends AbstractTest {

    private final TestHelper testHelper = new TestHelper();
    private final TypeReference<List<AmsInfoTest>> typeReference = new TypeReference<List<AmsInfoTest>>() {
    };

    @Override
    @Before
    public void setup() {
        super.setup();
    }

    //test1
    @Test
    public void getAllWithoutFiltersReturnAllAms() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms());
        assertTrue("Возвращается неверный результат при запросе GET /api/ams.", actual.equals(expected));
    }

    //test2
    @Test
    public void getAllWithFiltersAddressPageNumber() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?address=ka&pageNumber=1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(1, 5, testHelper.getAllAms().stream()
                .filter(ams -> ams.getAddress().contains("ka"))
                .collect(Collectors.toList()));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами address и pageNumber.", actual.equals(expected));
    }

    //test3
    @Test
    public void getAllWithFiltersTypePageSize() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?type=MAST&pageSize=7")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 7, testHelper.getAllAms().stream()
                .filter(ams -> ams.getType().equals(TypeAms.MAST))
                .collect(Collectors.toList()));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами type и pageSize.", actual.equals(expected));
    }

    //test4
    @Test
    public void getAllWithFiltersRangeHeight() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?minHeight=20.0&maxHeight=90.0")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> ams.getHeight() >= 20d && ams.getHeight() <= 90d)
                .collect(Collectors.toList()));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами minSize и maxSize.", actual.equals(expected));
    }

    //test5
    @Test
    public void getAllWithFiltersCodeCluster() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?code=LE&cluster=East")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> ams.getCode().equals("LE"))
                .filter(ams -> ams.getCluster().equals("East"))
                .collect(Collectors.toList()));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами code и cluster.", actual.equals(expected));
    }

    //test6
    @Test
    public void getAllWithFiltersNumber() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?number=1020")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        actual.sort(Comparator.comparing(ams -> ams.id));
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> ams.getNumber().equals(1020))
                .sorted(Comparator.comparing(ams -> ams.id))
                .collect(Collectors.toList()));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметром number.", actual.equals(expected));
    }

    //test7
    @Test
    public void getAllWithFiltersServiceContractorAccess() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?serviceContractor=Krivorukov&isAccess=true")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> Objects.equals(ams.getServiceContractor(), "Krivorukov"))
                .filter(ams -> ams.isAccess().equals(true))
                .collect(Collectors.toList()));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами serviceContractor и isAccess.", actual.equals(expected));
    }

    //test8
    @Test
    public void getAllWithFiltersRangeServiceDate() throws Exception {
        LocalDate afterServiceDate = LocalDate.of(2020, 3, 3);
        LocalDate beforeServiceDate = LocalDate.of(2020, 5, 13);

        ResultActions resultActions = mockMvc.perform(get("/api/ams?afterServiceDate=2020-03-03&beforeServiceDate=2020-05-13")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> ams.getServiceDate() != null &&
                        (ams.getServiceDate().isAfter(afterServiceDate) || Objects.equals(ams.getServiceDate(), afterServiceDate)))
                .filter(ams -> ams.getServiceDate().isBefore(beforeServiceDate) || Objects.equals(ams.getServiceDate(), beforeServiceDate))
                .collect(Collectors.toList()));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами afterServiceDate и beforeServiceDate.", actual.equals(expected));
    }

    //test9
    @Test
    public void getAllWithFiltersRangeReportDate() throws Exception {
        LocalDate afterReportDate = LocalDate.of(2020, 4, 13);
        LocalDate beforeReportDate = LocalDate.of(2020, 5, 13);

        ResultActions resultActions = mockMvc.perform(get("/api/ams?afterReportDate=2020-04-13&beforeReportDate=2020-05-13")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> ams.getReportDate() != null &&
                        (ams.getReportDate().isAfter(afterReportDate) || Objects.equals(ams.getReportDate(), afterReportDate)))
                .filter(ams -> ams.getReportDate().isBefore(beforeReportDate) || Objects.equals(ams.getReportDate(), beforeReportDate))
                .collect(Collectors.toList()));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами afterReportDate и beforeReportDate.", actual.equals(expected));
    }

    //test10
    @Test
    public void getAllAmsWithFiltersReportContractorOrderReportDate() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?reportContractor=Idealniy&order=REPORT_DATE")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> Objects.equals(ams.getReportContractor(), "Idealniy"))
                .collect(Collectors.toList()));
        expected.sort(Comparator.comparing(AmsInfoTest::getReportDate));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами reportContractor и order.", actual.equals(expected));
    }

    //test11
    @Test
    public void getAllAmsWithFiltersTypeOrderHeight() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?type=TRIPOD&order=HEIGHT")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> ams.getType().equals(TypeAms.TRIPOD))
                .collect(Collectors.toList()));
        expected.sort(Comparator.comparing(AmsInfoTest::getHeight));
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами type и order.", actual.equals(expected));
    }

    //test12
    @Test
    public void getAllAmsWithFiltersCodeOrderServiceDate() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/ams?code=EK&order=SERVICE_DATE")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<AmsInfoTest> actual = mapFromJson(contentAsString, typeReference);
        List<AmsInfoTest> expected = testHelper.getAmsInfoByPage(0, 5, testHelper.getAllAms().stream()
                .filter(ams -> ams.getCode().equals("EK"))
                .collect(Collectors.toList()));
        expected.sort(Comparator.comparing(AmsInfoTest::getServiceDate));
        actual.forEach(System.out::println);
        assertTrue("Возвращается неверный результат при запросе GET /api/ams с параметрами code и order.", actual.equals(expected));
    }
}
