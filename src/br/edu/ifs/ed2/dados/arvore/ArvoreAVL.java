/**
 *
 */
package br.edu.ifs.ed2.dados.arvore;

import br.edu.ifs.ed2.dados.no.NoAVL;

/**
 * Classe que implementa as opera��es de uma �rvore bin�ria AVL.
 *
 * @author Marlos Tacio Silva.
 *
 */
public class ArvoreAVL<G extends Comparable<G>> {

    /*
     * Atributos -------------------------------------------------------------------
     */

    /**
     * Atributo que cont�m uma refer�ncia para o n� raiz da �rvore.
     */
    private NoAVL<G> raiz;

    /*
     * Construtores ----------------------------------------------------------------
     */

    /**
     * Construtor da classe.
     */
    public ArvoreAVL() {

        this(null);
    }

    /**
     * Construtor da classe.
     *
     * @param raiz N� raiz da �rvore.
     */
    public ArvoreAVL(NoAVL<G> raiz) {

        this.setRaiz(raiz);
    }

    /*
     * M�todos p�blicos ------------------------------------------------------------
     */

    /**
     * M�todo para a inser��o de um elemento na �rvore bin�ria de busca.
     *
     * @param conteudo Conte�do a ser inserido.
     *
     * @return Verdadeiro, para inser��o bem sucedida, ou falso, caso contr�rio.
     */
    public boolean inserir(G conteudo) {

        /*
         * Verifica��o e indica��o de inser��o mal sucedida, caso o conte�do seja nulo.
         */
        if (conteudo == null) {

            return false;
        }

        /*
         * Inser��o do conte�do a partir da raiz da �rvore.
         */
        this.setRaiz(this.inserir(this.getRaiz(), conteudo));
        return true;
    }

    /**
     * M�todo para a remo��o de um elemento na �rvore bin�ria de busca.
     *
     * @param conteudo Conte�do a ser removido.
     *
     * @return Verdadeiro, para remo��o bem sucedida, ou falso, caso contr�rio.
     */
    public boolean remover(G conteudo) {

        /*
         * Verifica��o e indica��o de remo��o mal sucedida, caso o conte�do seja nulo.
         */
        if (conteudo == null) {

            return false;
        }

        /*
         * Verifica��o e indica��o de elemento n�o encontrado.
         */
        if (this.buscar(conteudo) == null) {

            return false;
        }

        /*
         * Remo��o do elemento a partir da raiz da �rvore.
         */
        this.setRaiz(this.remover(this.getRaiz(), conteudo));

        /*
         * Indica��o de remo��o bem sucedida.
         */
        return true;
    }

    /**
     * M�todo para a busca de um elemento na �rvore bin�ria de busca.
     *
     * @param conteudo Conte�do a ser buscado.
     *
     * @return N� encontrado, para busca bem sucedida, ou nulo, caso contr�rio.
     */
    public NoAVL<G> buscar(G conteudo) {

        /*
         * Verifica��o e indica��o de inser��o mal sucedida, caso o conte�do seja nulo.
         */
        if (conteudo == null) {

            return null;
        }

        /*
         * Busca do elemento a partir da raiz.
         */
        return this.buscar(this.getRaiz(), conteudo);
    }

    /**
     * M�todo que retorna o n� com m�ximo valor na �rvore.
     *
     * @return N� m�ximo da �rvore.
     */
    public NoAVL<G> maximo() {

        /*
         * Chamada ao m�todo privado m�ximo passando a raiz como n� de refer�ncia.
         */
        return this.maximo(this.getRaiz());
    }

    /**
     * M�todo que retorna o n� com m�nimo valor na �rvore.
     *
     * @return N� m�nimo da �rvore.
     */
    public NoAVL<G> minimo() {

        /*
         * Chamada ao m�todo privado m�nimo passando a raiz como n� de refer�ncia.
         */
        return this.minimo(this.getRaiz());
    }

