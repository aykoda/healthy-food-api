package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.model.MealPlan;
import com.techreturners.healthyfood.model.ApiConfig;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;


@Service
public class ApiConfigServiceImpl implements ApiConfigService{

    @Value("${api_key}")
    private String apiKey;

    @Override
    public LinkedHashMap getJsonResponse(ApiConfig api){

        RestTemplate restTemplate = new RestTemplate();

        //System.out.println("----API global key-- "+apiKey);
        //System.out.println("----3. API key URL-- "+api.getUrl());

        ResponseEntity<Object> response =restTemplate.exchange(api.getUrl(), api.getHttp(), api.getEntity(), Object.class);

        //System.out.println("----response-- "+response);
        LinkedHashMap mealsMap = (LinkedHashMap) response.getBody();

        //System.out.println("----LinkedHashMap-- "+mealsMap);

        return mealsMap ;
    }


    @Override
    public ApiConfig getMealPlanParameterBuider(MealPlan meal) {
        ApiConfig apiConfig = new ApiConfig();

        StringBuilder stringBuilder = new StringBuilder(apiConfig.getUrlMealplanner());

        //System.out.println("----1 URL base-- "+apiConfig.getUrlMealplanner());

        if (meal != null) {

            if (meal.getDiet() != null)
                stringBuilder.append("&diet=").append(meal.getDiet());
            if (meal.getTargetCalories() != null)
                stringBuilder.append("&targetCalories=").append(meal.getTargetCalories());

            if (meal.getExclusions() != null && meal.getExclusions().size() > 0) {
                stringBuilder.append("&exclude=").append(meal.getExclusions().get(0));
                for (int i = 1; i < meal.getExclusions().size() - 1; i++) {
                    stringBuilder.append("").append(meal.getExclusions().get(i));
                }
            }
            apiConfig.setUrlMealplanner(stringBuilder.toString());

        }

        stringBuilder.append("&apiKey=").append(apiKey);
        apiConfig.setUrl(stringBuilder.toString());

        //System.out.println("----2. URL by parameters-- "+apiConfig.getUrlMealplanner());

        return apiConfig;
    }
}
