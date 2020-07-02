import javax.swing.*;

public class Main {
    private double delaytime = 500000000;

    public Main(){
        JFrame frame = new JFrame();

        Title title = new Title();
        frame.add(title);

        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        for(double i = 0;i<delaytime;i++){
            i++;
        }
        frame.getContentPane().removeAll();
        Panel GamePanel = new Panel();
        frame.add(GamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Simple Snake Game Project");

        frame.pack();
        frame.revalidate();
        frame.repaint();
        GamePanel.requestFocusInWindow();
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Main();
    }
}
