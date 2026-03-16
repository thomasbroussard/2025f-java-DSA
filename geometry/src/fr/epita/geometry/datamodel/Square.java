package fr.epita.geometry.datamodel;

public class Square implements Shape {

    private Double side;

    public Square(int i) {
        this.side = Double.valueOf(i);
    }

    public Double getPerimeter(){
        return side * 4;
    }

    public Double getArea(){
        return side * side;
    }


}
