import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JButton submit,cancel;
    String formno;

    JCheckBox c1,c2,c3,c4,c5,c6;
    SignUp3(String formno){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons./bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,5,100,100);
        add(image);

        this.formno = formno;

        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Ralway", Font.BOLD, 20));
        l1.setBounds(350,30,400,40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Ralway", Font.BOLD, 25));
        l2.setBounds(320,80,400,40);
        add(l2);

        JLabel l3 = new JLabel("Account Type :");
        l3.setFont(new Font("Ralway", Font.BOLD, 20));
        l3.setBounds(60,160,400,40);
        add(l3);

         r1 = new JRadioButton("Saving Account");
         r1.setFont(new Font("Ralway", Font.BOLD, 17));
         r1.setBackground(new Color(215, 252, 250));
         r1.setBounds(210,160,160,40);
         add(r1);

        r2 = new JRadioButton(" Fixed Deposit Account");
        r2.setFont(new Font("Ralway", Font.BOLD, 17));
        r2.setBackground(new Color(215, 252, 250));
        r2.setBounds(370,160,230,40);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Ralway", Font.BOLD, 17));
        r3.setBackground(new Color(215, 252, 250));
        r3.setBounds(210,190,160,40);
        add(r3);

        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Ralway", Font.BOLD, 17));
        r4.setBackground(new Color(215, 252, 250));
        r4.setBounds(370,190,250,40);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Card No :");
        l4.setFont(new Font("Ralway", Font.BOLD, 20));
        l4.setBounds(60,250,400,40);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-Digit card Number)");
        l5.setFont(new Font("Ralway", Font.BOLD, 12));
        l5.setBounds(60,280,400,40);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-2056");
        l6.setFont(new Font("Ralway", Font.BOLD, 20));
        l6.setBounds(270,250,400,40);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on  atm card /cheque Book and statements )");
        l7.setFont(new Font("Ralway", Font.BOLD, 12));
        l7.setBounds(270,280,500,40);
        add(l7);

        JLabel l8 = new JLabel("Pin No :");
        l8.setFont(new Font("Ralway", Font.BOLD, 20));
        l8.setBounds(60,340,200,40);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Ralway", Font.BOLD, 20));
        l9.setBounds(220,340,200,40);
        add(l9);

        JLabel l10 = new JLabel("(Your 4-digit Pin no )");
        l10.setFont(new Font("Ralway", Font.BOLD, 12));
        l10.setBounds(60,360,400,40);
        add(l10);

        JLabel l11 = new JLabel("Services Required :");
        l11.setFont(new Font("Ralway", Font.BOLD, 20));
        l11.setBounds(60,410,200,40);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(215, 252, 250));
        c1.setFont(new Font("Ralway", Font.BOLD, 15));
        c1.setBounds(270,415,120,30);
        add(c1);

        c2 = new JCheckBox("NET BANKING");
        c2.setBackground(new Color(215, 252, 250));
        c2.setFont(new Font("Ralway", Font.BOLD, 15));
        c2.setBounds(400,410,140,40);
        add(c2);

        c3 = new JCheckBox("UPI");
        c3.setBackground(new Color(215, 252, 250));
        c3.setFont(new Font("Ralway", Font.BOLD, 15));
        c3.setBounds(540,410,50,40);
        add(c3);

        c4 = new JCheckBox("EMAIL ALERT");
        c4.setBackground(new Color(215, 252, 250));
        c4.setFont(new Font("Ralway", Font.BOLD, 15));
        c4.setBounds(610,410,200,40);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(new Color(215, 252, 250));
        c5.setFont(new Font("Ralway", Font.BOLD, 15));
        c5.setBounds(270,450,140,40);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(new Color(215, 252, 250));
        c6.setFont(new Font("Ralway", Font.BOLD, 15));
        c6.setBounds(420,450,200,40);
        add(c6);

        JCheckBox c7 = new JCheckBox("I here by declares that the above entered details correctly to the best of my knowledege",true);
        c7.setBackground(new Color(215, 252, 250));
        c7.setFont(new Font("Ralway", Font.BOLD, 12));
        c7.setBounds(60,520,680,40);
        add(c7);

        JLabel l12 = new JLabel("FormNo:");
        l12.setFont(new Font("Serif", Font.BOLD, 18));
        l12.setBounds(620,10,90,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Serif", Font.BOLD, 18));
        l13.setBounds(700,10,90,30);
        add(l13);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLUE);
        submit.setFont(new Font("Ralway", Font.BOLD, 15));
        submit.setForeground(Color.RED);
        submit.setBounds(550,650,100,30);
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLUE);
        cancel.setFont(new Font("Ralway", Font.BOLD, 15));
        cancel.setForeground(Color.RED);
        cancel.setBounds(660,650,100,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(new Color(215,252,250));
        setSize(800,750);
        setLayout(null);
        setLocation(400,20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acccountType = null;
        if(r1.isSelected()){
            acccountType = "Saving Account";

        } else if (r2.isSelected()) {
            acccountType = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            acccountType = "Current Account";
        } else if (r4.isSelected()) {
            acccountType = "Reccuring Deposit Account";
        }

        Random ran  = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String card_No = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 90000000L) + 1000L;
        String pinNo = "" + Math.abs(first3);

        String serviceRequired = null;
        if(c1.isSelected()){
              serviceRequired = serviceRequired+"ATM CARD";
        }else if(c2.isSelected()){
              serviceRequired = serviceRequired+"NET BANKING";
        }else if(c3.isSelected()){
              serviceRequired = serviceRequired+"UPI";
        }else if(c4.isSelected()){
              serviceRequired = serviceRequired+"EMAIL ALERT";
        }else if(c5.isSelected()){
              serviceRequired = serviceRequired+"CHEQUE BOOK";
        }else if(c6.isSelected()){
              serviceRequired = serviceRequired+"E-STATEMENT";
        }
        try {
            if(e.getSource()==submit){
                if(acccountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }else {
                    New new1 = new New();
                    String q1 = "INSERT INTO signupthree (form_no, acccountType, card_No, pinNo ) VALUES (?, ?, ?,? )";
                    try (PreparedStatement pstmt = new1.connection.prepareStatement(q1)) {
                        pstmt.setString(1, formno);
                        pstmt.setString(2, acccountType);
                        pstmt.setString(3, card_No);
                        pstmt.setString(4, pinNo);

                        pstmt.executeUpdate();
                    }
                    String q2 = "INSERT INTO login (form_no,card_No,pinNo ) VALUES (?, ?, ? )";
                    try (PreparedStatement pstmt = new1.connection.prepareStatement(q2)) {
                        pstmt.setString(1, formno);
                        pstmt.setString(2, card_No);
                        pstmt.setString(3, pinNo);

                        pstmt.executeUpdate();
                    }
                    JOptionPane.showMessageDialog(null, "Card no : "+card_No+"\n Pin : "+pinNo);
                    new Deposit(pinNo);
                    setVisible(false);
                }
                }else if(e.getSource()==cancel){
                System.exit(0);
            }
        }catch(Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args){
        new SignUp3("");
    }
}
