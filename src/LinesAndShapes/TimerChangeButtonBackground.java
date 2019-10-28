package LinesAndShapes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class TimerChangeButtonBackground extends JFrame {
    boolean flag = false;

    JButton button = new JButton("Click to stop");

    Timer timer;

    public TimerChangeButtonBackground() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(button, "Center");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                button.setBackground(Color.red);
            }
        });
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button.setBackground(flag ? Color.green : Color.yellow);
                flag = !flag;
                repaint();
            }
        });
        timer.start();
        pack();
        setVisible(true);
    }

    public static void main(String arg[]) {
        new TimerChangeButtonBackground();
    }
}
