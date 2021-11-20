package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class RootLayout extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField startButton;
	private JTextField history;
	private JTextField QuestionsManagment;
	private JFrame panel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RootLayout frame = new RootLayout();
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
	public RootLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setToolTipText("I am Pacman");
		lblNewLabel_4.setIcon(new ImageIcon(RootLayout.class.getResource("/pac.jpg")));
		lblNewLabel_4.setBounds(12, 404, 90, 88);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RootLayout.class.getResource("/1.jpg")));
		lblNewLabel_1.setBounds(189, 87, 462, 88);
		getContentPane().add(lblNewLabel_1);
		

		
		//start game icon		
		history = new JTextField();
		history.setBackground(new Color(51, 102, 204));
		history.setHorizontalAlignment(SwingConstants.CENTER);
		history.setEditable(false);
		history.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();    
				History h= new History();
				h.show();
			}
		});
		
		JLabel remove = new JLabel("");
		remove.setToolTipText("Remove");
		remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});

		history.setFont(new Font("Tahoma", Font.BOLD, 18));
		history.setForeground(new Color(255, 255, 255));
		history.setText("History");
		history.setBounds(304, 267, 232, 53);
		getContentPane().add(history);
		history.setColumns(10);
		history.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		startButton = new JTextField();
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();    		
				PlayerName h= new PlayerName();
				h.show();
				
			}
		});
		startButton.setBackground(new Color(51, 102, 204));
		startButton.setHorizontalAlignment(SwingConstants.CENTER);
		startButton.setEditable(false);
		startButton.setText("Start Game");
		startButton.setForeground(Color.WHITE);
		startButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		startButton.setColumns(10);
		startButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		startButton.setBounds(304, 188, 232, 53);
		contentPane.add(startButton);
		
		QuestionsManagment = new JTextField();
		QuestionsManagment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();    		
				Question_managment q= new Question_managment();
				q.show();
			}
		});
		QuestionsManagment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();    		
				Question_managment q= new Question_managment();
				q.show();
				
			}
		});
		QuestionsManagment.setBackground(new Color(51, 102, 204));
		QuestionsManagment.setHorizontalAlignment(SwingConstants.CENTER);
		QuestionsManagment.setEditable(false);
		QuestionsManagment.setText("Questions Managment");
		QuestionsManagment.setForeground(new Color(255, 255, 255));
		QuestionsManagment.setFont(new Font("Tahoma", Font.BOLD, 17));
		QuestionsManagment.setColumns(10);
		QuestionsManagment.setBounds(304, 342, 232, 53);
		QuestionsManagment.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(QuestionsManagment);
		
		//history Icon 3people
		JLabel historySide = new JLabel("");
		historySide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();    		
				History h= new History();
				h.show();
				
				
			}
		});
		historySide.setToolTipText("Top five");
		historySide.setIcon(new ImageIcon(RootLayout.class.getResource("/historySide.jpg")));
		historySide.setBounds(214, 267, 78, 63);
		getContentPane().add(historySide);
		
		//playIcon
		JLabel playIcom = new JLabel("");
		playIcom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				dispose();    		
				PlayerName h= new PlayerName();
				h.show();

			}
		});
		playIcom.setToolTipText("play");
		playIcom.setIcon(new ImageIcon(RootLayout.class.getResource("/playButton.jpg")));
		playIcom.setBounds(214, 176, 66, 88);
		getContentPane().add(playIcom);
		
		//setting icon
		JLabel setting = new JLabel("");
		setting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();    		
				Question_managment q= new Question_managment();
				q.show();
			}
		});
		setting.setToolTipText("managment");
		setting.setBounds(202, 342, 78, 63);
		setting.setIcon(new ImageIcon(RootLayout.class.getResource("/setting.jpg")));
		getContentPane().add(setting);
		
		//Title
		JLabel packman = new JLabel("Packman");
		packman.setHorizontalAlignment(SwingConstants.CENTER);
		packman.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
		packman.setBackground(new Color(255, 0, 0));
		packman.setForeground(new Color(255, 255, 0));
		packman.setBounds(166, 13, 433, 75);
		getContentPane().add(packman);
		
		//contentPane.setVisible(false);
		
		
	
		
		
		
	}
}
