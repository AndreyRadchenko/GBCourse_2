package Balls_and_Bricks.bricks;

import Balls_and_Bricks.common.GameCanvas;
import Balls_and_Bricks.common.GameObject;

import java.awt.*;

public class Background implements GameObject {
    private Color color = new Color(123,214,76);

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);
    }
}
