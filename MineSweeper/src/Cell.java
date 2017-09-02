import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Cell extends JButton{
	private int x;
	private int y;
	private boolean isABomb;
	private int numOfNeighbors = 0;
	private BufferedImage image;
	private boolean isRevealed = false;
	private boolean isMarked = false;

	
	
	public Cell(String name, int x, int y, boolean isb){
		
		this.x = x;
		this.y = y;
		isABomb = isb;
	}
	
	public void reveal(){
		//System.exit(0);
		//System.out.println(x + " " + y);
		if(isRevealed){
			return;
		}
		isRevealed = true;
		if(isABomb){
			this.setBackground(Color.black);
		}else{
			setText(String.valueOf(numOfNeighbors));
			Color color = Color.white;
			switch(numOfNeighbors){
			case 1: color = Color.blue;
				break;
			case 2: color = Color.green;
				break;
			case 3: color = Color.red;
				break;
			case 4: color = Color.cyan;
				break;
			case 5: color = Color.yellow;
				break;
			case 6: color = Color.magenta;
				break;
			case 7: color = Color.orange;
				break;
			case 8: color = Color.pink;
			}
			this.setBackground(color);
				
			
		}
	}
	public void mark(){
		isMarked = true;
		this.setBackground(Color.gray);
		//setIcon(new ImageIcon("bomb.jpeg"));
	}
	
	public void unMark(){
		isMarked = false;
		this.setBackground(Color.white);
	}
	
	public boolean getIsMarked(){
		return isMarked;
	}
	public boolean getIsABomb(){
		return isABomb;
	}
	public void setSurroundingBombs(int b){
		numOfNeighbors = b;
	}
	public int getNumNeighbors(){
		return numOfNeighbors;
	}
	
	
	
	
	
	
	
	public void nextButton() {
	    try {
	        image = ImageIO.read(new File("kareem.jpeg"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}

	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(image.getWidth(), image.getHeight());
	}
	
	public int getXLoc(){
		return x;
	}
	public int getYLoc(){
		return y;
	}
	
	public boolean getIsRevealed(){
		return isRevealed;
	}
	

}
