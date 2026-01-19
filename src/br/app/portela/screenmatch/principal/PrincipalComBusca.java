package br.app.portela.screenmatch.principal;

import br.app.portela.screenmatch.exceptions.ErroAnoInvalido;
import br.app.portela.screenmatch.modelos.Titulo;
import br.app.portela.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o título da busca:");
        var busca = scanner.nextLine();
        String url = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") +
                "&apikey" +
                "=92a14529";
        try {


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(tituloOmdb);


            Titulo titulo = new Titulo(tituloOmdb);
            System.out.println("Titulo convertido:");
            System.out.println(titulo);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter o título: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no argumento da busca : " + e.getMessage());
        } catch (ErroAnoInvalido e) {
            System.out.println( e.getMessage());
        } finally {
            System.out.println("Busca concluída.");
        }
    }
}
