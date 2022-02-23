package com.techreturners.healthyfood.controller;

import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.service.HealthyFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class HealthyFoodController {

    @Autowired
    HealthyFoodService bookManagerService;

    @GetMapping
    public ResponseEntity<List<Meal>> getAllBooks() {
        List<Meal> meals = bookManagerService.getAllMeals();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @GetMapping({"/{bookId}"})
    public ResponseEntity<Meal> getBookById(@PathVariable Long bookId) {
        return new ResponseEntity<>(bookManagerService.getMealById(bookId), HttpStatus.OK);
    }
    @DeleteMapping({"/{bookId}"})
    public ResponseEntity deleteBooks(@PathVariable Long bookId) {
        bookManagerService.deleteMealById(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Meal> addBook(@RequestBody Meal meal) {
        Meal newMeal = bookManagerService.insertMeal(meal);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("book", "/api/v1/book/" + newMeal.getId().toString());
        return new ResponseEntity<>(newMeal, httpHeaders, HttpStatus.CREATED);
    }



}
