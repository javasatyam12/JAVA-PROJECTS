import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pinNo;
    TextField textField;
    JButton b1, b2;

    Withdrawl(String pinNo) {
        this.pinNo = pinNo;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1550, 830);
        add(l1);

        JLabel l2 = new JLabel("MAXIMUM WITHDRAWL IS RS.10,000 ");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.white);
        l2.setBounds(460, 180, 400, 35);
        l1.add(l2);

        JLabel l3 = new JLabel("PLEASE ENTER YOUR AMOUNT ");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.white);
        l3.setBounds(460, 220, 400, 35);
        l1.add(l3);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.white);
        textField.setBounds(460, 260, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700, 410, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l1.add(b2);

        setLayout(null);
        setSize(1550, 1000);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* if(e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");

                } else {
                    New new1 = new New();
                    ResultSet resultSet = new1.statement.executeQuery("SELECT * FROM login WHERE  pinNo = '\" + pinNo + \"'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("transactionType").equals("Deposit")) {
                            balance = balance + Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance = balance - Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, " Insufficient balance");
                        return;
                    }

                    String q2 = "INSERT INTO bank (pinNo, date, transactionType, amount) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement pstmt = new1.connection.prepareStatement(q2)) {
                        pstmt.setString(1, pinNo);
                        pstmt.setString(2, date.toString());
                        pstmt.setString(3, "WITHDRAWL");  // Assuming "Deposit" is a string literal
                        pstmt.setString(4, amount);

                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Rs." + amount + " has been withdrawn");
                        setVisible(false);
                        new Main_class(pinNo);
                    }
                }
            } catch (Exception E) {
                E.printStackTrace();
            }*/
        if (e.getSource() == b1) {
            try {
                String amountStr = textField.getText().trim();
                Date date = new Date();

                if (amountStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
                    return;
                }

                int amount;
                try {
                    amount = Integer.parseInt(amountStr);
                    if (amount <= 0 || amount > 10000) {
                        JOptionPane.showMessageDialog(null, "Enter a valid amount (1 - 10,000)");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    return;
                }

                New new1 = new New();
                ResultSet resultSet = new1.statement.executeQuery("SELECT * FROM bank WHERE pinNo = '" + pinNo + "'");
                int balance = 0;

                while (resultSet.next()) {
                    if (resultSet.getString("transactionType").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }

                String q2 = "INSERT INTO bank (pinNo, date, transactionType, amount) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = new1.connection.prepareStatement(q2)) {
                    pstmt.setString(1, pinNo);
                    pstmt.setString(2, date.toString());
                    pstmt.setString(3, "WITHDRAWAL"); // Correct spelling
                    pstmt.setString(4, amountStr);

                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs." + amountStr + " has been withdrawn");
                    setVisible(false);
                    new Main_class(pinNo);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
                ex.printStackTrace();
            }


        }else if(e.getSource()==b2) {
            setVisible(false);
            new Main_class(pinNo);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}




