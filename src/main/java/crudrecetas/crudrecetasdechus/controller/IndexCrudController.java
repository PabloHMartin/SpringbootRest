package crudrecetas.crudrecetasdechus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCrudController {

    private final String CRUD_WEB_VIEW = "crudindex";

    @GetMapping("/crud")
    public String index(){
            return CRUD_WEB_VIEW;
    }

}
