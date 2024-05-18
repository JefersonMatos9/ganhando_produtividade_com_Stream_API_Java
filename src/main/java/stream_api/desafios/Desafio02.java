package stream_api.desafios;

import java.util.Arrays;

/**
 * IMPRIMA A SOMA DOS NÚMEROS PARES DA LISTA
 * Utilizando o Stream API, realize a soma dos números pares da lista e exiba o resultado no console.
 */
public class Desafio02 {
    // Array com números
    int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Método para imprimir números pares
    //    public void numerosPares() {
    //        for (int num : numeros) {
    //            if ((num % 2) == 0) {
    //                System.out.print(num + " ");
    //            }
    //        }
    //    }

    // Método para imprimir números pares usando Stream API
    public void numerosPares(){
        Arrays.stream(numeros) // Cria um stream a partir do array
                .filter(num -> num % 2 == 0) // Filtra o números pares
                .forEach(num -> System.out.print(num + " ")); // Imprime cada número par
    }
    public static void main(String[] args) {

        // Instanciando a classe
        Desafio02 desafio02 = new Desafio02();

        // Chamando o método
        desafio02.numerosPares();
    }
}

