package crudrecetas.crudrecetasdechus.service;

import crudrecetas.crudrecetasdechus.entity.Recipe;

import java.util.List;

public interface RecipeIndexService {
    List<Recipe> findAllByCategories(String categories);
    Recipe findById(long id);
    Recipe findRandomById();
}
