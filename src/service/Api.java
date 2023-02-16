package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Api {
    public static CompletableFuture<List<String>> getMapFromApi() {
        return CompletableFuture.supplyAsync(() -> {
            // Llamar a la API y esperar un tiempo aleatorio para simular la latencia
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1500 + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Obtener vasta de mapa de la API
            List<String> map = new ArrayList<>();
            map.add("vista satelital");
            map.add("vista de mapa");
            return map;
        });
    }
}
