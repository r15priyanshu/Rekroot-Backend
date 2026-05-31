package com.anshuit.rekroot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpringApiVersioningDemoTestController {
    //Below 2 methods are for testing API Versioning using - Path Versioning Approach
    @GetMapping(value = "/{v}/test", version = "v1")
    public String test1() {
        return "SpringApiVersioningDemoTestController : test1() Method : v1";
    }

    @GetMapping(value = "/{v}/test", version = "v2")
    public String test2() {
        return "SpringApiVersioningDemoTestController : test2() Method : v2";
    }

    //Below 2 methods are for testing API Versioning using - Request(Query) Parameter Versioning Approach
    @GetMapping(value = "/test", version = "v3")
    public String test3() {
        return "SpringApiVersioningDemoTestController : test3() Method : v3";
    }

    @GetMapping(value = "/test", version = "v4")
    public String test4() {
        return "SpringApiVersioningDemoTestController : test4() Method : v4";
    }

    //Below 2 methods are for testing API Versioning using - Header Versioning Approach
    @GetMapping(value = "/test", version = "v5")
    public String test5() {
        return "SpringApiVersioningDemoTestController : test5() Method : v5";
    }

    @GetMapping(value = "/test", version = "v6")
    public String test6() {
        return "SpringApiVersioningDemoTestController : test6() Method : v6";
    }

    //Below 2 methods are for testing API Versioning using - MIME ( Content Negotiation ) Versioning Approach
    @GetMapping(value = "/test", version = "v7")
    public String test7() {
        return "SpringApiVersioningDemoTestController : test7() Method : v7";
    }

    @GetMapping(value = "/test", version = "v8")
    public String test8() {
        return "SpringApiVersioningDemoTestController : test8() Method : v8";
    }
}
