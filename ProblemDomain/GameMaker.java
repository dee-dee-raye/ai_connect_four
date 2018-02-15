package ProblemDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameMaker {
  
  //the contestants that will play
  private Contestants contestants;
  //the board we'll use
  private Board board;
  //this will be the tribute used for playing against a pereson
  private Tribute theFinalTribute;
  //this is the id of tribute in the contestants that is being used as the final tribute
  private int idOfCurrentFinalTribute;
  
  //this holds everything together
  //this is essentially our game class, but more mencing 
  public GameMaker()
  {
  //load up our board
    this.board = new Board(6,7);
    FileWriter fw;
    try {
      fw = new FileWriter("file.txt");
      PrintWriter output = new PrintWriter(fw);
    //make 40 contestants
      this.contestants=new Contestants(40);
      System.out.println("LOG of AIs");
      output.println("LOG of AIs");
      System.out.println("");
      output.println("");
      System.out.println("First Batch");
      output.println("First Batch");
      System.out.println(contestants.printContestants());                 //40 are printed
      output.println(contestants.printContestants()); 
      
      tournamentSelection(this.contestants);          //have the contestants play against each other
      
      Training.trainContestants(contestants, true);         //mutate the surviving contestants
      
      System.out.println("");
      output.println("");
      System.out.println("Second Batch");
      output.println("Second Batch");
      System.out.println(contestants.printContestants());                 //roughly 20 are printed
      output.println(contestants.printContestants());
      
      tournamentSelection(this.contestants);          //have the contestants play against each other
      
      Training.trainContestants(contestants,false);          //mutate the surviving contestants
      
      System.out.println("");
      output.println("");
      System.out.println("Third Batch");
      output.println("Third Batch");
      System.out.println(contestants.printContestants());                  //roughly 10 are printed
      output.println(contestants.printContestants());
      
      
      tournamentSelection(this.contestants);          //have the contestants play against each other
      
      Training.trainContestants(contestants,true);          //mutate the surviving contestants
      
      System.out.println("");
      output.println("");
      System.out.println("Fourth Batch");
      output.println("Fourth Batch");
      System.out.println(contestants.printContestants());                   //roughly 5 are printed
      output.println(contestants.printContestants());
      
      tournamentSelection(this.contestants);            //have the contestants play against each other
      
      Training.trainContestants(contestants,false);           //mutate the surviving contestants
      
      System.out.println("");
      output.println("");
      System.out.println("Fifth Batch");
      output.println("Fifth Batch");
      System.out.println(contestants.printContestants());                   //roughly 2 are printed
      output.println(contestants.printContestants());  
      output.close();
      fw.close();
      
    } 
    catch (IOException e) {                                     //in case the file doesn't work
    //make 40 contestants
      this.contestants=new Contestants(40);
      System.out.println("LOG of AIS");
      System.out.println("");
      System.out.println("FirstBatch");
      contestants.printContestants();                 //40 are printed
      
      tournamentSelection(this.contestants);          //have the contestants play against each other
      
      Training.trainContestants(contestants, true);         //mutate the surviving contestants
      
      System.out.println("");
      System.out.println("Second Batch");
      contestants.printContestants();                 //roughly 20 are printed
      
      tournamentSelection(this.contestants);          //have the contestants play against each other
      
      Training.trainContestants(contestants,false);          //mutate the surviving contestants
      
      System.out.println("");
      System.out.println("Third Batch");
      contestants.printContestants();                  //roughly 10 are printed
      
      tournamentSelection(this.contestants);           //have the contestants play against each other
      
      Training.trainContestants(contestants,true);          //mutate the surviving contestants
      
      System.out.println("");
      System.out.println("Fourth Batch");
      contestants.printContestants();                   //roughly 5 are printed
      
      tournamentSelection(this.contestants);            //have the contestants play against each other
      
      Training.trainContestants(contestants,false);           //mutate the surviving contestants
      
      System.out.println("");
      System.out.println("Fifth Batch");
      contestants.printContestants();                   //roughly 2 are printed
      
    
      
    }

    //clean up our board for the human
    this.board.resetBoard();
    //save the id of the finalTribute
    this.idOfCurrentFinalTribute=(int)Math.random()*this.contestants.tributes.size();
    //save the finalTribute
    this.theFinalTribute=this.contestants.getTribute(this.idOfCurrentFinalTribute);
  }
  
  //function to lead up the ai when it is playing against a human
  public Coordinates humanPlayingAI()
  {
    //goes into board and gets the ai's move
    return this.board.computerMove(this.theFinalTribute);
  }
  
  
  //is used for training the ai while a human is playing it
  public void didTributeWin(boolean result)
  {
    String output;
    
    if(result)  //the ai/tribute won
    {
      output="The AI won. New Resulting genes.";
      
    }
    else     //ai lost
    {
    //mutate
      Training.mutate(this.contestants.tributes.get(this.idOfCurrentFinalTribute));
       output="The AI lost. New Resulting genes."; 
    }
    
    System.out.println("");
    System.out.println(output);
    System.out.println(contestants.printContestants());     //roughly 2 are printed
    
  //save the id of the finalTribute
    this.idOfCurrentFinalTribute=(int)Math.random()*this.contestants.tributes.size();
    //save the finalTribute
    this.theFinalTribute=this.contestants.getTribute(this.idOfCurrentFinalTribute);
    
    if(this.contestants.tributes.size() > 10)
    {
      tournamentSelection(this.contestants);
    }
    
  }

  //set the board to be a new board
  public void setBoardPosition(Board newBoard) {
    this.board = newBoard;
    
  }

  //gets the board
  public Board getBoardPosition() {
    return this.board;
  }
  
  //this is what plays the tributes against each other
  //basically the hunger games
  public void tournamentSelection(Contestants cons)
  {
    
    int sizeToStopAt = cons.tributes.size();
    System.out.println(sizeToStopAt);
    
    for(int x =0; x< sizeToStopAt; x++)
    {
      this.contestants.tributes.get(x).setFitness(0);
    }
    
    //get the tributes in a random order
    for(int pi = 0; pi < sizeToStopAt; pi++)
    {
      int randId = (int) Math.floor((Math.random() * sizeToStopAt));
      cons.pickedAtReaping(pi, cons.getTribute(randId));;
    }
    ArrayList<Tribute> survivors = new ArrayList<Tribute>();
    boolean notFinished = true;
    
    //everyone plays against each other
    while(notFinished)
     { 
      Tribute tribute1= cons.tributes.get(0);
      tribute1.repersent='X';
      
      for(int x = 1; x < cons.tributes.size()-1; x++)
      {
        cons.tributes.get(x+1).repersent='O';
        Tribute tribute2 = cons.tributes.get(x+1);
        
        //play 3 times
        int result = this.board.minMaxAlg(tribute1, tribute2);
        if(result == 1)
        {
          tribute1.incrementFitness();
        }
        else if(result == -1)
        {
          cons.tributes.get(x+1).incrementFitnessBy2();
        }
        int result2 = this.board.minMaxAlg(tribute2, tribute1);
        if(result2 == 1)
        {
          tribute1.incrementFitnessBy2();
        }
        else if(result2 == -1)
        {
          cons.tributes.get(x+1).incrementFitness();
        }
        int result3 = this.board.minMaxAlg(tribute1, tribute2);
        if(result3 == 1)
        {
          tribute1.incrementFitness();
        }
        else if(result3 == -1)
        {
          cons.tributes.get(x+1).incrementFitnessBy2();
        }
      }
     
      survivors.add(tribute1);
      cons.tributes.remove(0);
      
      if(cons.tributes.size()<=1)
      {
        notFinished=false;
      }
    }
    Collections.sort(survivors);
    this.contestants.tributes.clear();
    int sizeToStopAt2 = survivors.size();
    
    //reduce number of tributes
    for(int x =0; x < sizeToStopAt2/4; x++)
    {
      this.contestants.tributes.add(survivors.get(x));
    }
   
  }
 
  //put char onto the board
  public void placeOnBoard(int x, int y, char value)
  {
    this.board.moveToSpot(x, y, value);
  }
  
  //see if there is a winner
  public boolean winCheck(char value)
  {
    return this.board.checkForWin(value);
  }
  
  //see if the board is full
  public boolean gameFull()
  {
    return this.board.isFull();
  }
  
  //clear out the board
  public void resetGame()
  {
    this.board.resetBoard();
  }
  
  //print out the board directly
  public void printBoard()
  {
    System.out.println(this.board.printBoard());
  }

}
