package br.com.jotaportela.screenmatch.modelos;

import br.com.jotaportela.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private Serie serie;
    private String nome;
    private int totalDeVisualizacoes;

    public int getTotalDeVisualizacoes() {
        return totalDeVisualizacoes;
    }

    public void setTotalDeVisualizacoes(int totalDeVisualizacoes) {
        this.totalDeVisualizacoes = totalDeVisualizacoes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public int getClassificacao() {
         if (totalDeVisualizacoes > 100){
             return 4;
         } else if (totalDeVisualizacoes > 30){
             return 2;
         } else {
             return 1;
         }
    }
}
