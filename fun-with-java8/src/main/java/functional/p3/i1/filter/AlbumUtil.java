package functional.p3.i1.filter;

import java.util.Collection;
import java.util.StringJoiner;

/**
 * @author victorp
 */
public class AlbumUtil {
    public static void print(Collection<?> things){
        System.out.print(format(things));
    }

    public static void println(Collection<?> things,String msg){
        System.out.println(msg);
        System.out.println(format(things));
    }

    public static String format(Collection<?> things){
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        things.forEach(thing -> stringJoiner.add(thing.toString()));
        return stringJoiner.toString();
    }

    }
