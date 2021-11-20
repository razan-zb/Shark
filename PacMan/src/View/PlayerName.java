package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Main;
import Model.Player;

public class PlayerName extends JFrame {

	private JPanel contentPane;
	private JTextField Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerName frame = new PlayerName();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayerName() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setForeground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		//Home
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();    
						RootLayout home= new RootLayout();
						home.show();
					}
				});
				contentPane.setLayout(null);
				lblNewLabel_4.setToolTipText("Home");
				lblNewLabel_4.setIcon(new ImageIcon(RootLayout.class.getResource("/pac.jpg")));
				lblNewLabel_4.setBounds(12, 397, 74, 67);
				contentPane.add(lblNewLabel_4);
				
				JLabel home = new JLabel("Home...");
				home.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();    
						RootLayout home= new RootLayout();
						home.show();
					}
				});
				home.setHorizontalAlignment(SwingConstants.CENTER);
				home.setForeground(new Color(255, 255, 0));
				home.setFont(new Font("Arial", Font.BOLD, 30));
				home.setBackground(Color.RED);
				home.setBounds(58, 406, 134, 58);
				contentPane.add(home);
				
				//Ghost
				JLabel gho1 = new JLabel("");
				gho1.setToolTipText("Hiii");
				gho1.setIcon(new ImageIcon(PlayerName.class.getResource("/gho1JPG.jpg")));
				gho1.setBounds(269, 33, 88, 95);
				
				JLabel gho2 = new JLabel("");
				gho2.setToolTipText("Hiii");
				gho2.setIcon(new ImageIcon(PlayerName.class.getResource("/gho2JPG.jpg")));
				gho2.setBounds(146, 23, 149, 105);
				
				JLabel gho4 = new JLabel("");
				gho4.setToolTipText("Hiii");
				gho4.setIcon(new ImageIcon(PlayerName.class.getResource("/gho4JPG.jpg")));
				gho4.setBounds(23, 33, 107, 95);
				
				JLabel gho3 = new JLabel("");
				gho3.setToolTipText("Hiii");
				gho3.setIcon(new ImageIcon(PlayerName.class.getResource("/gho3JPG.jpg")));
				gho3.setBounds(307, 262, 134, 102);
				
				
				JLabel playerName = new JLabel("Player Name");
				playerName.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
				playerName.setForeground(Color.WHITE);
				playerName.setBounds(142, 155, 183, 45);
				getContentPane().add(playerName);
				
				
				contentPane.add(gho1);
				contentPane.add(gho2);
				contentPane.add(gho3);
				contentPane.add(gho4);
				
				
				Name = new JTextField();
				Name.setToolTipText("Enter your name or nickname");
				Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
				Name.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Name.setText(null);
						Name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
				});
				Name.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {

						Name.setForeground(Color.BLACK);
						

					}
				});
				Name.setForeground(Color.LIGHT_GRAY);
				Name.setText("Enter your name or nickname");
				Name.setBounds(98, 201, 243, 45);
				getContentPane().add(Name);
				Name.setColumns(10);
				

				
				
				JLabel go = new JLabel("");
				go.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if(Name.getText().isEmpty()|| Name.getText().equals("Enter your name or nickname"))
							Name.setBorder(BorderFactory.createLineBorder(Color.red));
						else {
							String name=Name.getText();
							Player p=new Player(name);
							Main.system.add_player_to_theHistory(p);
							for(Player s:Main.system.getPlayersHistory())
								System.out.println(s);
							dispose(); 
							Pacman pac=new Pacman(p.getPlayerName());
							
						}
						
					}
				});
				go.setToolTipText("start the game");
				go.setIcon(new ImageIcon(PlayerName.class.getResource("/go.jpg")));
				go.setBounds(171, 244, 74, 83);
				contentPane.add(go);
				
				
				


				
	

				

	}

}