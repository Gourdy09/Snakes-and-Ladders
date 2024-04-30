import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SetupScreen extends JFrame implements ActionListener{
    JLabel player1ColorLabel = new JLabel("Player 1 Color:");
    JButton player1ColorSelect = new JButton("Pick a color for player 1");
    JLabel player1NameLabel = new JLabel("Player 1 Name:");
    JTextField player1NameField = new JTextField(3);

    JLabel player2ColorLabel = new JLabel("Player 2 Color:");
    JButton player2ColorSelect = new JButton("Pick a color for player 2");
    JLabel player2NameLabel = new JLabel("Player 2 Name:");
    JTextField player2NameField = new JTextField(3);

    JLabel blank = new JLabel(" ");

    SetupScreen(){
        player1ColorSelect.addActionListener(this);
        player2ColorSelect.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == player1ColorSelect){
            System.out.println("Player 1 Color Select Pressed");
            JColorChooser.showDialog(null, "Player 1 Color Select", Color.RED);
            
        }
        if(event.getSource() == player2ColorSelect){
            System.out.println("Player 2 Color Select Pressed");
            JColorChooser.showDialog(null, "Player 2 Color Select", Color.BLUE); 
        }
    }

    public void AddUIToFrame(JFrame frame){
        frame.setLayout(new GridLayout(2, 4, 10, 25));

        frame.add(player1NameLabel);
        frame.add(player1NameField);
        frame.add(player1ColorLabel);
        frame.add(player1ColorSelect);

        frame.add(blank);

        frame.add(player2NameLabel);
        frame.add(player2NameField);
        frame.add(player2ColorLabel);
        frame.add(player2ColorSelect);
    }

}
