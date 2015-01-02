package functional.p3.i4.reduce;

import functional.p3.i1.filter.Album;

import java.util.List;

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
        return right == null || left.getYear() < right.getYear();
    }


}
