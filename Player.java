
import java.util.*;


public class Player {
    private String name;
    private Card [] hand;
    private int numCards;
    
    public Player(String name) {
        this.name = name;
        this.hand = new Card [CardMatch.MAX_CARDS];
    }
    public String getName(){
        return this.name;
    }
    public int getNumCards(){
        return this.numCards;
    }
    public Card [] getHand(){
        return this.hand;
    }
    public String toString(){
        return this.name;
    }
    public void addCard(Card card){
        if ((card==null) || (numCards==CardMatch.MAX_CARDS)){
            throw new IllegalArgumentException();
        }
        this.hand[this.numCards] = card;
        this.numCards++;
    }

    public boolean contains(Object card){
        for (int i=0; i<=this.numCards; i++){
            if (this.hand[i].equals(card)){
                return true;
            }
        }return false;
    }
    public Card getCard(int index){
        for (int i=0; i<=this.numCards; i++){
            if (hand[index].equals(hand[i])){
                return hand[index];
            }
        }
        throw new IllegalArgumentException();
       } 
    
    public int getHandValue(){
        int sum=0;
        for (int i=0; i <= this.numCards -1;i++){
            Card card = this.hand[i];
            int cardNum = card.getValue();
            sum = sum + cardNum;
        }

        if (sum == CardMatch.MAX_CARDS){
            sum = sum +20;
        }
        return sum; 
    }
    public void displayHand(){
        System.out.println(this.name + "'s hand:");

        for (int i=0; i<=numCards;i++){
            if (hand[i] != null){
            System.out.println("  " + i + ": " + hand[i]);
            } 
            
        }
    }
    public Card removeCard(int index){
        Card removed = this.hand[index];
        this.hand[index] = this.hand[numCards -1];
        this.hand[numCards-1] = null;
        this.numCards --;
        return removed; 
    }
    public int getPlay(Scanner console, Card card){
        System.out.print(this.name + ": number of card to play (-1 to draw)? ");
        int play = console.nextInt();
       // while (play < -1 || play > numCards -1){
       //     System.out.println((this.name + ": number of card to play (-1 to draw)? ");
     //       int play = console.nextInt();
     //   }
        if (play ==-1){
            return play;
        } else{
            return play;
        }
    }
    public static void main(String [] args){
        
    }
}
