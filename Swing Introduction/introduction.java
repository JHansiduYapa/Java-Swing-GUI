import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a frame of the GUI
        JFrame jFrame = new JFrame();

        // Make button component
        JButton jButton = new JButton();
        jButton.setBounds(130,100,100, 40);

        // add frame to the button
        jFrame.add(jButton);

        // Make the frame size of the window
        jFrame.setSize(400,500);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

    }
}
