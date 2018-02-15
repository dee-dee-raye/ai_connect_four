package Interface;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import ProblemDomain.Board;
import ProblemDomain.Coordinates;
import ProblemDomain.GameMaker;

public class HumanPanel extends JPanel {

  //keeps up with scores
  int aiScore =0;
  int humanScore=0;
  JLabel lblToBeUsed;
  JLabel lblAiScore;
  JLabel lblYourScore;
  
  //what we (human) plays through
  public HumanPanel(JFrame currentFrame, GameMaker me) {
   setBackground(Color.CYAN);
    
    setLayout(null);
    ArrayList<Coordinates> locations = new ArrayList<Coordinates>();
    JButton[][] spots =new JButton[6][7];
    
    
    
    
    JPanel panel = new JPanel();
    panel.setBackground(UIManager.getColor("Menu.selectionBackground"));
    panel.setLayout(null);
    panel.setBounds(70, 40, 555, 528);
    add(panel);
    
    JButton row5col0 = new JButton();
    row5col0.setBackground(Color.PINK);
    row5col0.setBounds(21, 18, 70, 70);
    panel.add(row5col0);
    
    spots[5][0]=row5col0;
    
    JButton row5col1 = new JButton();
    row5col1.setBounds(95, 18, 70, 70);
    row5col1.setBackground(Color.PINK);
    panel.add(row5col1);
    
    spots[5][1]=row5col1;
    
    JButton row5col2 = new JButton();
    row5col2.setBounds(169, 18, 70, 70);
    row5col2.setBackground(Color.PINK);
    panel.add(row5col2);
    
    spots[5][2]=row5col2;
    
    JButton row4col0 = new JButton();
    row4col0.setBounds(21, 104, 70, 70);
    row4col0.setBackground(Color.PINK);
    panel.add(row4col0);
    
    spots[4][0]=row4col0;
    
    JButton row4col1 = new JButton();
    row4col1.setBounds(95, 104, 70, 70);
    row4col1.setBackground(Color.PINK);
    panel.add(row4col1);
    
    spots[4][1]=row4col1;
    
    JButton row4col2 = new JButton();
    row4col2.setBounds(169, 104, 70, 70);
    row4col2.setBackground(Color.PINK);
    panel.add(row4col2);
    
    spots[4][2]=row4col2;
    
    JButton row3col0 = new JButton();
    row3col0.setBackground(Color.PINK);
    row3col0.setBounds(21, 187, 70, 70);
    row4col2.setBackground(new Color(0, 204, 204));
    panel.add(row3col0);
    
    spots[3][0]=row3col0;
    
    JButton row3col1 = new JButton();
    row3col1.setBounds(95, 187, 70, 70);
    row3col1.setBackground(Color.PINK);
    panel.add(row3col1);
    
    spots[3][1]=row3col1;
    
    JButton row3col2 = new JButton();
    row3col2.setBounds(169, 187, 70, 70);
    row3col2.setBackground(Color.PINK);
    panel.add(row3col2);
    
    spots[3][2]=row3col2;
    
    JButton row5col3 = new JButton();
    row5col3.setBackground(Color.PINK);
    row5col3.setBounds(243, 18, 70, 70);
    panel.add(row5col3);
    
    spots[5][3]=row5col3;
    
    JButton row3col5 = new JButton();
    row3col5.setBackground(Color.PINK);
    row3col5.setBounds(388, 187, 70, 70);
    panel.add(row3col5);
    
    spots[3][5]=row3col5;
    
    JButton row5col4 = new JButton();
    row5col4.setBackground(Color.PINK);
    row5col4.setBounds(317, 18, 70, 70);
    panel.add(row5col4);
    
    spots[5][4] = row5col4;
    
    JButton row5col5 = new JButton();
    row5col5.setBackground(Color.PINK);
    row5col5.setBounds(388, 18, 70, 70);
    panel.add(row5col5);
    spots[5][5]=row5col5;
    
    JButton row4col5 = new JButton();
    row4col5.setBackground(Color.PINK);
    row4col5.setBounds(388, 104, 70, 70);
    panel.add(row4col5);
    spots[4][5]=row4col5;
    
    JButton row4col3 = new JButton();
    row4col3.setBackground(Color.PINK);
    row4col3.setBounds(243, 104, 70, 70);
    panel.add(row4col3);
    spots[4][3]=row4col3;
    
    JButton row4col4 = new JButton();
    row4col4.setBackground(Color.PINK);
    row4col4.setBounds(317, 104, 70, 70);
    panel.add(row4col4);
    spots[4][4]=row4col4;
    
    JButton row3col3 = new JButton();
    row3col3.setBackground(Color.PINK);
    row3col3.setBounds(243, 187, 70, 70);
    panel.add(row3col3);
    spots[3][3]=row3col3;
    
    JButton row3col4 = new JButton();
    row3col4.setBackground(Color.PINK);
    row3col4.setBounds(317, 187, 70, 70);
    panel.add(row3col4);
    spots[3][4]=row3col4;
    
    JButton row5col6 = new JButton();
    row5col6.setBackground(Color.PINK);
    row5col6.setBounds(465, 18, 70, 70);
    panel.add(row5col6);
    spots[5][6]=row5col6;
    
    JButton row3row6 = new JButton();
    row3row6.setBackground(Color.PINK);
    row3row6.setBounds(465, 187, 70, 70);
    panel.add(row3row6);
    spots[3][6]=row3row6;
    
    JButton row4col6 = new JButton();
    row4col6.setBackground(Color.PINK);
    row4col6.setBounds(465, 104, 70, 70);
    panel.add(row4col6);
    spots[4][6]=row4col6;
    
    JButton row2col0 = new JButton();
    row2col0.setBackground(Color.PINK);
    row2col0.setBounds(21, 266, 70, 70);
    panel.add(row2col0);
    spots[2][0]=row2col0;
    
    JButton row1col0 = new JButton();
    row1col0.setBackground(Color.PINK);
    row1col0.setBounds(21, 352, 70, 70);
    panel.add(row1col0);
    spots[1][0]=row1col0;
    
    JButton row0col0 = new JButton();
    row0col0.setBackground(Color.PINK);
    row0col0.setBounds(21, 435, 70, 70);
    panel.add(row0col0);
    spots[0][0]=row0col0;
    
    JButton row2col1 = new JButton();
    row2col1.setBackground(Color.PINK);
    row2col1.setBounds(95, 266, 70, 70);
    panel.add(row2col1);
    spots[2][1]=row2col1;
    
    JButton row1col1 = new JButton();
    row1col1.setBackground(Color.PINK);
    row1col1.setBounds(95, 352, 70, 70);
    panel.add(row1col1);
    spots[1][1]=row1col1;
    
    JButton row0col1 = new JButton();
    row0col1.setBackground(Color.PINK);
    row0col1.setBounds(95, 435, 70, 70);
    panel.add(row0col1);
    spots[0][1]=row0col1;
    
    JButton row2col2 = new JButton();
    row2col2.setBackground(Color.PINK);
    row2col2.setBounds(169, 266, 70, 70);
    panel.add(row2col2);
    spots[2][2]=row2col2;
    
    JButton row1col2 = new JButton();
    row1col2.setBackground(Color.PINK);
    row1col2.setBounds(169, 352, 70, 70);
    panel.add(row1col2);
    spots[1][2]=row1col2;
    
    JButton row0col2 = new JButton();
    row0col2.setBackground(Color.PINK);
    row0col2.setBounds(169, 435, 70, 70);
    panel.add(row0col2);
    spots[0][2]=row0col2;
    
    JButton row2col3 = new JButton();
    row2col3.setBackground(Color.PINK);
    row2col3.setBounds(243, 266, 70, 70);
    panel.add(row2col3);
    spots[2][3]=row2col3;
    
    JButton row1col3 = new JButton();
    row1col3.setBackground(Color.PINK);
    row1col3.setBounds(243, 352, 70, 70);
    panel.add(row1col3);
    spots[1][3]=row1col3;
    
    JButton row0col3 = new JButton();
    row0col3.setBackground(Color.PINK);
    row0col3.setBounds(243, 435, 70, 70);
    panel.add(row0col3);
    spots[0][3]=row0col3;
    
    JButton row2col4 = new JButton();
    row2col4.setBackground(Color.PINK);
    row2col4.setBounds(317, 266, 70, 70);
    panel.add(row2col4);
    spots[2][4]=row2col4;
    
    JButton row1col4 = new JButton();
    row1col4.setBackground(Color.PINK);
    row1col4.setBounds(317, 352, 70, 70);
    panel.add(row1col4);
    spots[1][4]=row1col4;
    
    JButton row0col4 = new JButton();
    row0col4.setBackground(Color.PINK);
    row0col4.setBounds(317, 435, 70, 70);
    panel.add(row0col4);
    spots[0][4]=row0col4;
    
    JButton row2col5redo = new JButton();
    row2col5redo.setBackground(Color.PINK);
    row2col5redo.setBounds(388, 266, 70, 70);
    panel.add(row2col5redo);
    spots[2][5]=row2col5redo;
    
    JButton row1col5 = new JButton();
    row1col5.setBackground(Color.PINK);
    row1col5.setBounds(388, 352, 70, 70);
    panel.add(row1col5);
    spots[1][5]=row1col5;
    
    JButton row0col5 = new JButton();
    row0col5.setBackground(Color.PINK);
    row0col5.setBounds(388, 435, 70, 70);
    panel.add(row0col5);
    spots[0][5]=row0col5;
    
    JButton row2col6 = new JButton();
    row2col6.setBackground(Color.PINK);
    row2col6.setBounds(465, 266, 70, 70);
    panel.add(row2col6);
    spots[2][6]=row2col6;
    
    JButton row1col6 = new JButton();
    row1col6.setBackground(Color.PINK);
    row1col6.setBounds(465, 352, 70, 70);
    panel.add(row1col6);
    spots[1][6]=row1col6;
    
    JButton row0col6 = new JButton();
    row0col6.setBackground(Color.PINK);
    row0col6.setBounds(465, 435, 70, 70);
    panel.add(row0col6);
    spots[0][6]=row0col6;
    
    JButton button_41 = new JButton("Play Again");
    button_41.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        newGame(spots, me, locations);
      }
    });
  button_41.setBounds(290, 580, 117, 29);
  add(button_41);
  
  computerTurn(spots, me, locations);
    
    JButton drop0 = new JButton("Drop");
    drop0.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int row = me.getBoardPosition().move('O', 0);
        
        spots[row][0].setText("O");
        spots[row][0].setEnabled(false);
        
        computerTurn(spots, me, locations);
      }
    });
    drop0.setBounds(93, 6, 70, 28);
    add(drop0);
    
    JButton drop1 = new JButton("Drop");
    drop1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int row = me.getBoardPosition().move('O', 1);
        
        spots[row][1].setText("O");
        spots[row][1].setEnabled(false);
        
        computerTurn(spots, me, locations);
      }
    });
    drop1.setBounds(161, 6, 70, 28);
    add(drop1);
    
    JButton drop2 = new JButton("Drop");
    drop2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int row = me.getBoardPosition().move('O', 2);
        spots[row][2].setText("O");
        spots[row][2].setEnabled(false);
        
        computerTurn(spots, me, locations);
      }
    });
    drop2.setBounds(236, 6, 70, 28);
    add(drop2);
    
    JButton drop3 = new JButton("Drop");
    drop3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int row = me.getBoardPosition().move('O', 3);
        spots[row][3].setText("O");
        spots[row][3].setEnabled(false);
        
        computerTurn(spots, me, locations);
      }
    });
    drop3.setBounds(311, 6, 70, 28);
    add(drop3);
    
    JButton drop4 = new JButton("Drop");
    drop4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int row = me.getBoardPosition().move('O', 4);
        spots[row][4].setText("O");
        spots[row][4].setEnabled(false);
        
        computerTurn(spots, me, locations);
      }
    });
    drop4.setBounds(383, 6, 70, 28);
    add(drop4);
    
    JButton drop5 = new JButton("Drop");
    drop5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int row = me.getBoardPosition().move('O', 5);
        spots[row][5].setText("O");
        spots[row][5].setEnabled(false);
        
        computerTurn(spots, me, locations);
      }
    });
    drop5.setBounds(458, 6, 70, 28);
    add(drop5);
    
    JButton drop6 = new JButton("Drop");
    drop6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int row = me.getBoardPosition().move('O', 6);
        
        spots[row][6].setText("O");
        spots[row][6].setEnabled(false);
        
        computerTurn(spots, me, locations);
        
        
      }
    });
    drop6.setBounds(533, 6, 70, 28);
    add(drop6);
    
    lblToBeUsed = new JLabel("");
    lblToBeUsed.setHorizontalAlignment(SwingConstants.CENTER);
    lblToBeUsed.setBounds(161, 631, 356, 16);
    add(lblToBeUsed);
    lblToBeUsed.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
    
    JLabel lblScore = new JLabel("AI Score");
    lblScore.setHorizontalAlignment(SwingConstants.CENTER);
    lblScore.setBounds(42, 605, 61, 16);
    add(lblScore);
    lblScore.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    
    lblAiScore = new JLabel("");
    lblAiScore.setText(""+aiScore);
    lblAiScore.setHorizontalAlignment(SwingConstants.CENTER);
    lblAiScore.setBounds(42, 620, 61, 16);
    add(lblAiScore);
    lblAiScore.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    
    JLabel lblScore_1 = new JLabel("Your Score");
    lblScore_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblScore_1.setBounds(577, 605, 70, 16);
    add(lblScore_1);
    lblScore_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    
    lblYourScore = new JLabel("");
    lblYourScore.setText(""+humanScore);
    lblYourScore.setHorizontalAlignment(SwingConstants.CENTER);
    lblYourScore.setBounds(575, 620, 61, 16);
    add(lblYourScore);
    lblYourScore.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    
    
 
    }
  
  public void computerTurn(JButton[][] spotsOnScreen, GameMaker me,  ArrayList<Coordinates> locations)
  {
  //CLEAN UP BOARD AND CHECK FOR WINNER OR DRAW------------------------------------------------------------------
  //clear out board based on what screen displays
    me.getBoardPosition().resetBoard();

   
    for(int x =0; x<6; x++)
    {
      for(int y=0; y<7; y++)
      {
        if(spotsOnScreen[x][y].getText().equals("X"))  //if spot is taken by computer
        {   
          me.placeOnBoard(x, y, 'X');                    //set as computer
        }
        else  if(spotsOnScreen[x][y].getText().equals("O"))          
        {
          me.placeOnBoard(x, y, 'O');                //set as human
        }
        else
        {
          me.placeOnBoard(x, y, ' ');
        }
      }
    }
    
    
                    
    
    
    if(me.winCheck('O'))                       //if human won
    {   
      System.out.println("O won.");
      lblToBeUsed.setText("You Won");          //set big label
      humanScore=humanScore+1;
      lblYourScore.setText(""+humanScore);
      
      //go through all buttons and disable them
      for(int x =0; x<6; x++)
      {
        for(int y=0; y<7; y++)
        {
          spotsOnScreen[x][y].setEnabled(false);
        }
      }
      spotsOnScreen[2][5].setEnabled(false);
      me.didTributeWin(false);
    }
    else if(me.winCheck('X'))                  //if computer won
    {
      System.out.println("X won.");
      lblToBeUsed.setText("AI Won");
      aiScore=aiScore+2;
      lblAiScore.setText(""+aiScore);
      //go through all buttons and disable them
      for(int x =0; x<7; x++)
      {
        for(int y=0; y<6; y++)
        {
          spotsOnScreen[x][y].setEnabled(false);
        }
      }
      spotsOnScreen[2][5].setEnabled(false);
      me.didTributeWin(true);
    }
    else if(me.gameFull())                      //if board is full
    {
      System.out.println("Draw.");                          
      lblToBeUsed.setText("The Cat Won");       //set big label
      
      //go through all buttons and disable them
      for(int x =0; x<6; x++)
      {
        for(int y=0; y<7; y++)
        {
          spotsOnScreen[x][y].setEnabled(false);
        }
      }
      spotsOnScreen[2][5].setEnabled(false);
    }
  //---------------------------------------------------------------------------------------------------------------
  

  
    
  //GET COMPUTER'S MOVE--------------------------------------------------------------------------------------------
    Coordinates spot = me.humanPlayingAI();       //get coordinates of move
    
    //verify spot is valid based on what is displayed to user before setting
    if(spotsOnScreen[spot.getX()][spot.getY()].isEnabled())
    {
      spotsOnScreen[spot.getX()][spot.getY()].setText("X");
      spotsOnScreen[spot.getX()][spot.getY()].setEnabled(false);
      
    }
  //----------------------------------------------------------------------------------------------------------------
    
  //CLEAN UP BOARD AND CHECK FOR WINNER OR DRAW------------------------------------------------------------------
  //clear out board based on what screen displays
    me.resetGame();
  
   
    for(int x =0; x<6; x++)
    {
      for(int y=0; y<7; y++)
      {
        if(spotsOnScreen[x][y].getText().equals("X"))  //if spot is taken by computer
        {   
          me.placeOnBoard(x, y, 'X');                     //set as computer
        }
        else  if(spotsOnScreen[x][y].getText().equals("O"))          
        {
          me.placeOnBoard(x, y, 'O');                   //set as human
        }
        else
        {
          me.placeOnBoard(x, y, ' '); 
        }
      }
    }
    
    
    
    
    if(me.winCheck('O'))                       //if human won
    {   
      System.out.println("O won.");
      lblToBeUsed.setText("You Won");          //set big label
      humanScore=humanScore+1;
      lblYourScore.setText(""+humanScore);
      
      //go through all buttons and disable them
      for(int x =0; x<6; x++)
      {
        for(int y=0; y<7; y++)
        {
          spotsOnScreen[x][y].setEnabled(false);
        }
      }
      spotsOnScreen[2][5].setEnabled(false);
      me.didTributeWin(false);
    }
    else if(me.winCheck('X'))                //if computer won
    {
      System.out.println("X won.");
      lblToBeUsed.setText("AI Won");          //set big label
      aiScore=aiScore + 2;
      lblAiScore.setText(""+aiScore);
     
      //go through all buttons and disable them
      for(int x =0; x<6; x++)
      {
        for(int y=0; y<7; y++)
        {
          spotsOnScreen[x][y].setEnabled(false);
        }
      }
      spotsOnScreen[2][5].setEnabled(false);
      me.didTributeWin(true);
    }
    else if(me.gameFull())                //if board is full
    {
      System.out.println("Draw.");                          
      lblToBeUsed.setText("The Cat Won");  //set big label
      
      //go through all buttons and disable them
      for(int x =0; x<6; x++)
      {
        for(int y=0; y<7; y++)
        {
          spotsOnScreen[x][y].setEnabled(false);
        }
      }
      spotsOnScreen[2][5].setEnabled(false);
    }
  //---------------------------------------------------------------------------------------------------------------
  
  
  }
  
  public void newGame(JButton[][] spotsOnScreen, GameMaker me,  ArrayList<Coordinates> locations)
  {
    me.resetGame();
    lblToBeUsed.setText("");
    
    //clear out the visual board
    for(int x =0; x<6; x++)
    {
      for(int y=0; y<7; y++)
      {
        spotsOnScreen[x][y].setText("");
        spotsOnScreen[x][y].setEnabled(true);
        
      }
    }
    
  }
}
