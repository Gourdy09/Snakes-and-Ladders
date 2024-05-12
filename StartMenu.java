import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartMenu extends JFrame implements ActionListener{
	// INSTANCE VARIABLES
	boolean isStartMenu = true;

	JPanel startMenuPanel = new JPanel();
	JLabel title = new JLabel("Snakes and Ladders");
	JLabel subTitle = new JLabel("By Om Patel ©️2024");
	JButton playButton = new JButton("Start Game");
	ImageIcon gameboardIcon = new ImageIcon(new ImageIcon(".\\gameboard.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
	JLabel image = new JLabel(gameboardIcon);

	JFrame projectWindow;

	StartMenu(JFrame frame){
		// SET UP FRAME AND ACTION LISTENER (TO LISTEN TO BUTTON PRESS)
		playButton.addActionListener(this);
		projectWindow = frame;
	}

	@Override
	public void actionPerformed(ActionEvent event){
		// IF PLAY BUTTON PRESSED: REMOVE ALL UI, MAKE A NEW SCREEN FOR SETUP, ADD NEW UI TO SCREEN
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
		// SET UP MAIN PANEL
		startMenuPanel.setLayout(null);
		startMenuPanel.setBackground(new Color(125, 132, 145));

		// SET UP AND ADD TITLE
		title.setFont(new Font("Serif", Font.BOLD, 70));
		title.setForeground(Color.WHITE);
		title.setBounds((700 - title.getPreferredSize().width) / 2, 0, title.getPreferredSize().width, title.getPreferredSize().height);
		startMenuPanel.add(title);

		// SET UP AND ADD SUBTITLE
		subTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		subTitle.setForeground(Color.WHITE);
		subTitle.setBounds((700 - subTitle.getPreferredSize().width) / 2, title.getPreferredSize().height + 5, subTitle.getPreferredSize().width, subTitle.getPreferredSize().height);
		startMenuPanel.add(subTitle);

		// SET UP AND ADD IMAGE
		image.setBounds((700 - image.getPreferredSize().width) / 2, title.getPreferredSize().height + subTitle.getPreferredSize().height + 10, image.getPreferredSize().width, image.getPreferredSize().height);
		startMenuPanel.add(image);

		// SET UP AND ADD THE PLAY BUTTON
		playButton.setFont(new Font("Serif", Font.PLAIN, 40));
		playButton.setBounds((700 - playButton.getPreferredSize().width) / 2, title.getPreferredSize().height + subTitle.getPreferredSize().height + image.getPreferredSize().height + 25, playButton.getPreferredSize().width, playButton.getPreferredSize().height);
		playButton.setBackground(new Color(23, 23, 56));
		playButton.setForeground(Color.WHITE);
		startMenuPanel.add(playButton);
		projectWindow.add(startMenuPanel);
	}

	public void RemoveUIFromFrame(){
		// REMOVE MAIN PANEL
		projectWindow.remove(startMenuPanel);
	}
}
