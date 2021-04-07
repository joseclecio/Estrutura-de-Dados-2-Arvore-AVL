/**
 *
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.ifs.ed2.dados.hash.Hash;
import br.edu.ifs.ed2.dados.hash.HashEncadeado;
import br.edu.ifs.ed2.dados.hash.chave.ChaveNumerica;
import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.espalhamento.EspalhamentoDivisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * @author Marlos Tacio Silva
 *
 */
public class TesteColisaoEncadeada {

    /*
     * Tamanho da tabela hash.
     */
    private int tamanho = 8;

    /*
     * Estrat�gia de gera��o de chaves num�ricas.
     */
    private EstrategiaChave<Integer> chave = new ChaveNumerica();

    /*
     * Estrat�gia de tratamento de colis�es.
     */
    private EstrategiaColisao<Integer> colisao = new ColisaoEncadeada<Integer>();

    /*
     * Estrat�gia de espalhamento dos elementos na tabela hash.
     */
    private EstrategiaEspalhamento<Integer> espalhamento = new EspalhamentoDivisao<Integer>();

    /*
     * Tabela Hash com endere�amento encadeado.
     */
    private Hash<Integer> hash = new HashEncadeado<Integer>(tamanho, chave, espalhamento, colisao);

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.hash.colisao.ColisaoEncadeada#obterIndice(int, br.edu.ifs.ed2.dados.hash.Hash)}.
     */
    @Test
    public void testObterIndiceIntHashOfG() {

        /*
         * Verifica��o da t�cnica de resolu��o de colis�o para hash encadeados.
         */
        assertEquals(colisao.obterIndice(0, hash), 0);
        assertEquals(colisao.obterIndice(1, hash), 1);
        assertEquals(colisao.obterIndice(2, hash), 2);
        assertEquals(colisao.obterIndice(3, hash), 3);
        assertEquals(colisao.obterIndice(4, hash), 4);
        assertEquals(colisao.obterIndice(5, hash), 5);
        assertEquals(colisao.obterIndice(6, hash), 6);
        assertEquals(colisao.obterIndice(7, hash), 7);
    }

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.hash.colisao.ColisaoEncadeada#obterIndice(int, br.edu.ifs.ed2.dados.hash.Hash, java.lang.Object)}.
     */
    @Test
    public void testObterIndiceIntHashOfGG() {

        /*
         * Inser��o de elementos na tabela
         */
        hash.inserir(0);
        hash.inserir(1);
        hash.inserir(8);
        hash.inserir(9);

        /*
         * Verifica��o dos elementos 0 e 8 no �ndice 0 da tabela de espalhamento.
         */
        assertEquals(colisao.obterIndice(0, hash, 0), 0);
        assertEquals(colisao.obterIndice(0, hash, 8), 0);

        /*
         * Verifica��o dos elementos 1 e 9 no �ndice 1 da tabela de espalhamento.
         */
        assertEquals(colisao.obterIndice(1, hash, 1), 1);
        assertEquals(colisao.obterIndice(1, hash, 9), 1);

        /*
         * Verifica��o dos elementos 0 e 8 que n�o devem ser encontrados no �ndice 1 da
         * tabela de espalhamento.
         */
        assertEquals(colisao.obterIndice(1, hash, 0), -1);
        assertEquals(colisao.obterIndice(1, hash, 8), -1);

        /*
         * Verifica��o dos elementos 1 e 9 que n�o devem ser encontrados no �ndice 0 da
         * tabela de espalhamento.
         */
        assertEquals(colisao.obterIndice(0, hash, 1), -1);
        assertEquals(colisao.obterIndice(0, hash, 9), -1);

    }

}
