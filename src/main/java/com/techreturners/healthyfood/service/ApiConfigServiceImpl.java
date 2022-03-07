package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.model.ApiConfig;
import com.techreturners.healthyfood.model.MealPlan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

@Service
public class ApiConfigServiceImpl implements ApiConfigService {

    @Value("${api_key}")
    private String apiKey;
    @Value("${urlMealRecipe}")
    private String urlMealRecipe;
    @Value("${urlMealPlanner}")
    private String urlMealPlanner;

    @Override
    public LinkedHashMap getJsonResponse(ApiConfig api) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> response = restTemplate.exchange(api.getUrl(), api.getHttp(), api.getEntity(), Object.class);
        LinkedHashMap mealsMap = (LinkedHashMap) response.getBody();

        return mealsMap;
    }

    @Override
    public ApiConfig getMealPlanParameterBuilder(MealPlan meal) {
        ApiConfig apiConfig = new ApiConfig();

        StringBuilder stringBuilder = new StringBuilder(urlMealPlanner);


        if (meal != null) {
            if (meal.getDiet() != null)
                stringBuilder.append("&diet=").append(meal.getDiet());

            if (meal.getTargetCalories() != null)
                stringBuilder.append("&targetCalories=").append(meal.getTargetCalories());

            if (meal.getExclusions() != null && meal.getExclusions().size() > 0) {
                stringBuilder.append("&exclude=").append(meal.getExclusions().get(0));

                for (int i = 1; i < meal.getExclusions().size(); i++) {
                    stringBuilder.append(",").append(meal.getExclusions().get(i));
                }
            }
            apiConfig.setUrlMealPlanner(stringBuilder.toString());
        }

        stringBuilder.append("&apiKey=").append(apiKey);
        apiConfig.setUrl(stringBuilder.toString());

        return apiConfig;
    }
}
