package functional.p5.performance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * In this example we compare simple algo which returns concatenated unique strings
 * @author victorp
 */
public class DoItSimple {

    public static void main(String...args){
        int callsCount = 10000;
        List<String> helloWorld = Arrays.asList("Hello", "World","Hello", "World","Hello", "World","Hello", "World","Hello", "World");

        //print results of all implementations
        printResult("doIt1", DoItSimple::doIt1,helloWorld);
        printResult("doIt2", DoItSimple::doIt2,helloWorld);


        //warm up
        System.out.println("Warming up, please be patient :)");

        final boolean printIt = false;
        IntStream.rangeClosed(1, 200).forEach(i->{
            testPerformance(callsCount, "doIt1", DoItSimple::doIt1, helloWorld,printIt);
            testPerformance(callsCount,"doIt2", DoItSimple::doIt2,helloWorld,printIt);
        });

        //real run after warm up
        System.out.println("Running the real test after warm up");
        final boolean printItNow = true;
        IntStream.rangeClosed(1,1).forEach(i->{
            testPerformance(callsCount, "doIt1", DoItSimple::doIt1, helloWorld,printItNow);
            testPerformance(callsCount,"doIt2", DoItSimple::doIt2,helloWorld,printItNow);
        });

    }


    private static void printResult(String name, Function<List<String>,String> fun,List<String> words) {
        System.out.println(name+" -> "+fun.apply(words));
    }

    private static void testPerformance(int callsCount, String name, Consumer<List<String>> fun,List<String> words, boolean printResults) {
        long start = System.currentTimeMillis();
        for (int i = 0 ; i <callsCount; i++){
            fun.accept(words);
        }

        if (printResults) {
            System.out.println("end of " + name);
            System.out.println(name + " took: " + (System.currentTimeMillis() - start));
        }
    }

    private static String doIt2(List<String> words) {
        return words.stream().
                distinct().
                collect(Collectors.joining());
    }



    private static String doIt1(List<String> words) {
        StringBuilder  strBuilder = new StringBuilder();
        Set<String> strSet = new HashSet<>();
        for (String word: words){
            if (!strSet.contains(word)){
                strSet.add(word);
                strBuilder.append(word);
            }
        }
        return strBuilder.toString();
    }


}


