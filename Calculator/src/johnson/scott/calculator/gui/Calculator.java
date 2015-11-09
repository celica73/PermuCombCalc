package johnson.scott.calculator.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import johnson.scott.calculator.model.CalculatorModel;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
    private CalculatorModel m;

    private JButton one = new JButton("1");
    private JButton two = new JButton("2");
    private JButton three = new JButton("3");
    private JButton four = new JButton("4");
    private JButton five = new JButton("5");
    private JButton six = new JButton("6");
    private JButton seven = new JButton("7");
    private JButton eight = new JButton("8");
    private JButton nine = new JButton("9");
    private JButton zero = new JButton("0");
    private JButton compute = new JButton("=");
    private JPanel buttons = new JPanel();

    private JLabel instructions = new JLabel(
            "Enter formula separated by spaces, C n r or P n r.",
            (int) CENTER_ALIGNMENT);
    private JTextField param = new JTextField();
    private String answerString;
    private JTextField answer = new JTextField(answerString, (int) CENTER_ALIGNMENT);
    private JPanel inst = new JPanel();

    public Calculator() {
        m = new CalculatorModel();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        buttons.setLayout(new GridLayout(4, 3));
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);
        buttons.add(zero);
        buttons.add(compute);
        c.add(buttons, BorderLayout.EAST);
        inst.setLayout(new GridLayout(3, 1));
        inst.add(instructions);
        inst.add(param);
        inst.add(answer);
        c.add(inst, BorderLayout.WEST);

        setTitle("Permutation and Combination Calculator");
        setSize(550, 150);
        setVisible(true);

        param.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        compute.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(one)) {
            param.setText(param.getText() + "1");
        } else if (e.getSource().equals(two)) {
            param.setText(param.getText() + "2");
        } else if (e.getSource().equals(three)) {
            param.setText(param.getText() + "3");
        } else if (e.getSource().equals(four)) {
            param.setText(param.getText() + "4");
        } else if (e.getSource().equals(five)) {
            param.setText(param.getText() + "5");
        } else if (e.getSource().equals(six)) {
            param.setText(param.getText() + "6");
        } else if (e.getSource().equals(seven)) {
            param.setText(param.getText() + "7");
        } else if (e.getSource().equals(eight)) {
            param.setText(param.getText() + "8");
        } else if (e.getSource().equals(nine)) {
            param.setText(param.getText() + "9");
        } else if (e.getSource().equals(zero)) {
            param.setText(param.getText() + "0");
        } else if (e.getSource().equals(compute)) {
            m.parseLine(param.getText());
            answer.setText(String.format("%s(%d,%d) = %d",
                    m.getCalcType().toUpperCase(), m.getN(), m.getR(),
                    m.getAnswer()));
            param.setText("");
        } else {
            JTextField userEntry = (JTextField) e.getSource();
            m.parseLine(userEntry.getText());
            answer.setText(String.format("%s(%d,%d) = %.0f",
                    m.getCalcType().toUpperCase(), m.getN(), m.getR(),
                    m.getAnswer()));
            param.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
