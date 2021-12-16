package Controller;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Model.Display;
import Model.Game;
import Model.Player;



/**
 * @author 
 */
public class CreateTheGame {
	

	public   CreateTheGame(Player p) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
				Game game = new PacmanGame(p);
                Display view = new Display(game);
                JFrame frame = new JFrame();
                
            	URL iconURL = getClass().getResource("/res/pacman_0_1.png");
            	ImageIcon icon = new ImageIcon(iconURL);
            	frame.setIconImage(icon.getImage());
                frame.setTitle("Hi "+p.getPlayerName()+" In Pacman Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(view);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
                view.requestFocus();
                view.start();
            }
        });
		
	}
}