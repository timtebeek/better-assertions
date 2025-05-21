package com.github.timtebeek.betterassertions.mockmvc;

import com.github.timtebeek.betterassertions.BundleController;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;

class BundleControllerNewTest {

    private final MockMvcTester mockMvc = MockMvcTester.of(new BundleController());

    @Test
    void getBundle() {
        assertThat(mockMvc.get().uri("/bundle"))
                .hasStatusOk()
                .hasContentType(MediaType.APPLICATION_JSON)
                .bodyJson()
                .hasPathSatisfying("$.books[0].title",
                        title -> assertThat(title).isEqualTo("Effective Java"));
    }

}
