import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUp2 extends JFrame implements ActionListener {
    JTextField textPan, textAdhaar;
    JRadioButton r1,r2 ,r3,r4;
    JButton Next;
    JComboBox comboBox ,comboBox2 ,comboBox3,comboBox4,comboBox5;
    String formno;
    SignUp2(String formno){
        super("APPLICATION FORM ");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons./bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,5,100,100);
        add(image);

        this.formno = formno;

        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Serif", Font.BOLD, 22));
        l1.setBounds(340,20,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Information");
        l2.setFont(new Font("Serif", Font.BOLD, 30));
        l2.setBounds(260,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Serif", Font.BOLD, 25));
        l3.setBounds(70,190,100,30);
        add(l3);

        String religion[]  ={"Hindu", "Muslim" , "Sikh" , "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(222,255,228));
        comboBox.setFont(new Font("Serif", Font.BOLD, 14));
        comboBox.setBounds(230,190,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category :");
        l4.setFont(new Font("Serif", Font.BOLD, 25));
        l4.setBounds(70,240,130,30);
        add(l4);

        String category[]  ={"SC", "ST" , "OBC" , "General"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(222,255,228));
        comboBox2.setFont(new Font("Serif", Font.BOLD, 14));
        comboBox2.setBounds(230,240,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income :");
        l5.setFont(new Font("Serif", Font.BOLD, 25));
        l5.setBounds(70,290,130,30);
        add(l5);

       String income[]  ={"NULL", "<1,50,000" , "<2,50,000" , "5,00000" , "Upto 10,00000" , "above 10,00000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(222,255,228));
        comboBox3.setFont(new Font("Serif", Font.BOLD, 14));
        comboBox3.setBounds(230,290,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Education :");
        l6.setFont(new Font("Serif", Font.BOLD, 25));
        l6.setBounds(70,340,130,30);
        add(l6);

        String education[]  ={"Non Graduated" , "Graduated" ,"Post-Graduation", "Doctrate","Other"};
        comboBox4 = new JComboBox(education);
        comboBox4.setBackground(new Color(222,255,228));
        comboBox4.setFont(new Font("Serif", Font.BOLD, 14));
        comboBox4.setBounds(230,340,320,30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation :");
        l7.setFont(new Font("Serif", Font.BOLD, 25));
        l7.setBounds(70,390,160,30);
        add(l7);

        String occupation[]  ={"Buissnessman" , "Service-Man" ,"Self-Employed", "Unemployed","Student","Retired"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(new Color(222,255,228));
        comboBox5.setFont(new Font("Serif", Font.BOLD, 14));
        comboBox5.setBounds(230,390,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number :");
        l8.setFont(new Font("Serif", Font.BOLD, 25));
        l8.setBounds(70,440,180,30);
        add(l8);

        textPan = new JTextField();
        textPan.setBackground(new Color(222,255,228));
        textPan.setFont(new Font("Serif", Font.BOLD, 14));
        textPan.setBounds(230,445,320,30);
        add(textPan);

        JLabel l9 = new JLabel("Adhaar No :");
        l9.setFont(new Font("Serif", Font.BOLD, 25));
        l9.setBounds(70,490,200,30);
        add(l9);

        textAdhaar= new JTextField();
        textAdhaar.setBackground(new Color(222,255,228));
        textAdhaar.setFont(new Font("Serif", Font.BOLD, 14));
        textAdhaar.setBounds(230,490,320,30);
        add(textAdhaar);

        JLabel l10 = new JLabel("Senior Citizen :");
        l10.setFont(new Font("Serif", Font.BOLD, 25));
        l10.setBounds(70,540,200,30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setBackground(new Color(222,255,228));
        r1.setFont(new Font("Serif", Font.BOLD, 14));
        r1.setBounds(250,545,50,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Ralway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(340,544,90,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel l11 = new JLabel("ExistingAccount:");
        l11.setFont(new Font("Serif", Font.BOLD, 25));
        l11.setBounds(70,590,200,30);
        add(l11);

        r3 = new JRadioButton("Yes");
        r3.setBackground(new Color(222,255,228));
        r3.setFont(new Font("Serif", Font.BOLD, 14));
        r3.setBounds(250,595,50,30);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Ralway",Font.BOLD,14));
        r4.setBackground(new Color(222,255,228));
        r4.setBounds(340,594,90,30);
        add(r4);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(r3);
        buttonGroup2.add(r4);

        JLabel l12 = new JLabel("FormNo:");
        l12.setFont(new Font("Serif", Font.BOLD, 18));
        l12.setBounds(680,10,90,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Serif", Font.BOLD, 18));
        l13.setBounds(780,10,90,30);
        add(l13);

        Next = new JButton("Next");
        Next.setFont(new Font("Ralway",Font.BOLD,14));
        Next.setBackground(Color.blue);
        Next.setForeground(Color.red);
        Next.setBounds(570,640,100,30);
        Next.addActionListener(this);
        add(Next);



        setLayout(null);
        setSize(850,750);
        setLocation(450,80);

        getContentPane().setBackground(new Color(222,255,228));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
     String religion =(String) comboBox.getSelectedItem();
     String category =(String) comboBox2.getSelectedItem();
     String income  =(String) comboBox3.getSelectedItem();
     String education =(String) comboBox4.getSelectedItem();

     String occupation =(String) comboBox5.getSelectedItem();
     String pan =(String) textPan.getText();
     String adhaar =(String) textAdhaar.getText();

     String seniorcitizen = null;
     if((r1.isSelected())){
         seniorcitizen = "Yes";
     }else if(r2.isSelected()){
         seniorcitizen = "No";
     }
     String existing_account = null;
        if(r3.isSelected()){
            existing_account = "Yes";
        }else if(r4.isSelected()){
            existing_account = "No";
        }
        try{
            if(textPan.getText().equals("")|| textAdhaar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter all the fields");
            }else{
                New new1 = new New();
                String q = "INSERT INTO signuptwo (form_no ,religion ,category,income ,education ,occupation ,pan ,adhaar ,seniorcitizen ,existing_account ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,? )";
                try (PreparedStatement pstmt = new1.connection.prepareStatement(q)) {
                    pstmt.setString(1, formno);
                    pstmt.setString(2, religion);
                    pstmt.setString(3, category);
                    pstmt.setString(4, income);
                    pstmt.setString(5, education);
                    pstmt.setString(6, occupation);
                    pstmt.setString(7, pan);
                    pstmt.setString(8, adhaar);
                    pstmt.setString(9, seniorcitizen);
                    pstmt.setString(10, existing_account);

                    pstmt.executeUpdate();
                }
                new SignUp3(formno);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
    new SignUp2("");
    }
}
