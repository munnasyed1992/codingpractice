package miscellaneous;

public class LinkedListImpl {

    // The starting point of the list. If head is null, the list is empty.
    private Node head;

    public void add(int data){
        // Step 1: Create a brand new independent node. Its 'next' is null by default.
        Node node = new Node(data);
        
        // EDGE CASE: If the list is empty, make this new node the head.
        if(head == null){
            head = node;
            return; // EXIT BUTTON: Stop here so we don't accidentally run the traversal logic below.
        }
        
        // TRAVERSAL: Create a temporary traveler pointer. Never move 'head' or you lose the list.
        Node current  = head;

        // CRITICAL LOGIC: We check 'current.next != null' because we want to stop EXACTLY ON the last node.
        while(current.next != null){
            current = current.next; // Move forward one step
        }
        
        // LINKING: Now that 'current' is sitting on the last node, link its 'next' reference to our new node.
        current.next = node;
    }

    public void printList(){
        Node current = head;
        
        // CRITICAL LOGIC: We check 'current != null' (not current.next) because we want to step ONTO 
        // every single node, including the last one, to print its data before stopping.
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next; // Move forward one step
        }
    }

    public int size(){
        Node current = head;
        int count = 0; // Counter starts at 0

        // Just like printing, we step onto every valid node to count it accurately.
        while(current != null){
            count++; // Increment the counter for the current node
            current = current.next; // Move forward
        }

        return count; // Return total tally
    }

    public boolean contains(int i){
        Node current = head;

        // Step onto every node to look at its interior data.
        while(current != null){
            // If the current node contains the target number, exit immediately and report success.
            if(current.data == i){
                return true;
            }
            // CRITICAL BUG FIX: This must stay outside the 'if' block so the pointer 
            // always moves forward, preventing an infinite loop.
            current = current.next;
        }
        
        // If the loop finished and we hit 'null' without returning true, the number doesn't exist.
        return false;
    }

    public void delete(int target){
        // EDGE CASE 1: If the list is empty, there is nothing to delete.
        if(head == null){
            return;
        }
        
        // EDGE CASE 2: If the node to delete is the very FIRST node (the head).
        if(head.data == target){
            head = head.next; // Shifting head to the 2nd node drops the 1st node out of the chain.
            return; // Exit immediately since deletion is complete.
        }
        
        // MIDDLE DELETION: Start a traveler pointer. 
        Node current = head;
        
        // CRITICAL LOGIC: We check 'current.next != null' to ensure we have a look-ahead node to evaluate.
        // This safely protects us from hitting a NullPointerException at the end of the list.
        while(current.next != null){

            // LOOK-AHEAD: Check if the NEXT node contains the target value.
            // We do this because we must stop the traveler one step BEFORE the target to rewire things.
            if(current.next.data == target){
                // REWIRING: Skip the target node entirely by linking 'current.next' 
                // directly to the node that comes AFTER the target (.next.next).
                current.next = current.next.next;
                return; // Exit immediately since deletion is complete.
            }
            current = current.next; // Move forward if the next node wasn't the target
        }
    }

    public void clear(){
        // DOMINO CLEANUP LOGIC: Disconnecting the 'head' pointer completely isolates the list.
        // Your program can no longer access any nodes, making the list instantly empty.
        // Java's background Garbage Collector will see these isolated nodes and automatically wipe them from RAM.
        head = null;
    }


   // Inner class representing a single box in the list chain.
   private static class Node {
    int data;  // Stores the actual integer value
    Node next; // Stores the reference address of the next Node object in line

    // Constructor to build a fresh, unlinked node box.
    private Node(int data){
        this.data = data;
        this.next = null; // Born alone: Every fresh node points to nothing until manually linked.
    }
   }
}
