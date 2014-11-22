package functional.performance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;



/**
 * Here we show that performance may be very bad when using flat map <br/>
 *
 * @author: Victor
 */
public class FlatMap{
    public static void main(String...args){
        int itrCount = 10000;
        long start = System.currentTimeMillis();
        for (int i = 0 ; i <itrCount; i++){
            helloWorld1();
        }

        System.out.println("end of first");
        System.out.println("first took: "+ (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        for (int i = 0 ; i <itrCount; i++){
            helloWorld2();
        }

        long mid2 = System.currentTimeMillis();
        System.out.println("end of second");
        System.out.println("second took: "+ (System.currentTimeMillis()-start));


        for (int i = 0 ; i <itrCount; i++){
            helloWorld3();
        }

        System.out.println("end of third");
        System.out.println("third took: "+ (System.currentTimeMillis()-start));

    }

    private static void helloWorld2() {
        List<String> helloWorld = Arrays.asList("Hello", "World");
        helloWorld.stream().
                map(str -> str.split("")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::print);
    }


    private static void helloWorld3() {
        List<String> helloWorld = Arrays.asList("Hello", "World");
        helloWorld.stream()
                .flatMap(str->str.chars().mapToObj(i -> (char) i))
                .distinct()
                .forEach(System.out::print);
    }

// The following code does not compile. We cannot combine IntStream with Generic streams :(
//    private static void helloWorld4() {
//        List<String> helloWorld = Arrays.asList("Hello", "World");
//        helloWorld.stream()
//                .flatMap(String::chars)
//                .distinct()
//                .forEach(System.out::print);
//    }



    private static Stream<Character> stream(String str){
        return str.chars()
                .mapToObj(i -> (char) i);
    }

    private static void helloWorld1() {
        StringBuilder  helloWorldUniqueChars = new StringBuilder();
        Set<Character> helloWorldUniqueCharsSet = new HashSet<>();

        List<String> helloWorld = Arrays.asList("Hello", "World");
        for (String word: helloWorld){
            for (char singleChar : word.toCharArray())  {
                if (!helloWorldUniqueCharsSet.contains(singleChar)){
                    helloWorldUniqueChars.append(singleChar);
                    helloWorldUniqueCharsSet.add(singleChar);
                }
            }
        }

        System.out.print(helloWorldUniqueChars.toString());
    }
}

