package com.techreturners.healthyfood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {

    Long id;

    String title;

    int readyInMinutes;

    int servings;

    String sourceUrl;
}
