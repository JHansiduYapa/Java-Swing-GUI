import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButton {
    public static void main(String[] args) {
        // create the frame object
        JFrame jFrame = new JFrame();

        // make the button and add to the frame
        JButton jButton = new JButton("Click Here");
        jButton.setBounds(50,50,150,40);
        jFrame.add(jButton);

        // make a textField
        final JTextField tf=new JTextField();
        tf.setBounds(10,10, 150,20);
        jFrame.add(tf);

        // add action listener
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton.setText("Button Clicked!");
            }
        });

        // make the frame visible
        jFrame.setSize(400,400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
