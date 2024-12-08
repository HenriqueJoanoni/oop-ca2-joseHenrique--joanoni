package org.example.question2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Name:Tanatswa Ben Musemburi
 * Class Group:SD2A
 * <p>
 * Question 2 – Car Parking (Stack)
 * A homeowner rents out parking spaces in a driveway during special events. The driveway is
 * a “last-in, first-out” LIFO stack. Of course, when a car owner retrieves a vehicle that wasn’t
 * the last one in, the cars blocking it must be temporarily move to the street so that the
 * requested vehicle can leave. Write a program that models this behaviour, using one stack for
 * the driveway and one stack for the street. Use integer values as license plate numbers (e.g.
 * 1,2,3,4…).
 * User Interface: The user enters positive numbers to add a car (1,2,3…), negative numbers
 * remove a specific car( so, “-2” means to remove car number 2), and zero stops the
 * simulation. Print out the current state of the stack after each operation is complete.
 * So, entering “1” means – add car number 1 to the driveway, entering “-2” means - retrieve
 * car number 2 from the driveway
 */
public class Question2  // Car Parking - Stack
{
    public static void runSimulation() {
        Deque<Integer> driveway = new ArrayDeque<>();
        Deque<Integer> street = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter positive numbers to add cars, negative numbers to remove cars, and 0 to stop:");
        int input = scanner.nextInt();
        while (input != 0) {

            if (input > 0) {
                // Add a car to the driveway
                driveway.push(input);
                System.out.println("Added car " + input + " to the driveway.");
            } else {
                // Remove a car from the driveway
                int carToRetrieve = (input) * -1;

                if (driveway.isEmpty()) {
                    System.out.println("The driveway is empty. No car to retrieve.");
                }

                boolean carFound = false;

                // Temporarily move cars to the street to retrieve the desired car
                while (!driveway.isEmpty()) {
                    int topCar = driveway.pop();
                    if (topCar == carToRetrieve) {
                        System.out.println("Car " + carToRetrieve + " has been retrieved.");
                        carFound = true;
                    } else {
                        street.push(topCar);
                    }
                }

                // Move cars back from the street to the driveway
                while (!street.isEmpty()) {
                    driveway.push(street.pop());
                }

                if (!carFound) {
                    System.out.println("Car " + carToRetrieve + " is not in the driveway.");
                }
            }

            // Print the current state of the driveway
            System.out.println("Current state of the driveway: " + driveway);

            System.out.println("Enter positive numbers to add cars, negative numbers to remove cars, and 0 to stop:");
            input = scanner.nextInt();
        }

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
