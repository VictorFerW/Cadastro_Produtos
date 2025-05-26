package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    // Configure aqui os dados do seu banco de dados MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/db_app?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

    private static Connection conn = null;

    // Método para obter a conexão
    public static Connection getConnection() {
        try {
            // Tenta reutilizar a conexão se já estiver aberta e válida
            if (conn == null || conn.isClosed()) {
                // Carrega o driver JDBC (necessário em algumas configurações)
                // Class.forName("com.mysql.cj.jdbc.Driver"); // Descomente se necessário

                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão com o banco de dados estabelecida.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            // Em uma aplicação real, tratar o erro de forma mais robusta (log, mensagem ao usuário)
            // Lançar uma exceção personalizada pode ser uma boa prática
            // throw new RuntimeException("Erro ao conectar ao banco de dados", e);
            conn = null; // Garante que não retornará uma conexão inválida
        } /*catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            conn = null;
        }*/
        return conn;
    }

    // Método para fechar a conexão
    public static void closeConnection() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                    System.out.println("Conexão com o banco de dados fechada.");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
            conn = null; // Define como nulo após fechar
        }
    }

    // Método principal apenas para teste rápido da conexão (opcional)
    public static void main(String[] args) {
        Connection testConn = ConexaoBD.getConnection();
        if (testConn != null) {
            System.out.println("Teste de conexão bem-sucedido!");
            ConexaoBD.closeConnection();
        } else {
            System.out.println("Falha no teste de conexão.");
        }
    }
}

