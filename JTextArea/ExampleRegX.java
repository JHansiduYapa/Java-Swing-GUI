import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExampleRegX {
    ExampleRegX(){
        // make the JFrame and add components
        JFrame jFrame = new JFrame("Remove Spaces");

        // make the textArea and add it to the frame
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(20,20,100,100);
        jFrame.add(jTextArea);

        // add a button to the frame
        JButton jButton =new JButton("Remove Spaces");
        jButton.setBounds(20 ,130,100,20);
        jFrame.add(jButton);

        // Create the JLabel
        JLabel jLabel = new JLabel();
        jLabel.setBounds(50, 150, 300, 30);
        jFrame.add(jLabel);

        // add action listener to the button
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_string = jTextArea.getText();
                String format_string = user_string.replaceAll("//s","");
                jLabel.setText(format_string);
            }
        });

        // make the frame visible
        jFrame.setLayout(null);
        jFrame.setSize(500,500);
        jFrame.setVisible(true);

    }


    public static void main(String[] args) {
        new ExampleRegX();
    }
}
