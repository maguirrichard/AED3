/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class Lista {

    private Celula primeiro; // Primeira celula: SEM elemento valido.
    private Celula ultimo; // Ultima celula: COM elemento valido.

    /**
     * Construtor da classe: Instancia uma celula (primeira e ultima).
     */
    public Lista() {
        primeiro = new Celula(null);
        ultimo = primeiro;
    }

    /**
     * Procura um elemento e retorna se ele existe.
     *
     * @param x Elemento a pesquisar.
     * @return <code>true</code> se o elemento existir, <code>false</code> em
     * caso contrario.
     */
    public boolean pesquisar(int x) {
        boolean retorno = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento.getCodigo() == x) {
                retorno = true;
                i = ultimo;
            }
        }
        return retorno;
    }

    /**
     * ****************************************************
     * Insere um elemento na primeira posicao da sequencia.
     *
     * @param elemento Elemento a inserir.
   *****************************************************
     */
    public void inserir(Entrega elemento) {
        Celula tmp = new Celula(elemento);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if (primeiro == ultimo) {
            ultimo = tmp;
        }

        tmp = null;
    }

    public void remover(int x) {
        for (Celula i = primeiro; i != null; i = i.prox) {
            if (i.prox != null && i.prox.elemento.getCodigo() == x) {
                i.prox = i.prox.prox;
            }
        }
    }
}
