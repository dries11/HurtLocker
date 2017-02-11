package ries.dan;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by danries on 2/10/17.
 */
public class GroceryEngineTest {

    GroceryEngine groceryEngine = new GroceryEngine();

    ArrayList<String[]> items = new ArrayList<String[]>();
    ArrayList<GroceryItem> list;

    @Before public void initialize(){
        String[] item = new String[]{"cookies","3.23","Food","1/26/35"};
        items.add(item);
    }

    @Test
    public void createGroceryItemTEST() throws Exception{
        String expected = "cookies";
        String actual = groceryEngine.createGroceryItems(items).get(0).getName();
        assertEquals("We expect to get the grocery item back",expected,actual);
    }

    @Before public void makeGroceryArray() throws Exception{
        list  = groceryEngine.createGroceryItems(items);
    }

    @Test
    public void insertItemsIntoMapTEST(){
        int expected = 1;
        groceryEngine.insertItemsIntoMap(list);
        int actual = groceryEngine.size();
        assertTrue(expected == actual);
    }

}
