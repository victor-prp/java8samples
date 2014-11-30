package functional.filter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static functional.filter.Album.album;
import static functional.filter.AlbumUtil.println;

/**
 * @author victorp
 */


public class TopAlbums_V1 {
    public static final List<Album> ALBUMS = Arrays.asList(
            album("The dark Side Of The Moon", 1973, 1, 1),
            album("The Wall", 1979, 1, 5),
            album("Animals", 1977, 2, 1),
            album("Wish You Were Here", 1977, 1, 1),
            album("More", 1969, 10, 2)
    );

    public static List<Album> topUKandUS() {
        List<Album> hits = new LinkedList<>();
        for (Album album : ALBUMS) {
            if (album.ukChart == 1 && album.usChart == 1) {
                hits.add(album);
            }
        }
        return hits;
    }

}


//    public static void main(String... args) {
//        println(topUKandUS(), "(v1) topUKandUS:");
//    }
//}


