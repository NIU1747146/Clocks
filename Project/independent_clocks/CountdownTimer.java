package independent_clocks;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class CountdownTimer extends Clock {
  java.time.Duration time;
  ClockTimer timer;
  private JLabel timeLabel;
  public CountdownTimer(java.time.Duration time, ClockTimer timer) {
    this.time = time;
    this.timer = timer;

    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(5, 45, 5, 45));
    panel.setPreferredSize(new Dimension(500,120));
    timeLabel = new JLabel();
    timeLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 72));
    timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(timeLabel);
    timeLabel.setText(format());
  }

  @Override
  public void update(Observable o, Object arg) {
    time = time.minusMillis((timer.getPeriod()));
    if (time.isNegative())
    {
      time = time.ZERO;
    }
    timeLabel.setText(format());
  }
  private String format() {
    return String.format("%d:%02d:%02d", time.toHours(), time.toMinutesPart(), time.toSecondsPart());
  }
}

