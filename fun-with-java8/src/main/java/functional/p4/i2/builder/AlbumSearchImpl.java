package functional.p4.i2.builder;

import functional.p3.i1.filter.Album;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author victorp
 */
public class AlbumSearchImpl implements AlbumSearch {
    private final Stream<Album> albums;

    public static AlbumSearch search(List<Album> albums){
        return new AlbumSearchImpl(albums.stream());
    }

    public AlbumSearchImpl(Stream<Album> albums) {
        this.albums = albums;
    }


    @Override
    public AlbumSearch filter(Predicate<Album> predicate) {
        return new AlbumSearchImpl(albums.filter(predicate));
    }

    @Override
    public List<Album> all() {
        return albums.collect(Collectors.toList());
    }

    @Override
    public Optional<Album> last() {
        //very not efficient
        return albums.reduce((l,r)->r);
    }

    @Override
    public Optional<Album> first() {
        return albums.findFirst();
    }
}
