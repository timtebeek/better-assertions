package com.github.timtebeek.betterassertions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BundleController {

    @GetMapping("/bundle")
    Bundle bundle() {
        return new Bundle();
    }

    @GetMapping("/boom")
    Bundle boom() {
        throw new IllegalStateException("Boom");
    }
}
