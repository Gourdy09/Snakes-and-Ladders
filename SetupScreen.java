import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SetupScreen extends JFrame implements ActionListener{

    // INSTANCE VARIABLES
    public boolean isSetupDone = false;

    JLabel player1ColorLabel = new JLabel("Player 1 Color:");
    JButton player1ColorSelect = new JButton("Pick a color for player 1");
    JLabel player1NameLabel = new JLabel("Player 1 Name:");
    JTextField player1NameField = new JTextField(20);

    JLabel player2ColorLabel = new JLabel("Player 2 Color:");
    JButton player2ColorSelect = new JButton("Pick a color for player 2");
    JLabel player2NameLabel = new JLabel("Player 2 Name:");
    JTextField player2NameField = new JTextField(20);

    JButton submitInfoButton = new JButton("Start Game");

    JPanel mainPanel = new JPanel();
    JPanel player1Panel = new JPanel();
    JPanel player2Panel = new JPanel();
    JPanel playButtonPanel = new JPanel();

    JFrame projectWindow;

    SetupScreen(JFrame w){
        // ADD ACTION LISTENERS (FOR THE BUTTON PRESSES)
        player1ColorSelect.addActionListener(this);
        player2ColorSelect.addActionListener(this);
        submitInfoButton.addActionListener(this);
        
        projectWindow = w;
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        // SELECT THE COLOR FOR PLAYER 1
        if(event.getSource() == player1ColorSelect){
            PlayerVariables.player1Color = JColorChooser.showDialog(null, "Player 1 Color Select", Color.RED);
        }
        // SELECT THE COLOR FOR PLAYER 2
        if(event.getSource() == player2ColorSelect){
            PlayerVariables.player2Color = JColorChooser.showDialog(null, "Player 2 Color Select", Color.BLUE);
        }
        // SUBMIT INFO (SETS STATIC VARIABLES IN PLAYERVARIABLES CLASS AND STARTS GAME)
        if(event.getSource() == submitInfoButton){
            if(!player1NameField.getText().equals("")){
                PlayerVariables.player1Name = player1NameField.getText();
            }
            else{
                PlayerVariables.player1Name = "P1";
            }
            if(!player2NameField.getText().equals("")){
                PlayerVariables.player2Name = player2NameField.getText();
            }
            else{
                PlayerVariables.player2Name = "P2";
            }

            if(PlayerVariables.player1Color == null){
                PlayerVariables.player1Color = new Color(255, 0, 0);
            }
            if(PlayerVariables.player2Color == null){
                PlayerVariables.player2Color = new Color(0, 0, 255);
            }

            removeUIFromFrame();
            GameBoard gameBoard = new GameBoard();
            projectWindow.setSize(701, 701);
            gameBoard.addUIToFrame(projectWindow);
        }
    }

    public void AddUIToFrame(JFrame frame){
        // SET UP LAYOUT AND CONSTRAINTS
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        mainPanel.setLayout(layout);

        // ADD BORDERS BETWEEN PLAYER 1 AND 2 OPTIONS
        player1Panel.setBorder(BorderFactory.createLineBorder(PlayerVariables.player1Color));
        player2Panel.setBorder(BorderFactory.createLineBorder(PlayerVariables.player1Color));

        // SET UP COLORS FOR THE BUTTONS
        player1ColorSelect.setBackground(new Color(23, 23, 56));
        player2ColorSelect.setBackground(new Color(23, 23, 56));
        player1ColorSelect.setForeground(Color.WHITE);
        player2ColorSelect.setForeground(Color.WHITE);
        submitInfoButton.setBackground(new Color(23, 23, 56));
        submitInfoButton.setForeground(Color.WHITE);

        // SET UP COLORS FOR THE TEXT
        player1ColorLabel.setForeground(Color.WHITE);
        player2ColorLabel.setForeground(Color.WHITE);
        player1NameLabel.setForeground(Color.WHITE);
        player2NameLabel.setForeground(Color.WHITE);

        // SET UP BACKGROUND COLORS
        player1Panel.setBackground(new Color(125, 132, 145));
        player2Panel.setBackground(new Color(125, 132, 145));
        playButtonPanel.setBackground(new Color(125, 132, 145));
        mainPanel.setBackground(new Color(125, 132, 145));


        constraints.fill = GridBagConstraints.HORIZONTAL;

        // ADD OBJECTS
        addObject(player1NameLabel, player1Panel, layout, constraints, 0, 0, 1, 1);
        addObject(player1NameField, player1Panel, layout, constraints, 1, 0, 1, 1);
        addObject(player1ColorLabel, player1Panel, layout, constraints, 2, 0, 1, 1);
        addObject(player1ColorSelect, player1Panel, layout, constraints, 3, 0, 1, 1);

        addObject(player2NameLabel, player2Panel, layout, constraints, 0, 1, 1, 1);
        addObject(player2NameField, player2Panel, layout, constraints, 1, 1, 1, 1);
        addObject(player2ColorLabel, player2Panel, layout, constraints, 2, 1, 1, 1);
        addObject(player2ColorSelect, player2Panel, layout, constraints, 3, 1, 1, 1);

        addObject(submitInfoButton, playButtonPanel, layout, constraints, 0, 2, 1, 1);

        addObject(player1Panel, mainPanel, layout, constraints, 0, 0 , 1, 1);
        addObject(player2Panel, mainPanel, layout, constraints, 0, 1 , 1, 1);
        addObject(playButtonPanel, mainPanel, layout, constraints, 0, 2 , 1, 1);

        // ADD MAIN PANEL TO FRAME
        frame.add(mainPanel);
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

    public void removeUIFromFrame(){
        // REMOVE UI
        projectWindow.remove(mainPanel);
    }
}
