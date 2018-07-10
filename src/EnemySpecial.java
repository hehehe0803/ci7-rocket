//import base.FrameCounter;
//import base.GameObject;
//import base.Vector2D;
//import game.enemy.BulletEnemy;
//import game.enemy.Enemy;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class EnemySpecial implements Attack {
//
//    private FrameCounter frameCounter;
//
//    private Random random;
//
//    private int speed;
//
//    public List<BulletEnemy> bulletEnemies;
//
//    public EnemySpecial() {
//        random = new Random();
//        this.bulletEnemies = new ArrayList<>( );
//        this.speed = random.nextInt(3) + 1;
//        this.frameCounter = new FrameCounter(50);
//    }
//
//    @Override
//    public void run(GameObject enemy) {
//        enemy.position.add(new Vector2D(speed,0));
//        if (this.frameCounter.run()) {
//            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 10) {
//                BulletEnemy bulletEnemy = new BulletEnemy();
//                bulletEnemy.position.set(enemy.position);
//                bulletEnemy.velocity.set(
//                        (new Vector2D(3.0f, 0.0f)).rotate(angle).add(new Vector2D(speed,0))
//                );
//                this.bulletEnemies.add(bulletEnemy);
//                this.frameCounter.reset();
//            }
//        }
//        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run( ));
//        this.backtoScreen(((Enemy)enemy));
//    }
//
//    private void backtoScreen(Enemy enemy) {
//        if (enemy.position.x < 0) enemy.position.set(1024, this.random.nextInt(600));
//
//        if (enemy.position.x > 1024) enemy.position.set(0, this.random.nextInt(600));
//
//        if (enemy.position.y < 0) enemy.position.set(this.random.nextInt(1024), 600);
//
//        if (enemy.position.y > 600) enemy.position.set(this.random.nextInt(1024), 0);
//    }
//
//    @Override
//    public void render(Graphics graphics) {
//        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
//    }
//}
