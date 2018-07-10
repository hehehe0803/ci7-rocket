package game.powerup;

import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class Shield extends PowerUp {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public Shield() {
        super();
        this.renderer = new ImageRenderer("resources/images/powerup_shield.png", 20, 20);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }
}
