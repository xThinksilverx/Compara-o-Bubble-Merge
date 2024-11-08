import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Edificio {
    String nome;
    int distanciaDoCentro;

    public Edificio(String nome, int distancia) {
        this.nome = nome;
        this.distanciaDoCentro = distancia;
    }
}

public class OrdenacaoMergeSort {

    public static List<Edificio> mergeSort(List<Edificio> edificios) {
        if (edificios.size() <= 1) {
            return edificios;
        }
        
        int meio = edificios.size() / 2;
        List<Edificio> esquerda = mergeSort(new ArrayList<>(edificios.subList(0, meio)));
        List<Edificio> direita = mergeSort(new ArrayList<>(edificios.subList(meio, edificios.size())));
        
        return merge(esquerda, direita);
    }

    private static List<Edificio> merge(List<Edificio> esquerda, List<Edificio> direita) {
        List<Edificio> listaOrdenada = new ArrayList<>();
        int i = 0, j = 0;

        while (i < esquerda.size() && j < direita.size()) {
            if (esquerda.get(i).distanciaDoCentro <= direita.get(j).distanciaDoCentro) {
                listaOrdenada.add(esquerda.get(i++));
            } else {
                listaOrdenada.add(direita.get(j++));
            }
        }
        
        listaOrdenada.addAll(esquerda.subList(i, esquerda.size()));
        listaOrdenada.addAll(direita.subList(j, direita.size()));
        
        return listaOrdenada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de edifícios para ordenar com Merge Sort: ");
        int numeroDeEdificios = scanner.nextInt();

        List<Edificio> edificios = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < numeroDeEdificios; i++) {
            edificios.add(new Edificio("Edificio_" + i, random.nextInt(1000)));
        }

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long inicio = System.currentTimeMillis();
        List<Edificio> edificiosOrdenados = mergeSort(edificios);
        long tempoMergeSort = System.currentTimeMillis() - inicio;

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        System.out.println("Tempo do Merge Sort: " + tempoMergeSort + " ms");
        System.out.println("Memória utilizada pelo Merge Sort: " + memoriaUsada + " bytes");

        scanner.close();
    }
}
