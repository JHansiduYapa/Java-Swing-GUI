import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // create the jframe object
        JFrame jFrame = new JFrame("Button Example");
        // create and add the button
        JButton jButton = new JButton("Click Here");
        jButton.setBounds(50,50,100,40);
        jFrame.add(jButton);
        // frame set the layout
        jFrame.setSize(400,400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}