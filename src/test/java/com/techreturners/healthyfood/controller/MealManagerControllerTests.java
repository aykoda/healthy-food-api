package com.techreturners.healthyfood.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.healthyfood.model.Meal;
import com.techreturners.healthyfood.model.Diet;
import com.techreturners.healthyfood.model.MealPlan;
import com.techreturners.healthyfood.service.HealthyFoodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
    private static String baseUrl = "/api/v1/mealPlanner";

    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(healthyFoodController).build();
        mapper = new ObjectMapper();
    }

    /*"","/","/diet={diet}", "/{calories}","/exclude={ingredients}",
            "/diet={diet}/{calories}", "/{calories}/exclude={ingredients}", "/diet={diet}/exclude={ingredients}",
            "/diet={diet}/{calories}/exclude={ingredients}"
    *
    * */

   private static Stream<Arguments> parametersGenerator() {
      return Stream.of(
              Arguments.of(baseUrl,MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + "BadURL",MockMvcResultMatchers.status().isNotFound()),
              Arguments.of(baseUrl + "/2000",MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + "/exclude=egg",MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + "/2000/exclude=egg",MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + String.format("/%s",Diet.KETOGENIC), MockMvcResultMatchers.status().isBadRequest()),
              Arguments.of(baseUrl + String.format("/diet=%s",Diet.KETOGENIC), MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + String.format("/diet=%s/2000",Diet.KETOGENIC), MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + String.format("/diet=%s/exclude=egg",Diet.KETOGENIC), MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + String.format("/diet=%s/2000/exclude=egg",Diet.KETOGENIC), MockMvcResultMatchers.status().isOk())
      );
   }

   @ParameterizedTest
   @MethodSource("parametersGenerator")
     void getAResponse(String url, ResultMatcher result) throws Exception {
        MealPlan mealPlan =null;
        List<Meal> meals = new ArrayList<>();


        when(mockHealthyFoodServiceImpl.getDailyMeals(mealPlan)).thenReturn(meals);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get(url))
                .andExpect(result);
    }

    }

