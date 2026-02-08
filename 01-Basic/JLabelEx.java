import javax.swing.*;
import java.awt.*;

public class JLabelEx{
    public static void main(String[] args){
        JFrame f = new JFrame("Learning about labels...");
        
        f.setBounds(600,300,500,450);

        ImageIcon icon1 = new ImageIcon("C:/Users/DIPESH/Pictures/Screenshots/Filter.png");
        f.setIconImage(icon1.getImage());
        

        Container c = f.getContentPane();
        c.setLayout(null);

        ImageIcon icon2 = new ImageIcon("logo.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(40,-75,400,350);
        c.add(label1);

        JLabel label = new JLabel();
        label.setText("Username: ");
        c.add(label);
        
        label.setBounds(70 ,200,100,40);
        Font font = new Font("Arial",Font.BOLD,17);
        label.setFont(font);

        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}