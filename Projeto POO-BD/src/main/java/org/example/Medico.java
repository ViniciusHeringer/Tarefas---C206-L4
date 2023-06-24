package org.example;

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
