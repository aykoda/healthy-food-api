package com.techreturners.healthyfood.repository;

import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.MealType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MealRepositoryTests {

    @Autowired
    private HealthyFoodRepository healthyFoodRepository;

    @Test
    public void testFindAllMealsReturnsMeals() {

        Meal meal = new Meal(1L, MealType.Breakfast,"Cornflakes","Ingredients",
                100,true, false, true, true, false);
        healthyFoodRepository.save(meal);

        Iterable<Meal> meals = healthyFoodRepository.findAll();
        assertThat(meals).hasSize(1);

    }



}
