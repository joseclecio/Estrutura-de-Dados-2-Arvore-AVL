/**
 *
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe abstrata que modela as opera��es de um n� de uma lista encadeada
 *
 * @author Marlos Tacio Silva
 *
 */
public abstract class No<G> {

    /**
     * Atributo gen�rico para o armazenamento do conte�do do n�
     */
    private G conteudo;

    /**
     * Construtor da classe
     *
     * @param conteudo Conte�do do n�
     */
    public No(G conteudo) {

        this.setConteudo(conteudo);
    }

    /**
     * M�todo que retorna o conte�do do n�
     *
     * @return Uma refer�ncia para o conte�do do n�
     */
    public G getConteudo() {

        return this.conteudo;
    }

    /**
     * M�todo que altera o conte�do do n�
     *
     * @param conteudo Conte�do a ser inserido
     *
     * @return Uma refer�ncia para o n� (encadeamento de opera��es)
     */
    public No<G> setConteudo(G conteudo) {

        this.conteudo = conteudo;

        return this;
    }

    /**
     * M�todo que retorna uma representa��o do n� em formato texto (string)
     */
    @Override
    public String toString() {

        return this.getConteudo().toString();
    }
}
