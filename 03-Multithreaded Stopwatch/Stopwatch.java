import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch {
    private JFrame frame;
    private JPanel btnPanel;
    private JButton reset;
    private JButton start;
    private JButton stop;
    private JLabel timeLabel;
    private TimerThread timerThread;


    public Stopwatch(){
        // make the frame
        frame = new JFrame();
        frame.setSize(300,300);
        frame.setLayout(new BorderLayout());

        // create panel to add button
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        frame.add(btnPanel,BorderLayout.SOUTH);

        //make the components and add them
        reset = new JButton("Reset");
        btnPanel.add(reset);

        start = new JButton("Start");
        btnPanel.add(start);

        stop = new JButton("Stop");
        btnPanel.add(stop);

        // add JLabel to the frame
        timeLabel = new JLabel("00:00:00");
        frame.add(timeLabel,BorderLayout.CENTER);



        // make the frame visible
        frame.setVisible(true);
    }

    private class TimerThread extends Thread{
        private boolean running = false;
        private int hours = 0, minutes = 0, seconds = 0;

        @Override
        public void run() {
            while (true){
                synchronized (this){
                    while (!running){
                        try {
                            wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                seconds++;
                if (seconds == 60){
                    minutes ++;
                    seconds = 0;
                }
                if(minutes == 60){
                    hours ++;
                    minutes =0;
                }
                SwingUtilities.invokeLater(() -> {
                    timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
                });
            }
        }

        // make a method to start timer
        private void startTimer(){
            running = true;
            notify();
        }
        // make method to stop timer
        private  void stopTimer(){
            running = false;
        }

        // make method to reset timer
        public synchronized void resetTimer() {
            running = false;
            hours = 0;
            minutes = 0;
            seconds = 0;
            SwingUtilities.invokeLater(() -> timeLabel.setText("00:00:00"));
        }
    }
    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (timerThread == null) {
                timerThread = new TimerThread();
                timerThread.start();
            }
            timerThread.startTimer();
        }
    }

    private class StopButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (timerThread != null) {
                timerThread.stopTimer();
            }
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (timerThread != null) {
                timerThread.resetTimer();
            }
        }
    }
    // main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Stopwatch::new);
    }
}
