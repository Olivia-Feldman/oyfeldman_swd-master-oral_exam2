import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Welcome extends BasePanel implements ActionListener {

    private JLabel instructions, instructions2, username, password,l1, newUsername, newPassword;
    private JButton login, signup, enter1, enter2;
    private JPasswordField  password_text, new_password_text;
    private JTextField username_text, new_username_text;
    private int num;
    private int age;
    private int day;
    private int year;
    private int weight;
    private int height;
    private String month, first, middle, last;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }




    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    private String sUsername;
    private String sPassword;
    Map<String, String> UI = new HashMap<String,String>();

    Welcome(JPanel p, String title){
        super(p,title);

        p.setLayout(null);
        p.setFont(new Font("TimesRoman", FontUIResource.BOLD,100));
        instructions = new JLabel(" Welcome back!  " +
                "Please sign in to access features");
        p.add(instructions);
        instructions.setBounds(100,20,500,100);

        signup = new JButton("Signup");
        signup.setLocation(300,300);
        p.add(signup);

        username = new JLabel("Username");
        username.setBounds(100,100,80,35);
        p.add(username);

        username_text= new JTextField(15);
        username_text.setBounds(250,100,150,35);
        p.add(username_text);

        password = new JLabel("Password");
        password.setBounds(100,150,80,35);
        p.add(password);

        password_text = new JPasswordField(15);
        p.add(password_text);
        password_text.setBounds(250,150,150,35);



        login = new JButton("login");
        login.addActionListener(this);
        login.setBounds(250,200,100,35);
        p.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myPass = String.valueOf(password_text.getPassword());
                //System.out.println( UI.size());


                //bug in this if  statement
                if (UI.containsKey(username.getText()) && UI.containsValue(username.getText()) ){
                    l1.setText("Login Successful");
                    p.add(l1);

                    System.out.println(myPass);
                    System.out.println(username_text.getText());
                }

                if(UI.containsKey(username.getText() )== false){
                        l1.setText("Login incorrect");
                        p.add(l1);
                }

            }
        });
         l1 = new JLabel("");
         l1.setBounds(100,200,150,35);


         instructions2 = new JLabel(" New User? Create an account!");
         p.add(instructions2);
         instructions2.setBounds(100,300,250,40);

         newUsername = new JLabel("New Username");
         p.add(newUsername);
         newUsername.setBounds(100,350,150,35);

         newPassword = new JLabel("New Password");
         p.add(newPassword);
         newPassword.setBounds(100,400,150,35);

         new_username_text = new JTextField(15);
         p.add(new_username_text);
         new_username_text.setBounds(250,350,150,35);

         new_password_text = new JPasswordField(15);
         p.add(new_password_text);
         new_password_text.setBounds(250,400,150,35);
         signup = new JButton("Sign up");
         signup.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            String myPass = String.valueOf(new_password_text.getPassword());
              System.out.println( new_username_text.getText());
                 System.out.println( myPass);

                 //adding user login information to hasmap
                 setsPassword(myPass);
                 setsUsername(new_username_text.getText());
                 UI.put(sUsername,sPassword);

                 new_username_text.setText("");
                 new_password_text.setText("");

               CreateFrame();

             }
         });
         p.add(signup);
         signup.setBounds(250,450,150,35);
         p.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){


    }
    public void CreateFrame(){

        JButton save, edit;
        JLabel firstl,middlel, lastl, birthdatl, agel,heightl,weightl, lb, inch, medications;
        JTextField firstt, middlet, lastt,aget,heightt,weightt;
        String[] months = {
                "Month",                               // leave empty so that months[1] = "January"
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };
        String[] days = {"Day", "1","2","3","4","5","6","7","8","9","10",
                "11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30","31"

        };
        String [] years = { "Year","1910","1911", "1912", "1913","1914", "1915", "1916","1917","1918","1919",
                "1920","1921", "1922", "1923","1924", "1925", "1926","1927","1928","1929",
                "1930","1931", "1932", "1923","194", "1935", "1936","1937","1938","1939",
                "1940","1941", "1942", "1943","1944", "1945", "1946","1947","1948","1949",
                "1950","1951", "1952", "1953","1954", "1955", "1956","1957","1958","1959",
                "1960","1961", "1962", "1963","1964", "1965", "1966","1967","1968","1969",
                "1970","1971", "1972", "1973","1974", "1975", "1976","1977","1978","1979",
                "1980","1981", "1982", "1983","1984", "1985", "1986","1987","1988","1999",
                "1990","1991", "1992", "1993","1994", "1995", "1996","1997","1998","1999",
                "2000","2001", "2002", "2003","2004", "2005", "2006","2007","2008","2009",
                "2010","2011", "2012", "2013","2014", "2015", "2016","2017","2018","2019",
                "2020","2021"
        };





        JFrame frame = new JFrame(); //creating a new pop-up frame for user to fill out profile infp
        JPanel p = new JPanel(); //creating a new panel to add onto the frame
        p.setLayout(null);
        p.setSize(800,800);
        frame.add(p);


        //adding first name label and text field
        firstl = new JLabel("First");
        p.add(firstl);
        firstl.setBounds(20,200,100,35);


        firstt = new JTextField(25);
        p.add(firstt);
        firstt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                setFirst(String.valueOf(object));
            }
        });
        firstt.setBounds(60,200,150,35);

        //adding middle name label and text field
        middlel = new JLabel("Middle");
        p.add(middlel);
        middlel.setBounds(250,200,150,35);


        middlet = new JTextField(25);
        middlet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                setMiddle(String.valueOf(object));
            }
        });
        p.add(middlet);
        middlet.setBounds(300,200,150,35);

        //adding last name label and text field
        lastl = new JLabel("Last");
        p.add(lastl);
        lastl.setBounds(500,200,150,35);

        lastt = new JTextField(35);
        p.add(lastt);
        lastt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                setLast(String.valueOf(object));
            }
        });
        lastt.setBounds(550,200,200,35);

        //adding birth month and label
        birthdatl = new JLabel("Birthdate");
        p.add(birthdatl);
        birthdatl.setBounds(20,250,100,35);

        //adding age labels and textfield
        agel = new JLabel("Age");
        p.add(agel);
        agel.setBounds(500,300,140,35);

        aget = new JTextField(25);
        p.add(aget);
        aget.setBounds(550,300,140,35);
        aget.setText(String.valueOf(getAge()));
        aget.setEditable(false);



        //Bithdate in JComboBox as Month, Date, year
        JComboBox<String> birthMonths = new JComboBox<>(months);
        p.add(birthMonths);
        birthMonths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                String s = birthMonths.getSelectedItem().toString();
                setMonth(s);
            }
        });
        birthMonths.setBounds(20,300,140,35);

        //Day
        JComboBox <String> birthday = new JComboBox<String>(days);
        p.add(birthday);
        birthday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                String s = birthday.getSelectedItem().toString();
                setDay(Integer.parseInt(s));
            }
        });
        birthday.setBounds(160,300,140,35);

        //year
        JComboBox<String>year= new JComboBox<String>(years);
        //adding an actionlistener to the year combobox to calculate an age
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //getting the age from the year put in by the user
                String num1 = (String) year.getSelectedItem().toString();
                setNum(Integer.parseInt(num1));
                setYear(getNum());
                setAge(2020-getNum()); //getting the users age from the year in the combox

                aget.setText(String.valueOf(getAge()));
                System.out.println(age);


            }
        });

        p.add(year);
        year.setBounds(300, 300, 140, 35);


        //adding weight label and textfield
        weightl = new JLabel("Weight (lbs)");
        p.add(weightl);
        weightl.setBounds(20,350,150,35);
        lb = new JLabel("lb");
        p.add(lb);
        lb.setBounds(250,350,150,35);
        weightt = new JTextField(25);
        p.add(weightt);
        weightt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                String s =  String.valueOf(object);
                setWeight(Integer.parseInt(s));
            }
        });
        weightt.setBounds(100,350,150,35);



        //adding height label and text field
        heightl = new JLabel("Height(inch)");
        p.add(heightl);
        heightl.setBounds(20, 400, 150,35);
        heightt = new JTextField(25);
        p.add(heightt);
        heightt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                String s =  String.valueOf(object);
                setHeight(Integer.parseInt(s));
            }
        });
        heightt.setBounds(100,400,150,35);
        inch = new JLabel("Inches");
        p.add(inch);
        inch.setBounds(250, 400, 150, 35);

        //adding medication label
        medications = new JLabel(" User Medications");
        p.add(medications);
        medications.setBounds(20, 450, 150,35);



        save = new JButton("Save");
        p.add(save);
        save.setBounds(20, 700, 100,50);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile test = new Profile(getP(), "Profile",getFirst(),getMiddle(),getLast(),getMonth(),getDay(),getYear(),getAge(),getHeight(),getWeight() );


            }
        });



        //setting the dimensions and default close operation
        frame.setSize(800,800);
        frame.setVisible(true);

    }

}
