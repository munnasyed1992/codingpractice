package streams.terminal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class StreamTerminalExample {

    public static void main(String[] args) {

        Long count = Arrays.stream(new int[] {1,2,3,4,5,6}).count();
        System.out.println(count);

        List<String> list = List.of("Munna","Syed","Munna","Dummy","Double");
        System.out.println(list.stream().filter(s -> s.equalsIgnoreCase("Munna")).findAny().orElseGet(() -> "Ia m King"));

        System.out.println(list.stream().min(Comparator.naturalOrder()).get());
        

    }
}
