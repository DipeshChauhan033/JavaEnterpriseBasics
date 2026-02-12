import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
    Container c;
    MyFrame(){
        c = getContentPane();
        c.setLayout(null);
        JButton btn = new JButton("Click Me..");
        btn.setBounds(190,180,100,30);
        c.add(btn);
        btn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        c.setBackground(Color.YELLOW);
        JLabel j = new JLabel();
        j.setText("Hello");
        c.add(j);
        j.setBounds(200,120,100,30);
        

    }
}

public class ActionOnButton{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setBounds(500,270,500,450);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setResizable(false);
    }
}