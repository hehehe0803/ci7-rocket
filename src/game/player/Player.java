package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.powerup.PowerUp;
import game.powerup.TripleShot;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import javax.swing.*;
import java.awt.*;

public class Player extends GameObject implements PhysicBody {

    public double angle = 0.0;
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private PlayerShoot playerShoot = new PlayerShoot();
    private PlayerMove playerMove = new PlayerMove();
    private RunHitObject runHitObject;


    public Player() {
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.velocity = new Vector2D(3.5f, 0);
        this.boxCollider = new BoxCollider(16, 20);
        this.attributes.add(playerShoot);
        this.attributes.add(playerMove);
        this.runHitObject = new RunHitObject(
                Enemy.class,
                BulletEnemy.class
        );
    }

    @Override
    public void run() {
        super.run();
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 8);
        PowerUp powerUp = GameObjectManager.instance.checkCollision(this.boxCollider, PowerUp.class);
        if (powerUp != null) {
            powerUp.isAlive = false;
            System.out.println("powerup used" );
        }
        if (powerUp instanceof TripleShot) {
            System.out.println("tripleshot" );
            this.playerShoot.tripleShotCounter = 300;
        }
        this.runHitObject.run(this);
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