package crudrecetas.crudrecetasdechus.repository;

import crudrecetas.crudrecetasdechus.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RecipeJpaRepository extends JpaRepository<Recipe,Serializable>{
    Recipe findByName(String name);
    void deleteByName(String name);
}
