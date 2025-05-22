package com.github.timtebeek.betterassertions.mockmvc;

import com.github.timtebeek.betterassertions.BundleController;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class BundleControllerBridgeTest {

    private final MockMvcTester mockMvc = MockMvcTester.of(new BundleController());

    @Test
    void getBundle() {
        assertThat(mockMvc.perform(get("/bundle")))
                .hasStatusOk()
                .hasContentType(MediaType.APPLICATION_JSON)
                .bodyJson()
                .hasPathSatisfying("$.books[0].title",
                        title -> assertThat(title).isEqualTo("Effective Java"));
    }


    @Test
    void boom() {
        assertThat(mockMvc.perform(get("/boom")))
                .hasStatus5xxServerError();
    }

}
