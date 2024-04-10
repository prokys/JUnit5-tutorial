package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {
    static List<String> sourceString(){
        //real code here
        return Arrays.asList("tomato","carrot","cabbage");
    }

    static Stream<String> sourceStringStream(){
        //real code here
        return Stream.of("beetroot", "apple", "pear");
    }

    static List<Arguments> sourceList_StringDouble(){
        //real code here
        return Arrays.asList(arguments("tomato", 2.0), arguments("carrot", 4.5), arguments("cabbage", 7.8));
    }

    static Stream<Arguments> sourceStream_StringDouble(){
        //real code here
        return Stream.of(arguments("apple", 8.9), arguments("pear", 3.3), arguments("orange", 5.2));
    }
}
