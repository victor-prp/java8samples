package functional.p3.i3.transformdata;

import functional.p3.i1.filter.Album;
import functional.p3.i1.filter.AlbumRegistry;
import functional.p3.i1.filter.TopAlbums_V3;

import java.util.List;

import static functional.p3.i1.filter.AlbumUtil.println;
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

