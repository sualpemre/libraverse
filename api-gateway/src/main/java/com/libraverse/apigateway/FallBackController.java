package com.libraverse.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fb")
public class FallBackController {

    @GetMapping("/account")
    public String accountServiceFallBack() {
        return "Account Service is not available right now. Try again later!";
    }


    @GetMapping("/library")
    public String libraryServiceFallBack() {
        return "Library Service is not available right now. Try again later!";
    }
}