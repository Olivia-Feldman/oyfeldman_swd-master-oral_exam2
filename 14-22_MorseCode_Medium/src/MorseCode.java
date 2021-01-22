
import java.util.HashMap;

/**
 * class MorseCode translate morse code to english and vice versa
 */
public class MorseCode {
    /**
     * phrase is used to store the english phrase
     */
    private String phrase;
    /**
     * morsePhrase is used to store the string value of the morse code
     */
    private String morsePhrase;

    /**
     * setter method for codes hashmap
     * @param codes
     */
    public void setCodes(HashMap<String, String> codes) {
        this.codes = codes;
    }

    /**
     * codes hashmaps stores object value of morse code and key value of the english translation
     */
    private HashMap<String, String> codes;

    /**
     * constructor intializes phrase, morsePhase and codes hashmap
     * @param phrase
     * @param morsePhase
     * @param codes
     */
    MorseCode( String phrase, String morsePhase, HashMap<String, String> codes) {
   this.phrase = phrase;
   this.morsePhrase = morsePhase;
   setCodes(codes);
    }

    /**
     * method converts string to have 3 blank spaces between words and one blank between
     * @param phrase
     * @return
     */
    public String stringConvert(String phrase) {

        String currentChar;
        String getMorseChar;
        String convertedString = "";

        for (int i = 0; i < phrase.length(); i++) {
            //Get character at i position
            currentChar = phrase.charAt(i) + "";

            //convert character to morse code
            getMorseChar = convert(currentChar);

            //separate words with 3 blanks
            if (getMorseChar.equals(" ")) {
                convertedString = convertedString + "  ";
            } else {
                //concat the converted letter
                convertedString = convertedString + getMorseChar;

                //Add a space between each letter
                if (!getMorseChar.equals(" ")) {
                    convertedString = convertedString + " ";
                }
            }
        }

        return convertedString;


    }


    /**
     * uses hashmap and finds the key object pairs and stores them into a string morse
     * @param toEncode
     * @return
     */
    public static String convert(String toEncode) {

        String morse = toEncode;

        if (toEncode.equalsIgnoreCase("a"))
            morse = ".-";
        if (toEncode.equalsIgnoreCase("b"))
            morse = "-...";
        if (toEncode.equalsIgnoreCase("c"))
            morse = "-.-.";
        if (toEncode.equalsIgnoreCase("d"))
            morse = "-..";
        if (toEncode.equalsIgnoreCase("e"))
            morse = ".";
        if (toEncode.equalsIgnoreCase("f"))
            morse = "..-.";
        if (toEncode.equalsIgnoreCase("g"))
            morse = "--.";
        if (toEncode.equalsIgnoreCase("h"))
            morse = "....";
        if (toEncode.equalsIgnoreCase("i"))
            morse = "..";
        if (toEncode.equalsIgnoreCase("j"))
            morse = ".---";
        if (toEncode.equalsIgnoreCase("k"))
            morse = "-.-";
        if (toEncode.equalsIgnoreCase("l"))
            morse = ".-..";
        if (toEncode.equalsIgnoreCase("m"))
            morse = "--";
        if (toEncode.equalsIgnoreCase("n"))
            morse = "-.";
        if (toEncode.equalsIgnoreCase("o"))
            morse = "---";
        if (toEncode.equalsIgnoreCase("p"))
            morse = ".--.";
        if (toEncode.equalsIgnoreCase("q"))
            morse = "--.-";
        if (toEncode.equalsIgnoreCase("r"))
            morse = ".-.";
        if (toEncode.equalsIgnoreCase("s"))
            morse = "...";
        if (toEncode.equalsIgnoreCase("t"))
            morse = "-";
        if (toEncode.equalsIgnoreCase("u"))
            morse = "..-";
        if (toEncode.equalsIgnoreCase("v"))
            morse = "...-";
        if (toEncode.equalsIgnoreCase("w"))
            morse = ".--";
        if (toEncode.equalsIgnoreCase("x"))
            morse = "-..-";
        if (toEncode.equalsIgnoreCase("y"))
            morse = "-.--";
        if (toEncode.equalsIgnoreCase("z"))
            morse = "--..";
        if (toEncode.equalsIgnoreCase("0"))
            morse = "-----";
        if (toEncode.equalsIgnoreCase("1"))
            morse = ".----";
        if (toEncode.equalsIgnoreCase("2"))
            morse = "..---";
        if (toEncode.equalsIgnoreCase("3"))
            morse = "...--";
        if (toEncode.equalsIgnoreCase("4"))
            morse = "....-";
        if (toEncode.equalsIgnoreCase("5"))
            morse = ".....";
        if (toEncode.equalsIgnoreCase("6"))
            morse = "-....";
        if (toEncode.equalsIgnoreCase("7"))
            morse = "--...";
        if (toEncode.equalsIgnoreCase("8"))
            morse = "---..";
        if (toEncode.equalsIgnoreCase("9"))
            morse = "----.";
        if (toEncode.equalsIgnoreCase("."))
            morse = ".-.-";
        if (toEncode.equalsIgnoreCase(","))
            morse = "--..--";
        if (toEncode.equalsIgnoreCase("?"))
            morse = "..--..";

        return morse;
    }

    /**
     * method converts morse to english using get method to find key value pair
     * @param morsePhrase
     */
    public void morseToEnglish(String morsePhrase) {

        //splitting the phrase at 3 spaces
        String[] words = morsePhrase.split("\\s{3}");


            for(String word: words){
                //splitting at each space
                String[] letters = word.split("\\s");
                for( String letter:letters) {
                    //getting the value pair from codes hasmap
                    System.out.print(codes.get(letter));
                }
                //printing space between words
                System.out.print(" ");


            }



    }


}







