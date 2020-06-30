import javax.swing.*;

public class Main {

    public Main(){
        JFrame frame = new JFrame();
        Panel GamePanel = new Panel();

        frame.add(GamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Simple Snake Game Project");

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Main();
    }
}
