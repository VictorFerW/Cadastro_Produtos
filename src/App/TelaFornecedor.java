package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.xml.validation.Schema;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTable;

public class TelaFornecedor {

	private JFrame frame;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table;
	private JTable table_4;
	private JTable table_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor window = new TelaFornecedor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaFornecedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(221, 221, 221));
		frame.setBounds(100, 100, 1006, 705);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 212, 666);
		panel.setBackground(new Color(39, 66, 88));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Produtos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBackground(new Color(39, 66, 88));
		btnNewButton_2.setForeground(new Color(39, 66, 88));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(40, 264, 125, 35);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Entrada");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setForeground(new Color(39, 66, 88));
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2_1.setBackground(new Color(39, 66, 88));
		btnNewButton_2_1.setBounds(40, 310, 125, 35);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Saida");
		btnNewButton_2_2.setForeground(new Color(39, 66, 88));
		btnNewButton_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2_2.setBackground(new Color(39, 66, 88));
		btnNewButton_2_2.setBounds(40, 356, 125, 35);
		panel.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_2_1 = new JButton("Fornecedor ");
		btnNewButton_2_2_1.setForeground(new Color(39, 66, 88));
		btnNewButton_2_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2_2_1.setBackground(new Color(39, 66, 88));
		btnNewButton_2_2_1.setBounds(40, 402, 125, 35);
		panel.add(btnNewButton_2_2_1);
		
		JButton btnNewButton_2_2_2 = new JButton("Marca");
		btnNewButton_2_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_2_2.setForeground(new Color(39, 66, 88));
		btnNewButton_2_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2_2_2.setBackground(new Color(39, 66, 88));
		btnNewButton_2_2_2.setBounds(40, 448, 125, 35);
		panel.add(btnNewButton_2_2_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(40, 45, 125, 122);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Exemplo");
		lblNewLabel_2.setBounds(32, 53, 61, 18);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 192, 192, 1);
		panel.add(panel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 0, 778, 109);
		panel_1.setBackground(new Color(111, 111, 111));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Estoque AV2");
		lblNewLabel_2_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 52));
		lblNewLabel_2_2.setBounds(33, 26, 485, 61);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_6 = new JLabel("Inicio");
		lblNewLabel_3_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_6.setForeground(Color.WHITE);
		lblNewLabel_3_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3_6.setBounds(669, 50, 83, 15);
		panel_1.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fornecedores");
		lblNewLabel_2_1.setBounds(245, 137, 253, 43);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(973, 174, 17, 442);
		frame.getContentPane().add(scrollBar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(244, 211, 195, 210);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fornecedor 1");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 11, 175, 51);
		panel_2.add(lblNewLabel_1_2);
		
		table = new JTable();
		table.setBounds(20, 51, 151, 148);
		panel_2.add(table);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(509, 211, 195, 210);
		frame.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fornecedor 2");
		lblNewLabel_1_2_1.setBounds(10, 11, 175, 51);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		panel_2_1.add(lblNewLabel_1_2_1);
		
		table_1 = new JTable();
		table_1.setBounds(20, 51, 151, 148);
		panel_2_1.add(table_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(768, 211, 195, 210);
		frame.getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Fornecedor 3");
		lblNewLabel_1_2_1_1.setBounds(10, 11, 175, 51);
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		panel_2_2.add(lblNewLabel_1_2_1_1);
		
		table_2 = new JTable();
		table_2.setBounds(20, 51, 151, 148);
		panel_2_2.add(table_2);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBounds(244, 469, 195, 210);
		frame.getContentPane().add(panel_2_3);
		panel_2_3.setLayout(null);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Fornecedor 4");
		lblNewLabel_1_2_2.setBounds(10, 11, 175, 51);
		panel_2_3.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		table_3 = new JTable();
		table_3.setBounds(20, 51, 165, 148);
		panel_2_3.add(table_3);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBounds(509, 469, 195, 210);
		frame.getContentPane().add(panel_2_1_1);
		panel_2_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Fornecedor 5");
		lblNewLabel_1_2_1_2.setBounds(10, 11, 175, 51);
		panel_2_1_1.add(lblNewLabel_1_2_1_2);
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_2_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		table_4 = new JTable();
		table_4.setBounds(20, 51, 152, 148);
		panel_2_1_1.add(table_4);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setBounds(768, 469, 195, 210);
		frame.getContentPane().add(panel_2_2_1);
		panel_2_2_1.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Fornecedor 6");
		lblNewLabel_1_2_1_1_1.setBounds(10, 11, 175, 51);
		panel_2_2_1.add(lblNewLabel_1_2_1_1_1);
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		table_5 = new JTable();
		table_5.setBounds(20, 51, 151, 148);
		panel_2_2_1.add(table_5);
		
	}

	private void px(Color color) {
		// TODO Auto-generated method stub
		
	}
}
