import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  
  
public class Calculator implements ActionListener {  
   JFrame frame;  
   JTextField textField;  
   JButton[] numberButtons = new JButton[10];  
   JButton addButton, subtractButton, multiplyButton, divideButton, equalButton;  
   JButton clearButton, deleteButton;  
   JPanel panel;  
  
   Font font = new Font("Arial", Font.BOLD, 20);  
  
   double number1, number2, result;  
   char operation;  
  
   Calculator() {  
      createGUI();  
   }  
  
   void createGUI() {  
      frame = new JFrame("Calculator");  
      frame.setSize(300, 400);  
      frame.setLayout(new BorderLayout());  
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
      textField = new JTextField();  
      textField.setFont(font);  
      frame.add(textField, BorderLayout.NORTH);  
  
      panel = new JPanel();  
      panel.setLayout(new GridLayout(4, 4));  
      frame.add(panel, BorderLayout.CENTER);  
  
      for (int i = 0; i < 10; i++) {  
        numberButtons[i] = new JButton(String.valueOf(i));  
        numberButtons[i].addActionListener(this);  
        numberButtons[i].setFont(font);  
      }  
  
      addButton = new JButton("+");  
      subtractButton = new JButton("-");  
      multiplyButton = new JButton("*");  
      divideButton = new JButton("/");  
      equalButton = new JButton("=");  
  
      addButton.addActionListener(this);  
      subtractButton.addActionListener(this);  
      multiplyButton.addActionListener(this);  
      divideButton.addActionListener(this);  
      equalButton.addActionListener(this);  
  
      addButton.setFont(font);  
      subtractButton.setFont(font);  
      multiplyButton.setFont(font);  
      divideButton.setFont(font);  
      equalButton.setFont(font);  
  
      clearButton = new JButton("C");  
      deleteButton = new JButton("Del");  
      clearButton.addActionListener(this);  
      deleteButton.addActionListener(this);  
      clearButton.setFont(font);  
      deleteButton.setFont(font);  
  
      panel.add(numberButtons[7]);  
      panel.add(numberButtons[8]);  
      panel.add(numberButtons[9]);  
      panel.add(divideButton);  
      panel.add(numberButtons[4]);  
      panel.add(numberButtons[5]);  
      panel.add(numberButtons[6]);  
      panel.add(multiplyButton);  
      panel.add(numberButtons[1]);  
      panel.add(numberButtons[2]);  
      panel.add(numberButtons[3]);  
      panel.add(subtractButton);  
      panel.add(numberButtons[0]);  
      panel.add(clearButton);  
      panel.add(deleteButton);  
      panel.add(addButton);  
  
      JPanel southPanel = new JPanel();  
      southPanel.add(equalButton);  
      frame.add(southPanel, BorderLayout.SOUTH);  
  
      frame.setVisible(true);  
   }  
  
   public void actionPerformed(ActionEvent e) {  
      for (int i = 0; i < 10; i++) {  
        if (e.getSource() == numberButtons[i]) {  
           textField.setText(textField.getText().concat(String.valueOf(i)));  
        }  
      }  
  
      if (e.getSource() == addButton) {  
        number1 = Double.parseDouble(textField.getText());  
        operation = '+';  
        textField.setText("");  
      }  
  
      if (e.getSource() == subtractButton) {  
        number1 = Double.parseDouble(textField.getText());  
        operation = '-';  
        textField.setText("");  
      }  
  
      if (e.getSource() == multiplyButton) {  
        number1 = Double.parseDouble(textField.getText());  
        operation = '*';  
        textField.setText("");  
      }  
  
      if (e.getSource() == divideButton) {  
        number1 = Double.parseDouble(textField.getText());  
        operation = '/';  
        textField.setText("");  
      }  
  
      if (e.getSource() == equalButton) {  
        number2 = Double.parseDouble(textField.getText());  
        result = calculate(number1, number2, operation);  
        textField.setText(String.valueOf(result));  
      }  
  
      if (e.getSource() == clearButton) {  
        textField.setText("");  
      }  
  
      if (e.getSource() == deleteButton) {  
        String text = textField.getText();  
        if (text.length() > 0) {  
           textField.setText(text.substring(0, text.length() - 1));  
        }  
      }  
   }  
  
   double calculate(double num1, double num2, char op) {  
      switch (op) {  
        case '+':  
           return num1 + num2;  
        case '-':  
           return num1 - num2;  
        case '*':  
           return num1 * num2;  
        case '/':  
           if (num2 != 0) {  
              return num1 / num2;  
           } else {  
              return 0;  
           }  
        default:  
           return 0;  
      }  
   }  
  
   public static void main(String[] args) {  
      new Calculator();  
   }  
}
