package ries.dan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by danries on 2/8/17.
 */
public class JerkSonParser extends HashMap<String,ArrayList<GroceryItem>>{

    public int errorCounter;

    String name = "^\\w+";
    String seperators = "\\W";


    public String[] splitFileIntoParts(String file){
        String[] items = (file.split("##"));
        return items;
    }

    public ArrayList<String[]> parseStrings(String[] items){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String itemName = "";
        String itemPrice = "";
        String[] itemType;
        String expirationDate = "";
        String typer = "";

        Pattern price = Pattern.compile("(\\d+)\\.(\\d+)");
        Pattern date = Pattern.compile("(\\d+)/(\\d+)/(\\d+)");
        Pattern name = Pattern.compile("[A-Za-z]+");
        Pattern type = Pattern.compile("(type:)\\w+");

        int i = 0;
        while (i < items.length){
            Matcher priceOfItem = price.matcher(items[i]);
            Matcher dateOfItem = date.matcher(items[i]);
            Matcher nameOfItem = name.matcher(items[i]);
            Matcher typeOfItem = type.matcher(items[i]);

            i++;

            nameOfItem.replaceFirst("");

            while(priceOfItem.find() && nameOfItem.find() && dateOfItem.find() && typeOfItem.find()){
                itemName = nameOfItem.group();
                itemPrice = priceOfItem.group();
                itemType = typeOfItem.group().split(":");
                typer = itemType[1];
                expirationDate = dateOfItem.group();
            }
            String[] itemInfo = new String[]{itemName,itemPrice,typer,expirationDate};
            list.add(itemInfo);

        }
        return list;
    }

    public void insertItemsIntoMap(ArrayList<GroceryItem> groceryItems){
        for (GroceryItem item : groceryItems){
            if (this.containsKey(item.name)){
                this.get(item.name).add(item);
            }
            else{
                ArrayList<GroceryItem> items = new ArrayList<GroceryItem>();
                items.add(item);
                this.put(item.name,items);
            }
        }
    }
}
