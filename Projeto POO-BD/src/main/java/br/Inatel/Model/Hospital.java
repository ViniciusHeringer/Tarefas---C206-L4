package br.Inatel.Model;

import br.Inatel.DAO.ConnectionDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Hospital extends ConnectionDAO {
    ArrayList<Paciente> pacientes = new ArrayList<>();
    ArrayList<Medico> medicos = new ArrayList<>();
    public final String Endereco;

    public Hospital(String endereco)
    {
        Endereco = endereco;
        insertEndereco();
    }

    public boolean insertEndereco()
    {
        connectToDB();

        String sql = "INSERT INTO hospital (Endereco) values(?)";
        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, Endereco);;
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
        return sucesso;
    }

    public void RegisterMedic(String nome, int idade, float salario, long CRM, Especialidades especialidade) {
        medicos.add(new Medico(nome, idade, salario, CRM, especialidade));
    }
    public void RegisterPatient() {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) == null) {
                pacientes.add(i, new Paciente());
                return;
            }
        }
        pacientes.add(new Paciente());
    }
}