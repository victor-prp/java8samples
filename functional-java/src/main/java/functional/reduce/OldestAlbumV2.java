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
        if (left.getYear() < right.getYear()){
            return left;
        }else{
            return right;
        }
    }


}
