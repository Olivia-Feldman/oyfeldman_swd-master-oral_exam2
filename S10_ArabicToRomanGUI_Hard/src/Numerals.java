

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**@author :olivaia Feldman
 * numerals class implements methods to convert between arabic numbers and roman numerals
 * this class also implements the GUI for the user to input values
 */
public class Numerals  extends  JFrame {

    /**
     * arabic is used to store a number as a string from the user
     */
    private String arabic = "";
    /**
     * number is used for conversion from numeral to arabic value in real time
     */
    private int number =0;
    /**
     * string to store roman numeral value
     */
    private String roman = "";
    /**
     * extra variable to store roman value
     */
    private String save_roman = "";

    /**
     * text field to convert string of roman to text field to be displayed
     */
    JTextField roman1;
    /**
     *  text field to convert string of arabic number to text field to be displayed
     */
    JTextField arabic_text;
    /**
     * String of one place representing roman numeral values
     */
    private final String[] units = {"I", "II", "III", "IV", "V", "V", "VII", "VIII", "IX"};
    /**
     * string of tens places values for Roman numerals
     */
    private final String[] tens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    /**
     * string of hundreds place  values for roman numerals
     */
    private final String[] hundreds = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    /**
     * string of thousand place vales for roman numerals
     */
    private final String[] thousands = {"M", "MM", "MM"};

    /**
     *
     * @return getter fro save_roman
     */
    public String getSave_roman() {
        return save_roman;
    }

    /**
     *
     * @param save_roman sets value for roman
     */
    public void setSave_roman(String save_roman) {
        this.save_roman = save_roman;
    }

    /**
     *
     * @return  returns NUmber
     */

    public int getNumber() {
        return number;
    }

    /**
     *
     * @param arabic sets arabic value
     */
    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    /**
     *
     * @return returns Roamn value
     */
    public String getRoman() {
        return roman;

    }

    /**
     *
     * @param roman sets roamn value
     */
    public void setRoman(String roman) {
        this.roman = roman;
    }

