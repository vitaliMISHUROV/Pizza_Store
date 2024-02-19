package com.example.pizza_store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

    private  String  name;
    private  String  size;
    private  int   numbers;

    private List<String> ingredients = new ArrayList<>();

    public Order() {
    }

    public Order(String name, String size, int numbers, List<String> ingredients) {
        this.name = name;
        this.size = size;
        this.numbers = numbers;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", numbers=" + numbers +
                ", ingredients=" + ingredients +
                '}';
    }
}
