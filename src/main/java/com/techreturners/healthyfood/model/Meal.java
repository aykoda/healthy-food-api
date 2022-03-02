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
