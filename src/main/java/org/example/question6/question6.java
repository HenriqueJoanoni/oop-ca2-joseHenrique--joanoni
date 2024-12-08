package org.example.question6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name: Ikram Abbas
 * Class Group: SD2A
 */
public class question6 {

    public static Scanner keyboard = new Scanner(System.in);

    static Queue<String> land = new LinkedList<>();
    static Queue<String> takeoff = new LinkedList<>();

    public static void main(String[] args) {

        int choice = 0;
        while (choice != 4) {
            printMainMenu();
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice == 1) {
                land();
            } else if (choice == 2) {
                takeoff();
            } else if (choice == 3) {
                next();
            } else if (choice == 4) {
                System.out.println("Thank you! Bye ;)");
                break;
            } else {
                System.out.println("enter valid input !");
            }
        }
    }

    public static void printMainMenu() {
        System.out.println("============= question 6 =============");
        System.out.println("1. land ____.");
        System.out.println("2. takeoff ____.");
        System.out.println("3. next ____.");
        System.out.println("4. Exit.");
        System.out.println("=========== Please select an option: ===========");
    }

    public static void land() {
        System.out.print("Enter flight code to land: ");
        String flightCode = keyboard.nextLine();
        land.add(flightCode);
        System.out.println(flightCode + " added to landing queue.");
    }

    public static void takeoff() {
        System.out.print("Enter flight code to take off: ");
        String flightCode = keyboard.nextLine();
        takeoff.add(flightCode);
        System.out.println(flightCode + " added to takeoff queue.");
    }

    public static void next() {
        if (!land.isEmpty()) {

            String landingFlight = land.poll();
            System.out.println("Landing : " + landingFlight);
        } else if (!takeoff.isEmpty()) {
            String takeoffFlight = takeoff.poll();
            System.out.println("Takeoff :" + takeoffFlight);
        } else {

            System.out.println("No plane is waiting here .");
        }
    }
}
