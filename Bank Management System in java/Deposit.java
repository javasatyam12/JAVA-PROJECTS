import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pinNo;
    TextField textField;
    JButton b1,b2;
    String Deposit;
    Deposit(String pinNo){
        this.pinNo = pinNo;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.white);
        l2.setBounds(460,180,400,35);
        l1.add(l2);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
         l1.add(textField);

         b1 = new JButton("DEPOSIT");
         b1.setBounds(700,362,150,35);
         b1.setBackground(new Color(65,125,128));
         b1.setForeground(Color.white);
         b1.addActionListener(this);
         l1.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,410,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l1.add(b2);

        setLayout(null);
        setSize(1550,1000);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      try {
          String amount = textField.getText();
          Date date = new Date();
          if(e.getSource()==b1){
              if(textField.getText().equals("")){
                  JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
              }else {
                  New new1 = new New();
                  //()
                  /*String q2 = "insert into bank (pinNo,date,type,ammount) values (?,?,?,?)";
                  try (PreparedStatement pstmt = new1.connection.prepareStatement(q2)) {
                      pstmt.setString(1, pinNo);
                      pstmt.setString(2, date.toString());
                      pstmt.setString(3, 'Deposit);
                      pstmt.setString(4, amount);

                      pstmt.executeUpdate();
                  }*/
                  String q2 = "INSERT INTO bank (pinNo, date, transactionType, amount) VALUES (?, ?, ?, ?)";
                  try (PreparedStatement pstmt = new1.connection.prepareStatement(q2)) {
                      pstmt.setString(1, pinNo);
                      pstmt.setString(2, date.toString());
                      pstmt.setString(3, "Deposit");  // Assuming "Deposit" is a string literal
                      pstmt.setString(4, amount);

                      pstmt.executeUpdate();
                  }
                  JOptionPane.showMessageDialog(null,"Rs." +amount+ "Deposited successfully");
                  setVisible(false);
                  new Main_class(pinNo);
              }
          }else if(e.getSource()==b2){
                setVisible(false);
                new Main_class(pinNo);
          }
      }catch(Exception E){
          E.printStackTrace();
      }
      }
    public  static void main(String[] args) {
        new Deposit("");
    }
    }





