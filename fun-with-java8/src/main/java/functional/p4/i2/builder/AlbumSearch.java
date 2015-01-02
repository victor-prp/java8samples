package functional.p4.i2.builder;

import functional.p3.i1.filter.Album;

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
