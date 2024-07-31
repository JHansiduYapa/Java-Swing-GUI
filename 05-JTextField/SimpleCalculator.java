import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    JTextField tf1, tf2, tf3;
    JButton b1, b2;

    SimpleCalculator() {
        JFrame jFrame = new JFrame();
        tf1 = new JTextField();
        tf1.setBounds(50, 50, 150, 20);
        jFrame.add(tf1);
        tf2 = new JTextField();
        tf2.setBounds(50, 100, 150, 20);
        jFrame.add(tf2);
        tf3 = new JTextField();
        tf3.setBounds(50, 150, 150, 20);
        tf3.setEditable(false);
        jFrame.add(tf3);
        b1 = new JButton("+");
        b1.setBounds(50, 200, 50, 50);
        jFrame.add(b1);
        b2 = new JButton("-");
        b2.setBounds(120, 200, 50, 50);
        jFrame.add(b2);

        // create an action listener
        ActionListener addActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = tf1.getText();
                String s2 = tf2.getText();

                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);

                int c = a + b;
                String n_c = Integer.toString(c);
                tf3.setText(n_c);

            }
        };

        // create an action listener
        ActionListener subActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = tf1.getText();
                String s2 = tf2.getText();

                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);

                int c = a - b;
                String n_c = Integer.toString(c);
                tf3.setText(n_c);

            }
        };
        b2.addActionListener(subActionListener);
        b1.addActionListener(addActionListener);

        // make the frame visible
        jFrame.setLayout(null);
        jFrame.setSize(400,400);
        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        SimpleCalculator n_obj = new SimpleCalculator();
    }
}
