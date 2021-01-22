import java.io.File;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class ReadFile {
public ReadFile(){
try
    {

        File file = new File("F:\\XMLFile.xml");
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        System.out.println("Root element: "+ document.getDocumentElement().getNodeName());
        if (document.hasChildNodes())
        {
            printNodeList(document.getChildNodes());
        }
    }
catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
}
    private static void printNodeList(NodeList nodeList)
    {
        for (int count = 0; count < nodeList.getLength(); count++)
        {
            Node elemNode = nodeList.item(count);
            if (elemNode.getNodeType() == Node.ELEMENT_NODE)
            {
// get node name and value
                System.out.println("\nNode Name =" + elemNode.getNodeName()+ " [OPEN]");
                System.out.println("Node Content =" + elemNode.getTextContent());
                if (elemNode.hasAttributes())
                {
                    NamedNodeMap nodeMap = elemNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++)
                    {
                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());
                    }
                }
                if (elemNode.hasChildNodes())
                {
//recursive call if the node has child nodes
                    printNodeList(elemNode.getChildNodes());
                }
                System.out.println("Node Name =" + elemNode.getNodeName()+ " [CLOSE]");
            }
        }
    }


    public static class Profile  extends BasePanel {

        private String first;
        private String last;
        private String birthDay;
        private String birthMonth;
        private String  birhYear;

        private int weight;
        private int height;
        private int age;
        String[] monthes = { "Month","January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November",
                "December" };



        private JTextField firstText, lastText;
        private JLabel firstLabel, lastLabel;
        private JList<String> birth_Month;
        private JButton save, edit;
        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }


        Profile(JPanel p, String title)  {
            super(p,title);


            p.setLayout(null);

            firstLabel = new JLabel("First Name");
            p. add(firstLabel);
            firstLabel.setBounds(30,100,100,40);
            firstText = new JTextField(20);
            p.add(firstText);
            firstText.setBounds(150,100,200,40);

            lastLabel = new JLabel("last Name");
            p. add(lastLabel);
            lastLabel.setBounds(30,150,100,40);

            lastText = new JTextField(20);
            p.add(lastText);
            lastText.setBounds(150,150,200,40);





            birth_Month = new JList(monthes);
            birth_Month.setSelectedIndex(2);
            birth_Month.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    birthMonth = e.toString();


                }
            });
            birth_Month.setDropMode(DropMode.USE_SELECTION);
            p.add(birth_Month);

            birth_Month.setBounds(100,250, 100,200);

            p.setVisible(true);
        }
    }
}




