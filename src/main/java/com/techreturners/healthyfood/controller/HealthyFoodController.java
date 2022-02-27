package com.techreturners.healthyfood.controller;

import com.techreturners.healthyfood.model.Diet;
import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.service.HealthyFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mealPlanner")
public class HealthyFoodController {

    @Autowired
    HealthyFoodService healthyDailyMealService;

    @GetMapping
    public ResponseEntity getDailyMealsSpecificDiet(@RequestParam(required = false) Diet diet, Long calories) {
        List<Meal> meals = null;
        if(diet!=null)
          meals= healthyDailyMealService.getDailyMeals();

        return new ResponseEntity<>(meals, HttpStatus.OK);
    }
}
