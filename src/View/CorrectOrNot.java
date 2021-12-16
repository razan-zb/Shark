package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CorrectOrNot extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CorrectOrNot dialog = new CorrectOrNot(10);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog to make the player know if the answer that he choose is correct or not 
	 */
	public CorrectOrNot(int i) {
		setBounds(100, 100, 577, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null); 
		{
			JLabel lblNewLabel = new JLabel("You got "+i+" point to your score");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
			lblNewLabel.setBounds(36, 101, 494, 97);
			contentPanel.add(lblNewLabel);
		}
		
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblNewLabel_1.setBounds(166, 85, 229, 36);
			contentPanel.add(lblNewLabel_1);
		
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			
		}
		
		
		if(i<0) {
			contentPanel.setBackground(Color.red);
			lblNewLabel_1.setText("Uncorrect Answer");
		}
			
		else {
			contentPanel.setBackground(Color.green);
			lblNewLabel_1.setText("Correct Answer");
		}
			
			
			
	}

}
