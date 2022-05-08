import javax.swing.*;
import java.awt.*;

class CalculatorButton extends JButton {

    private int buttonWidth = 60;
    private int buttonHeight = 50;
    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;

    public CalculatorButton(String text, int col, int row) {
        super(text);
        setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFont(new Font("Sans-Serif", Font.PLAIN, 20));
        setMargin(new Insets(0, 0, 0, 0));
        setRolloverEnabled(true);
        setColors();
        setBorders(col,row);
    }

    // Method for recoloring button upon hover, pressed, etc.
    @Override protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }

    private void setColors() {
        String text = getText();

        if (text == "÷" || text == "x" || text == "-" || text == "+" || text == "=") {
            setBackground(new Color(255,160,25));
            setHoverBackgroundColor(new Color(255,175,40));
            setPressedBackgroundColor(new Color(255,190,55));
        } else if (text == "AC" || text == "+/-" || text == "%") {
            setBackground(Color.DARK_GRAY);
            setHoverBackgroundColor(new Color(80,80,80));
            setPressedBackgroundColor(new Color(90,90,90));
        } else {
            setBackground(Color.GRAY);
            setHoverBackgroundColor(new Color(140,140,140));
            setPressedBackgroundColor(new Color(150,150,150));
        }
    }

    private void setBorders(int col, int row) {
        if (col < 3) {
            if (row == 0) {
                // Set only right border
                setBorder(BorderFactory.createMatteBorder(0,0,0,1, new Color(40,40,40)));
            } else {
                // Set only right and top border
                setBorder(BorderFactory.createMatteBorder(1,0,0,1, new Color(40,40,40)));
            }
        } if (col == 3) {
            if (row == 0) {
                // Set no borders
                setBorder(BorderFactory.createMatteBorder(0,0,0,0, new Color(40,40,40)));
            } else {
                // Set only top border
                setBorder(BorderFactory.createMatteBorder(1,0,0,0, new Color(40,40,40)));
            }
        }
    }
}