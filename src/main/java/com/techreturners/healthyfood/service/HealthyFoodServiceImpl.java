package com.techreturners.healthyfood.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.MealPlan;
import com.techreturners.healthyfood.model.ApiConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {

    private ApiConfig  apiConfig = new ApiConfig();

    @Autowired
    ApiConfigService  apiConfigService;

    @Override
    public void getDailyMealsRecipes() {

    }

    @Override
    public List<Meal> getDailyMeals(MealPlan meal)  {

        apiConfig = apiConfigService.getMealPlanParameterBuider(meal);

        List<Meal> meals = new ArrayList<>(apiConfigService.getJsonResponse(apiConfig).values());

        //meals.get(0).getId();


        return meals;

    }

}
