package br.com.jotaportela.screenmatch.principal;

import br.com.jotaportela.screenmatch.modelos.Filme;
import br.com.jotaportela.screenmatch.modelos.Serie;
import br.com.jotaportela.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        var filme1 = new Filme("Superman", 2025);
        filme1.avalia(10);
        var filme2 = new Filme("Besouro azul", 2023);
        filme2.avalia(3.5);
        var filme3 = new Filme("Esquadrão suicida 2", 2021);
        filme3.avalia(9.2);
        var serie = new Serie("The walking dead", 2010);

        var listaDeFilmes = new ArrayList<Titulo>();
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        listaDeFilmes.add(serie);

        for(var titulo : listaDeFilmes) {
            System.out.println(titulo.getNome());
            if (titulo instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Avaliação   : " + filme.getClassificacao());
            }
        }
    }
}
