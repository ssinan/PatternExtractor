/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patternextractor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author saricas
 */
public class PatternExtractor {

    public static void main(String[] args) {
        try {
            // take the menu bar off the jframe
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            // set the name of the application menu item
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Pattern Extractor");

            // set the look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    new MainWindow().setVisible(true);
                }
            });


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatternExtractor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PatternExtractor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PatternExtractor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PatternExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
