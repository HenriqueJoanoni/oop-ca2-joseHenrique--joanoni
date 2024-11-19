package org.example.question1;

public class Cylinder implements IMeasurableContainer {
    private double height, diameter, weight;

    /** Constructor */
    public Cylinder(double height, double diameter, double weight) {
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        double radius = diameter / 2;
        return height * diameter * diameter;
    }
}
