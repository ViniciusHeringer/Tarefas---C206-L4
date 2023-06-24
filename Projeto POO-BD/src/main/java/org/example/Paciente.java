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
    public Paciente() {
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
    }