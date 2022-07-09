package club.beimeng.book_manage_keshe.utils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class EmailUtils {

    public static boolean isEmail(String str) {
        return Pattern.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", str);
    }

    public static String blur(String toEmail) {

        String str = toEmail.split("@")[0];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i >= chars.length / 2) {
                chars[i] = '*';
            }
        }
        String suffix = toEmail.split("@")[1];

        StringBuilder str2 = new StringBuilder();
        for (char aChar : chars) {
            str2.append(aChar);
        }
        return str2 + suffix;
    }
}
