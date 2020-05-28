package ru.kladnitskiy.AMSService.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kladnitskiy.AMSService.rest.utils.TestHelper.NORMAL_JSON_WITH_ID;

@Sql(scripts = "classpath:database/testPopulateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UpdateAmsTest extends AbstractTest {

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
                .content(NORMAL_JSON_WITH_ID)
        )
                .andExpect(status().isNotFound());
    }

}
