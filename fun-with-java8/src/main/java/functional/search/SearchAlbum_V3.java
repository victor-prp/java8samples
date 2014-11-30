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
public class SearchAlbum_V3 {

    public static List<Album> search(List<Album> albums,
                                     Predicate<Album> predicate){
        return albums.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        println(
                search(ALBUMS,
                        byName("The Wall")),
                        "(v2) searchByName:");

        System.out.println();

        println(
                search(ALBUMS,
                        byYear(1977)) ,
                "(v2) searchByYear:");

        System.out.println();

        println(
                search(ALBUMS,
                        album -> album.getUkChart() == 1),
                "(v2) searchByUkChart:");

    }
}
