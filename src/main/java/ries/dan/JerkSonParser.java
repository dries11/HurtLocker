package ries.dan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by danries on 2/8/17.
 */
public class JerkSonParser{

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
        Pattern name = Pattern.compile("[A-Za-z\\d]+");
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
                if (nameOfItem.group().matches("(?i)c.+s")){
                    itemName = "cookies";
                }
                else{
                    itemName = nameOfItem.group();
                }

                itemPrice = priceOfItem.group();
                itemType = typeOfItem.group().split(":");
                typer = itemType[1];
                expirationDate = dateOfItem.group();
            }
            if (itemName.equals("price") || itemName.equals("name") || itemPrice.equals("type") || itemName.equals("")){
                errorCounter++;
                itemName = "";
                itemPrice = "";
                typer = "";
                expirationDate = "";
            }
            else{
                String[] itemInfo = new String[]{itemName,itemPrice,typer,expirationDate};
                list.add(itemInfo);
                itemName = "";
                itemPrice = "";
                typer = "";
                expirationDate = "";
            }


        }
        return list;
    }

    public int getErrorCounter() {
        return errorCounter;
    }
}
