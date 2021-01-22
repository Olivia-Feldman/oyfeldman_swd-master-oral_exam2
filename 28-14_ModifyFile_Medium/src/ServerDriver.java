import javax.swing.*;
// Fig. 28.4: ServerTest.java
// Test the Server application.
// edited by Olivia Feldman

/**
 * This driver class uses the server class to create a GUI and connect to the client class to transfer a file
 */
public class ServerDriver {
    /**
     * This main method creates a new
     * @param args
     */
    public static void main(String[] args) {

        Server test = new Server(); // creates new Server object
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.runServer(); // run server application
    }
}
