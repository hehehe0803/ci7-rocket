import java.awt.*;

public class BackgroundRenderer implements Renderer {

    private Color color = Color.BLACK;

    public BackgroundRenderer() {

    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.fillRect(0, 0, 1024, 600);

    }
}

