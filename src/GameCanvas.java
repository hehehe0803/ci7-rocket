import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    Background background;

    private CreateStar createStar;

    public Player player;
    public Enemy enemy1;
    public Enemy enemy2;

    private Random random = new Random();


    public GameCanvas() {

        player = new Player();
        enemy1 = new Enemy(new EnemyFollow());
        enemy2 = new Enemy(new EnemySpecial());
        createStar = new CreateStar();

        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();
        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupPlayer() {
        this.player.position.set(100, 200);
    }

    private void setupEnemy() {
        this.enemy1.position.set(800, 400);
        this.enemy2.position.set(200,50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);

        this.player.render(this.graphics);
        this.enemy1.render(this.graphics);
        this.enemy2.render(this.graphics);
        this.createStar.render(this.graphics);

        this.repaint();
    }

    public void runAll() {
        this.createStar.create();
        this.createStar.run();
        this.runEnemy();
        this.enemy2.run();
        this.player.run();
    }

    public void runEnemy(){
        Vector2D velocity = player.position
                .subtract(this.enemy1.position)
                .normalize()
                .multiply(1.5f);
        this.enemy1.velocity.set(velocity);
        this.enemy1.run();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
