package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.MealPlan;
import com.techreturners.healthyfood.repository.HealthyFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {
    @Value("${api_key}")
    private String apiKey;

    @Autowired
    HealthyFoodRepository healthyFoodRepository;
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Meal> getDailyMeals() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        String url = "https://api.spoonacular.com/mealplanner/generate?timeFrame=day&apiKey=" + apiKey;

        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        LinkedHashMap mealsMap = (LinkedHashMap) response.getBody();

        return new ArrayList<>(mealsMap.values());
    }

    @Override
    public List<Meal> getDailyMeals(MealPlan meal) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        String url = "https://api.spoonacular.com/mealplanner/generate?timeFrame=day";
        StringBuilder stringBuilder = new StringBuilder(url);
        if (meal.getDiet() != null)
            stringBuilder.append("&diet=").append(meal.getDiet());
        if (meal.getTargetCalories() != null)
            stringBuilder.append("&targetCalories=").append(meal.getTargetCalories());
        /*@TODO MANAGE ARRAY OF EXCLUSIONS*/
        if (meal.getExclusions() != null && meal.getExclusions().length > 0) {
            stringBuilder.append("&exclude=").append(meal.getExclusions()[0]);
            for (int i = 1; i < meal.getExclusions().length - 1; i++) {
                stringBuilder.append("").append(meal.getExclusions()[i]);
            }
        }
        stringBuilder.append("&apiKey=").append(apiKey);

        url = stringBuilder.toString();
        System.out.println(url);

        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        LinkedHashMap mealsMap = (LinkedHashMap) response.getBody();
        List<Meal> meals = new ArrayList<Meal>(mealsMap.values());

        return meals;
    }

}
