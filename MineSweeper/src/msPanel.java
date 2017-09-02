import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;


public class msPanel extends JPanel implements ActionListener {
	
	private int xlength = 20;
	private int ylength = 10;
	private int numMines = 50;
	
	private int buttonh = 45;
	private int buttonw = 45;
	
	private int margins = 10;
	
	private int opfieldw = 120;
	private int opfieldh = 100;
	
	private int displayNumMines;
	private JLabel bn;
	
	JButton restart;
	
	Cell[][] mineField;
	
	boolean canPlay = true;
	
	JLabel message;
	
	public msPanel(){
		setLayout(null);
	    
		setUpGame();
	}
	
	public void setUpGame(){
		displayNumMines = numMines;
		canPlay = true;
		message = new JLabel("");
	    message.setFont(new Font("Verdana",1,60));
	    this.add(message);
	 
		message.setBounds(400, 150, 600, 200);
		this.add(message);
		
		bn = new JLabel(String.valueOf(displayNumMines));
		bn.setFont(new Font("Verdana",1,80));
	    this.add(bn);
	 
		bn.setBounds(30, 150, 600, 200);
		this.add(bn);
		
		restart = new JButton("Restart");
		restart.setBounds(margins, margins, opfieldw, opfieldh);
		this.add(restart);
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				removeButtons();
				setUpGame();
				canPlay = true;
				message.setText("");
			}
		});
		
		mineField = getRandomMines(xlength, ylength, numMines);
		for(int i = 0; i < ylength; i++){
			for(int j = 0; j < xlength; j++){
				mineField[i][j].setSurroundingBombs(getBombNum(j,i));
				//mineField[i][j].setText(String.valueOf(mineField[i][j].getNumNeighbors()));
				mineField[i][j].setBounds(margins + opfieldw + margins + (j*buttonw), margins + (i*buttonh), buttonw, buttonh);
				this.add(mineField[i][j]);
				final Cell c = mineField[i][j];
				
				mineField[i][j].addMouseListener(new MouseListener(){
					public void mouseClicked(MouseEvent e){
						if(canPlay){
							//((Cell)e.getSource()).setBackground(Color.white);
							if(SwingUtilities.isLeftMouseButton(e)){
								c.reveal();
								if(c.getNumNeighbors()==0){
									revealNeighbors(c.getXLoc(),c.getYLoc());
								}
								if(c.getIsABomb() == true){
									canPlay = false;
									revealAll();
									message.setText("GAME OVER");
								}
							}else{
								if(c.getIsMarked()){
									c.unMark();
									displayNumMines++;
									bn.setText(String.valueOf(displayNumMines));
									
								}else{
									c.mark();
									displayNumMines--;
									bn.setText(String.valueOf(displayNumMines));
									
								}
							}
							if(displayNumMines == 0){
								if(checkBoardForWin() == true){
									canPlay = false;
									message.setText("YOU WIN!");
								}
							}
							
						}
					}
					public void mouseEntered(MouseEvent e){
						
					}
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		//System.out.println(s);
		
	}
	
	public Cell[][] getRandomMines(int xlen, int ylen, int num){
		Cell[][] cells = new Cell[ylen][xlen];
		int size = xlen * ylen;
		ArrayList<Boolean> rn = new ArrayList<Boolean>();
		for(int i = 0; i < size - num; i++){
			rn.add(new Boolean(false));
		}
		for(int j = 0; j < num; j++){
			rn.add((int)(Math.random() * rn.size()), new Boolean(true));
		}
		int pos = 0;
		for(int i = 0; i < ylen; i++){
			for(int j = 0; j < xlen; j++){
				cells[i][j] = new Cell(String.valueOf(pos), j, i, rn.get(pos));
				pos++;
				
			}
		}
		return cells;
	}
	
	public int getBombNum(int x, int y){
		int sum = 0;
		for(int i = -1; i <= 1; i++){
			if((y+i)<0||(y+i)>= mineField.length){
			}else{
				for(int j = -1; j <= 1; j++){
					if((x+j)<0||(x+j)>= mineField[y+i].length||(i==0 && j==0)){
					}else{
						if(mineField[y+i][x+j].getIsABomb()){
							sum++;
						}
					}				
				}
			}
			
		}
		return sum;
	}
	
	public void revealAll(){
		for(int i = 0; i < mineField.length; i++){
			for(int j = 0; j < mineField[i].length; j++){
				mineField[i][j].reveal();
			}
		}
	}
	
	public void removeButtons(){
		/*
		for(int i = 0; i < mineField.length; i++){
			for(int j = 0; j < mineField[i].length; j++){
				this.remove(mineField[i][j]);
				//this.removeAll();
			}
		}
		*/
		this.removeAll();
		this.repaint();
	}
	
	public void revealNeighbors(int x, int y){
		for(int i = -1; i <= 1; i++){
			if((y+i)<0||(y+i)>= mineField.length){
			}else{
				for(int j = -1; j <= 1; j++){
					if((x+j)<0||(x+j)>= mineField[y+i].length||(i==0 && j==0)){
					}else{
						
						if(mineField[y+i][x+j].getIsRevealed() == false){
							mineField[y+i][x+j].reveal();
							if(mineField[y+i][x+j].getNumNeighbors() == 0){
								revealNeighbors(x+j,y+i);
							}
						}
					}				
				}
			}
		}
	}
	
	public boolean checkBoardForWin(){
		for(int i = 0; i < ylength; i++){
			for(int j = 0; j < xlength; j++){
				if(mineField[i][j].getIsABomb() != mineField[i][j].getIsMarked()){
					return false;
				}
				if(mineField[i][j].getIsABomb() == false){
					if(mineField[i][j].getIsRevealed() == false){
						return false;
					}
				}
				
			}
		}	
		return true;
	}
	
	
	
}
