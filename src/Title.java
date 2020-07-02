import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Title extends JPanel {
    private BufferedImage image;
    public Title(){
        initUI();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(586, 185);
    }

    private void initUI() {
        try {
            image = ImageIO.read(new File("src\\snaketitle.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }
}
