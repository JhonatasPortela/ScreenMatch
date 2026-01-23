package br.app.portela.screenmatch.modelos;

import br.app.portela.screenmatch.exceptions.ErroAnoInvalido;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private double somaDasAvaliacoes;
    private boolean incluidoNoPlano;
    private int totalDeAvaliacoes;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        if(tituloOmdb.year().length() > 4){
            throw new ErroAnoInvalido("Erro ao converter o ano: " + tituloOmdb.year());
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
       // String apenasNumeros = tituloOmdb.runtime().replaceAll("\\D", "");
       // if (apenasNumeros.isEmpty()) {
       //     this.duracaoEmMinutos = 0;
       // } else {
       //     this.duracaoEmMinutos = Integer.valueOf(apenasNumeros);
       // }
       // this.duracaoEmMinutos =Integer.valueOf(tituloOmdb.runtime().replaceAll("\\D", ""));
        this.duracaoEmMinutos =
                Integer.valueOf(tituloOmdb.runtime().substring(0,3));
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void exibeFixaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }


    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(Titulo: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")" + " - " + this.getDuracaoEmMinutos() + " min )";
    }
}
