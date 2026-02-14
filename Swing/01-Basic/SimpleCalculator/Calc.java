import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
    Container c;
    JLabel label1,label2,result;
    JTextField tf1,tf2;
    JButton add,sub,mod,div,mul;
    MyFrame(){
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        label1 = new JLabel("First Number: ");
        label1.setBounds(50,60,150,70);
        c.add(label1);
        Font f1 = new Font("Arial",Font.BOLD,14);
        label1.setFont(f1);

        tf1 = new JTextField();
        tf1.setBounds(50,115,90,25);
        c.add(tf1);

        label2 = new JLabel("Second Number: ");
        label2.setBounds(190,60,140,70);
        c.add(label2);
        Font f2 = new Font("Arial",Font.BOLD,14);
        label2.setFont(f2);

        tf2 = new JTextField();
        tf2.setBounds(190,115,90,25);
        c.add(tf2);

        add = new JButton("+");
        add.setBounds(30,170,50,40);
        c.add(add);
        sub = new JButton("-");
        sub.setBounds(90,170,50,40);
        c.add(sub);
        mul = new JButton("*");
        mul.setBounds(150,170,50,40);
        c.add(mul);
        div = new JButton("/");
        div.setBounds(210,170,50,40);
        c.add(div);
        mod = new JButton("%");
        mod.setBounds(270,170,50,40);
        c.add(mod);

        result = new JLabel();
        result.setBounds(30,200,200,100);
        c.add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e){
        try{
            int a =Integer.parseInt(tf1.getText());
            int b =Integer.parseInt(tf2.getText());
            if(e.getSource()==add){
                int ans = a+b;
                result.setText("Result : "+ans);
            }
            else if(e.getSource()==sub){
                double ans = a-b;
                result.setText("Result : "+ans);
            }
            else if(e.getSource()==mul){
                double ans = a*b;
                result.setText("Result : "+ans);
            }
            else if(e.getSource()==div){
                double ans = a/b;
                result.setText("Result : "+ans);
            }
            else if(e.getSource()==mod){
                double ans = a%b;
                result.setText("Result : "+ans);
            }
        }
        catch(NumberFormatException e2){
            result.setText("Please enter numbers..");
        }
        catch(ArithmeticException e3){
            result.setText("Can not divided by zero");
        }
        
    }
}

public class Calc{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setBounds(500,270,370,450);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setResizable(false);
    }
}