import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckBoxExample {
    JFrame frame;
    JPanel panel;
    JCheckBox ch1,ch2;
    public JCheckBoxExample(){
        // make a frame
        frame = new JFrame();
        frame.setSize(300,300);

        // add a panel
        panel = new JPanel();

        // make a label
        JLabel label = new JLabel("What Programming language is selected");
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);

        // make checkboxes and item listeners
        ch1 = new JCheckBox("C++");
        ch2 = new JCheckBox("Java");

        // get the state and change it
        ch1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                label.setText("C++" + (e.getStateChange() == 1? "checked":"unchecked"));
            }
        });

        // add to the panel
        panel.add(ch1);
        panel.add(ch2);

        // panel add to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JCheckBoxExample();
    }
}
