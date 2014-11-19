package functional.search;

import functional.filter.Album;

import java.util.function.Predicate;

/**
 * @author victorp
 */
public class Filter {

    public static Predicate<Album> byName(String name) {
        return new Predicate<Album>() {
            @Override
            public boolean test(Album album) {
                return album.getName().equals(name);
            }
        };
    }

    //lambda style
    public static Predicate<Album> byYear(Integer year) {
        return album -> year.equals(album.getYear());
    }

}
