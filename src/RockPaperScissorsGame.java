import java.util.*;

public class RockPaperScissorsGame {

    private String[] options;
    private String playerName;
    private String playerOption;
    private String computerOption;
    private int playerWinTotal;
    private int computerWinTotal;
    private int roundCounter = 1;

    public RockPaperScissorsGame() {
        initializeOptions();
        playerWinTotal = 0;
        computerWinTotal = 0;
        setPlayerName();
    }

    public void initializeOptions() {
        options = new String[3];
        options[0] = "Rock";
        options[1] = "Paper";
        options[2] = "Scissors";
    }

    public void setPlayerName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        playerName = sc.nextLine();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerWinTotal() {
        return playerWinTotal;
    }

    public int getComputerWinTotal() {
        return computerWinTotal;
    }

    public void addPlayerWin() {
        playerWinTotal++;
    }

    public void addComputerWin() {
        computerWinTotal++;
    }

    public void setComputerOption() {
        Random random = new Random();
        int randomChoice = random.nextInt(3);
        computerOption = options[randomChoice];
    }

    public String getComputerOption() {
        return computerOption;
    }

    public void chooseWeapon() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nRound " + getRoundCounter() + ":");
        System.out.println("Rock, Paper, or Scissors?");
        playerOption = sc.nextLine();
        playerOption = String.valueOf(playerOption.charAt(0)).toUpperCase() + playerOption.substring(1);
    }

    public String getPlayerOption() {
        return playerOption;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void decideWinner() {
        roundCounter++;
        if(playerOption.equals(getComputerOption())) {
            System.out.println("Tie");
            System.out.println();
        }
        else if(playerOption.equals("Paper") && computerOption.equals("Rock")) {
            System.out.println("Paper beats rock!");
            System.out.println(getPlayerName() + " wins!");
            addPlayerWin();
        }
        else if(playerOption.equals("Rock") && computerOption.equals("Scissors")) {
            System.out.println("Rock pummels scissors!");
            System.out.println(getPlayerName() + " wins!");
            addPlayerWin();
        }
        else if(playerOption.equals("Scissors") && computerOption.equals("Paper")) {
            System.out.println("Scissors cut paper!");
            System.out.println(getPlayerName() + " wins!");
            addPlayerWin();
        }
        else {
            System.out.println(computerOption + " beats " + playerOption);
            System.out.println("Computer wins!");
            addComputerWin();
        }
    }

    public void play() {
        while(true) {
            chooseWeapon();
            setComputerOption();
            System.out.println(getPlayerName() + "'s weapon: " + getPlayerOption());
            System.out.println("Computer's weapon: " + getComputerOption());
            decideWinner();
            if(getComputerWinTotal() == 5) {
                System.out.println("Computer is victorious");
                break;
            }
            else if(getPlayerWinTotal() == 5) {
                System.out.println(getPlayerName() + " is victorious!");
                break;
            }
        }

    }

    public static void main(String[] args) {
        new RockPaperScissorsGame().play();
    }
}