import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField passwordField1,passwordField2;
    String pinNo;
    Pin(String pinNo){
           this.pinNo = pinNo;
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
           Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel l1 = new JLabel(i3);
           l1.setBounds(0, 0, 1550, 830);
           add(l1);


          JLabel l2 = new JLabel("CHANGE YOUR PIN");
          l2.setFont(new Font("System", Font.BOLD, 16));
          l2.setForeground(Color.white);
          l2.setBounds(430, 150, 400, 35);
          l1.add(l2);




           JLabel l3 = new JLabel("NEW PIN :");
           l3.setFont(new Font("System", Font.BOLD, 16));
           l3.setForeground(Color.white);
           l3.setBounds(430, 220, 150, 35);
           l1.add(l3);

           passwordField1 = new JPasswordField();
           passwordField1.setBackground(new Color(65, 125, 128));
           passwordField1.setForeground(Color.white);
           passwordField1.setBounds(600, 225, 200, 30);
           passwordField1.setFont(new Font("Raleway", Font.BOLD, 18));
           l1.add(passwordField1);


           JLabel l4 = new JLabel("RE-ENTER NEW PIN :");
           l4.setFont(new Font("System", Font.BOLD, 16));
           l4.setForeground(Color.white);
           l4.setBounds(430, 270, 200, 35);
           l1.add(l4);

           passwordField2 = new JPasswordField();
           passwordField2.setBackground(new Color(65, 125, 128));
           passwordField2.setForeground(Color.white);
           passwordField2.setBounds(600, 270, 180, 30);
           passwordField2.setFont(new Font("Raleway", Font.BOLD, 22));
           l1.add(passwordField2);


           b1 = new JButton("CHANGE");
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






        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         /*try{
        String pin1 = passwordField1.getText();
        String pin2 = passwordField2.getText();
        if(!passwordField1.equals(passwordField2)){
            JOptionPane.showMessageDialog(null,"PIN DOESNT MATCH");
            return;
        }
        if(e.getSource()==b1){
            if(passwordField1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"ENTER NEW PIN");
                return;
            }
            if(passwordField2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"RE-ENTER NEW PIN");
                return;
            }

            New new1 = new New();
            String q1 = "update bank set pinNo ='"+pin1+"' where pin ='"+pinNo+"'";
            String q2 = "update login set pinNo ='"+pin1+"' where pin ='"+pinNo+"'";
            String q3 = "update signupthree set pinNo ='"+pin1+"' where pin ='"+pinNo+"'";

            new1.statement.executeUpdate(q1);
            new1.statement.executeUpdate(q2);
            new1.statement.executeUpdate(q3);

            JOptionPane.showMessageDialog(null,"PIN UPDATED");
            setVisible(false);
            new Main_class(pinNo);
        } else if (e.getSource()==b2) {
            new Main_class(pinNo);
            setVisible(false);
        }

         }catch (Exception   E){
         E.printStackTrace();
         }*/
        try {
            String pin1 = passwordField1.getText();
            String pin2 = passwordField2.getText();

            // Check if PINs match
            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "PIN DOESN'T MATCH");
                return;
            }

            // Check if PIN fields are empty
            if (pin1.equals("")) {
                JOptionPane.showMessageDialog(null, "ENTER NEW PIN");
                return;
            }
            if (pin2.equals("")) {
                JOptionPane.showMessageDialog(null, "RE-ENTER NEW PIN");
                return;
            }

            // Assuming new1 is a valid object with a database connection
            New new1 = new New();
            String q1 = "UPDATE bank SET pinNo = ? WHERE pinNo = ?";
            String q2 = "UPDATE login SET pinNo = ? WHERE pinNo = ?";
            String q3 = "UPDATE signupthree SET pinNo = ? WHERE pinNo = ?";

            // Using PreparedStatement to prevent SQL injection
            PreparedStatement ps1 = new1.connection.prepareStatement(q1);
            ps1.setString(1, pin1);
            ps1.setString(2, pinNo);

            PreparedStatement ps2 = new1.connection.prepareStatement(q2);
            ps2.setString(1, pin1);
            ps2.setString(2, pinNo);

            PreparedStatement ps3 = new1.connection.prepareStatement(q3);
            ps3.setString(1, pin1);
            ps3.setString(2, pinNo);

            // Execute update queries
            ps1.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();

            // Show success message
            JOptionPane.showMessageDialog(null, "PIN UPDATED");

            // Hide current frame and open the main class
            setVisible(false);
            new Main_class(pinNo);

        } catch (SQLException ex) {
            // Handle any SQL exceptions
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            // Catch any other exceptions
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
