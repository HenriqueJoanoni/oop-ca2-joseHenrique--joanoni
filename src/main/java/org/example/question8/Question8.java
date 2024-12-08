package org.example.question8;

import java.util.*;

/**
 * Name:Tanatswa Ben Musemburi
 * Class Group:SD2A
 * Question 8 – Multi-Company Stock Shares Tax Calculation (Queue) [10]
 * Extend Question 6 to a program that can handle shares of multiple companies. The user
 * enters commands buy symbol quantity price and sell symbol quantity. Hint: Keep a
 * Map<String, Queue<Block>> that manages a separate queue for each stock symbol.
 */
public class Question8  // Multi-company (Queue)
{
    /**
     * Will repeatedly ask the user to enter the commands in the format
     *    buy company qty price
     *    or
     *    sell company qty price
     *    or
     *    quit
     */
    public static void main(String[] args) {
        Map<String, Queue<Block>> stocks = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.print(" 1. Enter 'buy' to buy stocks\n" +
                    " 2. Enter 'sell' to sell stocks\n" +
                    " 3. Enter 'quit' to quit\n");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                System.out.print("Enter company name: ");
                String company = in.next();
                System.out.print("Enter the quantity : ");
                int qty = in.nextInt();
                System.out.print("Enter the price: ");
                double price = in.nextDouble();
                // Code to buy shares here
                if (!stocks.containsKey(company)) {
                    stocks.put(company, new LinkedList<>());
                }
                stocks.get(company).add(new Block(qty, price));
                System.out.println("Bought " + qty + " shares of " + company + " at €" + price + " each.");

                // test
//                while(!stocks.get(company).isEmpty())
//                {
//                    System.out.print(stocks.get(company).poll() + " ");
//                }
            } else if (command.equals("sell")) {
                System.out.print("Enter company name: ");
                String company = in.next();
                System.out.print("Enter the quantity : ");
                int qty = in.nextInt();
                System.out.print("Enter the price: ");
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here
//
//                if (!stocks.containsKey(company)) {
//                    System.out.println("Stock " + company + " does not exist.");
//                }
//                else {
//                    int remaining = stocks.get(company).peek().quantity;
//                    if (remaining < qty) {
//                        System.out.println("unable to sell " + qty + " shares from " + company + "due to insufficient stock.");
//                    }
//                    else {
//                        qty -= remaining;
//                        price = price * qty;
//                        ;
//                    }
//                }
                if (stocks.containsKey(company)) {
                    Queue<Block> queue = stocks.get(company);
                    int remainingQty = qty;
                    double totalProfit = 0;

                    while (remainingQty > 0 && !queue.isEmpty()) {
                        Block block = queue.peek();
                        if (block.quantity <= remainingQty) {
                            totalProfit += block.quantity * (price - block.price);
                            remainingQty -= block.quantity;
                            queue.poll();
                        } else {
                            totalProfit += remainingQty * (price - block.price);
                            block.quantity -= remainingQty;
                            remainingQty = 0;
                        }
                    }

                    if (remainingQty > 0) {
                        System.out.println("Not enough quantity to sell");
                    } else {
                        System.out.println("Sold " + qty + " shares of " + company + "for a profit of €" + totalProfit);
                    }
                } else {
                    System.out.println("No shares available for" + company);
                }
            } else {
                System.out.println("Invalid command");
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}
