package lab3;

import java.util.ArrayList;

/**
 *
 * @author Isaac Zheng 501263130
 */

public class QueueOfDistinctStrings {
    
    // Overview: QueueOfDistinctStrings are mutable, bounded
    // collection of distinct strings that operate in
    // FIFO (First-In-First-Out) order.
    //
    // The abstraction function is:
    // a) Write the abstraction function here
    //  
    //  AF(c) = {c.items[i] | 0 <= i < c.items.size}
    //  
    //  Informally:
    //   - AF(c) represents a queue of distinct strings
    //   - c.items[i] reprsents the individual strings in the FIFO queue
    //   - i represnts the order of the elements in c.items in the FIFO queue
    //   - c.items[0] would be the string at the front of the queue
    //   - c.items[c.items.size()-1] represents the string at the end of the queue
    //
    //
    // The rep invariant is:
    // b) Write the rep invariant here
    //
    //  RI(c) = true if c.items != null &&
    //  for all Strings s, c.items[s] != null &&
    //  for all int i, j,
    //  (0 <= i < j <  c.items.size() =>
    //  c.items.get(i).equals(c.items.get(j)) == false)
    //  = false otherwise
    //
    //  Informally:
    //   - The rep invariant is:
    //   - c.items != null  //array must be initialized
    //   - Elements in c.items are not null
    //   - c.items does not contain duplicates and is unique
    //
    
    //the rep
    private ArrayList<String> items;
    
    // constructor
    public QueueOfDistinctStrings () {
        // EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }
    
    // MODIFIES: this
    // EFFECTS: Appends the element at the end of the queue
    // if the element is not in the queue, otherwise
    // does nothing.
    public void enqueue(String element) throws Exception {
        if(element == null) throw new Exception();
        if(false == items.contains(element))
            items.add(element);
    }
    
    public String dequeue() throws Exception {
        // MODIFIES: this
        // EFFECTS: Removes an element from the front of the queue
        if (items.size() == 0) throw new Exception();
            return items.remove(0);
    }
    
    public boolean repOK() {
        // EFFECTS: Returns true if the rep invariant holds for this
        // object; otherwise returns false
        // c) Write the code for the repOK() here
        
        //Return false if ArrayList is null
        if (items == null)
            return false;
        
        //Return false if element is null
        for (String item : items){
            if (item == null)
                return false;
        }
        
        //Return false for duplicates
        for (int i = 0; i < items.size(); i++){
            for (int j = i+1; j < items.size(); j++){ //j = i+1 to check elements infront to not accidentally count current element as duplicate
                if (items.get(i).equals(items.get(j)))
                    return false;
            }
        }
        
        return true;
    }
    
    public String toString() {
        // EFFECTS: Returns a string that contains the strings in the
        // queue, the front element and the end element.
        // Implements the abstraction function.
        // d) Write the code for the toString() here
        
        //Returns if queue is empty
        if (items.isEmpty())
            return ("Queue is Empty");
        
        //Returns strings in the queue by implementing the abstract method
        return ("Queue: " + items.toString() + "\nFront: " + items.get(0) + "\nEnd: " + items.get(items.size()-1));
    }
    
    //Main function
    public static void main(String[] args){
        
        //TESTING: 
        //Will Test: repOK and toString method
        //Enqueue and dequeue are given methods already completed and assumed correct
        
        try{
            
            //Create new queue
            QueueOfDistinctStrings queue = new QueueOfDistinctStrings();
            
            //Check initial queue
            System.out.println("Initial queue");
            System.out.println("repOK(): " + queue.repOK()); //Print true because queue is initialized in constructor and is not null
            System.out.println("toString(): " + queue.toString() + "\n"); //Print "Empty queue" because no elements have been enqueued

            //Enqueue elements into queue
            queue.enqueue("Lab1");
            queue.enqueue("Lab2");
            queue.enqueue("Lab3");
            
            //Check added elements
            System.out.println("Enqueued queue");
            System.out.println("repOK(): " + queue.repOK());
            System.out.println("toString(): " + queue.toString() + "\n"); 
            
            //Dequeue element in the queue
            queue.dequeue();
            
            //Check new queue
            System.out.println("Dequeued queue");
            System.out.println("repOK(): " + queue.repOK());
            System.out.println("toString(): " + queue.toString() + "\n");
            
            //Manually add duplicate element because enqueue prevents duplicate elements from being added
            queue.items.add("Lab3");
            
            //Check after adding duplicate
            System.out.println("Duplicate in queue");
            System.out.println("repOK(): " + queue.repOK()); //Print false because of duplicate
            System.out.println("toString(): " + queue.toString());
            
        }catch (Exception e){
            System.out.println("ErrorExceptionCatched");
        }
        
    }
    
}
