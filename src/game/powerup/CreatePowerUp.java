package game.powerup;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreatePowerUp extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public CreatePowerUp() {
        this.frameCounter = new FrameCounter(500);
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            if (random.nextInt()%2==0) {
                PowerUp powerUp = new TripleShot();
                powerUp.position.set(1024, this.random.nextInt(600));
                powerUp.velocity.set((-(this.random.nextInt(3) + 1)), 0);
                GameObjectManager.instance.add(powerUp);
                this.frameCounter.reset();
                System.out.println("powerup created" );
            } else {
                PowerUp powerUp = new Shield();
                powerUp.position.set(1024, this.random.nextInt(600));
                powerUp.velocity.set((-(this.random.nextInt(3) + 1)), 0);
                GameObjectManager.instance.add(powerUp);
                this.frameCounter.reset();
            }
        }
    }
}