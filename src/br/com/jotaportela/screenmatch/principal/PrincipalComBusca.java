package br.com.jotaportela.screenmatch.principal;

import br.com.jotaportela.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

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
        String url = "http://www.omdbapi.com/?t=" + busca + "&apikey=92a14529";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        Titulo titulo = gson.fromJson(json, Titulo.class);
        System.out.println(titulo);
    }
}
