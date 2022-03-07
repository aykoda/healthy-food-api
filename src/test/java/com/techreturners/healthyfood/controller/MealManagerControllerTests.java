package com.techreturners.healthyfood.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.healthyfood.model.Diet;
import com.techreturners.healthyfood.service.HealthyFoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.stream.Stream;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
 class MealManagerControllerTests {

    @Autowired
    private HealthyFoodService healthyFoodService;

    @InjectMocks
    private HealthyFoodController healthyFoodController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;
    private static String baseUrl = "/api/v1/mealPlanner";

    @BeforeEach
    public void setup() {
       // mockMvcController = MockMvcBuilders.standaloneSetup(healthyFoodController).build();
        mapper = new ObjectMapper();
    }

   @Test
    void should_test_ResponseJSON() throws Exception{

        mockMvcController.perform( get(baseUrl)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0][0].servings",lessThanOrEqualTo(100)));
    }

   @ParameterizedTest
   @MethodSource("parametersGenerator")
   void should_test_AllResponseEndpoits(String url, ResultMatcher result) throws Exception {

        mockMvcController.perform(
                        get(url)).andExpect(result);
    }

    private static Stream<Arguments> parametersGenerator() {
        return Stream.of(
              Arguments.of(baseUrl,MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + "BadURL",MockMvcResultMatchers.status().isNotFound()),
              Arguments.of(baseUrl + "/2000",MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + "/exclude=egg",MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + "/2000/exclude=egg",MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + String.format("/%s", Diet.KETOGENIC), MockMvcResultMatchers.status().isBadRequest()),
              Arguments.of(baseUrl + String.format("/diet=%s",Diet.KETOGENIC), MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + String.format("/diet=%s/2000",Diet.KETOGENIC), MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + String.format("/diet=%s/exclude=egg",Diet.KETOGENIC), MockMvcResultMatchers.status().isOk()),
              Arguments.of(baseUrl + String.format("/diet=%s/2000/exclude=egg",Diet.KETOGENIC), MockMvcResultMatchers.status().isOk()));
    }

    }

