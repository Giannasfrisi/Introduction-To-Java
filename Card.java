/*
 * Card.java
 * 
 * A blueprint class for objects that represent a single playing card 
 * for a game in which cards have both colors and numeric values.
 * 
 * starter code: CS 112 Staff (cs112-staff@cs.bu.edu)
 * completed by: 
 * Name : Ellis Hamilton ellisham@bu.edu
 * Gianna Sfrisi - gsfrisi@bu.edu
 */
import java.util.*;
public class Card {
    /* fields to define characteristics of the cards*/
    private String color; 
    private int value; 
    /* The smallest possible value that a Card can have. */
    public static final int MIN_VALUE = 0;
    
    /* The possible colors that a Card can have. */
    public static final String[] COLORS = {"blue", "green", "red", "yellow"};

    /* Define the third class constant here. */
    public static final int MAX_VALUE = 9;

    /* Put the rest of your class definition below. */
    public static boolean isValidColor(String color){
        boolean value = false;
        for (int i=0;i< COLORS.length; i++){
            if (color.equals(COLORS[i])){
                value = true;
                break;
            }
        }
        return value;
    }
    public void setColor (String inputColor){
        if (Card.isValidColor(inputColor)==true){
            this.color=inputColor;
        } else{
            throw new IllegalArgumentException();
        }
    }
    public void setValue(int inputValue){
        if ((inputValue<=MAX_VALUE) && (inputValue>=MIN_VALUE)){
            this.value=inputValue;
        } else{
            throw new IllegalArgumentException();
        }
    }
    public Card(String card, int val){
        this.setColor(card);
        this.setValue(val);
    }
    public String getColor(){
        return this.color;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return (this.color + " " + this.value);
    }
    public boolean matches(Card other){
        if (other == null){
        return false;
        }
        else{
            if(this.color == other.color){
                return true;
            }
            else if(this.value == other.value){
                return true;
            }
            return false;
        }
    }

    public boolean equals(Card other){
        if (other == null){
            return false;
            }
        else{
            if (this.color == other.color && this.value == other.value){
                return true;
            }
            return false;
        }
    }

    public static void main(String [] args){
        System.out.println(isValidColor("orange"));
    }
}
    
