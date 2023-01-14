# blueHenChess
Chess-like game in which two players take turns selecting actions until one player has no more pieces left or a team gets three pieces to the other side of the board

Cointains One parent Action class and five extension Action classes:
  -Action
    -ActionAttack
    -ActionMove
    -ActionRecruit
    -ActionSpawn
    -ActionThrowSpear
    
Contains One parent Piece class and six Extension Piece classes, all to construct Piece objects:
  -Piece
    -PieceArcher
    -PieceBlueHen
    -PieceBuzz
    -PieceMinion
      -PieceEvilMinion (is a minion)
    -PieceGuard
    
Contains two Interfaces to classify pieces as actionable:
  -Attacker
  -Spawner
  
Contains a class to construct a GameBoard object
  -GameBoard
  
Contains a class to construct a BoardSquare object:
  -BoardSquare
  
Contains two Game classes to construct game objects:
  -Game
    -GameS22 (is a Game)
    
Contains a Rules class that handles all checks for if an action is valid
  -Rules
  
Contains a Team class to construct a Team object:
  -Team
  
Contains a Text View class that generates the text view of the game:
  -TextView
  
Contains a Controller class to initialize the game and handle user input:
  -Controller
