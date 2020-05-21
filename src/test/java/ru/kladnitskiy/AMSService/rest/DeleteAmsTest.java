package ru.kladnitskiy.AMSService.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "classpath:database/testPopulateDB.sql")
public class DeleteAmsTest extends AbstractTest {

    @Override
    @Before
    public void setup() {
        super.setup();
    }

    //test1
    @Test
    public void deleteAmsByIdNotExistTest() throws Exception {
        mockMvc.perform(delete("/api/ams/100")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    //test2
    @Test
    public void deleteAmsByIdNotNumberTest() throws Exception {
        mockMvc.perform(delete("/api/ams/test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    //test3
    @Test
    public void deleteAmsByIdTest() throws Exception {
        mockMvc.perform(delete("/api/ams/20001")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/ams/20001")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

}