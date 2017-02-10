package ries.dan;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;

/**
 * Created by danries on 2/8/17.
 */
public class FormatOutput {

    String breakline = "============";

    public String format(ArrayList<String> input){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input);
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("%-30.30s %-30.30s");
        return stringBuilder.toString();
    }

    public ArrayList<String[]> turnDataIntoOneString(HashMap<String, Integer> timesItemSeen, HashMap<String, Integer> timesPriceSeen, HashMap<String, ArrayList<String>> differentPricesSeen){
        ArrayList<String[]> itemsInfo = new ArrayList<String[]>();
        for (String key : timesItemSeen.keySet()){

        }
        return null;
    }

}
