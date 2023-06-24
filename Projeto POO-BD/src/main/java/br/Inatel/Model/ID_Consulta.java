package br.Inatel.Model;

import br.Inatel.DAO.ConnectionDAO;
import java.sql.SQLException;

public class ID_Consulta extends ConnectionDAO
{
    static int counter = 0;
    private final int id = ++counter;

    static void Init() {
        ConnectionDAO connection = new ConnectionDAO();
        connection.connectToDB();
        String sql = "SELECT * FROM ID_Consulta ORDER BY ID DESC LIMIT 1";

        try {
            connection.st = connection.con.createStatement();
            connection.rs = connection.st.executeQuery(sql);
            counter = connection.rs.getInt("id");
            connection.sucesso = true;
        } catch (SQLException e) {
            counter = 0;
            connection.sucesso = false;
        }
    }

    ID_Consulta()
    {
        connectToDB();
        String sql = "INSERT INTO ID_Consulta (id) values(?)";
        try
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        }
        catch (SQLException exc)
        {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        }
        finally
        {
            try
            {
                con.close();
                pst.close();
            }
            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }
}
