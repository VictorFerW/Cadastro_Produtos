package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JToolBar;
import javax.xml.validation.Schema;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Canvas;
import javax.swing.JButton;

public class TelaSaida {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_7;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSaida window = new TelaSaida();
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
	public TelaSaida() {
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
		
		JLabel lblNewLabel_3 = new JLabel("Produtos");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(43, 224, 116, 34);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Entradas");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(43, 269, 116, 34);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Saidas");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3_2.setBounds(43, 314, 116, 34);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Fornecedores");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3_3.setBounds(43, 359, 134, 34);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Marcas");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3_4.setBounds(43, 404, 116, 34);
		panel.add(lblNewLabel_3_4);
		
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
		panel_2.setBounds(244, 186, 695, 195);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Produto 1");
		lblNewLabel_1_2.setBounds(30, 0, 118, 42);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(40, 120, 65));
		panel_3.setBounds(40, 53, 125, 125);
		panel_2.add(panel_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(201, 82, 135, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nome:");
		lblNewLabel_8.setBounds(238, 67, 61, 14);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(346, 53, 1, 118);
		panel_2.add(panel_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(357, 151, 125, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Fornecedor:");
		lblNewLabel_8_2_1.setBounds(377, 137, 82, 14);
		panel_2.add(lblNewLabel_8_2_1);
		lblNewLabel_8_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		textField_4 = new JTextField();
		textField_4.setBounds(357, 107, 125, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8_3 = new JLabel("Categoria:");
		lblNewLabel_8_3.setBounds(380, 53, 61, 14);
		panel_2.add(lblNewLabel_8_3);
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_8_2 = new JLabel("Marca:");
		lblNewLabel_8_2.setBounds(380, 92, 61, 14);
		panel_2.add(lblNewLabel_8_2);
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(357, 67, 125, 20);
		panel_2.add(comboBox);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.BLACK);
		panel_4_1.setBounds(492, 53, 1, 118);
		panel_2.add(panel_4_1);
		
		textField = new JTextField();
		textField.setBounds(201, 131, 135, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantidade:");
		lblNewLabel.setBounds(234, 113, 74, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.setBounds(514, 82, 140, 51);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Saida de produtos");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(244, 132, 253, 43);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(973, 174, 17, 442);
		frame.getContentPane().add(scrollBar);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(244, 431, 695, 195);
		frame.getContentPane().add(panel_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Produto 2");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(30, 0, 118, 42);
		panel_2_1.add(lblNewLabel_1_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(43, 288, 105, 20);
		panel_2_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(201, 82, 135, 20);
		panel_2_1.add(textField_2);
		
		JLabel lblNewLabel_8_1 = new JLabel("Nome:");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8_1.setBounds(238, 67, 61, 14);
		panel_2_1.add(lblNewLabel_8_1);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(Color.BLACK);
		panel_4_2.setBounds(346, 53, 1, 118);
		panel_2_1.add(panel_4_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(357, 151, 125, 20);
		panel_2_1.add(textField_3);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("Fornecedor:");
		lblNewLabel_8_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8_2_1_1.setBounds(377, 137, 82, 14);
		panel_2_1.add(lblNewLabel_8_2_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(357, 107, 125, 20);
		panel_2_1.add(textField_6);
		
		JLabel lblNewLabel_8_3_1 = new JLabel("Categoria:");
		lblNewLabel_8_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8_3_1.setBounds(380, 53, 61, 14);
		panel_2_1.add(lblNewLabel_8_3_1);
		
		JLabel lblNewLabel_8_2_2 = new JLabel("Marca:");
		lblNewLabel_8_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8_2_2.setBounds(380, 92, 61, 14);
		panel_2_1.add(lblNewLabel_8_2_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(357, 67, 125, 20);
		panel_2_1.add(comboBox_1);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBackground(Color.BLACK);
		panel_4_1_1.setBounds(492, 53, 1, 118);
		panel_2_1.add(panel_4_1_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(201, 131, 135, 20);
		panel_2_1.add(textField_8);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(234, 113, 74, 14);
		panel_2_1.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.setBounds(514, 82, 140, 51);
		panel_2_1.add(btnNewButton_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(120, 0, 20));
		panel_3_1.setBounds(40, 53, 125, 125);
		panel_2_1.add(panel_3_1);
		
	}

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

	private void px(Color color) {
		// TODO Auto-generated method stub
		
	}
}
