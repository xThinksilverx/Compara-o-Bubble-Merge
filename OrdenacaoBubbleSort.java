import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Predio {
    String nome;
    int distanciaDoCentro;

    public Predio(String nome, int distancia) {
        this.nome = nome;
        this.distanciaDoCentro = distancia;
    }
}

public class OrdenacaoBubbleSort {
    
    public static void bubbleSort(List<Predio> predios) {
        int n = predios.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (predios.get(j).distanciaDoCentro > predios.get(j + 1).distanciaDoCentro) {
                    Collections.swap(predios, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de prédios para ordenar com Bubble Sort: ");
        int numeroDePredios = scanner.nextInt();

        List<Predio> predios = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < numeroDePredios; i++) {
            predios.add(new Predio("Predio_" + i, random.nextInt(1000)));
        }

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long inicio = System.currentTimeMillis();
        bubbleSort(predios);
        long tempoBubbleSort = System.currentTimeMillis() - inicio;

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        System.out.println("Tempo do Bubble Sort: " + tempoBubbleSort + " ms");
        System.out.println("Memória utilizada pelo Bubble Sort: " + memoriaUsada + " bytes");

        scanner.close();
    }
}
