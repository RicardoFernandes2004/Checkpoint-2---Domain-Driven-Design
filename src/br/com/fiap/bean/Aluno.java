package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;


public class Aluno {
    private int registroMatricula;
    private String nomeCompleto;
    private LocalDate dataDeNascimento;

    public Aluno(){}

    public Aluno(int registroMatricula, LocalDate dataDeNascimento, String nomeCompleto) throws Exception {
        setRegistroMatricula(registroMatricula);
        setDataDeNascimento(dataDeNascimento);
        this.nomeCompleto = nomeCompleto;
    }

    public int getRegistroMatricula() {
        return registroMatricula;
    }

    public void setRegistroMatricula(int registroMatricula){
        try {
            if (registroMatricula >= 80000 && registroMatricula <= 599999) {
                this.registroMatricula = registroMatricula;
            } else {
                throw new Exception("Registro de matrícula inválido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.exit(0);
        }

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento){
    LocalDate dataAtual = LocalDate.now();
    LocalDate dataLimite = LocalDate.parse("1960-01-01");
    try {
        if ((dataDeNascimento.isAfter(dataLimite) || dataDeNascimento.isEqual(dataLimite)) && (dataDeNascimento.isBefore(dataAtual) || dataDeNascimento.isEqual(dataAtual))){
            this.dataDeNascimento = dataDeNascimento;
        }else {
            throw new Exception("Data de nascimento inválida");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.getMessage());
    }

    }
    public String calcularIdadeCompleta(LocalDate dataAtual) {
        Period periodo = Period.between(dataDeNascimento, dataAtual);

        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();

        String textoAnos = anos + " " + (anos == 1 ? "ano" : "anos");
        String textoMeses = meses + " " + (meses == 1 ? "mês" : "meses");
        String textoDias = dias + " " + (dias == 1 ? "dia" : "dias");

        return textoAnos + ", " + textoMeses + " e " + textoDias;
    }


}
