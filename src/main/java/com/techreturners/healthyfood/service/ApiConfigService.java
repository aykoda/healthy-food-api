package com.techreturners.healthyfood.service;


import com.techreturners.healthyfood.model.ApiConfig;
import com.techreturners.healthyfood.model.MealPlan;

import java.util.LinkedHashMap;


public interface ApiConfigService {

    LinkedHashMap getJsonResponse(ApiConfig apiConfig);
    ApiConfig getMealPlanParameterBuider(MealPlan meal);
}
