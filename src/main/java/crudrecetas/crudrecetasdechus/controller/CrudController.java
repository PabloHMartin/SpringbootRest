package crudrecetas.crudrecetasdechus.controller;

import crudrecetas.crudrecetasdechus.entity.Recipe;
import crudrecetas.crudrecetasdechus.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import javax.annotation.PostConstruct;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:63342", maxAge = 3600)
@RestController
@RequestMapping("/crud")
public class CrudController{

    @PostConstruct
    private void loadData(){
        Recipe recipe  = new Recipe("Croquetas","leche,huevos","Cocer la leche","tipicas");
        Recipe recipe2  = new Recipe("Jamon al horno","leche,huevos","Cocer la leche","tipicas");
        Recipe recipe3  = new Recipe("Feijao","alubias,huevos","Cocer la leche","tipicas");
        recipeService.saveRecipe(recipe);
        recipeService.saveRecipe(recipe2);
        recipeService.saveRecipe(recipe3);
    }

    @Autowired
    @Qualifier("recipeServiceImp")
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes(){
        return recipeService.findAll();
    }

    @GetMapping("/recipes/{name}")
    public Recipe getRecipeById(@PathVariable String name){
        return recipeService.findByName(name);
    }

    @PostMapping("/addRecipe")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        recipeService.saveRecipe(recipe);
        return recipe;
    }

    //no funciona
    @DeleteMapping("/deleteRecipe/{name}")
    public void deleteRecipe(@PathVariable String name){
        recipeService.deleteByName(name);
    }
}
