# Healthy Food API
This is a daily meal planning API that makes use of the [Spoonacular API](https://spoonacular.com/food-api) 
to get a meal plan for a single day based on calories and dietary requirements.

# Solution

# Introduction

The API structure has a `src`, a `test` and `main` directories with the java files we need. 
This application is a Spring Boot application, that is part of the Spring Boot ecosystem. 
It is a framework we can use to quickly start to build a web application using Java.

To run this API you need to watch out for the `@SpringBootApplication` annotation which 
tells the Spring framework that this specific class is the main entry point. 
The annotation is in the `HealthyFoodApplication` main class in the `healthyfood` 
package. Run the application.

In a browser, go to `localhost:8080/api/v1/mealplanner` and you can see the API:







