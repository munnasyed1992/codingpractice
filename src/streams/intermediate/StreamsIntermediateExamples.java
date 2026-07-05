package streams.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsIntermediateExamples {
    public record Employee(String name,Double salary) implements Comparable<Employee> {
        @Override
        public int compareTo(Employee o) {
            return Double.compare(this.salary,o.salary);
        }
    }
    public static void main(String[] args) {
        Arrays.stream(new int[]{1,2,3,4,5,6,8,10}).filter(x -> x %2 ==0).forEach(System.out::println);
        System.out.println();
        Arrays.stream(new int[]{1,2,3,3,5,5,8,8}).distinct().forEach(System.out::print);
        System.out.println();
        Arrays.stream(new int[]{1,2,3,4,5})
                .peek(x -> System.out.println("element before limit"+x))
                .limit(3).forEach(System.out::print);
        System.out.println();
        Stream.of(1,2,3,4,5,6,8,10).filter(n -> n%2 ==0).skip(1).forEach(System.out::print);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,8,10);
        System.out.println();
        list.stream().filter(n -> n%2 ==0).map(n -> n/2).forEach(System.out::print);
        System.out.println();
        List<String> sentences = Arrays.asList("Hello World","Java Streams","Flat Map");
        sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(System.out::print);
        System.out.println();

        Stream.of(1,4,5,7,3,10,12,11,2).sorted(Comparator.comparingInt(Integer::intValue).reversed()).forEach(System.out::print);
        System.out.println();
        sentences.stream().flatMap(s -> Stream.of(s.split(" ")))
                .sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
        List<Employee> employess = List.of(new Employee("munna",12000.00),new Employee("yasmin",15000.00),new Employee("naseema",170000.00));
        employess.stream().sorted(Comparator.comparing(Employee::salary).reversed().thenComparing(Employee::name)).forEach(System.out::print);
        System.out.println();
        double value =list.stream().mapToInt(n -> n).average().getAsDouble();
        System.out.println(value);

    }
}
