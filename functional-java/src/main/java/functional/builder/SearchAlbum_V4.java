package functional.builder;

import functional.filter.Album;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static functional.builder.AlbumSearchImpl.search;
import static functional.filter.AlbumRegistry.ALBUMS;
import static functional.filter.AlbumUtil.println;
import static functional.search.Filter.byName;
import static functional.search.Filter.byYear;
import static java.lang.System.out;

/**
 * @author victorp
 */
public class SearchAlbum_V4 {

    public static void main(String... args) {
        println(
                search(ALBUMS)
                        .filter(album -> album.getName().startsWith("T"))
                        .filter(album -> album.getYear() > 1917)
                        .all(),
                "(v4) searchByNameAndYear:");
        out.println();

        out.println(
                "(v4) get last where year > 1917: \n" +
                search(ALBUMS)
                        .filter(album -> album.getYear() > 1917)
                        .last()
                        .get()
        );
    }
}

