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
    FormatOutput formatOutput = new FormatOutput();

    public void run(String file) throws Exception{

        ArrayList<String[]> parsed = new ArrayList<String[]>();
        ArrayList<GroceryItem> groceryItems = new ArrayList<GroceryItem>();
        HashMap<String, ArrayList<String >> pricesSeen = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> timesItemsSeen = new HashMap<String, Integer>();
        HashMap<String, Integer> timesPricesSeen = new HashMap<String, Integer>();


        String[] split =  jerkSonParser.splitFileIntoParts(file);

        parsed = jerkSonParser.parseStrings(split);

        groceryItems = groceryEngine.createGroceryItems(parsed);

        groceryEngine.insertItemsIntoMap(groceryItems);

        formatOutput.output(groceryEngine);
        System.out.println("Errors Seen: " + groceryEngine.errorCounter + " times" );



    }

}
