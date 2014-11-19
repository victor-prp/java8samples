package functional.filter;

import java.util.List;

import static functional.filter.AlbumUtil.println;
import static java.util.stream.Collectors.*;

/**
 * @author victorp
 */
public class TopAlbums_V3 {
    public static List<Album> topUKandUS(List<Album> albums){
        return albums
                .stream()
                .filter(TopAlbums_V3::hitAlbum)
                .collect(toList());

    }

    public static boolean hitAlbum(Album albums) {
        return albums.ukChart == 1 && albums.usChart == 1;
    }


    public static void main(String... args) {
        println(topUKandUS(AlbumRegistry.ALBUMS), "(v3) topUKandUS:");
    }
}
