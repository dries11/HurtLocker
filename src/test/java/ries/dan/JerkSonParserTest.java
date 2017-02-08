package ries.dan;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by danries on 2/8/17.
 */
public class JerkSonParserTest {

    JerkSonParser jerkSonParser = new JerkSonParser();

    @Test
    public void splitFileIntoPartsTest(){
        ArrayList actual = jerkSonParser.splitFileIntoParts("");
        assertTrue(actual.size() > 0);
    }

}
