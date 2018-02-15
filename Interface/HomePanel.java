package Interface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import ProblemDomain.GameMaker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class HomePanel extends JPanel {
  public HomePanel(Frame currentFrame) {
    setBackground(Color.CYAN);
    setLayout(null);
    
    JLabel lblHome = new JLabel("Connect Four");
    lblHome.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
    lblHome.setHorizontalAlignment(SwingConstants.CENTER);
    lblHome.setBounds(16, 6, 428, 47);
    add(lblHome);
    
    JButton btnStartGame = new JButton("Train AI");
    btnStartGame.setBackground(Color.WHITE);
    btnStartGame.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
    btnStartGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        GameMaker me = new GameMaker();
        me.getBoardPosition().resetBoard();
        HumanPanel newPanel = new HumanPanel(currentFrame, me);
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(newPanel);
        currentFrame.revalidate();
      }
    });
    btnStartGame.setBounds(165, 157, 102, 65);
    add(btnStartGame);
  }
}
