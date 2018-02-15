package ProblemDomain;


public class Coordinates {
  int x;      // x coordinate for a board location (0,1,2)
  int y;      // y coordinate for a board location (0,1,2)
  
  /**
  * Coordinate constructor creates an instance setting the values of x,y,z
  * 
  * @param  x  int x coordinate for a board location (0,1,2)
  * @param  y  int y coordinate for a board location (0,1,2)
  */
  public Coordinates (int x, int y)
  {
      setX(x);
      setY(y);
  }
  /**
  * setX() set x attribute
  * 
  * @param  x  int x coordinate for a board location (0,1,2)
  */
   public void setX(int x)
   {
       this.x = x;
   }
   
  /**
  * getX() get x attribute
  * 
  * @return x  int x coordinate for a board location (0,1,2)
  */
   public int getX()
   {
       return this.x;
   }
   
  /**
  * setY() set y attribute
  * 
  * @param  y  int y coordinate for a board location (0,1,2)
  */
   public void setY(int y)
   {
       this.y = y;
   }
   
  /**
  * getY() get y attribute
  * 
  * @return y  int y coordinate for a board location (0,1,2)
  */
   public int getY()
   {
       return this.y;
   }
   
  /**
  * equals() compare coordinates
  * 
  * @param coord Coordinates - coordinates to compare
  * @return boolean true if all coordinates are equal, false if they are not
  */
   public Boolean equals(Coordinates coord)
   {
       return (getX() == coord.getX() && getY() == coord.getY());
   }
   
  /**
  * toString() create string that represents coordinates
  * 
  * @return String - of x and y values for coordinate
  */
   public String toString()
   {
       return "["+getX()+","+getY()+"]";
   }
}

