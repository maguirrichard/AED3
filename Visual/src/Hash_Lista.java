/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class Hash_Lista {

    Lista tabela[];
    int tamanho;

    public Hash_Lista() {
        this(21);
    }

    public Hash_Lista(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new Lista[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new Lista();
        }
    }

    public Lista listar(int codigo) {
        return tabela[codigo];
    }

    public void inserir(Entrega elemento) {
        int pos = elemento.getCodigo();
        tabela[pos].inserir(elemento);
    }

    public void remover(int elemento) {
        int pos = elemento;
        if (tabela[pos].pesquisar(elemento) == true) {
            tabela[pos].remover(elemento);
        }
    }

}
