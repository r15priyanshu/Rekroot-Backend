package com.anshuit.rekroot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    //Below 2 methods are for testing API Versioning using - MIME ( Content Negotiation ) Versioning Approach
    @GetMapping(value = "/test", version = "v1")
    public Map<String, String> test1() {
        return Map.of("message", "TestController : test1() Method : /api/test : v1");
    }

    @GetMapping(value = "/test", version = "v2")
    public Map<String, String> test2() {
        return Map.of("message", "TestController : test2() Method : /api/test : v2");
    }
}
