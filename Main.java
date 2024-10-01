class Nodo{
    String caractere;
    Nodo filho_esquerdo;
    Nodo filho_direito;

    Nodo(){
        this.caractere = null;
        this.filho_esquerdo = null;
        this.filho_direito = null;
    }
}


class ArvoreBinariaMorse{
    private Nodo raiz;
    public void inicializar(){
        this.raiz = new Nodo();
    }
    
    public void inserir(String codigo_morse , String caractere){
        Nodo no_atual = raiz;
        for (int i = 0; i < codigo_morse.length(); i++){
            char caractere_atual = codigo_morse.charAt(i);

            if (caractere_atual == '.'){
                if (no_atual.filho_esquerdo == null){
                    no_atual.filho_esquerdo = new Nodo();
                }
                no_atual = no_atual.filho_esquerdo;
            }
            else if (caractere_atual =='-'){    
                if (no_atual.filho_direito == null){
                    no_atual.filho_direito = new Nodo();
                }
                no_atual = no_atual.filho_direito;
            }
            
            no_atual.caractere = caractere;
        }
    }

    public String buscar(String codigo_morse){
        Nodo no_atual = raiz;
        String resultado = "";  // Variável simples para armazenar o resultado.
        
        for (int i = 0; i < codigo_morse.length(); i++){
            char caractere_atual = codigo_morse.charAt(i);
    
            // Quando encontramos um ponto, seguimos para o filho esquerdo.
            if (caractere_atual == '.'){
                if (no_atual.filho_esquerdo == null) {
                    return "Erro";
                }
                no_atual = no_atual.filho_esquerdo;
            }
            
            else if (caractere_atual == '-'){
                if (no_atual.filho_direito == null) {
                    return "Erro";
                }
                no_atual = no_atual.filho_direito;
            }
    
            
            if (no_atual != null){
                resultado += no_atual.caractere;  
                  
            }
            no_atual = raiz;
        }
    
        return resultado;
    }
    
}

public class Main{
    public static void main(String[] args) {
        
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();
        arvore.inserir("...", "S");
        arvore.inserir("---", "O");
        arvore.inserir("...", "S");


        System.out.println(arvore.buscar("..."));
        System.out.println(arvore.buscar("---"));
        System.out.println(arvore.buscar("."));

    }
}