package Interface;

import javax.swing.JFrame;


public class UserInterface{
  
  public static void main(String args[])
  {
      JFrame frame = new Frame();
      frame.pack();                  //set the size of the frame based on content
      frame.setVisible(true);        //allows us to see the frame
      frame.setSize(800, 1000);
  }
}

