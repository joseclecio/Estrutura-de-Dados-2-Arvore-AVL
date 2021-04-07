/**
 *
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe que implementas as opera��es de um n� com encadeamento duplo
 *
 * @author Marlos Tacio Silva
 *
 */
public class NoDuplo<G> extends No<G> {

    /**
     * Atributo que armazena uma refer�ncia para o n� posterior
     */
    private NoDuplo<G> posterior;

    /**
     * Atributo que armazena uma refer�ncia para o n� anterior
     */
    private NoDuplo<G> anterior;

    /**
     * Construtor da classe
     *
     * @param conteudo Conte�do do n�
     */
    public NoDuplo(G conteudo) {

        super(conteudo);
    }

    /**
     * M�todo que retorna uma refer�ncia para o pr�ximo n�
     *
     * @return Uma refer�ncia para o pr�ximo n�, caso exista, ou nulo, caso
     *         contr�rio
     */
    public NoDuplo<G> getPosterior() {

        return posterior;
    }

    /**
     * M�todo que altera a refer�ncia para o n� posterior. Essa opera��o efetua a
     * liga��o entre as refer�ncias posterior e anterior dos n�s envolvidos.
     *
     * @param posterior O n� a ser inserido
     *
     * @return Uma refer�ncia para o pr�prio n� (encadeamento de opera��es)
     */
    public NoDuplo<G> setPosterior(NoDuplo<G> posterior) {

        if (this.posterior == posterior) {

            return this;
        }

        this.posterior = posterior;

        if (posterior != null) {

            posterior.setAnterior(this);
        }

        return this;
    }

    /**
     * M�todo que retorna uma refer�ncia para o n� anterior
     *
     * @return Uma refer�ncia para o n� anterior, caso exista, ou nulo, caso
     *         contr�rio
     */
    public NoDuplo<G> getAnterior() {

        return anterior;
    }

    /**
     * M�todo que altera a refer�ncia para o n� anterior. Essa opera��o efetua a
     * liga��o entre as refer�ncias posterior e anterior dos n�s envolvidos.
     *
     * @param anterior O n� a ser inserido
     *
     * @return Uma refer�ncia para o pr�prio n� (encadeamento de opera��es)
     */
    public NoDuplo<G> setAnterior(NoDuplo<G> anterior) {

        if (this.anterior == anterior) {

            return this;
        }

        this.anterior = anterior;

        if (anterior != null) {

            anterior.setPosterior(this);
        }

        return this;
    }
}
