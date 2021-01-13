import javax.swing.*;
import java.awt.*;

public class Runner {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFrameSize(frame);
        frame.getContentPane().add(new SierpinskiTrianglePanel());
        frame.setVisible(true);
    }

    private static void setFrameSize(JFrame frame) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screen);
    }
}
