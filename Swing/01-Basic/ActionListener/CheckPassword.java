import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
    Container c;
    JPasswordField pf;
    JTextField tf;
    public MyFrame(){
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);
        
        //LOGO
        ImageIcon logo = new ImageIcon("logo.png");
        JLabel label1 = new JLabel(logo);
        label1.setBounds(40,-75,400,350);
        c.add(label1);

        //Username
        JLabel label2 = new JLabel();
        label2.setText("Username:");
        c.add(label2);
        label2.setBounds(110,190,100,40);
        Font f1 = new Font("Arial",Font.BOLD,17);
        label2.setFont(f1);
        //Username Field
        tf = new JTextField(); 
        tf.setBounds(110,230,250,25);
        c.add(tf);
        Font f2 = new Font("Arial",Font.PLAIN,14);
        tf.setFont(f2);
        tf.setForeground(Color.WHITE);
        tf.setBackground(Color.BLACK);
        tf.setCaretColor(Color.WHITE);

        //Password
        JLabel label3 = new JLabel();
        label3.setText("Password: ");
        c.add(label3);
        label3.setBounds(110,270,250,25);
        label3.setFont(f1);
        //Password Field
        pf = new JPasswordField();
        c.add(pf);
        pf.setBounds(110,300,250,25);
        pf.setForeground(Color.WHITE);
        pf.setBackground(Color.BLACK);
        pf.setCaretColor(Color.WHITE);
        pf.setFont(f2);

        //Button
        JButton bt = new JButton();
        bt.setText("Login");
        bt.setBounds(180,360,100,30);
        c.add(bt);
        Font f3 = new Font("Arial",Font.BOLD,14);
        bt.setFont(f3);
        bt.setBackground(Color.BLACK);
        bt.setForeground(Color.WHITE);
        //Change Cursor
        Cursor cr = new Cursor(Cursor.HAND_CURSOR);
        bt.setCursor(cr);
        //Action
        bt.addActionListener(this);

        /*Image as Button..
        ImageIcon loginicon = new ImageIcon("LoginButton.png");
        JButton bt2 = new JButton(loginicon);
        bt2.setBounds(180,300,loginicon.getIconWidth(),loginicon.getIconHeight());
        c.add(bt2);
        //Change Cursor
        Cursor cr2 = new Cursor(Cursor.HAND_CURSOR);
        bt2.setCursor(cr2);
        */
       
    }

    public void actionPerformed(ActionEvent e){
        String s = new String(pf.getPassword());
        if(tf.getText().equals("")){
            JLabel l = new JLabel();
            l.setText("Please enter username.");
            c.add(l);
            l.setBounds(180,320,200,35);
            l.setForeground(Color.RED);
        }
        else{
                if(s.equals("Dipesh__123")){
                JLabel l2 = new JLabel();
                l2.setText("Valid Password..");
                c.add(l2);
                l2.setBounds(180,320,100,35);
                l2.setForeground(Color.GREEN);
            }
            else{
                JLabel l3 = new JLabel();
                l3.setText("Invalid Password..");
                c.add(l3);
                l3.setBounds(180,320,150,40);
                l3.setForeground(Color.RED);
            }
        }
        
    }
    
}

public class CheckPassword{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setBounds(500,270,500,450);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);

        ImageIcon img = new ImageIcon("C:/Users/DIPESH/Pictures/Screenshots/Filter.png");
        f.setIconImage(img.getImage());
    }
}