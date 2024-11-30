import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                //Instantiate RockScissorGUI Object
                RockPaperScissorGUI rockPaperScissorGUI = new RockPaperScissorGUI();

                //Display the GUI
                rockPaperScissorGUI.setVisible(true);
            }
        });
    }
}
