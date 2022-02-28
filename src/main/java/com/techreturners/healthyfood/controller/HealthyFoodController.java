package com.techreturners.healthyfood.controller;

import com.techreturners.healthyfood.model.Diet;
import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.MealPlan;
import com.techreturners.healthyfood.service.HealthyFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/mealPlanner")
public class HealthyFoodController {

    @Autowired
    HealthyFoodService healthyDailyMealService;

    @GetMapping
    public ResponseEntity getDailyMeals() {
        List<Meal> meals = null;
        meals = healthyDailyMealService.getDailyMeals();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = {"/diet={diet}", "/{calories}", "/diet={diet}/{calories}"})
    public ResponseEntity getDailyMealsSpecificDiet(@PathVariable(required = false) Diet diet, @PathVariable(required = false) Long calories) {
        MealPlan inputMealPlan = new MealPlan();
        inputMealPlan.setDiet(diet);
        inputMealPlan.setTargetCalories(calories);
        List<Meal> meals = null;
        meals = healthyDailyMealService.getDailyMeals(inputMealPlan);

        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = {"/exclude={ingredients}", "/exclude={ingredients}/{calories}"})
    public ResponseEntity getDailyMealsCaloriesExclusions(@PathVariable(required = false) List<String> ingredients, @PathVariable(required = false) Long calories) {
        MealPlan inputMealPlan = new MealPlan();
        inputMealPlan.setExclusions(ingredients);
        inputMealPlan.setTargetCalories(calories);
        List<Meal> meals = null;
        meals = healthyDailyMealService.getDailyMeals(inputMealPlan);

        return new ResponseEntity<>(meals, HttpStatus.OK);
    }
}
