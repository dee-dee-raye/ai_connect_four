package ProblemDomain;

import java.util.ArrayList;


public class Board {
  //rows
  int height;
  //cols
  int width;
  //the used board
  char[][] self;
  //a shadow of the used board
  //used to clean up self[][]
  char [][] oldSelf;
 
 
  //this class is used for min and maxing
  private static class Move {
    int x;
    int y;
    double score;
    
    public Move()
    {
      
    }
    
    public Move(int x, int y)
    {
      this.x=x;
      this.y=y;
    }
    
    public Move(double s)
    {
      this.score=s;
    }
    
    public void setScore(double s)
    {
      this.score=s;
    }
    
  }
  
  
   //board is 
   //- - - - - - -
   //- - - - - - -
   //- - - - - - -
   //- - - - - - -
   //- - - - - - -
   //- - - - - - -
  public Board(int row, int col)
  {
    this.self = new char[row][col];
    this.height=row;
    this.width=col;
    this.oldSelf = new char[row][col];
    //fills out the boards with blanks
    clearOldSelf();
    clearBoard();
  }
  
  
  //get the size of the board self[][]
  public int getSize()
  {
    return this.self.length;
  }
  
  //reload shelf[][] with another [][]
  //helps with avoiding shallow copies
  public void setSelf(char[][] src)
  {
    for(int row = 0; row< this.height; row++)
    {
      for(int col=0; col<this.width; col++)
      {
        this.self[row][col]=src[row][col];
      }
    }
  }
  
  //get a string representation of the board
  //for the console
  public String printBoard()
  {
    String print = "";

    for(int row = this.height-1; row >= 0; row--)
    {
      
      for(int col = 0; col < this.width; col++)
      {
        print=print +"|"+this.self[row][col]+"|\t";
      }
      print = print +"\n";
    }
    return print;
    
  }
  
  //start the board fresh
  public void resetBoard()
  {
    clearBoard();
  }
  
  //fill everything with blanks
  private void clearBoard()
  {
    for(int row = 0; row < this.height; row++)
    {
      for(int col = 0; col < this.width; col++)
      {
        this.self[row][col]=' ';
      }
    }
  }
  
  //fill everything in oldSelf[][] with blanks
  private void clearOldSelf()
  {
    for(int row = 0; row < this.height; row++)
    {
      for(int col = 0; col < this.width; col++)
      {
        this.oldSelf[row][col]=' ';
      }
    }
  }
  
  //move a char to the next open spot in a col
  public int move(char value, int col)
  {
    boolean canAdd = canAddToCol(col);
    int rowToReturn=-1;
    
    
    if(canAdd)        //the col is not full
    {
      boolean stop = false;
      
      for(int row = 0; row < this.height && !stop; row++)
      {
        if(this.self[row][col]!='X' && this.self[row][col]!='O')
        {
          this.self[row][col] = value;
          stop = true;
          rowToReturn = row;
        }
      }
    }

    return rowToReturn;
  }
  
  //move a char to a particular spot
  public void moveToSpot(int row, int col, char value)
  {
    this.self[row][col]=value; 
  }
  
  //get a list of all the cols with space still in them
  public ArrayList<Integer> getEmptySpots()
  {
    boolean dontMoveOn=true;
    ArrayList<Integer> spots = new ArrayList<Integer>();
    for(int col = 0; col<this.width; col++)
    {
      for(int row = 0; row< this.height && dontMoveOn; row++)
      {
        if(this.self[row][col]==' ')
        {
          spots.add(col);
          dontMoveOn=false;
        }
      }
      dontMoveOn=true;
    }
    
    return spots;
  }
  
  //see if there is still room in a col
  private boolean canAddToCol(int col)
  {
    boolean empty = false;
    
    for(int row = 0; row < this.height && !empty; row++)
    {
      if(this.self[row][col] == ' ')
      {
        empty=true;
      }
    }
    return empty;
  }
  
  //remove the highest level item in a col
  public boolean removeMove(int col)
  {
    boolean stop =false;
    for(int row = 0; row < this.height && !stop; row++)
    {
      if(!(this.self[row][col] == ' '))
      {
        this.self[row][col] = ' ';
        stop = true;
      }
    }
    return stop;
  }
  
  //check if the char passed has won
  public boolean checkForWin(char value)
  {
    boolean foundWin = false;
    
    if(!foundWin)
    {
      foundWin = checkHorizontalWin(value);
    }
    
    if(!foundWin)
    {
      foundWin = checkVerticalWin(value);
    }
    
    if(!foundWin)
    {
      foundWin = checkDiagonalWin3(value);
    }
    
    return foundWin;
  }
  
