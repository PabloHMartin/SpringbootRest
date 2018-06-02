package crudrecetas.crudrecetasdechus.service.imp;

import crudrecetas.crudrecetasdechus.entity.Recipe;
import crudrecetas.crudrecetasdechus.repository.RecipeJpaRepository;
import crudrecetas.crudrecetasdechus.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("recipeServiceImp")
public class RecipeServiceImp implements RecipeService{

    @Autowired
    @Qualifier("recipeJpaRepository")
    private RecipeJpaRepository recipeJpaRepository;


    @Override
    public List<Recipe> findAll() {
        return recipeJpaRepository.findAll();
    }

    @Override
    public Recipe findByName(String name) {
        return recipeJpaRepository.findByName(name);
    }


    @Override
    public void saveRecipe(Recipe recipe) {
        recipeJpaRepository.save(recipe);
    }

    @Override
    public void deleteByName(String name) {
        recipeJpaRepository.deleteByName(name);
    }


}
