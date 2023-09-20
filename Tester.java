/*
 * Tester.java 
 * 
 * A program that you can use to make test calls to the methods that you 
 * write as part of your Wordle implementation. 
 */

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // sample test for the includes method
        System.out.println("\nTesting includes method...");
        boolean result = Wordle.includes("hello", 'e');
        System.out.println("includes(\"hello\", 'e') returns " + result);

        // Add additional tests below to ensure that your methods
        // work correctly.

     /*   includes("hello", 'e');
        includes("hello", 'l');
        includes("goodbye", 'x');
        isAlpha("Hello");
        isAlpha("Goodbye!");
        numOccur('l', "hello");
        numOccur('e', "hello");
        numOccur('x', "goodbye");
        numInSamePosn('p', "apple", "maple");
        numInSamePosn('a', "apple", "maple");
        numInSamePosn('a', "java", "mama");

        isValidGuess("hello");
        isValidGuess("hi");
        isValidGuess("what?");
        isValidGuess("abcde");

        processGuess("heart", "depth");
        processGuess("stain", "edict");
        processGuess("light", "edict");
        processGuess("merit", "edict");
        processGuess("edict", "edict");

*/

        console.close();
    }
}
