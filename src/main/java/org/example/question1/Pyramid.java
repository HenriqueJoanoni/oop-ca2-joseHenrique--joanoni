package org.example.question1;

public class Pyramid implements IMeasurableContainer {
    private double length, sideLength, weight;

    /** Constructor */
    public Pyramid(double length, double sideLength, double weight) {
        this.length = length;
        this.sideLength = sideLength;
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
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
        return length * length * length;
    }
}
