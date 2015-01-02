package functional.p3.i2.search;

import functional.p3.i1.filter.Album;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static functional.p3.i1.filter.AlbumRegistry.ALBUMS;
import static functional.p3.i1.filter.AlbumUtil.println;
import static functional.p3.i2.search.Filter.byName;
import static functional.p3.i2.search.Filter.byYear;

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
