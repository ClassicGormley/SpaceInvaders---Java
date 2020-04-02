
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Score extends JPanel{
   private JLabel shipLabel; //labels to display ships score    
   private int shipScore;// tally ships score
   
   public Score(){
      setLayout(new GridLayout(1,4));
      shipLabel = new JLabel("ship score: 0");
      add(shipLabel);
      add(new JLabel("Space Invaders"));
      shipScore = 0;
   }
   public void update(){
   
   }

}

