/**
 *
 */
package br.edu.ifs.ed2.dados.hash.chave;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Marlos Tacio Silva
 *
 */
public class TesteChaveTextual {

    /*
     * Instancia��o de uma estrat�gia de gera��o de chave
     */
    private EstrategiaChave<String> chave = new ChaveTextual();

    /**
     * Testar m�todo para
     * {@link br.edu.ifs.ed2.dados.hash.chave.ChaveTextual#gerarChave(java.lang.String)}.
     */
    @Test
    public void testGerarChave() {

        /*
         * Aplica��o da fun��o de gera��o da chave em um texto vazio.
         */
        assertEquals(chave.gerarChave(""), 0);

        /*
         * Aplica��o da fun��o de gera��o da chave em uma letra (mai�scula e min�scula).
         */
        assertEquals(chave.gerarChave("a"), 97);
        assertEquals(chave.gerarChave("A"), 97);

        /*
         * Aplica��o da fun��o de gera��o da chave em combina��o e duas letras
         * (mai�scula e min�scula).
         */
        assertEquals(chave.gerarChave("ab"), 3105);
        assertEquals(chave.gerarChave("AB"), 3105);
        assertEquals(chave.gerarChave("aB"), 3105);
        assertEquals(chave.gerarChave("Ab"), 3105);

        /*
         * Aplica��o da fun��o de gera��o da chave em uma palavra (mai�scula e
         * min�scula).
         */
        assertEquals(chave.gerarChave("uva"), 116192);
        assertEquals(chave.gerarChave("UVA"), 116192);

    }
}
