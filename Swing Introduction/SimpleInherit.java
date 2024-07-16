import javax.swing.*;

public class SimpleInherit extends JFrame {
    JFrame jFrame; // no need to call the constructor new SimpleInherit(); object call
    SimpleInherit(){
        JButton btn = new JButton();
        btn.setBounds(100,100,100,20);

        // add the button
        add(btn);
        setSize(400,500);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleInherit();
    }
}
