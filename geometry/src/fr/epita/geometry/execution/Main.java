package fr.epita.geometry.execution;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(3);
        double area = circle.getArea();
        System.out.println(area);

        if (area != 28.274333882308138){
            throw new RuntimeException("invalid result");
        }

        Square square = new Square(4);

        System.out.println(square.getArea());

        double v = square.getArea() + circle.getArea();
        List<Square> squareList = new Stack<>();

        squareList.add(square);
        squareList.add(new Square(5));
        squareList.add(new Square(6));

        List<Circle> circles = new ArrayList<>();
        circles.add(circle);



        List<Shape> shapes = new ArrayList<>();
        shapes.addAll(squareList);
        shapes.addAll(circles);

        double totalArea = 0;
        for (Shape s : shapes){
            if (s instanceof Square){

            }
            totalArea += s.getArea();
        }



    }

}
