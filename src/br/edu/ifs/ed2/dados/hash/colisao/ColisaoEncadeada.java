/**
 *
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import br.edu.ifs.ed2.dados.hash.Hash;
import br.edu.ifs.ed2.dados.hash.HashEncadeado;

/**
 * Classe que implementa a opera��o de tratamento de colis�es na tabela.
 *
 * @author Marlos Tacio Silva
 *
 */
public class ColisaoEncadeada<G> implements EstrategiaColisao<G> {

    /**
     *
     */
    @Override
    public int obterIndice(int indiceInicial, Hash<G> tabela) {

        /*
         * Inicializa��o do novo �ndice.
         */
        int novoIndice = 0;

        /*
         * Resolu��o da colis�o e, consequentemente, c�lculo do novo valor do �ndice.
         */
        novoIndice = indiceInicial;

        /*
         * Retorno do novo �ndice.
         */
        return novoIndice;
    }

    @Override
    public int obterIndice(int indiceInicial, Hash<G> tabela, G conteudo) {

        /*
         * Coer��o da tabela para um hash encadeado.
         */
        HashEncadeado<G> hash = (HashEncadeado<G>) tabela;

        /*
         * Verifica��o da condi��o da c�lula da tabela referente ao �ndice inicial.
         */
        if (hash.getTabela()[indiceInicial] == null) {

            return -1;
        }

        /*
         * Verifica��o da lista alocada na c�lula da tabela referente ao �ndice inicial.
         */
        if (hash.getTabela()[indiceInicial].buscar(conteudo) == null) {

            return -1;
        }

        /*
         * Retorno do �ndice em que o conte�do est� alocado.
         */
        return indiceInicial;
    }

}
