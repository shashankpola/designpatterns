package com.epam.DesignPatterns.creational;

import java.util.HashMap;
import java.util.Map;

abstract class Color implements Cloneable{
    protected String color;
    abstract void addColor();
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}

class blue extends Color{
    public blue(){
        this.color="blue";
    }
    @Override
    void addColor() {
        System.out.println("Blue  added");
    }
}

class red extends Color{
    public red(){
        this.color="red";
    }
    @Override
    void addColor() {
        System.out.println("Red  added");
    }
}

class ColorStore{
    private static Map<String,Color> colorMap = new HashMap<String, Color>();
    static {
        colorMap.put("blue",new blue());
        colorMap.put("red",new red());
    }
    public static Color getColor(String colorName){
        return (Color) colorMap.get(colorName).clone();
    }
}

public class Prototype {
    public static void main(String args[]){
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("red").addColor();
        ColorStore.getColor("red").addColor();
        ColorStore.getColor("blue").addColor();
    }
}