/* completed by: gianna sfrisi gsfrisi@bu.edu

That takes a user input of a maximum ladder height and 
the angle the ladder is positioned at, calculates the value to radians 
and computes the length.
*/

import java.util.*;

public class Ladder {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the height the ladder must reach: ");
        int maxHeight = scan.nextInt();

        System.out.println("Enter the angle the ladder is positioned at: ");
        int angle = scan.nextInt();

        double radians = ((double)angle * Math.PI)/180.0;
        double length = (double)maxHeight/ Math.sin(radians);

        double feet = length;
        double yards = feet/3.0;
        int roundedYards = (int)feet/3;
        double leftFeet = roundedYards*-3 + feet;

        System.out.println("The required length is:");
        System.out.println(feet + " feet");
        System.out.println(yards + " yards");
        System.out.println(roundedYards + " yards and " + leftFeet + " feet");

    }
}
