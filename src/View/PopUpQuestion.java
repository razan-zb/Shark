package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Main;
import Controller.PacmanGame;
import Model.Answer;
import Model.Question;
import Model.QuestionBall;
import Utils.DifficultyLevel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

/**
 * 
 * @author Razan Zbedy
 *
 */
public class PopUpQuestion extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JRadioButton button1;
	private JRadioButton button2;
	private JRadioButton button3;
	private JRadioButton button4;
	private int numberOfSelectedAnswer=0;
	private Question question;
    static int addScore=0;
    PacmanGame game;
    boolean flage=false;
    

	/**
	 * 
	 * @param args
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    Answer a1=new Answer(1,"answer1",true);
				    Answer a2=new Answer(2,"answer2",false);
				    Answer a3=new Answer(3,"answer3",false);
				    Answer a4=new Answer(4,"answer4",false);
				    HashMap<Integer,Answer> has=new  HashMap<Integer,Answer>();
				    has.put(1, a1);
				    has.put(2, a2);
				    has.put(3, a3);
				    has.put(4, a4);
				    Question q=new Question("Question Content ",DifficultyLevel.EASY,has);
					PopUpQuestion frame = new PopUpQuestion(q);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame to answer the question when the pacman eats a question food 
	 *  @param question is the question that the ball have when eating it
	 *  
	 */
	
    
    
	public PopUpQuestion(Question question,PacmanGame game) {
		this.question=question;
		this.game=game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 467);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 139, 139));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		
		/**
		 * contentLabel To set the question content
		 */
		JLabel contentLabel = new JLabel(question.getContent()+"?");
		contentLabel.setForeground(new Color(128, 0, 0));
		contentLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentLabel.setBounds(233, 49, 634, 47);
		contentPane.add(contentLabel);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		textField.setBackground(new Color(128, 0, 0));
		textField.setBounds(0, 0, 201, 479);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		/**
		 * answer1 label for the first answer
		 * answer2 label for the second answer
		 * answer3 label for the third answer
		 * answer4 label for the ford answer
		 */
		JLabel answer1 = new JLabel("1.  "+question.getAnswers().get(1).getContent());
		answer1.setFont(new Font("Tahoma", Font.BOLD, 20));
		answer1.setForeground(new Color(139, 0, 0));
		answer1.setBounds(266, 122, 574, 31);
		contentPane.add(answer1);
		
		JLabel answer2 = new JLabel("2.  "+question.getAnswers().get(2).getContent());
		answer2.setForeground(new Color(139, 0, 0));
		answer2.setFont(new Font("Tahoma", Font.BOLD, 20));
		answer2.setBounds(266, 174, 601, 31);
		contentPane.add(answer2);
		
		JLabel answer3 = new JLabel("3.  "+question.getAnswers().get(3).getContent());
		answer3.setForeground(new Color(139, 0, 0));
		answer3.setFont(new Font("Tahoma", Font.BOLD, 20));
		answer3.setBounds(266, 231, 601, 31);
		contentPane.add(answer3);
		
		JLabel answer4 = new JLabel("4.  "+question.getAnswers().get(4).getContent());
		answer4.setForeground(new Color(139, 0, 0));
		answer4.setFont(new Font("Tahoma", Font.BOLD, 20));
		answer4.setBounds(266, 291, 601, 31);
		contentPane.add(answer4);
		

	    button1 = new JRadioButton("");
		button1.setBackground(new Color(0, 128, 128));
		button1.setBounds(233, 128, 25, 25);
		contentPane.add(button1);
		
	    button2 = new JRadioButton("");
		button2.setBackground(new Color(0, 128, 128));
		button2.setBounds(233, 180, 25, 25);
		contentPane.add(button2);
		
        button3 = new JRadioButton("");
		button3.setBackground(new Color(0, 128, 128));
		button3.setBounds(233, 237, 25, 25);
		contentPane.add(button3);
		
	    button4 = new JRadioButton("");
		button4.setBackground(new Color(0, 128, 128));
		button4.setBounds(233, 297, 25, 25);
		contentPane.add(button4);
		
		JButton submit = new JButton("Submit");
		submit.setForeground(new Color(0, 128, 128));
		submit.setFont(new Font("Tahoma", Font.BOLD, 20));
		submit.setBackground(new Color(128, 0, 0));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkRadio())
					getScore(numberOfSelectedAnswer);
				if(addScore!=0) {
					CorrectOrNot  c=new CorrectOrNot(addScore);
					setVisible(false);
					c.setVisible(true);
					  new java.util.Timer().schedule( 
			                    new java.util.TimerTask() {
			                        @Override
			                        public void run() {
			                        	c.setVisible(false);
			                        	setFlage(true);
			                        	QuestionBall.isGo=true;
			                        }
			                    }, 
			                    0 
			            );						
				}
			
										
		     setFlage(true);
			}
		});
		submit.setBounds(401, 368, 143, 39);
		contentPane.add(submit);

	}
	
	
	
	public boolean isFlage() {
		return flage;
	}



	public void setFlage(boolean flage) {
		this.flage = flage;
	}



	/**
	 * to check that the player chooses one answer
	 */
	public boolean checkRadio() {
		int num=0;
		if(button1.isSelected()) {
			num++;
			numberOfSelectedAnswer=1;
		}
			
		if(button2.isSelected()) {
			num++;
			numberOfSelectedAnswer=2;
		}
			
		if(button3.isSelected()) {
			num++;
			numberOfSelectedAnswer=3;
		}
		if(button4.isSelected()) {
			num++;
			numberOfSelectedAnswer=4;
		}
		
		if(num!=1) {
		   JOptionPane.showMessageDialog(null, "Please select one answer");
		   return false;
		}
		return true;
			
	}
	
	/**
	 * to calculate the addition score 
	 * @param i the number of the choosen answer
	 */
	public void getScore(int i) {
		int numDiff=0;
	    if(question.getDifficulty()==DifficultyLevel.EASY)
	    	numDiff=1;
	    else 
	    	if(question.getDifficulty()==DifficultyLevel.MEDIUM)
	    		numDiff=2;
	    	else
	    		if(question.getDifficulty()==DifficultyLevel.HARD)
	    			numDiff=3;
	    	
		if(question.getAnswers().get(i).isCorrect()) 
			addScore=numDiff;
		else
			addScore=numDiff*(-10);
		//to add/remove point from the game score
        game.addScore(addScore);
		
	}


	


	
	
	
}
