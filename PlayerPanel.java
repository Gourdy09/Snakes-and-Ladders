import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel implements  MouseListener{
    // INSTANCE VARIABLES
    public JPanel playerPanel = new JPanel();
    ImageIcon gameboardIcon = new ImageIcon(new ImageIcon(".\\gameboard.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
    JLabel player1Icon = GameBoard.player1Icon;
    JLabel player2Icon = GameBoard.player2Icon;
    int newX;
    int newY;
    int turn = 1;

    boolean inBoard = false;

    public PlayerPanel(){
        // SET UP MOUSE LISTENER AND SET UP PANEL
        playerPanel.addMouseListener(this);
        setUpPlayerPanel(player1Icon, player2Icon);
    }
    public void setUpPlayerPanel(JLabel player1Icon, JLabel player2Icon){
        // ADD ICONS TO PANEL
        playerPanel.setLayout(null);
		setUpPlayerIcons(player1Icon, player2Icon);
		player1Icon.setBounds(0, 0, 30, 30);
		player2Icon.setBounds(0, 0, 30, 30);
		playerPanel.add(player1Icon);
		playerPanel.add(player2Icon);
		player1Icon.setLocation(10, 500);
		player2Icon.setLocation(10, 500);
	}
    public void setUpPlayerIcons(JLabel player1Icon, JLabel player2Icon){
        // SET UP ICONS
		player1Icon.setOpaque(true);
		player1Icon.setForeground(Color.WHITE);
		player1Icon.setBackground(PlayerVariables.player1Color);

		player2Icon.setOpaque(true);
		player2Icon.setForeground(Color.WHITE);
		player2Icon.setBackground(PlayerVariables.player2Color);
	}
    public void setPlayerIcons(JLabel a, JLabel b){
        player1Icon = a;
        player2Icon = b;
    }
    
    @Override
    public void mousePressed(MouseEvent e){
    }

    @Override
    public void mouseReleased(MouseEvent e) { 
        // WHEN THEY LET GO OF CLICK: SET A NEW X AND Y AND UPDATE PLAYER POSITION
        System.out.println("drop"); 
        if(inBoard){
            newX = e.getX();
            newY = e.getY();
        }
        
		if(turn % 2 == 0 && inBoard){
			updatePlayerPosition(2);
		}
		else if(turn % 2 != 0 && inBoard){
			updatePlayerPosition(1);
		}
    }

    @Override
    public void mouseEntered(MouseEvent e) { 
        // MAKE SURE MOUSE IS IN THE CLICKABLE AREA  
        inBoard = true;
    }
 
    @Override
    public void mouseExited(MouseEvent e) {
        // MAKE SURE MOUSE IS IN THE CLICKABLE AREA  
        inBoard = false;
    }
 
    @Override
    public void mouseClicked(MouseEvent e) {
    }

	public void updatePlayerPosition(int player){
        // MOVE PLAYER TO THE MOUSE CURSOR'S LOCATION
		if(player == 1){
			player1Icon.setLocation(newX - player1Icon.getPreferredSize().width / 2, newY - player1Icon.getPreferredSize().height / 2);
		}
		if(player == 2){
			player2Icon.setLocation(newX - player2Icon.getPreferredSize().width / 2, newY - player2Icon.getPreferredSize().height / 2);
		}
	}
    public void setTurn(){
        // INCREMENT TURN VARIABLE
        turn++;
    }
    public int getTurn(){
        // RETURN TURN VARIABLE
        return turn;
    }
}
