public class Ship extends Pieces {
 
   boolean moveRight;
   boolean moveLeft;
 
 public Ship(int x, int y, int s){
    super(x,y,s);
      moveRight = false;
      moveLeft = false;
  }
}