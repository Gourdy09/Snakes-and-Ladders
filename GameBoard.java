import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class GameBoard extends JPanel implements ActionListener{
	// INSTANCE VARIABLES
	JFrame frame = new JFrame("Snakes and Ladders");
	ImageIcon gameboardIcon = new ImageIcon(new ImageIcon(".\\gameboard.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
	JLabel gameboard = new JLabel(gameboardIcon);
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
	int turn = 1;
	JPanel turnPanel = new JPanel();

	JLayeredPane gamePane = new JLayeredPane();

	public static JLabel player1Icon = new JLabel(" " + PlayerVariables.player1Name + " ");
	public static JLabel player2Icon = new JLabel(" " + PlayerVariables.player2Name + " ");

	JButton newTurnButton = new JButton("New Turn"); 
	JLabel currentPlayerLabel = new JLabel("Current Player: " + turn);

	PlayerPanel playerPanelClass = new PlayerPanel();

	JPanel background = new JPanel();

	// CONSTRUCTOR
	public GameBoard(){
		// SET BACKGROUND COLOR
		playerPanelClass.playerPanel.setBackground(new Color(0, 0, 0, 0));
		gamePane.setBackground(new Color(125, 132, 145));
		// SET BOUNDARIES (NOT USING A LAYOUT MANAGER)
		gameboard.setBounds(0, 0, gameboardIcon.getIconWidth(), gameboardIcon.getIconHeight());
		dicePanel.setBounds(525, 100, 200, 260);
		turnPanel.setBounds(100, 550, 500, 100);
		playerPanelClass.playerPanel.setBounds(0, 0, gameboardIcon.getIconWidth(), gameboardIcon.getIconHeight());
		
		// ADD ACTION LISTENENERS (FOR BUTTON PRESSES)
		rollButton.addActionListener(this);
		newTurnButton.addActionListener(this);
	}

	public void addUIToFrame(JFrame projectWindow){
		// ADD ALL THE UI ONTO THE SCREEN AND SET SOME BOUNDS
		background.setBounds(0, 0, 700, 700);
		background.setBackground(new Color(125, 132, 145));

		setUpDicePanel();
		setUpTurnPanel();
		addPanels();
		projectWindow.add(gamePane);
	}

	public void addPanels(){
		// MAKE THE PLAYER PANE (TOP PANEL SEE-THROUGH)
		playerPanelClass.playerPanel.setOpaque(false);

		// ADD ALL THE PANELS TO THE JLAYEREDFRAME CALLED GAMEPANE (BOTTOM LAYER -> TOP LAYER: BACKGROUND, GAMEBOARD IMAGE, DICEPANEL, TURN PANEL, PLAYER PANEL)
		gamePane.add(background, JLayeredPane.DEFAULT_LAYER);
		gamePane.add(gameboard, JLayeredPane.MODAL_LAYER);
		gamePane.add(dicePanel, JLayeredPane.MODAL_LAYER);
		gamePane.add(turnPanel, JLayeredPane.DRAG_LAYER);
		gamePane.add(playerPanelClass.playerPanel, JLayeredPane.DRAG_LAYER);
	}

	public void setUpTurnPanel(){
		// ADD COMPONENTS TO THE TURN PANEL
		turnPanel.add(newTurnButton);
		turnPanel.add(currentPlayerLabel);
	}

    public void addObject(Component component, Container container, GridBagLayout layout, GridBagConstraints gbc, int gridX, int gridY, int gridWidth, int gridHeight ){
        // ADD OBJECT TO (X, Y) ON GRID
        gbc.gridx = gridX;
        gbc.gridy = gridY;

        // SET OBJECT WIDTH AND HEIGHT ON GRID
        gbc.gridwidth = gridWidth;
        gbc.gridheight = gridHeight;
        // SET OBJECT CONSTRAINTS ON GRID
        layout.setConstraints(component, gbc);
        // ADD OBJECT TO CONTAINER
        container.add(component);
    }

	public void setUpDicePanel(){
		// SET UP CONSTRAINTS AND LAYOUT
		GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
		dicePanel.setLayout(layout);

		// ADD OBJECTS TO DICE PANEL
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

		// SET UP COLORS
		previousRollDisplay.setForeground(Color.WHITE);
		previousRoll1.setForeground(Color.WHITE);
		previousRoll2.setForeground(Color.WHITE);
		previousRoll3.setForeground(Color.WHITE);
		previousRoll4.setForeground(Color.WHITE);
		previousRoll5.setForeground(Color.WHITE);

		newTurnButton.setForeground(Color.WHITE);
		newTurnButton.setBackground(new Color(23, 23, 56));
		currentPlayerLabel.setForeground(Color.WHITE);

		rollButton.setBackground(new Color(23, 23, 56));
		rollButton.setForeground(Color.WHITE);

		dicePanel.setBackground(new Color(125, 132, 145));
		turnPanel.setBackground(new Color(125, 132, 145));
	}

	@Override
	public void actionPerformed(ActionEvent event){
		// IF ROLL BUTTON PRESSED: ROLL A RANDOM NUMBER, UPDATE THE DICE PICTURE, AND UPDATE THE PREVIOUS ROLLED LIST
        if(event.getSource() == rollButton){
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

		if(event.getSource() == newTurnButton){
			// IF THE NEW TURN BUTTON IS PRESSED: SET THE TURN TO CORRECT PLAYER (IF ODD (1, 3, 5, ...): PLAYER 1 TURN) (IF EVEN (2, 4, 6, ...): PLAYER 2 TURN), UPDATE TURN LABEL
			if(playerPanelClass.getTurn() % 2 == 0){
				currentPlayerLabel.setText("Current Player: " + 1);
			}
			else{
				currentPlayerLabel.setText("Current Player: " + 2);
			}
			playerPanelClass.setTurn();
		}
	}	
}




