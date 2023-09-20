/*
 * Palindrome.java
 *
 * Computer Science 112
 *
 * Modifications and additions by:
 *     name: gianna sfrisi and ellis hamilton
 *     username: gsfrisi@bu.edu and ellisgham@bu.edu
 */


public class Palindrome {
    public static boolean isPal(String s) {
        // This line is included to allow the code to compile.
        // Replace it with your implementation of the method.
        
        if (s == null){
            throw new IllegalArgumentException();
        }
        s.toLowerCase();
        // make queue
        ArrayQueue<Character> sQueue = new ArrayQueue<Character> (s.length());
        // add items to queue
        for (int i=0; i<=s.length();i++){ 
            if (Character.isLetter(s.charAt(i))){
                sQueue.insert(s.charAt(i));
            }
        }
        // base case
        if (s.length() <=1){
            return true;
        } else {
            isPal(s.substring(1,s.length()-1));
            if(sQueue.remove()!=sQueue.peek()){
                return false;
            }
            
            
        }
    return true;
    }
    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            boolean expected = true;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * Add five more unit tests that test a variety of different
         * cases. Follow the same format that we have used above.
         */
        System.out.println("(1) Testing on \"redivider\"");
        try {
            boolean results = isPal("redivider");
            boolean expected = true;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();

        System.out.println("(2) Testing on \"gianna and ellie's code\"");
        try {
            boolean results = isPal("gianna and ellie's code");
            boolean expected = false;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();

        System.out.println("(3) Testing on \"Yo, banana boy\"");
        try {
            boolean results = isPal("Yo, banana boy");
            boolean expected = true;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();

        System.out.println("(4) Testing on \"My dog ate my code\"");
        try {
            boolean results = isPal("My dog ate my code");
            boolean expected = false;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();

        System.out.println("(5) Testing on \"Evil olive\"");
        try {
            boolean results = isPal("Evil olive");
            boolean expected = true;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();



    }
}