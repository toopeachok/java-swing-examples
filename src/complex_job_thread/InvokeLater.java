package complex_job_thread;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InvokeLater extends JFrame {
  private JButton button;

  public InvokeLater() {
    super("InvokeLater");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    button = new JButton("Выполнить сложную работу");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // запустим отдельный поток
        new ComplexJobThread().start();
        button.setText("Подождите...");
      }
    });
    setLayout(new FlowLayout());
    add(new JTextField(20));
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  // поток, выполняющий "сложную работу"
  class ComplexJobThread extends Thread {
    public void run() {
      try {
        // изобразим задержку
        sleep(3000);
        // работа закончена, нужно изменить интерфейс
        EventQueue.invokeLater(new Runnable() {
          public void run() {
            button.setText("Работа завершена");
          }
        });
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          new InvokeLater();
        }
      });
  }
}