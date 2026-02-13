import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
    Container c;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    public MyFrame(){
        c = getContentPane();
        c.setLayout(null);

        

        btn1 = new JButton("Orange");
        btn2 = new JButton("White");
        btn3 = new JButton("Green");

        btn1.setBounds(70,100,100,30);
        btn2.setBounds(200,100,70,30);
        btn3.setBounds(300,100,70,30);

        c.add(btn1);
        c.add(btn2);
        c.add(btn3);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn1){
            c.setBackground(Color.ORANGE);
        }
        else if(e.getSource()==btn2){
            c.setBackground(Color.WHITE);
        }
        else if(e.getSource()==btn3){
            c.setBackground(Color.GREEN);
        }

    }
}

public class GetSource{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setBounds(500,270,500,450);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}