import javax.swing.*;
import java.awt.*;
public class JFrameFirst{
    public static void main(String[] args){
        JFrame frame = new JFrame();  //   JFrame frame = new JFrame("Java Frame");
        frame.setVisible(true);
        //frame.setSize(300,200);
        //frame.setLocation(600,400);
        frame.setTitle("java Frame");  //we can pass title name in obj..show above

        frame.setBounds(600,400,300,200);  //first two args location , second are size
        
        ImageIcon icon = new ImageIcon("C:/Users/DIPESH/Pictures/Screenshots/Filter.png");
        frame.setIconImage(icon.getImage());

        Container c = new Container();
        c = frame.getContentPane();  // Container c = frame.getContentPane();
        Color color1 = new Color(255,0,0);
        c.setBackground(color1);    // s.setBackground(Color.RED)

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}