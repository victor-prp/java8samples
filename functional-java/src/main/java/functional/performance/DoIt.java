package functional.performance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;


/**
 * Here we show that performance may be very bad when using flat map <br/>
 *
 * @author: Victor
 */
public class DoIt {
    public static void main(String...args){
        int callsCount = 10000;
        List<String> helloWorld = Arrays.asList("Hello", "World");

        testPerformance(callsCount,"doIt1", DoIt::doIt1,helloWorld);
        testPerformance(callsCount,"doIt2", DoIt::doIt2,helloWorld);
        testPerformance(callsCount,"doIt3", DoIt::doIt3,helloWorld);
        testPerformance(callsCount,"doIt4", DoIt::doIt4,helloWorld);
    }

    private static void testPerformance(int callsCount, String name, Consumer<List<String>> fun,List<String> words) {
        long start = System.currentTimeMillis();
        for (int i = 0 ; i <callsCount; i++){
            fun.accept(words);
        }

        System.out.println("end of "+name);
        System.out.println(name+" took: "+ (System.currentTimeMillis()-start));
    }

    private static void doIt2(List<String> words) {
        words.stream().
                map(str -> str.split("")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::print);
    }


    private static void doIt3(List<String> words) {
        words.stream()
                .flatMap(str->str.chars().mapToObj(i -> (char) i))
                .distinct()
                .forEach(System.out::print);
    }

    private static void doIt4(List<String> words) {
        words.stream()
                .flatMapToInt(String::chars)
                .distinct()
                .forEach(DoIt::printAsChar);
    }

    private static void printAsChar(int c){
        System.out.print((char)c);
    }



    private static void doIt1(List<String> words) {
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
        System.out.print(strBuilder.toString());
    }


}

