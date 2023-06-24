package br.Inatel.Model;

import br.Inatel.DAO.ConnectionDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Medico extends ConnectionDAO {
    private long CRM;
    private String Nome;
    private int Idade;
    private float Salario;
    private Especialidades Especialidade;
    private final ArrayList<Paciente> Pacientes = new ArrayList<>();

    public Medico(String nome, int idade, float salario, long crm,  Especialidades especialidade) {
        Nome = nome;
        Idade = idade;
        Salario = salario;
        Especialidade = especialidade;
        CRM = crm;
        insertMedic();
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        this.Idade = idade;
    }

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float salario) {
        this.Salario = salario;
    }

    public Especialidades getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(Especialidades especialidade) {
        this.Especialidade = especialidade;
    }

    public void DischargePacient(Paciente pac) {
        for (int i = 0; i < Pacientes.size(); i++) {
            if (Pacientes.get(i).equals(pac)) {
                Pacientes.remove(pac);
            }
        }
    }

    public ArrayList<Paciente> getPacientes() {
        return Pacientes;
    }

    public boolean insertMedic()
    {
        connectToDB();

        String sql = "INSERT INTO medico (CRM,nome,idade,salario,Especialidade,Hospital_Endereco) values(?,?,?,?,?,?)";
        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(CRM));
            pst.setString(2, Nome);
            pst.setString(3, String.valueOf(Idade));
            pst.setString(4, String.valueOf(Salario));
            pst.setString(5, String.valueOf(Arrays.stream(Especialidades.values()).toList().indexOf(Especialidade)));
            pst.setString(6, Main.Hospital.Endereco);
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
}
