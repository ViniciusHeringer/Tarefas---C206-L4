package br.Inatel.Model;

import java.util.Scanner;

public class Main {
    public static Hospital Hospital = new Hospital("Minha Casa");
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ID_Consulta.Init();

        //Instanciando médicos
        Hospital.RegisterMedic("Marcelo Joaquim", 38, 4500, 491105, Especialidades.Oncologista);
        Hospital.RegisterMedic("Joao Resende", 42, 6550, 12346, Especialidades.Cardiologista);
        Hospital.RegisterMedic("Lucas Botello", 55, 7200, 12347, Especialidades.Oftalmologista);

        int option;
        do {
            exibirMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (option) {
                case 1:
                    Hospital.RegisterPatient();
                    System.out.println("<<<< Paciente registrado com sucesso >>>>");
                    break;

                case 2:
                    System.out.print("Digite o CPF do paciente a ser apagado do sistema: "); //mudar para cpf (chave primaria)
                    Paciente.deletePatient(scanner.nextLine());
                    break;

                case 3:
                    System.out.print("Digite o CPF do paciente a ser modificado no sistema: "); //mudar para cpf (chave primaria)
                    Paciente.updatePatient(scanner.nextLine());
                    break;

                case 4:
                    System.out.println("==== PACIENTES REGISTRADOS ====");
                    Paciente.selectPatients();
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 0);
    }

    public static void exibirMenu() {
        System.out.println("\n==== Bem-Vindo ao Hospital Nova Esperança! ====\n");
        System.out.println("1) Salvar informações do paciente no sistema"); //INSERT
        System.out.println("2) Remover paciente do sistema"); //DELETE
        System.out.println("3) Modificar dados de um paciente"); //UPDATE
        System.out.println("4) Mostrar Dados Registrados");
        System.out.println("0) Sair");
        System.out.print("Escolha uma opção: ");
    }
}