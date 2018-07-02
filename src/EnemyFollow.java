import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemyFollow implements Attack {

    public List<BulletEnemy> bulletEnemies;
    private int count;

    public EnemyFollow() {
        this.bulletEnemies = new ArrayList<>( );
        this.count = 0;
    }


    @Override
    public void run(GameObject enemy) {
        enemy.position.add(((Enemy)enemy).velocity);
        if (this.count == 30) {
            BulletEnemy bulletEnemy = new BulletEnemy( );
            bulletEnemy.position.set(((Enemy)enemy).position);
            bulletEnemy.velocity.set(((Enemy)enemy).velocity.copy( ).multiply(1.5f));
            this.bulletEnemies.add(bulletEnemy);
            this.count = 0;
        } else {
            this.count += 1;
        }
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run( ));

    }

    public void render(Graphics graphics) {
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}

