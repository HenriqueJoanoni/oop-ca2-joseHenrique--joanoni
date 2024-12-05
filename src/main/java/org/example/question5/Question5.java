package org.example.question5;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * Name: Jose Henrique Pinto Joanoni
 * Class Group: SD2A
 */
public class Question5 { // Java Identifier Count (Map)

    private static final Pattern PATTERN = Pattern.compile("[A-Za-z_][A-Za-z0-9_]*");

    public static void readFile(String fileName) {
        Map<String, Integer> identifierCountMap = new TreeMap<>();
        Map<String, List<String>> identifierLinesMap = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                processLine(line, lineNumber, identifierCountMap, identifierLinesMap);
            }
            printResults(identifierCountMap, identifierLinesMap);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void processLine(
            String line,
            int lineNumber,
            Map<String,
            Integer> countMap,
            Map<String,
            List<String>> linesMap
    ) {

        Matcher matcher = PATTERN.matcher(line);

        /** SEARCH MATCHES */
        while (matcher.find()) {
            String identifier = matcher.group();

            /** UPDATES COUNT MAP */
            countMap.put(identifier, countMap.getOrDefault(identifier, 0) + 1);
            
            /** UPDATES LINE MAP */
            linesMap.putIfAbsent(identifier, new ArrayList<>());
            linesMap.get(identifier).add(lineNumber + ". " + line.trim());
        }
    }

    private static void printResults(Map<String, Integer> countMap, Map<String, List<String>> linesMap) {
        for (String identifier : countMap.keySet()) {
            System.out.println(identifier + " " + countMap.get(identifier));
            System.out.println(linesMap.get(identifier));
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/Question2.java";
        readFile(filePath);
    }
}
