package dataModels;

import java.util.regex.Pattern;

/**idea of the class is to provide functionality to validate strings
 * like:
 * verify that it is hexadecimal
 * verify that it contains 0 or 1 only
 * */
public class ValidationUtils {

    public static boolean isHexadecimal(String str){
        return str.matches("^[0-9A-Fa-f]+$");
    }

    public static boolean is01(String str){
        return str.matches("^[0-1]+$");
    }
}
