package org.example.question4;

public class Cell {
    private int row, column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Cell() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
