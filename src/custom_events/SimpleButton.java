package custom_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SimpleButton extends JComponent {
  private ArrayList<ButtonPressListener> listenerList = new ArrayList<ButtonPressListener>();

  private ButtonPressEvent event = new ButtonPressEvent(this);

  public SimpleButton() {
    addMouseListener(new PressL());
    setPreferredSize(new Dimension(100, 100));
  }

  public void addButtonPressListener(ButtonPressListener l) {
    listenerList.add(l);
  }

  public void removeButtonPressListener(ButtonPressListener l) {
    listenerList.remove(l);
  }

  public void paintComponent(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(Color.BLACK);
    g.draw3DRect(0, 0, getWidth(), getHeight(), true);
  }

  protected void fireButtonPressed() {
    for (ButtonPressListener l : listenerList) {
      l.buttonPressed(event);
    }
  }

  class PressL extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      fireButtonPressed();
    }
  }
}
