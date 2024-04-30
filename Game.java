import javax.swing.*;

class Game{
	public static void main(String[] args){
		JFrame frame = new JFrame("Snakes and Ladders");
		frame.setSize(800, 800);

		JPanel panel = new JPanel();

		SetupScreen setupScreen = new SetupScreen();
		setupScreen.AddUIToFrame(frame);

		frame.add(panel);
		frame.setSize(900, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
