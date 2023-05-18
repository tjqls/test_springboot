package com.example.sss;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/sss")
    @ResponseBody
    public String sss(){
        return "hi";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }

}
