package br.app.portela.screenmatch.principal;
import br.app.portela.screenmatch.modelos.Filme;
import br.app.portela.screenmatch.modelos.Serie;
import br.app.portela.screenmatch.modelos.Titulo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Superman", 2025);
        meuFilme.avalia(10);
        Filme outroFilme = new Filme("Besouro azul", 2023);
        outroFilme.avalia(8.5);
        Filme filme3 = new Filme("Esquadrão suicida 2", 2021);
        filme3.avalia(7.8);
        Serie theWalkingDead = new Serie("The walking dead", 2010);
        theWalkingDead.avalia(9.5);
        theWalkingDead.setAtiva(true);

        var lista = new ArrayList<Titulo>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(filme3);
        lista.add(theWalkingDead);
        System.out.println(lista.size());
        System.out.println( lista);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            } else if (item instanceof Serie serie && serie.isAtiva()) {
                System.out.println("Série ativa");
            }
        }

        var listaNomes = new ArrayList<String>();
        listaNomes.add("Zeus");
        listaNomes.add("Luiza");
        listaNomes.add("Jhonatas");
        listaNomes.add("Sofia");

        Collections.sort(listaNomes);
        System.out.println("Lista de nomes ordenada:");
        System.out.println(listaNomes);

        Collections.sort(lista);
        System.out.println("Lista de títulos ordenada:");
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Lista de títulos ordenada por ano de lançamento:");
        System.out.println(lista);
    }
}
