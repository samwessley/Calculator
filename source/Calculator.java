import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.border.EmptyBorder;

public class Calculator {

    JLabel display = new JLabel();
    Double value1 = null;
    Double value2 = null;
    String value1String = "";
    String value2String = "";
    char operator = 'n';

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.buildGUI();
    }

    public void buildGUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel displayPanel = new JPanel();

        display.setForeground(Color.WHITE);
        display.setText("0");
        display.setFont(new Font("Sans-Serif", Font.PLAIN, 36));
        display.setMinimumSize(new Dimension(230,70));
        display.setPreferredSize(new Dimension(230,70));
        display.setMaximumSize(new Dimension(230,70));
        display.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setVerticalAlignment(SwingConstants.CENTER);

        displayPanel.setBackground(new Color(40,40,40));
        displayPanel.setMinimumSize(new Dimension(240,70));
        displayPanel.setPreferredSize(new Dimension(240,70));
        displayPanel.setMaximumSize(new Dimension(240,70));
        displayPanel.add(display);

        panel.setBackground(new Color(40,40,40));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        CalculatorButton clearButton = new CalculatorButton("AC",c.gridx,c.gridy);
        clearButton.addActionListener(new ClearButtonListener());
        panel.add(clearButton, c);

        c.gridx = 0;
        c.gridy = 1;
        CalculatorButton n7Button = new CalculatorButton("7",c.gridx,c.gridy);
        n7Button.addActionListener(new NumberButtonListener());
        panel.add(n7Button, c);

        c.gridx = 0;
        c.gridy = 2;
        CalculatorButton n4Button = new CalculatorButton("4",c.gridx,c.gridy);
        n4Button.addActionListener(new NumberButtonListener());
        panel.add(n4Button, c);

        c.gridx = 0;
        c.gridy = 3;
        CalculatorButton n1Button = new CalculatorButton("1",c.gridx,c.gridy);
        n1Button.addActionListener(new NumberButtonListener());
        panel.add(n1Button, c);

        c.gridx = 0;
        c.gridy = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        CalculatorButton n0Button = new CalculatorButton("0",c.gridx,c.gridy);
        n0Button.addActionListener(new NumberButtonListener());
        panel.add(n0Button, c);

        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 1;
        CalculatorButton signButton = new CalculatorButton("+/-",c.gridx,c.gridy);
        signButton.addActionListener(new SignButtonListener());
        signButton.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        panel.add(signButton, c);

        c.gridx = 1;
        c.gridy = 1;
        CalculatorButton n8Button = new CalculatorButton("8",c.gridx,c.gridy);
        n8Button.addActionListener(new NumberButtonListener());
        panel.add(n8Button, c);

        c.gridx = 1;
        c.gridy = 2;
        CalculatorButton n5Button = new CalculatorButton("5",c.gridx,c.gridy);
        n5Button.addActionListener(new NumberButtonListener());
        panel.add(n5Button, c);

        c.gridx = 1;
        c.gridy = 3;
        CalculatorButton n2Button = new CalculatorButton("2",c.gridx,c.gridy);
        n2Button.addActionListener(new NumberButtonListener());
        panel.add(n2Button, c);

        c.gridx = 2;
        c.gridy = 4;
        CalculatorButton decimalButton = new CalculatorButton(".",c.gridx,c.gridy);
        decimalButton.addActionListener(new DecimalButtonListener());
        panel.add(decimalButton, c);

        c.gridx = 2;
        c.gridy = 0;
        CalculatorButton percentButton = new CalculatorButton("%",c.gridx,c.gridy);
        percentButton.addActionListener(new PercentButtonListener());
        panel.add(percentButton, c);

        c.gridx = 2;
        c.gridy = 1;
        CalculatorButton n9Button = new CalculatorButton("9",c.gridx,c.gridy);
        n9Button.addActionListener(new NumberButtonListener());
        panel.add(n9Button, c);

        c.gridx = 2;
        c.gridy = 2;
        CalculatorButton n6Button = new CalculatorButton("6",c.gridx,c.gridy);
        n6Button.addActionListener(new NumberButtonListener());
        panel.add(n6Button, c);

        c.gridx = 2;
        c.gridy = 3;
        CalculatorButton n3Button = new CalculatorButton("3",c.gridx,c.gridy);
        n3Button.addActionListener(new NumberButtonListener());
        panel.add(n3Button, c);

        c.gridx = 3;
        c.gridy = 0;
        CalculatorButton divisionButton = new CalculatorButton("÷",c.gridx,c.gridy);
        divisionButton.addActionListener(new OperationButtonListener());
        panel.add(divisionButton, c);

        c.gridx = 3;
        c.gridy = 1;
        CalculatorButton multiplicationButton = new CalculatorButton("x",c.gridx,c.gridy);
        multiplicationButton.addActionListener(new OperationButtonListener());
        panel.add(multiplicationButton, c);

        c.gridx = 3;
        c.gridy = 2;
        CalculatorButton subtractionButton = new CalculatorButton("-",c.gridx,c.gridy);
        subtractionButton.addActionListener(new OperationButtonListener());
        panel.add(subtractionButton, c);

        c.gridx = 3;
        c.gridy = 3;
        CalculatorButton additionButton = new CalculatorButton("+",c.gridx,c.gridy);
        additionButton.addActionListener(new OperationButtonListener());
        panel.add(additionButton, c);

        c.gridx = 3;
        c.gridy = 4;
        CalculatorButton evaluateButton = new CalculatorButton("=",c.gridx,c.gridy);
        evaluateButton.addActionListener(new EvaluateButtonListener());
        panel.add(evaluateButton, c);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.getContentPane().add(displayPanel);
        frame.getContentPane().add(panel);
        frame.setSize(240,348);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton button = (JButton)(event.getSource());

            // If there's no operator set, we're inputting the first value
            if (operator == 'n') {
                value1String += button.getText();
                value1 = Double.parseDouble(value1String);
                display.setText(value1String);
            }
            // If there is an operator set, we're inputting the second value
            else {
                value2String += button.getText();
                value2 = Double.parseDouble(value2String);
                display.setText(value2String);
            }
        }
    }

    class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            value1 = null;
            value1String = "";
            value2 = null;
            value2String = "";
            operator = 'n';
            display.setText("0");
        }
    }

    class SignButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            // If there are two values, change the sign of the second one
            if (value2 != null) {
                value2 = -value2;

                // Format the value to remove unecessary decimal points and zeros
                if (value2 % 1 == 0) {
                    value2String = String.format("%.0f", value2);
                } else {
                    value2String = String.format("%.10f", value2);
                    value2 = round(value2, 10);
                    value2String = value2.toString();
                }
                display.setText(value2String);
            }
            // If there's only one value, change the sign of first value
            else if (value1 != null) {
                value1 = -value1;

                if (value1 % 1 == 0) {
                    value1String = String.format("%.0f", value1);
                } else {
                    value1String = String.format("%.10f", value1);
                    value1 = round(value1, 10);
                    value1String = value1.toString();
                }
                display.setText(value1String);
            }
        }
    }

    class DecimalButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Double newValue;
            
            // If there are two values, add a decimal to the second value
            if (value2String != "") {
                if (!value2String.contains(".")) {
                    value2String += ".";
                    newValue = Double.parseDouble(value2String);
                    value2 = newValue;
                    display.setText(value2String);
                }
            }

            // If there's only one value, add a decimal to that one
            else if (value1String != "") {
                if (!value1String.contains(".") && operator == 'n') {
                    value1String += ".";
                    newValue = Double.parseDouble(value1String);
                    value1 = newValue;
                    display.setText(value1String);
                }
                // If the first value has a decimal already and there is an operator loaded,
                // Then we'll create a new value starting with a decimal
                else if (value2String == "" && operator != 'n') {
                    value2String = "0.";
                    newValue = Double.parseDouble(value2String);
                    value2 = newValue;
                    display.setText(value2String);
                }
            } 
            // If there are no values yet, create a new one starting with a decimal
            else {
                value1String = "0.";
                newValue = Double.parseDouble(value1String);
                value1 = newValue;
                display.setText(value1String);
            }
        }
    }

    class PercentButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            // If there are two values, convert the second one to a percent
            if (value2 != null) {
                value2 = value2 / 100;

                // Format the value to remove unecessary decimal points and zeros
                if (value2 % 1 == 0) {
                    value2String = String.format("%.0f", value2);
                } else {
                    value2String = String.format("%.10f", value2);
                    value2 = round(value2, 10);
                    value2String = value2.toString();
                }

                display.setText(value2String);
            }
            // If there's only one value, convert that one to a percent
            else if (value1 != null) {
                value1 = value1 / 100;

                // Format the value to remove unecessary decimal points and zeros
                if (value1 % 1 == 0) {
                    value1String = String.format("%.0f", value1);
                } else {
                    value1String = String.format("%.10f", value1);
                    value1 = round(value1, 10);
                    value1String = value1.toString();
                }
                display.setText(value1String);
            }
        }
    }

    class OperationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton button = (JButton)(event.getSource());
    
            // If there are two values already, evaluate them and set value2
            // to null to allow for the next value to be input
            if (value2 != null) {

                switch (operator) {
                    case '+':   value1 = value1 + value2;
                                break;
                    case '-':   value1 = value1 - value2;
                                break;
                    case 'x':   value1 = value1 * value2;
                                break;
                    case '÷':   value1 = value1 / value2;
                                break;
                    default:    break;
                } 

                // Format the value to remove unecessary decimal points and zeros
                if (value1 % 1 == 0) {
                    value1String = String.format("%.0f", value1);
                } else {
                    value1String = String.format("%.10f", value1);
                    value1 = round(value1, 10);
                    value1String = value1.toString();
                }

                display.setText(value1String);
                value2 = null;
                value2String = "";
            }

            operator = button.getText().charAt(0);
        }
    }

    class EvaluateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            // If there are two values already, evaluate them and set value2
            // to null to allow for the next value to be input
            if (value1 != null && value2 != null) {
                switch (operator) {
                    case '+':   value1 = value1 + value2;
                                break;
                    case '-':   value1 = value1 - value2;
                                break;
                    case 'x':   value1 = value1 * value2;
                                break;
                    case '÷':   value1 = value1 / value2;
                                break;
                    default:    break;
                } 
            }
            // If there is only one value, evaluate the first value against itself
            else if (value1 != null && value2 == null) {
                switch (operator) {
                    case '+':   value1 = value1 + value1;
                                break;
                    case '-':   value1 = value1 - value1;
                                break;
                    case 'x':   value1 = value1 * value1;
                                break;
                    case '÷':   value1 = value1 / value1;
                                break;
                    default:    break;
                } 
            }

            // Format the value to remove unecessary decimal points and zeros
            if (value1 != null) {
                if (value1 % 1 == 0) {
                    value1String = String.format("%.0f", value1);
                } else {
                    value1String = String.format("%.10f", value1);
                    value1 = round(value1, 10);
                    value1String = value1.toString();
                }

                display.setText(value1String);
            } else {
                display.setText("0");
            }

            value2 = null;
            value2String = "";
        }
    }

    // Helper method to round values to nearest n places
    private static Double round(Double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}