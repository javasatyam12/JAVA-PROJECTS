import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String pinNo;
    JButton button;
     Mini(String pinNo) {
         this.pinNo = pinNo;
         getContentPane().setBackground(new Color(255, 204, 204));
         setSize(400, 600);
         setVisible(true);
         setLayout(null);
         setLocation(20, 20);

         JLabel l1 = new JLabel("");
         l1.setBounds(20, 140, 400, 200);
         add(l1);

         JLabel l2 = new JLabel("AXIS BANK");
         l2.setFont(new Font("System", Font.BOLD, 15));
         l2.setBounds(150, 20, 200, 20);
         add(l2);

         JLabel l3 = new JLabel("");
         l3.setBounds(20, 80, 300, 20);
         l3.setFont(new Font("System", Font.BOLD, 15));
         add(l3);

         JLabel l4 = new JLabel("");
         l4.setBounds(20, 400, 300, 20);
         add(l4);

         try {
             New new1 = new New();
             ResultSet resultSet = new1.statement.executeQuery("SELECT * FROM bank WHERE pinNo = '" + pinNo + "'");
             while (resultSet.next()) {
                 l3.setText(" Card Number: " + resultSet.getString("card_No").substring(0, 4) + "XXXXXXXX" + resultSet.getString("card_No").substring(12));
             }

         } catch (Exception e) {
             e.printStackTrace();
         }

         try {

             int balance = 0;
             New new1 = new New();
             ResultSet resultSet = new1.statement.executeQuery("SELECT * FROM bank WHERE pinNo = '" + pinNo + "'");
             while (resultSet.next()) {

                 l1.setText(l1.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("transactionType") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");
                 if (resultSet.getString("transactionType").equals("Deposit")) {
                     balance += Integer.parseInt(resultSet.getString("amount"));
                 } else {
                     balance -= Integer.parseInt(resultSet.getString("amount"));
                 }
             }

             l4.setText("Your total balance is " + balance);


         } catch (Exception E) {
             E.printStackTrace();
         }

         button = new JButton("EXIT");
         button.setBounds(20, 500, 100, 25);
         button.setBackground(Color.BLACK);
         button.setForeground(Color.WHITE);
         button.addActionListener(this);
         add(button);


     }




    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
