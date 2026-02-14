import javax.swing.*;
import java.awt.*;

public class JCheckBoxEx{
    public static void main(String[] args){
        JFrame f = new JFrame("LoginPage With Button");
        f.setBounds(500,270,500,450);

        Container c = f.getContentPane();
        c.setLayout(null);

        Font font = new Font("Arial",Font.ITALIC,15);
        JCheckBox b1 = new JCheckBox("High school");
        b1.setBounds(100,50,120,20);
        b1.setFont(font);
        b1.setEnabled(false);
        c.add(b1);
        JCheckBox b2 = new JCheckBox("Intermediate");
        b2.setBounds(100,100,120,20);
        b2.setFont(font);
        c.add(b2);
        JCheckBox b3 = new JCheckBox("Graduation");
        b3.setFont(font);
        b3.setSelected(true);
        b3.setBounds(100,150,120,20);
        c.add(b3);
        JCheckBox b4 = new JCheckBox("Post-Graduation");
        b4.setFont(font);
        b4.setBounds(100,200,150,20);
        c.add(b4);


        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}