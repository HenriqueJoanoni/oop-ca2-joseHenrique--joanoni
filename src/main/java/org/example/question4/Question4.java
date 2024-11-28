package org.example.question4;

import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Jose Henrique Pinto Joanoni
 * Class Group: SD2a
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int[][] arr = floodFillStart();

        System.out.print("Enter starting row (0-9): ");
        int startRow = kb.nextInt();
        System.out.print("Enter starting column (0-9): ");
        int startCol = kb.nextInt();

        fill(startRow, startCol, arr);

        display(arr);
    }

    /*
        Creates a 2D array and populates it with zeros
    */
    public static int[][] floodFillStart() {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    /*
        Displays the 2D array
    */
    public static void display(int[][] arr) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    /*
        Performs the flood fill algorithm using a stack
    */
    public static void fill(int r, int c, int[][] arr) {
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(r, c));
        int fillNumber = 1;

        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            int row = current.getRow();
            int col = current.getColumn();

            if (row < 0 || row >= 10 || col < 0 || col >= 10 || arr[row][col] != 0) {
                continue;
            }

            arr[row][col] = fillNumber++;

            /** NORTH */
            stack.push(new Cell(row - 1, col));

            /** SOUTH */
            stack.push(new Cell(row + 1, col));

            /** WEST */
            stack.push(new Cell(row, col - 1));

            /** EAST */
            stack.push(new Cell(row, col + 1));
        }
    }
}
