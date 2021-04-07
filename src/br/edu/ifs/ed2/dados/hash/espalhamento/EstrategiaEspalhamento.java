/**
 *
 */
package br.edu.ifs.ed2.dados.hash.espalhamento;

/**
 * Interface que define a opera��o de espalhamento dos elementos na tabela.
 *
 * @author Marlos Tacio Silva
 *
 */
public interface EstrategiaEspalhamento<G> {

    /**
     * M�todo para calcular o �ndice de um elemento a partir de sua chave.
     *
     * @param chave   Chave do elemento a ser inserido.
     *
     * @param tamanho Tamanho da tabela de espalhamento.
     *
     * @return �ndice em que o elemento ser� inserido.
     */
    public int calcularIndice(int chave, int tamanho);

}
