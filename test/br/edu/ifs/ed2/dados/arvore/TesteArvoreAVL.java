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
         * Construção dos nós da árvore.
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
         * Estabelecimento das relações.
         */
        n1.setEsquerdo(n2);
        n1.setDireito(n3);

        n2.setEsquerdo(n4);
        n2.setDireito(n5);

        n3.setEsquerdo(n6);
        n3.setDireito(n7);

        /*
         * Inicialização da árvore.
         */
        arvore = new ArvoreAVL<Integer>(n1);
    }

    /**
     * Testar método para
     * {@link br.edu.ifs.ed2.dados.arvore.ArvoreAVL#inserir(java.lang.Comparable)}.
     */
    @Test
    public void testInserir() {

        /*
         * Criação e verificação de uma árvore vazia.
         */
        arvore = new ArvoreAVL<Integer>();
        assertEquals(arvore.toString(), "");

        /*
         * Tentativa de inserção de um valor nulo na árvore.
         */
        assertFalse(arvore.inserir(null));

        /*
         * Inserção do valor 30 que deve ser alocado na raiz da árvore.
         */
        assertTrue(arvore.inserir(30));
        assertEquals(arvore.toString(), "30");

        /*
         * Inserção do valor 50 que deve ser alocado à direita da raiz da árvore.
         */
        assertTrue(arvore.inserir(50));
        assertEquals(arvore.toString(), "30( - , 50 )");

        /*
         * Inserção do valor 80 que quando for alocado à direita do valor 50 irá causar
         * um desbalanceamento na árvore. O balanceamento dessa árvore envolverá uma
         * rotação à esquerda.
         */
        assertTrue(arvore.inserir(80));
        assertEquals(arvore.toString(), "50( 30 , 80 )");

        /*
         * Inserção do valor 20 que deve ser alocado à esquerda do valor 30.
         */
        assertTrue(arvore.inserir(20));
        assertEquals(arvore.toString(), "50( 30( 20 , - ) , 80 )");

        /*
         * Inserção do valor 10 que quando for alocado à esquerda do valor 20 irá causar
         * um desbalanceamento na árvore. O balanceamento dessa árvore envolverá uma
         * rotação à direita.
         */
        assertTrue(arvore.inserir(10));
        assertEquals(arvore.toString(), "50( 20( 10 , 30 ) , 80 )");

        /*
         * Inserção do valor 25 que quando for alocado à esquerda do valor 30 irá causar
         * um desbalanceamento na árvore. O balanceamento dessa árvore envolverá uma
         * rotação à esquerda seguida de uma rotação à direita.
         */
        assertTrue(arvore.inserir(25));
        assertEquals(arvore.toString(), "30( 20( 10 , 25 ) , 50( - , 80 ) )");

        /*
         * Inserção do valor 70 que quando for alocado à esquerda do valor 50 irá causar
         * um desbalanceamento na árvore. O balanceamento dessa árvore envolverá uma
         * rotação à direita seguida de uma rotação à esquerda.
         */
        assertTrue(arvore.inserir(70));
        assertEquals(arvore.toString(), "30( 20( 10 , 25 ) , 70( 50 , 80 ) )");
    }

    /**
     * Testar método para
     * {@link br.edu.ifs.ed2.dados.arvore.ArvoreAVL#remover(java.lang.Comparable)}.
     */
    @Test
    public void testRemover() {

        /*
         * Verificação do estado inicial da árvore de teste.
         */
        assertEquals(arvore.toString(), "30( 20( 10 , 25 ) , 70( 50 , 80 ) )");

        /*
         * Tentativa de remoção de um valor nulo e de um valor inexistente na árvore.
         */
        assertFalse(arvore.remover(null));
        assertFalse(arvore.remover(1));

        /*
         * Remoção de um nó que possui ambos os filhos, mas nenhum deles é o seu
         * sucessor. A remoção desse nó não causará desbalanceamento na árvore.
         */
        assertTrue(arvore.remover(30));
        assertEquals(arvore.toString(), "50( 20( 10 , 25 ) , 70( - , 80 ) )");

        /*
         * Remoção de um nó que possui apenas um filho direito. A remoção desse nó não
         * causará desbalanceamento na árvore.
         */
        assertTrue(arvore.remover(70));
        assertEquals(arvore.toString(), "50( 20( 10 , 25 ) , 80 )");

        /*
         * Remoção de um nó que não possui nenhum filho. A remoção desse nó causará um
         * desbalanceamento na árvore. O balanceamento dessa árvore envolverá uma
         * rotação à direita.
         */
        assertTrue(arvore.remover(80));
        assertEquals(arvore.toString(), "20( 10 , 50( 25 , - ) )");

        /*
         * Remoção de um nó que não possui nenhum filho. A remoção desse nó causará um
         * desbalanceamento na árvore. O balanceamento dessa árvore envolverá uma
         * rotação à direita seguida de uma rotação à esquerda.
         */
        assertTrue(arvore.remover(10));
        assertEquals(arvore.toString(), "25( 20 , 50 )");
    }
}
