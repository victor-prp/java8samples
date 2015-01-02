package functional.p4.i2.builder;

import static functional.p4.i2.builder.AlbumSearchImpl.search;
import static functional.p3.i1.filter.AlbumRegistry.ALBUMS;
import static functional.p3.i1.filter.AlbumUtil.println;
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

