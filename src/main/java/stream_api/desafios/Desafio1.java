package stream_api.desafios;


import java.util.Arrays;


/** MOSTRE A LISTA NA ORDEM NÚMERICA
 *  Utilize a Stream Api para ordenar a lista de números em ordem crescente e a exiba no console.
 */
public class Desafio1 {

    // Chamando o método de números a ser ordenado
    static int[] numeroCrescente = {1,5,10,22,35,2,3,4};

    // Método para ordenar os números
    // private static void ordenarNumeros(int[] numeroCrescente) {
    // Arrays.sort(numeroCrescente);
    //    }

    // Método usando Stream Api para ordenar numeros crescente
    public void ordenarNumeros(int[]numeroCrescente){
        Arrays.stream(numeroCrescente)
                .sorted()
                .forEach(num -> System.out.print(num + " "));
    }
    public static void main(String[] args) {

        Desafio1 desafio1 = new Desafio1();

         // Chamando o método para ordenar o Array
         desafio1.ordenarNumeros(numeroCrescente);

//         // Imprima os números ordenados
//         for (int num : numeroCrescente){
//             System.out.print(num + "-");
        }
    }

