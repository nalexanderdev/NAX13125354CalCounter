package util;

import java.text.DecimalFormat;

/**
 * Created by Nick Alexander x13125354@student.ncirl.ie on 25/2/17.
 */
public class Utils {


    public static String formatNumber( int value) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formatted = formatter.format(value);

        return formatted;
    }
}
