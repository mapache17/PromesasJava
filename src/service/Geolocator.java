package service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Geolocator {
    public static CompletableFuture<List<String>> getUserLocation() {
        return CompletableFuture.supplyAsync(() -> {
            //Simular latencia
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1500 + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Obtener ubicación del usuario
            double latitude = Math.random() * 180 - 90;
            double longitude = Math.random() * 360 - 180;
            
            List<String> location = new ArrayList<>();
            location.add("Latitud: "+String.valueOf(latitude));
            location.add("Longitud: "+String.valueOf(longitude));
            return location;
        });
    }
}