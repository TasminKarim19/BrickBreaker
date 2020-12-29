import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Exit extends JPanel{
	
	  
    public void paint(Graphics g) {
    	

   	 g.setColor(Color.black);
        g.fillRect(0, 0, 590, 700);
   //     g.setColor(Color.white);
 //       g.fillRect(0, 350, 590, 350);
    	g.setColor(Color.red);
    	g.setFont(new Font("Ink Free",Font.BOLD,75));
    	FontMetrics metrics = getFontMetrics(g.getFont());
    	
    	g.drawString("GAME OVER", 75,320);
    	 g.setColor(Color.white);
         g.setFont(new Font("serif", Font.BOLD, 25));
      
    }


}
