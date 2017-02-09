package ries.dan;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by danries on 2/8/17.
 */
public class JerkSonParserTest {

    String[] arrayOfGroceryItemsInString = new String[]{"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016","naME:BreaD;price:1.23;type:Food;expiration:1/02/2016","NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016"};

    JerkSonParser jerkSonParser = new JerkSonParser();

    @Test
    public void splitFileIntoPartsTest(){
        String[] actual = jerkSonParser.splitFileIntoParts("NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##");
        assertTrue(actual.length == 3);
    }

    @Before public void initialize(){


    }

    @Test
    public void createGroceryItems(){
        ArrayList<String[]> groceryItems = jerkSonParser.parseStrings(arrayOfGroceryItemsInString);
        assertTrue(groceryItems.size() == 3);
    }

    ArrayList<String[]> groceryItems;

    @Before public void createArrayToInsertinMap(){
        groceryItems = jerkSonParser.parseStrings(arrayOfGroceryItemsInString);
    }

    @Test
    public void insertItesmIntoMapTest(){

    }

}
