
# 🥗 Healthy Food API

# Introduction

This is a daily meal planning API that makes use of the [Spoonacular API](https://spoonacular.com/food-api)
to get a meal plan in JSON format, for a single day based on calories and dietary requirements.


## Approach

### Diagram

Developed a diagram as a starting point to define processes.

![](docs/HealthyFoodAPIdiagram.png)

Generated Spring Boot project called `Healthy Food API`

Used Spring  `Initializr`, metadata included: maven, Java 17

Dependencies used:
- Spring Web - web endpoint for clients - (rather than Spring reactive web)
- Validation - to simplify validation of parameters
- Java Actuator - Actuator is mainly used to expose operational information about the running application — health, metrics, info, dump, env, etc
-  [  http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)
-   [ http://localhost:8080/actuator/info](http://localhost:8080/actuator/info)
- Unit Test - JUnit5

In our Model/Controller app the following classes were implemented:
`Enum Diet class ` - Contains the list of possible diets
`MealPlan Class` -  It's the model class we use to query data
Meal Class` - it's the model class that defines a single meal
`HealthyFood Service Interface` - defines method getDailyMeals()
`HealthyFoodService Implementation class` - implements method getDailyMeals()
`

### Project Structure

The API structure has a `src`, a `test` and `main`.
This application is a Spring Boot application, that is part of the Spring Boot ecosystem.
It is a framework we can use to quickly start to build a web application using Java.

### How to use it:

To see this API in action you need run `HealthyFoodApplication` main class in the `healthyfood` package.
The annotation `@SpringBootApplication`  tells the Spring framework that this specific class is the main entry point.

In a browser, go to `localhost:8080/api/v1/mealplanner` and you will receive a set of 3 meal recipe links, and the detailed nutrients and calories for the whole day.

####  Filters:
We are keen to offer the highest level of prsonalization for this API, you can filter the recipes in your daily meal plan according to:
a specific amount of daily calories
**and/or**
a specific diet  using /diet=DIET endpoint
- GLUTENFREE
-  KETOGENIC
- VEGETARIAN
- LACTOVEGETARIAN
- OVOVEGETARIAN
- VEGAN
- PESCETARIAN
- PALEO
- PRIMAL
- LOWFODMAP
- WHOLE30

i.e.
[http://localhost:8080/api/v1/mealPlanner/1500](http://localhost:8080/api/v1/mealPlanner/1500)
[http://localhost:8080/api/v1/mealPlanner/diet=VEGETARIAN](http://localhost:8080/api/v1/mealPlanner/diet=VEGETARIAN)
[http://localhost:8080/api/v1/mealPlanner/diet=PALEO/2000](http://localhost:8080/api/v1/mealPlanner/diet=PALEO/2000)

It is also possible to specify any food or ingredients to `exclude` from the plan, just separate the list entries with a `,`.
Optionally it is possible to specify a max number of calories too.
i.e. http://localhost:8080/api/v1/mealPlanner/exclude=sugar,fruit,chicken,eggs,cheese/1100
http://localhost:8080/api/v1/mealPlanner/exclude=sugar,fruit,chicken,eggs,cheese

### Extensions

Deploy your API onto a cloud service, such as AWS.
Save favourite recipes in a local MySQL database