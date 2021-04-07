/**
 *
 */
package br.edu.ifs.ed2.dados.lista;

import br.edu.ifs.ed2.dados.no.No;

/**
 * Interface que estabelece as opera��es b�sicas de uma lista
 *
 * @author Marlos Tacio Silva
 *
 */
public interface Lista<G> {

    /**
     * M�todo para a inser��o de um elemento no inicio da lista
     *
     * @param conteudo Conte�do a ser inserido na lista
     *
     * @return Uma refer�ncia para a lista (encadeamento de opera��es)
     */
    public Lista<G> inserirInicio(G conteudo);

    /**
     * M�todo para a inser��o de um elemento no fim da lista
     *
     * @param conteudo Conte�do a ser inserido na lista
     *
     * @return Uma refer�ncia para a lista (encadeamento de opera��es)
     */
    public Lista<G> inserirFim(G conteudo);

    /**
     * M�todo para a remo��o de um elemento da lista
     *
     * @param conteudo Conte�do a ser removido
     *
     * @return Verdadeiro em caso de remo��o bem sucedida e falso caso contr�rio
     */
    public boolean remover(G conteudo);

    /**
     * M�todo para a remo��o de um elemento do inicio lista
     *
     * @return Verdadeiro em caso de remo��o bem sucedida e falso caso contr�rio
     */
    public boolean removerInicio();

    /**
     * M�todo para a remo��o de um elemento do fim lista
     *
     * @return Verdadeiro em caso de remo��o bem sucedida e falso caso contr�rio
     */
    public boolean removerFim();

    /**
     * M�todo para a busca de um elemento da lista
     *
     * @param conteudo Conte�do a ser buscado
     *
     * @return Uma refer�ncia para o conte�do em caso de busca bem sucedida e nulo
     *         caso contr�rio
     */
    public No<G> buscar(G conteudo);

    /**
     * M�todo que verifica se a lista est� vazia
     *
     * @return Verdadeiro em caso de lista vazia e falso caso contr�rio
     */
    public boolean estaVazia();

    /**
     * M�todo que remove todos os elementos da lista
     *
     * @return Uma refer�ncia para a lista (encadeamento de opera��es)
     */
    public Lista<G> limpar();

}
