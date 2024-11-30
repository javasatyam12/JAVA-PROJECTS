//Game Logic

import java.util.Random;

public class RockPaperScissor {
    //All THE CHOICES THAT COMPUTER CHOSES
    private static  final String[] computerChoice = {"Rock" , "Paper" , "Scissor"};

    //Store the computer choice so that we can retrieve the values and display it
    private String computerchoice;

    public String getComputerchoice() {
        return computerchoice;
    }

    public int getComputerScore(){
        return computerScore;
    }
    public int getPlayerScore(){
        return playerScore;
    }

    //Store the score so that we can display the score
    private int computerScore, playerScore;
    //Use to generate the random number to  randomly choose option for the computer
    private Random random;

    //Constructor to intialize the random object
    public RockPaperScissor() {
        random = new Random();
    }
    //Call this method to play the Rock Paper Scissor
    //playerChoice - is the choice made by the player (i.e, Rock,Paper, Scissor)
    //this method will return the result (i.e, computer win , Player Win , draw)
    public String playRockPaperScissor(String playerChoice) {
     //generate computer choices
        computerchoice = computerChoice[random.nextInt(computerChoice.length)];

        //Will continue returning the message indicating the result of the game
        String result = "";

        //Evaluate
        if(computerchoice.equals("Rock")) {
            if(playerChoice.equals("Paper")) {
                result = "Player Win";
                playerScore = playerScore + 1;
            }else if(playerChoice.equals("Scissor")) {
                result = "Computer Win";
                computerScore = computerScore + 1;
            }else {
                result = "Draw";
            }

        }else if(computerchoice.equals("Paper")) {
            if(playerChoice.equals("Scissor")) {
                result = "Player Win";
                playerScore = playerScore + 1;
            }else if(playerChoice.equals("Rock")) {
                result = "Computer Win";
                computerScore = computerScore + 1;
            }else{
                result = "Draw";
            }
        }else{
            //Computer Choses Scissor
            if(computerChoice.equals("Scissor")) {
                if(playerChoice.equals("Rock")) {
                    result = "Player Win";
                    playerScore = playerScore + 1;
                }
                else if(playerChoice.equals("Paper")) {
                    result = "Computer Win";
                    computerScore = computerScore + 1;
                }else{
                    result = "Draw";
                }
            }
        }
        return result;
    }
}
