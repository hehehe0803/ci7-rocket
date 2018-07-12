package game.powerup;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PowerUp extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public PowerUp() {
        this.velocity = new Vector2D( );
        this.boxCollider = new BoxCollider(20, 20);
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run( );
        this.position.add(this.velocity);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        this.runHitObject.run(this);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }
}
