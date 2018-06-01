package crudrecetas.crudrecetasdechus.controller;

import crudrecetas.crudrecetasdechus.entity.Recipe;
import crudrecetas.crudrecetasdechus.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @PostConstruct
    private void loadData(){
        Recipe recipe  = new Recipe("Croquetas","leche,huevos","Cocer la leche","tipicas");
        Recipe recipe2  = new Recipe("Jamon","leche,huevos","Cocer la leche","tipicas");
        recipeService.saveRecipe(recipe);
        recipeService.saveRecipe(recipe2);
    }


    @Autowired
    @Qualifier("recipeServiceImp")
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes(){
        return recipeService.findAll();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable long id){
        return recipeService.findById(id);
    }

    @PostMapping("/addRecipe")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        recipeService.saveRecipe(recipe);
        return recipe;
    }

    //no funciona
    @DeleteMapping("/deleteRecipe/{id}")
    public void deleteRecipe(@PathVariable long id){
        recipeService.deleteById(id);
    }
}
