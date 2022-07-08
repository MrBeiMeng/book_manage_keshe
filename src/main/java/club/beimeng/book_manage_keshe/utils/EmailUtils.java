package club.beimeng.book_manage_keshe.utils;

import java.util.regex.Pattern;

public class EmailUtils {

    public static boolean isEmail(String str) {
        return Pattern.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", str);
    }
}
