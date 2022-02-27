package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.model.Meal;
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
        String url="https://api.spoonacular.com/mealplanner/generate?timeFrame=day";
        ResponseEntity<Object> response = restTemplate.exchange(
                "https://api.spoonacular.com/mealplanner/generate?"+
                        "diet=vegetarian"+
                        "&targetCalories=2000+"+
                        "&exclude=shellfish,olives,sugar,cheese,butter"+
                        "&apiKey="+ apiKey +
                         ""
                , HttpMethod.GET, entity,Object.class);
        LinkedHashMap mealsMap = (LinkedHashMap) response.getBody();
        List<Meal> meals = new ArrayList<Meal>(mealsMap.values());

        return meals;
    }

}
