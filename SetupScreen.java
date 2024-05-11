import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SetupScreen extends JFrame implements ActionListener{
    public boolean isSetupDone = false;

    String player1Name;
    String player2Name;

    Color player1Color;
    Color player2Color;

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
        player1ColorSelect.addActionListener(this);
        player2ColorSelect.addActionListener(this);
        submitInfoButton.addActionListener(this);
        projectWindow = w;
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == player1ColorSelect){
            System.out.println("Player 1 Color Select Pressed");
            player1Color = JColorChooser.showDialog(null, "Player 1 Color Select", Color.RED);
            
        }
        if(event.getSource() == player2ColorSelect){
            System.out.println("Player 2 Color Select Pressed");
            player2Color = JColorChooser.showDialog(null, "Player 2 Color Select", Color.BLUE); 
        }
        if(event.getSource() == submitInfoButton){
            player1Name = player1NameField.getText();
            player2Name = player2NameField.getText();
            if(player1Color == null){
                player1Color = new Color(255, 0, 0);
            }
            if(player2Color == null){
                player2Color = new Color(0, 0, 255);
            }
            
            System.out.print("PLAYER 1 - Name: " + player1Name + " Color:" + player1Color.toString());
            System.out.println();
            System.out.print("PLAYER 2 - Name: " + player2Name + " Color: " + player2Color.toString());

            removeUIFromFrame();
            GameBoard gameBoard = new GameBoard();
            projectWindow.setSize(701, 701);
            gameBoard.addUIToFrame(projectWindow);
        }
    }

    public void AddUIToFrame(JFrame frame){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        mainPanel.setLayout(layout);

        player1Panel.setBorder(BorderFactory.createLineBorder(player1Color));
        player2Panel.setBorder(BorderFactory.createLineBorder(player1Color));

        constraints.fill = GridBagConstraints.HORIZONTAL;

        addObject(player1NameLabel, player1Panel, layout, constraints, 0, 0, 1, 4);
        addObject(player1NameField, player1Panel, layout, constraints, 1, 0, 1, 4);
        addObject(player1ColorLabel, player1Panel, layout, constraints, 2, 0, 1, 4);
        addObject(player1ColorSelect, player1Panel, layout, constraints, 3, 0, 1, 4);

        addObject(player2NameLabel, player2Panel, layout, constraints, 0, 1, 1, 1);
        addObject(player2NameField, player2Panel, layout, constraints, 1, 1, 1, 1);
        addObject(player2ColorLabel, player2Panel, layout, constraints, 2, 1, 1, 1);
        addObject(player2ColorSelect, player2Panel, layout, constraints, 3, 1, 1, 1);

        addObject(submitInfoButton, playButtonPanel, layout, constraints, 0, 2, 1, 1);

        addObject(player1Panel, mainPanel, layout, constraints, 0, 0 , 1, 1);
        addObject(player2Panel, mainPanel, layout, constraints, 0, 1 , 1, 1);
        addObject(playButtonPanel, mainPanel, layout, constraints, 0, 2 , 1, 1);

        frame.add(mainPanel);
    }

    public void addObject(Component component, Container container, GridBagLayout layout, GridBagConstraints gbc, int gridX, int gridY, int gridWidth, int gridHeight ){
        gbc.gridx = gridX;
        gbc.gridy = gridY;

        gbc.gridwidth = gridWidth;
        gbc.gridheight = gridHeight;
        
        layout.setConstraints(component, gbc);
        container.add(component);
    }

    public String getPlayer1Name(){
		return player1Name;
	}
    public String getPlayer2Name(){
		return player2Name;
	}
    public Color getPlayer1Color(){
        return player1Color;
    }
    public Color getPlayer2Color(){
        return player2Color;
    }

    public void removeUIFromFrame(){
        projectWindow.remove(mainPanel);
    }
}
