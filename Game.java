import javax.swing.*;

class Game{
	public static void main(String[] args){
		JFrame frame = new JFrame("Snakes and Ladders");
		JPanel panel = new JPanel();
		
		StartMenu startMenu = new StartMenu(frame);

		if(startMenu.isStartMenu)
		{
			frame.add(panel);
			frame.setSize(701, 701);
			startMenu.AddUIToFrame();
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}