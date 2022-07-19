package com.example.demookta.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {

    @GetMapping("/greetings")
    public String greeting() {
        return "Response coming from demo API";
    }

    @GetMapping("/whoami")
    public Object whoami(Authentication authentication) {
        if (isNull(authentication)) {
            return "Security is disabled";
        }
        return authentication.getCredentials();
    }
}
