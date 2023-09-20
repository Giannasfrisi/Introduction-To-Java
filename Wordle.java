/*
 * Wordle.java 
 * 
 * An console-based implementation of a popular word-guessing game
 * 
 * starter code: Computer Science 112 staff (cs112-staff@cs.bu.edu)
 *
 * completed by: Gianna Sfrisi and Ellis Hamilton
 */

import java.util.*;

public class Wordle {
    // the name of a file containing a collection of English words, one word per line
    public static final String WORD_FILE = "words.txt";

    /*
     * printWelcome - prints the message that greets the user at the beginning of the game
     */  
    public static void printWelcome() {
        System.out.println();   
        System.out.println("Welcome to Wordle!");
        System.out.println("The mystery word is a 5-letter English word.");
        System.out.println("You have 6 chances to guess it.");
        System.out.println();
    }
    
    /*
     * initWordList - creates the WordList object that will be used to select
     * the mystery work. Takes the array of strings passed into main(),
     * since that array may contain a random seed specified by the user 
     * from the command line.
     */
    public static WordList initWordList(String[] args) {
        int seed = -1;
        if (args.length > 0) {
            seed = Integer.parseInt(args[0]);
        }

        return new WordList(WORD_FILE, seed);
    }

    /*
     * readGuess - reads a single guess from the user and returns it
     * inputs:
     *   guessNum - the number of the guess (1, 2, ..., 6) that is being read
     *   console - the Scanner object that will be used to get the user's inputs
     */
    public static String readGuess(int guessNum, Scanner console) {
        String guess;
        do {
            System.out.print("guess " + guessNum + ": ");
            guess = console.next();
        } while (! isValidGuess(guess));

        return guess.toLowerCase();
    }

    /**** ADD YOUR METHODS FOR TASK 1 HERE ****/
     public static boolean includes(String s, char c){
        int lenS = s.length();
        String letter = c + "";
        /*String letter = c.toString(); */

        for (int i = 0; i < lenS; i++){
            if (s.indexOf(letter) == i){
                return true;
            }  

            }
        return false;
        }

    public static boolean isAlpha(String s){
        int lenS = s.length();
        for (int i = 0; i < lenS; i++){
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) == false){
                return false;
            }
        }
        return true;
    }

    public static int numOccur(char c, String s){
        int lenS = s.length();
        int amount = 0; 
        for (int i = 0; i < lenS; i++){
            String letter = s.substring( i, i+1);
            String character = String.valueOf(c);
            if (letter.contains(character) == true ){
                amount = amount + 1;
            }
        }
        return amount; 
    }

    public static int numInSamePosn(char c, String s1, String s2){
        int lenS = s1.length();
        int amount = 0; 
        for (int i = 0; i < lenS; i ++){
            String letterS1 = s1.substring( i, i+1);
            String letterS2 = s2.substring( i, i+1);
            String character = String.valueOf(c);
            if (letterS1.equals(letterS2) == true && letterS1.equals(character)){
                amount = amount + 1;
        }
        }
        return amount;
    }

    /*
     * TASK 2: Implement this method
     * 
     * isValidGuess -  takes an arbitrary string guess and returns true
     * if it is a valid guess for Wordle, and false otherwise
     */
    public static boolean isValidGuess(String guess) {
        if (guess.length() != 5){
            System.out.println("Your guess must be 5 letters long.");
            return false;
        }

        if (isAlpha(guess) == false){
            System.out.println("Your guess must only contain letters of the alphabet.");
            return false;
        }

        return true;
    }

    /**** ADD YOUR METHOD FOR TASKS 3 and 5 HERE. ****/
    public static boolean processGuess(String guess, String mystery){
    String output = "  ";
    int lenS = guess.length();

    for (int i = 0; i < lenS; i++){
        String letterG = guess.substring( i, i+1);
        String letterM = mystery.substring( i, i+1);
        if (letterG.equals(letterM) == true){
            output = output + " " + letterG;
        }
        else if (mystery.contains(letterG)){
            if ((numOccur(guess.charAt(i), guess)) < (numOccur(mystery.charAt(i), mystery))){
            output = output + " [" + letterG + "]";
            }
            else{
                if (output.contains(letterG) == false){
                    output = output + " [" + letterG + "]";
                    
                }
                else{
                    output = output + " _";
                }
            }
        }

        else{
            output = output + " _";
        }
    }

    System.out.println(output);
    System.out.println();
    if (guess.equals(mystery) == true){
        return true;
    }
    return false;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        printWelcome();

        // Create the WordList object for the collection of possible words.
        WordList words= initWordList(args);

        // Choose one of the words as the mystery word.
        String mystery = words.getRandomWord();
       // String mystery = "towel";//
        
        /*** TASK 4: Implement the rest of the main method below. ***/
        int tries = 1;

        while (tries <= 6){
            //String guess = console.next();//
            String guess = readGuess(tries, console);
            if (isValidGuess(guess) == true) {
            if (processGuess(guess, mystery) == true){
                System.out.println("Congrats! You guessed it!");
                break;
            }
            else {
                tries = tries + 1; 
            }
            if(tries == 7){
                System.out.println("Sorry! Better luck next time!");
                System.out.println("The word was " + mystery);
                break;
            }
        }
        }
        
        console.close();
    }
}