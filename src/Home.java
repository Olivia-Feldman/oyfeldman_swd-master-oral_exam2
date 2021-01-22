import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Calendar;

public class Home extends BasePanel{
    private JPanel p = new JPanel();
    String title = "Tutorial";

    public Home(JPanel p, String title)
    {
        super(p, title);


        ClickWindow cw1 = new ClickWindow(p, title);
        cw1.setTextArea("Welcome to the Tutorial!");


        if(ClickWindow.isButtonClicked() == 1)
        {
            ClickWindow cw2 = new ClickWindow(p, title);
            cw2.setTextArea("Page 2");
        }

    }

}



