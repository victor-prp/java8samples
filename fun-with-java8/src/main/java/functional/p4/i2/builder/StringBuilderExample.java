package functional.p4.i2.builder;

import static functional.p3.i1.filter.AlbumRegistry.ALBUMS;
import static functional.p3.i1.filter.AlbumUtil.println;
import static functional.p4.i2.builder.AlbumSearchImpl.search;
import static java.lang.System.out;

/**
 * @author victorp
 */
public class StringBuilderExample {

    public static void main(String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("let's ")
                .append("build ")
                .append("string ")
                .append("step ")
                .append("by ")
                .append("step");

        String result = stringBuilder.toString();
        System.out.println(result);
    }


}
