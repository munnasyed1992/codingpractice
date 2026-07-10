package miscellaneous;

public class Tester {


    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();

        list.add(10);
        list.add(20);
        list.add(30);

        list.printList();
        System.out.println("\n"+list.size());
        System.out.println(list.contains(15));
       // list.delete(20);
        list.printList();
        System.out.println();
        list.reverse();
        list.printList();
        
    }

}
