package sreproject;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RenderManager extends JPanel {
    private List<Renderable> renderables = new ArrayList<>();
    private FlappyBirdGameContext context;

    public RenderManager(FlappyBirdGameContext context) {
        this.context = context;
    }

    public void addRenderable(Renderable renderable) {
        renderables.add(renderable);
    }

    public void clearRenderables() {
        renderables.clear();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Renderable r : renderables) {
            r.render(g);
        }
    }
}