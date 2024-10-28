
import javax.swing.*;

public class APP{
    public static void main(String[] args) throws Exception {
        int boardWidth = 360;
        int boardHieght = 640;
        JFrame frame = new JFrame("Flappy bird");
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHieght);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        flappyBird.requestFocus();
        frame.setVisible(true);


    }
}
