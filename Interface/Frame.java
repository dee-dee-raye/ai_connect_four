package Interface;

import javax.swing.JFrame;

public class Frame extends JFrame {
  
  Frame currentFrame = this;
  
  public Frame()
  {
     // setResizable(false);
   
      
      currentFrame.getContentPane().add("Center", new HomePanel(currentFrame));
      currentFrame.pack(); // give a suitable size to window automatically
      currentFrame.setSize(1500, 1500);
      currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      currentFrame.setVisible(true); // make window visible
  }

}
