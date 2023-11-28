package com.simplesession.simplesessiontest.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/health_check")
    public String healthCheck(){
        return "ok";
    }
}
