package functional.search;

import functional.filter.Album;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static functional.filter.AlbumRegistry.ALBUMS;
import static functional.filter.AlbumUtil.println;
import static functional.search.Filter.byName;
import static functional.search.Filter.byYear;

/**
 * @author victorp
 */
public class SearchAlbum_V2 {

    public static List<Album> searchByPredicate(List<Album> customers, Predicate<Album> predicate){
        return customers.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        println(
                searchByPredicate(  ALBUMS,
                                    byName("The Wall")),
                                    "(v2) searchByName:");

        System.out.println();

        println(
                searchByPredicate(  ALBUMS,
                                    byYear(1977)) ,
                                    "(v2) searchByYear:");

        System.out.println();

        println(
                searchByPredicate(  ALBUMS,
                                     album -> album.getUkChart() == 1),
                                    "(v2) searchByUkChart:");

    }
}
