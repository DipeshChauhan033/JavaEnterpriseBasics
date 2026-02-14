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
        rbt1.setSelected(true);  //To preselect

        JRadioButton rbt2 = new JRadioButton("Female");
        rbt2.setBounds(50,100,100,50);
        c.add(rbt2);

        ButtonGroup gender =  new ButtonGroup();
        gender.add(rbt1);
        gender.add(rbt2);

        JRadioButton general = new JRadioButton("GENERAL");
        general.setBounds(50,150,100,50);
        c.add(general);
        general.setSelected(true);
        
        JRadioButton obc = new JRadioButton("OBC");
        obc.setBounds(150,150,100,50);
        c.add(obc);
        
        JRadioButton sc = new JRadioButton("SC");
        sc.setBounds(250,150,100,50);
        c.add(sc);
    
        JRadioButton st = new JRadioButton("ST");
        st.setBounds(350,150,100,50);
        c.add(st);
      
        ButtonGroup cast = new ButtonGroup();
        cast.add(general);
        cast.add(obc);
        cast.add(st);
        cast.add(sc);
        
        //Disable..
        sc.setEnabled(false);

        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}