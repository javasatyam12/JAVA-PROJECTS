import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinNo;
    Main_class(String pinNo){
        this.pinNo = pinNo;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        l2.setBounds(420,180,700,35);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 22));
        l1.add(l2);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(420,270,150,35);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("PIN CHANGE");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(420,365,150,35);
        b2.addActionListener(this);
        l1.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(420,320,150,35);
        b3.addActionListener(this);
        l1.add(b3);

        b4 = new JButton("BALANCE ENQUIRY");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(690,370,150,35);
        b4.addActionListener(this);
        l1.add(b4);

        b5 = new JButton("EXIT");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(420,410,150,35);
        b5.addActionListener(this);
        l1.add(b5);

        b6 = new JButton("MINI STATEMENT");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(690,320,150,35);
        b6.addActionListener(this);
        l1.add(b6);

        b7 = new JButton("CASH WITHDRAW");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(690,270,150,35);
        b7.addActionListener(this);
        l1.add(b7);
        
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==b1){
         new Deposit(pinNo);
         setVisible(false);
     } else if (e.getSource()==b5) {
         System.exit(0);
     } else if (e.getSource()==b7) {
         new Withdrawl(pinNo);
     }else if(e.getSource()==b4){
         new BalanceEnquiry(pinNo);
         setVisible(false);
     }else if(e.getSource()==b3){
         new FastCash(pinNo);
         setVisible(false);
     } else if (e.getSource()==b2) {
         new  Pin(pinNo);
         setVisible(false);
     } else if(e.getSource()==b6){
         new  Mini(pinNo);
     }

    }

    public static void main(String[] args) {
        new Main_class("");
    }
}
