import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickWindow extends JFrame{
    private JPanel p = new JPanel();
    private static JTextArea textArea = new JTextArea(15, 50);
    private static JButton button = new JButton("Next ->");
    private JFrame frame = new JFrame("Test");
    private JPanel inputpanel = new JPanel();
    private static int buttonClicked = 0;

    public ClickWindow(JPanel p, String title)
    {
        p.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setOpaque(true);


        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(Font.getFont(Font.SANS_SERIF));

        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        inputpanel.setLayout(new FlowLayout());
        //JTextField input = new JTextField(20);


        p.add(scroller);
        //inputpanel.add(input);
        inputpanel.add(button);
        p.add(inputpanel);

        frame.getContentPane().add(BorderLayout.CENTER, p);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        //input.requestFocus();

        // register event handlers
        TextFieldHandler handler = new TextFieldHandler();
        button.addActionListener(handler);

    }

    public void setTextArea(String text)
    {
        textArea.setText(text);

    }

    private class TextFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == button)
            {
                buttonClicked = 1;
                System.out.printf(String.valueOf(buttonClicked));
                repaint();
                getContentPane().setBackground(Color.LIGHT_GRAY);
                textArea.setText("Page 2");

            }
        }


    }

    public static int isButtonClicked()
    {
        return buttonClicked;
    }


}
