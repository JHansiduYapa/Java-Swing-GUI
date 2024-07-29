import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCounter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // create the JFrame
            JFrame frame = new JFrame("Simple Counter");
            frame.setSize(300, 200);
            frame.setLayout(new FlowLayout());

            // create the JButton to start the counter
            JButton jButton = new JButton("Start");
            frame.add(jButton);

            // create the JLabel
            JLabel counterLabel = new JLabel("0");
            frame.add(counterLabel);

            // Display the JFrame
            AtomicInteger counter = new AtomicInteger(0);

            // Create and start the counter thread
            Thread counterThread = new Thread(() -> {
                try{
                    while(true){
                        // Increment the counter
                        int currentValue = counter.incrementAndGet();

                        // Update the JLabel on the Event Dispatch Thread
                        SwingUtilities.invokeLater(()->counterLabel.setText(String.valueOf(currentValue)));

                        // sleep for 1s
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });

            // when button pressed start the counter thread
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    counterThread.start();
                }
            });

            // set visible the frame
            frame.setVisible(true);
        });
    }
}
