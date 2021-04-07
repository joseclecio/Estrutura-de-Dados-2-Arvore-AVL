/**
 *
 */
package br.edu.ifs.ed2.dados.hash.espalhamento;

/**
 * Classe que implementa a t�cnica de espalhamento via divis�o.
 *
 * @author Marlos Tacio Silva
 *
 */
public class EspalhamentoDivisao<G> implements EstrategiaEspalhamento<G> {

    /**
     *
     */
    @Override
    public int calcularIndice(int chave, int tamanho) {

        /*
         * Inicializa��o do �ndice
         */
        int indice = 0;

        /*
         * C�lculo do �ndice com base na t�cnica de divis�o
         */
        indice = chave % tamanho;

        /*
         * Retorno do �ndice
         */
        return indice;
    }
}
