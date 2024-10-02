import java.util.Scanner;

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

class ArvoreBinariaMorse {
    private Nodo raiz;

    public void inicializar() {
        this.raiz = new Nodo();
    }

    public void inserir(String codigo_morse, String caractere) {
        Nodo no_atual = raiz;
        for (int i = 0; i < codigo_morse.length(); i++) {
            char caractere_atual = codigo_morse.charAt(i);

            if (caractere_atual == '.') {
                if (no_atual.filho_esquerdo == null) {
                    no_atual.filho_esquerdo = new Nodo();
                }
                no_atual = no_atual.filho_esquerdo;
            } else if (caractere_atual == '-') {
                if (no_atual.filho_direito == null) {
                    no_atual.filho_direito = new Nodo();
                }
                no_atual = no_atual.filho_direito;
            }
        }
        no_atual.caractere = caractere;
    }

    public String buscar(String codigo_morse) {
        Nodo no_atual = raiz;
        for (int i = 0; i < codigo_morse.length(); i++) {
            char caractere_atual = codigo_morse.charAt(i);

            if (caractere_atual == '.') {
                if (no_atual.filho_esquerdo == null) {
                    return "Erro";
                }
                no_atual = no_atual.filho_esquerdo;
            } else if (caractere_atual == '-') {
                if (no_atual.filho_direito == null) {
                    return "Erro";
                }
                no_atual = no_atual.filho_direito;
            }
        }
        if (no_atual.caractere != null) {
            return no_atual.caractere;
        } else {
            return "Erro";
        }
    }

    public String buscarCodigoMorse(String caractere) {
        return buscarCodigoMorse(raiz, caractere.toUpperCase(), "");
    }

    private String buscarCodigoMorse(Nodo no, String caractere, String codigoAtual) {
        if (no == null) {
            return null;
        }
        if (caractere.equals(no.caractere)) {
            return codigoAtual;
        }
        String codigoEsquerda = buscarCodigoMorse(no.filho_esquerdo, caractere, codigoAtual + ".");
        if (codigoEsquerda != null) {
            return codigoEsquerda;
        }
        String codigoDireita = buscarCodigoMorse(no.filho_direito, caractere, codigoAtual + "-");
        return codigoDireita;
    }

    public void exibirArvore() {
        exibirArvore(raiz, "");
    }

    private void exibirArvore(Nodo no, String prefixo) {
        if (no != null) {
            if (no.caractere != null) {
                System.out.println(prefixo + ": " + no.caractere);
            }
            exibirArvore(no.filho_esquerdo, prefixo + ".");
            exibirArvore(no.filho_direito, prefixo + "-");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();

        String[][] morseCodes = {
                { "A", ".-" }, { "B", "-..." }, { "C", "-.-." }, { "D", "-.." },
                { "E", "." }, { "F", "..-." }, { "G", "--." }, { "H", "...." },
                { "I", ".." }, { "J", ".---" }, { "K", "-.-" }, { "L", ".-.." },
                { "M", "--" }, { "N", "-." }, { "O", "---" }, { "P", ".--." },
                { "Q", "--.-" }, { "R", ".-." }, { "S", "..." }, { "T", "-" },
                { "U", "..-" }, { "V", "...-" }, { "W", ".--" }, { "X", "-..-" },
                { "Y", "-.--" }, { "Z", "--.." }, { "0", "-----" }, { "1", ".----" },
                { "2", "..---" }, { "3", "...--" }, { "4", "....-" }, { "5", "....." },
                { "6", "-...." }, { "7", "--..." }, { "8", "---.." }, { "9", "----." }
        };

        for (String[] pair : morseCodes) {
            arvore.inserir(pair[1], pair[0]);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Traduzir código Morse para texto");
            System.out.println("2. Traduzir texto para código Morse");
            System.out.println("3. Exibir árvore Morse");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o código Morse (separado por espaços): ");
                String codigoMorse = scanner.nextLine();
                String[] codigos = codigoMorse.trim().split(" ");
                StringBuilder resultado = new StringBuilder();
                for (String codigo : codigos) {
                    if (codigo.equals("")) {
                        resultado.append(" ");
                    } else {
                        String caractere = arvore.buscar(codigo);
                        if (caractere.equals("Erro")) {
                            resultado.append("?");
                        } else {
                            resultado.append(caractere);
                        }
                    }
                }
                System.out.println("Texto traduzido: " + resultado.toString());
            } else if (opcao == 2) {
                System.out.print("Digite o texto: ");
                String texto = scanner.nextLine();
                StringBuilder resultado = new StringBuilder();
                for (int i = 0; i < texto.length(); i++) {
                    char c = texto.charAt(i);
                    if (c == ' ') {
                        resultado.append("  ");
                    } else {
                        String codigo = arvore.buscarCodigoMorse(String.valueOf(c));
                        if (codigo != null) {
                            resultado.append(codigo).append(" ");
                        } else {
                            resultado.append("? ");
                        }
                    }
                }
                System.out.println("Código Morse: " + resultado.toString());
            } else if (opcao == 3) {
                System.out.println("Árvore Morse:");
                arvore.exibirArvore();
            } else if (opcao == 4) {
                System.out.println("Encerrando o programa.");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
