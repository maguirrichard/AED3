/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class Celula {

    public Entrega elemento; // Elemento inserido na celula.
    public Celula prox; // Aponta a celula prox.

    /**
     * ********************************************
     * Construtor da classe.
     *
     * @param elemento Elemento inserido na celula.
     * ********************************************
     */
    Celula(Entrega elemento) {
        this.elemento = elemento;
        this.prox = null;
    }

    /**
     * ********************************************
     * Construtor da classe.
     *
     * @param elemento Elemento inserido na celula.
     * @param prox Aponta a celula prox.
     * ********************************************
     */
    Celula(Entrega elemento, Celula prox) {
        this.elemento = elemento;
        this.prox = prox;
    }
}
