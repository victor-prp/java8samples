package functional.filter;

import java.util.Arrays;
import java.util.List;

import static functional.filter.Album.album;

/**
 * @author victorp
 */
public class AlbumRegistry {
    public static final List<Album> ALBUMS = Arrays.asList(
            album("The dark Side Of The Moon", 1973, 1,1),
            album("The Wall", 1979, 1,5),
            album("Animals", 1977, 2,1),
            album("Wish You Were Here", 1977, 1,1),
            album("More", 1969, 10,2)
    );
}
