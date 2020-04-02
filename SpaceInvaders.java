import javax.swing.JFrame;

public class SpaceInvaders extends JFrame
{

  public SpaceInvaders(){
    add(new GameBoard());
    setTitle("GameBoard");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500,500);
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
  }
  public static void main(String[] args){
    new SpaceInvaders();
  }
}