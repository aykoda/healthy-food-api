package com.techreturners.healthyfood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {
/*
*  "id": 885005,
            "imageType": "jpg",
            "title": "No-Bake Lemon Tarts (Gluten Free, Paleo + Vegan)",
            "readyInMinutes": 20,
            "servings": 3,
            "sourceUrl": "http://www.bakerita.com/no-bake-lemon-tarts-gluten-free-paleo-vegan/"*/
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

   // @Column
  //  MealType mealType;

    @Column
    String title;

   // @Column
   // String  ingredients;

   // @Column
    // int calories;

   // @Enumerated
   // Diet diet;

    int readyInMinutes;

    int servings;

    String sourceUrl;
}
