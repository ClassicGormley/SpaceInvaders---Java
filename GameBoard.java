import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

//things to do(make ship shoot, and add end of game)

public class GameBoard  extends JPanel implements Runnable
{
  boolean ingame = true;
  private Dimension d;
  int BOARD_WIDTH=500;
  int BOARD_HEIGHT=500;
  int x = 0;
  BufferedImage img;
  String message = "";// put starting message here 
  private Thread animator;
  Ship a;
  Alien[][] s = new Alien[5][9];
  Missile m;
  public GameBoard()
  {
    addKeyListener(new TAdapter());
    setFocusable(true);
    d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    a = new Ship(BOARD_WIDTH/2 ,BOARD_HEIGHT - 60, 3);
   // Alien positioning ( make 2D array )  
    int sx = 0;
    int sy = 5;
    for(int i= 0; i< s.length; i++){
      for (int j = 0; j < s[i].length; j++){
        if(i != 0 && j ==0){
          sx = 0;
          sy += 40;
        }
        s[i][j] = new Alien(sx,sy,1);
        sx += 40; 
      }
    setBackground(Color.black);
    
    /*         
     try {
     img = ImageIO.read(this.getClass().getResource("mount.jpg"));
     } catch (IOException e) {
     System.out.println("Image could not be read");
     // System.exit(1);
     }
     */
    if (animator == null || !ingame) {
      animator = new Thread(this);
      animator.start();
    }
    
    
    setDoubleBuffered(true);
  }
  }
  public void paint(Graphics g){
    super.paint(g);
    
    g.setColor(Color.white);
    g.fillRect(0, 0, d.width, d.height);

    
    //Ship
    g.setColor(Color.green); 
    g.fillRect(a.x, a.y, 25, 25);
    
    if(a.moveRight == true)
      a.x += a.speed;
   
    if(a.moveLeft == true)
      a.x -= a.speed;
    //Aliens
    moveAliens();
     for(int i= 0; i< s.length; i++){
       for(int j = 0; j < s[i].length; j++){
       g.fillRect(s[i][j].x, s[i][j].y, 35, 35);
       }
       
     }
    
    Font small = new Font("Helvetica", Font.BOLD, 14);
    FontMetrics metr = this.getFontMetrics(small);
    g.setColor(Color.black);
    g.setFont(small);
    g.drawString(message, 10, d.height-60);
    
    if (ingame) {
      
      
      
      
      
      // g.drawImage(img,0,0,200,200 ,null);
      
      
      
    }
    Toolkit.getDefaultToolkit().sync();
    g.dispose();
  }
  // Move aliens across screen(use 2D array)
  
  public void moveAliens(){
    for(int i= 0; i< s.length; i++){
      for(int j = 0; j < s[i].length; j++){
        if(s[i][j].moveLeft == true){
          s[i][j].x -= s[i][j].speed;
        }
        
        if(s[i][j].moveRight == true){
          s[i][j].x += s[i][j].speed;
        }
        
        // s[i].y += s[i].speed;
      }
    }
    
    int rowend = 4;
    int colend = 8;

    if(s[rowend][colend].x > BOARD_WIDTH - 35){  
      for(int i= 0; i< s.length; i++){
        for(int j = 0; j < s[i].length; j++){
          
          s[i][j].moveLeft = true;
          s[i][j].moveRight=false;
          s[i][j].y += 5;
        }
      }
    }
    
    int rowstart = 0;
    int colstart = 0;
    if(s[rowstart][colstart].x < 0){
      for(int i= 0; i< s.length; i++){
        for(int j = 0; j < s[i].length; j++){
          s[i][j].moveRight = true;
          s[i][j].moveLeft = false;
          s[i][j].y += 5;
        }
      }
    }
  }

  public void tryToFire(){
    if (m.fireable == true){
      fireMissile();
    }
  }
  
  public void fireMissile(){
    int x = a.x + 12;
    int y = a.y;
  }
 
  private class TAdapter extends KeyAdapter {
    
    public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
      a.moveRight = false;
      a.moveLeft = false;
    }
    
    public void keyPressed(KeyEvent e) {
      System.out.println( e.getKeyCode());
      // message = "Key Pressed: " + e.getKeyCode();
      int key = e.getKeyCode();
      if(key==39){
        a.moveRight = true;
      }
      
      if(key==37){
        a.moveLeft = true;
      }
      
      if(key ==32){
        fireMissle();
      }
      
    }
  }
  
  
  
  public void run() {
    
    long beforeTime, timeDiff, sleep;
    
    beforeTime = System.currentTimeMillis();
    int animationDelay = 15;
    long time = System.currentTimeMillis();
    while (true) {//infinite loop
      // spriteManager.update();
      repaint();
      try {
        time += animationDelay;
        Thread.sleep(Math.max(0,time - 
                              System.currentTimeMillis()));
      }catch (InterruptedException e) {
        System.out.println(e);
      }//end catch
    }//end while loop
    
    
    
    
  }//end of run
  
}//end of class
