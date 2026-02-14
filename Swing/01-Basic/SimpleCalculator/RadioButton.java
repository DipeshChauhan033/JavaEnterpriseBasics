import javax.swing.*;
import java.awt.*;

public class RadioButton{
    public static void main(String[] args){
        JFrame f = new JFrame("LoginPage With Button");
        f.setBounds(500,270,500,450);

        Container c = f.getContentPane();
        c.setLayout(null);

        JRadioButton rbt1 = new JRadioButton("Male");
        rbt1.setBounds(50,60,100,50);
        c.add(rbt1);

        JRadioButton rbt2 = new JRadioButton("Female");
        rbt2.setBounds(50,100,100,50);
        c.add(rbt2);

        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}