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

    public void stream1() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
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
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        List<String> limitResult = limit.collect(Collectors.toList());
        System.out.println(limitResult);
    }

    
}