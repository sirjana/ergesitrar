package cs.miu.edu.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home/index";
    }

    @GetMapping(value="/about")
    public String displayAboutPage(){
        return "home/about";
    }
}
