import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinNo;
    FastCash(String pinNo) {
        this.pinNo = pinNo;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("PLEASE SELECT WITHDRAWL AMOUNT");
        l2.setBounds(425,180,700,35);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 20));
        l1.add(l2);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(420,270,150,35);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("Rs. 1000");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(420,365,150,35);
        b2.addActionListener(this);
        l1.add(b2);

        b3 = new JButton("Rs. 500");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(420,320,150,35);
        b3.addActionListener(this);
        l1.add(b3);

        b4 = new JButton("Rs. 10000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(690,370,150,35);
        b4.addActionListener(this);
        l1.add(b4);

        b5 = new JButton("BACK");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(420,410,150,35);
        b5.addActionListener(this);
        l1.add(b5);

        b6 = new JButton("Rs. 5000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(690,320,150,35);
        b6.addActionListener(this);
        l1.add(b6);

        b7 = new JButton("Rs. 2000");
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
     if(e.getSource()==b5){
         setVisible(false);
         new Main_class(pinNo);
     }else{
         String amount = ((JButton)e.getSource()).getText().substring(4);
         New new1 = new New();
         Date date = new Date();
         try{
             ResultSet resultSet = new1.statement.executeQuery("SELECT * FROM bank WHERE pinNo = '" + pinNo + "'");
             int balance = 0;
             while(resultSet.next()){
                 if(resultSet.getString("transactionType").equals("Deposit")){
                     balance += Integer.parseInt(resultSet.getString("amount"));
                 }else {
                     balance -= Integer.parseInt(resultSet.getString("amount"));
                 }
             }String num="17";

             if(e.getSource()!=b5 && balance<Integer.parseInt(amount)){
                 JOptionPane.showMessageDialog(null,"Insufficient balance");
                 return;
             }

             String q2 = "INSERT INTO bank (pinNo, date, transactionType, amount) VALUES (?, ?, ?, ?)";
             try (PreparedStatement pstmt = new1.connection.prepareStatement(q2)) {
                 pstmt.setString(1, pinNo);
                 pstmt.setString(2, date.toString());
                 pstmt.setString(3, "WITHDRAWAL"); // Correct spelling
                 pstmt.setString(4, amount);

                 pstmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Rs." + amount + " debited Succesfully");

             }
         }catch(Exception  E){
             E.printStackTrace();
         }
         setVisible(false);
         new Main_class(pinNo);
     }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
