//import base.FrameCounter;
//import base.GameObject;
//import game.enemy.BulletEnemy;
//import game.enemy.Enemy;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EnemyFollow implements Attack {
//
//    public List<BulletEnemy> bulletEnemies;
//    private FrameCounter frameCounter;
//
//    public EnemyFollow() {
//        this.bulletEnemies = new ArrayList<>( );
//        frameCounter = new FrameCounter(30);
//
//    }
//
//
//    @Override
//    public void run(GameObject enemy) {
//        enemy.position.add(((Enemy)enemy).velocity);
//        if (this.frameCounter.run()) {
//            BulletEnemy bulletEnemy = new BulletEnemy( );
//            bulletEnemy.position.set(((Enemy)enemy).position);
//            bulletEnemy.velocity.set(((Enemy)enemy).velocity.copy( ).multiply(1.5f));
//            this.bulletEnemies.add(bulletEnemy);
//            this.frameCounter.reset();
//        }
//        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run( ));
//
//    }
//
//    public void render(Graphics graphics) {
//        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
//    }
//}
//
