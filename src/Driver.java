import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Driver {

    //main method
    public static  void main(String[] args){

        JFrame frame = new JFrame();
        JTabbedPane tp;
        JPanel welcome, profile,home, warnings, results, contact, news ;
        frame.setSize(800,800);

        welcome = new JPanel();
        profile = new JPanel();
        home = new JPanel();
        warnings =new JPanel();
        results =new JPanel();
        contact = new JPanel();
        news = new JPanel();

        tp = new JTabbedPane();

        tp.setBounds(20,20,700,700);
        Welcome w1  = new Welcome(welcome,"Welcome");
        tp.add(w1.getTitle(),w1.getP());
        Profile p1 = new Profile(profile,"Profile", w1.getFirst(), w1.getMiddle(), w1.getLast(), w1.getMonth(),w1.getDay(),w1.getYear(),w1.getAge(),w1.getHeight(),w1.getWeight());
        tp.add(p1.getTitle(), p1.getP());
        Home h1 = new Home(home, "Home");
        tp.add(h1.getTitle(), h1.getP());
        tp.add("Warnings", warnings);
        tp.add("Results", results);
        tp.add("Contact", contact);
        tp.add("New", news);

        frame.add(tp);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);



    }
}
