package custom_events;

import java.util.EventListener;

public interface ButtonPressListener extends EventListener {
  void buttonPressed(ButtonPressEvent e);
}
