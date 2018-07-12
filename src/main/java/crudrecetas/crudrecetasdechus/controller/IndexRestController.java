package crudrecetas.crudrecetasdechus.controller;

import crudrecetas.crudrecetasdechus.entity.Recipe;
import crudrecetas.crudrecetasdechus.service.RecipeIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexRestController {



    @Autowired
    @Qualifier("recipeIndexServiceImp")
    private RecipeIndexService recipeIndexService;

    @PostMapping("/randomRecipe")
    public Recipe randomRecipe(){
       return recipeIndexService.findRandomById();
    }

    @PostMapping("/categories/{categories}")
    public List<Recipe> findAllByCategories(@PathVariable String categories){
        return recipeIndexService.findAllByCategories(categories);
    }

    @PostMapping("/recipe/{id}")
    public Recipe findById(@PathVariable long id){
        return recipeIndexService.findById(id);
    }

}
