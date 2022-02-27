package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.MealPlan;

import java.util.List;

public interface HealthyFoodService {

    List<Meal> getDailyMeals();
    List<Meal> getDailyMeals(MealPlan meal);

}
