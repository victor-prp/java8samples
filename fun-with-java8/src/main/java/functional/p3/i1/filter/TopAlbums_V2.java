package functional.p3.i1.filter;

import java.util.LinkedList;
import java.util.List;

import static functional.p3.i1.filter.AlbumUtil.println;
import static java.util.stream.Collectors.toList;

/**
 * @author victorp
 */
public class TopAlbums_V2 {


    public static List<Album> topUKandUS(List<Album> albums) {
        List<Album> hits = new LinkedList<>();
        for (Album album : albums) {
            if (album.ukChart == 1 && album.usChart == 1) {
                hits.add(album);
            }
        }
        return hits;
    }


    public static void main(String... args) {
        println(topUKandUS(AlbumRegistry.ALBUMS), "(v2) topUKandUS:");
    }
}

