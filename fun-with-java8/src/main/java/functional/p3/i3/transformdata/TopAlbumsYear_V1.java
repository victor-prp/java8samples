package functional.p3.i3.transformdata;

import functional.p3.i1.filter.Album;
import functional.p3.i1.filter.AlbumRegistry;
import functional.p3.i1.filter.TopAlbums_V3;

import java.util.LinkedList;
import java.util.List;

import static functional.p3.i1.filter.AlbumUtil.println;

/**
 * @author victorp
 */
public class TopAlbumsYear_V1 {

    public static List<Integer> topUKandUS_Year(List<Album> albums) {
        List<Album> hits = TopAlbums_V3.topUKandUS(albums);

        List<Integer> result = new LinkedList<>();
        hits.forEach((hit) -> result.add(hit.getYear()));

        return result;
    }

    public static void main(String... args) {
        println(topUKandUS_Year(AlbumRegistry.ALBUMS), "(v1) topUKandUS Years:");
    }
}
