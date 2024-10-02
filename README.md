# Implementação de Árvore Binária com Código Morse

Este projeto é uma implementação de uma árvore binária que representa o código Morse, permitindo a tradução de texto para código Morse e vice-versa. O código foi escrito em Java e inclui funcionalidades como inserção e busca de caracteres, exibição hierárquica da árvore e uma interface interativa com o usuário.

## Sumário

- [Introdução](#introdução)
- [Descrição do Projeto](#descrição-do-projeto)
- [Estrutura de Dados Utilizada](#estrutura-de-dados-utilizada)
- [Classes e Métodos](#classes-e-métodos)
    - [Classe `Nodo`](#classe-nodo)
    - [Classe `ArvoreBinariaMorse`](#classe-arvorebinariamorse)
    - [Classe `Main`](#classe-main)
- [Como o Programa Funciona](#como-o-programa-funciona)
    - [Inserção de Caracteres](#inserção-de-caracteres)
    - [Busca de Caracteres](#busca-de-caracteres)
    - [Exibição da Árvore](#exibição-da-árvore)
    - [Interface com o Usuário](#interface-com-o-usuário)
- [Como Executar o Programa](#como-executar-o-programa)
- [Exemplos de Uso](#exemplos-de-uso)
- [Considerações Finais](#considerações-finais)
- [Possíveis Melhorias](#possíveis-melhorias)
- [Referências](#referências)

## Introdução

O código Morse é um sistema de representação de letras e números através de sinais curtos e longos, conhecidos como pontos (.) e traços (-). Este projeto busca implementar uma árvore binária que mapeia cada caractere alfanumérico ao seu respectivo código Morse, permitindo a tradução entre texto e código Morse de forma eficiente.

## Descrição do Projeto

O objetivo principal é criar uma árvore binária onde cada caminho da raiz até um nó folha representa a sequência de pontos e traços de um caractere em código Morse. Isso permite uma representação hierárquica e estruturada do código Morse, facilitando a inserção, busca e exibição dos caracteres.

## Estrutura de Dados Utilizada

A estrutura principal é uma **árvore binária**, onde:

- Cada **nó** representa um ponto no percurso do código Morse.
- O **filho esquerdo** corresponde a um **ponto** (.)
- O **filho direito** corresponde a um **traço** (-)
- As **folhas** contêm o **caractere** correspondente ao código Morse percorrido desde a raiz.

## Classes e Métodos

### Classe `Nodo`

Representa um nó na árvore binária.

```java
class Nodo {
    String caractere;
    Nodo filho_esquerdo;
    Nodo filho_direito;

    Nodo() {
        this.caractere = null;
        this.filho_esquerdo = null;
        this.filho_direito = null;
    }
}
```

- **Atributos:**
    - `caractere`: Armazena o caractere alfanumérico correspondente ao código Morse percorrido.
    - `filho_esquerdo`: Referência ao filho esquerdo do nó.
    - `filho_direito`: Referência ao filho direito do nó.
- **Construtor:**
    - Inicializa o `caractere` como `null` e os filhos como `null`.

### Classe `ArvoreBinariaMorse`

Gerencia a árvore binária e as operações de inserção, busca e exibição.

```java
class ArvoreBinariaMorse {
    private Nodo raiz;

    public void inicializar() { ... }

    public void inserir(String codigo_morse, String caractere) { ... }

    public String buscar(String codigo_morse) { ... }

    public String buscarCodigoMorse(String caractere) { ... }

    private String buscarCodigoMorse(Nodo no, String caractere, String codigoAtual) { ... }

    public void exibirArvore() { ... }

    private void exibirArvore(Nodo no, String prefixo) { ... }
}
```

- **Atributos:**
    - `raiz`: Referência ao nó raiz da árvore.

- **Métodos:**

    - `inicializar()`: Inicializa a árvore criando a raiz.
    - `inserir(String codigo_morse, String caractere)`: Insere um caractere na árvore de acordo com o seu código Morse.
    - `buscar(String codigo_morse)`: Busca um caractere na árvore dado um código Morse.
    - `buscarCodigoMorse(String caractere)`: Retorna o código Morse correspondente a um caractere.
    - `exibirArvore()`: Exibe a estrutura hierárquica da árvore.
    - **Métodos Privados:**
        - `buscarCodigoMorse(Nodo no, String caractere, String codigoAtual)`: Método recursivo auxiliar para buscar o código Morse de um caractere.
        - `exibirArvore(Nodo no, String prefixo)`: Método recursivo auxiliar para exibir a árvore.

### Classe `Main`

Contém o método `main` e gerencia a interação com o usuário.

```java
public class Main {
    public static void main(String[] args) {
        ...
    }
}
```

- **Principais Funcionalidades:**
    - Inicializa a árvore e insere todos os caracteres alfanuméricos.
    - Exibe um menu interativo permitindo ao usuário:
        - Traduzir código Morse para texto.
        - Traduzir texto para código Morse.
        - Exibir a árvore Morse.
        - Encerrar o programa.

## Como o Programa Funciona

### Inserção de Caracteres

- **Processo:**
    - Para cada caractere, percorremos o código Morse e navegamos na árvore:
        - Se o símbolo for um ponto (.), vamos para o filho esquerdo.
        - Se for um traço (-), vamos para o filho direito.
    - Ao final do percurso, atribuímos o caractere ao nó correspondente.
- **Implementação:**
    - Utiliza o método `inserir(String codigo_morse, String caractere)`.

### Busca de Caracteres

- **Buscar por Código Morse:**
    - Percorre a árvore seguindo os símbolos do código Morse.
    - Retorna o caractere encontrado ou "Erro" se não existir.
    - Implementado no método `buscar(String codigo_morse)`.

- **Buscar por Caractere:**
    - Realiza uma busca em profundidade na árvore para encontrar o caminho (código Morse) até o caractere.
    - Implementado no método `buscarCodigoMorse(String caractere)`.

### Exibição da Árvore

- Exibe a estrutura hierárquica da árvore, mostrando:
    - O caminho (pontos e traços) desde a raiz até cada nó que contém um caractere.
    - Implementado nos métodos `exibirArvore()` e `exibirArvore(Nodo no, String prefixo)`.

### Interface com o Usuário

- **Menu Interativo:**
    - Oferece quatro opções:
        1. Traduzir código Morse para texto.
        2. Traduzir texto para código Morse.
        3. Exibir a árvore Morse.
        4. Sair.
- **Interação:**
    - Utiliza a classe `Scanner` para ler as entradas do usuário.
    - Realiza validações e fornece feedback em caso de entradas inválidas.

## Como Executar o Programa

1. **Pré-requisitos:**
    - Ter o **Java Development Kit (JDK)** instalado (versão 8 ou superior).

2. **Compilação:**
    - Salve as classes `Nodo`, `ArvoreBinariaMorse` e `Main` em arquivos `.java` com os respectivos nomes.
    - Compile os arquivos utilizando o comando:
      ```
      javac Main.java
      ```

3. **Execução:**
    - Execute o programa com o comando:
      ```
      java Main
      ```

## Exemplos de Uso

### 1. Traduzir Código Morse para Texto

- **Entrada:**
  ```
  ... --- ...
  ```
- **Processo:**
    - O programa divide o código Morse em códigos individuais: `...`, `---`, `...`.
    - Busca cada código na árvore e forma a palavra.
- **Saída:**
  ```
  Texto traduzido: SOS
  ```

### 2. Traduzir Texto para Código Morse

- **Entrada:**
  ```
  HELLO WORLD
  ```
- **Processo:**
    - O programa percorre cada caractere do texto.
    - Converte espaços em dois espaços para separar palavras no código Morse.
    - Busca o código Morse correspondente a cada caractere na árvore.
- **Saída:**
  ```
  Código Morse: .... . .-.. .-.. ---   .-- --- .-. .-.. -..
  ```

### 3. Exibir a Árvore Morse

- **Saída Exemplo:**
  ```
  : E
  .: I
  ..: S
  ...: H
  ....: 5
  ...-: V
  ..-: U
  ..-.: F
  .-: A
  .-.: R
  .-..: L
  .--: W
  .---: J
  .--.: P
  ...
  ```

### 4. Opção Inválida

- **Entrada:**
  ```
  5
  ```
- **Saída:**
  ```
  Opção inválida. Tente novamente.
  ```

## Considerações Finais

Este programa demonstra de forma prática como uma árvore binária pode ser utilizada para representar e manipular o código Morse. A estrutura permite inserções e buscas eficientes, tornando a tradução entre texto e código Morse rápida e precisa.

Além disso, a implementação oferece uma interface amigável, facilitando a interação do usuário com o programa.

## Possíveis Melhorias

- **Adicionar Suporte a Caracteres Especiais:**
    - Incluir pontuação e outros símbolos no mapeamento Morse.
- **Implementar Sensibilidade a Minúsculas e Maiúsculas:**
    - Tratar entradas em diferentes casos sem a necessidade de conversão explícita.
- **Melhorar o Tratamento de Erros:**
    - Fornecer mensagens de erro mais detalhadas e sugestões para o usuário.
- **Interface Gráfica:**
    - Desenvolver uma interface gráfica para tornar o programa mais interativo.
- **Salvar e Carregar Mensagens:**
    - Permitir que o usuário salve traduções em arquivos e carregue mensagens previamente salvas.

## Referências

- **Código Morse Internacional:** [Wikipedia](https://pt.wikipedia.org/wiki/C%C3%B3digo_Morse)
- **Estruturas de Dados em Java:** Livro "Estruturas de Dados & Algoritmos em Java" de Robert Lafore.
- **Documentação Java:** [Oracle Java Documentation](https://docs.oracle.com/javase/8/docs/api/)

