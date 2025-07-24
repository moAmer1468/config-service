package org.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class TestController {

    @GetMapping("/test")
    public String hello() {
        return "This server is working very fine";
    }

}
