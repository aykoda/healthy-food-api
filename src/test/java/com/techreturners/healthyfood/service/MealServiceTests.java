package com.techreturners.healthyfood.service;

import com.techreturners.healthyfood.repository.HealthyFoodRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MealServiceTests {

    @Mock
    private HealthyFoodRepository mockHealthyFoodRepository;

    @InjectMocks
    private HealthyFoodServiceImpl bookManagerServiceImpl;



}
