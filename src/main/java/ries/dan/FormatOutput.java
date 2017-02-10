package ries.dan;

import java.util.ArrayList;
import java.util.Formatter;

/**
 * Created by danries on 2/8/17.
 */
public class FormatOutput {

    String breakline = "============";

    public String format(String input){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input);
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("%-30.30s %-30.30s");
        return stringBuilder.toString();
    }

}
