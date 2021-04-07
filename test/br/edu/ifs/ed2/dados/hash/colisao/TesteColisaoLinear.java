/**
 *
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.ifs.ed2.dados.hash.Hash;
import br.edu.ifs.ed2.dados.hash.HashAberto;
import br.edu.ifs.ed2.dados.hash.chave.ChaveNumerica;
import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.espalhamento.EspalhamentoDivisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * @author Marlos Tacio Silva
 *
 */
public class TesteColisaoLinear {

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
    private EstrategiaColisao<Integer> colisao = new ColisaoLinear<Integer>();

    /*
     * Estrat�gia de espalhamento dos elementos na tabela hash.
     */
    private EstrategiaEspalhamento<Integer> espalhamento = new EspalhamentoDivisao<Integer>();

    /*
     * Tabela Hash com endere�amento aberto.
     */
    private Hash<Integer> hash = new HashAberto<Integer>(tamanho, chave, espalhamento, colisao);

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.hash.colisao.ColisaoLinear#obterIndice(int, br.edu.ifs.ed2.dados.hash.Hash)}.
     */
    @Test
    public void testObterIndiceIntHashOfG() {

        /*
         * Inser��o de elementos no in�cio da tabela.
         */
        hash.inserir(1);
        hash.inserir(2);
        hash.inserir(3);

        /*
         * Inser��o de elementos no fim da tabela.
         */
        hash.inserir(5);
        hash.inserir(6);
        hash.inserir(7);

        /*
         * Resolu��o de colis�o com c�lulas livres.
         */
        assertEquals(colisao.obterIndice(0, hash), 0);
        assertEquals(colisao.obterIndice(4, hash), 4);

        /*
         * Resolu��o de colis�o com c�lulas ocupadas.
         */
        assertEquals(colisao.obterIndice(1, hash), 4);
        assertEquals(colisao.obterIndice(2, hash), 4);
        assertEquals(colisao.obterIndice(3, hash), 4);

        /*
         * Resolu��o de colis�o com c�lulas ocupadas.
         */
        assertEquals(colisao.obterIndice(5, hash), 0);
        assertEquals(colisao.obterIndice(6, hash), 0);
        assertEquals(colisao.obterIndice(7, hash), 0);
    }

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.hash.colisao.ColisaoLinear#obterIndice(int, br.edu.ifs.ed2.dados.hash.Hash, java.lang.Object)}.
     */
    @Test
    public void testObterIndiceIntHashOfGG() {

        /*
         * Inser��o de elementos na tabela.
         */
        hash.inserir(0);
        hash.inserir(8);
        hash.inserir(16);
        hash.inserir(24);
        hash.inserir(32);
        hash.inserir(40);
        hash.inserir(48);
        hash.inserir(56);
        hash.inserir(64);

        /*
         * Verifica��o dos elementos na tabela de espalhamento.
         */
        assertEquals(colisao.obterIndice(0, hash, 0), 0);
        assertEquals(colisao.obterIndice(0, hash, 8), 1);
        assertEquals(colisao.obterIndice(0, hash, 16), 2);
        assertEquals(colisao.obterIndice(0, hash, 24), 3);
        assertEquals(colisao.obterIndice(0, hash, 32), 4);
        assertEquals(colisao.obterIndice(0, hash, 40), 5);
        assertEquals(colisao.obterIndice(0, hash, 48), 6);
        assertEquals(colisao.obterIndice(0, hash, 56), 7);
        assertEquals(colisao.obterIndice(0, hash, 64), -1);
    }

}
