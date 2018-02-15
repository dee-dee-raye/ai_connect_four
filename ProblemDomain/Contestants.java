package ProblemDomain;

import java.util.ArrayList;

public class Contestants {
  
 //this is the group of tributes tha do battle
 ArrayList<Tribute> tributes;
  
  //a contestants is a group of tributes
  public Contestants(int size)
  {
    tributes = new ArrayList<Tribute>();
    
    for(int x = 0; x < size; x++)
    {
      Tribute tempTribute = new Tribute();
      
      pickedAtReaping(x, tempTribute);
    }
  }
  
  //this is another contructor used when there is already a ArrayList of the tributes
  public Contestants(ArrayList<Tribute> t)
  {
    this.tributes=t;
  }
  
  //get an individual tribute from the contestants
  public Tribute getTribute(int index)
  {
    return tributes.get(index);
  }
  
  //get the current number of tributes
  public int numOfContestants()
  {
    return tributes.size();
  }
  
  //this what adds the tributes created in the constructor to the list inside contestants
  public void pickedAtReaping(int index, Tribute tribute)
  {
    this.tributes.add(index, tribute);
  }
  
  //this prints out all the tributes
  public String printContestants()
  {
    String print="";
    for(Tribute tribute : this.tributes)
    {
      print = tribute.getStringOfGene() + "Fitness: "+ tribute.getFitness()+ " " + "\n" + print;
    }
    print = print + "3 near of its own kind, 3 near of its not kind, middle is open, 2 near it of its kind, 2 near it not its kind";
    return print;
  }

}
