package com.techreturners.healthyfood.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
    @RequestMapping(value = { "","/","/diet={diet}", "/{calories}","/exclude={ingredients}",
            "/diet={diet}/{calories}", "/{calories}/exclude={ingredients}", "/diet={diet}/exclude={ingredients}",
            "/diet={diet}/{calories}/exclude={ingredients}"
    })
    public ResponseEntity getDailyMeals( @PathVariable(required = false) Diet diet,@PathVariable(required = false) Long calories, @PathVariable(required = false) List<String> ingredients)
            throws JsonProcessingException {
        List<Meal> meals = null;
        MealPlan inputMealPlan = new MealPlan();

        inputMealPlan.setDiet(diet);
        inputMealPlan.setTargetCalories(calories);
        inputMealPlan.setExclusions(ingredients);

        meals = healthyDailyMealService.getDailyMeals(inputMealPlan);


        //ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter().withRootValueSeparator("\n");
        //String json = ow.writeValueAsString((Object) meals);

        return new ResponseEntity<>(meals, HttpStatus.OK);
    }
}