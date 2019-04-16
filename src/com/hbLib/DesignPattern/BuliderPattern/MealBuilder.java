package com.hbLib.DesignPattern.BuliderPattern;

public class MealBuilder {

    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareChickenMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareChickenMeal();
        System.out.println("First Meal is about Chicken:");
        meal.showMeal();
        System.out.println("It costs "+meal.getCost());

        meal = mealBuilder.prepareVegMeal();
        System.out.println("The second meal is about Veg");
        meal.showMeal();
        System.out.println("It costs "+meal.getCost());
    }

}
