import javax.swing.*;
import java.awt.*;

public class JPasswordFieldEx{
    public static void main(String[] args){
        JFrame f = new JFrame("Learning about Fields...");
        
        f.setBounds(600,300,500,450);

        ImageIcon icon1 = new ImageIcon("C:/Users/DIPESH/Pictures/Screenshots/Filter.png");
        f.setIconImage(icon1.getImage());
        

        Container c = f.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

        //Logo
        ImageIcon icon2 = new ImageIcon("logo.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(40,-60,400,350);
        c.add(label1);

        //UserName
        JLabel label2 = new JLabel();
        label2.setText("Username: ");
        c.add(label2);
        label2.setBounds(110,215,100,40);
        Font font = new Font("Arial",Font.BOLD,17);
        label2.setFont(font);
        //UserName Feild
        JTextField t1 = new JTextField();
        t1.setBounds(110,255,250,25);
        c.add(t1);

        //Password
        JLabel label3 = new JLabel();
        label3.setText("Password: ");
        c.add(label3);
        label3.setBounds(110,285,100,40);
        Font font2 = new Font("Arial",Font.BOLD,17);
        label3.setFont(font2);
        //Password Feild
        JPasswordField t2 = new JPasswordField();
        t2.setBounds(110,325,250,25);
        c.add(t2);

        //Modify Field Tetx
        //In Username Field
        Font font3 = new Font("Arial",Font.PLAIN,14);
        t1.setFont(font3);

        //In Password Field
        Font font4 = new Font("Arial",Font.PLAIN,14);
        t2.setFont(font4);

        
        t1.setForeground(Color.WHITE);  //Change color of text in field
        t1.setBackground(Color.BLACK);  //Change bgcolor of field
        t1.setCaretColor(Color.WHITE);  //Change cursor color
        
        t2.setForeground(Color.WHITE);  
        t2.setBackground(Color.BLACK);
        t2.setCaretColor(Color.WHITE); 

        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}