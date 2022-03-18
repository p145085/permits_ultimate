package com.example.permits_ultimate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String helloWorld(){
        return "greeting";
    }

    @RequestMapping(value = "/permits", method = RequestMethod.GET)
    public String permitList(){return "permits";}

    @GetMapping("/permits/add")
    public String showPermitForm(){
        return "permitForm";
    }
}
