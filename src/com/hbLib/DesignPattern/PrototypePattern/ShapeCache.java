package com.hbLib.DesignPattern.PrototypePattern;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> shapemap = new Hashtable<>();

    public static Shape getShape(String typeId) {
        Shape cacheShape = shapemap.get(typeId);
        return (Shape) cacheShape.clone();
    }

    public static void loadCache() {
        Shape circle = new Circle();
        circle.setId("1");
        shapemap.put(circle.getId(), circle);

        Shape square = new Square();
        square.setId("2");
        shapemap.put(square.getId(), square);

        Shape rec = new Rectangle();
        rec.setId("3");
        shapemap.put(rec.getId(), rec);
    }

    public static void main(String[] args) {

        ShapeCache.loadCache();

        Shape cloneShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + cloneShape.getType());

        Shape cloneShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + cloneShape2.getType());

        Shape cloneShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + cloneShape3.getType());

    }
}
