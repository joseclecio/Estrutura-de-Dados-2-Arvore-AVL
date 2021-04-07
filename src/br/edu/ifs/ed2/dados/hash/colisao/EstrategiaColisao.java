/**
 *
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import br.edu.ifs.ed2.dados.hash.Hash;

/**
 * Interface que define a opera��o de tratamento de colis�es na tabela.
 *
 * @author Marlos Tacio Silva
 *
 */
public interface EstrategiaColisao<G> {

    /**
     * M�todo que aplica uma t�cnica de tratamento de colis�o, a partir de um �ndice
     * inicial, no intuito de obter o �ndice de uma c�lula n�o ocupada.
     *
     * @param indiceInicial �ndice inicial.
     *
     * @param tabela        Tabela de espalhamento.
     *
     * @return �ndice obtido ap�s a resolu��o da colis�o, em caso de resolu��o bem
     *         sucedida, ou -1, em caso de tabela cheia.
     */
    public int obterIndice(int indiceInicial, Hash<G> tabela);

    /**
     * M�todo que aplica uma t�cnica de tratamento de colis�o, a partir de um �ndice
     * inicial, no intuito de buscar um determinado conte�do na tabela de
     * espalhamento.
     *
     * @param indiceInicial �ndice inicial.
     *
     * @param tabela        Tabela de espalhamento.
     *
     * @param conteudo      Conte�do a ser buscado.
     *
     * @return �ndice obtido ap�s a resolu��o da colis�o, em caso de buscar bem
     *         sucedida, ou -1, em caso de busca mal sucedida.
     */
    public int obterIndice(int indiceInicial, Hash<G> tabela, G conteudo);

}
