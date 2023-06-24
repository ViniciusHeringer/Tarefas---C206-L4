package br.Inatel.Model;

import br.Inatel.DAO.ConnectionDAO;
import java.sql.SQLException;
import java.util.Scanner;

public class Paciente extends ConnectionDAO {

    private String nome;
    private String cpf;
    private int idade;
    private boolean temPlano;
    private Medico Medico;
    public Paciente()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        nome = scanner.nextLine();

        System.out.print("CPF: ");
        cpf = scanner.nextLine();

        System.out.print("Idade: ");
        idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tem Plano: ");
        temPlano = scanner.nextBoolean();
        scanner.nextLine();

        while (true) {
            System.out.println("Qual especialista o paciente gostaria de consultar?");
            System.out.println("1- Cardiologista");
            System.out.println("2- Oncologista");
            System.out.println("3- Oftalmologista");

            int input = scanner.nextInt();
            if (input > Especialidades.values().length) {
                throw new InvalidOptionException("Opcao Invalida!");
            }

            Especialidades esp = Especialidades.values()[input - 1];
            for (Medico medico : Main.Hospital.medicos) {
                if (medico.getEspecialidade() == esp) {
                    Medico = medico;
                    medico.getPacientes().add(this);
                    break;
                }
            }
            if (Medico != null) {
                break;
            }
            System.out.println("Nenhum medico com a especialidade selecionada disponível!");
        }
        insertPatient();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isTemPlano() {
        return temPlano;
    }

    public void setTemPlano(boolean temPlano) {
        this.temPlano = temPlano;
    }

    public Medico getMedico() {
        return Medico;
    }

    public boolean insertPatient() {
        connectToDB();

        String sql = "INSERT INTO paciente (cpf,nome,idade,temPlano) values(?,?,?,?)";
        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.setString(2, nome);
            pst.setInt(3, idade);
            pst.setBoolean(4, temPlano);
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

    public static boolean deletePatient(String cpf)
    {
        ConnectionDAO connection = new ConnectionDAO();
        connection.connectToDB();
        String sql = "DELETE FROM paciente where cpf=?";
        try
        {
            connection.pst = connection.con.prepareStatement(sql);
            connection.pst.setString(1, cpf);
            connection.pst.execute();
            connection.sucesso = true;
        } catch (SQLException ex)
        {
            System.out.println("Erro = " + ex.getMessage());
            connection.sucesso = false;
        }
        finally
        {
            try
            {
                connection.con.close();
                connection.pst.close();
            }
            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return connection.sucesso;
    }

    //UPDATE
    public static boolean updatePatient(String cpf)
    {
        ConnectionDAO connection = new ConnectionDAO();
        connection.connectToDB();

        Scanner scanner = new Scanner(System.in);


        String sql = "UPDATE paciente SET nome=?, idade=?, temPlano=? where cpf=?";
        try
        {
            connection.pst = connection.con.prepareStatement(sql);

            System.out.print("Nome: ");
            connection.pst.setString(1, scanner.nextLine());

            System.out.print("Idade: ");
            connection.pst.setInt(2, scanner.nextInt());
            scanner.nextLine();

            System.out.print("Tem Plano: ");
            connection.pst.setBoolean(3, scanner.nextBoolean());
            scanner.nextLine();

            connection.pst.setString(4, cpf);
            connection.pst.execute();
            connection.sucesso = true;
        }
        catch (SQLException ex)
        {
            System.out.println("Erro = " + ex.getMessage());
            connection.sucesso = false;
        }
        finally
        {
            try
            {
                connection.con.close();
                connection.pst.close();
            }
            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return connection.sucesso;
    }

    public static void selectPatients()
    {
        ConnectionDAO connection = new ConnectionDAO();
        connection.connectToDB();

        String sql = "SELECT * FROM paciente";

        try
        {
            connection.st = connection.con.createStatement();
            connection.rs = connection.st.executeQuery(sql);

            System.out.println("Lista de pacientes: ");

            while (connection.rs.next())
            {
                System.out.println("CPF: " + connection.rs.getString("cpf"));
                System.out.println("Nome: " + connection.rs.getString("nome"));
                System.out.println("Idade: " + connection.rs.getInt("idade"));
                System.out.println("Tem Plano: " + connection.rs.getBoolean("temPlano") + "\n");
            }
            connection.sucesso = true;
        } catch (SQLException e)
        {
            System.out.println("Erro: " + e.getMessage());
            connection.sucesso = false;
        } finally {
            try {
                connection.con.close();
                connection.st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}

