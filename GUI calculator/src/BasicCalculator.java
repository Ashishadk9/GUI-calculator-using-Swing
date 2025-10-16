import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator extends JFrame implements ActionListener {

    // Components
    private  JTextField num1Field, num2Field, resultField;
    private JButton addButton, subButton, mulButton, clearButton;
    private Object divButton;

    public  BasicCalculator(){
        // Frame settings
        setTitle("Calculator");
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// Center the window

        // create panel
        JPanel panel =new JPanel();
        panel.setLayout(new GridLayout(6,2,10,10));
        
        // Labels
        panel.add(new JLabel("First Number:"));
        num1Field=new JTextField();
        panel.add(num1Field);
        
        panel.add(new JLabel("Second Number:"));
        num2Field =new JTextField();
        panel.add(num2Field);
        
        panel.add(new JLabel("Result:"));
        resultField=new JTextField();
        resultField.setEditable(false);
        panel.add(resultField);
        
        //Buttons
        addButton =new JButton("Add");
        subButton =new JButton("subtract");
        mulButton =new JButton("Multiply");
        JButton divButton = new JButton("Divide");
        clearButton =new JButton("Clear");
        // Add buttons to panel
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(clearButton);

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add panel to frame
        add(panel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                    return;
                }
                result = num1 / num2;
            } else if (e.getSource() == clearButton) {
                num1Field.setText("");
                num2Field.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BasicCalculator());
    }
}
