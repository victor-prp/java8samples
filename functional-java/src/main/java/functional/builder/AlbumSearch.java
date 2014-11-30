package functional.builder;

import functional.filter.Album;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author victorp
 */

public interface AlbumSearch {

        AlbumSearch filter(Predicate<Album> predicate);

        List<Album> all();
        Optional<Album> last(); //not supported by stream API
        Optional<Album> first();
}
