package independent_clocks;

import java.time.LocalDateTime;

public class ClockTimer extends java.util.Observable{
  private int period;
  private java.util.Timer timer;
  private java.util.TimerTask task;

  public ClockTimer(int period) {
    this.period = period;
    this.task = new java.util.TimerTask() {
      public void run() {
        setChanged();
        notifyObservers(LocalDateTime.now());
      }
    };
    this.timer = new java.util.Timer();
    timer.scheduleAtFixedRate(task, period, period);
  }



  public int getPeriod() {return period;}
}
