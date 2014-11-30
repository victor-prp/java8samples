package functional;

/**
 * @author victorp
 */
public class Util {
    public static void println(Object objToPrint, Object... paramsToFormat){
        if (paramsToFormat == null || paramsToFormat.length ==0){
            System.out.println(objToPrint.toString());
        }else{
            System.out.println(String.format(objToPrint.toString(),paramsToFormat));
        }
    }
}
