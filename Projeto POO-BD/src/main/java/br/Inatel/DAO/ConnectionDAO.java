package br.Inatel.DAO;

import java.sql.*;

public class ConnectionDAO
{

    public Connection con; //conexão
    public PreparedStatement pst; // declaração(query) preparada - código em sql
    public Statement st; //declaração(query) - código em sql
    public ResultSet rs; //resposta do banco
    public boolean sucesso = false;

    String database = "mydb";//nome do BD
    String user = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    public void connectToDB()
    {
        try
        {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao deu certo!");
        }
        catch(SQLException exc)
        {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}