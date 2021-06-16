import java.util.*;

public class Grid {

    public char[][] grid;

    public Grid() {
        grid = new char[3][3];
    }

    public void setup() {
        ArrayList<Character> numbers = new ArrayList<>();
        for (int i=0; i<10; i++)
            numbers.add(toChar(i));
        // initialize random numbers to grid
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if ( i == 1 && j == 1) // put start to center
                    grid[i][j] = '*';
                else { 
                    int randomIndex = (int)(Math.random() * numbers.size());
                    char temp = numbers.remove(randomIndex); 
                    grid[i][j] = temp;
                }
            }
        }
    }
    
    public void printGrid() { 
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // convert int to char
    private char toChar(int n) { 
        return Character.forDigit(n, 10); 
    }

}
