package com.techreturners.healthyfood.model;

public enum Diet {

    GLUTENFREE("Gluten Free"),
    KETOGENIC("Ketogenic"),
    VEGETARIAN("Vegetarian"),
    LACTOVEGETARIAN("Lacto-Vegetarian"),
    OVOVEGETARIAN("Ovo-Vegetarian"),
    VEGAN("Vegan"),
    PESCETARIAN("Pescetarian"),
    PALEO("Paleo"),
    PRIMAL("Primal"),
    LOWFODMAP("Low FODMAP"),
    WHOLE30("Whole30");

    private String name;

    Diet(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }



}
