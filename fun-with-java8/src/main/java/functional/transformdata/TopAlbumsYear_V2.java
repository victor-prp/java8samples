package functional.transformdata;

import functional.filter.Album;
import functional.filter.AlbumRegistry;
import functional.filter.TopAlbums_V3;

import java.util.List;

import static functional.filter.AlbumUtil.println;
import static java.util.stream.Collectors.toList;

/**
 * @author victorp
 */
public class TopAlbumsYear_V2 {

    public static List<Integer> topUKandUS_Year(List<Album> albums) {
        return albums
                .stream()
                .filter(TopAlbums_V3::hitAlbum)
                .map(Album::getYear)
                .collect(toList());
    }

    public static void main(String... args) {
        println(topUKandUS_Year(AlbumRegistry.ALBUMS), "(v2) topUKandUS Years:");
    }
}

