package com.techreturners.healthyfood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// This meal plan should not be in the database,
// it exists to allow the healthy food controller to return a meal plan
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealPlan {

    private Diet diet;
    private Long targetCalories;
    private List<String> exclusions;

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

    public List<String> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List exclusions) {
        this.exclusions = exclusions;
    }


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
