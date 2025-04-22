package br.com.fiap.main;

import br.com.fiap.bean.Aluno;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainAluno {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDeNascimento;
        int registroMatricula;
        String nomeCompleto;

        try {
            // Aluno 1 - construtor vazio
            Aluno aluno1 = new Aluno();
            registroMatricula = Integer.parseInt(JOptionPane.showInputDialog("Aluno 1 - Matrícula:"));
            aluno1.setRegistroMatricula(registroMatricula);

            nomeCompleto = JOptionPane.showInputDialog("Aluno 1 - Nome completo:");
            aluno1.setNomeCompleto(nomeCompleto);

            try {
                String dataStr = JOptionPane.showInputDialog("Aluno 1 - Data de nascimento (dd/MM/yyyy):");
                dataDeNascimento = LocalDate.parse(dataStr, dtf);
                aluno1.setDataDeNascimento(dataDeNascimento);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data inválida para Aluno 1.");
                System.exit(0);
            }

            // Aluno 2 - construtor vazio
            Aluno aluno2 = new Aluno();
            registroMatricula = Integer.parseInt(JOptionPane.showInputDialog("Aluno 2 - Matrícula:"));
            aluno2.setRegistroMatricula(registroMatricula);

            nomeCompleto = JOptionPane.showInputDialog("Aluno 2 - Nome completo:");
            aluno2.setNomeCompleto(nomeCompleto);

            try {
                String dataStr = JOptionPane.showInputDialog("Aluno 2 - Data de nascimento (dd/MM/yyyy):");
                dataDeNascimento = LocalDate.parse(dataStr, dtf);
                aluno2.setDataDeNascimento(dataDeNascimento);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data inválida para Aluno 2.");
                System.exit(0);
            }

            // Aluno 3 - construtor com parâmetros
            Aluno aluno3;
            try {
                registroMatricula = Integer.parseInt(JOptionPane.showInputDialog("Aluno 3 - Matrícula:"));
                nomeCompleto = JOptionPane.showInputDialog("Aluno 3 - Nome completo:");
                String dataStr = JOptionPane.showInputDialog("Aluno 3 - Data de nascimento (dd/MM/yyyy):");
                dataDeNascimento = LocalDate.parse(dataStr, dtf);

                aluno3 = new Aluno(registroMatricula, dataDeNascimento, nomeCompleto);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Aluno 3: " + e.getMessage());
                return;
            }

            // Aluno 4 - construtor com parâmetros
            Aluno aluno4;
            try {
                registroMatricula = Integer.parseInt(JOptionPane.showInputDialog("Aluno 4 - Matrícula:"));
                nomeCompleto = JOptionPane.showInputDialog("Aluno 4 - Nome completo:");
                String dataStr = JOptionPane.showInputDialog("Aluno 4 - Data de nascimento (dd/MM/yyyy):");
                dataDeNascimento = LocalDate.parse(dataStr, dtf);

                aluno4 = new Aluno(registroMatricula, dataDeNascimento, nomeCompleto);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Aluno 4: " + e.getMessage());
                return;
            }

            // Exibição dos dados com String.format
            LocalDate hoje = LocalDate.now();
            String resultado = String.format(
                    "=== Alunos Cadastrados ===\n\n" +
                            "Aluno 1:\nMatrícula: %d\nNome: %s\nIdade: %s\n\n" +
                            "Aluno 2:\nMatrícula: %d\nNome: %s\nIdade: %s\n\n" +
                            "Aluno 3:\nMatrícula: %d\nNome: %s\nIdade: %s\n\n" +
                            "Aluno 4:\nMatrícula: %d\nNome: %s\nIdade: %s\n",
                    aluno1.getRegistroMatricula(), aluno1.getNomeCompleto(), aluno1.calcularIdadeCompleta(hoje),
                    aluno2.getRegistroMatricula(), aluno2.getNomeCompleto(), aluno2.calcularIdadeCompleta(hoje),
                    aluno3.getRegistroMatricula(), aluno3.getNomeCompleto(), aluno3.calcularIdadeCompleta(hoje),
                    aluno4.getRegistroMatricula(), aluno4.getNomeCompleto(), aluno4.calcularIdadeCompleta(hoje)
            );

            JOptionPane.showMessageDialog(null, resultado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        }
    }
}
