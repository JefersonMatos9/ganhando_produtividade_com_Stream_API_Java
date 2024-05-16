Claro! Vou formatar o texto para que fique bonito e bem organizado no README do GitHub.

---

# Ganhando Produtividade com Stream API e Java

A Stream API traz uma nova opção para a manipulação de coleções em Java seguindo os princípios da programação funcional. Trata-se de uma poderosa solução para processar coleções de maneira declarativa, ao invés da tradicional e burocrática forma imperativa.

## Exemplo de Uso sem Stream API

```java
public class CarrinhoDeCompras {
  // Atributos
  private List<Item> itemList;

  // Construtor
  public CarrinhoDeCompras() {
    this.itemList = new ArrayList<>();
  }

  // Método para calcular valor total dos itens sem utilizar o Stream API
  public double calcularValorTotal() {
    double valorTotal = 0d;
    if (!itemList.isEmpty()) {
      for (Item item : itemList) {
        double valorItem = item.getPreco() * item.getQuant();
        valorTotal += valorItem;
      }
      return valorTotal;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }
}
```

Na forma imperativa, o desenvolvedor precisa se preocupar não apenas com o que deve ser feito em cada elemento, mas também com a maneira de realizar essa iteração.

## Exemplo de Uso com Stream API

```java
public class CarrinhoDeCompras {
  // Atributos
  private List<Item> itemList;

  // Construtor
  public CarrinhoDeCompras() {
    this.itemList = new ArrayList<>();
  }

  // Método para calcular valor total dos itens utilizando o Stream API
  public double calcularValorTotal() {
    if (itemList.isEmpty()) {
      throw new RuntimeException("A lista está vazia!");
    }
    return itemList.stream()
        .mapToDouble(item -> item.getPreco() * item.getQuant())
        .sum();
  }
}
```

Combinada com expressões lambda e method references, a Stream API proporciona uma forma simples e concisa de lidar com conjuntos de elementos, resultando em facilidade de manutenção e paralelização sem efeitos indesejados em tempo de execução.

## Operações na Stream API

### Operações Intermediárias

- **filter(Predicate<T> predicate)**: Filtra os elementos da Stream com base em um predicado. Retorna uma nova Stream contendo apenas os elementos que atendem ao critério do predicado.
  ```java
  stream.filter(n -> n > 5)
  ```
- **map(Function<T, R> mapper)**: Transforma cada elemento da Stream usando a função especificada e retorna uma nova Stream contendo os elementos resultantes.
  ```java
  stream.map(s -> s.toUpperCase())
  ```
- **sorted()**: Classifica os elementos da Stream em ordem natural (se os elementos forem comparáveis) ou de acordo com um comparador fornecido.
  ```java
  stream.sorted()
  ```
- **distinct()**: Remove elementos duplicados da Stream, considerando a implementação do método equals() para comparação.
  ```java
  stream.distinct()
  ```
- **limit(long maxSize)**: Limita o número de elementos da Stream aos maxSize primeiros elementos.
  ```java
  stream.limit(10)
  ```
- **skip(long n)**: Pula os primeiros n elementos da Stream e retorna uma nova Stream sem eles.
  ```java
  stream.skip(5)
  ```

### Operações Terminais

- **forEach(Consumer<T> action)**: Executa uma ação para cada elemento da Stream.
  ```java
  stream.forEach(System.out::println)
  ```
- **toArray()**: Converte a Stream em um array contendo os elementos da Stream.
  ```java
  stream.toArray()
  ```
- **collect(Collector<T, A, R> collector)**: Coleta os elementos da Stream em uma estrutura de dados específica, como uma lista ou um mapa.
  ```java
  stream.collect(Collectors.toList())
  ```
- **count()**: Retorna o número de elementos na Stream.
  ```java
  stream.count()
  ```
- **anyMatch(Predicate<T> predicate)**: Verifica se algum elemento da Stream atende ao predicado especificado.
  ```java
  stream.anyMatch(s -> s.startsWith("A"))
  ```
- **allMatch(Predicate<T> predicate)**: Verifica se todos os elementos da Stream atendem ao predicado especificado.
  ```java
  stream.allMatch(n -> n > 0)
  ```
- **noneMatch(Predicate<T> predicate)**: Verifica se nenhum elemento da Stream atende ao predicado especificado.
  ```java
  stream.noneMatch(s -> s.isEmpty())
  ```
- **min(Comparator<T> comparator)** e **max(Comparator<T> comparator)**: Encontra o elemento mínimo e máximo da Stream, respectivamente, de acordo com o comparador fornecido.
  ```java
  stream.min(Comparator.naturalOrder())
  stream.max(Comparator.naturalOrder())
  ```
- **reduce(T identity, BinaryOperator<T> accumulator)**: Combina os elementos da Stream usando o acumulador especificado e retorna o resultado final.
  ```java
  stream.reduce(0, (a, b) -> a + b)
  ```

## Lambda

As expressões lambda permitem representar interfaces funcionais (interfaces com um único método abstrato) de forma mais concisa e possibilitam escrever código no estilo funcional. As interfaces funcionais desempenham um papel crucial na programação funcional em Java, pois servem de base para o uso de expressões lambda. Uma função lambda é uma função sem declaração, isto é, não é necessário colocar um nome, um tipo de retorno e o modificador de acesso. A ideia é que o método seja declarado no mesmo lugar em que será usado.

As funções lambda em Java têm a sintaxe definida como `(argumento) -> (corpo)`.

## Exemplo de Ordenação com Lambda

```java
public class OrdenacaoPessoa {
  // Atributo
  private List<Pessoa> pessoaList;

  // Construtor
  public OrdenacaoPessoa() {
    this.pessoaList = new ArrayList<>();
  }

  public List<Pessoa> ordenarPorAltura() {
    if (!pessoaList.isEmpty()) {
      List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
      pessoasPorAltura.sort((p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura()));
      return pessoasPorAltura;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }
}
```

## Method Reference

Method Reference é um recurso do Java 8 que permite fazer referência a um método ou construtor de uma classe (de forma funcional) e assim indicar que ele deve ser utilizado num ponto específico do código, deixando-o mais simples e legível. Para utilizá-lo, basta informar uma classe ou referência seguida do símbolo `::` e o nome do método sem os parênteses no final.

## Exemplo de Ordenação com Method Reference

```java
public class OrdenacaoPessoa {
  // Atributo
  private List<Pessoa> pessoaList;

  // Construtor
  public OrdenacaoPessoa() {
    this.pessoaList = new ArrayList<>();
  }

  public List<Pessoa> ordenarPorAltura() {
    if (!pessoaList.isEmpty()) {
      List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
      pessoasPorAltura.sort(Comparator.comparingDouble(Pessoa::getAltura));
      return pessoasPorAltura;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }
}
```

## Referências

1. [Java Stream API - Oracle](https://www.oracle.com/br/technical-resources/articles/java-stream-api.html)
2. [Java Collections API Examples - cami-la](https://github.com/cami-la/collections-java-api-2023)
3. [Como usar funções functional_interface em Java - DevMedia](https://www.devmedia.com.br/como-usar-funcoes-lambda-em-java/32826)

---

