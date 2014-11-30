package functional.reduce;

import functional.filter.Album;

import java.util.List;

/**
 * @author victorp
 */
public class OldestAlbumV2 {

    public static Album oldest(List<Album> albums){
        return albums
                .stream()
                    .reduce(OldestAlbumV2::older)
                    .get();
    }

    public static Album older(Album left, Album right){
        return left.getYear() < right.getYear() ? left : right;
    }


}
