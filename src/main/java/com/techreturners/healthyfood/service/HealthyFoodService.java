package com.techreturners.healthyfood.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.MealPlan;

import java.util.List;

public interface HealthyFoodService {

    List<Meal> getDailyMeals(MealPlan meal) throws JsonProcessingException;
    void getDailyMealsRecipes();
}
