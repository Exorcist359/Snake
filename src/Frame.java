import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;

import levels.Level;

public class Frame extends JFrame{
    private Game game;
    private int WIN_WIDTH = 500;
    private int WIN_HEIGHT = 500;

    private int SELL_SIZE = 25;
    private final int SEED = 3;
    private final int X_OFFSET = 7;
    private final int Y_OFFSET = 30;

    public Frame(){
        super("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    private SnakeDirection snakeDir;
    private boolean isDirectionChanged = false;

    public void execute() throws Exception {
        game = new Game(new Level(SEED));
        WIN_HEIGHT = game.height * SELL_SIZE+37;
        WIN_WIDTH = game.width * SELL_SIZE+14;

        this.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 37:
                        snakeDir = SnakeDirection.Left;
                        isDirectionChanged = true;
                        break;
                    case 38:
                        snakeDir = SnakeDirection.Up;
                        isDirectionChanged = true;
                        break;
                    case 39:
                        snakeDir = SnakeDirection.Right;
                        isDirectionChanged = true;
                        break;
                    case 40:
                        snakeDir = SnakeDirection.Down;
                        isDirectionChanged = true;
                        break;

                }
            }
        });
        //start music
        AudioInputStream ais = AudioSystem.getAudioInputStream(new java.io.File(
                "A:\\Users\\Александр\\Downloads\\Linkin Park\\Extended Plays\\2010 - 8 bit Rebellion\\04-In-The-End.wav"));

        Clip clip = AudioSystem.getClip();

        if (true) {
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
        }
        //end music
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if(isDirectionChanged){
                    game.changeSnakeDirection(snakeDir);
                    isDirectionChanged = false;
                };
                game.tick();
                if(game.isGameOver() == true)
                    t.cancel();
                repaint();

            }

        }, 0 , 200);

    }

    @Override
    public void paint(Graphics g){
        g.clearRect(0, 0, WIN_WIDTH, WIN_HEIGHT);

        super.paint(g);
        Graphics2D gr2d = (Graphics2D) g;

        gr2d.setPaint(Color.black);

        game.getWalls().forEach(wall ->
                g.fillRect(wall.column*SELL_SIZE+X_OFFSET, wall.row*SELL_SIZE+Y_OFFSET, SELL_SIZE, SELL_SIZE));

        gr2d.setPaint(Color.green);
        game.getSnake().forEach(snakePart ->
                g.fillRect(snakePart.column*SELL_SIZE+X_OFFSET, snakePart.row*SELL_SIZE+Y_OFFSET, SELL_SIZE, SELL_SIZE));

        gr2d.setPaint(Color.YELLOW);
        g.fillRect(game.getSnakeHead().column*SELL_SIZE+X_OFFSET, game.getSnakeHead().row*SELL_SIZE+Y_OFFSET,
                SELL_SIZE, SELL_SIZE);

        gr2d.setPaint(Color.red);
        g.fillRect(game.getApple().column*SELL_SIZE+X_OFFSET, game.getApple().row*SELL_SIZE+Y_OFFSET,
                SELL_SIZE, SELL_SIZE);


    }
}
