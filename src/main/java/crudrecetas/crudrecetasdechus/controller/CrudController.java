package crudrecetas.crudrecetasdechus.controller;

import crudrecetas.crudrecetasdechus.entity.Recipe;
import crudrecetas.crudrecetasdechus.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class CrudController{

    @PostConstruct
    private void loadData(){
        Recipe recipe  = new Recipe("Croquetas","leche,huevos","Cocer la leche","tipicas,navidad","croquetas.jpg");
        Recipe recipe2  = new Recipe("Jamon al horno","leche,huevos","Cocer la leche","tipicas","");
        Recipe recipe3  = new Recipe("Feijao","alubias,huevos,otro","Cocer la leche","tipicas","");
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

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable long id){
        return recipeService.findById(id);
    }

    @PostMapping("/addRecipe")
    public void addRecipe(@RequestBody Recipe recipe){
        recipeService.saveRecipe(recipe);

    }

    @Transactional
    @PostMapping("/deleteRecipe/{id}")
    public @ResponseBody void deleteRecipe(@PathVariable String id){
          recipeService.deleteById(id);

    }

}
