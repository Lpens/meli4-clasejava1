package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) throws FileNotFoundException {


        Object o = null;
        Properties preferences = new Properties();
        FileInputStream in = new FileInputStream("MiFactory.properties");
        try {
            preferences.load(in);

            String name = preferences.getProperty(objName);
            Class c = null;
            try {
                Constructor cst;
                o = Class.forName(preferences.getProperty(objName)).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                // There may be other exceptions to throw here,
                // but I'm writing this from memory.
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return o;
    }
}
