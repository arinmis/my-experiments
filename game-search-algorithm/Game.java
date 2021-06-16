import java.util.Scanner;

public class Game {

    public static void main(String args[]) {
        //Scanner input = new Scanner(System.in);
        Grid grid = new Grid();
        grid.setup();
        System.out.println("------ Initial Grid -------");
        grid.printGrid();
        // create players
        Players players = new Players();
        System.out.println("\tPlayer1 Sign: " + players.PLAYER1SIGN);
        System.out.println("\tPlayer2 Sign: " + players.PLAYER2SIGN);
        System.out.println();
        // there must be 8 round
        for (int i=0; i<8; i++) {
            players.play(grid.grid, i+1);
            // uncomment line below to see step-by-step
            //printState(grid, players, i + 1);
        }
        System.out.println("------ Last Version of Grid -------");
        grid.printGrid();
        System.out.println();
        System.out.println();
        // print final result
        int score1 = players.getPlayer1Score();
        int score2 = players.getPlayer2Score(); 
        if (score1 > score2) 
            System.out.println("Player 1 won");
        else if (score2 > score1)
            System.out.println("Player 2 won");
        else 
            System.out.println("No winner, tie");
        System.out.println("\tPlayer final 1 score: " + score1); 
        System.out.println("\tPlayer final 2 score: " + score2); 
    }

    public static void printState(Grid grid, Players players, int round) { 
        System.out.println("\n------ Round " + round + " ------");
        grid.printGrid();
        System.out.println("\tPlayer 1 score: " + players.getPlayer1Score()); 
        System.out.println("\tPlayer 2 score: " + players.getPlayer2Score()); 
    }

}
