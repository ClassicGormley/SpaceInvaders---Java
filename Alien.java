public class Alien extends Pieces {
 
   boolean moveRight;
   boolean moveLeft;
   boolean isVisable;
 public Alien(int x, int y, int s){
    super(x,y,s);
      moveRight = true;
      moveLeft = false;
      isVisable = true;
  }
}