  //checks for a horizontal win
  private boolean checkHorizontalWin(char value)
  {
    boolean foundWin = false;
    for(int row = 0; row < this.height && !foundWin; row++)
    {
      for(int col = 0; col < this.width && !foundWin; col++)
      {
        if(col + 3 < this.width)
        if(this.self[row][col]==value && this.self[row][col+1] == value && this.self[row][col+2] == value &&
            this.self[row][col+3] == value)
        {
          foundWin = true;
        }
      }
    }
    return foundWin;
  }
  
  //checks for a vertical win
  private boolean checkVerticalWin(char value)
  {
    boolean foundWin = false;
    for(int col = 0; col < this.width && !foundWin; col++)
    {
      for(int row = 0; row < this.height && !foundWin; row++)
      {
        if(row+3 < this.height)
        if(this.self[row][col]==value && this.self[row+1][col] == value && this.self[row+2][col] == value &&
            this.self[row+3][col] == value)
        {
          foundWin = true;
        }
      }
    }
    return foundWin;
  }
  
  //checks for a diagonal win
  private boolean checkDiagonalWin3(char value)
  {
    boolean foundWin = false;
    
    for(int row = 0; row < this.height && !foundWin; row++)
    {
      for(int col = 0; col < this.width && !foundWin; col++)
      {
    
    
    if((col==0 || col==1 || col==2 || col==3) && row < 3)
    {
      if(this.self[row][col] == value && this.self[row+1][col+1]== value && this.self[row+2][col+2] == value && this.self[row+3][col+3]==value)
      {
        foundWin=true;
      }
      
    }
    else if((col==0 || col==1 || col==2 || col==3) && row > 3)
    {
      if(this.self[row][col] == value && this.self[row-1][col+1]== value && this.self[row-2][col+2] == value && this.self[row-3][col+3]==value)
      {
        foundWin=true;
      }
      
    }
    else if(col==3 && row>=3)
    {
      if(this.self[row][col]==value && this.self[row-1][col-1]== value && this.self[row-2][col-2] == value && this.self[row-3][col-3]==value)
      {
        foundWin=true;
      }
    }
    else if((col==4 || col==5 || col==6)&& row >=3)
    {
      if(this.self[row][col]==value && this.self[row-1][col-1]== value && this.self[row-2][col-2] == value && this.self[row-3][col-3]==value)
      {
        foundWin=true;
      }
    }
    else if((col==4 || col==5 || col==6)&& row < 3)
    {
      if(this.self[row][col]==value && this.self[row+1][col-1]== value && this.self[row+2][col-2] == value && this.self[row+3][col-3]==value)
      {
        foundWin=true;
      }
    }
    
      }
    }
    return foundWin;
  }
 
  
  //get the fitness (heuristic for the boards current status
  public double getFitness(char rep, Tribute tribute)
  {
    int result =0;
    char opp = 'X';
    
    if(rep=='X')
    {
      opp='O';
    }
    
    
    double strengthThreeOppInRole = tribute.getGene(1);
    
    double strengthThreeInRole = tribute.getGene(0);
    
    
    double strengthIfFirstMiddle = tribute.getGene(2);
    
    
    
    double strengthIfOppHasOnlyTwoInRole = tribute.getGene(4);
    
    
    double strengthIfTwoInRole = tribute.getGene(3);
    
    double totalFitness=0;
    
    for(int row = 0; row <this.height; row++)
    {
      for(int col = 0; col < this.width; col++)
      {
        double resultStrengthThreeOppInRole=0;
        double resultStrengthIfFirstMiddle=0;
        double resultStrengthIfOppHasOnlyTwoInRole=0;
        double resultStrengthIfTwoInRole=0;
        double resultStrengthThreeInRole=0;
        
        if(this.self[row][col]==rep)
        {
        
        if(three(rep, row, col))
        {
          resultStrengthThreeInRole=1;
        }
        if(three(opp,row,col))
        {
          resultStrengthThreeOppInRole=1;
        }
        if(two(rep, row, col))
        {
          resultStrengthIfTwoInRole=1;
        }
        if(two(opp,row,col))
        {
          resultStrengthIfOppHasOnlyTwoInRole=1;
        }
        if(row==0 && col == 3)
        {
          resultStrengthIfFirstMiddle=1;
        }
        
        resultStrengthThreeInRole=resultStrengthThreeInRole*strengthThreeInRole;
        resultStrengthThreeOppInRole=resultStrengthThreeOppInRole*strengthThreeOppInRole;
        resultStrengthIfTwoInRole=resultStrengthIfTwoInRole*strengthIfTwoInRole;
        resultStrengthIfOppHasOnlyTwoInRole=resultStrengthIfOppHasOnlyTwoInRole*strengthIfOppHasOnlyTwoInRole;
        resultStrengthIfFirstMiddle = resultStrengthIfFirstMiddle * strengthIfFirstMiddle;
        
        totalFitness = totalFitness + (resultStrengthThreeInRole+resultStrengthThreeOppInRole+resultStrengthIfTwoInRole + 
            resultStrengthIfOppHasOnlyTwoInRole + resultStrengthIfFirstMiddle);
        
        }
      }
    }
   
    return totalFitness;
     
  }
  
