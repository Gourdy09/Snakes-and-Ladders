import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartMenu extends JFrame implements ActionListener{
	boolean isStartMenu = true;

	JPanel startMenuPanel = new JPanel();
	JLabel title = new JLabel("Snakes and Ladders");
	JLabel subTitle = new JLabel("By Om Patel ©️2024");
	JButton playButton = new JButton("Start Game");

	JFrame projectWindow;

	StartMenu(JFrame frame){
		playButton.addActionListener(this);
		projectWindow = frame;
	}

	@Override
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == playButton){
			RemoveUIFromFrame();
			SetupScreen setupScreen = new SetupScreen(projectWindow);
			projectWindow.setSize(700, 700);
			setupScreen.AddUIToFrame(projectWindow);
			isStartMenu = false;
		}
	}


	public boolean getStartMenuStatus() { return isStartMenu; }

	public void AddUIToFrame(){
		startMenuPanel.setLayout(new BoxLayout(startMenuPanel, BoxLayout.Y_AXIS));

		title.setFont(new Font("Serif", Font.BOLD, 80));
		title.setAlignmentX(CENTER_ALIGNMENT);
		startMenuPanel.add(title);

		subTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		subTitle.setAlignmentX(CENTER_ALIGNMENT);
		startMenuPanel.add(subTitle);

		playButton.setFont(new Font("Serif", Font.PLAIN, 40));
		playButton.setAlignmentX(CENTER_ALIGNMENT);
		startMenuPanel.add(playButton);
		projectWindow.add(startMenuPanel);
	}
	public void RemoveUIFromFrame(){
		projectWindow.remove(startMenuPanel);
	}
}
