/**
 *
 */
package br.edu.ifs.ed2.dados.arvore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifs.ed2.dados.no.NoAVL;

/**
 * @author Marlos Tacio Silva
 *
 */
public class TesteArvoreAVL {

    /*
     *
     */
    private ArvoreAVL<Integer> arvore;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        /*
         * Constru��o dos n�s da �rvore.
         */
        NoAVL<Integer> n1 = new NoAVL<Integer>(30);
        NoAVL<Integer> n2 = new NoAVL<Integer>(20);
        NoAVL<Integer> n3 = new NoAVL<Integer>(70);
        NoAVL<Integer> n4 = new NoAVL<Integer>(10);
        NoAVL<Integer> n5 = new NoAVL<Integer>(25);
        NoAVL<Integer> n6 = new NoAVL<Integer>(50);
        NoAVL<Integer> n7 = new NoAVL<Integer>(80);

        /*
         *
         */
        n1.setAltura(2);
        n2.setAltura(1);
        n3.setAltura(1);

        /*
         * Estabelecimento das rela��es.
         */
        n1.setEsquerdo(n2);
        n1.setDireito(n3);

        n2.setEsquerdo(n4);
        n2.setDireito(n5);

        n3.setEsquerdo(n6);
        n3.setDireito(n7);

        /*
         * Inicializa��o da �rvore.
         */
        arvore = new ArvoreAVL<Integer>(n1);
    }

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.arvore.ArvoreAVL#inserir(java.lang.Comparable)}.
     */
    @Test
    public void testInserir() {

        /*
         * Cria��o e verifica��o de uma �rvore vazia.
         */
        arvore = new ArvoreAVL<Integer>();
        assertEquals(arvore.toString(), "");

        /*
         * Tentativa de inser��o de um valor nulo na �rvore.
         */
        assertFalse(arvore.inserir(null));

        /*
         * Inser��o do valor 30 que deve ser alocado na raiz da �rvore.
         */
        assertTrue(arvore.inserir(30));
        assertEquals(arvore.toString(), "30");

        /*
         * Inser��o do valor 50 que deve ser alocado � direita da raiz da �rvore.
         */
        assertTrue(arvore.inserir(50));
        assertEquals(arvore.toString(), "30( - , 50 )");

        /*
         * Inser��o do valor 80 que quando for alocado � direita do valor 50 ir� causar
         * um desbalanceamento na �rvore. O balanceamento dessa �rvore envolver� uma
         * rota��o � esquerda.
         */
        assertTrue(arvore.inserir(80));
        assertEquals(arvore.toString(), "50( 30 , 80 )");

        /*
         * Inser��o do valor 20 que deve ser alocado � esquerda do valor 30.
         */
        assertTrue(arvore.inserir(20));
        assertEquals(arvore.toString(), "50( 30( 20 , - ) , 80 )");

        /*
         * Inser��o do valor 10 que quando for alocado � esquerda do valor 20 ir� causar
         * um desbalanceamento na �rvore. O balanceamento dessa �rvore envolver� uma
         * rota��o � direita.
         */
        assertTrue(arvore.inserir(10));
        assertEquals(arvore.toString(), "50( 20( 10 , 30 ) , 80 )");

        /*
         * Inser��o do valor 25 que quando for alocado � esquerda do valor 30 ir� causar
         * um desbalanceamento na �rvore. O balanceamento dessa �rvore envolver� uma
         * rota��o � esquerda seguida de uma rota��o � direita.
         */
        assertTrue(arvore.inserir(25));
        assertEquals(arvore.toString(), "30( 20( 10 , 25 ) , 50( - , 80 ) )");

        /*
         * Inser��o do valor 70 que quando for alocado � esquerda do valor 50 ir� causar
         * um desbalanceamento na �rvore. O balanceamento dessa �rvore envolver� uma
         * rota��o � direita seguida de uma rota��o � esquerda.
         */
        assertTrue(arvore.inserir(70));
        assertEquals(arvore.toString(), "30( 20( 10 , 25 ) , 70( 50 , 80 ) )");
    }

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.arvore.ArvoreAVL#remover(java.lang.Comparable)}.
     */
    @Test
    public void testRemover() {

        /*
         * Verifica��o do estado inicial da �rvore de teste.
         */
        assertEquals(arvore.toString(), "30( 20( 10 , 25 ) , 70( 50 , 80 ) )");

        /*
         * Tentativa de remo��o de um valor nulo e de um valor inexistente na �rvore.
         */
        assertFalse(arvore.remover(null));
        assertFalse(arvore.remover(1));

        /*
         * Remo��o de um n� que possui ambos os filhos, mas nenhum deles � o seu
         * sucessor. A remo��o desse n� n�o causar� desbalanceamento na �rvore.
         */
        assertTrue(arvore.remover(30));
        assertEquals(arvore.toString(), "50( 20( 10 , 25 ) , 70( - , 80 ) )");

        /*
         * Remo��o de um n� que possui apenas um filho direito. A remo��o desse n� n�o
         * causar� desbalanceamento na �rvore.
         */
        assertTrue(arvore.remover(70));
        assertEquals(arvore.toString(), "50( 20( 10 , 25 ) , 80 )");

        /*
         * Remo��o de um n� que n�o possui nenhum filho. A remo��o desse n� causar� um
         * desbalanceamento na �rvore. O balanceamento dessa �rvore envolver� uma
         * rota��o � direita.
         */
        assertTrue(arvore.remover(80));
        assertEquals(arvore.toString(), "20( 10 , 50( 25 , - ) )");

        /*
         * Remo��o de um n� que n�o possui nenhum filho. A remo��o desse n� causar� um
         * desbalanceamento na �rvore. O balanceamento dessa �rvore envolver� uma
         * rota��o � direita seguida de uma rota��o � esquerda.
         */
        assertTrue(arvore.remover(10));
        assertEquals(arvore.toString(), "25( 20 , 50 )");
    }
}