  //check for 3 together at a spot
  private boolean three(char value, int row, int col)
  {
    boolean found = false;
    
    if(threeInRowHorizontal(value,row,col))
    {
      found=true;
    }
    else if(!found && threeInRowVertical(value, row, col))
    {
      found = true;
    }
    else if(!found && threeinRowDiagonal(value, row, col))
    {
      found = true;
    }
    
    return found;
  }
  
  //checks for 2 together at a spot
  private boolean two(char value, int row, int col)
  {
    boolean found = false;
    
    if(twoInRoleHorizontal(value,row,col))
    {
      found=true;
    }
    else if(!found && twoInRoleVertical(value, row, col))
    {
      found = true;
    }
    else if(!found && twoInRowDiagonal(value, row, col))
    {
      found = true;
    }
    
    return found;
  }
  
  //checks for 3 horizontal based on a spot
  private boolean threeInRowHorizontal(char value, int row, int col)
  {
    boolean foundWin = false;
    if(col==0 || col==1 || col==2)
    {
      if(this.self[row][col+1]==value && this.self[row][col+2] == value && this.self[row][col+3] == value)
      {
        foundWin = true;
      }
    }
    else if((col==3))
    {
      if(this.self[row][col+1]==value && this.self[row][col+2] == value && this.self[row][col+3] == value)
      {
        foundWin = true;
      }
      if(this.self[row][col-1]==value && this.self[row][col-2] == value && this.self[row][col-3] == value)
      {
        foundWin=true;
      }
    }
    else
    {
      if(this.self[row][col-1]==value && this.self[row][col-2] == value && this.self[row][col-3] == value)
      {
        foundWin=true;
      }
    }
    return foundWin;
  }
  
  //Checks if there are three values togerther around a spot
  private boolean threeInRowVertical(char value, int row, int col)
  {
    boolean foundWin = false;
    
    if(row==0 || row == 1 || row == 2)
    {
      if(this.self[row+1][col] == value && this.self[row+2][col] == value && this.self[row+3][col] == value)
      {
        foundWin = true;
      }
    }
    else
    {
      if(this.self[row-1][col] == value && this.self[row-2][col] == value && this.self[row-3][col] == value)
      {
        foundWin = true;
      }
    }
    
    return foundWin;
  }
  
  //chekcs if there are 3 diagonal near a spot
  private boolean threeinRowDiagonal(char value, int row, int col)
  {
    boolean foundWin = false;
    
    if((col==0 || col==1 || col==2 || col==3) && row < 3)
    {
      if(this.self[row+1][col+1]== value && this.self[row+2][col+2] == value && this.self[row+3][col+3]==value)
      {
        foundWin=true;
      }
      
    }
    else if(col==3 && row>=3)
    {
      if(this.self[row-1][col-1]== value && this.self[row-2][col-2] == value && this.self[row-3][col-3]==value)
      {
        foundWin=true;
      }
    }
    else if((col==4 || col==5 || col==6)&& row >=3)
    {
      if(this.self[row-1][col-1]== value && this.self[row-2][col-2] == value && this.self[row-3][col-3]==value)
      {
        foundWin=true;
      }
    }
    
    return foundWin;
  }
  
  //checks for 2 together nera a spot
  private boolean twoInRoleHorizontal(char value, int row, int col)
  {
    boolean foundWin = false;
    if(col==0 || col==1)
    {
      if(this.self[row][col+1]==value && this.self[row][col+2] == value)
      {
        foundWin = true;
      }
    }
    else if((col==2 || col==3 || col == 4))
    {
      if(this.self[row][col+1]==value && this.self[row][col+2] == value)
      {
        foundWin = true;
      }
      if(this.self[row][col-1]==value && this.self[row][col-2] == value)
      {
        foundWin=true;
      }
    }
    else
    {
      if(this.self[row][col-1]==value && this.self[row][col-2] == value)
      {
        foundWin=true;
      }
    }
    return foundWin;
  }
  
