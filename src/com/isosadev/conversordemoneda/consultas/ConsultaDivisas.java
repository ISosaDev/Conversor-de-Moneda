package com.isosadev.conversordemoneda.consultas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisas {

    public Divisa busquedaDivisa(String base_code, String target_code, double cantidadDeCambio) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/62b2ec3137f69b6fa5bd615a/pair/"
                        +base_code+"/"+target_code+"/"+cantidadDeCambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), Divisa.class);
    }
}
