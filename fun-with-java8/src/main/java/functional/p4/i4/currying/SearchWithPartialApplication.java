package functional.p4.i4.currying;

import functional.p3.i1.filter.Album;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static functional.p3.i1.filter.AlbumRegistry.ALBUMS;
import static functional.p3.i1.filter.AlbumUtil.println;


/**
 * @author victorp
 */
public class SearchWithPartialApplication {
    public static List<Album> search(List<Album> albums,
                                     Predicate<Album> predicate){
        return albums.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static void main(String... args){
        println(
                search(ALBUMS,
                        toPredicate(SearchWithPartialApplication::match,
                                    "The Wall")),
                "search with partial application");
    }

    public static boolean match(Album album, String name){
        return album.getName().equals(name);
    }

    public static <T,P> Predicate<T> toPredicate(BiFunction<T,P,Boolean> fun,
                                                 P curried ){
        return t -> fun.apply(t,curried);
    }
}
