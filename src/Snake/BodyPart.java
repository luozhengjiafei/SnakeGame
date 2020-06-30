package Snake;

import java.awt.*;


public class BodyPart {

    private int xCor,yCor,width,height;


    public BodyPart(int xCoor,int yCoor,int size){
        this.xCor = xCoor;
        this.yCor = yCoor;
        width = size;
        height = size;
    }

    public void tick(){

    }
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(xCor*width,yCor*height,width,height);
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
