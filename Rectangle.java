package com.company;

public class Rectangle {

    protected final String name;
    protected final double height;
    protected final double width;

    public Rectangle(String name, double height, double width) {
        //input name, height and width of Rectangle
        this.name = name;
        this.height = height;
        this.width = width;
    }
    public double calculate_square() {
        //Calculate square of rectangle
        return this.height * this.width;
    }
    public double get_height(){
        return this.height;
    }
    public double get_width(){
        return this.width;
    }
    public String get_name(){
        return this.name;
    }
}
