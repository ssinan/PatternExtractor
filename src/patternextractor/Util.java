/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patternextractor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author saricas
 */
public class Util {
    
    private static boolean LOGGING_ON = false;
    
    public static void log(Object klass, String string) {
        if (LOGGING_ON) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date) + " " + klass.getClass().toString() + ": " + string);
        }
    }
    
}
