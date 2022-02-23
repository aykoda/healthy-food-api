package com.techreturners.healthyfood.repository;

import com.techreturners.healthyfood.model.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthyFoodRepository extends CrudRepository<Meal, Long> {

}
