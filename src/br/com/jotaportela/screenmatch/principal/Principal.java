package br.com.jotaportela.screenmatch.principal;

import br.com.jotaportela.screenmatch.calculos.CalculadoraDeTempo;
import br.com.jotaportela.screenmatch.calculos.FiltroRecomendacao;
import br.com.jotaportela.screenmatch.modelos.Episodio;
import br.com.jotaportela.screenmatch.modelos.Filme;
import br.com.jotaportela.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Superman", 2025);
        meuFilme.setDuracaoEmMinutos(143);

        meuFilme.avalia(10);
        meuFilme.avalia(9.1);
        meuFilme.avalia(6.7);

        Filme outroFilme = new Filme("Besouro azul", 2023);
        outroFilme.setDuracaoEmMinutos(180);

        var filme3 = new Filme("Esquadrão suicida 2", 2021);
        filme3.setDuracaoEmMinutos(200);

        meuFilme.exibeFixaTecnica();
        System.out.println("Avaliação média: " + meuFilme.pegaMedia());
        System.out.println("Quantidade de avaliações: " + meuFilme.getTotalDeAvaliacoes());

        Serie theWalkingDead = new Serie("The walking dead", 2010);
        theWalkingDead.setAtiva(false);
        theWalkingDead.setTemporadas(10);
        theWalkingDead.setEpisodiosPorTemporada(10);
        theWalkingDead.setMinutosPorEpisodio(50);

        theWalkingDead.exibeFixaTecnica();
        System.out.println(theWalkingDead.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(theWalkingDead);
        System.out.println(calculadora.getTempoTotal());

        Episodio ep1 = new Episodio();
        ep1.setNumero(1);
        ep1.setSerie(theWalkingDead);
        ep1.setTotalDeVisualizacoes(20);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        filtro.filtra(ep1);

        var listaDeFilmes = new ArrayList<Filme>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(filme3);
        System.out.println(listaDeFilmes.size());
        System.out.println("Filmes: " + listaDeFilmes);

        var listaDeSeries = new ArrayList<Serie>();
        listaDeSeries.add(theWalkingDead);
        System.out.println(listaDeSeries);

    }
}
