package com.anshuit.rekroot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LegacyApiVersioningDemoTestController {
    //Below 2 methods are for testing API Versioning using - Path Versioning Approach
    @GetMapping("/v1/test2")
    public String test1() {
        return "LegacyApiVersioningDemoTestController : test1() Method : v1";
    }

    @GetMapping("/v2/test2")
    public String test2() {
        return "LegacyApiVersioningDemoTestController : test2() Method : v2";
    }

    //Below 2 methods are for testing API Versioning using - Request(Query) Parameter Versioning Approach
    @GetMapping(value = "/test2", params = {"version=v3"})
    public String test3() {
        return "LegacyApiVersioningDemoTestController : test3() Method : v3";
    }

    @GetMapping(value = "/test2", params = {"version=v4"})
    public String test4() {
        return "LegacyApiVersioningDemoTestController : test4() Method : v4";
    }

    //Below 2 methods are for testing API Versioning using - Header Versioning Approach
    @GetMapping(value = "/test2", headers = {"X-API-VERSION=5"})
    public String test5() {
        return "LegacyApiVersioningDemoTestController : test5() Method : v5";
    }

    @GetMapping(value = "/test2", headers = {"X-API-VERSION=6"})
    public String test6() {
        return "LegacyApiVersioningDemoTestController : test6() Method : v6";
    }

    //Below 2 methods are for testing API Versioning using - MIME ( Content Negotiation ) Versioning Approach
    @GetMapping(value = "/test2", produces = "application/vnd.com.anshuit.rekroot.v7+json")
    public String test7() {
        return "LegacyApiVersioningDemoTestController : test7() Method : v7";
    }

    @GetMapping(value = "/test2", produces = "application/vnd.com.anshuit.rekroot.v8+json")
    public String test8() {
        return "LegacyApiVersioningDemoTestController : test8() Method : v8";
    }
}
