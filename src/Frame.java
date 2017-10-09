import java.awt.*;
import java.awt.event.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import levels.Level;

public class Frame extends JFrame{

    private static Game game;
    private final int WIN_WIDTH = 500;
    private final int WIN_HEIGHT = 500;
    private final int SEED = 123;

    public Frame(){
        super("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);
        this.getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void execute(){
        Game game = new Game(new Level(SEED));

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 37:
                        game.turn(SnakeDirection.Left);
                        break;
                    case 38:
                        game.turn(SnakeDirection.Up);
                        break;
                    case 39:
                        game.turn(SnakeDirection.Right);
                        break;
                    case 40:
                        game.turn(SnakeDirection.Down);
                }
            }
        });

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                game.tick();
                if(game.gameOver() == true)
                    t.cancel();


            }

        }, 0 , 1*1000);

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
