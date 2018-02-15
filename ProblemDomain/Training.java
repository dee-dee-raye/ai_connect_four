package ProblemDomain;

public class Training {
  
  //used from crossovers
  static double uniformRate = 0.5;
  //used for mutations
  static double mutationRate = 0.02;

  //this mutates all the contestants used 
  static Contestants trainContestants(Contestants cons, boolean mutateOrNot)
  {
    Contestants newContestants = new Contestants(cons.numOfContestants());
    
    //mutate
    for(int x = 0; x < cons.numOfContestants()-1; x++)
    {
      if(mutateOrNot)
      {
        mutate(newContestants.getTribute(x));
      }
      else
      {
        crossover(newContestants.getTribute(x), newContestants.getTribute(x+1));
      }
      
    }
    return newContestants;
  }
  
  //this crossovers two tributes. Used to continue growth after the human begins playing
  public static Tribute crossover(Tribute tribute1, Tribute tribute2)
  {
    Tribute newTribute = new Tribute();
    
    for(int x = 0; x < tribute1.currentSize(); x++)
    {
      if(Math.random() <= uniformRate)
      {
        newTribute.setGene(x, tribute1.getGene(x));
      }
      else
      {
        newTribute.setGene(x, tribute2.getGene(x));
      }
    }
    return newTribute;
  }
  
  //this is a mutate method that returns what was mutated
  static Tribute mutate(Tribute tribute)
  {
    for(int x = 0; x < tribute.currentSize(); x++)
    {
      if(Math.random() <= mutationRate)
      {
        double temp =tribute.getGene(x);
        //-1 ... 1
        temp = Math.random() * 2 - 1;
        tribute.setGene(x, temp);
      }
    }
    return tribute;
  }
  

}
