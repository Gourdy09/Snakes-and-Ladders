import java.awt.*;
import javax.swing.*;

class main{
	public static void main(String args[]){
		JFrame frame = new JFrame("Snakes and Ladders");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter Player 1 Name:");
		JTextField textField = new JTextField(20);
		textField.setPreferredSize(new Dimension(200, 100));
		panel.add(label);
		panel.add(textField);
		frame.add(panel);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
