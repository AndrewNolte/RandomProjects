import java.awt.*;

import javax.swing.*;

public class MineSweeper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame msGUI = new JFrame();
		msGUI.setTitle("Mine Sweeper");
		msGUI.setSize(1100, 550);
		msGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container pane = msGUI.getContentPane();
		JPanel myPanel = new msPanel();
		pane.add(myPanel);
		
		msGUI.setVisible(true);

	}

}
