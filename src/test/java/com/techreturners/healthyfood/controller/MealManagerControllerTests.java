package com.techreturners.healthyfood.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.Diet;
import com.techreturners.healthyfood.service.HealthyFoodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
 class MealManagerControllerTests {

    @Mock
    private HealthyFoodServiceImpl mockHealthyFoodServiceImpl;

    @InjectMocks
    private HealthyFoodController healthyFoodController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(healthyFoodController).build();
        mapper = new ObjectMapper();
    }

    @Test
     void getAResponse() throws Exception {
        List<Meal> meals = new ArrayList<>();

        when(mockHealthyFoodServiceImpl.getDailyMeals()).thenReturn(meals);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/mealPlanner/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    }

