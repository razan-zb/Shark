package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
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
	public History() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		//Title
		JLabel lblNewLabel_1 = new JLabel("The 5 Best Players");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(221, 43, 355, 46);
		
		contentPane.add(lblNewLabel_1);
		
		JLabel Stars = new JLabel("");
		Stars.setToolTipText("Top 5");
		Stars.setIcon(new ImageIcon(RootLayout.class.getResource("/5Stars.jpg")));
		Stars.setBounds(296, 63, 261, 88);
		contentPane.add(Stars);
		
		
		//table
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0), null));
		scrollPane_1.setBounds(73, 164, 686, 229);
		contentPane.add(scrollPane_1);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"    Rank", "    Score", "    NickName"
			}
		));
		table.setForeground(new Color(240, 255, 255));
		table.setBackground(new Color(210, 105, 30));
		table.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrollPane_1.setViewportView(table);
		
		
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
		lblNewLabel_4.setToolTipText("Home");
		lblNewLabel_4.setIcon(new ImageIcon(RootLayout.class.getResource("/pac.jpg")));
		lblNewLabel_4.setBounds(12, 423, 90, 88);
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
		home.setBounds(52, 455, 147, 29);
		contentPane.add(home);
		
		

	}
}

