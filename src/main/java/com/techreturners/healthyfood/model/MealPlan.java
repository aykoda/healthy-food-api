package com.techreturners.healthyfood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//// This meal plan should not be in the database,
//// it exists to allow the healthy food controller to return a meal plan
//// TODO
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealPlan {

private Diet diet;
private Long targetCalories;
private String[] exclusions;

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public Long getTargetCalories() {
        return targetCalories;
    }

    public void setTargetCalories(Long targetCalories) {
        this.targetCalories = targetCalories;
    }

    public String[] getExclusions() {
        return exclusions;
    }

    public void setExclusions(String[] exclusions) {
        this.exclusions = exclusions;
    }


// "diet=vegetarian"+
//                        "&targetCalories=2000+"+
//                        "&exclude=shellfish,olives,sugar,cheese,butter"+
//    @Id
//    @GeneratedValue
//    @Column(updatable = false, nullable = false)
//    Long id;
//
//    @Column
//    Meal breakfast;
//
//    @Column
//    Meal lunch;
//
//    @Column
//    Meal dinner;
}
