import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Food {

    private int xCor, yCor, width, height;



    public Food(int xCoor, int yCoor, int size) throws IOException {
        this.xCor = xCoor;
        this.yCor = yCoor;
        width = size;
        height = size;
    }

    public void tick() {

    }

    public void draw(Graphics graphics) throws IOException {
        final BufferedImage image = ImageIO.read(new File("src\\apple.png"));
        graphics.drawImage(image,xCor * width - 12,yCor * height - 12,null);
        // graphics.fillRect(xCor * width, yCor * height, width, height);
    }
    public int getxCor(){
        return xCor;
    }
    public void setxCor(int xCoor){
        this.xCor = xCoor;
    }

    public int getyCor(){
        return yCor;
    }
    public void setyCor(int yCoor){
        this.yCor = yCoor;
    }
}
