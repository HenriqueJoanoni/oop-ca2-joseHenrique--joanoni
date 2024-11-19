package org.example.question1;

import java.util.List;

/**
 * Your Name: Jose Henrique Pinto Joanoni
 * Class Group: SD2A
 */
public class Question1 {    // Interfaces
    public static void main(String[] args) {
        System.out.println("Question 1");

        /** INSTANTIATING CONTAINER MANAGER */
        ContainerManager mn = new ContainerManager();

        /** INSTANTIATING ELEMENT CLASSES */
        Box box = new Box(2, 3, 4, 10);
        Cylinder cyl = new Cylinder(5, 2, 8);
        Pyramid pyr = new Pyramid(3, 3, 5);

        /** ADDING ELEMENTS INTO CONTAINER */
        mn.add(box);
        mn.add(cyl);
        mn.add(pyr);

        /** DISPLAYING TOTAL WEIGHT AND RECTANGULAR VOLUME OF ALL ELEMENTS INTO THE CONTAINER */
        System.out.println("Total Weight: " + mn.totalWeight());
        System.out.println("Total Rectangular Volume: " + mn.totalRectangularVolume());


        /** LISTING ALL PROPERTIES FROM ELEMENTS INTO THE CONTAINER */
        List<IMeasurableContainer> ttlContainers = mn.getAllContainers();

        for (IMeasurableContainer container : ttlContainers) {
            if (container instanceof Box) {
                Box box1 = (Box) container;
                System.out.println("Box - Length: " + box1.getLength() +
                        ", width: " + box1.getWidth() +
                        ", Depth: " + box1.getDepth() +
                        ", Weight: " + box1.getWeight());
            } else if (container instanceof Cylinder) {
                Cylinder cyl1 = (Cylinder) container;
                System.out.println("Cylinder - Height: " + cyl1.getHeight() +
                        ", Diameter: " + cyl1.getDiameter() +
                        ", Weight: " + cyl1.getWeight());
            } else if (container instanceof Pyramid) {
                Pyramid pyr1 = (Pyramid) container;
                System.out.println("Pyramid - Length: " + pyr1.getLength() +
                        ", SideLength: " + pyr1.getSideLength() +
                        ", Weight: " + pyr1.getWeight());
            }
        }
    }
}


