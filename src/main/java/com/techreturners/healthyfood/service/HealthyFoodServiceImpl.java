package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.model.ApiConfig;
import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.MealPlan;
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

        apiConfig = apiConfigService.getMealPlanParameterBuilder(meal);

        List<Meal> meals = new ArrayList<>(apiConfigService.getJsonResponse(apiConfig).values());

        return meals;
    }

}
