package com.github.timtebeek.betterassertions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    void handle(){}
}
