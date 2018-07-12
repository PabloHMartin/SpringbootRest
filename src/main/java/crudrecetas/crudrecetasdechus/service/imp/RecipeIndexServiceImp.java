package crudrecetas.crudrecetasdechus.service.imp;

import crudrecetas.crudrecetasdechus.entity.Recipe;
import crudrecetas.crudrecetasdechus.repository.RecipeJpaRepository;
import crudrecetas.crudrecetasdechus.service.RecipeIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Qualifier("recipeIndexServiceImp")
public class RecipeIndexServiceImp implements RecipeIndexService{

    @Autowired
    @Qualifier("recipeJpaRepository")
    private RecipeJpaRepository recipeJpaRepository;


    @Override
    public List<Recipe> findAllByCategories(String categories) {
        return recipeJpaRepository.findAllByCategories(categories);
    }


    @Override
    public Recipe findById(long id) {
        return recipeJpaRepository.findById(id);
    }

    @Override
    public Recipe findRandomById() {
        Random random = new Random();
        int minimum = 1;
        return recipeJpaRepository.findById(random.nextInt(recipeJpaRepository.findAll().size())+minimum);
    }

}
