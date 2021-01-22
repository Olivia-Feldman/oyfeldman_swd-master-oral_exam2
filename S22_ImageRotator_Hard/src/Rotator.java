


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFrame;
import  javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.Timer;

/**
 * @author Olivia Feldman
 * @Use The purpose of this program is to create a GUI that rotates a image
 * the program allows the user to enter in a value in degrees to rotate the image by this amount
 * the program also allows the user to continuously rotate the image by a default speed or the user has the capability to
 * increase or decrease the speed dynamically
 */

public class Rotator extends JFrame {

    /**
     * panel p is used to draw GUI components onto
     */
    private JPanel p;
    /**
     *  is a JButton used to activate an action from the user to input rotation value
     */
    private JButton start;
    /**
     * Jbutton to allow user to rotate button continuously
     */
    private JButton continuous;
    /**
     * Jbutton used to stop the continuous rotation of the image
     */
    private JButton stop;
    /**
     * jButton to dynamically change the rotation speed to increase
     */
    private JButton faster;
    /**
     * slower jbnutton allows user to decrease the rotation speed dynamically
     */
    private JButton slower;
    /**
     * JTextField to allow user to input the rotation value into a textfield
     */
    private JTextField rotate;
    /**
     * imagelabel is a label to show image on
     */
    private JLabel imageLabel;
    /**
     * guide label is used to guide user throw the GUI and display a message if they enter in something wrong
     */
    private JLabel guide;
    /**
     * bug is the buffered image variable that stores the image to be rotated
     */
    private BufferedImage bug;
    /**
     * image is an imageicon that will be displayed on the imagelabel with the image
     */
    private ImageIcon image;
    /**
     * graphics i draws the image using the painComponent method
     */
    private Graphics i;

    /**
     * timer is user to continuously rotate the image by re-initializing it's self every 100 ms
     */
    private Timer timer;
    /**
     * default speed the image will start rotating until the user presses the faster or slower buttion
     */
    private double default_speed =5;
    /**
     *
     */
    private double degree_Rotate;

    /**
     * this speed will be changed by user
     * @return returns default speed
     */
    public double getDefault_speed() {
        return default_speed;
    }

    /**
     * sets default speed
     * @param default_speed
     */
    public void setDefault_speed(double default_speed) {
        this.default_speed = default_speed;
    }

    /**
     *returns the degree to be rotated by the user
     * @return degree_Rotate
     */

    public double getDegree_Rotate() {
        return degree_Rotate;
    }

    /**
     * sets degree_Rotator speed
     * @par degree_Rotate
     */
    public void setDegree_Rotate(Double degree_Rotate) {
        this.degree_Rotate = degree_Rotate;
    }

    /**
     * Rotator constructor initializes and implements the panel and GUI components
     *
     * @throws IOException will print an error if file can't be read
     */

