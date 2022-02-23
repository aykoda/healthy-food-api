package com.techreturners.healthyfood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    @Column
    MealType mealType;

    @Column
    String dish;

    @Column
    String  ingredients;

    @Column
    Integer calories;

    @Column
    Boolean isVegan;

    @Column
    Boolean isVegetarian;

    @Column
    Boolean isGlutenFree;

    @Column
    Boolean isDairyFree;

    @Column
    Boolean isPaleo;
}
