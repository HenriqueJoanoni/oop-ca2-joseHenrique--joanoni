package org.example.question7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name: Jose Henrique Pinto Joanoni
 * Class Group: SD2a
 */
public class Question7  // Shares Tax Calculations (Queue)
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Block> queue = new LinkedList<>();

        String command = "";
        do {
            System.out.print(">");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                int qty = in.nextInt();
                double price = in.nextDouble();
                queue.add(new Block(qty, price));
                System.out.println("Buying " + qty + " shares at £" + price);

            } else if (command.equals("sell")) {
                int qty = in.nextInt();
                double price = in.nextDouble();
                double totalGain = 0;

                while (qty > 0 && !queue.isEmpty()) {
                    Block block = queue.peek();
                    int sellQty = Math.min(block.quantity, qty);
                    totalGain += sellQty * (price - block.price);
                    block.quantity -= sellQty;
                    qty -= sellQty;

                    if (block.quantity == 0) {
                        queue.poll();
                    }
                }

                if (qty > 0) {
                    System.out.println("Not enough shares to sell");
                } else {
                    System.out.printf("Total gain: £%.2f%n", totalGain);
                }
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}