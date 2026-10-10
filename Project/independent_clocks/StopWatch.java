package independent_clocks;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class StopWatch extends Clock{

  java.time.Duration time;
  ClockTimer timer;
  private JLabel timeLabel;
  private JButton startStopButton;
  private boolean running;
  public StopWatch(ClockTimer timer) {
    this.time = time.ZERO;
    this.timer = timer;

    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(5, 45, 5, 45));
    panel.setPreferredSize(new Dimension(700,180));
    timeLabel = new JLabel();
    timeLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 72));
    timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(timeLabel);
    startStopButton = new JButton("Start");
    startStopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    startStopButton.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        running = !running;
        startStopButton.setText(running ? "Stop" : "Start");
      }
    });
    panel.add(startStopButton);
    timeLabel.setText(format());
  }

  @Override
  public void update(Observable o, Object arg) {
    if (running)
    {
      time = time.plusMillis(timer.getPeriod());
    }
    timeLabel.setText(format());
  }
  private String format() {
    return String.format("%d:%02d:%02d:%03d", time.toHours(), time.toMinutesPart(), time.toSecondsPart(), time.toMillisPart());
  }
}