    /**
     * M�todo que retorna o sucessor de um determinado conte�do na �rvore.
     *
     * @param conteudo Conte�do em foco.
     *
     * @return O n� sucessor, caso exista, ou nulo, caso contr�rio.
     */
    public NoAVL<G> sucessor(G conteudo) {

        /*
         * Chamada ao m�todo privado passando o n� resultante da busca como refer�ncia.
         */
        return this.sucessor(this.buscar(conteudo));
    }

    /**
     * M�todo que retorna o predecessor de um determinado conte�do na �rvore.
     *
     * @param conteudo Conte�do em foco.
     *
     * @return O n� predecessor, caso exista, ou nulo, caso contr�rio.
     */
    public NoAVL<G> predecessor(G conteudo) {

        /*
         * Chamada ao m�todo privado passando o n� resultante da busca como refer�ncia.
         */
        return this.predecessor(this.buscar(conteudo));
    }

    /**
     * M�todo que efetua a limpeza da �rvore bin�ria de busca.
     */
    public void limpar() {

        /*
         * Estabelece a raiz como nula.
         */
        this.setRaiz(null);
    }

    /*
     * Gets e Sets -----------------------------------------------------------------
     */

    /**
     * M�todo que retorna uma refer�ncia para a ra�z da �rvore.
     *
     * @return A ra�z da �rvore.
     */
    public NoAVL<G> getRaiz() {

        return this.raiz;
    }

    /**
     * M�todo que altera o valor da ra�z da �rvore.
     *
     * @param raiz A nova ra�z da �rvore.
     */
    private void setRaiz(NoAVL<G> raiz) {

        this.raiz = raiz;
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

        if (this.getRaiz() == null) {

            return "";
        }

        return this.getRaiz().toString();
    }

    /*
     * M�todos privados ------------------------------------------------------------
     */

    /**
     * M�todo recursivo para a inser��o de um n� na �rvore.
     *
     * @param no       Sub-�rvore em foco.
     *
     * @param conteudo Conte�do a ser inserido.
     *
     * @return Sub-�rvore ap�s a inser��o do elemento.
     */
    private NoAVL<G> inserir(NoAVL<G> no, G conteudo) {

        /*
         * Verifica��o de fim de percurso e consequente retorno do novo n� a ser
         * inserido.
         */
        if (no == null) {

            return new NoAVL<G>(conteudo);
        }

        /*
         * Compara��o do conte�do a ser inserido com o conte�do do n� em foco.
         *
         * Obt�m o filho direito, caso o conte�do a ser inserido seja maior do que ou
         * igual ao do n� em foco, e o filho esquerdo, caso contr�rio.
         */
        if (conteudo.compareTo(no.getConteudo()) < 0) {

            no.setEsquerdo(this.inserir(no.getEsquerdo(), conteudo));
        } else {

            no.setDireito(this.inserir(no.getDireito(), conteudo));
        }

        /*
         * Atualiza��o da altura e balanceamento do n� em foco ap�s a inser��o.
         */
        no.setAltura(this.calcularAltura(no));
        return this.balanceamento(no);
    }

    /**
     * M�todo recursivo para a busca de um conte�do na �rvore.
     *
     * @param no       Sub-�rvore em foco.
     *
     * @param conteudo Conte�do a ser buscado.
     *
     * @return N� encontrado, para busca bem sucedida, ou nulo, caso contr�rio.
     */
    private NoAVL<G> buscar(NoAVL<G> no, G conteudo) {

        /*
         * Verifica��o de fim de percurso e consequente indica��o de busca mal sucedida.
         */
        if (no == null) {

            return null;
        }

        /*
         * Compara��o do conte�do a ser inserido com o conte�do do n� em foco.
         *
         * Obt�m o filho direito, caso o conte�do a ser inserido seja maior do que o do
         * n� em foco, o filho esquerdo, caso o conte�do a ser inserido seja menor do
         * que o do n� em foco, e o pr�prio n�, caso contr�rio.
         */
        if (conteudo.compareTo(no.getConteudo()) < 0) {

            return this.buscar(no.getEsquerdo(), conteudo);
        } else if (conteudo.compareTo(no.getConteudo()) > 0) {

            return this.buscar(no.getDireito(), conteudo);
        } else {

            return no;
        }
    }

