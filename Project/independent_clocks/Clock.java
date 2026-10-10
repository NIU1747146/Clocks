package independent_clocks;

import javax.swing.*;

public abstract class Clock implements java.util.Observer {
  // this is just to have in Main.java a list with digital and analog clocks

  protected JPanel panel;
  // this is a container class, contains all the elements of the UI

  public void show() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}