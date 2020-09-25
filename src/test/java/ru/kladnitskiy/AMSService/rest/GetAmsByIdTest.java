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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "classpath:database/testPopulateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class GetAmsByIdTest extends AbstractTest {

    @Override
    @Before
    public void setup() {
        super.setup();
    }

    //test1
    @Test
    public void getAmsByIdNotNumberTest() throws Exception {
        mockMvc.perform(get("/api/ams/test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    //test2
    @Test
    public void getAmsByIdNotExistTest() throws Exception {
        mockMvc.perform(get("/api/ams/100")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    //test3
    @Test
    public void getAmsByIdTest() throws Exception {
        AmsInfoTest expected = new AmsInfoTest(20007, "PS", 38, "Pskov", "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe", TypeAms.MAST, 90.0d,
                "Ivanov", LocalDate.of(2020, 5, 16), "Petrov", LocalDate.of(2020, 5, 20), false,
                new TypesOfWorkInfoTest(true, true, true, true, true, false, false, false, false, false, false, false, false, false, false));

        ResultActions resultActions = mockMvc.perform(get("/api/ams/20007")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        String resultAsString = resultActions.andReturn().getResponse().getContentAsString();
        AmsInfoTest actual = mapFromJson(resultAsString, AmsInfoTest.class);
        assertTrue("Вернулся неправильный объект при запросе GET /api/ams/{id}", actual.equals(expected));
    }
}
