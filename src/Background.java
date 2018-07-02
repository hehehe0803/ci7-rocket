import java.awt.*;

public class Background extends GameObject {
    public Background(){
        this.renderer = new BackgroundRenderer();
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

}
