package org.example.question8;

public class Block {
    int quantity;
    double price;

    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Block{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
