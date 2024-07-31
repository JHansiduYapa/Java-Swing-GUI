import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        // make a text area jTextArea
        JTextArea jTextArea = new JTextArea("This is new text area...");
        jTextArea.setBounds(50,50,200,200);
        jFrame.add(jTextArea);

        // make the fame visible and make layout
        jFrame.setLayout(null);
        jFrame.setSize(600,600);
        jFrame.setVisible(true);

    }
}