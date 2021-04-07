/**
 *
 */
package br.edu.ifs.ed2.dados.hash.chave;

/**
 * Interface que define a opera��o de constru��o da chave de um elemento.
 *
 * @author Marlos Tacio Silva
 *
 */
public interface EstrategiaChave<G> {

    /**
     * M�todo que calcula o valor de uma chave a partir do conte�do de um elemento.
     *
     * @param conteudo Conte�do em foco.
     *
     * @return Chave calculada.
     */
    public int gerarChave(G conteudo);

}
