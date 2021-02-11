package com.company;

public class Main {

    public static void main(String[] args) {
        String nameC = "O", nameS = "S", nameR = "R";
        Circle c1 = new Circle(nameC, 1d);
        Circle c2 = new Circle(nameC, 2d);
        Circle c3 = new Circle(nameC, 0);
        Circle c4 = new Circle(nameC, 3);

        System.out.println("Tests for Circle:");

        if(c1.calculate_square() == 3.141592653589793)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");

        if(c2.calculate_square() == 12.566370614359172)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");
        if(c3.calculate_square() == 0.0)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");
        if(c4.calculate_square() == 28.274333882308138)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");

        System.out.println("Tests for Square:");

        Square s1 = new Square(nameS, 1d);
        Square s2 = new Square(nameS, 0);
        Square s3 = new Square(nameS, 2.5d);
        Square s4 = new Square(nameS, 10.13);

        if(s1.calculate_square() == 1d)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");

        if(s2.calculate_square() == 0d)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");
        if(s3.calculate_square() == 6.25d)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");
        if(s4.calculate_square() == 102.61690000000002)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");

        System.out.println("Tests for Rectangle:");

        Rectangle r1 = new Rectangle(nameR, 0, 500000);
        Rectangle r2 = new Rectangle(nameR, 1d, 1d);
        Rectangle r3 = new Rectangle(nameR, 0.5d, 0.33d);
        Rectangle r4 = new Rectangle(nameR, 100d, 0.005d);

        if(r1.calculate_square() == 0d)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");

        if(r2.calculate_square() == 1d)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");
        if(r3.calculate_square() == 0.165d)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");
        if(r4.calculate_square() == 0.5d)
            System.out.println("TEST1 : OK");
        else
            System.out.println("TEST1 : FAILED");

    }
}
