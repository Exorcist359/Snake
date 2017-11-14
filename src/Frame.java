import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import logic.*;

public class Frame extends JFrame {
    private GameController gameController;
    private FieldView fieldView;
    private ISnakeBot bot;
    private boolean hasBot;
    private int WIN_WIDTH = 500;
    private int WIN_HEIGHT = 500;

    private int SELL_SIZE = 25;

    private class MyPanel extends JPanel {
        public MyPanel() {
            super();
        }

        @Override
        public void paint(Graphics g) {
            g.clearRect(0, 0, WIN_WIDTH, WIN_HEIGHT);

            super.paint(g);
            Graphics2D gr2d = (Graphics2D) g;


            gr2d.setPaint(Color.BLACK);
            fieldView.getWalls().forEach(wall ->
                    g.fillRect(wall.getPosition().x*SELL_SIZE, wall.getPosition().y*SELL_SIZE, SELL_SIZE, SELL_SIZE));

            gr2d.setPaint(Color.GREEN);
            fieldView.getSnakeParts().forEach(snakePart ->
                    g.fillRect(snakePart.getPosition().x*SELL_SIZE, snakePart.getPosition().y*SELL_SIZE, SELL_SIZE, SELL_SIZE));

            gr2d.setPaint(Color.YELLOW);
            fieldView.getSnakeHeads().forEach(snakePart ->
                    g.fillRect(snakePart.getPosition().x*SELL_SIZE, snakePart.getPosition().y*SELL_SIZE, SELL_SIZE, SELL_SIZE));

            gr2d.setPaint(Color.RED);
            fieldView.getApples().forEach(snakePart ->
                    g.fillRect(snakePart.getPosition().x*SELL_SIZE, snakePart.getPosition().y*SELL_SIZE, SELL_SIZE, SELL_SIZE));

        }
    }

    private MyPanel panel = new MyPanel();

    public Frame(boolean withInnerBot) {
        super("Snake");
        InitFrame();

        hasBot = withInnerBot;
        if (hasBot) {
            InitExternalBot();
        }
    }

    public Frame(ISnakeBot bot) {
        super("Snake");
        InitFrame();

        hasBot = true;
        if (hasBot) {
            this.bot = bot;
        }
    }

    private void InitFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);

        panel.setDoubleBuffered(true);
        this.add(panel);

        setVisible(true);
    }

    private void InitExternalBot() {

    }

    private SnakeDirection snakeDir;
    private boolean isDirectionChanged = false;

    public void execute() throws Exception {
        int playersCount = 1;
        if (hasBot)
            playersCount = 2;
        gameController = new GameController(playersCount);
        fieldView = gameController.getFieldWrapper();
        WIN_HEIGHT = fieldView.getHeight() * SELL_SIZE+37;
        WIN_WIDTH = fieldView.getWidth() * SELL_SIZE+14;

        this.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
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

        /*//start music
        AudioInputStream ais = AudioSystem.getAudioInputStream(new java.io.File(
                "src\\music\\02-Faint.wav"));

        Clip clip = AudioSystem.getClip();

        if (true) {
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
        }
        //end music
        */
        if (hasBot) {
            if (bot == null) {
                // * * *
                // initialize bot from jars !!!
                bot = new MyBot();
            }
            bot.SetSnake(gameController.snakes.get(1));
        }
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(isDirectionChanged) {
                    gameController.snakes.get(0).tryChangeSnakeDirection(snakeDir);
                    isDirectionChanged = false;
                };
                if (hasBot) {
                    bot.getNextDirection(gameController.getFieldWrapper());
                }
                gameController.tick();
                if(gameController.isGameOver())
                    t.cancel();
                panel.repaint();

            }

        }, 0 , 150);
    }
}