  //checks for 2 together vertically near a spot
  private boolean twoInRoleVertical(char value, int row, int col)
  {
    boolean foundWin = false;
    
    if(row==0 || row == 1)
    {
      if(this.self[row+1][col] == value && this.self[row+2][col] == value && this.self[row+3][col] == value)
      {
        foundWin = true;
      }
    }
    else if(row == 2 || row==3)
    {
      if(this.self[row+1][col] == value && this.self[row+2][col] == value)
      {
        foundWin = true;
      }
      if(this.self[row-1][col] == value && this.self[row-2][col] == value)
      {
        foundWin = true;
      }
    }
    else
    {
      if(this.self[row-1][col] == value && this.self[row-2][col] == value && this.self[row-3][col] == value)
      {
        foundWin = true;
      }
    }
    return foundWin;
  }
  
  //checks for 2 together near a spot diagonally
  private boolean twoInRowDiagonal(char value, int row, int col)
  {
    boolean foundWin = false;
    
    
    if((col==0 || col==1) && row < 4)
    {
      if(this.self[row+1][col+1]== value && this.self[row+2][col+2] == value)
      {
        foundWin=true;
      }
      
    }
    else if(col==0 || col==1 && row>=4)
    {
      if(this.self[row-1][col+1]== value && this.self[row-2][col+2] == value)
      {
        foundWin=true;
      }
    }
    else if((col==3 || col==4)&& row <2)
    {
      if(this.self[row+1][col+1]== value && this.self[row+2][col+2] == value)
      {
        foundWin=true;
      }
    }
    else if((col==3 || col==4  || col==5 )&& row>=2)
    {
      if(this.self[row-1][col-1]== value && this.self[row-2][col-2] == value)
      {
        foundWin=true;
      }
    }
    
    return foundWin;
  }
  

//checks board to see if all blanks are gone  
  public boolean isFull()
  {
    boolean empty=true;
    for(int row = 0; row< this.height && empty; row++)
    {
      for(int col = 0; col < this.width && empty; col++)
      {
        if(this.self[row][col]==' ')
        {
          empty=false;
        }
      }
    }
    return empty;
  }
 
 //get the row from the col 
  public int getRowFromCol(int col)
  {
    int location = 0;
    boolean notFound = true;
    for(int row = 0; row <this.height && notFound; row++)
    {
      if(this.self[row][col] == ' ')
      {
        location = row;
        notFound = false;
      }
    }
    return location;
  }
  
  //is used to control the hunger games face offs
  public int minMaxAlg(Tribute tribute1, Tribute tribute2)
  {
    while(!this.isFull() && !this.checkForWin('X') && !this.checkForWin('O'))
    {
      
    //clear out board and reset
      this.resetBoard();
      this.setSelf(this.oldSelf);
      
          Coordinates coord1 = min(tribute1.repersent, tribute1);
          this.oldSelf[coord1.x][coord1.y]=tribute1.repersent;
          this.moveToSpot(coord1.x, coord1.y, tribute1.repersent);
          
      this.resetBoard();
      this.setSelf(this.oldSelf);
      
          Coordinates coord2 = max(tribute2.repersent, tribute2);
          this.oldSelf[coord2.x][coord2.y]=tribute2.repersent;
          this.moveToSpot(coord2.x, coord2.y, tribute2.repersent);
          
        //clear out board and reset
          this.resetBoard();
          this.setSelf(this.oldSelf);
    }
   if(this.checkForWin('X'))
    {
      return 1;  
    }
   if(this.checkForWin('O'))
    {
      return -1;
    }
   else
   {
     return 0;
   }
  }
  
  //does the min tribute for min and max
  public Coordinates min(char value, Tribute tribute)
  {
    int alphaMax = 0;
    int betaMin = 100;
    Move move = minMaxStuff(-1, value, 0, tribute, alphaMax, betaMin);
    
    this.moveToSpot(move.x, move.y, value);
    
    return new Coordinates(move.x, move.y);
  }
  
  
  
 //does the max tribute for min and max
  public Coordinates max(char value, Tribute tribute)
  {
    int alphaMax = 0;
    int betaMin = 100;
    Move move = minMaxStuff(1, value, 0, tribute, alphaMax, betaMin);
    
    this.moveToSpot(move.x, move.y, value);
    
    return new Coordinates(move.x, move.y);
  }
  
