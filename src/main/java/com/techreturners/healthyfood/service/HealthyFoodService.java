package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.model.Meal;

import java.util.List;

public interface HealthyFoodService {

    List<Meal> getAllMeals();
    Meal insertMeal(Meal meal);
    Meal getMealById(Long id);

    void deleteMealById(Long id);
}
