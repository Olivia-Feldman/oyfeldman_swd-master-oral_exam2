
import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.*;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends BasePanel implements ActionListener {

    private String first;
    private String last;
    private String middle;
    private int day;
    private String month;
    private int year;
    private int age;
    private int height;
    private int weight;
    private int num;
    private JPanel drugPanel;
    private JLabel drugNameLabel, descriptionLabel, interactionsLabel, associatedConditionsLabel;
    private JTextField drugNameField;
    private JTable drugInteractionsTable;
    private JTextArea descriptionArea, associatedConditionsArea;
    private JScrollPane descriptionPane, drugInteractionsPane;
    private JButton addDrugButton, drugInfoButton;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


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


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    private JButton save, edit;
    private JLabel firstl, lastl, birthdayl, heightl, weightl, spacer;
    private JTextField firstt, lastt, birthdayt, heightt, weightt;

    public void CreateFrame() {

        JButton save, edit;
        JLabel firstl, middlel, lastl, birthdatl, agel, heightl, weightl, lb, inch, medications;
        JTextField firstt, middlet, lastt, aget, heightt, weightt;
        String[] months = {
                "Month",                               // leave empty so that months[1] = "January"
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };
        String[] days = {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"

        };
        String[] years = {"Year", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919",
                "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929",
                "1930", "1931", "1932", "1923", "194", "1935", "1936", "1937", "1938", "1939",
                "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949",
                "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959",
                "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
                "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
                "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1999",
                "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
                "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
                "2020", "2021"
        };


        JFrame frame = new JFrame(); //creating a new pop-up frame for user to fill out profile infp
        JPanel p = new JPanel(); //creating a new panel to add onto the frame
        p.setLayout(null);
        p.setSize(800, 800);
        frame.add(p);


        //adding first name label and text field
        firstl = new JLabel("First");
        p.add(firstl);
        firstl.setBounds(20, 200, 100, 35);


        firstt = new JTextField(25);
        p.add(firstt);
        firstt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                setFirst(String.valueOf(object));
            }
        });
        firstt.setBounds(60, 200, 150, 35);

        //adding middle name label and text field
        middlel = new JLabel("Middle");
        p.add(middlel);
        middlel.setBounds(250, 200, 150, 35);


        middlet = new JTextField(25);
        middlet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                setMiddle(String.valueOf(object));
            }
        });
        p.add(middlet);
        middlet.setBounds(300, 200, 150, 35);

        //adding last name label and text field
        lastl = new JLabel("Last");
        p.add(lastl);
        lastl.setBounds(500, 200, 150, 35);

        lastt = new JTextField(35);
        p.add(lastt);
        lastt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                setLast(String.valueOf(object));
            }
        });
        lastt.setBounds(550, 200, 200, 35);

        //adding birth month and label
        birthdatl = new JLabel("Birthdate");
        p.add(birthdatl);
        birthdatl.setBounds(20, 250, 100, 35);

        //adding age labels and textfield
        agel = new JLabel("Age");
        p.add(agel);
        agel.setBounds(500, 300, 140, 35);

        aget = new JTextField(25);
        p.add(aget);
        aget.setBounds(550, 300, 140, 35);
        aget.setText(String.valueOf(getAge()));
        aget.setEditable(false);


        //Birthdate in JComboBox as Month, Date, year
        JComboBox<String> birthMonths = new JComboBox<>(months);
        p.add(birthMonths);
        birthMonths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                setMonth(String.valueOf(object));
            }
        });
        birthMonths.setBounds(20, 300, 140, 35);

        //Day
        JComboBox<String> birthday = new JComboBox<String>(days);
        p.add(birthday);
        birthday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                String s = String.valueOf(object);
                setDay(Integer.parseInt(s));
            }
        });
        birthday.setBounds(160, 300, 140, 35);

        //year
        JComboBox<String> year = new JComboBox<String>(years);
        //adding an actionlistener to the year combobox to calculate an age
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //getting the age from the year put in by the user
                String num1 = (String) year.getSelectedItem().toString();
                setNum(Integer.parseInt(num1));
                setYear(getNum());
                setAge(2020 - getNum()); //getting the users age from the year in the combox

                aget.setText(String.valueOf(getAge()));
                System.out.println(age);
            }
        });

        p.add(year);
        year.setBounds(300, 300, 140, 35);


        //adding weight label and textfield
        weightl = new JLabel("Weight (lbs)");
        p.add(weightl);
        weightl.setBounds(20, 350, 150, 35);
        lb = new JLabel("lb");
        p.add(lb);
        lb.setBounds(250, 350, 150, 35);
        weightt = new JTextField(25);
        p.add(weightt);
        weightt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                String s = String.valueOf(object);
                setWeight(Integer.parseInt(s));
            }
        });
        weightt.setBounds(100, 350, 150, 35);


        //adding height label and text field
        heightl = new JLabel("Height(inch)");
        p.add(heightl);
        heightl.setBounds(20, 400, 150, 35);
        heightt = new JTextField(25);
        p.add(heightt);
        heightt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                String s = String.valueOf(object);
                setHeight(Integer.parseInt(s));
            }
        });
        heightt.setBounds(100, 400, 150, 35);
        inch = new JLabel("Inches");
        p.add(inch);
        inch.setBounds(250, 400, 150, 35);

        //adding medication label
        medications = new JLabel(" User Medications");
        p.add(medications);
        medications.setBounds(20, 450, 150, 35);


        save = new JButton("Save");
        p.add(save);
        save.setBounds(20, 700, 100, 50);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        //setting the dimensions and default close operation
        frame.setSize(800, 800);
        frame.setVisible(true);

    }

    public void createAddDrugFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame addDrugsFrame = new JFrame("Search for a Drug");
                addDrugsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addDrugsFrame.setVisible(true);
                addDrugsFrame.setSize(new Dimension(300, 300));

                JPanel panel = new JPanel();
                panel.setLayout(new MigLayout());

                JTextField input = new JTextField(30);
                panel.add(input);

                JButton searchButton = new JButton("Search");
                panel.add(searchButton);

                panel.add(spacer = new JLabel(" "),"span, grow");

                JTextArea searchResults = new JTextArea(20, 40);
                searchResults.setWrapStyleWord(true);
                searchResults.setEditable(false);
                panel.add(searchResults);

                addDrugsFrame.add(panel);

                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        DrugInformation data = new DrugInformation();
                        String results = data.findMatches(input.getText());
                        if (results.equals("")) {
                            searchResults.setText("No drugs match your search terms.");
                        } else {
                            searchResults.setText(results);
                            drugInfoButton = new JButton("See Info");
                            panel.add(drugInfoButton, "top");
                            drugInfoButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    createDrugInfoFrame(results);
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    public void createDrugInfoFrame(String input) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame drugInfoFrame = new JFrame("More about " + input);
                drugInfoFrame.setLayout(new MigLayout());
                drugInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                drugInfoFrame.setVisible(true);
                drugInfoFrame.setSize(new Dimension(300, 300));

                JPanel drugInfoPanel = new JPanel(new GridLayout(4,2));
                JLabel drugInfoNameLabel = new JLabel("Drug Name");
                JLabel descriptionInfoLabel = new JLabel("Description");
                JLabel interactionsInfoLabel = new JLabel("Drug Interactions:");
                JLabel associatedConditionsInfoLabel = new JLabel("Associated Conditions");

                Drug example = new Drug();
                DrugInformation drugData = new DrugInformation();
                example.setDrugName(input);
                example.setDescription(drugData.getDescription(input));
                HashMap<String, String> interactions = new HashMap<>();
                interactions.put("Abacavir", "Ibuprofen may decrease the excretion rate of Abacavir which could result in a higher serum level.");
                interactions.put("Abametapir", "The serum concentration of Ibuprofen can be increased when it is combined with Abametapir.");
                interactions.put("Abatacept", "The metabolism of Ibuprofen can be increased when combined with Abatacept.");
                example.setDrugInteractions(interactions);
                ArrayList<String> conditions = new ArrayList<>(Arrays.asList(drugData.getConditions(input)));
                example.setAssociatedCondition(conditions);
                String[] columnNames = {"Drug", "Interaction"};
                Object[][] data = {
                        {"Abacavir", example.getDrugInteractions().get("Abacavir")},
                        {"Abametapir", example.getDrugInteractions().get("Abametapir")},
                        {"Abatacept", example.getDrugInteractions().get("Abatacept")}
                };
                StringBuilder conditionsStringBuilder = new StringBuilder();

                for (String condition : example.getAssociatedConditions()) {
                    conditionsStringBuilder.append(condition).append("\n");
                }

                Border border = BorderFactory.createLineBorder(Color.BLACK);
                drugInfoPanel.setBorder(BorderFactory.createCompoundBorder(border,
                        BorderFactory.createEmptyBorder(5, 8, 8, 8)));

                JTextField drugInfoNameField = new JTextField(example.getDrugName().toUpperCase());
                drugInfoNameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                drugInfoNameField.setEditable(false);

                JTextArea descriptionInfoArea = new JTextArea(10, 30);
                descriptionInfoArea.setText(example.getDescription());
                descriptionInfoArea.setEditable(false);
                JScrollPane descriptionInfoPane = new JScrollPane(descriptionInfoArea);
                descriptionInfoPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                descriptionInfoArea.setLineWrap(true);
                descriptionInfoArea.setWrapStyleWord(true);
                descriptionInfoPane.setBorder(BorderFactory.createCompoundBorder(border,
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

                JTable drugInteractionsInfoTable = new JTable(data, columnNames);
                TableColumnModel columnModel = drugInteractionsInfoTable.getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(90);
                columnModel.getColumn(1).setPreferredWidth(600);
                //drugInteractionsTable.setPreferredSize(new Dimension(1200, 300));
                //drugInteractionsTable.setPreferredScrollableViewportSize(new Dimension(1200, 300));
                drugInteractionsInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                JScrollPane drugInteractionsInfoPane = new JScrollPane(drugInteractionsTable);
                drugInteractionsInfoPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                drugInteractionsInfoPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                drugInteractionsInfoPane.setBorder(BorderFactory.createCompoundBorder(border,
                        BorderFactory.createEmptyBorder(1, 5, 5, 5)));

                JTextArea associatedConditionsInfoArea = new JTextArea(new String(conditionsStringBuilder));
                associatedConditionsInfoArea.setEditable(false);
                associatedConditionsInfoArea.setBorder(BorderFactory.createCompoundBorder(border,
                        BorderFactory.createEmptyBorder(1, 5, 5, 5)));
                drugInfoPanel.add(drugInfoNameLabel);
                drugInfoPanel.add(drugInfoNameField);
                drugInfoPanel.add(descriptionInfoLabel);
                drugInfoPanel.add(descriptionInfoPane);
                drugInfoPanel.add(associatedConditionsInfoLabel);
                drugInfoPanel.add(associatedConditionsInfoArea);
                drugInfoPanel.add(interactionsInfoLabel);
                drugInfoPanel.add(drugInteractionsInfoPane);
                drugInfoFrame.add(drugInfoPanel, "span");
                drugInfoPanel.add(drugInteractionsInfoPane);
                drugInfoFrame.add(drugInfoPanel);
                drugInfoFrame.setVisible(true);
            }
        });
    }

    Profile(JPanel p, String title, String first, String middle, String last, String month, int day, int year, int age, int height, int weight) {
        super(p, title);

        p.setLayout(new MigLayout());

        addDrugButton = new JButton("Add");
        addDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createAddDrugFrame();
            }
        });
        p.add(addDrugButton);

        p.add(spacer = new JLabel(" "),"span, grow");

        firstl = new JLabel("First Name");
        p.add(firstl);
        firstl.setBounds(20, 20, 100, 35);

        p.add(spacer = new JLabel(" "),"span, grow");

        lastl = new JLabel("Last Name");
        p.add(lastl);
        firstl.setBounds(20, 50, 100, 35);

        p.add(spacer = new JLabel(" "),"span, grow");

        drugPanel = new JPanel(new GridLayout(4, 2));
        drugNameLabel = new JLabel("Drug Name");
        descriptionLabel = new JLabel("Description");
        interactionsLabel = new JLabel("Drug Interactions:");
        associatedConditionsLabel = new JLabel("Associated Conditions");

        Drug ibuprofen = new Drug();
        ibuprofen.setDrugName("Ibuprofen".toUpperCase());
        ibuprofen.setDescription("Ibuprofen is a non-steroidal anti-inflammatory drug (NSAID) derived from propionic " +
                "acid and it " + "is considered the first of the propionics. The formula of ibuprofen is " +
                "2-(4-isobutylphenyl) " + "propionic acid and its initial development was in 1960 while researching" +
                " for a safer alternative " + "for aspirin. Ibuprofen was finally patented in 1961 and this drug was" +
                " first launched against " + "rheumatoid arthritis in the UK in 1969 and USA in 1974. It was the" +
                " first available over-the-counter" + " NSAID.\n" + "\n" + "On the available products, ibuprofen is" +
                " administered as a racemic mixture. " + "Once administered, the R-enantiomer undergoes extensive" +
                " interconversion to the S-enantiomer in vivo" + " by the activity of the alpha-methylacyl-CoA" +
                " racemase. In particular, it is generally proposed that" + " the S-enantiomer is capable of " +
                "eliciting stronger pharmacological activity than the R-enantiomer.");
        HashMap<String, String> interactions = new HashMap<>();
        interactions.put("Abacavir", "Ibuprofen may decrease the excretion rate of Abacavir which could result in a higher serum level.");
        interactions.put("Abametapir", "The serum concentration of Ibuprofen can be increased when it is combined with Abametapir.");
        interactions.put("Abatacept", "The metabolism of Ibuprofen can be increased when combined with Abatacept.");
        ibuprofen.setDrugInteractions(interactions);
        ArrayList<String> conditions = new ArrayList<>();
        conditions.add("Headache");
        conditions.add("Fever");
        conditions.add("Migraine");
        ibuprofen.setAssociatedCondition(conditions);
        String[] columnNames = {"Drug", "Interaction"};
        Object[][] data = {
                {"Abacavir", ibuprofen.getDrugInteractions().get("Abacavir")},
                {"Abametapir", ibuprofen.getDrugInteractions().get("Abametapir")},
                {"Abatacept", ibuprofen.getDrugInteractions().get("Abatacept")}
        };
        StringBuilder conditionsStringBuilder = new StringBuilder();

        for (String condition : ibuprofen.getAssociatedConditions()) {
            conditionsStringBuilder.append(condition).append("\n");
        }

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        drugPanel.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 8, 8, 8)));

        drugNameField = new JTextField(ibuprofen.getDrugName());
        drugNameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        drugNameField.setEditable(false);

        descriptionArea = new JTextArea(10, 30);
        descriptionArea.setText(ibuprofen.getDescription());
        descriptionArea.setEditable(false);
        descriptionPane = new JScrollPane(descriptionArea);
        descriptionPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionPane.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        drugInteractionsTable = new JTable(data, columnNames);
        TableColumnModel columnModel = drugInteractionsTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(90);
        columnModel.getColumn(1).setPreferredWidth(600);
        //drugInteractionsTable.setPreferredSize(new Dimension(1200, 300));
        //drugInteractionsTable.setPreferredScrollableViewportSize(new Dimension(1200, 300));
        drugInteractionsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        drugInteractionsPane = new JScrollPane(drugInteractionsTable);
        drugInteractionsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        drugInteractionsPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        drugInteractionsPane.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(1, 5, 5, 5)));

        associatedConditionsArea = new JTextArea(new String(conditionsStringBuilder));
        associatedConditionsArea.setEditable(false);
        associatedConditionsArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(1, 5, 5, 5)));
        drugPanel.add(drugNameLabel);
        drugPanel.add(drugNameField);
        drugPanel.add(descriptionLabel);
        drugPanel.add(descriptionPane);
        drugPanel.add(associatedConditionsLabel);
        drugPanel.add(associatedConditionsArea);
        drugPanel.add(interactionsLabel);
        drugPanel.add(drugInteractionsPane);
        p.add(drugPanel, "span");
        drugPanel.add(drugInteractionsPane);
        p.add(drugPanel);

        p.setVisible(true);
    }

}
