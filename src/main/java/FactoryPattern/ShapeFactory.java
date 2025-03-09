package FactoryPattern;

import FactoryPattern.shape.IShape;
import FactoryPattern.shape.Square;
import FactoryPattern.shape.Circle;

public class ShapeFactory {
    public static IShape getShape(String type){
        switch (type){
            case "CIRCLE":
                return new Circle();
            case "SQUARE":
                return new Square();
            default:
                throw new IllegalArgumentException("Shape not found");
        }
    }

}
