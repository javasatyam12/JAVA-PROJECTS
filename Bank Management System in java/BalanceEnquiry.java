import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNo;
    JLabel l3;
    JButton b1;
    BalanceEnquiry(String pinNo) {
        this.pinNo = pinNo;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("YOUR CURRENT BALANCE IS RS  ");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.white);
        l2.setBounds(430,180,400,35);
        l1.add(l2);

        l3 = new JLabel();
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.white);
        l3.setBounds(430,220,400,35);
        l1.add(l3);

        b1 = new JButton("BACK");
        b1.setBounds(700,406,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l1.add(b1);

        int balance = 0;
        /*try{
            New new1 = new New();
            ResultSet resultSet = new1.statement.executeQuery("SELECT * FROM login WHERE  pinNo = '\" + pinNo + \"'");
            while (resultSet.next()) {
                if(resultSet.getString("transactionType").equals("Deposit")){
                    balance = balance + Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance = balance - Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }*/
        try {
            New new1 = new New(); // Ensure this class is correctly defined
            ResultSet resultSet = new1.statement.executeQuery("SELECT * FROM bank WHERE pinNo = '" + pinNo + "'");
            while (resultSet.next()) {
                if (resultSet.getString("transactionType").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        l2.setText("YOUR CURRENT BALANCE IS RS " + balance);
        setLayout(null);
        setSize(1550,1000);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Main_class(pinNo);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
