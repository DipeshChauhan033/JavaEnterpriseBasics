import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JComboBoxEx{
    public static void main(String[] args){
        JFrame f = new JFrame("LoginPage With Button");
        f.setBounds(500,270,500,450);

        Container c = f.getContentPane();
        c.setLayout(null);

        Font font = new Font("Arial",Font.BOLD,15);
        String[] strarr = {"A","B","C","D","E"};
        JComboBox c1 = new JComboBox(strarr);
        c1.setBounds(70,50,100,30);
        c1.setFont(font);
        c.add(c1); 

        c1.setEditable(true);// can add other value
        c1.setSelectedIndex(4);  // or // c1.setSelectedItem("D");

        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);

        JButton btn = new JButton("Submit");
        btn.setBounds(70,100,100,30);
        btn.setFont(font);
        c.add(btn);

        JLabel label = new JLabel();
        label.setBounds(70,200,100,30);
        label.setFont(font);
        c.add(label);

        //Add & Removes Items
        c1.addItem("F");
        c1.removeItem("E"); // Removes first occurs duplicate element from arr
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String str = (String)c1.getSelectedItem();
                label.setText(str);

                /* Index
                String str2 = String.valueOf(c1.getSelectedIndex());
                label.setText(str2);
                */
            }
        });
    }
}