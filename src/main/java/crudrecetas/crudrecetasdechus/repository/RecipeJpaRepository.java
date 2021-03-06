package crudrecetas.crudrecetasdechus.repository;

import crudrecetas.crudrecetasdechus.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface RecipeJpaRepository extends JpaRepository<Recipe,Serializable>{
    Recipe findByName(String name);
    Recipe findById(long id);
    Recipe save(Recipe recipe);
    void deleteByName(String name);
    void deleteById(long id);
    List<Recipe> findAll();
    List<Recipe> findAllByCategories(String categories);
}
