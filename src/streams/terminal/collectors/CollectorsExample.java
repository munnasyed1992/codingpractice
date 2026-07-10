package streams.terminal.collectors;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsExample {

    public record Employee(int age,String name,double salary,String department){}
    public record OrderEvent(Long orderId,LocalDateTime timestamp,String status){}

    public static void main(String[] args) {
       List<Employee> employees =  List.of(new Employee(21,"Munna",70000,"IT")
       ,new Employee(28,"Rahul", 40000,"HR"),
       new Employee(31, "Balaji", 900000,"Finance"),
        new Employee(22, "Munna", 70000,"IT")
    );

        employees.stream()
        .map(employee -> employee.name)
        .collect(Collectors.toList());

       Set<Employee> highEarners = employees.stream().filter(employee -> employee.salary > 20000).collect(Collectors.toSet());
       System.out.println(highEarners);

     List<Integer> ages =  employees.stream().map(Employee::age).collect(Collectors.toUnmodifiableList());
            // ages.add(50); // This will throw an UnsupportedOperationException

     Set<Integer> agesSet =  employees.stream().map(Employee::age).collect(Collectors.toUnmodifiableSet());
     System.out.println(agesSet);

     TreeSet<Employee> treeEmployess =employees.
                                        stream().
                                        filter(employee -> employee.age >18).collect(Collectors.toCollection(() -> new TreeSet(Comparator.comparingInt(Employee::age).reversed())));
    System.out.println(treeEmployess);

   Map<Integer,String> ageToNameMap = employees.stream().collect(Collectors.toMap(employee -> employee.name.length(),
            Employee::name,
        (len1,len2) -> len1 + "," + len2));
            System.out.println("age to name map: " + ageToNameMap);
        

     Map<Character,List<Employee>> grouped = employees.stream().collect(Collectors.groupingBy(employee -> employee.name.charAt(0))); 
     System.out.println(grouped);

     Map<String,Long> departmentalGroups = employees.stream().collect(Collectors.groupingBy(Employee::department,
        Collectors.counting()));
     System.out.println(departmentalGroups);

    List<OrderEvent> orderEvents = List.of(new OrderEvent(123l,LocalDateTime.now(),"CREATED"),
                new OrderEvent(123l,LocalDateTime.of(2026, Month.JUNE, 15, 12, 45, 45, 45),"CREATED"),
             new OrderEvent(124l,LocalDateTime.now(),"CREATED"),
             new OrderEvent(125l,LocalDateTime.now(),"CREATED"),
             new OrderEvent(126l,LocalDateTime.now(),"CANCELLED"),
             new OrderEvent(127l,LocalDateTime.now(),"CANCELLED"));
             
             orderEvents.stream()
             .collect(Collectors.groupingBy(OrderEvent::orderId,
            Collectors.minBy(Comparator.comparing(OrderEvent::timestamp))))
             .forEach((orderid,status) -> System.out.println(orderid+" : "+status.get()));


             orderEvents.stream().collect(Collectors.toMap(order -> order.orderId, order -> order,
                (o1,o2) -> o1.timestamp.isAfter(o2.timestamp) ? o1 : o2)).forEach((order,orderevent) -> 
            System.out.println(order +"  "+orderevent)
            );

            

             
            

     

    }

   

}
