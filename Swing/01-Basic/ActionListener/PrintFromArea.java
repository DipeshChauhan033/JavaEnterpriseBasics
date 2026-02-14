import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrintFromArea{
    public static void main(String[] args){
        JFrame f = new JFrame("Suggestion Form..");
        f.setBounds(500,270,500,450);

        Container c = f.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        JLabel lb = new JLabel("Write your suggestions..");
        lb.setBounds(40,10,250,100);
        Font fn = new Font("Arial",Font.BOLD,18);
        lb.setFont(fn);
        lb.setForeground(Color.WHITE);
        c.add(lb);

        JTextArea txa = new JTextArea();
        txa.setBounds(40,90,400,200);
        Font fn1 = new Font("Arial",Font.BOLD,15);
        txa.setFont(fn1);
        txa.setLineWrap(true);
        c.add(txa);

        JButton bt = new JButton("Submit");
        bt.setBounds(190,310,100,30);
        Font fn2 = new Font("Arial",Font.BOLD,14);
        bt.setFont(fn2);
        bt.setBackground(Color.WHITE);
        c.add(bt);  
        
        bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String output = txa.getText().trim();
                if(output.isEmpty()){
                    
                }
                else{
                    System.out.println(output);
                }
            }
        }); 

        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setResizable(false);

        
    }
}