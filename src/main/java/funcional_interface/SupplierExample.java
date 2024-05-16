package funcional_interface;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {
        // Usa o supplier com expressão lambda para fornecer uma saudação personalizada
        Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";

        // Usa o Supplier para obter uma lista com 5 saudações
        List<String> listaSaudacoes = Stream.generate(saudacao)
                .limit(5)
                .toList();

        // Imprimir as saudações geradas
        listaSaudacoes.forEach(System.out::println);
    }
}
