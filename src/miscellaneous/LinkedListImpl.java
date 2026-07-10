package miscellaneous;

public class LinkedListImpl {

    private Node head;

    public void add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return;
        }
        Node current  = head;

        while(current.next != null){

            current = current.next;

        }
        current.next = node;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;

        }
    }

    public int size(){
        Node current = head;
        int count =0 ;

        while(current != null){
            count++;
            current = current.next;
        }

        return count;
    }

    public boolean contains(int i ){

        Node current = head;

        while(current != null){

            if(current.data == i){
                return true ;
            }
            current = current.next;
        }
        return false;

    }

    public void delete(int target){

        if(head == null){
            return ;
        }
        if(head.data == target){
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null){

            if(current.next.data == target){
                current.next = current.next.next;
                return ;
            }
            current = current.next;

        }
    }



   private static class Node {

    int data;
    Node next;

    private Node(int data){
        this.data = data;
        this.next = null;
    }
   }
}