  /**
   * minMaxStuff creates tree and then decides which branch to go down in order for computer to win
   * @return move - position to move to along with score for decision making
   */
  public Move minMaxStuff(int player, char value, int depth, Tribute tribute, double alphaMax, double betaMin)
  {
    
   //CASES TO STOP RECURSSION---------------------------------------------------------------------------------------
    if(this.checkForWin('X'))
    {
      if(value == 'X')
      {
        Move tempMove = new Move();
        tempMove.setScore(10);
        return(tempMove);
      }
      else
      {
        Move tempMove = new Move();
        tempMove.setScore(-10);
        return(tempMove); 
      }
      
    }
    if(this.checkForWin('O'))
    {
      if(value == 'O')
      {
        Move tempMove = new Move();
        tempMove.setScore(-10);
        return(tempMove);
      }
      else
      {
        Move tempMove = new Move();
        tempMove.setScore(10);
        return(tempMove);
      }
       
    }
    if(depth==4)
    {
      Move tempMove = new Move();
      tempMove.setScore(this.getFitness(value, tribute));
      return tempMove;
    }
    if(this.isFull())
    {

      Move tempMove = new Move();
      tempMove.setScore(this.getFitness(value, tribute));
      return tempMove;
    }
  
    //GENERATE TREE OF MOVES----------------------------------------------------------------------------------------
    //create new list of moves (the tree with its branches)
   ArrayList<Move> moves = new ArrayList<Move>();
   
   //create list of avialable spots for selections
   ArrayList<Integer> openSpots = new ArrayList<Integer>();
   openSpots=this.getEmptySpots();
    
   //go through all the available spots
    for(Integer col : openSpots)
    {
         
        int row = this.move(value, col);                           //put a move on board based on newly created move
        Move move = new Move(row, col);                            //create new move at this location
         
         if(player==-1)                                           //if player is computer
         {
          
           if(value =='X')
           {
             double score = minMaxStuff(1, 'O', depth+1, tribute, alphaMax, betaMin).score;

               move.setScore(score);    //get score based on human's next move (create a branch)      
           }       
           else
           { double score = minMaxStuff(1, 'X', depth+1, tribute, alphaMax, betaMin).score;
               move.setScore(score);
           }
            
         }
         else                                                       //if player is human
         {
           if(value == 'X')
           {
             double score = minMaxStuff(-1, 'O', depth+1, tribute, alphaMax, betaMin).score;
             

               move.setScore(score);                    //get score based on computer's next move (create a branch)
      
           }
           else
           {
             double score = minMaxStuff(-1, 'X', depth+1, tribute, alphaMax, betaMin).score;
             

               alphaMax = score;
               move.setScore(score);

           }
             
         }
         
         moves.add(move);                                           //store result to later check with min max
         this.removeAtSpot(row, col);                               //reset board to previous state
         
        }
      
    
    //MIN MAX PART---------------------------------------------------------------------------------------------------
    int currentBestMove = 0;                                        //set currentBestMove to zero for now
    if(player==-1)                                                  //if player is computer
    {
      
     
      for(int i =0; i<moves.size(); i++)                            //go through all the moves found (start going through the branches)
      {
        if(moves.get(i).score < betaMin)                           //see if move's score is better than the best score
        {
          currentBestMove=i;                                        //save move location in list 
          betaMin=moves.get(i).score;                              //update best score based on move's score
          
        }
      }
    }
    else                                                            //if player is human
    {
      for(int i =0; i < moves.size(); i++)                          //go through all the moves found (start going through the branches)
      {
        
        if(moves.get(i).score > alphaMax)                            //see if move's score is less than the best score
        {
          currentBestMove=i;                                        //save move location in list
          alphaMax=moves.get(i).score;                               //update best score based on move's score
          
        }
      } 
    }

    return moves.get(currentBestMove);                              //return the best overall move 
  }
  
  //handles the ai when it is playing against a human
  public Coordinates computerMove(Tribute tribute)
  {
    int alphaMax =0;
    int betaMin = 100;
    Move move = minMaxStuff(-1, 'X', 0, tribute, alphaMax, betaMin);
    this.moveToSpot(move.x, move.y, 'X');
    return new Coordinates(move.x, move.y);
  }
  
  //clear up particular spot in the board
  private void removeAtSpot(int x, int y)
  {
    this.self[x][y]=' ';
  }
  

}
