import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        // make the label
        JLabel jLabel1 , jLabel2;
        jLabel1 = new JLabel("Hansidu Yapa");
        jLabel1.setBounds(50,50,100,100);
        jFrame.add(jLabel1);

        jLabel2 = new JLabel("Java GUI");
        jLabel2.setBounds(50,100,100,100);
        jFrame.add(jLabel2);

        // make the frame size and set bounds
        jFrame.setLayout(null);
        jFrame.setSize(400,400);
        jFrame.setVisible(true);
    }
}