import java.util.*;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name){
        super(name);
    }
    public void displayHand(){
        System.out.println(getName() + "'s hand:");
        if (getNumCards()==1){
            System.out.println("  " + getNumCards() + " card");
        } else{
            System.out.println("  " + getNumCards() + " cards");
        }
    } 
    @Override
    public int getPlay(Scanner console, Card discard){
        int matchingIndex = -1;
        Card [] hand = this.getHand();
        int x = 0;
        int max =0;
        Card[] match = new Card [this.getNumCards()];
        for (int i=0; i < this.getNumCards();i++){
            Card check = hand[i];  
            String checkColor = check.getColor();

            if (checkColor == discard.getColor()){
                match [x] = check;
                x++;
            }
        }
            for (int i=0; i< x;i++){
                Card check = (Card) match[i];
                int checkValue = check.getValue();
                if (checkValue>max){
                    max = checkValue;
                }
        
        Card soln = new Card (discard.getColor(),max);
        for (int j = 0; j<this.getNumCards();j++){
            if (soln.equals(hand[j])){
                matchingIndex = j;
            }
        }
    }
        for (int i=0; i < getNumCards();i++){
        Card check = hand [i];
        int checkValue = check.getValue();
        if (discard.getValue() == checkValue){
            matchingIndex = i;
        }
        }

        return matchingIndex;
}

public static void main(String [] args){
        
}
}
