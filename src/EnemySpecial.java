import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySpecial implements Attack {

    private Random random;

    public List<BulletEnemy> bulletEnemies;
    private int count;

    public EnemySpecial() {
        random = new Random();
        this.bulletEnemies = new ArrayList<>( );
        this.count = 0;
    }

    @Override
    public void run(GameObject enemy) {
        enemy.position.add(new Vector2D(-4,0));
        if (this.count == 30) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 10.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(3.0f, 0.0f)).rotate(angle)
                );
                this.bulletEnemies.add(bulletEnemy);
            }
            this.count = 0;
        } else {
            this.count += 1;
        }
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run( ));
        this.backtoScreen(((Enemy)enemy));
    }

    private void backtoScreen(Enemy enemy) {
        if (enemy.position.x < 0) enemy.position.set(1024, this.random.nextInt(600));

        if (enemy.position.x > 1024) enemy.position.set(0, this.random.nextInt(600));

        if (enemy.position.y < 0) enemy.position.set(this.random.nextInt(1024), 600);

        if (enemy.position.y > 600) enemy.position.set(this.random.nextInt(1024), 0);
    }

    @Override
    public void render(Graphics graphics) {
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
