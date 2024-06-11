import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LeerArchivo {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\Aprendiz\\Downloads\\holamundo.txt";
        int contadorLineas = 0;
        int contadorPalabras = 0;
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contadorLineas++;
                String[] palabras = linea.split("\\s+"); // Separar palabras por espacios en blanco
                contadorPalabras += palabras.length;

                for (String palabra : palabras) {
                    palabra = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Eliminar caracteres no alfabéticos y convertir a minúsculas
                    if (!palabra.isEmpty()) {
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Número de líneas: " + contadorLineas);
        System.out.println("Número de palabras: " + contadorPalabras);

        String palabraMasFrecuente = "";
        int frecuenciaMaxima = 0;

        for (Map.Entry<String, Integer> entrada : frecuenciaPalabras.entrySet()) {
            if (entrada.getValue() > frecuenciaMaxima) {
                palabraMasFrecuente = entrada.getKey();
                frecuenciaMaxima = entrada.getValue();
            }
        }

        System.out.println("La palabra que más se repite es: " + palabraMasFrecuente + " (" + frecuenciaMaxima + " veces)");
    }
}