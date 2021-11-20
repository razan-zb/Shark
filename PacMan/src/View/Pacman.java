package View;


import javax.swing.JFrame;

public class Pacman extends JFrame{

	
	public Pacman() {
		getContentPane().add(new Model());
	} 
	 
	//I need to add the player name on the top of the page -->Model
	public Pacman(String playerName) {
		getContentPane().add(new Model());
		Pacman pac = new Pacman();
		pac.setVisible(true);
		pac.setTitle("Pacman");
		pac.setSize(380,420);
		pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pac.setLocationRelativeTo(null);
	}
	
	


}
