package com.github.timtebeek.betterassertions.mockmvc;

import com.github.timtebeek.betterassertions.BundleController;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BundleControllerOldTest {

    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new BundleController()).build();

    @Test
    void getBundle() throws Exception {
        mockMvc.perform(get("/bundle"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.books[0].title").value("Effective Java"));
    }

    @Test
    void boom() throws Exception {
        mockMvc.perform(get("/boom"))
                .andExpect(status().isInternalServerError());
    }

}
