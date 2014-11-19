package functional.filter;

import java.util.LinkedList;
import java.util.List;

import static functional.filter.AlbumUtil.println;

/**
 * @author victorp
 */
public class TopAlbums_V1 {
    public static List<Album> topUKandUS(List<Album> albums){
        List<Album> hits = new LinkedList<>();
        for (Album album: albums){
            if (album.ukChart == 1 && album.usChart == 1){
                hits.add(album);
            }
        }
        return hits;
    }

    public static void main(String... args) {
        println(topUKandUS(AlbumRegistry.ALBUMS), "(v1) topUKandUS:");
    }
}


