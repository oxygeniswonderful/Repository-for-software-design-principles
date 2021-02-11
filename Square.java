package com.company;

public class Square extends Rectangle {

    private String name;
    private  double height;

    public Square(String name, double height){
        super(name, height, height);
    }

}
