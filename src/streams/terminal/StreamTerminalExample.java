package streams.terminal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class StreamTerminalExample {

    public record Employee(String name,int age,double salary) { };
    
    public static void main(String[] args) {

        Long count = Arrays.stream(new int[] {1,2,3,4,5,6}).count();
        System.out.println(count);

        List<String> list = List.of("Munna","Syed","Munna","Dummy","Double","ANSR");
        System.out.println(list.stream().filter(s -> s.equalsIgnoreCase("Munna")).findAny().orElseGet(() -> "Ia m King"));

        System.out.println(list.stream().min(Comparator.naturalOrder()).get());
        list.stream().sorted(Comparator.comparingInt(String::length)).forEach(
                System.out::println
        );
       System.out.println(list.stream().max(Comparator.comparingInt(String::length).thenComparing(String::compareTo)).get());    
       
       List<Employee> employess = List.of(new Employee("MUNNA", 19, 35000),
        new Employee("SYED", 20, 40000), new Employee("DUMMY", 21, 30000));
      boolean result = employess.stream().anyMatch(employee -> employee.salary > 20000);
      System.out.println(result);
      boolean result1 = employess.stream().allMatch(employee -> employee.salary > 40000);
      System.out.println(result1);
      boolean result2 = employess.stream().noneMatch(employee -> employee.age > 30 );
      System.out.println(result2);
      boolean result3 = employess.stream().allMatch(employee -> employee.name.equals(employee.name.toUpperCase()));
      System.out.println(result3);
      System.out.println(employess.stream().filter(employee -> employee.salary > 30000).findAny().orElse(null));

     System.out.println(list.stream().reduce("DummyNellore",(a,b) -> a.length() > b.length() ? a :b)
    
    );
     

    
    }
}