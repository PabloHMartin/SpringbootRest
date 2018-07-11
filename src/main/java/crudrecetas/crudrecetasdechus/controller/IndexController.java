package crudrecetas.crudrecetasdechus.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    private final String INDEX_WEB_VIEW = "crudindex";

    @GetMapping("/")
    public String index(){
        return INDEX_WEB_VIEW;
    }

}
