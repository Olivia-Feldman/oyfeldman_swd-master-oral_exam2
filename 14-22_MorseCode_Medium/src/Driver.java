import java.util.HashMap;
import java.util.Scanner;

/**
 * Driver class that class call morsecode class
 */
public class Driver {
    /**
     * main method
     * @param args
     */
    public  static void main(String[] args) {
        /**
         * english is a array string that stores english characters to encode to morse code
         */
        String[] english = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?" , " "};
        /**
         * morse code characters that match to the string of english array
         */

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--..", " "};

        /**
         * codes hash map contains to string arrays to pair object and key values
         */
        HashMap< String, String> codes = new HashMap<String, String>();

        //puts values into hashmap
         for (int i = 0; i < 40 ;i++){

             codes.put( morse[i], english[i]);
         }

         // testing to make sure same length of arays and hash map : size should be 40
            System.out.println(morse.length);
            System.out.println(english.length);
            System.out.println(codes.size());

        //gettting input from user
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter a phrase to convert to morse code: ");
        String phrase= userInput.nextLine();
        System.out.println("");

        //creating a morsecode for one translation
        MorseCode obj = new MorseCode(phrase, "", codes);
        //calling stringConver method and printing out the conversion
        System.out.println(obj.stringConvert(phrase));

        //getting user input two for the second translation
        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Please enter a phrase to morse to convert into english ");
        String morsephrase= userInput2.nextLine();
       System.out.println("");
       //creating a new morsecode obj for second translation
        MorseCode obj2= new MorseCode(phrase,morsephrase, codes);


        //calling the morseToEnglish method to print out the algorithm
        obj2.morseToEnglish(morsephrase);








    }
}
