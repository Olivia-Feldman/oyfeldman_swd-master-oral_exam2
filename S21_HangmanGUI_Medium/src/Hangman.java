






import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * @author: olivia Feldman
 * @use: this program implements a hangman GUI game using the graphics class to draw lines and ovals for game
 */
public class Hangman extends JFrame implements ActionListener {
    /**
     * @lifeCount: used to store the users life; user will be give 6 to start with
     * @saveWord: used to store the word the user inputs to gues
     * @hidden: string to hide the actual word letter from user; it will display a string of ? the same length as the word
     * @guess: label to show user where the hidden word is
     * @enter1: enter button to create a action listener and event with the button
     * @enter2: enter button to create a action listener and event with the button
     * @hiddenWordLabel: used to display hidden in a label
     * @enterWord: label to show user where to enter a word;
     * @guide: label to guide user through mistakes in the game
     * @guessW: label for mystery word
     * @sword: text field to save input word from user
     * @letter: letter text field to save input letter from user
     * @p: panel where everything is shown to user
     * @h: graphics object used to draw simples lines an ovals to display hangman game to user
     */
    private int lifeCount;
    private String saveWord;
    private StringBuilder hidden;
    private JLabel guess;
    private JButton enter1, enter2;
    private JLabel hiddenWordLabel, enterWord, guide, guessW,life;
    private JTextField sword, letter;
    private JPanel p;
    private Graphics h;

    /**
     *getter for life count
     * @return
     */
    public int getLifeCount() {
        return lifeCount;
    }

