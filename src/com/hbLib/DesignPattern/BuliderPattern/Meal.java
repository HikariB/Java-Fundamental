package com.hbLib.DesignPattern.BuliderPattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> meal = new ArrayList<>();

    public void addItem(Item item) {
        meal.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : meal)
            cost += item.price();
        return cost;
    }

    public void showMeal() {
        for (Item item : meal) {
            System.out.print("Meal: " + item.name());
            System.out.print(" Price: " + item.price());
            System.out.println("package: " + item.packing().pack());
        }
    }

}
