//package com.techreturners.healthyfood.model;
//
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
//public class MealPlan {
//
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
//}
