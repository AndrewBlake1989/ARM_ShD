package ua.andrewblake.utils;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SkinUtil {

    public static void changeSkin(Component comp, LookAndFeel laf){
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(SkinUtil.class.getName()).log(Level.SEVERE, null, ex);
            // NOP
            return;
        }
        SwingUtilities.updateComponentTreeUI(comp);
    }

    public static void changeSkin(Component comp, String s){
        try {
            UIManager.setLookAndFeel(s);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(SkinUtil.class.getName()).log(Level.SEVERE, null, ex);
            // NOP
            return;
        }
        SwingUtilities.updateComponentTreeUI(comp);
    }
}