package game.powerup;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TripleShot extends PowerUp {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public TripleShot() {
        super();
        this.renderer = new ImageRenderer("resources/images/powerup_triple_shot.png", 20, 20);
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
