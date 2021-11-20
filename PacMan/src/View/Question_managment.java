package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.Main;
import Model.Answer;
import Model.Player;
import Model.Question;
import Utils.DifficultyLevel;
import java.awt.Color;
import java.awt.event.InputMethodListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;

public class Question_managment extends JFrame {

	private JPanel contentPane;
	private JTextField answer1;
	private JTextField answer2;
	private JTextField answer3;
	private JTextField answer4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField content;
	private JComboBox comboBoxdifficulty;
	JComboBox idBox;
	private int idChoseen=0;
	Question que;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_managment frame = new Question_managment();
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
	public Question_managment() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//Home
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(1, 626, 91, 82);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();    
				RootLayout home= new RootLayout();
				home.show();
			}
		});
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		lblNewLabel_4.setToolTipText("Home");
		lblNewLabel_4.setIcon(new ImageIcon(RootLayout.class.getResource("/pacaJPG.jpg")));
		contentPane.add(lblNewLabel_4);
		
		JLabel home = new JLabel("Home...");
		home.setBounds(61, 637, 134, 58);
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
		contentPane.add(home);
		
		
		//Title
		JLabel packman = new JLabel("Questions");
		packman.setBounds(313, -16, 433, 103);
		packman.setHorizontalAlignment(SwingConstants.CENTER);
		packman.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
		packman.setBackground(new Color(255, 0, 0));
		packman.setForeground(new Color(255, 255, 0));
		getContentPane().add(packman);
		
		JLabel lblSelectAQuestion = new JLabel("Select a question number ");
		lblSelectAQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAQuestion.setForeground(new Color(255, 204, 51));
		lblSelectAQuestion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblSelectAQuestion.setBackground(Color.RED);
		lblSelectAQuestion.setBounds(73, 145, 272, 57);
		contentPane.add(lblSelectAQuestion);
		
		JLabel lblAnswer = new JLabel("Answer 1 :");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setForeground(new Color(255, 204, 51));
		lblAnswer.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblAnswer.setBackground(Color.RED);
		lblAnswer.setBounds(133, 327, 168, 57);
		contentPane.add(lblAnswer);
		
		JLabel lblSelectAQuestion_1_1 = new JLabel("Answer 2 :");
		lblSelectAQuestion_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAQuestion_1_1.setForeground(new Color(255, 204, 51));
		lblSelectAQuestion_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblSelectAQuestion_1_1.setBackground(Color.RED);
		lblSelectAQuestion_1_1.setBounds(133, 376, 168, 57);
		contentPane.add(lblSelectAQuestion_1_1);
		
		JLabel lblSelectAQuestion_1_1_1 = new JLabel("Answer 3 :");
		lblSelectAQuestion_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAQuestion_1_1_1.setForeground(new Color(255, 204, 51));
		lblSelectAQuestion_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblSelectAQuestion_1_1_1.setBackground(Color.RED);
		lblSelectAQuestion_1_1_1.setBounds(133, 427, 168, 57);
		contentPane.add(lblSelectAQuestion_1_1_1);
		
		JLabel lblSelectAQuestion_1_1_2 = new JLabel("Answer 4 :");
		lblSelectAQuestion_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAQuestion_1_1_2.setForeground(new Color(255, 204, 51));
		lblSelectAQuestion_1_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblSelectAQuestion_1_1_2.setBackground(Color.RED);
		lblSelectAQuestion_1_1_2.setBounds(133, 479, 168, 57);
		contentPane.add(lblSelectAQuestion_1_1_2);
		
		
		
		
		answer1 = new JTextField();
		answer1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				answer1.setForeground(Color.BLACK);

			}
		});
		answer1.setForeground(new Color(0, 51, 102));
		answer1.setBounds(323, 337, 363, 38);
		getContentPane().add(answer1);
		answer1.setColumns(10);
		
		answer2 = new JTextField();
		answer2.setForeground(new Color(0, 51, 102));
		answer2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer2.setColumns(10);
		answer2.setBounds(323, 386, 363, 38);
		contentPane.add(answer2);
		
		answer3 = new JTextField();
		answer3.setForeground(new Color(0, 51, 102));
		answer3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer3.setColumns(10);
		answer3.setBounds(324, 437, 363, 38);
		contentPane.add(answer3);
		
		answer4 = new JTextField();
		answer4.setForeground(new Color(0, 51, 102));
		answer4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer4.setColumns(10);
		answer4.setBounds(324, 489, 363, 38);
		contentPane.add(answer4);
		
		JLabel saveIcon = 
				new JLabel("");
		saveIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save_the_changing();
				Main.system.WriteQuestions();
			}

			
		});
		saveIcon.setToolTipText("Save The Changing");
		saveIcon.setBounds(495, 535, 85, 67);
		saveIcon.setIcon(new ImageIcon(RootLayout.class.getResource("/greJPG.jpg")));
		contentPane.add(saveIcon);
		
		JLabel lblTheQuestionIs = new JLabel("The question is");
		lblTheQuestionIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheQuestionIs.setForeground(new Color(255, 204, 51));
		lblTheQuestionIs.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblTheQuestionIs.setBackground(Color.RED);
		lblTheQuestionIs.setBounds(90, 215, 211, 57);
		contentPane.add(lblTheQuestionIs);
		
		content = new JTextField();
		content.setForeground(new Color(0, 51, 102));
		content.setFont(new Font("Tahoma", Font.PLAIN, 17));
		content.setColumns(10);
		content.setBounds(323, 225, 439, 38);
		contentPane.add(content);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulty.setForeground(new Color(255, 204, 51));
		lblDifficulty.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDifficulty.setBackground(Color.RED);
		lblDifficulty.setBounds(90, 275, 248, 57);
		contentPane.add(lblDifficulty);
		
		
		comboBoxdifficulty = new JComboBox(DifficultyLevel.values());
		comboBoxdifficulty.setBackground(SystemColor.activeCaption);
		comboBoxdifficulty.setForeground(new Color(0, 0, 0));
		comboBoxdifficulty.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxdifficulty.setBounds(323, 285, 128, 38);
		getContentPane().add(comboBoxdifficulty);
		
		JLabel lblSaveTheChanging = new JLabel("Save The Changing");
		lblSaveTheChanging.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveTheChanging.setForeground(new Color(255, 255, 255));
		lblSaveTheChanging.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblSaveTheChanging.setBackground(Color.RED);
		lblSaveTheChanging.setBounds(557, 540, 217, 58);
		contentPane.add(lblSaveTheChanging);
		
		JLabel remove = new JLabel("");
		remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean flag=Main.system.removeQuestion(que);
				idBox = new JComboBox(Main.system.getQuestionList().keySet().toArray());
				JOptionPane.showMessageDialog(null, "We have successfully remove the question"+flag);
			}
		});
		remove.setToolTipText("Remove the question");
		remove.setBounds(398, 535, 98, 67);
		remove.setIcon(new ImageIcon(RootLayout.class.getResource("/red.jpg")));
		contentPane.add(remove);
		
		JLabel lblDeleteTheQuestion = new JLabel("Delete The Question");
		lblDeleteTheQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteTheQuestion.setForeground(new Color(255, 255, 255));
		lblDeleteTheQuestion.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblDeleteTheQuestion.setBackground(Color.RED);
		lblDeleteTheQuestion.setBounds(196, 540, 217, 58);
		contentPane.add(lblDeleteTheQuestion);
		
		 idBox = new JComboBox(Main.system.getQuestionList().keySet().toArray());
		idBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTheJtext();
			}
		});
		idBox.setFont(new Font("Tahoma", Font.BOLD, 17));
		idBox.setForeground(new Color(240, 248, 255));
		idBox.setBackground(new Color(210, 105, 30));
		idBox.setBounds(324, 155, 108, 37);
		getContentPane().add(idBox);
		
		JLabel lblToAddNew = new JLabel("To Add New Question");
		lblToAddNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblToAddNew.setForeground(Color.YELLOW);
		lblToAddNew.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblToAddNew.setBackground(Color.RED);
		lblToAddNew.setBounds(698, 309, 400, 103);
		contentPane.add(lblToAddNew);
		
		JLabel addQues = new JLabel("");
		addQues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddQuestion newQuestion= new AddQuestion();
				newQuestion.show();
			}
		});
		addQues.setToolTipText("To Add Question");
		addQues.setBounds(842, 371, 128, 135);
		addQues.setIcon(new ImageIcon(RootLayout.class.getResource("/addQ.jpg")));
		contentPane.add(addQues);
		

}
	
	
	public void refresh() {
		idBox = new JComboBox(Main.system.getQuestionList().keySet().toArray());
		content.setText(null);
		comboBoxdifficulty.setSelectedIndex(1);
		answer1.setText(null);
		answer2.setText(null);
		answer3.setText(null);
		answer4.setText(null);
		answer1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		answer2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		answer3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		answer4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	public void updateTheJtext() {
		idChoseen=  (int) idBox.getSelectedItem();
		que=Main.system.get_Question_by_Id(idChoseen);
		if(que!=null){
			answer1.setText(que.getAnswers().get(1).getContent());
			answer2.setText(que.getAnswers().get(2).getContent());
			answer3.setText(que.getAnswers().get(3).getContent());
			answer4.setText(que.getAnswers().get(4).getContent());
			content.setText(que.getContent());
			comboBoxdifficulty.setSelectedItem(que.getDifficulty());
			
		}
	}
	

	
	
	
	public void save_the_changing() {
		try {
			boolean flage=false;
			updateTheJtext();
			//check empty fields
			if(idChoseen==0)
				throw new Exception("There is empty fields");
			if(content.getText().isEmpty())
				throw new Exception("There is empty fields");
			if(answer1.getText().isEmpty() ) {
				answer1.setBorder(BorderFactory.createLineBorder(Color.red));
				flage=true;
				
			}
				
			if(answer2.getText().isEmpty()) {
				answer2.setBorder(BorderFactory.createLineBorder(Color.red));
				flage=true;
			}
				
			if(answer3.getText().isEmpty() ) {
				answer3.setBorder(BorderFactory.createLineBorder(Color.red));
				flage=true;
			}
			if(answer4.getText().isEmpty() ) {
				answer4.setBorder(BorderFactory.createLineBorder(Color.red));
				flage=true;
			}
			if(flage)
				throw new Exception("There is empty fields");
			
			//change the setting of the question if there
			DifficultyLevel dl=(DifficultyLevel) comboBoxdifficulty.getSelectedItem();
			que.setAnswerById(1,answer1.getText());
			que.setAnswerById(2,answer2.getText());
			que.setAnswerById(3,answer3.getText());
			que.setAnswerById(4,answer4.getText());
			que.setDifficulty(dl);
			que.setContent(content.getSelectedText());
			refresh();
			
			
			JOptionPane.showMessageDialog(null, "We have successfully change the question");
			
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		

}
	
	
}