    /**
     *setter for life count
     * @param lifeCount
     */
    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }

    /**
     * getter for hidden label
     * @return
     */
    public JLabel getHiddenWordLabel() {
        return hiddenWordLabel;
    }

    /**
     * setter for hiddenworld label
     * @param hiddenWordLabel
     */
    public void setHiddenWordLabel(JLabel hiddenWordLabel) {
        this.hiddenWordLabel = hiddenWordLabel;
    }

    /**
     * getter for sword
     * @return
     */
    public JTextField getSword() {
        return sword;
    }

    /**
     * setter for sword
     * @param sword
     */
    public void setSword(JTextField sword) {
        this.sword = sword;
    }

    /**
     * getter for letter text field
     * @return
     */
    public JTextField getLetter() {
        return letter;
    }

    /**
     * setter for letter text field
     * @param letter
     */
    public void setLetter(JTextField letter) {
        this.letter = letter;
    }


    /**
     * getter for saveWord
     * @return
     */
    public String getSaveWord() {
        return saveWord;
    }

    /**
     * setter for saveWord
     * @param saveWord
     */

    public void setSaveWord(String saveWord) {
        this.saveWord = saveWord;
    }

    /**
     * getter for hidden word
     * @return
     */
    public StringBuilder getHidden() {
        return hidden;
    }

    /**
     * setter for hidden
     * @param hidden
     */
    public void setHidden(StringBuilder hidden) {
        this.hidden = hidden;
    }

    /**
     * constructor initializes Jpanel components and call the override paint method to paint GUI hangman
     */
    public Hangman() {
        setLayout(new FlowLayout()); // set layout as flow style
        setTitle("Hangman Game: By Olivia Feldman");//setting the frame title
        p = new JPanel(); //creating a panel for the game to be shown on to user
        p.setPreferredSize(new Dimension(400, 400)); // calling dimension function that sets width adn height   400x400 of panel
        p.setBackground(Color.BLACK);  //setting the  panel background color black
        setLifeCount(6); // intializing the life to 6 for paint method

        enterWord = new JLabel("Please enter a word in lowerase");//initializing  the label
        sword = new JTextField(20);//setting the column length of Jtext field
        enter1 = new JButton("enter word"); //button to allow user to enter in a word to be guessed
        enter1.addActionListener(this); //initializing a action listener to this button
        hiddenWordLabel = new JLabel("  "); // this empty label will be used to hide the save word from user
        letter = new JTextField(10); //initializing the coloum length of text field
        guide = new JLabel("Great so far");//adding test to the label to guide user
        guide.setBackground(Color.MAGENTA);//adding color to guide label

        enter2 = new JButton("enter guess"); // button for entering letter from textfield
        enter2.addActionListener(this); //adding a action listener to invoke an action of an event
        guess = new JLabel("guess lettter ");// label to show where the user to enter in a letter

        guessW = new JLabel("Myster Word: ");//label for number of lives left
        life = new JLabel("Lives left :" +lifeCount);


        //adding initialized panel components to panel p
        add(p);
        add(guide);
        add(enterWord);
        add(sword);
        add(enter1);
        add(guess);
        add(letter);
        add(enter2);
        add(guessW);
        add(hiddenWordLabel);
        add(life);
        p.paint(h); //calling paint method on panel p to paint the graphics to the panle

        setVisible(true); //intializing this method true to show panel
        setSize(600, 600);//setting size of the panel
        setDefaultCloseOperation(EXIT_ON_CLOSE); //terminates program when exit button is activated
    }

    /**
     * actionPerformed method overides this method from superclass and is invoked when action is performed
     * @param h
     */
    @Override //override because it tells compiler to look and make sure this method is in super class
    public void actionPerformed(ActionEvent h) {
        p.repaint();
        //if the enter1 button is activated then the string from sword Jtext is saved
        if (h.getSource() == enter1) {
            enter1.setEnabled(false);// disabling the action listener once a word is entered
            setSaveWord(sword.getText());// storing save word
            if (saveWord.isEmpty()) { //checks to see if saveword is empty
                guide.setText("You need to enter a word to begin"); //updatess the label to guide the user to input a word
                guide.setBackground(Color.white);//sets label button background color
               sword.setEnabled(true);
               enter1.setEnabled(true);
           }
            //condition statement intialize the hidden word string as the same length as saveWord
           else {
                StringBuilder hidden = new StringBuilder();
                for (int i = 0; i < saveWord.length(); i++) {
                    hidden.insert(i, "?");
                }
                setHidden(hidden); //updates hidden
                hiddenWordLabel.setText(String.valueOf(hidden));//adds hidden string to hiddenWordLabel
                sword.setEnabled(false); //disables the action listner
                sword.setText("?????????????"); //hides word from user on GUI
            }
            life.setText("Lives left" +lifeCount); //updates life label
            p.repaint();//calls paint method  to update
        }
        //if the enter2 button is invoked then this statement will update the game accordingly
        if (h.getSource() == enter2) {
            String s = letter.getText();// assigns the  letter JTextfield letter to a string s
            if (saveWord.contains(s)) {// checks if the letter from user is in saveWord
                for (int i = 0; i < saveWord.length(); i++) {
                    if (saveWord.charAt(i) == s.charAt(0)) { //finds the index of the letter in word
                        setHidden(getHidden().insert(i, s.charAt(0))); //inserts and reveals the correct letter
                        setHidden(hidden.deleteCharAt(i + 1));//deletes index of mystery string to reveal correct letter guessed
                    }
                }
                hiddenWordLabel.setText(String.valueOf(hidden)); //updates the hidden word with correct letters guessed

            } else {
                setLifeCount(getLifeCount()- 1); //if the letter guessed isn't in saveWord then life will be takemn
                life.setText("Lives left:" +lifeCount); //updates life label
            }
            repaint();//updating the paint method after an action is performed
        }
    }

    /**
     * paint method overrides the paint function from super class, graphics is an abstract class
     * @param h
     */
    @Override
    public void paint(Graphics h) {
        super.paint(h);
        h.setColor(Color.yellow);//sets graphic's color to yellow
            if(getLifeCount() ==6) {//draws frame
                h.drawLine(120, 100, 120, 300); //middle frame
                h.drawLine(120, 100, 300, 100); //top frame
            }


        if(getLifeCount() < 6) {//as the user's lifecount goes down additional body graphics will be added
            h.drawLine(120, 100, 120, 300); //middle frame
            h.drawLine(120, 100, 300, 100); //top frame
            //switch statement to go run through the life cases and draw hangman graphic as loser loses lifes
            switch (lifeCount) {
                case (5):
                    h.drawOval(270, 100, 60, 60); //add head when you loose a life
                    break;
                case (4):
                    h.drawOval(270, 100, 60, 60);//head
                    h.drawLine(300,160,300,250);//add body when user loses a life
                    break;
                case (3):
                    h.drawOval(270, 100, 60, 60); //head
                    h.drawLine(300,160,300,250);//boyd
                    h.drawLine(300,200,370,150);//add right arm when user loses a life
                    break;
                case (2):
                    h.drawOval(270, 100, 60, 60); //head
                    h.drawLine(300,160,300,250);//body
                    h.drawLine(300,200,370,150);//right arm
                    h.drawLine(300,200,250,150);//add left arm when user loses a life
                    break;
                case (1):
                    h.drawOval(270, 100, 60, 60); //head
                    h.drawLine(300,160,300,250);//body
                    h.drawLine(300,200,370,150); //right arm
                    h.drawLine(300,200,250,150);//left arm
                    h.drawLine(300,250,200,300);// left leg is added when user loses a life count

                    break;
                case (0):
                    h.drawOval(270, 100, 60, 60); //head
                    h.drawLine(300,160,300,250);//body
                    h.drawLine(300,200,370,150); //right arm
                    h.drawLine(300,200,250,150);//left arm
                    h.drawLine(300,250,370,300);//left leg
                    h.drawLine(300,250,200,300);//right leg is added for last life
                    enter2.setEnabled(false);// stop action listener
                    guessW.setEnabled(false); //stop action listener
                default:
                    //throws a new exception if a case is not available
                    throw new IllegalStateException("Unexpected value: " + lifeCount + " Game is over. You loooooseee");
            }

        }

    }

}