    /**
     * M�todo para a remo��o de um elemento na �rvore bin�ria de busca.
     *
     * @param no       Sub-�rvore em foco.
     *
     * @param conteudo Conte�do a ser inserido.
     *
     * @return Sub-�rvore ap�s a inser��o do elemento.
     */
    private NoAVL<G> remover(NoAVL<G> no, G conteudo) {

        /*
         * Compara��o do conte�do a ser inserido com o conte�do do n� em foco.
         *
         * Obt�m o filho direito, caso o conte�do a ser inserido seja maior do que o do
         * n� em foco, o filho esquerdo, caso o conte�do a ser inserido seja menor do
         * que o do n� em foco, e o pr�prio n�, caso contr�rio.
         */
        if (conteudo.compareTo(no.getConteudo()) < 0) {

            no.setEsquerdo(this.remover(no.getEsquerdo(), conteudo));
        } else if (conteudo.compareTo(no.getConteudo()) > 0) {

            no.setDireito(this.remover(no.getDireito(), conteudo));
        } else {

            /*
             * Se o n� a ser removido n�o possuir filho esquerdo, ent�o dever� ser
             * substitu�do por seu filho direito.
             *
             * Se o n� a ser removido n�o possuir filho direito, ent�o dever� ser
             * substitu�do por seu filho esquerdo.
             *
             * Se o n� a ser removido possuir ambos os filhos, ent�o dever� ser substitu�do
             * por seu sucessor, que dever� ser removido.
             */
            if (no.getEsquerdo() == null) {

                return no.getDireito();
            } else if (no.getDireito() == null) {

                return no.getEsquerdo();
            } else {

                no.setConteudo(this.sucessor(no).getConteudo());
                no.setDireito(this.remover(no.getDireito(), no.getConteudo()));
            }
        }

        /*
         * Atualiza��o da altura e balanceamento do n� em foco ap�s a inser��o.
         */
        no.setAltura(this.calcularAltura(no));
        return this.balanceamento(no);
    }

    /**
     * M�todo que calcula a altura de um n�.
     *
     * @param no N� em foco.
     *
     * @return Altura do n�.
     */
    private int calcularAltura(NoAVL<G> no) {

        /*
         * Se o n� for nulo ent�o sua altura ser� -1.
         */

        if (no == null) {
            return -1;
        }

        /*
         * Estabelece, em um primeiro momento, os valores das alturas direita e
         * esquerda.
         */

        if (no.getEsquerdo() == null && no.getDireito() == null) {
            return 0;

        }

        /*
         * Se o n� direito existir ent�o sua altura dever� ser obtida.
         */

        else if (no.getDireito() == null) {
            return 1 + calcularAltura(no.getEsquerdo());

        }

        /*
         * Se o n� esquerdo existir ent�o sua altura dever� ser obtida.
         */

        else if (no.getEsquerdo() == null) {
            return 1 + calcularAltura(no.getDireito());

        }

        /*
         * Retornar o valor da maior altura dos seus filhos mais um.
         */

        else {
            return 1 + Math.max(calcularAltura(no.getEsquerdo()), calcularAltura(no.getDireito()));
        }

    }

