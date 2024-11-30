
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorGUI extends JFrame implements ActionListener {
    //Player Buttons
    JButton rockButton, paperButton, scissorButton;

    //Will Display the choice of the computer
    JLabel computerChoice;

    //will display the score of computer and player
    JLabel computerScoreLabel, playerScoreLabel;

    //backend obj
    RockPaperScissor rockPaperScissor;

    //Constructor for GUI
    public RockPaperScissorGUI() {
        super("Rock Paper Scissor"); // Title of the frame
        setSize(450, 574); // Frame size
        setLayout(null); // Absolute layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit when close
        setLocationRelativeTo(null); // Center window
        rockPaperScissor = new RockPaperScissor(); // Initialize game logic
        addGuiComponents(); // Add components to the frame
    }

    private void addGuiComponents() {
        // Create and set computer score label
        computerScoreLabel = new JLabel("Computer Score: 0");
        computerScoreLabel.setBounds(0, 43, 450, 30);
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScoreLabel);

        // Create computer choice label
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Dialog", Font.BOLD, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        // Create and set player score label
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 317, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        // Player buttons (Rock, Paper, Scissors)
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.BOLD, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        paperButton = new JButton("Paper");
        paperButton.setBounds(160, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.BOLD, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(280, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.BOLD, 18));
        scissorButton.addActionListener(this);
        add(scissorButton);
    }

    // Method to display the result dialog
    private void showDialog(String message) {
        JDialog dialog = new JDialog(this, "Result", true);
        dialog.setSize(226, 124);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);

        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(resultLabel, BorderLayout.CENTER);

        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.addActionListener(e -> {
            // Reset computer choice
            computerChoice.setText("?");
            dialog.dispose(); // Close the dialog
        });
        dialog.add(tryAgainButton, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get player choice from button click
        String playerChoice = e.getActionCommand();

        // Get the result from the game logic
        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        // Load the computer's choice
        computerChoice.setText(rockPaperScissor.getComputerchoice());

        // Update the scores
        computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());

        // Show the result in a dialog
        showDialog(result);
    }
}
