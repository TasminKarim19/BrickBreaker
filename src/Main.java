/*
 * @author Tasmin
 */


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class Main extends JFrame {
	
	
	
 public static void main(String[] args) {
	 
	
    
    	
 		
			//for easy 
    	 
    	 JButton easy = new JButton(" Easy");
    	 easy.setBounds(190, 360, 220, 30);
    	  easy.setBackground(Color.pink);
   	  
    	  //for medium
    	  JButton medium = new JButton(" Medium");
    	  
    	  medium.setBounds(190, 410, 220, 30);
    	  medium.setBackground(Color.pink);
    	  
    	  
    	  //for hard
 JButton hard = new JButton(" Hard");
    	  
    	  hard.setBounds(190, 460, 220, 30);
    	  hard.setBackground(Color.pink);
    	  
    	  
    	//  Label for display 
    	  
    	  JLabel label = new JLabel();
    	  label.setLayout(null);
    	 
    		 label.setBounds(220, 250, 250, 100);
    		 label.setFont(new Font("Ink Free", Font.BOLD, 30));
    		 label.setText("Brick Breaker");
 			
   /* function of frames*/
   
    //here starts the start screen	
    	  JLabel l1 = new JLabel();
    	
    	JFrame startScreen = new JFrame("Let's Break The Bricks");
    	  startScreen.setContentPane(new JLabel( new ImageIcon("E:\\ProjectPic\\rsz_startscreen.png")));
    	  
    	
    	startScreen.setLayout(null);
    	  startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 startScreen.setVisible(true);
    	 startScreen.setSize(590,720);
    	  startScreen.setResizable(false); 
    	 
    	  
    	  
    	  startScreen.add(l1);
    	   
    	    startScreen.add(easy);
    	   startScreen.add(medium);
    	    startScreen.add(hard);
    	   
    	    startScreen.add(label);
        	
    	
  // it's for game 	
  JFrame frame = new JFrame("Let's Break The Bricks");
  BlockBreakerPanel panel = new BlockBreakerPanel(frame,startScreen);
  
  frame.getContentPane().add(panel);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setVisible(false);
 frame.setSize(590,700);
 frame.setResizable(false);
  
 JFrame frame2 = new JFrame("Let's Break The Bricks");
 BlockBreakerPanelMedium panel2 = new BlockBreakerPanelMedium(frame2,startScreen);
 
 frame2.getContentPane().add(panel2);
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame2.setVisible(false);
frame2.setSize(590,700);
frame2.setResizable(false);


JFrame frame3 = new JFrame("Let's Break The Bricks");
BlockBreakerPanelHard panel3 = new BlockBreakerPanelHard(frame3,startScreen);

frame3.getContentPane().add(panel3);
frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame3.setVisible(false);
frame3.setSize(590,700);
frame3.setResizable(false);

  
  
  
    
  /* Action listeners*/
    
easy.addActionListener(listner ->{
	 startScreen.setVisible(false);
 	frame.setVisible(true);
 //	 mymusic.playMusic(filepath1);
 });

medium.addActionListener(listner ->{
	 startScreen.setVisible(false);
	frame2.setVisible(true);
	
});

hard.addActionListener(listner ->{
	 startScreen.setVisible(false);
	frame3.setVisible(true);
	

});

  
   }

}

