/**
 *
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe que implementas as opera��es de um n� de uma �rvore AVL.
 *
 * @author Marlos Tacio Silva
 *
 */
public class NoAVL<G> extends NoTriplo<G> {

    /*
     * Atributos -------------------------------------------------------------------
     */

    /**
     * Atributo que armazena a altura do n�.
     */
    private int altura;

    /*
     * Construtores ----------------------------------------------------------------
     */

    /**
     * Construtor da classe.
     *
     * @param conteudo Conte�do do n�.
     */
    public NoAVL(G conteudo) {

        super(conteudo);

        this.setAltura(0);
    }

    /*
     * Gets e Sets -----------------------------------------------------------------
     */

    /*
     * Gets e Sets -----------------------------------------------------------------
     */

    /**
     * M�todo que retorna uma refer�ncia para o n� pai.
     *
     * @return Uma refer�ncia para o n� pai, caso exista, ou nulo, caso contr�rio.
     */
    public NoAVL<G> getPai() {

        return (NoAVL<G>) super.getPai();
    }

    /**
     * M�todo que altera a refer�ncia para do n� pai.
     *
     * @param pai O n� a ser alterado.
     *
     */
    protected void setPai(NoAVL<G> pai) {

        this.pai = pai;
    }

    /**
     * M�todo que retorna uma refer�ncia para o n� filho esquerdo.
     *
     * @return Uma refer�ncia para o n� filho esquerdo, caso exista, ou nulo, caso
     *         contr�rio.
     */
    public NoAVL<G> getEsquerdo() {

        return (NoAVL<G>) this.esquerdo;
    }

    /**
     * M�todo que retorna uma refer�ncia para o n� filho direito.
     *
     * @return Uma refer�ncia para o n� filho direito, caso exista, ou nulo, caso
     *         contr�rio.
     */
    public NoAVL<G> getDireito() {

        return (NoAVL<G>) this.direito;
    }

    /**
     * M�todo que altera a refer�ncia para o n� filho esquerdo. Essa opera��o altera
     * tamb�m a rela��o de paternidade entre os n�s envolvidos.
     *
     * @param esquerdo O n� a ser alterado.
     *
     */
    public void setEsquerdo(NoAVL<G> esquerdo) {

        if (this.esquerdo == esquerdo) {

            return;
        }

        this.esquerdo = esquerdo;

        if (esquerdo != null) {

            esquerdo.setPai(this);
        }
    }

    /**
     * M�todo que altera a refer�ncia para o n� filho direito. Essa opera��o altera
     * tamb�m a rela��o de paternidade entre os n�s envolvidos.
     *
     * @param direito O n� a ser alterado.
     *
     */
    public void setDireito(NoAVL<G> direito) {

        if (this.direito == direito) {

            return;
        }

        this.direito = direito;

        if (direito != null) {

            direito.setPai(this);
        }
    }

    /**
     * @return o altura
     */
    public int getAltura() {

        return this.altura;
    }

    /**
     * @param altura o altura a ser configurado
     */
    public void setAltura(int altura) {

        this.altura = altura;
    }
}
