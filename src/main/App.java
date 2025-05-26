package main; // Ou o pacote onde você criou a classe App

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import App.TelaPrincipal; // Importa a sua tela principal

public class App {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Erro ao definir o Look and Feel: " + e.getMessage());
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}
