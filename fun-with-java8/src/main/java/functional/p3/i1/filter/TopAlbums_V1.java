package functional.p3.i1.filter;

import java.util.LinkedList;
import java.util.List;

import static functional.p3.i1.filter.AlbumUtil.println;

/**
 * @author victorp
 */


public class TopAlbums_V1 {
    public static final List<Album> ALBUMS = AlbumRegistry.ALBUMS;

    public static List<Album> topUKandUS() {
        List<Album> hits = new LinkedList<>();
        for (Album album : ALBUMS) {
            if (album.ukChart == 1 && album.usChart == 1) {
                hits.add(album);
            }
        }
        return hits;
    }


    public static void main(String... args) {
        println(topUKandUS(), "(v1) topUKandUS:");
    }
}


