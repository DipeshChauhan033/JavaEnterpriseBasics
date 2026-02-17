import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
    Container c;
    JLabel title,name,mobile_no,gender,dob,address;
    JTextField namef,mobile_nof;
    JTextArea addressta;
    JRadioButton male,female;
    ButtonGroup genderselect;
    JComboBox<Integer> day;
    JComboBox<String> month;
    JComboBox<Integer> year;
    JCheckBox check;
    JButton submit;
    public MyFrame(){
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        title = new JLabel("Registration Form");
        title.setBounds(140,-25,250,100);
        Font f1 = new Font("Verdana",Font.BOLD,20);
        title.setFont(f1);
        c.add(title);
        //Name..
        name = new JLabel("Name:");
        name.setBounds(20,50,100,50);
        Font f2 = new Font("Verdana",Font.BOLD,15);
        name.setFont(f2);
        c.add(name);

        namef = new JTextField();
        namef.setBounds(90,67,130,20);
        c.add(namef);

        //Password
        mobile_no = new JLabel("Mobile no:");
        mobile_no.setBounds(20,100,100,50);
        mobile_no.setFont(f2);
        c.add(mobile_no);

        mobile_nof = new JTextField();
        mobile_nof.setBounds(120,117,130,20);
        c.add(mobile_nof);

        //Gender
        gender = new JLabel("Gender:");
        gender.setBounds(20,140,100,50);
        gender.setFont(f2);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(110,140,70,50);
        male.setBackground(Color.WHITE);
        c.add(male);

        female = new JRadioButton("Female");
        female.setBounds(180,140,100,50);
        female.setBackground(Color.WHITE);
        c.add(female);

        genderselect = new ButtonGroup();
        genderselect.add(male);
        genderselect.add(female);

        day = new JComboBox<>();
            for(int i=1;i<=31;i++){
            day.addItem(i);
        }
        String[] months =  {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        month = new JComboBox<>(months);

        year = new JComboBox<>();
        for(int i=1990;i<=2026;i++){
            year.addItem(i);
        }

        dob = new JLabel("DOB:");
        dob.setBounds(20,180,100,50);
        dob.setFont(f2);
        c.add(dob);

        day.setBounds(80,195,80,20); 
        day.setFont(f2); 
        c.add(day);

        month.setBounds(180,195,80,20); 
        month.setFont(f2); 
        c.add(month);

        year.setBounds(280,195,80,20); 
        year.setFont(f2); 
        c.add(year);

        address = new JLabel("Address:");
        address.setBounds(20,220,80,50);
        address.setFont(f2);
        c.add(address);

        addressta = new JTextArea();
        addressta.setBounds(100,235,230,70);
        Color cream = new Color(255, 255, 240);
        addressta.setBackground(cream);
        c.add(addressta);

        check = new JCheckBox("Above details are correct..");
        check.setBounds(20,320,200,50);
        Font f3 = new Font("Verdana",Font.BOLD,12);
        check.setFont(f3);
        check.setBackground(Color.WHITE);
        c.add(check);


        submit = new JButton("Submit");
        submit.setBounds(270,330,100,30);
        c.add(submit);
        Cursor cr = new Cursor(Cursor.HAND_CURSOR);
        submit.setCursor(cr);
        submit.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if(check.isSelected()){
            System.out.println("Name: "+namef.getText());
            System.out.println("Mobile no: "+mobile_nof.getText());
            String s = "male";
            if(female.isSelected()){
                s="female";
            }
            System.out.println("Gender is: "+s);
            System.out.println("DOB: "+day.getSelectedItem()+" "+month.getSelectedItem()+" "+year.getSelectedItem());
            System.out.println("Address: "+addressta.getText());
        }
    }
}

public class RegistrationForm{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setBounds(500,270,500,450);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}