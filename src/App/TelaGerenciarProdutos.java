package App;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;

public class TelaGerenciarProdutos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciarProdutos window = new TelaGerenciarProdutos();
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
	public TelaGerenciarProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 989, 702);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(322, 0, 651, 663);
		frame.getContentPane().add(panel);
		
		// Exemplo com a imagem dentro da pasta 'src/imagens'
		JLabel lblImagem = new JLabel();
		lblImagem.setBounds(50, 50, 200, 200); // posição e tamanho do JLabel

		// Carregando a imagem
		lblImagem.setIcon(new ImageIcon(getClass().getResource("Sistema.png")));

		// Adiciona o JLabel no painel ou frame
		panel.add(lblImagem);

	}
}
