/**
 *
 */
package br.edu.ifs.ed2.dados.hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.ifs.ed2.dados.hash.chave.ChaveNumerica;
import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.ColisaoEncadeada;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EspalhamentoDivisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * @author Marlos Tacio Silva
 *
 */
public class TesteHashEncadeado {

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
     * {@link br.edu.ifs.ed2.dados.hash.Hash#inserir(java.lang.Object)}.
     */
    @Test
    public void testInserir() {

        /*
         * Aplica��o da opera��o de inser��o num conjunto de n�meros menores do que o
         * tamanho da tabela hash.
         */
        assertTrue(hash.inserir(0));
        assertTrue(hash.inserir(1));
        assertTrue(hash.inserir(2));
        assertTrue(hash.inserir(3));
        assertTrue(hash.inserir(4));
        assertTrue(hash.inserir(5));
        assertTrue(hash.inserir(6));
        assertTrue(hash.inserir(7));

        /*
         * Aplica��o da opera��o de inser��o num conjunto de n�meros maiores do que o
         * tamanho da tabela hash.
         */
        assertTrue(hash.inserir(8));
        assertTrue(hash.inserir(9));
        assertTrue(hash.inserir(10));
        assertTrue(hash.inserir(11));
        assertTrue(hash.inserir(12));
        assertTrue(hash.inserir(13));
        assertTrue(hash.inserir(14));
        assertTrue(hash.inserir(15));
    }

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.hash.Hash#buscar(java.lang.Object)}.
     */
    @Test
    public void testBuscar() {

        /*
         * Inser��o de elementos no primeiro �ndice da tabela.
         */
        hash.inserir(0);
        hash.inserir(8);

        /*
         * Inser��o de elementos no segundo �ndice da tabela.
         */
        hash.inserir(1);
        hash.inserir(9);

        /*
         * Busca dos �ndices dos elementos 0 e 8 na tabela.
         */
        assertEquals(hash.buscar(0), 0);
        assertEquals(hash.buscar(8), 0);

        /*
         * Busca dos �ndices dos elementos 1 e 9 na tabela.
         */
        assertEquals(hash.buscar(1), 1);
        assertEquals(hash.buscar(9), 1);

        /*
         * Busca do �ndice do elemento 2 que n�o deve ser encontrado na tabela.
         */
        assertEquals(hash.buscar(2), -1);
    }

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.hash.Hash#remover(java.lang.Object)}.
     */
    @Test
    public void testRemover() {

        /*
         * Inser��o de elementos no primeiro �ndice da tabela.
         */
        hash.inserir(0);
        hash.inserir(8);

        /*
         * Inser��o de elementos no segundo �ndice da tabela.
         */
        hash.inserir(1);
        hash.inserir(9);

        /*
         * Remo��o de elementos no primeiro e no segundo �ndice da tabela.
         */
        assertTrue(hash.remover(0));
        assertTrue(hash.remover(9));

        /*
         * Busca dos elementos removidos que n�o devem ser encontrados na tabela.
         */
        assertEquals(hash.buscar(0), -1);
        assertEquals(hash.buscar(9), -1);
    }
}
