package crudrecetas.crudrecetasdechus.service;

import crudrecetas.crudrecetasdechus.entity.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> findAll();
    Recipe findById(String id);
    void saveRecipe(Recipe recipe);
    void deleteByName(String name);
    void deleteById(String id);
}
