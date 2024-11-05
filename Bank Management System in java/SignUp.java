
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;

public class SignUp extends JFrame implements ActionListener {

    JRadioButton r1,r2,m1,m2;
    JButton Next;
    JTextField textName,textFname,textEmail,textAddress,textCity,textPin,textState;
    JDateChooser datechooser;

    Random ran = new Random();
    long first4 =(ran.nextLong() % 9000L) + 1000L;

    String first = "" + Math.abs(first4);
    SignUp(){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons./bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION NO: " + first);
        label1.setBounds(160,50,600,40);
        label1.setFont(new Font("Arial",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway",Font.BOLD,22));
        label2.setBounds(330,10,600,30);
        add(label2);

        JLabel label3 = new JLabel("PERSONAL DETAILS");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(290,120,600,30);
        add(label3);

        JLabel labelName =new  JLabel("NAME :");
        labelName.setFont(new Font("Ralway",Font.BOLD,22));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Ralway",Font.BOLD,14));
        textName.setBounds(300,190,400,30);
        add(textName);

        JLabel labelfname =new  JLabel("FATHER NAME :");
        labelfname.setFont(new Font("Ralway",Font.BOLD,22));
        labelfname.setBounds(100,240,200,30);
        add(labelfname);
        
        textFname = new JTextField();
        textFname.setFont(new Font("Ralway",Font.BOLD,14));
        textFname.setBounds(300,240,400,30);
        add(textFname);

        JLabel DOB =new  JLabel("DATE OF BIRTH :");
        DOB.setFont(new Font("Ralway",Font.BOLD,22));
        DOB.setBounds(100,340,200,30);
        add(DOB);

        datechooser = new JDateChooser();
        datechooser.setForeground(new Color(105,105,105));
        datechooser.setBounds(300,340,400,30);
        add(datechooser);

        JLabel labelG = new JLabel("GENDER :");
        labelG.setFont(new Font("Ralway",Font.BOLD,22));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Ralway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,290,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Ralway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450,290,90,30);
        add(r2);

        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(r1);
        buttongroup.add(r2);

        JLabel labelEmail = new JLabel("EMAIL :");
        labelEmail.setFont(new Font("Ralway",Font.BOLD,22));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Ralway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelMs = new JLabel("MARTIAL STATUS: ");
        labelMs.setFont(new Font("Ralway",Font.BOLD,20));
        labelMs.setBounds(100,440,200,30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(300,440,100,30);
        m1.setFont(new Font("Ralway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(400,440,250,30);
        m2.setFont(new Font("Ralway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
        add(m2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        JLabel labelAddress = new JLabel("ADDRESS: ");
        labelAddress.setFont(new Font("Ralway",Font.BOLD,22));
        labelAddress.setBounds(100,490,200,30);
        add(labelAddress);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Ralway",Font.BOLD,14));
        textAddress.setBounds(300,490,400,30);
        add(textAddress);



        JLabel labelPin = new JLabel("PIN CODE: ");
        labelPin.setFont(new Font("Ralway",Font.BOLD,22));
        labelPin.setBounds(100,540,200,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Ralway",Font.BOLD,14));
        textPin.setBounds(300,540,400,30);
        add(textPin);

        JLabel labelState = new JLabel("STATE : ");
        labelState.setFont(new Font("Ralway",Font.BOLD,22));
        labelState.setBounds(100,590,200,30);
        add(labelState);

        textState= new JTextField();
        textState.setFont(new Font("Ralway",Font.BOLD,14));
        textState.setBounds(300,590,400,30);
        add(textState);

        Next = new JButton("Next");
        Next.setFont(new Font("Ralway",Font.BOLD,14));
        Next.setBackground(Color.blue);
        Next.setForeground(Color.red);
        Next.setBounds(620,650,80,30);
        Next.addActionListener(this);
        add(Next);
        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,750);
        setLocation(360,40);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String martial = null;
        if(m1.isSelected()){
            martial = "Married";
        }else if(m2.isSelected()){
            martial = "Unmarried";
        }
        String address = textAddress.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try{
            {
               if(textName.getText().equals("")){
                   JOptionPane.showMessageDialog(null,"Fill all the fields ");
               }else{
                   New new1 = new New();
                   String q = "INSERT INTO signup (form_no ,name ,father_name,DOB ,gender ,email ,martial_status ,address ,pincode ,state ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,? )";
                   try (PreparedStatement pstmt = new1.connection.prepareStatement(q)) {
                       pstmt.setString(1, formno);
                       pstmt.setString(2, name);
                       pstmt.setString(3, fname);
                       pstmt.setString(4, dob);
                       pstmt.setString(5, gender);
                       pstmt.setString(6, email);
                       pstmt.setString(7, martial);
                       pstmt.setString(8, address);
                       pstmt.setString(9, pincode);
                       pstmt.setString(10, state);

                       pstmt.executeUpdate();
                   }

                   new SignUp2(formno);
                   setVisible(false);

               }
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
