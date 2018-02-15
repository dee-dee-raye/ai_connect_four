package ProblemDomain;

import java.util.Vector;

public class Tribute implements Comparable<Tribute> {
  
  //3 near of its own kind, 3 near of its not kind, middle is open, 2 near it of its kind, 2 near it not its kind
  //this is my vector of coefficients for my weights 
  //my genes
  private Vector<Double> vectOfCoef;
  //this is how many unique genes in the vector there are
  private int numOfCoef=5;
  //this stores if this tribute (individual) is an 'X' or and 'O'
  char repersent;
  //this is used in the min and max alg to determine if it is a min player vs a max
  int player;
  //this is the fitness of each tribute
  int fitness;
  
  //A tribute is the genes I use to repersent the heuristics. They do battle until the strongest remains.
  public Tribute()
  {
    vectOfCoef = new Vector<Double>(numOfCoef);
    for(int x =0; x < numOfCoef; x++)
    {
      vectOfCoef.addElement((Math.random() * 2) - 1);
    }
  }
  
  //sets the fitness of the tribute
  public void setFitness(int fit)
  {
    this.fitness=fit;
  }
  
  //gets the fitness of the tribute
  public int getFitness()
  {
    return this.fitness;
  }
  
  //increment fitness by one
  public void incrementFitness()
  {
    this.fitness++;
  }
  
  //increment fitness by two
  public void incrementFitnessBy2()
  {
    this.fitness=this.fitness+2;
  }
  
  //set the player for min and maxing
  public void setPlayer(int play)
  {
    this.player=play;
  }
  
  //gets the player for min and maxing
  public int getPlayer()
  {
    return this.player;
  }
  
  //set if this tribute is an 'X' or an 'O'
  public void setRepersent(char rep)
  {
    this.repersent=rep;
  }
  
  //get the char for this tribute
  public char getRepersent()
  {
    return this.repersent;
  }
  
  //this returns a string of the tribute's genes
  //used for printing to the console for logs
  public String getStringOfGene()
  {
    String print = "";
    for(int x = 0; x < numOfCoef; x++)
    {
      print = print +"||"+ vectOfCoef.get(x);
    }
    return print;
  }
  
  //get the specific individual gene
  public double getGene(int x)
  {
    return this.vectOfCoef.get(x);
  }
  
  //set an individual gene to something new
  public void setGene(int x, double value)
  {
    this.vectOfCoef.set(x, value);
  }
  
  //get how many individual genes there are
  public int currentSize()
  {
    return this.numOfCoef;
  }
  
  public int compareTo(Tribute compareTribute) {

    int compareQuantity = ((Tribute) compareTribute).getFitness();

    //descending order
    return compareQuantity - this.fitness;

}

}

