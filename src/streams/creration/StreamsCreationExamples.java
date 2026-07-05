package streams.creration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsCreationExamples {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        list.stream().forEach(System.out::print);
        System.out.println();
        Stream.of(1,2,3,4,5,6).forEach(System.out::print);
        System.out.println();

        Stream.iterate(new int[]{0,1}, n-> {

            return new int[]{n[1],n[0]+n[1]};

                }

                ).limit(10)
                .map(n->n[0]).forEach(System.out::print);
        System.out.println();
        Stream.generate(Math::random).limit(10).forEach(System.out::print);




    }
}
