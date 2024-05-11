import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GameBoard extends JFrame implements ActionListener{
	JFrame gameFrame = new JFrame("Snakes and Ladders");
	JLabel gameboard = new JLabel(new ImageIcon(new ImageIcon(".\\gameboard.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
	JPanel mainPanel = new JPanel();
	JLabel diceFace = new JLabel(new ImageIcon(new ImageIcon(".\\DiceFaces\\1.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
	JPanel dicePanel = new JPanel();
	JLabel previousRollDisplay = new JLabel("Previous Rolls: ");
	JLabel previousRoll1 = new JLabel();
	JLabel previousRoll2 = new JLabel();
	JLabel previousRoll3 = new JLabel();
	JLabel previousRoll4 = new JLabel();
	JLabel previousRoll5 = new JLabel();
	JButton rollButton = new JButton("Click to roll");

	String[] diceFaces = {".\\DiceFaces\\1.png", ".\\DiceFaces\\2.png", ".\\DiceFaces\\3.png", ".\\DiceFaces\\4.png", ".\\DiceFaces\\5.png", ".\\DiceFaces\\6.png"};
	ArrayList<String> previousRolls = new ArrayList<>();
	JLabel[] previousRollsDisplay = {previousRoll1, previousRoll2, previousRoll3, previousRoll4, previousRoll5};
	int rollCount = 0;

	public GameBoard(){
		rollButton.addActionListener(this);
	}

	public void addUIToFrame(JFrame projectWindow){
		setUpMainPanel();
		projectWindow.add(mainPanel);
	}

	public void addObject(Component component, Container container, GridBagLayout layout, GridBagConstraints gbc, int gridX, int gridY, int gridWidth, int gridHeight ){
        gbc.gridx = gridX;
        gbc.gridy = gridY;

        gbc.gridwidth = gridWidth;
        gbc.gridheight = gridHeight;
        
        layout.setConstraints(component, gbc);
        container.add(component);
    }

	public void setUpMainPanel(){
		GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        mainPanel.setLayout(layout);
		dicePanel.setLayout(layout);

		addObject(diceFace, dicePanel, layout, constraints, 0, 0, 1, 1);
		constraints.insets = new Insets(10, 0, 0, 0);
		addObject(rollButton, dicePanel, layout, constraints, 0, 1, 1, 1);
		constraints.insets = new Insets(0, 0, 10, 0);
		addObject(previousRollDisplay, dicePanel, layout, constraints, 0, 2, 1, 1);
		constraints.insets = new Insets(0, 0, 0, 0);
		addObject(previousRoll1, dicePanel, layout, constraints, 0, 3, 1, 1);
		addObject(previousRoll2, dicePanel, layout, constraints, 0, 4, 1, 1);
		addObject(previousRoll3, dicePanel, layout, constraints, 0, 5, 1, 1);
		addObject(previousRoll4, dicePanel, layout, constraints, 0, 6, 1, 1);
		addObject(previousRoll5, dicePanel, layout, constraints, 0, 7, 1, 1);

		addObject(gameboard, mainPanel, layout, constraints, 0, 0, 1, 1);
		constraints.insets = new Insets(0, 50, 0, 0);
		addObject(dicePanel, mainPanel, layout, constraints, 1, 0, 1, 1);
	}

	

	public void setUpDicePanel(){
		dicePanel.add(diceFace);
		dicePanel.add(rollButton);
	}

	@Override
	public void actionPerformed(ActionEvent event){
        if(event.getSource() == rollButton){
			diceRollAnimation(diceFace);
            int num = (int) (Math.random() * 6); // random num from 0-5
			rollCount++;
			if(previousRolls.size() < 5){
				previousRolls.add("Roll " + rollCount + ": " + num + "");
			}
			else{
				for(int i = 0; i < previousRolls.size() - 1; i++){
					previousRolls.set(i, previousRolls.get(i+1));
				}
				previousRolls.set(previousRolls.size() - 1, "Roll " + rollCount + ": " + (num + 1) + "\n");
			}
			
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(diceFaces[num]).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			diceFace.setIcon(imageIcon);

			for(int x = 0; x < previousRolls.size(); x++){
				previousRollsDisplay[x].setText(previousRolls.get(x));
			}
        }
	}

	public void diceRollAnimation(JLabel image){
		image.setIcon(new ImageIcon(".\\DiceFaces\\dice_roll.gif"));
		//wait for x seconds
		// stop animation
		// set correct image
	}
}
