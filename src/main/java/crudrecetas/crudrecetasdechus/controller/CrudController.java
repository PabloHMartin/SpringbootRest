package crudrecetas.crudrecetasdechus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrudController {

    private final String CRUD_WEB_VIEW = "crudindex";

    @RequestMapping("/crud")
    public String index(){
        return CRUD_WEB_VIEW;
    }
}
