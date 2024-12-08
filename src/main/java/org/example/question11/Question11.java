package org.example.question11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Name: Ikram Abbas | Jose Henrique
 * Class Group: SD2A
 */
public class Question11 {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "CitiesAndDistances.txt";  // Replace with your actual filename
        List<String> lines = ReadFile.citiesDistances(filename);

        String startingCity = lines.get(0).split(" ")[0];
        Map<String, TreeSet<DistanceTo>> cityNetw = new HashMap<>();

        for (String line : lines) {
            String[] parts = line.split(" ");
            String city1 = parts[0];
            String city2 = parts[1];
            int distance = Integer.parseInt(parts[2]);

            addConnection(cityNetw, city1, city2, distance);
            addConnection(cityNetw, city2, city1, distance);
        }

        /** Dijkstra's algorithm */
        PriorityQueue<DistanceTo> queue = new PriorityQueue<>();
        queue.add(new DistanceTo(startingCity, 0));
        Map<String, Integer> shortestKnownDistance = new HashMap<>();

        while (!queue.isEmpty()) {
            DistanceTo current = queue.poll();
            String target = current.getTarget();
            int distance = current.getDistance();

            if (!shortestKnownDistance.containsKey(target)) {
                shortestKnownDistance.put(target, distance);

                if (cityNetw.containsKey(target)) {
                    for (DistanceTo neighbor : cityNetw.get(target)) {
                        if (!shortestKnownDistance.containsKey(neighbor.getTarget())) {
                            queue.add(new DistanceTo(neighbor.getTarget(), distance + neighbor.getDistance()));
                        }
                    }
                }
            }
        }

        System.out.println("Shortest distances from " + startingCity + ":");
        for (Map.Entry<String, Integer> entry : shortestKnownDistance.entrySet()) {
            String city = entry.getKey();
            int distance = entry.getValue();
            System.out.printf("%s -> %d\n", city, distance);
        }
    }

    private static void addConnection(Map<String, TreeSet<DistanceTo>> cityNetw, String city1, String city2, int distance) {
        cityNetw.putIfAbsent(city1, new TreeSet<>());
        cityNetw.get(city1).add(new DistanceTo(city2, distance));
    }

    static class ReadFile {
        public static List<String> citiesDistances(String filename) throws FileNotFoundException {
            File inputFile = new File(filename);
            List<String> lines = new ArrayList<>();
            try (Scanner sc = new Scanner(inputFile)) {
                while (sc.hasNextLine()) {
                    lines.add(sc.nextLine().trim());
                }
            }
            return lines;
        }
    }
}
