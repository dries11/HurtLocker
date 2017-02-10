package ries.dan;

import com.sun.applet2.AppletParameters;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by danries on 2/9/17.
 */
public class Controller {

    JerkSonParser jerkSonParser = new JerkSonParser();
    GroceryEngine groceryEngine = new GroceryEngine();

    public void run(String file) throws KeyNotAssociatedWithValueException{

        ArrayList<String[]> parsed = new ArrayList<String[]>();
        HashMap<String, ArrayList<String >> pricesSeen = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> timesItemsSeen = new HashMap<String, Integer>();
        HashMap<String, Integer> timesPricesSeen = new HashMap<String, Integer>();

        parsed = jerkSonParser.parseStrings(jerkSonParser.splitFileIntoParts(file));

        groceryEngine.insertItemsIntoMap(groceryEngine.createGroceryItems(parsed));

        pricesSeen = groceryEngine.getPricesSeen();
        timesItemsSeen = groceryEngine.getTimesItemSeen();
        timesPricesSeen = groceryEngine.getTimesPricesSeen();



    }

}
