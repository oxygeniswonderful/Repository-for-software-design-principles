package com.company;

public class Circle{
    private double radius;
    private String name;

    public Circle(String name, double radius) {
        this.radius = radius;
        this.name = name;
    }

    public double calculate_square(){
        return this.radius * this.radius * Math.PI;
    }
    public String get_name(){
        return this.name;
    }
    public double get_radius(){
        return this.radius;
    }
}
