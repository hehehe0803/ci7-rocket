import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerAttack implements Attack,Renderer{

    public List<BulletPlayer> bulletPlayers;
    private int count = 0;


    public PlayerAttack() {
        this.bulletPlayers = new ArrayList<>();
    }

    @Override
    public void run(GameObject player) {
        if (this.count == 30) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(((Player)player).position);
            bulletPlayer.velocity.set(((Player)player).velocity.copy().multiply(1.5f));
            this.bulletPlayers.add(bulletPlayer);
            this.count = 0;
        } else {
            this.count += 1;
        }
        this.bulletPlayers.forEach(bulletPlayer ->  bulletPlayer.run());

    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}
