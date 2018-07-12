package base;

import game.enemy.Enemy;
import game.player.BulletPlayer;
import game.player.Player;
import game.powerup.PowerUp;
import physic.BoxCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager( );

    private ArrayList<GameObject> list = new ArrayList<>( );
    private ArrayList<GameObject> tempList = new ArrayList<>( );

    private GameObjectManager() {
//        this.list = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list
                .stream( )
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run( ));
        this.list.addAll(this.tempList);
        this.tempList.clear( );
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream( )
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer() {
        return (Player) this.list
                .stream( )
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> gameObject.isAlive)
                .findFirst( )
                .orElse(null);
    }

    public Enemy checkCollision(BulletPlayer bulletPlayer) {
        return (Enemy) this.list
                .stream( )
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Enemy)
                .filter(gameObject -> {
                    BoxCollider other = ((Enemy) gameObject).boxCollider;
                    return bulletPlayer.boxCollider.checkCollision(other);
                })
                .findFirst( )
                .orElse(null);
    }
    public PowerUp checkCollisionPowerUp(Player player){
        return (PowerUp) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof PowerUp)
                .filter(gameObject -> {
                    BoxCollider other = ((PowerUp) gameObject).boxCollider;
                    return player.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }
}