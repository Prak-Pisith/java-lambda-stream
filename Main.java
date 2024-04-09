import java.util.*;
import java.util.stream.*;
import java.util.stream.Stream;


class Main {
    public static void main(String[] args) {
        TestLambda testLambda = new TestLambda();
        testLambda.allColor();


        TestStream testStream = new TestStream();
        testStream.stream1();
        testStream.stream2();
        testStream.stream3();
    }
}

class TestLambda {
    // forEach
    public void allColor() {
        List<String> colors = List.of("Red", "Green", "Blue");
        colors.forEach(color -> System.out.println("Color: " + color));
    }

}

class TestStream {

    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");


    public void stream1() {
        Stream<String> stream = strings.stream();
        System.out.println("stream");
        System.out.println(stream);

        stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        System.out.println("limit");
        System.out.println(limit);

        // counting
        System.out.println(limit.count());
    }

    public void stream2() {
        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        List<String> limitResult = limit.collect(Collectors.toList());
        System.out.println(limitResult);
    }

    public void stream3() {
        // Stream Pipeline
        List<String> result = strings
                .stream() // Source
                .limit(5) // Intermediate operation
                .collect(Collectors.toList()); // terminal operation
                // then output
        System.out.println("Result : " + result);

        List<String> result2 = strings
                .stream()
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Result 2 : " + result2);

        List<String> result3 = strings
                .stream()
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                .skip(2)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("Result 3 : " + result3);

    }


}