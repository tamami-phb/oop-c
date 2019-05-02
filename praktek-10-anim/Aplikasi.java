import javax.swing.*;

public class Aplikasi extends JFrame {

    private MyAnim anim;

    public Aplikasi() {
        initUI();
    }

    private void initUI() {
        anim = new MyAnim();
        add(anim);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
    }

}