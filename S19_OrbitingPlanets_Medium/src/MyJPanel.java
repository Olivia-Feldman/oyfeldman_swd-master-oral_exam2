

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MyJpanel Class creates Gui of orbiting planets using multithreading
 * up to 8 planets can be added to gui to orbit the sun.
 */
public class MyJPanel extends JPanel implements ActionListener {
    /**
     * Array list to store planet objects in
     */
    private ArrayList<Orbiting> planets;
    /**
     * A timer to have the paint function continuously paint
     */
    private Timer timer;
    /**
     * es a new scheduled thread pool that creates a thread pool
     * that can schedule commands to run after a certain time
     */
    private ExecutorService es = Executors.newCachedThreadPool();
    /**
     * Graphics g is used to paint ovals onto the gui
     */
    private Graphics g;
    /**
     * p is a Jpanel to be added to the Frame in main and to paint the planets and sun
     */
    private JPanel p;

    /**
     * MyJPanel constructor implements the GUI and adds the action listners
     * to a Mouseclicked event.
     */
    public MyJPanel() {

         p = new JPanel();
        timer = new Timer(200, new Timer1());// intitializing the timer with a delay and event
        add(p);
        setLayout(new FlowLayout());// setting a flowlayout for an organized layout of GUI
        setSize(1000, 800);
        setBackground(Color.BLACK);
        planets = new ArrayList<Orbiting>();

        //creates a new mouse event listener to add planets the array list
        //and starts the time to update the paint function and calls the run method in Orbiting class
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (  planets.size()< 8) {
                    Random rand = new Random();
                    Color randomColor = new Color(rand.nextInt());
                    Orbiting p = new Orbiting(rand.nextInt(400)+50, rand.nextInt(400)+50,10,randomColor);
                    planets.add(p);
                    timer.start();
                    es.execute(p);
                }

            }
        });



        setVisible(true);
    }

    /**
     * must overide the actionperformed method in the super class
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {


    }

    /**
     * Timer method calls update method to repaint sun and planets
     *
     */
    private class Timer1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    }

    /**
     * Method update is needed so the repaint can be called indirectly
     *
     */
    public void update(){
        //starts the timer
        timer.start();
        //paints graphics to panel
        this.repaint();

    }

    /**
     * paintComponent method overrides the super class method and creates
     * a sun and planets from arraylist
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //oval for sun
        g.setColor(Color.YELLOW);
        g.fillOval(400,400,100,100);

        //oval for planets
        for(Orbiting p :planets){
            g.setColor(p.getColor());
           g.fillOval(p.getX(),p.getY(),30,25);

        }


    }

}
