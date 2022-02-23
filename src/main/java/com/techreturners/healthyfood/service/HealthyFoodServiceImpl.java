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
    public List<Meal> getAllMeals() {
        List<Meal> meals = new ArrayList<>();
        healthyFoodRepository.findAll().forEach(meals::add);
        return meals;
    }

    @Override
    public Meal insertMeal(Meal meal) {
        return healthyFoodRepository.save(meal);
    }

    @Override
    public Meal getMealById(Long id) {
        return healthyFoodRepository.findById(id).get();
    }

    @Override
    public void deleteMealById(Long id){
        healthyFoodRepository.deleteById(id);
    }

}
