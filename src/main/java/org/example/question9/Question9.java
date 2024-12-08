package org.example.question9;

import java.util.Scanner;

/**
 * Name: Ikram Abbas
 * Class Group: SD2A
 */
public class Question9 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation:");
        equation = in.nextLine().trim();

        try {
            String postfix = ReversePolishCalculator.toPostfix(equation);
            System.out.println("Postfix Notation: " + postfix);

            int result = ReversePolishCalculator.evaluatePostfix(postfix);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error in processing the expression: " + e.getMessage());
        }
    }
}
