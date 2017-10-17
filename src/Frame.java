import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;

import logic.LevelGenerator;
import logic.Game;
import logic.SnakeDirection;


public class Frame extends JFrame{
    private Game game;
    private int WIN_WIDTH = 500;
    private int WIN_HEIGHT = 500;

    private int SELL_SIZE = 25;

    private class MyPanel extends JPanel{
        public MyPanel(){
            super();
        }

        @Override
        public void paint(Graphics g){
            g.clearRect(0, 0, WIN_WIDTH, WIN_HEIGHT);

            super.paint(g);
            Graphics2D gr2d = (Graphics2D) g;

            gr2d.setPaint(Color.black);

            game.getWalls().forEach(wall ->
                    g.fillRect(wall.x*SELL_SIZE, wall.y*SELL_SIZE, SELL_SIZE, SELL_SIZE));

            gr2d.setPaint(Color.green);
            game.getSnake().forEach(snakePart ->
                    g.fillRect(snakePart.x*SELL_SIZE, snakePart.y*SELL_SIZE, SELL_SIZE, SELL_SIZE));

            gr2d.setPaint(Color.YELLOW);
            g.fillRect(game.getSnakeHead().x*SELL_SIZE, game.getSnakeHead().y*SELL_SIZE, SELL_SIZE, SELL_SIZE);

            gr2d.setPaint(Color.red);
            g.fillRect(game.getApple().x*SELL_SIZE, game.getApple().y*SELL_SIZE, SELL_SIZE, SELL_SIZE);
        }
    }

    private MyPanel panel = new MyPanel();

    public Frame(){
        super("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);

        panel.setDoubleBuffered(true);
        this.add(panel);

        setVisible(true);
    }

    private SnakeDirection snakeDir;
    private boolean isDirectionChanged = false;

    public void execute() throws Exception {
        game = new Game(new LevelGenerator());
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
                "src\\music\\02-Faint.wav"));

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
                panel.repaint();

            }

        }, 0 , 150);

    }

}
