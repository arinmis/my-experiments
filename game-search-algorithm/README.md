# Game Search Algorithm

- This is 3x3 grid game, grid has 8 number(center of the grid doesn't used) 
- Game can be played between two player 
- Aim of the players are making highest score as they can.
- In this program both of the players uses 'greedy strategy' means that they always choose maximum number from their selectable number set. 

## Rules of the game
    * Each turn only one player can choose only one number, and turn alternates between players 
    * Player can only choose number that are same row or column with previously choosen number
    * Player 1 starts game on the center( filled with star in array)
    * If there is no available number in same row or column, player can choose any of them 
    * Game terminates when there is no number(after 8 turn)
    
