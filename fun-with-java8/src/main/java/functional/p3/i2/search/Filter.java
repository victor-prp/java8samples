package functional.p3.i2.search;

import functional.p3.i1.filter.Album;

import java.util.function.Predicate;

/**
 * @author victorp
 */
public class Filter {

    public static Predicate<Album> byName(String name) {
        return album -> album.getName().equals(name);
    }

    //lambda style
    public static Predicate<Album> byYear(Integer year) {
        return album -> year.equals(album.getYear());
    }

}