    public Rotator() throws IOException {

        //try and catch statement to read in file and throws an error in catch statement
        try {
            BufferedImage bug = ImageIO.read(new File("/user/o/oyfeldman/Desktop/oyfeldman_swd/oral_exam2/S22_ImageRotator_Hard/src/bug.png"));
        } catch (IOException e) {
            System.out.println("error opening file");//printing out error
        }

        p = new JPanel(); //creating a new panel for GUI
        setLayout(new FlowLayout());// setting a flowlayout for an organized layout of GUI
        setTitle("Image Rotator"); //setting title on Panel
        image = new ImageIcon(getClass().getResource("bug.png"), null);//creating a new ImageIcon from image from file
        imageLabel = new JLabel(image) { //creating a new image label for the imageIcon
            /**
             * override the paintComponent method from the super class to draw the image to panel
             * method also will draw the new rotated image
             * @param i is Graphcis i object to draw image
             */
            @Override  //Override to tell the compiler to go and look for this method in the superclass and make sure it's there
            public void paintComponent(Graphics i) {
                //if statements to determine if the image will not be rotated
                if (degree_Rotate == 0) { // image with no rotation a
                    i.drawImage(image.getImage(), 0, 0, null);
                }
                if (degree_Rotate > 0) { //image with rotation
                    Graphics2D i2d = (Graphics2D) i;//casts graphics i to Graphics2Dge are
                    //using rotate method to rotate image with the value of getDegreee and the coordinates of the center of image are given to rotate about
                    i2d.rotate(Math.toRadians(getDegree_Rotate()), image.getIconWidth() / 2.0, image.getIconHeight() / 2.0);
                    i2d.drawImage(image.getImage(), 0, 0, null); //draws new image
                }


            }
        };

        start = new JButton("Start");  //creating a new JButton for user to insert degrees
        start.addActionListener(new startListener());  //actionlistener for start button
        start.setEnabled(true);  //enabling the start button for the action listener
        continuous = new JButton("Continuous"); //creating a new continuous button for user to decide to rotate continuously
        continuous.addActionListener(new continuousListener());  //linking the actionlistener to the private listener class
        stop = new JButton("Stop"); //creating a stop button to terminate the continuous rotation
        stop.addActionListener(new stopListener()); //linking the actionlistener to the private listener class
        faster = new JButton("Faster"); //creating a faster button to increase the speed of rotation
        faster.addActionListener(new continuousListener()); //linking actionlistener to private class
        slower = new JButton("Slower"); //creating a slow button to slow down the rotation speed
        slower.addActionListener(new continuousListener()); //linking actionlistener to private class
        guide = new JLabel("Doing Well so far"); //creating a guide label to display any mistakes the user may make
        rotate = new JTextField(10);    //new JtextField to read in the user rotation input
        timer = new Timer(100, new continuousListener()); // time to use to continuously rotate the image, setting 100 millseconds
        setDegree_Rotate(0.0); //default degrees to rotate will be a 0.0 double value
        //adding GUI components to the pannel
        add(p);
        add(guide);
        add(rotate);
        add(start);//
        add(continuous);
        add(stop);
        add(faster);
        add(slower);
        p.add(imageLabel);
        imageLabel.repaint();//calling paintComponent method to draw image
        setVisible(true); //setting the panel visible
        setSize(new Dimension(500, 500)); //setting the dimensions of the panel
        setDefaultCloseOperation(EXIT_ON_CLOSE); // on exit the program will terminate
    }


    /**
     * Private class implement the actions for start button
     */
    private class startListener implements ActionListener {
        /**
         * method implements the action for start button and will rotate the image with the user input
         * @param h
         */
        public void actionPerformed(ActionEvent h) {
            String string = rotate.getText();
            //checks to see if textfield is empty
            if (string.isEmpty()){
                guide.setText("Please enter a rotation!"); //reset the guide label to direct user
            }
            else {

                guide.setText("Doing Great So far");
                Double degree = Double.valueOf(rotate.getText()); //converts string value into a double
                setDegree_Rotate(degree); //re-initializes the degrees

            }

            imageLabel.repaint(); //calls repaint to redraw the rotate image
        }

    }

    /**
     * private class for continuous button, faster button and slower button actionListener implementation
     */
    private class continuousListener implements ActionListener {
        /**
         * perfroms the action for continuous,faster and slower button  for event h
         * @param h ActionEvent h
         */
        public void actionPerformed(ActionEvent h) {
            timer.start(); //begins timer and will restart after 100 ms
            start.setEnabled(false); //sets start button to false so user can't enter in a input
            if(h.getSource()==faster){
                setDefault_speed(getDefault_speed()+1);
            }
            if(h.getSource()==slower){
                if (getDefault_speed()== 0){
                    timer.stop();
                }
                setDefault_speed(getDefault_speed()-1);
            }
            //re-initializes the speed
            setDegree_Rotate(getDefault_speed()+ getDegree_Rotate());
            imageLabel.repaint();
        }

    }

    /**
     * Private class for stop button for event h
     */
    private class stopListener implements ActionListener {
        /**
         * method performs action for stop button
         * @param h ActionEvent h
         */
        public void actionPerformed(ActionEvent h) {
            timer.stop(); //stops the time for rotation to stop
            start.setEnabled(true);//enables the start button for user to use
        }
    }

}
