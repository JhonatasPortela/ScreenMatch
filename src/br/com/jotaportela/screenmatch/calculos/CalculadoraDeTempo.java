package br.com.jotaportela.screenmatch.calculos;

import br.com.jotaportela.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo titulo){
        System.out.println("Adicionado duração do título: " + titulo.getNome());
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
