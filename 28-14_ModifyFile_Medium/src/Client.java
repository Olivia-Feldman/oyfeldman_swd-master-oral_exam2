// Fig. 28.5: Client.java
// Client portion of a stream-socket connection between client and server.
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**ll
 * Client class greates gui aand established a stream socket to transfer daat
 * from the client's side
 */
public class Client extends JFrame{

    /**
     * enters information from user
     */
    private JTextField enterField;
    /**
     * to display website
     */
    private JEditorPane contentsArea;
    /**
     * display information to user
     */
    private JTextArea displayArea;
    /**
     * output stream to server
     */
    private ObjectOutputStream output;
    /**
     * input stream from server
     */
    private ObjectInputStream input;
    /**
     *  message from server
     */
    private String message = "";
    /**
     * host server for this application
     */
    private String chatServer;
    /**
     *
     */
    private JButton send;
    /**
     *  socket to communicate with server
     */
    private Socket client;



    /**
     * initialize chatServer and set up GUI
     * @param host
     */
    public Client(String host)
    {
        super("Simple Web Browser");

        // create enterField and register its listener
        enterField = new JTextField("Enter file URL here");
        enterField.addActionListener(
                new ActionListener()
                {
                    // get document specified by user
                    public void actionPerformed(ActionEvent event)
                    {
                        getThePage(event.getActionCommand());
                    }
                }
        );

        /**
         * send jbutton to send file to server
         */
        send = new JButton("Send File");
        add(send,BorderLayout.SOUTH);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file = enterField.getText();
                sendData(file);
            }
        });
        add(enterField, BorderLayout.NORTH);

        contentsArea = new JEditorPane(); // create contentsArea
        contentsArea.setEditable(true);
        contentsArea.addHyperlinkListener(
                new HyperlinkListener()
                {
                    // if user clicked hyperlink, go to specified page
                    public void hyperlinkUpdate(HyperlinkEvent event)
                    {
                        if (event.getEventType() ==
                                HyperlinkEvent.EventType.ACTIVATED)
                            getThePage(event.getURL().toString());
                    }
                }
        );

        add(new JScrollPane(contentsArea), BorderLayout.CENTER);
        setSize(400, 300); // set size of window
        setVisible(true); // show window
    }



    /**
     * connect to server and process messages from server
     */
    public void runClient()
    {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        }
        catch (EOFException eofException)
        {
            displayMessage("\nClient terminated connection");
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            closeConnection(); // close connection
        }
    }



    /**
     * connect to server
     * @throws IOException
     */
    private void connectToServer() throws IOException
    {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 6666);

        // display connection information
        displayMessage("Connected to: " +
                client.getInetAddress().getHostName());
    }



    /**
     * get streams to send and receive data
     * @throws IOException
     */
    private void getStreams() throws IOException
    {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }


    /**
     *  process connection with server
     * @throws IOException
     */
    private void processConnection() throws IOException
    {
        // enable enterField so client user can send messages
        setTextFieldEditable(true);

        do // process messages sent from server
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            }
            catch (ClassNotFoundException classNotFoundException)
            {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("SERVER>>> TERMINATE"));
    }

    /**
     * sets the page text and location
     * @param location
     */
    private void getThePage(String location)
    {
        try // load document and display location
        {
            contentsArea.setPage(location); // set the page
            enterField.setText(location); // set the text
        }
        catch (IOException ioException)
        {
            JOptionPane.showMessageDialog(this,
                    "Error retrieving specified URL", "Bad URL",
                    JOptionPane.ERROR_MESSAGE);
        }
    }



    /**
     * close streams and socket
     */
    private void closeConnection()
    {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false); // disable enterField

        try
        {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }



    /**
     * send message to server
     * @param message
     */
    private void sendData(String message)
    {
        try // send object to server
        {
            output.writeObject("CLIENT>>> " + message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT>>> " + message);
        }
        catch (IOException ioException)
        {
            displayArea.append("\nError writing object");
        }
    }


    /**
     *  manipulates displayArea in the event-dispatch thread
     * @param messageToDisplay
     */
    private void displayMessage(final String messageToDisplay)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }



    /**
     * manipulates enterField in the event-dispatch thread
     * @param editable
     */
    private void setTextFieldEditable(final boolean editable)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable(editable);
                    }
                }
        );
    }

}
