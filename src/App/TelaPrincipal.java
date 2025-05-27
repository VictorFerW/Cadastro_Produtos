package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.xml.validation.Schema;
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 0, 778, 109);
		panel_1.setBackground(new Color(150, 150, 150));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(245, 228, 195, 175);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerenciar Produtos");
		lblNewLabel.setForeground(new Color(89, 89, 89));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 124, 175, 51);
		panel_2.add(lblNewLabel);
		
		Button button = new Button("Produtos");
		button.setFont(new Font("Arial", Font.BOLD, 13));
		button.setForeground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBackground(new Color(66, 112, 149));
		button.setBounds(29, 97, 137, 36);
		panel_2.add(button);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(510, 228, 195, 175);
		frame.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(769, 228, 195, 175);
		frame.getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);
		
	}

	private void px(Color color) {
		// TODO Auto-generated method stub
		
	}
}