    /**
     * M�todo que calcula o fator de balanceamento de um n�.
     *
     * @param no N� em foco.
     *
     * @return Fator de balanceamento do n�.
     */
    private int fatorBalanceamento(NoAVL<G> no) {

        /*
         * Estabelece, em um primeiro momento, os valores das alturas direita e
         * esquerda.
         */

        if (no.getDireito() == null && no.getEsquerdo() == null) {
            return 0;
        }

        /*
         * Se o n� direito existir ent�o sua altura dever� ser obtida.
         */

        else if (no.getDireito() == null) {
            return -no.getAltura();
        }


        /*
         * Se o n� esquerdo existir ent�o sua altura dever� ser obtida.
         */

        else if (no.getEsquerdo() == null) {
            return no.getAltura();
        }

        /*
         * Retornar a diferen�a entre as alturas direita e esquerda.
         */
        return calcularAltura(no.getDireito()) - calcularAltura(no.getEsquerdo());
    }

    /**
     * M�todo que aplica a rota��o direita em um n�.
     *
     * @param alvo N� alvo da rota��o direita.
     *
     * @return N� reconfigurado ap�s a rota��o.
     */
    private NoAVL<G> rotacaoDireita(NoAVL<G> alvo) {

        /*
         * Aplica��o da rota��o � direita entre o n� alvo e o n� substituto.
         */
        NoAVL<G> substituto = alvo.getEsquerdo();

        /*
         * Atualiza��o da altura do no alvo e do n� substituto.
         */

        alvo.setEsquerdo(substituto.getDireito());
        substituto.setDireito(alvo);

        calcularAltura(alvo);
        calcularAltura(substituto);

        /*
         * Retorno do n� substituto.
         */
        return substituto;
    }

    /**
     * M�todo que aplica a rota��o esquerda em um n�.
     *
     * @param alvo N� alvo da rota��o esquerda.
     *
     * @return N� reconfigurado ap�s a rota��o.
     */
    private NoAVL<G> rotacaoEsquerda(NoAVL<G> alvo) {

        /*
         * Aplica��o da rota��o � esquerda entre o n� alvo e o n� substituto.
         */
        NoAVL<G> substituto = alvo.getDireito();

        /*
         * Atualiza��o da altura do no alvo e do n� substituto.
         */

        alvo.setDireito(substituto.getEsquerdo());
        substituto.setEsquerdo(alvo);

        calcularAltura(alvo);
        calcularAltura(substituto);

        /*
         * Retorno do n� substituto.
         */
        return substituto;
    }

    /**
     * M�todo que verifica as condi��es de balanceamento de uma �rvore a partir de
     * um n� foco e, caso necess�rio, aplica as t�cnicas de balanceamento da �rvore.
     *
     * @param no N� alvo do balanceamento.
     *
     * @return N� reconfigurado ap�s o balanceamento.
     */
    private NoAVL<G> balanceamento(NoAVL<G> no) {

        int fb = this.fatorBalanceamento(no);

        /*
         * Verifica��o do fator de balanceamento:
         *
         * +2 - desbalanceamento � direita, -2 - desbalanceamento � esquerda.
         */
        if (fb == +2) {

            /*
             * Verifica��o do fator de balanceamento do n� direito e aplica��o da rota��o �
             * direita, caso o fator de balanceamento seja negativo.
             */
            if (this.fatorBalanceamento(no.getDireito()) < 0) {

                no.setDireito(rotacaoDireita(no.getDireito()));
            }

            return rotacaoEsquerda(no);

        } else if (fb == -2) {

            /*
             * Verifica��o do fator de balanceamento do n� esquerdo e aplica��o da rota��o �
             * esquerda, caso o fator de balanceamento seja positivo.
             */
            if (this.fatorBalanceamento(no.getEsquerdo()) > 0) {
                no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));

            }

