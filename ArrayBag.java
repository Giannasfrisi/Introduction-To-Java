/* 
 * ArrayBag.java
 * 
 * Computer Science 112
 */

import java.util.*;

/**
 * An implementation of a bag data structure using an array.
 */
public class ArrayBag {
    /** 
     * The array used to store the items in the bag.
     */
    private Object[] items;
    
    /** 
     * The number of items in the bag.
     */
    private int numItems;
    
    public static final int DEFAULT_MAX_SIZE = 50;
    
    /**
     * Constructor with no parameters - creates a new, empty ArrayBag with 
     * the default maximum size.
     */
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }
    
    /** 
     * A constructor that creates a new, empty ArrayBag with the specified
     * maximum size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }
    
    /**
     * numItems - accessor method that returns the number of items 
     * in this ArrayBag.
     */
    public int numItems() {
        return this.numItems;
    }
    
    /** 
     * add - adds the specified item to this ArrayBag. Returns true if there 
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        } else if (this.numItems == this.items.length) {
            return false;    // no more room!
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }
    
    /** 
     * remove - removes one occurrence of the specified item (if any)
     * from this ArrayBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                this.items[this.numItems - 1] = null;
                
                this.numItems--;
                return true;
            }
        }
        
        return false;  // item not found
    }
    
    /**
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        
        int whichOne = (int)(Math.random() * this.numItems);
        return this.items[whichOne];
    }
    
    /**
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];
        
        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }
        
        return copy;
    }
    
    /**
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }
        
        str = str + "}";
        return str;
    }

    public int roomLeft(){
        int size = items.length;
        int total = size - numItems;
        return total;
    }

    public boolean isFull(){
        if (this.numItems == this.items.length) {
            return true;
        }
        else{
            return false;
        }

    }

    public void increaseCapacity(int increment){
        if (increment < 0){
            throw new IllegalArgumentException();
        }
        int amount = items.length + increment;
        Object[] temp = new Object[amount];
            for (int i = 0; i < amount; i++){
                temp[i] = items[i];
                this.items = temp;
            }
    }

    public boolean removeItems(ArrayBag other){
        if (other == null){
            throw new IllegalArgumentException();
        }

        if (this.items.length == 0 || other.items.length == 0){
            return false;
        }
        int originalSize = this.numItems;
       // System.out.println("NUM ITEMS: " + numItems);
        int newSize = this.numItems;
        int newArraySize = other.numItems;
        //System.out.println(Arrays.toString(this.items));
        for (int i = 0; i < originalSize; i++){
            if (this.items[i] == null){
                break;
            }
          //  System.out.println("I : " + i);
            //System.out.println("THIS: " + this.items[i]);
            boolean testcase = false;
            Object removedItem = this.items[i];
            for (int j = 0; j < newArraySize; j++){
              //  System.out.println("OTHER: " + other.items[j]);
                if (this.items[i].equals(other.items[j])){
                    testcase = true;
                    removedItem = this.items[i];
                }
            }
            if (testcase == true){
                    this.remove(removedItem);
                    newSize = newSize -1; 
                    i--;
            }
        }
        if (originalSize == newSize){
            return false;
        }
        else{
            return true;
        }

    }

    public ArrayBag intersectionWith(ArrayBag other){
        int size;
        if (other == null){
            throw new IllegalArgumentException();
        }
        
        if (this.items.length > other.items.length){
            size = other.items.length;
        }
        else{
            size = this.items.length;
        }
        ArrayBag newArrayBag = new ArrayBag(size -1);
        for (int i = 0; i < size; i++){
          //  System.out.println("I: " + i );
            for (int j= 0; j < size; j++){
              //  System.out.println("j: " + j );
             //   System.out.println("THIS: " + items[i]);
               // System.out.println("OTHER: " + items[j] );
                if (this.items[i].equals(other.items[j])){
                    if (i == 0){
                        newArrayBag.add(this.items[i]);
                    }
                    else if ((newArrayBag.contains(this.items[i])) == false){
                        newArrayBag.add(this.items[i]);
                    }
                }
               // System.out.println("newArrayBag: " + newArrayBag);
            }
        }
        return newArrayBag;
      }

    
    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // Create an ArrayBag named bag1.
        System.out.print("size of bag 1: ");
        int size = scan.nextInt();
        ArrayBag bag1 = new ArrayBag(size);
        scan.nextLine();    // consume the rest of the line
        
        // Read in strings, add them to bag1, and print out bag1.
        String itemStr;        
        for (int i = 0; i < size; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
        
        // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();
        
        // Iterate over the objects in bag1, printing them one per
        // line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
/*   
        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();

        //tests roomLeft
        ArrayBag b3 = new ArrayBag(10);
        System.out.println("room before: " + b3.roomLeft());
        b3.add("hello");
        b3.add("world");
        System.out.println("room after: " + b3.roomLeft());

        //tests isFull
        ArrayBag b1 = new ArrayBag(2);
        System.out.println(b1.isFull());
        b1.add("hello");
        System.out.println(b1.isFull());
        b1.add("world");
        System.out.println(b1.isFull());

        //tests increaseCapacity
        ArrayBag b2 = new ArrayBag(10);
        b2.add("hello");
        b2.add("world");
        System.out.println(b2);
        System.out.println("room before: " + b2.roomLeft());

        b2.increaseCapacity(5);
        System.out.println(b2);
        System.out.println("room after: " + b2.roomLeft());
        
        //tests removeItems
        ArrayBag b4 = new ArrayBag(6);
        String[] words1 = {"hello", "you", "how", "are", "you", "today?"};
        for (String w : words1) {
            b4.add(w);
        }        
        System.out.println(b4);

        ArrayBag b5 = new ArrayBag(6);
        String[] words2 = {"not", "bad", "how", "are", "you", "doing"};
        for (String w : words2) {
        b5.add(w);
       }        
        System.out.println(b5);

        System.out.println(b4.removeItems(b5));
        System.out.println(b4);
        System.out.println(b5);
*/
        //test intersectionwith
        ArrayBag b1 = new ArrayBag(10);
        String[] letters1 = {"a", "a", "b", "d", "f", "f", "f", "g"};
        for (String ltr: letters1) {
            b1.add(ltr);
        }
        System.out.println(b1);
        
        ArrayBag b2 = new ArrayBag(8);
        String[] letters2 = {"a", "b", "c", "d", "d", "e", "f"};
        for (String ltr: letters2) {
            b2.add(ltr);
        }
        System.out.println(b2);
        
        ArrayBag b3 = b1.intersectionWith(b2);
        System.out.println(b3);
        System.out.println(b3.numItems());
        System.out.println(b3.roomLeft());
        System.out.println(b1);   // make sure original bags are unchanged
        System.out.println(b2);

    }
}
