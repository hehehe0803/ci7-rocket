import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerAttack implements Attack{

    public List<BulletPlayer> bulletPlayers;
    private int count = 0;


    public PlayerAttack() {
        this.bulletPlayers = new ArrayList<>();
    }

    @Override
    public void run(GameObject player) {
        this.bulletPlayers.forEach(bulletPlayer ->  bulletPlayer.run());
        bulletPlayers.removeIf(bulletPlayer ->
                    bulletPlayer.position.x < 0
                ||  bulletPlayer.position.x > 1024
                ||  bulletPlayer.position.y < 0
                ||  bulletPlayer.position.y > 600
        );
    }

    @Override
    public void render(Graphics graphics) {
        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}
