package kz.projectx.almatour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String indexPage(){return "index";}

    @GetMapping(value = "/sign-in")
    public String signIn(){
        return "sign-in";
    }

    @GetMapping(value = "/sign-up")
    public String signIp(){
        return "sign-up";
    }
}
