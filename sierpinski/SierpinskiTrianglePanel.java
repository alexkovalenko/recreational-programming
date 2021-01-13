import javax.swing.*;
import java.awt.*;

public class SierpinskiTrianglePanel extends JPanel {

    private static final Color[] COLORS = {Color.WHITE, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = (int) this.getSize().getHeight();
        int width = (int) this.getSize().getWidth();
        int[][] cords = {{width / 2, 50}, {100, height - 50}, {width - 100, height - 50}};
        sierpinski(cords, 10, g);
    }

    private void sierpinski(int[][] cords, int level, Graphics g) {
        drawTriangle(cords, level, g);
        if (level > 0) {
            sierpinski(new int[][]{cords[0], midle(cords[0], cords[1]), midle(cords[0], cords[2])}, level - 1, g);
            sierpinski(new int[][]{cords[1], midle(cords[0], cords[1]), midle(cords[1], cords[2])}, level - 1, g);
            sierpinski(new int[][]{cords[2], midle(cords[2], cords[1]), midle(cords[0], cords[2])}, level - 1, g);
        }

    }

    private void drawTriangle(int[][] cords, int level, Graphics g) {
        Polygon polygon = new Polygon(
                new int[]{cords[0][0], cords[1][0], cords[2][0]},
                new int[]{cords[0][1], cords[1][1], cords[2][1]},
                3);
        g.setColor(COLORS[level % COLORS.length]);
        g.fillPolygon(polygon);
    }

    private int[] midle(int[] a, int[] b) {
        return new int[]{(a[0] + b[0]) / 2, (a[1] + b[1]) / 2};
    }
}
