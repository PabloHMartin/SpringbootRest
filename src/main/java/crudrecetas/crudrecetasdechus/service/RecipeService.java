package crudrecetas.crudrecetasdechus.service;

import crudrecetas.crudrecetasdechus.entity.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> findAll();
    Recipe findById(long id);
    void saveRecipe(Recipe recipe);
    void deleteById(long id);
}
