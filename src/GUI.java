import java.awt.*;
import javax.swing.*;

public class GUI {

    private static JFrame jf;
    private static JDialog info;

    public static void main(String[] args) {
        jf = new JFrame("Snake");
        jf.setBounds(new Rectangle(500, 300));
        jf.getContentPane().setBackground(Color.white);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
