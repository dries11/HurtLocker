package ries.dan;

import org.apache.commons.io.IOUtils;

public class Main {



    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();
        String output = (new Main()).readRawDataToString();
        controller.run(output);


    }
}
