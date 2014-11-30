package functional.performance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Here we show that performance may be very bad when using flat map <br/>
 *
 * @author: Victor
 */
public class DoIt {
    public static void main(String...args){
        int callsCount = 10000;
        testPerformance(callsCount,"doIt1", DoIt::doIt1);
        testPerformance(callsCount,"doIt2", DoIt::doIt2);
        testPerformance(callsCount,"doIt3", DoIt::doIt3);
        testPerformance(callsCount,"doIt4", DoIt::doIt4);
    }

    private static void testPerformance(int callsCount, String name, Runnable fun) {
        long start = System.currentTimeMillis();
        for (int i = 0 ; i <callsCount; i++){
            fun.run();
        }

        System.out.println("end of "+name);
        System.out.println(name+" took: "+ (System.currentTimeMillis()-start));
    }

    private static void doIt2() {
        List<String> helloWorld = Arrays.asList("Hello", "World");
        helloWorld.stream().
                map(str -> str.split("")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::print);
    }


    private static void doIt3() {
        List<String> helloWorld = Arrays.asList("Hello", "World");
        helloWorld.stream()
                .flatMap(str->str.chars().mapToObj(i -> (char) i))
                .distinct()
                .forEach(System.out::print);
    }

    private static void doIt4() {
        List<String> helloWorld = Arrays.asList("Hello", "World");
        helloWorld.stream()
                .flatMapToInt(String::chars)
                .distinct()
                .forEach(DoIt::printAsChar);
    }

    private static void printAsChar(int c){
        System.out.print((char)c);
    }



    private static void doIt1() {
        StringBuilder  strBuilder = new StringBuilder();
        Set<Character> chartsSet = new HashSet<>();

        List<String> helloWorld = Arrays.asList("Hello", "World");
        for (String word: helloWorld){
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

