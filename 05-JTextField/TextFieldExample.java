import javax.swing.*;

public class TextFieldExample {
    public static void main(String[] args) {
        // make the frame
        JFrame jFrame = new JFrame();

        // make the textFields
        JTextField textField1, textField2;
        textField1 = new JTextField("This is first text field");
        textField1.setBounds(50,50,100,50);
        jFrame.add(textField1);

        textField2 = new JTextField("Janith Hansidu");
        textField2.setBounds(50,150,100,50);
        jFrame.add(textField2);

        // add the frame bounds and make it visible
        jFrame.setSize(400,400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}