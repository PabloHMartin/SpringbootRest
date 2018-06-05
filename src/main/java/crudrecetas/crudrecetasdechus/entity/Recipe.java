package crudrecetas.crudrecetasdechus.entity;

import javax.persistence.*;

@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name="ingredients")
    private String ingredients;
    @Column(name = "preparation")
    private String preparation;
    @Column(name = "categories")
    private String categories;
    @Column(name = "image")
    private String image;

    public Recipe() {
    }

    public Recipe(String name, String ingredients, String preparation, String categories, String image) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.categories = categories;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
