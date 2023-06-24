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
        }
        //adicionar menu switch