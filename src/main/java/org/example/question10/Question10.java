package org.example.question10;

import org.example.DIRECTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Name: Ikram Abbas
 * Class Group: SD2A
 */
public class Question10 {

    public static void main(String[] args) {
        int[][] maze1 = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0}
        };

        Position start = new Position(0, 0);
        Position exit = new Position(4, 4);

        display(maze1);

        Question10 solver = new Question10();
        List<Position> path = solver.solve(maze1, start, exit);

        if (path != null) {
            System.out.print("Path found: ");
            for (Position p : path) {
                System.out.print("(" + p.row + ", " + p.column + ") ");
            }
        } else {
            System.out.println("No path found.");
        }
    }

    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    private boolean isValidMove(int[][] maze, boolean[][] visited, int row, int column) {
        return (row >= 0 && row < maze.length &&
                column >= 0 && column < maze[0].length &&
                maze[row][column] == 0 && !visited[row][column]);
    }

    public List<Position> solve(int[][] maze, Position start, Position exit) {
        Stack<Position> stack = new Stack<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        List<Position> path = new ArrayList<>();

        stack.push(start);

        while (!stack.isEmpty()) {

            Position current = stack.pop();
            int row = current.row;
            int column = current.column;

            if (row == exit.row && column == exit.column) {
                path.add(current);
                return path;
            }

            if (!visited[row][column]) {
                visited[row][column] = true;
                path.add(current);

                for (DIRECTION direction : DIRECTION.values()) {
                    int nextRow = row + (direction == DIRECTION.NORTH ? -1 : direction == DIRECTION.SOUTH ? 1 : 0);
                    int nextColumn = column + (direction == DIRECTION.EAST ? 1 : direction == DIRECTION.WEST ? -1 : 0);

                    if (isValidMove(maze, visited, nextRow, nextColumn)) {
                        stack.push(new Position(nextRow, nextColumn));
                    }
                }
            }
        }

        return null;
    }
}
