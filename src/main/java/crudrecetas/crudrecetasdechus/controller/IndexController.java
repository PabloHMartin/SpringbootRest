package crudrecetas.crudrecetasdechus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final String INDEX_WEB_VIEW = "index.html";

    @GetMapping("/")
    public String index(){
        return INDEX_WEB_VIEW;
    }

}
