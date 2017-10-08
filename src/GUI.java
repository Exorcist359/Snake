import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{

    private static Game game;
    private final int WIN_WIDTH = 500;
    private final int WIN_HEIGHT = 500;

    public GUI(){
        super("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);

        Container mainFrame = this.getContentPane();
        mainFrame.setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        g.clearRect(0, 0, WIN_WIDTH, WIN_HEIGHT);

        super.paint(g);

        Graphics2D gr2d = (Graphics2D) g;

        gr2d.setPaint(Color.black);
        g.fillRect(100,100, 100, 100);
    }
}
