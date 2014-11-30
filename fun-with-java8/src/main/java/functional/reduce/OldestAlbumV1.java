package functional.reduce;

import functional.filter.Album;

import java.util.List;
import java.util.Optional;

/**
 * @author victorp
 */
public class OldestAlbumV1 {

    public static Album oldest(List<Album> albums){
        Album currentOldest = null;
        for (Album album: albums){
          if (leftOlder(album,currentOldest)){
              currentOldest = album;
          }
        }
        return currentOldest;
    }

    public static boolean leftOlder(Album left, Album right){
        return left.getYear() < right.getYear();
    }


}
