package fr.epita.geometry.datamodel;

public class Circle implements Shape {

    private double radius;

    public Circle(int i) {
        this.radius = i;
    }

    public Double getPerimeter(){
        return this.radius * Math.PI * 2;
    }

    public Double getArea(){
        return this.radius * this.radius * Math.PI * 2;
    }



}
