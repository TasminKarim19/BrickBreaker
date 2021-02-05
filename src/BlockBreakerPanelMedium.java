/*
 * @author Tasmin Karim
 */

import javax.swing.*;





import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.lang.Thread;

public class BlockBreakerPanelMedium extends JPanel implements KeyListener {
    ArrayList<Block> blocks ;
    Block ball ;
	Block paddle ;
	JFrame exit;
	JFrame mainFrame, startScreen;

		public  int score =0;
	
	Thread thread;
   
	
	
	JLabel l2;
	
 String filepath = "sound.wav";
 String filepath1 = "tone.wav";
     
     musicSheet musicObject = new musicSheet();
   
	void reset() {
		
		
		blocks = new ArrayList<Block>();
		 ball = new Block(277,550,25,25,"ball8.png");
		 paddle = new Block(230,600,120,20,"red.png");
		 for(int i=0;i< 8; i++) 
	    		blocks.add(new Block((i*60+45),40,60,25,"block2.png"));
	    		for(int i=0;i< 7; i++) 
	    			blocks.add(new Block((i*60+70),65,60,25,"block3.png"));
	    			for(int i=0;i< 8; i++) 
	    				blocks.add(new Block((i*60+45),90,60,25,"wall3.png"));
	    				for(int i=0;i< 7; i++) 
	    					blocks.add(new Block((i*60+70),115,60,25,"block4.png"));
	    				for(int i=0;i< 8; i++) 
	    					blocks.add(new Block((i*60+45),140,60,25,"wall.png"));
	    				for(int i=0;i< 7; i++) 
	    					blocks.add(new Block((i*60+70),165,60,25,"wall2.png"));
	    				for(int i=0;i< 8; i++) 
	    					blocks.add(new Block((i*60+45),190,60,25,"block5.png"));
	    				

	    		        addKeyListener(this);
	    		           setFocusable(true);
	    		     
	    	}
 
public void paintComponent(Graphics g){
	super.paintComponent(g);
	
	 g.setColor(Color.white);
     g.fillRect(0, 0, 590, 350);
     g.setColor(Color.black);
     g.fillRect(0, 350, 590, 350);
	blocks.forEach(block ->{
		block.draw(g, this);
	});
	
	ball.draw(g, this);
    paddle.draw(g, this);
    
    
 g.setColor(Color.black);
   g.setFont(new Font("serif", Font.BOLD, 25));
  g.drawString("Score " + score, 400, 275);
  

    
}
 
    
 BlockBreakerPanelMedium(JFrame frame2, JFrame startScreen ){
    	
	 this.mainFrame = frame2;
    	this.startScreen = startScreen;
    	
    	reset();
    	

 }
   

    public void update  (Graphics g) {
    
    	ball.x += ball.movX;
    	if(ball.x > (getWidth()- 25) || ball.x<0)
    		ball.movX *=-1;
    	
    	if( ball.y < 0 || ball.intersects(paddle))
    		ball.movY *= -1;
    	
    	ball.y += ball.movY;
      	blocks.forEach(block->{
     		if(ball.intersects(block) && !block.destroyed) {
     			block.destroyed = true;
     			ball.movY *= -1;
     			score = score + 5;
     			musicObject.playMusic(filepath);
         		
     			
     	
     		}
     		
     		});
     	
     	repaint();
     	
     	
    	
    	if(ball.y >getHeight() || score ==300) {
    		
    		
    		
    		thread = null;
            
        	reset(); 
        	
        	musicObject.playMusic(filepath1);
        	

     	   g.setColor(Color.white);
     	     g.fillRect(0, 0, 590, 700);
        	
        	// buttons for play again and quit
      		
     		 JButton playAgain = new JButton(" Play Again");
     		 
       	playAgain.setBounds(190, 360, 220, 30);
       	  playAgain.setBackground(Color.pink);
       	  
       	  JButton quit = new JButton(" Quit");
        	 quit.setBounds(190, 400, 220, 30);
        	  quit.setBackground(Color.pink);
        	  
        	  mainFrame.add(playAgain);
         	  
          	  mainFrame.add(quit);
        	  
        	  
        	  
        	     
             
              
              Image pic;
          	
          	ImageIcon img = new ImageIcon("E:\\ProjectPic\\OkitaKUN.jpg");
          	
          	pic = img.getImage();
              super.paintComponent(g);
              g.drawImage(pic,66, 0, null);
              
              	//Game Over
        	  String msg = "Game Over";
              Font big = new Font("Ink Free", Font.BOLD, 75);
              FontMetrics metr = getFontMetrics(big);
              
              g.setColor(Color.red);
              g.setFont(big);
              g.drawString(msg,150,200);
              
              if(score== 300) {
            	//You won
                  
                  String msg1 = "You Won";
                  Font big1 = new Font("Ink Free", Font.BOLD,50);
                  FontMetrics metr1 = getFontMetrics(big1);
                  
                  g.setColor(Color.red);
                  g.setFont(big1);
                  g.drawString(msg1,100,50);
                  
              }
              
              
              
              
             //Score
              
              g.setColor(Color.blue);
      		g.setFont( new Font("Ink Free",Font.BOLD, 40));
      		FontMetrics metrics1 = getFontMetrics(g.getFont());
      		g.drawString("Score: "+score,150,250);
      		
      		
      	
         	
         	 
         	playAgain.addActionListener(listner ->{
         		 startScreen.setVisible(true);
         		 
         	 	mainFrame.setVisible(false);
         	 		
         	 });
         	  
         	quit.addActionListener(listner ->{
        		
        	 	mainFrame.setVisible(false);

        	 });
        	  
            
		}
         

		}
         

   
    	
    	
    

  
	@Override
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
    		
    		thread =  new Thread(()->{
                while(thread !=null){
                    update(getGraphics());
                    
                
                    try{
                        Thread.sleep(9);
                    }catch(InterruptedException err){
                        err.printStackTrace();
                    }
                }
            });
           thread.start();
          
    		}
   
    if(e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x<(getWidth( ) - paddle.width)) {
    	paddle.x += 60;
    }
    if(e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0) {
    	paddle.x -= 60;
    }
     }

   @Override
    public void keyTyped(KeyEvent e) {

    }



    @Override
    public void keyReleased(KeyEvent e) {

    }


	

}

