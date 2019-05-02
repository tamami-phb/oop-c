import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyAnim extends JPanel
    implements ActionListener {

  private final int WIDTH = 350;
  private final int HEIGHT = 350;
  private final int INIT_X = 0;
  private final int INIT_Y = 0;
  private final int DELAY = 25;

  private Image image;
  private Timer timer;
  private int x, y;

  public MyAnim() {
      initUI();
  }

  private void initUI() {
      setBackground(Color.BLUE);
      setPreferredSize(new Dimension(WIDTH, HEIGHT));

      x = INIT_X;
      y = INIT_Y;

      loadImage();

      timer = new Timer(DELAY, this);
      timer.start();
  }

  public void actionPerformed(ActionEvent evt) {
      x++; y++;
      if(y > WIDTH) {
          x = INIT_X;
          y = INIT_Y;
      }

      repaint();
  }

  private void loadImage() {
      ImageIcon icon = new ImageIcon("img/star.png");
      image = icon.getImage();
  }

  @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      gambar(g);
  }

  private void gambar(Graphics g) {
      g.drawImage(image, x, y, this);
      Toolkit.getDefaultToolkit().sync();
  }

}