package crudrecetas.crudrecetasdechus.service;

import crudrecetas.crudrecetasdechus.entity.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> findAll();
    Recipe findByName(String name);
    void saveRecipe(Recipe recipe);
    void deleteByName(String name);
}
