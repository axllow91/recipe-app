package com.mrn.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servicing;
    private String source;
    private String url;

    // this field has more than 255 char (the db creation)
    // so with @Lob annotation the jpa will know
    // that this object is larger than that
    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    /* Specifies that a persistent property or field should be persisted as a enumerated type.
      The Enumerated annotation may be used in conjunction with the Basic annotation,
      or in conjunction with the ElementCollection annotation when the element collection value is of basic type.
      If the enumerated type is not specified or the Enumerated annotation is not used, the EnumType value is assumed to be ORDINAL
    */
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
                joinColumns = @JoinColumn(name = "recipe_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    // add ingredient to recipe
    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

//    // remove ingredient
//    public Recipe removeIngredient(Ingredient ingredient) {
//        // set ingredient to recipe
//        ingredient.setRecipe(this);
//        this.ingredients.remove(ingredient);
//        return this;
//    }

}
