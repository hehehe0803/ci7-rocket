package game.player;

import base.FrameCounter;
import base.GameObjectAttributes;
import base.GameObjectManager;
import input.KeyboardInput;

import java.awt.event.KeyEvent;

public class PlayerShoot implements GameObjectAttributes<Player> {

    public int tripleShotCounter = 0;

    public PlayerShoot() {
    }

    @Override
    public void run(Player gameObject) {
        if (KeyboardInput.instance.isSpace) {
            this.shoot(gameObject);
        }
    }

    public void shoot(Player gameObject){
        if (tripleShotCounter == 0) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(gameObject.velocity.copy().multiply(1.5f));
            GameObjectManager.instance.add(bulletPlayer);
        } else {
            for (double angle = -30; angle <= 30; angle += 30) {
                game.player.BulletPlayer bulletPlayer = new game.player.BulletPlayer();
                bulletPlayer.position.set(gameObject.position);
                bulletPlayer.velocity.set(
                        gameObject.velocity.copy().multiply(2.2f).rotate(angle).add(gameObject.velocity)
                );
                GameObjectManager.instance.add(bulletPlayer);
            }
            tripleShotCounter --;

        }
    }
}