package View;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Main;
import Model.Answer;
import Model.Question;
import Utils.DifficultyLevel;

import java.awt.Color;

public class AddQuestion extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField content;
	private JLabel lblEnterQuestionContent;
	private JTextField answer1txt;
	private JLabel lblAnswerIs;
	private JLabel lblAnswerIs_2;
	private JTextField answer2txt;
	private JLabel lblAnswerIs_1;
	private JTextField answer3txt;
	private JLabel lblAnswerIs_3;
	private JTextField answer4txt;
	JComboBox correctAnswer;
	JComboBox difficulty;
	private int idChoseen=0;
	ArrayList<Integer> indexList=new ArrayList<Integer>();
	String ans1=null;
	String ans2=null;
	String ans3=null;
	String ans4=null;
	private JLabel lblAnswerIs_4;
	private JLabel lblAnswerIs_5;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion frame = new AddQuestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AddQuestion() {
		setAlwaysOnTop(true);
		this.setLocationRelativeTo(null); 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();    		
				Question_managment q= new Question_managment();
				q.show();
				setVisible(false);
			
			}
		});
		indexList.add(1);
		indexList.add(2);
		indexList.add(3);
		indexList.add(4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 810);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setForeground(new Color(0, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		content = new JTextField();
		content.setForeground(new Color(0, 51, 102));
		content.setFont(new Font("Tahoma", Font.PLAIN, 17));
		content.setColumns(10);
		content.setBounds(60, 163, 439, 38);
		contentPane.add(content);
		
		//Title
		JLabel packman = new JLabel("Add Question");
		packman.setBounds(134, -22, 295, 100);
		packman.setHorizontalAlignment(SwingConstants.CENTER);
		packman.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		packman.setBackground(new Color(255, 0, 0));
		packman.setForeground(new Color(255, 255, 0));
		getContentPane().add(packman);
		
		lblEnterQuestionContent = new JLabel("Enter Question Content");
		lblEnterQuestionContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterQuestionContent.setForeground(new Color(255, 153, 51));
		lblEnterQuestionContent.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblEnterQuestionContent.setBackground(Color.RED);
		lblEnterQuestionContent.setBounds(134, 100, 295, 74);
		contentPane.add(lblEnterQuestionContent);
		
		answer1txt = new JTextField();
		answer1txt.setForeground(new Color(0, 51, 102));
		answer1txt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer1txt.setColumns(10);
		answer1txt.setBounds(114, 272, 328, 38);
		contentPane.add(answer1txt);
		
		lblAnswerIs = new JLabel("Answer 1 is : ");
		lblAnswerIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerIs.setForeground(new Color(255, 153, 51));
		lblAnswerIs.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblAnswerIs.setBackground(new Color(255, 153, 51));
		lblAnswerIs.setBounds(134, 228, 295, 53);
		contentPane.add(lblAnswerIs);
		
		lblAnswerIs_2 = new JLabel("Answer 2 is : ");
		lblAnswerIs_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerIs_2.setForeground(new Color(255, 153, 51));
		lblAnswerIs_2.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblAnswerIs_2.setBackground(new Color(255, 153, 51));
		lblAnswerIs_2.setBounds(134, 313, 295, 53);
		contentPane.add(lblAnswerIs_2);
		
		answer2txt = new JTextField();
		answer2txt.setForeground(new Color(0, 51, 102));
		answer2txt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer2txt.setColumns(10);
		answer2txt.setBounds(114, 356, 328, 38);
		contentPane.add(answer2txt);
		
		lblAnswerIs_1 = new JLabel("Answer 3 is : ");
		lblAnswerIs_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerIs_1.setForeground(new Color(255, 153, 51));
		lblAnswerIs_1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblAnswerIs_1.setBackground(Color.RED);
		lblAnswerIs_1.setBounds(134, 398, 295, 53);
		contentPane.add(lblAnswerIs_1);
		
		answer3txt = new JTextField();
		answer3txt.setForeground(new Color(0, 51, 102));
		answer3txt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer3txt.setColumns(10);
		answer3txt.setBounds(114, 438, 328, 38);
		contentPane.add(answer3txt);
		
		lblAnswerIs_3 = new JLabel("Answer 4 is : ");
		lblAnswerIs_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerIs_3.setForeground(new Color(255, 153, 51));
		lblAnswerIs_3.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblAnswerIs_3.setBackground(Color.RED);
		lblAnswerIs_3.setBounds(134, 475, 295, 53);
		contentPane.add(lblAnswerIs_3);
		
		answer4txt = new JTextField();
		answer4txt.setForeground(new Color(0, 51, 102));
		answer4txt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer4txt.setColumns(10);
		answer4txt.setBounds(114, 514, 328, 38);
		contentPane.add(answer4txt);
		
		
		correctAnswer= new JComboBox(indexList.toArray());
		correctAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idChoseen=  (Integer) correctAnswer.getSelectedItem();		
			}
		});
		correctAnswer.setFont(new Font("Tahoma", Font.BOLD, 17));
		correctAnswer.setForeground(new Color(240, 248, 255));
		correctAnswer.setBackground(new Color(210, 105, 30));
		correctAnswer.setBounds(219, 609, 108, 37);
		getContentPane().add(correctAnswer);
		
		
		
		difficulty = new JComboBox(DifficultyLevel.values());
		difficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		difficulty.setFont(new Font("Tahoma", Font.BOLD, 17));
		difficulty.setForeground(new Color(240, 248, 255));
		difficulty.setBackground(new Color(210, 105, 30));
		difficulty.setBounds(219, 699, 108, 37);
		getContentPane().add(difficulty);
		
		lblAnswerIs_4 = new JLabel("Choose Correct Answer");
		lblAnswerIs_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerIs_4.setForeground(new Color(255, 153, 51));
		lblAnswerIs_4.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblAnswerIs_4.setBackground(Color.RED);
		lblAnswerIs_4.setBounds(124, 556, 295, 53);
		contentPane.add(lblAnswerIs_4);
		
		lblAnswerIs_5 = new JLabel("What Is The Difficulty Level ?");
		lblAnswerIs_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerIs_5.setForeground(new Color(255, 153, 51));
		lblAnswerIs_5.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblAnswerIs_5.setBackground(Color.RED);
		lblAnswerIs_5.setBounds(92, 641, 371, 53);
		contentPane.add(lblAnswerIs_5);
		
		
		JLabel save = new JLabel("");
		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addQuestionAndCheck();
				dispose();    		
				Question_managment q= new Question_managment();
				q.show();
				
		
			}
		});
		contentPane.setLayout(null);
		save.setToolTipText("Save");
		save.setIcon(new ImageIcon(RootLayout.class.getResource("/saving.jpg")));
		save.setBounds(475, 676, 108, 74);
		contentPane.add(save);
		
		
		JLabel arrow = new JLabel("");
		arrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();  
				Question_managment q= new Question_managment();
				q.show();

			}
		});
		contentPane.setLayout(null);
		arrow.setToolTipText("Save");
		arrow.setIcon(new ImageIcon(RootLayout.class.getResource("/leftArrow.jpg")));
		arrow.setBounds(0, 676, 108, 74);
		contentPane.add(arrow);
	}
	
	
	public void addQuestionAndCheck() {
		try {
			 boolean flage=false;
			 ans1=answer1txt.getText();
			 ans2=answer2txt.getText();
			 ans3=answer3txt.getText();
			 ans4=answer4txt.getText();
			 DifficultyLevel dl=(DifficultyLevel) difficulty.getSelectedItem();
			 idChoseen=(Integer) correctAnswer.getSelectedItem();
			 String questionContent=content.getText();

			//check empty fields
			 if(content.getText().isEmpty() ) {
				 content.setBorder(BorderFactory.createLineBorder(Color.red));
				 flage=true;	
			}
	
			if(ans1.isEmpty()) {
				answer1txt.setBorder(BorderFactory.createLineBorder(Color.red));
				flage=true;
				
			}
				
			if(ans2.isEmpty()) {
				answer2txt.setBorder(BorderFactory.createLineBorder(Color.red));
				flage=true;
			}
				
			if(ans3.isEmpty()) {
				answer3txt.setBorder(BorderFactory.createLineBorder(Color.red));
				flage=true;
			}
			if(ans4.isEmpty()) {
				answer4txt.setBorder(BorderFactory.createLineBorder(Color.red));
				flage=true;
			}
			if(difficulty.getSelectedItem()==null) {
				flage=true;
			}
			if(correctAnswer.getSelectedItem()==null) {
				flage=true;
			}
			if(idChoseen==0)
				flage=true;
			if(flage)
				throw new Exception("There is empty fields");
			
			//hash for the answers
			HashMap<Integer,Answer> answer=new HashMap<Integer, Answer>();
			//set the correct answer
			answer.put(1, new Answer(1,ans1,false));
			answer.put(2, new Answer(2,ans2,false));
			answer.put(3, new Answer(3,ans3,false));
			answer.put(4, new Answer(4,ans4,false));
			answer.get(idChoseen).setCorrect(true);
			

	
			
			Question newQuestion=new Question(questionContent,dl,answer,"animal");
			Main.system.addQuestion(newQuestion);

			JOptionPane.showMessageDialog(null, "We Have Successfully Add New Question");
			
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		

}
	

}
