package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.Main;
import Model.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;

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
		this.setLocationRelativeTo(null); 
		
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		//Title
		JLabel lblNewLabel_1 = new JLabel("The 5 Best Players");
		lblNewLabel_1.setBounds(221, 43, 355, 46);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		contentPane.add(lblNewLabel_1);
		
		JLabel Stars = new JLabel("");
		Stars.setBounds(296, 63, 261, 88);
		Stars.setToolTipText("Top 5");
		Stars.setIcon(new ImageIcon(RootLayout.class.getResource("/5Stars.jpg")));
		contentPane.add(Stars);
		
		
		//table for the best five
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(84, 164, 657, 229);
		scrollPane_1.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 200, 0), Color.ORANGE, Color.ORANGE, null));
		contentPane.add(scrollPane_1);
		
		String col[] = {"Rank", "NickName", "Score"};
		DefaultTableModel model = new DefaultTableModel(null,col);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		
		
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.yellow);
		header.setForeground(Color.blue);
		header.setFont(new Font("Arial", Font.BOLD, 20));
		table.getColumnModel().getColumn(0).setPreferredWidth(63);
		table.getColumnModel().getColumn(1).setPreferredWidth(122);
		table.setForeground(new Color(255, 204, 51));
		table.setBackground(new Color(0, 102, 204));
		scrollPane_1.setViewportView(table);
		table.setRowHeight(27);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		
		
		
        //Home
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(12, 423, 90, 88);
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
		contentPane.add(lblNewLabel_4);
		
		JLabel home = new JLabel("Home...");
		home.setBounds(52, 455, 147, 29);
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
		
		//to get the list of best 5 players
		setBestFive();
		
		

	}
	
	public void setBestFive() {
		
		table.removeAll();
		try {
			List<Player> array=new  ArrayList<Player>();
			array=Main.system.getPlayersHistory();
			Integer num = (Integer) ((array.size()<5) ? array.size():5);
			model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[]{  "","",""});
			for(int i=0 ; i<num ;i++) {
				Player p=Main.system.getPlayersHistory().get(i);
			    model.addRow(new Object[]{(i+1),p.getPlayerName(),p.getScore()});
			    //model.addRow(new Object[]{  "","",""});


			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());

		}
		
		
	}
}

