package game.player;

import base.GameObjectAttributes;
import base.GameObjectManager;
import input.KeyboardInput;

public class PlayerShoot implements GameObjectAttributes<Player> {

    public int tripleShotCounter = 0;
    public ShootState shootState;

    public PlayerShoot() {
    }

    @Override
    public void run(Player gameObject) {
        if (KeyboardInput.instance.isSpace) {
            this.shoot(gameObject);
        }
    }

    public void shoot(Player gameObject){
//        switch (this.shootState) {
//            case SINGLE:
//                BulletPlayer bulletPlayer = new BulletPlayer();
//                bulletPlayer.position.set(gameObject.position);
//                bulletPlayer.velocity.set(gameObject.velocity.copy().multiply(1.5f));
//                GameObjectManager.instance.add(bulletPlayer);
//                break;
//            case TRIPLE:
//                for (double angle = -30; angle <= 30; angle += 30) {
//                    BulletPlayer bulletPlayer = new game.player.BulletPlayer();
//                    bulletPlayer.position.set(gameObject.position);
//                    bulletPlayer.velocity.set(
//                            gameObject.velocity.copy().multiply(2.2f).rotate(angle).add(gameObject.velocity)
//                    );
//                    GameObjectManager.instance.add(bulletPlayer);
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