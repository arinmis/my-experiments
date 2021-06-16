public class Players {

    final static char PLAYER1SIGN = '#';
    final static char PLAYER2SIGN = '$';;
    private int player1Score; 
    private int player2Score; 
    private int[] lastIndex; 

    public Players() {
        player1Score = 0;
        player2Score = 0;
        lastIndex = new int[] {1, 1}; // start from center 
    }

    // strategy: picked the highest number available at any given time
    public void play(char[][] grid, int round) {
        int[] maxIndex = findMaxIndex(grid, lastIndex);
        if (round % 2 == 0) { // evens are player1  
            player1Score += Character.getNumericValue(grid[maxIndex[0]][maxIndex[1]]);
            grid[maxIndex[0]][maxIndex[1]] = PLAYER1SIGN; 
        }
        else { // odds are  player2
            player2Score += Character.getNumericValue(grid[maxIndex[0]][maxIndex[1]]);
            grid[maxIndex[0]][maxIndex[1]] = PLAYER2SIGN; 
        }
        lastIndex = maxIndex;
    }

    // find max value which adjacent to 'lastIndex' 
    private int[] findMaxIndex(char[][] grid, int[] lastIndex) {
        int maxValue = -1;
        int[] maxIndex = new int[2];
        // look at row
        for (int i=0; i<grid.length; i++) {
            // skip used number and the center
            if (i == lastIndex[0] || (i == 1 && lastIndex[0] == 1)) 
                continue;
            if (maxValue <= Character.getNumericValue(grid[lastIndex[0]][i])) {
                maxValue = Character.getNumericValue(grid[lastIndex[0]][i]);  
                maxIndex[0] = lastIndex[0];
                maxIndex[1] = i;
            }
        }
        // look at column 
        for (int i=0; i<grid[0].length; i++) {
            // skip used number and the center
            if (i == lastIndex[1] || (i == 1 && lastIndex[0] == 1)) 
                continue;
            if (maxValue <= Character.getNumericValue(grid[i][lastIndex[1]])) {
                maxValue =  Character.getNumericValue(grid[i][lastIndex[1]]);  
                maxIndex[0] = i;
                maxIndex[1] = lastIndex[1];
            }
        }
        
        // when no adjacent value
        if (maxValue == -1) {
            maxIndex = findMaxNoneAdjacent(grid);
        }
        return maxIndex;
    }

    private int[] findMaxNoneAdjacent(char[][] grid) {
        int value = -1;
        int[] maxIndex = new int[2];
        for (int i=0; i<grid.length; i++) { 
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] >= '0' && grid[i][j] <= '9' 
                        && Character.getNumericValue(grid[i][j]) > value)  {
                    value = Character.getNumericValue(grid[i][j]); 
                    maxIndex[0] = i;
                    maxIndex[1] = j;
                } 
            }
        }
        return maxIndex;
    }
    

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

}
