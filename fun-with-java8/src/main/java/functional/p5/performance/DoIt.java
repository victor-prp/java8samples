package functional.p5.performance;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Here we show that performance may be very bad when using flat map <br/>
 *
 * @author: victorp
 */
public class DoIt {
    public static void main(String...args){
        int callsCount = 10000;
        List<String> helloWorld = Arrays.asList("Hello", "World");

        //print results of all implementations
        printResult("doIt1", DoIt::doIt1,helloWorld);
        printResult("doIt2", DoIt::doIt2,helloWorld);
        printResult("doIt3", DoIt::doIt3,helloWorld);
        printResult("doIt4", DoIt::doIt4,helloWorld);


        //warm up
        System.out.println("Warming up, please be patient :)");

        final boolean printIt = false;
        IntStream.rangeClosed(1,200).forEach(i->{
            testPerformance(callsCount, "doIt1", DoIt::doIt1, helloWorld,printIt);
            testPerformance(callsCount,"doIt2", DoIt::doIt2,helloWorld,printIt);
            testPerformance(callsCount,"doIt3", DoIt::doIt3,helloWorld,printIt);
            testPerformance(callsCount,"doIt4", DoIt::doIt4,helloWorld,printIt);
        });

        //real run after warm up
        System.out.println("Running the real test after warm up");
        final boolean printItNow = true;
        IntStream.rangeClosed(1,1).forEach(i->{
            testPerformance(callsCount, "doIt1", DoIt::doIt1, helloWorld,printItNow);
            testPerformance(callsCount,"doIt2", DoIt::doIt2,helloWorld,printItNow);
            testPerformance(callsCount,"doIt3", DoIt::doIt3,helloWorld,printItNow);
            testPerformance(callsCount,"doIt4", DoIt::doIt4,helloWorld,printItNow);
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
                map(str -> str.split("")).
                flatMap(Arrays::stream).
                distinct().
                collect(Collectors.joining());
    }


    private static String doIt3(List<String> words) {
        StringBuilder result = new StringBuilder();
        words.stream()
                .flatMap(str->str.chars().mapToObj(i -> (char) i))
                .distinct()
                .forEach(result::append);
        return result.toString();
    }

    private static String doIt4(List<String> words) {
        StringBuilder result = new StringBuilder();
        words.stream()
                .flatMapToInt(String::chars)
                .distinct()
                .forEach((chr)-> result.append((char)chr));
        return result.toString();
    }


    private static String doIt1(List<String> words) {
        StringBuilder  strBuilder = new StringBuilder();
        Set<Character> chartsSet = new HashSet<>();
        for (String word: words){
            for (char singleChar : word.toCharArray())  {
                if (!chartsSet.contains(singleChar)){
                    strBuilder.append(singleChar);
                    chartsSet.add(singleChar);
                }
            }
        }
        return strBuilder.toString();
    }


}

