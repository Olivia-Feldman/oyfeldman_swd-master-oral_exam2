import javax.swing.*;
import java.awt.*;

/**
 * @author: Olivia Feldman
 * class used to create a Frame for GUI to be added
 * and test orbiting class
 */
public class Driver {
    /**
     * main method that creates a new MyJpanel object and runs the GUI
     * @param args
     */
    public static void main (String[] args) {
        /**
         * new JFrame for MyJPanel to be added
         */
        JFrame f = new JFrame();
        MyJPanel test = new MyJPanel();
        f.add(test);
        f.setSize(1200,900);
        f.setBackground(Color.BLACK);
        f.setTitle("Welcome to Liv's Solar System");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