            return rotacaoDireita(no);
        }

        /*
         * Caso n�o haja nenhum desbalanceamento ent�o o n� ser� retornado sem nenhuma
         * altera��o.
         */
        return no;
    }

    /**
     * M�todo que retorna o n� m�ximo a partir de um determinado n� de origem.
     *
     * @param no N� de origem.
     *
     * @return N� m�ximo.
     */
    private NoAVL<G> maximo(NoAVL<G> no) {

        /*
         * Verifica��o e, consequente, indica��o de busca mal sucedida, caso o n� de
         * origem seja nulo.
         */
        if (no == null) {

            return null;
        }

        /*
         * Busca recursiva pelo n� mais � esquerda da �rvore.
         */
        if (no.getDireito() != null) {

            return this.maximo(no.getDireito());
        }

        /*
         * Indica��o do resultado da busca.
         */
        return no;
    }

    /**
     * M�todo que retorna o n� m�nimo a partir de um determinado n� de origem.
     *
     * @param no N� de origem.
     *
     * @return N� m�nimo.
     */
    private NoAVL<G> minimo(NoAVL<G> no) {

        /*
         * Verifica��o e, consequente, indica��o de busca mal sucedida, caso o n� de
         * origem seja nulo.
         */
        if (no == null) {

            return null;
        }

        /*
         * Busca recursiva pelo n� mais � esquerda da �rvore.
         */
        if (no.getEsquerdo() != null) {

            return this.minimo(no.getEsquerdo());
        }

        /*
         * Indica��o do resultado da busca.
         */
        return no;
    }

    /**
     * M�todo que retorna o n� sucessor a partir de um determinado n� de origem.
     *
     * @param no N� de origem.
     *
     * @return N� sucessor.
     */
    private NoAVL<G> sucessor(NoAVL<G> no) {

        /*
         * Verifica��o e, consequente, indica��o de busca mal sucedida, caso o n� de
         * origem seja nulo.
         */
        if (no == null) {

            return null;
        }

        /*
         * Se o n� de origem possuir um filho � direita, ent�o o sucessor ser� o menor
         * valor a sua direita.
         */
        if (no.getDireito() != null) {

            return this.minimo(no.getDireito());
        }

        /*
         * Se o n� de origem n�o possuir um filho � direita, ent�o o sucessor dever� ser
         * procurado em seus ancestrais, com a busca iniciando pelo n� pai.
         */
        NoAVL<G> suc = no.getPai();

        /*
         * Deslocamento at� o n� mais superior do �rvore.
         */
        while (suc != null) {

            /*
             * Se o conte�do do n� sucessor for maior do que ou igual ao do n� de origem,
             * ent�o este ser� o n� sucessor.
             */
            if (suc.getConteudo().compareTo(no.getConteudo()) >= 0) {

                return suc;
            }

            /*
             * Atualiza��o do n� sucessor pelo seu pai.
             */
            suc = suc.getPai();
        }

        /*
         * Indica��o de busca mal sucedida.
         */
        return null;
    }

    /**
     * M�todo que retorna o n� predecessor a partir de um determinado n� de origem.
     *
     * @param no N� de origem.
     *
     * @return N� predecessor.
     */
    private NoAVL<G> predecessor(NoAVL<G> no) {

        /*
         * Verifica��o e, consequente, indica��o de busca mal sucedida, caso o n� de
         * origem seja nulo.
         */
        if (no == null) {

            return null;
        }

        /*
         * Se o n� de origem possuir um filho � esquerda, ent�o o predecessor ser� o
         * maior valor a sua esquerda.
         */
        if (no.getEsquerdo() != null) {

            return this.maximo(no.getEsquerdo());
        }

        /*
         * Se o n� de origem n�o possuir um filho � esquerda, ent�o o predecessor dever�
         * ser procurado em seus ancestrais, com a busca iniciando pelo n� pai.
         */
        NoAVL<G> pre = no.getPai();

        /*
         * Deslocamento at� o n� mais superior do �rvore.
         */
        while (pre != null) {

            /*
             * Se o conte�do do n� predecessor for menor do que o do n� de origem, ent�o
             * este ser� o n� predecessor.
             */
            if (pre.getConteudo().compareTo(no.getConteudo()) < 0) {

                return pre;
            }

            /*
             * Atualiza��o do n� predecessor pelo seu pai.
             */
            pre = pre.getPai();
        }

        /*
         * Indica��o de busca mal sucedida.NoAVL
         */
        return null;
    }
}