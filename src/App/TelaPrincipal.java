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

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(244, 255, 195, 175);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		Button button = new Button("Produtos");
		button.setFont(new Font("Arial", Font.BOLD, 13));
		button.setForeground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBackground(new Color(66, 112, 149));
		button.setBounds(30, 98, 137, 36);
		panel_2.add(button);
		
		JLabel lblNewLabel = new JLabel("Gerenciar produtos");
		lblNewLabel.setForeground(new Color(89, 89, 89));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 124, 175, 51);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(151, 0, 4));
		panel_3.setBounds(30, 11, 137, 78);
		panel_2.add(panel_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(509, 255, 195, 175);
		frame.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		Button button_1 = new Button("Entradas");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial", Font.BOLD, 13));
		button_1.setBackground(new Color(66, 112, 149));
		button_1.setBounds(30, 97, 137, 36);
		panel_2_1.add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("Gerenciar entrada de produtos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(89, 89, 89));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 124, 175, 51);
		panel_2_1.add(lblNewLabel_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(14, 106, 0));
		panel_3_1.setBounds(30, 11, 137, 78);
		panel_2_1.add(panel_3_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(768, 255, 195, 175);
		frame.getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);
		
		Button button_1_1 = new Button("Saidas");
		button_1_1.setForeground(Color.WHITE);
		button_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		button_1_1.setBackground(new Color(66, 112, 149));
		button_1_1.setBounds(30, 98, 137, 36);
		panel_2_2.add(button_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gerenciar saida de produtos");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 124, 175, 51);
		panel_2_2.add(lblNewLabel_1_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(16, 46, 90));
		panel_3_2.setBounds(30, 11, 137, 78);
		panel_2_2.add(panel_3_2);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBounds(244, 480, 195, 175);
		frame.getContentPane().add(panel_2_3);
		
		Button button_2 = new Button("Fornecedor");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Arial", Font.BOLD, 13));
		button_2.setBackground(new Color(66, 112, 149));
		button_2.setBounds(30, 96, 137, 36);
		panel_2_3.add(button_2);
		
		JLabel lblGerenciarFornecedores = new JLabel("Contato de fornecedores");
		lblGerenciarFornecedores.setToolTipText("");
		lblGerenciarFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarFornecedores.setForeground(new Color(89, 89, 89));
		lblGerenciarFornecedores.setFont(new Font("Arial", Font.BOLD, 12));
		lblGerenciarFornecedores.setBounds(10, 124, 175, 51);
		panel_2_3.add(lblGerenciarFornecedores);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBackground(new Color(151, 0, 4));
		panel_3_3.setBounds(30, 11, 137, 78);
		panel_2_3.add(panel_3_3);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(509, 480, 195, 175);
		frame.getContentPane().add(panel_2_1_1);
		
		Button button_1_2 = new Button("Marcas");
		button_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1_2.setForeground(Color.WHITE);
		button_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		button_1_2.setBackground(new Color(66, 112, 149));
		button_1_2.setBounds(30, 98, 137, 36);
		panel_2_1_1.add(button_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Marcas parceiras");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 124, 175, 51);
		panel_2_1_1.add(lblNewLabel_1_2);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBackground(new Color(14, 106, 0));
		panel_3_4.setBounds(30, 11, 137, 78);
		panel_2_1_1.add(panel_3_4);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBounds(768, 480, 195, 175);
		frame.getContentPane().add(panel_2_2_1);
		
		Button button_1_1_1 = new Button("Feedback");
		button_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1_1_1.setForeground(Color.WHITE);
		button_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		button_1_1_1.setBackground(new Color(66, 112, 149));
		button_1_1_1.setBounds(30, 98, 137, 36);
		panel_2_2_1.add(button_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Deixa sua Avaliação!");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(89, 89, 89));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 124, 175, 51);
		panel_2_2_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_3_5 = new JPanel();
		panel_3_5.setBackground(new Color(16, 46, 90));
		panel_3_5.setBounds(30, 14, 137, 78);
		panel_2_2_1.add(panel_3_5);
		
		JLabel lblNewLabel_2 = new JLabel("Bem-vindo!");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_2.setBounds(244, 142, 332, 58);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Atalhos");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(244, 211, 253, 43);
		frame.getContentPane().add(lblNewLabel_2_1);
		
	}

	private void px(Color color) {
		// TODO Auto-generated method stub
		
	}
}
