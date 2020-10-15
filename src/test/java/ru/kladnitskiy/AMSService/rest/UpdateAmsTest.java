package ru.kladnitskiy.AMSService.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.ResultActions;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.rest.utils.AmsInfoTest;
import ru.kladnitskiy.AMSService.rest.utils.TestHelper;

import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kladnitskiy.AMSService.rest.utils.TestHelper.*;

@Sql(scripts = "classpath:testPopulateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UpdateAmsTest extends AbstractTest {

    private final TestHelper testHelper = new TestHelper();

    @Override
    @Before
    public void setup() {
        super.setup();
    }

    //test1
    @Test
    public void updateAmsEmptyBodyTest() throws Exception {
        mockMvc.perform(put("/api/ams/20007")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content("{}")
        )
                .andExpect(status().isBadRequest());
    }

    //test2
    @Test
    public void updateAmsNotExistTest() throws Exception {
        mockMvc.perform(put("/api/ams/50007")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(String.format(NORMAL_JSON_WITH_ID, 50007))
        )
                .andExpect(status().isNotFound());
    }

    //test3
    @Test
    public void updateAmsNegativeHeightTest() throws Exception {
        mockMvc.perform(put("/api/ams/20007")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(NEGATIVE_HEIGHT_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test4
    @Test
    public void updateAmsEmptyAddressTest() throws Exception {
        mockMvc.perform(put("/api/ams/20007")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(EMPTY_ADDRESS_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test5
    @Test
    public void updateAmsServiceDateLaterReportDateTest() throws Exception {
        mockMvc.perform(put("/api/ams/20007")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(SERVICE_DATE_LATER_WHEN_THE_REPORT_DATE_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test6
    @Test
    public void updateAmsWithIdTest() throws Exception {
        AmsInfoTest expected = mapFromJson(String.format(NORMAL_JSON_WITH_ID, 20010), AmsInfoTest.class);

        ResultActions resultActions = mockMvc.perform(put("/api/ams/20010")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(String.format(NORMAL_JSON_WITH_ID, 20003))
        )
                .andExpect(status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        AmsInfoTest actual = mapFromJson(contentAsString, AmsInfoTest.class);

        assertTrue("При запросе PUT api/ams/{id} поле id не должно обновляться.", actual.id != 20003);
        assertTrue("При запросе PUT api/ams/{id} c полем id в теле запроса должны быть обновлены все поля, кроме id.", actual.equals(expected));
    }

    //test7
    @Test
    public void updateAmsWithDataTest() throws Exception {
        String code = "TST";
        Integer number = 1234;
        String address = "Test address";
        TypeAms type = TypeAms.PILLAR;
        Double height = 123.4d;
        String serviceContractor = "Contractor";
        LocalDate serviceDate = LocalDate.of(2020, 5, 9);

        AmsInfoTest expected = testHelper.getAmsInfoById(20007);
        expected.setCode(code);
        expected.setNumber(number);
        expected.setAddress(address);
        expected.setType(type);
        expected.setHeight(height);
        expected.setServiceContractor(serviceContractor);
        expected.setServiceDate(serviceDate);

        ResultActions resultActions = mockMvc.perform(put("/api/ams/20007")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(String.format(JSON_SKELETON, code, number, address, type, height, serviceContractor, serviceDate)))
                .andExpect(status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        AmsInfoTest actual = mapFromJson(contentAsString, AmsInfoTest.class);

        assertTrue("При запросе PUT api/ams/{id} должны быть обновлены все поля.", actual.equals(expected));
    }
}
