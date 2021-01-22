import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.plaf.FontUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */


 abstract class BasePanel extends JFrame implements ActionListener {

    private JPanel p;
    private String title;
    private JButton logout,b1, b2, b3, b4, b5;

    BasePanel(JPanel p, String title) {

        setP(p);
        setTitle(title);
        p.setBackground(Color.WHITE);
        p.setFont(new Font("TimesRoman", FontUIResource.BOLD,40));


    }

    public JPanel getP() {
        return p;
    }

    public void setP(JPanel p) {
        this.p = p;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public void actionPerformed(ActionEvent e){};
}
