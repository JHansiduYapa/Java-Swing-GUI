import javax.swing.*;

public class SimpleConstructor {
    JFrame jFrame;

    SimpleConstructor(){
        jFrame = new JFrame(); // Initialize the frame

        // Make the button and add
        JButton btn = new JButton("click");
        btn.setBounds(200,300,300,50);
        jFrame.add(btn);

        // make frame size and make it visible
        jFrame.setSize(500,500);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleConstructor();
    }
}