    /**
     * Numerals constructor creates GUI elements for the user to
     * input values to convert between roman numerals and arabic numbers
     */
    Numerals() {
        setArabic(arabic);
        setRoman(roman);
        JPanel p = new JPanel(); //creates a p jpanel for GUI
        JLabel l1 = new JLabel("Roman Numerals"); //Roman numeral textfield label
        JLabel l2 = new JLabel("Arabic Number");//arabic textfield label
        p.setLayout(new FlowLayout()); //sets panel flowlayout
        //setting panel dimensions and color of text fields
        setSize(400, 400);
        roman1 = new JTextField(20);
        roman1.setBorder(new LineBorder(Color.red));
        arabic_text = new JTextField(20);
        arabic_text.setBorder(new LineBorder(Color.BLUE));
        //adding components to panel
        add(p);
        p.add(roman1);
        p.add(l1);
        p.add(arabic_text);
        p.add(l2);
        /**
         * add key listener for when a key is pressed the keyReleased function will
         * execute method to set the roman textfield with the conversion
         */
        roman1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                int in = romanToArabic(roman1.getText());
                arabic_text.setText(Integer.toString(in));
                if (!validity(roman)){
                    roman1.setText(arabicToRoman("invalid conversion"));
                }

            }
        });

        /**
         *adding a key listener to arabic_text field to call keyReleased method when key is pressed to
         * set roman1 text field with the conversion
         */
        arabic_text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String str = arabic_text.getText();

                roman1.setText(arabicToRoman(str));


                if (!validity(roman)){
                    roman1.setText(arabicToRoman("invalid Conversion"));
                }
            }
        });

        setVisible(true);
    }

    /**
     * this method takes in a string of numbers and converts it into Roman Numeral values
     * @param arabic
     * @return
     */
    public String arabicToRoman(String arabic) {
        //if statements find the decimal place of the string number
       if (arabic.length() == 0) {
           save_roman = "";
       } else if (arabic.length() == 1) {
           //converts string value into an integer value
           int num1 = Integer.parseInt(String.valueOf(arabic.charAt(0)));
           save_roman = units[num1 - 1]; //finds the right ones place value and stores value, string index is off by one so -1
           setSave_roman(save_roman); //resets and saves  save_roman
           System.out.println(save_roman);

       } else if (arabic.length() == 2) {
           int num1 = Integer.parseInt(String.valueOf(arabic.charAt(0)));
           int num2 = Integer.parseInt(String.valueOf(arabic.charAt(1)));
           save_roman = tens[num1 - 1] + units[num2 - 1];
           setSave_roman(save_roman);
           System.out.println(save_roman);

       } else if (arabic.length() == 3) {
           int num1 = Integer.parseInt(String.valueOf(arabic.charAt(0)));
           int num2 = Integer.parseInt(String.valueOf(arabic.charAt(1)));
           int num3 = Integer.parseInt(String.valueOf(arabic.charAt(2)));
           save_roman = hundreds[num1 - 1] + tens[num2 - 1] + units[num3 - 1];
           setSave_roman(save_roman);
           System.out.println(save_roman);
       } else if (arabic.length() == 4) {
           int num1 = Integer.parseInt(String.valueOf(arabic.charAt(0)));
           int num2 = Integer.parseInt(String.valueOf(arabic.charAt(1)));
           int num3 = Integer.parseInt(String.valueOf(arabic.charAt(2)));
           int num4 = Integer.parseInt(String.valueOf(arabic.charAt(3)));
           save_roman = thousands[num1 - 1] + hundreds[num2 - 1] + tens[num3 - 1] + units[num4 - 1];
           setSave_roman(save_roman);
           System.out.println(save_roman);
       }

        return save_roman;
    }

    /**
     * This method takes in roman string and finds the numerical value
     * @param roman
     * @return
     */
    public int romanToArabic(String roman) {
        number = 0;
        for(int i =0; i <=roman.length();i++){
        if (roman.isEmpty()) {
            setArabic("");
        } else if (roman.startsWith("M")) {
            number += 1000;
            roman = roman.replaceFirst("M", "");

        } else if (roman.startsWith("CM")) {

            number += 900;
            roman = roman.replaceFirst("CM", "");
        } else if (roman.startsWith("D")) {
            number += 500;
            roman = roman.replaceFirst("D", "");
        } else if (roman.startsWith("CD")) {
            number += 400;
            roman = roman.replaceFirst("CD", "");
        } else if (roman.startsWith("C")) {

            number += 100;
            roman = roman.replaceFirst("C", "");
        } else if (roman.startsWith("XC")) {
            number += 90;
             roman = roman.replaceFirst("XC", "");

        } else if (roman.startsWith("L")) {
            number += 50;
            roman = roman.replaceFirst("L", "");

        } else if (roman.startsWith("XL")) {
            number += 40;
            roman = roman.replaceFirst("XL", "");
        } else if (roman.startsWith("X")) {
            number += 10;
            roman = roman.replaceFirst("X", "");
        } else if (roman.startsWith("IX")) {
            number += 9;
            roman =roman.replaceFirst("IX", "");
        } else if (roman.startsWith("V")) {
            number += 5;
            roman = roman.replaceFirst("V", "");
        } else if (roman.startsWith("IV")) {

            number += 4;
            roman = roman.replaceFirst("IV", "");

        } else if (roman.startsWith("I")) {
            number += 1;
            roman = roman.replaceFirst("I", "");

        }

        }
        return number;
    }

    /**
     * This method is used to test the validity of the conversions and checks if the number is
     * is the same number determined in the romanToArabic method
     * @param roman
     * @return
     */
    public boolean validity(String roman) {

        int num = romanToArabic(roman);
        if (getNumber() == num) {
            return true;
        }
        else{
            return false;
        }
    }
}



