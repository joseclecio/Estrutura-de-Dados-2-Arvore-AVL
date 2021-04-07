/**
 *
 */
package br.edu.ifs.ed2.dados.hash.chave;

/**
 * Classe que implementa uma opera��o de constru��o de chaves num�ricas a partir
 * do exemplo a seguir:
 *
 * Conte�do: 34 -> Chave; 34
 *
 * Conte�do: -98 -> Chave: 98
 *
 * @author Marlos Tacio Silva
 *
 */
public class ChaveNumerica implements EstrategiaChave<Integer> {

    /**
     *
     */
    @Override
    public int gerarChave(Integer conteudo) {

        /*
         * Inicializa��o da chave.
         */
        int chave = 0;

        /*
         * C�lculo da chave.
         */
        chave = Math.abs(conteudo);

        /*
         * Retorno da chave.
         */
        return chave;
    }
}