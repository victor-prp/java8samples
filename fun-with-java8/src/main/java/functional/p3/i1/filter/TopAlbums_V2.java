package functional.p3.i1.filter;

import java.util.List;

import static functional.p3.i1.filter.AlbumUtil.println;
import static java.util.stream.Collectors.toList;

/**
 * @author victorp
 */
public class TopAlbums_V2 {
    public static List<Album> topUKandUS(List<Album> albums){
        return albums
                .stream()
                .filter( album ->album.ukChart == 1 && album.usChart == 1)
                .collect(toList());
    }


    public static void main(String... args) {
        println(topUKandUS(AlbumRegistry.ALBUMS), "(v2) topUKandUS:");
    }
}

