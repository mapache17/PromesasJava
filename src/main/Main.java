package main;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import service.Api;
import service.Geolocator;


public class Main {
    public static CompletableFuture<List<String>> getData() {
        // Crear dos CompletableFuture que obtienen datos de la base de datos y la API, respectivamente
        CompletableFuture<List<String>> future1 = Geolocator.getUserLocation();
        CompletableFuture<List<String>> future2 = Api.getMapFromApi();

        // Combinar los resultados de las dos promesas
        return future1.thenCombine(future2, (location, map) -> {
            // Combinar los datos en una lista y devolverlos
            map.addAll(location);
            return map;
        });
    }

    public static void main(String[] args) {

        CompletableFuture<List<String>> future = getData();
        // Esperar a que la promesa se complete y obtener los resultados
        future.thenAccept(data -> {
            // Imprimir los datos
            System.out.println(data);
        });
        System.out.println("Obteniendo ubicación . . .");

        CompletableFuture.allOf(future).join();
    }
}