import Snake.BodyPart;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.JOptionPane.getRootFrame;
import static javax.swing.JOptionPane.showMessageDialog;

public class Panel extends JPanel implements Runnable, KeyListener {

    private  static final long serialVersionUID = 1L;
    private static final int width = 400,height = 400;

    private Thread thread;

    private boolean running;

    private boolean right = true,left = false,up = false,down = false;

    private BodyPart body;
    private ArrayList<BodyPart> snake;

    private int xCoor = 10,yCoor = 10,size = 5;

    private int ticks = 0;
    private Food food;
    private ArrayList<Food> foods;

    private Random random;
    private double Factor = 1700000;

    public Panel(){
        setFocusable(true);

        setPreferredSize(new Dimension(width,height));
        addKeyListener(this);

        snake = new ArrayList<BodyPart>();
        foods = new ArrayList<Food>();

        random = new Random();

        start();
    }

    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public void end(){
        running = false;
        try{
            thread.join();
        }catch (InterruptedException error){
            error.printStackTrace();
        }
    }

    public void tick() throws IOException {
        if(snake.size() == 0){
            body = new BodyPart(xCoor,yCoor,10);
            snake.add(body);
        }
        ticks++;
        if(ticks > Factor){
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;
            body = new BodyPart(xCoor,yCoor,10);
            snake.add(body);

            if(snake.size() > size){
                snake.remove(0);
            }
        }
        if(foods.size() == 0){
            int xCoor = random.nextInt(39);
            int yCoor = random.nextInt(39);

            food = new Food(xCoor,yCoor,10);
            foods.add(food);
        }

        for(int i = 0;i < foods.size();i++){
            if(xCoor == foods.get(i).getxCor() && yCoor == foods.get(i).getyCor()){
                size++;
                foods.remove(i);
                i++;
                Factor *= 0.95;
            }
        }

        for(int i =0;i< snake.size();i++){
            if(xCoor == snake.get(i).getxCor() && yCoor == snake.get(i).getyCor()) {
                if(i != snake.size() - 1 ){
                    showMessageDialog(null, "Game Over");
                    end();
                }
            }
        }
        if(xCoor < 0|| xCoor > 39|| yCoor < 0|| yCoor > 39){
            showMessageDialog(null, "Game Over");
            end();
        }
    }

    public void paint(Graphics graphics){
        graphics.clearRect(0,0,width,height);

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src\\grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        graphics.drawImage(image,0,0,null);
        //graphics.fillRect(0,0,width,height);

        for(int i = 0;i<width/10;i++){
             graphics.drawLine(i*10,0,i*10,height);
        }
        for(int i = 0;i<height/10;i++){
            graphics.drawLine(0,i*10,height,i*10);
        }
        for(int i =0;i < snake.size();i++){
                snake.get(i).draw(graphics);
        }
        for(int i =0;i< foods.size();i++){
            try {
                foods.get(i).draw(graphics);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (running){
            try {
                tick();
            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT && !left){
            right = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_LEFT && !right){
            left = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_UP && !down){
            up = true;
            left = false;
            right = false;
        }
        if(key == KeyEvent.VK_DOWN && !up){
            down = true;
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
