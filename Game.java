import javax.swing.*;

class Game{
	// MAIN FUNCTION (RUN THIS TO PLAY)
	public static void main(String[] args){
		// MAKE THE FRAME
		JFrame frame = new JFrame("Snakes and Ladders");
		JPanel panel = new JPanel();
		
		// CREATE START MENU
		StartMenu startMenu = new StartMenu(frame);

		if(startMenu.isStartMenu)
		{
			frame.add(panel);
			frame.setSize(701, 701);
			startMenu.AddUIToFrame();
		}
		
		// HANDLE CLOSING FRAME AND MAKE THE FRAME VISIBLE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}