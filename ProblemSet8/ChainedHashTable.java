/*
 * ChainedHashTable.java
 *
 * Computer Science 112, Boston University
 * 
 * Modifications and additions by:
 *     name: gianna sfrisi
 *     email: gsfrisi@bu.edu
 */

import java.util.*;     // to allow for the use of Arrays.toString() in testing

/*
 * A class that implements a hash table using separate chaining.
 */
public class ChainedHashTable implements HashTable {
    /* 
     * Private inner class for a node in a linked list
     * for a given position of the hash table
     */
    private class Node {
        private Object key;
        private LLQueue<Object> values;
        private Node next;
        
        private Node(Object key, Object value) {
            this.key = key;
            values = new LLQueue<Object>();
            values.insert(value);
            next = null;
        }
    }
    
    private Node[] table;      // the hash table itself
    private int numKeys;       // the total number of keys in the table
        
    /* hash function */
    public int h1(Object key) {
        int h1 = key.hashCode() % table.length;
        if (h1 < 0) {
            h1 += table.length;
        }
        return h1;
    }
    
    /*** Add your constructor here ***/
    public ChainedHashTable(int size){
        if (size <= 0){
            throw new IllegalArgumentException();
        }
        table = new Node[size];
    }
    
    /*
     * insert - insert the specified (key, value) pair in the hash table.
     * Returns true if the pair can be added and false if there is overflow.
     */
    public boolean insert(Object key, Object value) {
        /** Replace the following line with your implementation. **/
        if (key == null) {
            throw new IllegalArgumentException();
        }

        int i = h1(key);
        Node travel = table[i];
        Node nextNode = new Node(key, value);
        numKeys++;

        while( travel != null){
            if (travel.key == key){
                numKeys --;
                break;
            }
            travel = travel.next;
        }

        if (table[i] != null){
            table[i].next = null;
            }
            else{
                table[i] = nextNode;
        }
        return true;
    }
    
    /*
     * search - search for the specified key and return the
     * associated collection of values, or null if the key 
     * is not in the table
     */
    public Queue<Object> search(Object key) {
        /** Replace the following line with your implementation. **/
        if (key == null) {
            throw new IllegalArgumentException();
        }
        
        int i = h1(key);
        int checked = 1;
        int location = -1;

       for (int j = i; checked != table.length; j++){
            if (table[j].key == key){
                location = j;
            }
            checked ++;
            }
        if (location == -1 || table[location] == null){
            return null;
        }
        else{
            return table[location].values;
        }
    }
    
    /* 
     * remove - remove from the table the entry for the specified key
     * and return the associated collection of values, or null if the key 
     * is not in the table
     */
    public Queue<Object> remove(Object key) {
        /** Replace the following line with your implementation. **/
        if (key == null) {
            throw new IllegalArgumentException();
        }

        int i = h1(key);
        int checked = 1;
        int location = -1;

       for (int j = i; j < table.length; j++){
            if (j > 0 && table[j] != null && table[j].key == key){
                location = j;
            }
            checked ++;
            }
            if (location < 0 || table[location].values == null){
                return null;

            }
            LLQueue<Object> removedVals = table[location].values;
            table[location].key = null;
            table[location].values = null;

            numKeys--;
        return removedVals;
    }
    
    
    /*** Add the other required methods here ***/
    public int getNumKeys(){
        return this.numKeys;
    }

    public double load(){
     //   System.out.println(numKeys);
       // System.out.println(table.length);
        return (double)numKeys/table.length;
    }

    public Object[] getAllKeys(){
        Object [] allkeys = new Object [numKeys];
        boolean repeat = false;
        int start = 0;
        for (int i = 0; i < table.length; i++){
            if (table[i] != null && repeat == false){
                Node trav = table[i];
                while (trav != null){
                    allkeys[start] = trav.key;
                    trav = trav.next;
                    start ++;
                }
            }
        }
        return allkeys;
    }

    public void resize(int newSize){
        if (newSize <= table.length) {
            throw new IllegalArgumentException();
        }
    Node [] resizedTable = new Node[newSize];
    for (int i = 0; i < table.length; i++){
        if (table[i] != null){
            int indexValue = h1(table[i].key);
            Node resizedNode = new Node(table[i].key, table[i].values);
            if (table[indexValue] != null){
                table[indexValue].next = resizedNode;
            }
            else{
                table[indexValue] = resizedNode;
            }
        }
    }
    table = resizedTable;
    }
    
    
    /*
     * toString - returns a string representation of this ChainedHashTable
     * object. *** You should NOT change this method. ***
     */
    public String toString() {
        String s = "[";
        
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                s += "null";
            } else {
                String keys = "{";
                Node trav = table[i];
                while (trav != null) {
                    keys += trav.key;
                    if (trav.next != null) {
                        keys += "; ";
                    }
                    trav = trav.next;
                }
                keys += "}";
                s += keys;
            }
        
            if (i < table.length - 1) {
                s += ", ";
            }
        }       
        
        s += "]";
        return s;
    }

    public static void main(String[] args) {
        /** Add your unit tests here **/

ChainedHashTable table = new ChainedHashTable(5);
table.insert("howdy", 15);
table.insert("goodbye", 10);
System.out.println(table.insert("apple", 5));
System.out.println(table);
    
System.out.println("next test");
    

 System.out.println(table.getNumKeys());
 table.insert("howdy", 25);     // insert a duplicate
 System.out.println(table.getNumKeys());

 System.out.println("next test");


System.out.println(table.load());
table.insert("pear", 6);
System.out.println(table.load());

 System.out.println("next test");


 Object[] keys = table.getAllKeys();
 System.out.println(Arrays.toString(keys));

 System.out.println("next test");

 table.resize(7);
 System.out.println(table);

// my own test cases for each method 

ChainedHashTable table1 = new ChainedHashTable(20);
table1.insert("hi", 15);
table1.insert("my", 10);
table1.insert("name", 16);
table1.insert("is", 3);
table1.insert("gianna", 4);
System.out.println(table1);
System.out.println(table1.getNumKeys());
table1.remove(3);
table1.remove(10);
System.out.println(table1.getNumKeys());
System.out.println(table1.load());
table.resize(25);
 System.out.println(table1);

System.out.println("Test 2");

ChainedHashTable table2 = new ChainedHashTable(21);
 table2.insert("josie", 19);
 table2.insert("is", 10);
 table2.insert("my", 16);
 table2.insert("is", 2);
 table2.insert("dog", 12);
 System.out.println(table2);
 System.out.println(table2.getNumKeys());
 table2.remove(10);
 table2.remove(16);
 System.out.println(table2.getNumKeys());
 System.out.println(table2.load());
 table2.resize(27);
  System.out.println(table2);

 }
 }
