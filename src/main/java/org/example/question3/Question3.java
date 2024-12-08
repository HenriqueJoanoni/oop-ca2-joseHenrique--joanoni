package org.example.question3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Name:Tanatswa Ben Musemburi
 * Class Group: SD2A
 * <p>
 * Question 3 – Nested HTML Tags (Stack)
 * Write a program that checks whether a sequence of HTML tags is properly nested. For each
 * opening tag, such as <p>, there must be a closing tag </p>. Tags such as <p>, <ul>,<li> may
 * have other tags nested inside, for example :
 * <p> <ul> <li> </li> </u> <br> </p>
 * The inner tags must be closed before the outer ones, in nested fashion. An exception is the
 * <br> tag that has no closing tag. Your program should process a file containing tags. One is
 * provided with the sample code, but you should expand this. For simplicity, assume that the
 * tags are separated by spaces, and that there is no text between the tags.
 */

public class Question3 {
    public Question3() throws FileNotFoundException {

    }   //Nested HTML (Stack)

    /* filename: name of the file to test. */
    public static boolean validate(String filename) throws FileNotFoundException {
        boolean valid = true;

        //Scanner to read the file
        Scanner tagsReader = new Scanner(new File(filename));

        //Stacks to be used
        Deque<String> temporaryclosingtags = new ArrayDeque<String>();
        Deque<String> closingtags = new ArrayDeque<String>();
        Deque<String> openingtags = new ArrayDeque<String>();

        //Strings:1 for holding file contents, another for the br tag
        String tag = "", selfclosingtag = "<br>";

        //loop to go through the whole file picking each string
        while (tagsReader.hasNextLine()) {
            tag = tagsReader.next();

            //logic to not include the self-closing tag
            if (!tag.equals(selfclosingtag)) {

                //using functions to differentiate between opening and closing tags and add them to their respective stacks
                if (CheckClosingTags(tag)) {
                    temporaryclosingtags.push(tag);
                } else if (CheckOpeningTags(tag)) {
                    openingtags.push(tag);
                }
            }
        }

        //adding tags from temporary stack so that the formation is reversed to allow easy comparison against the opening tag stack
        while (!temporaryclosingtags.isEmpty()) {
            String currentTag = temporaryclosingtags.pop();
            closingtags.push(currentTag);
        }

        //comparing the 2 stacks and validating using size
        if (openingtags.size() != closingtags.size()) {
            valid = false;
        }

        //comparing the 2 stacks and validating using tag difference
        else {
            while (!openingtags.isEmpty()) {
                String currentOpeningTag = openingtags.pop(), currentClosingTag = closingtags.pop();
                if (!currentOpeningTag.substring(1, 2).equals(currentClosingTag.substring(2, 3))) {
                    valid = false;
                }
            }
        }

        return valid;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;

     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }

    }

    //functions to check what type of tag it is
    private static boolean CheckOpeningTags(String tag) {
        Boolean openingtags = false;
        if (tag.matches("<[a-zA-Z]+>"))
            openingtags = true;
        return openingtags;
    }

    private static boolean CheckClosingTags(String tag) {
        Boolean openingtags = false;
        if (tag.matches("</[a-zA-Z]+>"))
            openingtags = true;
        return openingtags;
    }
}