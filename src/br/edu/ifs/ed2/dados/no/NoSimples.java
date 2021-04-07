/**
 *
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe que implementas as opera��es de um n� com encadeamento simples
 *
 * @author Marlos Tacio Silva
 *
 */
public class NoSimples<G> extends No<G> {

    /**
     * Atributo que armazena uma refer�ncia para o n� posterior
     */
    private NoSimples<G> posterior;

    /**
     * Construtor da classe
     *
     * @param conteudo Conte�do do n�
     */
    public NoSimples(G conteudo) {

        super(conteudo);
    }

    /**
     * M�todo que retorna uma refer�ncia para o pr�ximo n�
     *
     * @return Uma refer�ncia para o pr�ximo n�, caso exista, ou nulo, caso
     *         contr�rio
     */
    public NoSimples<G> getPosterior() {

        return posterior;
    }

    /**
     * M�todo que altera a refer�ncia para o n� posterior
     *
     * @param posterior O n� a ser inserido
     *
     * @return Uma refer�ncia para o pr�prio n� (encadeamento de opera��es)
     */
    public NoSimples<G> setPosterior(NoSimples<G> posterior) {

        this.posterior = posterior;

        return this;
    }
}
