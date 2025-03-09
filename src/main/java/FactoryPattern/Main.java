package FactoryPattern;

import FactoryPattern.shape.IShape;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String type = "CIRCLE";
        IShape shape = ShapeFactory.getShape(type);
        shape.draw();
    }
}
