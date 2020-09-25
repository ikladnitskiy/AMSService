package ru.kladnitskiy.AMSService.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.ResultActions;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.rest.utils.AmsInfoTest;
import ru.kladnitskiy.AMSService.rest.utils.TypesOfWorkInfoTest;

import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kladnitskiy.AMSService.rest.utils.TestHelper.*;

@Sql(scripts = "classpath:database/testPopulateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class CreateAmsTest extends AbstractTest {

    private final static Integer expectedId = 10000;

    private AmsInfoTest expected;

    @Override
    @Before
    public void setup() {
        super.setup();

        expected = new AmsInfoTest(expectedId, "PS", 38, "Pskov", "Pskovskaya obl., g. Ostrov", TypeAms.MAST, 90.0d,
                "Ivanov", LocalDate.of(2020, 5, 16), "Petrov", LocalDate.of(2020, 5, 20), false,
                new TypesOfWorkInfoTest(true, true, true, true, true, false, false, false, false, false, false, false, false, false, false));
    }

    //test1
    @Test
    public void createAmsEmptyBodyTest() throws Exception {
        mockMvc.perform(post("/api/ams")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content("{}")
        )
                .andExpect(status().isBadRequest());
    }

    //test2
    @Test
    public void createAmsNoAddressTest() throws Exception {
        mockMvc.perform(post("/api/ams")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(NO_ADDRESS_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test3
    @Test
    public void createAmsHeightNegativeTest() throws Exception {
        mockMvc.perform(post("/api/ams")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(NEGATIVE_HEIGHT_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test4
    @Test
    public void createAmsEmptyCodeTest() throws Exception {
        mockMvc.perform(post("/api/ams")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(EMPTY_CODE_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test5
    @Test
    public void createCodeLengthTooSmallTest() throws Exception {
        mockMvc.perform(post("/api/ams")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(LENGTH_CODE_TOO_SMALL_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test6
    @Test
    public void createAddressLengthTooBigTest() throws Exception {
        mockMvc.perform(post("/api/ams")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(LENGTH_ADDRESS_TOO_BIG_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test7
    @Test
    public void createAmsServiceDateLaterReportDateTest() throws Exception {
        mockMvc.perform(post("/api/ams")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(SERVICE_DATE_LATER_WHEN_THE_REPORT_DATE_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    //test8
    @Test
    public void createAmsTrueTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/api/ams")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(NORMAL_JSON))
                .andExpect(status().isCreated());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        AmsInfoTest actual = mapFromJson(contentAsString, AmsInfoTest.class);
        assertTrue("Возвращается неверный результат при запросе создания АМС.", actual.equals(expected));
    }
}