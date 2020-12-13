package custom_events;

import javax.swing.*;

public class SimpleButtonTest extends JFrame {
  public SimpleButtonTest() {
    super("SimpleButtonTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    SimpleButton button = new SimpleButton();

    button.addButtonPressListener(new ButtonPressListener() {
      @Override
      public void buttonPressed(ButtonPressEvent e) {
        System.out.println("1!");
      }
    });

    button.addButtonPressListener(new ButtonL());

    JPanel contents = new JPanel();
    contents.add(button);
    setContentPane(contents);
    setSize(400, 300);
    setVisible(true);
  }

  class ButtonL implements ButtonPressListener {

    @Override
    public void buttonPressed(ButtonPressEvent e) {
      System.out.println("2!");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        @Override
        public void run() {
          new SimpleButtonTest();
        }
      }
    );
  }
}
