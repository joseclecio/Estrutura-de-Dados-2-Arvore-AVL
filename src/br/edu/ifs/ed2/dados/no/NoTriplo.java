/**
 *
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe que implementas as opera��es de um n� com encadeamento triplo.
 *
 * @author Marlos Tacio Silva
 *
 */
public class NoTriplo<G> extends No<G> {

    /*
     * Atributos -------------------------------------------------------------------
     */

    /**
     * Atributo que armazena uma refer�ncia para o n� que modela pai.
     */
    protected NoTriplo<G> pai;

    /**
     * Atributo que armazena uma refer�ncia para o n� que modela o filho esquerdo.
     */
    protected NoTriplo<G> esquerdo;

    /**
     * Atributo que armazena uma refer�ncia para o n� que modela o filho direito.
     */
    protected NoTriplo<G> direito;

    /*
     * Construtores ----------------------------------------------------------------
     */

    /**
     * Construtor da classe.
     *
     * @param conteudo Conte�do do n�.
     */
    public NoTriplo(G conteudo) {

        super(conteudo);
    }

    /*
     * Gets e Sets -----------------------------------------------------------------
     */

    /**
     * M�todo que retorna uma refer�ncia para o n� pai.
     *
     * @return Uma refer�ncia para o n� pai, caso exista, ou nulo, caso contr�rio.
     */
    public NoTriplo<G> getPai() {

        return this.pai;
    }

    /**
     * M�todo que altera a refer�ncia para do n� pai.
     *
     * @param pai O n� a ser alterado.
     *
     */
    protected void setPai(NoTriplo<G> pai) {

        this.pai = pai;
    }

    /**
     * M�todo que retorna uma refer�ncia para o n� filho esquerdo.
     *
     * @return Uma refer�ncia para o n� filho esquerdo, caso exista, ou nulo, caso
     *         contr�rio.
     */
    public NoTriplo<G> getEsquerdo() {

        return this.esquerdo;
    }

    /**
     * M�todo que retorna uma refer�ncia para o n� filho direito.
     *
     * @return Uma refer�ncia para o n� filho direito, caso exista, ou nulo, caso
     *         contr�rio.
     */
    public NoTriplo<G> getDireito() {

        return this.direito;
    }

    /**
     * M�todo que altera a refer�ncia para o n� filho esquerdo. Essa opera��o altera
     * tamb�m a rela��o de paternidade entre os n�s envolvidos.
     *
     * @param esquerdo O n� a ser alterado.
     *
     */
    public void setEsquerdo(NoTriplo<G> esquerdo) {

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
    public void setDireito(NoTriplo<G> direito) {

        if (this.direito == direito) {

            return;
        }

        this.direito = direito;

        if (direito != null) {

            direito.setPai(this);
        }
    }

    /*
     * M�todos Sobrescritos --------------------------------------------------------
     */

    /**
     * M�todo que retorna uma representa��o da �rvore no formato texto (string).
     * Para essa representa��o � utilizado o m�todo de caminhamento em ordem.
     */
    @Override
    public String toString() {

        return this.mostrarPreOrdem(this);
    }

    /*
     * M�todos privados ------------------------------------------------------------
     */

    /**
     * M�todo que efetua o caminhamento em ordem a partir de um determinado n�.
     *
     * @param no N� de in�cio do percurso.
     *
     * @return Representa��o da �rvore em formato texto.
     */
    private String mostrarPreOrdem(NoTriplo<G> no) {

        /*
         * Representa��o do n� nulo.
         */
        if (no == null) {

            return "-";
        }

        StringBuilder string = new StringBuilder();

        /*
         * Adiciona o conte�do do n� pai � estrutura de texto.
         */
        string.append(no.getConteudo());

        /*
         * Se pelo menos um dos n�s filhos n�o for nulo, ent�o adicionar recursivamente
         * os n�s filhos � estrutura de texto.
         */
        if (no.getEsquerdo() != null || no.getDireito() != null) {

            string.append("( ");
            string.append(mostrarPreOrdem(no.getEsquerdo()));
            string.append(" , ");
            string.append(mostrarPreOrdem(no.getDireito()));
            string.append(" )");
        }

        return string.toString();
    }
}