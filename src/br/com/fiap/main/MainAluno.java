//Ricardo Fernandes de Aquino (RM - 554597)
//Isadora de Morais Meneghetti (RM - 556326)
//Khadija do Rocio Vieira de Lima (RM - 558971)

package br.com.fiap.main;

import br.com.fiap.bean.Aluno;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainAluno {

    public static void main(String[] args) {
        // Formatador para dd/MM/yyyy
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDeNascimento;
        int registroMatricula;
        String nomeCompleto;


            // Aluno 1 - construtor vazio
            Aluno aluno1 = new Aluno();
            aluno1.setRegistroMatricula(554597);
            aluno1.setNomeCompleto("Ricardo Fernandes de Aquino");
            dataDeNascimento = LocalDate.parse("02/08/2004", dtf);
            aluno1.setDataDeNascimento(dataDeNascimento);


            // Aluno 2 - construtor vazio
            Aluno aluno2 = new Aluno();
            aluno2.setRegistroMatricula(558971);
            aluno2.setNomeCompleto("Khadija do Rocio Vieira de Lima");
            dataDeNascimento = LocalDate.parse("08/11/2005", dtf);
            aluno2.setDataDeNascimento(dataDeNascimento);

            // Leitura de dados do usuário
        try {
            // Aluno 3 - construtor com parâmetros
            Aluno aluno3;

            registroMatricula = Integer.parseInt(JOptionPane.showInputDialog("Aluno 3 - Matrícula:"));
            nomeCompleto = JOptionPane.showInputDialog("Aluno 3 - Nome completo:");
            String dataStr3 = JOptionPane.showInputDialog("Aluno 3 - Data de nascimento (dd/MM/yyyy):");
            dataDeNascimento = LocalDate.parse(dataStr3, dtf);

            aluno3 = new Aluno(registroMatricula, dataDeNascimento, nomeCompleto);

            // Aluno 4 - construtor com parâmetros
            Aluno aluno4;

            registroMatricula = Integer.parseInt(JOptionPane.showInputDialog("Aluno 4 - Matrícula:"));
            nomeCompleto = JOptionPane.showInputDialog("Aluno 4 - Nome completo:");
            String dataStr4 = JOptionPane.showInputDialog("Aluno 4 - Data de nascimento (dd/MM/yyyy):");
            dataDeNascimento = LocalDate.parse(dataStr4, dtf);

            aluno4 = new Aluno(registroMatricula, dataDeNascimento, nomeCompleto);


            // Exibição dos dados
            LocalDate hoje = LocalDate.now(); // Armazena a data atual
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
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar Aluno, verifique as informações inseridas.");
            System.exit(0);
        }
    }
}
