package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.repository.HealthyFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {

    @Autowired
    HealthyFoodRepository healthyFoodRepository;

    @Override
    public List<Meal> getDailyMeals() {
        List<Meal> meals = new ArrayList<>();
       // healthyFoodRepository.findAll().forEach(meals::add);
        meals.add(new Meal(1L,"fake title",30,6,"www.google.com"));
        meals.add(new Meal(2L,"fake title 2",40,2,"www.google.com/alalalalla"));
        return meals;
    }

}
