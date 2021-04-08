/**
 *
 */
package br.edu.ifs.ed2.dados.arvore;

import br.edu.ifs.ed2.dados.no.NoAVL;

/**
 * Classe que implementa as operações de uma árvore binária AVL.
 *
 * @author Marlos Tacio Silva.
 *
 */
public class ArvoreAVL<G extends Comparable<G>> {

    /*
     * Atributos -------------------------------------------------------------------
     */

    /**
     * Atributo que contém uma referência para o nó raiz da árvore.
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
     * @param raiz Nó raiz da árvore.
     */
    public ArvoreAVL(NoAVL<G> raiz) {

        this.setRaiz(raiz);
    }

    /*
     * Métodos públicos ------------------------------------------------------------
     */

    /**
     * Método para a inserção de um elemento na árvore binária de busca.
     *
     * @param conteudo Conteúdo a ser inserido.
     *
     * @return Verdadeiro, para inserção bem sucedida, ou falso, caso contrário.
     */
    public boolean inserir(G conteudo) {

        /*
         * Verificação e indicação de inserção mal sucedida, caso o conteúdo seja nulo.
         */
        if (conteudo == null) {

            return false;
        }

        /*
         * Inserção do conteúdo a partir da raiz da árvore.
         */
        this.setRaiz(this.inserir(this.getRaiz(), conteudo));
        return true;
    }

    /**
     * Método para a remoção de um elemento na árvore binária de busca.
     *
     * @param conteudo Conteúdo a ser removido.
     *
     * @return Verdadeiro, para remoção bem sucedida, ou falso, caso contrário.
     */
    public boolean remover(G conteudo) {

        /*
         * Verificação e indicação de remoção mal sucedida, caso o conteúdo seja nulo.
         */
        if (conteudo == null) {

            return false;
        }

        /*
         * Verificação e indicação de elemento não encontrado.
         */
        if (this.buscar(conteudo) == null) {

            return false;
        }

        /*
         * Remoção do elemento a partir da raiz da árvore.
         */
        this.setRaiz(this.remover(this.getRaiz(), conteudo));

        /*
         * Indicação de remoção bem sucedida.
         */
        return true;
    }

    /**
     * Método para a busca de um elemento na árvore binária de busca.
     *
     * @param conteudo Conteúdo a ser buscado.
     *
     * @return Nó encontrado, para busca bem sucedida, ou nulo, caso contrário.
     */
    public NoAVL<G> buscar(G conteudo) {

        /*
         * Verificação e indicação de inserção mal sucedida, caso o conteúdo seja nulo.
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
     * Método que retorna o nó com máximo valor na árvore.
     *
     * @return Nó máximo da árvore.
     */
    public NoAVL<G> maximo() {

        /*
         * Chamada ao método privado máximo passando a raiz como nó de referência.
         */
        return this.maximo(this.getRaiz());
    }

    /**
     * Método que retorna o nó com mínimo valor na árvore.
     *
     * @return Nó mínimo da árvore.
     */
    public NoAVL<G> minimo() {

        /*
         * Chamada ao método privado mínimo passando a raiz como nó de referência.
         */
        return this.minimo(this.getRaiz());
    }

    /**
     * Método que retorna o sucessor de um determinado conteúdo na árvore.
     *
     * @param conteudo Conteúdo em foco.
     *
     * @return O nó sucessor, caso exista, ou nulo, caso contrário.
     */
    public NoAVL<G> sucessor(G conteudo) {

        /*
         * Chamada ao método privado passando o nó resultante da busca como referência.
         */
        return this.sucessor(this.buscar(conteudo));
    }

    /**
     * Método que retorna o predecessor de um determinado conteúdo na árvore.
     *
     * @param conteudo Conteúdo em foco.
     *
     * @return O nó predecessor, caso exista, ou nulo, caso contrário.
     */
    public NoAVL<G> predecessor(G conteudo) {

        /*
         * Chamada ao método privado passando o nó resultante da busca como referência.
         */
        return this.predecessor(this.buscar(conteudo));
    }

    /**
     * Método que efetua a limpeza da árvore binária de busca.
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
     * Método que retorna uma referência para a raíz da árvore.
     *
     * @return A raíz da árvore.
     */
    public NoAVL<G> getRaiz() {

        return this.raiz;
    }

    /**
     * Método que altera o valor da raíz da árvore.
     *
     * @param raiz A nova raíz da árvore.
     */
    private void setRaiz(NoAVL<G> raiz) {

        this.raiz = raiz;
    }

    /*
     * Métodos Sobrescritos --------------------------------------------------------
     */

    /**
     * Método que retorna uma representação da árvore no formato texto (string).
     * Para essa representação é utilizado o método de caminhamento em ordem.
     */
    @Override
    public String toString() {

        if (this.getRaiz() == null) {

            return "";
        }

        return this.getRaiz().toString();
    }

    /*
     * Métodos privados ------------------------------------------------------------
     */

    /**
     * Método recursivo para a inserção de um nó na árvore.
     *
     * @param no       Sub-árvore em foco.
     *
     * @param conteudo Conteúdo a ser inserido.
     *
     * @return Sub-árvore após a inserção do elemento.
     */
    private NoAVL<G> inserir(NoAVL<G> no, G conteudo) {

        /*
         * Verificação de fim de percurso e consequente retorno do novo nó a ser
         * inserido.
         */
        if (no == null) {

            return new NoAVL<G>(conteudo);
        }

        /*
         * Comparação do conteúdo a ser inserido com o conteúdo do nó em foco.
         *
         * Obtém o filho direito, caso o conteúdo a ser inserido seja maior do que ou
         * igual ao do nó em foco, e o filho esquerdo, caso contrário.
         */
        if (conteudo.compareTo(no.getConteudo()) < 0) {

            no.setEsquerdo(this.inserir(no.getEsquerdo(), conteudo));
        } else {

            no.setDireito(this.inserir(no.getDireito(), conteudo));
        }

        /*
         * Atualização da altura e balanceamento do nó em foco após a inserção.
         */
        no.setAltura(this.calcularAltura(no));
        return this.balanceamento(no);
    }

    /**
     * Método recursivo para a busca de um conteúdo na árvore.
     *
     * @param no       Sub-árvore em foco.
     *
     * @param conteudo Conteúdo a ser buscado.
     *
     * @return Nó encontrado, para busca bem sucedida, ou nulo, caso contrário.
     */
    private NoAVL<G> buscar(NoAVL<G> no, G conteudo) {

        /*
         * Verificação de fim de percurso e consequente indicação de busca mal sucedida.
         */
        if (no == null) {

            return null;
        }

        /*
         * Comparação do conteúdo a ser inserido com o conteúdo do nó em foco.
         *
         * Obtém o filho direito, caso o conteúdo a ser inserido seja maior do que o do
         * nó em foco, o filho esquerdo, caso o conteúdo a ser inserido seja menor do
         * que o do nó em foco, e o próprio nó, caso contrário.
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
     * Método para a remoção de um elemento na árvore binária de busca.
     *
     * @param no       Sub-árvore em foco.
     *
     * @param conteudo Conteúdo a ser inserido.
     *
     * @return Sub-árvore após a inserção do elemento.
     */
    private NoAVL<G> remover(NoAVL<G> no, G conteudo) {

        /*
         * Comparação do conteúdo a ser inserido com o conteúdo do nó em foco.
         *
         * Obtém o filho direito, caso o conteúdo a ser inserido seja maior do que o do
         * nó em foco, o filho esquerdo, caso o conteúdo a ser inserido seja menor do
         * que o do nó em foco, e o próprio nó, caso contrário.
         */
        if (conteudo.compareTo(no.getConteudo()) < 0) {

            no.setEsquerdo(this.remover(no.getEsquerdo(), conteudo));
        } else if (conteudo.compareTo(no.getConteudo()) > 0) {

            no.setDireito(this.remover(no.getDireito(), conteudo));
        } else {

            /*
             * Se o nó a ser removido não possuir filho esquerdo, então deverá ser
             * substituído por seu filho direito.
             *
             * Se o nó a ser removido não possuir filho direito, então deverá ser
             * substituído por seu filho esquerdo.
             *
             * Se o nó a ser removido possuir ambos os filhos, então deverá ser substituído
             * por seu sucessor, que deverá ser removido.
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
         * Atualização da altura e balanceamento do nó em foco após a inserção.
         */
        no.setAltura(this.calcularAltura(no));
        return this.balanceamento(no);
    }

    /**
     * Método que calcula a altura de um nó.
     *
     * @param no Nó em foco.
     *
     * @return Altura do nó.
     */
    private int calcularAltura(NoAVL<G> no) {

        /*
         * Se o nó for nulo então sua altura será -1.
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
         * Se o nó direito existir então sua altura deverá ser obtida.
         */

        else if (no.getDireito() == null) {
            return 1 + calcularAltura(no.getEsquerdo());

        }

        /*
         * Se o nó esquerdo existir então sua altura deverá ser obtida.
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
     * Método que calcula o fator de balanceamento de um nó.
     *
     * @param no Nó em foco.
     *
     * @return Fator de balanceamento do nó.
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
         * Se o nó direito existir então sua altura deverá ser obtida.
         */

        else if (no.getDireito() == null) {
            return -no.getAltura();
        }


        /*
         * Se o nó esquerdo existir então sua altura deverá ser obtida.
         */

        else if (no.getEsquerdo() == null) {
            return no.getAltura();
        }

        /*
         * Retornar a diferença entre as alturas direita e esquerda.
         */
        return calcularAltura(no.getDireito()) - calcularAltura(no.getEsquerdo());
    }

    /**
     * Método que aplica a rotação direita em um nó.
     *
     * @param alvo Nó alvo da rotação direita.
     *
     * @return Nó reconfigurado após a rotação.
     */
    private NoAVL<G> rotacaoDireita(NoAVL<G> alvo) {

        /*
         * Aplicação da rotação à direita entre o nó alvo e o nó substituto.
         */
        NoAVL<G> substituto = alvo.getEsquerdo();

        /*
         * Atualização da altura do no alvo e do nó substituto.
         */

        alvo.setEsquerdo(substituto.getDireito());
        substituto.setDireito(alvo);

        calcularAltura(alvo);
        calcularAltura(substituto);

        /*
         * Retorno do nó substituto.
         */
        return substituto;
    }

    /**
     * Método que aplica a rotação esquerda em um nó.
     *
     * @param alvo Nó alvo da rotação esquerda.
     *
     * @return Nó reconfigurado após a rotação.
     */
    private NoAVL<G> rotacaoEsquerda(NoAVL<G> alvo) {

        /*
         * Aplicação da rotação à esquerda entre o nó alvo e o nó substituto.
         */
        NoAVL<G> substituto = alvo.getDireito();

        /*
         * Atualização da altura do no alvo e do nó substituto.
         */

        alvo.setDireito(substituto.getEsquerdo());
        substituto.setEsquerdo(alvo);

        calcularAltura(alvo);
        calcularAltura(substituto);

        /*
         * Retorno do nó substituto.
         */
        return substituto;
    }

    /**
     * Método que verifica as condições de balanceamento de uma árvore a partir de
     * um nó foco e, caso necessário, aplica as técnicas de balanceamento da árvore.
     *
     * @param no Nó alvo do balanceamento.
     *
     * @return Nó reconfigurado após o balanceamento.
     */
    private NoAVL<G> balanceamento(NoAVL<G> no) {

        int fb = this.fatorBalanceamento(no);

        /*
         * Verificação do fator de balanceamento:
         *
         * +2 - desbalanceamento à direita, -2 - desbalanceamento à esquerda.
         */
        if (fb == +2) {

            /*
             * Verificação do fator de balanceamento do nó direito e aplicação da rotação á
             * direita, caso o fator de balanceamento seja negativo.
             */
            if (this.fatorBalanceamento(no.getDireito()) < 0) {

                no.setDireito(rotacaoDireita(no.getDireito()));
            }

            return rotacaoEsquerda(no);

        } else if (fb == -2) {

            /*
             * Verificação do fator de balanceamento do nó esquerdo e aplicação da rotação á
             * esquerda, caso o fator de balanceamento seja positivo.
             */
            if (this.fatorBalanceamento(no.getEsquerdo()) > 0) {
                no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));

            }

            return rotacaoDireita(no);
        }

        /*
         * Caso não haja nenhum desbalanceamento então o nó será retornado sem nenhuma
         * alteração.
         */
        return no;
    }

    /**
     * Método que retorna o nó máximo a partir de um determinado nó de origem.
     *
     * @param no Nó de origem.
     *
     * @return Nó máximo.
     */
    private NoAVL<G> maximo(NoAVL<G> no) {

        /*
         * Verificação e, consequente, indicação de busca mal sucedida, caso o nó de
         * origem seja nulo.
         */
        if (no == null) {

            return null;
        }

        /*
         * Busca recursiva pelo nó mais à esquerda da árvore.
         */
        if (no.getDireito() != null) {

            return this.maximo(no.getDireito());
        }

        /*
         * Indicação do resultado da busca.
         */
        return no;
    }

    /**
     * Método que retorna o nó mínimo a partir de um determinado nó de origem.
     *
     * @param no Nó de origem.
     *
     * @return Nó mínimo.
     */
    private NoAVL<G> minimo(NoAVL<G> no) {

        /*
         * Verificação e, consequente, indicação de busca mal sucedida, caso o nó de
         * origem seja nulo.
         */
        if (no == null) {

            return null;
        }

        /*
         * Busca recursiva pelo nó mais à esquerda da árvore.
         */
        if (no.getEsquerdo() != null) {

            return this.minimo(no.getEsquerdo());
        }

        /*
         * Indicação do resultado da busca.
         */
        return no;
    }

    /**
     * Método que retorna o nó sucessor a partir de um determinado nó de origem.
     *
     * @param no Nó de origem.
     *
     * @return Nó sucessor.
     */
    private NoAVL<G> sucessor(NoAVL<G> no) {

        /*
         * Verificação e, consequente, indicação de busca mal sucedida, caso o nó de
         * origem seja nulo.
         */
        if (no == null) {

            return null;
        }

        /*
         * Se o nó de origem possuir um filho à direita, então o sucessor será o menor
         * valor a sua direita.
         */
        if (no.getDireito() != null) {

            return this.minimo(no.getDireito());
        }

        /*
         * Se o nó de origem não possuir um filho á direita, então o sucessor deverá ser
         * procurado em seus ancestrais, com a busca iniciando pelo nó pai.
         */
        NoAVL<G> suc = no.getPai();

        /*
         * Deslocamento até o nó mais superior do árvore.
         */
        while (suc != null) {

            /*
             * Se o conteúdo do nó sucessor for maior do que ou igual ao do nó de origem,
             * então este será o nó sucessor.
             */
            if (suc.getConteudo().compareTo(no.getConteudo()) >= 0) {

                return suc;
            }

            /*
             * Atualização do nó sucessor pelo seu pai.
             */
            suc = suc.getPai();
        }

        /*
         * Indicação de busca mal sucedida.
         */
        return null;
    }

    /**
     * Método que retorna o nó predecessor a partir de um determinado nó de origem.
     *
     * @param no Nó de origem.
     *
     * @return Nó predecessor.
     */
    private NoAVL<G> predecessor(NoAVL<G> no) {

        /*
         * Verificação e, consequente, indicação de busca mal sucedida, caso o nó de
         * origem seja nulo.
         */
        if (no == null) {

            return null;
        }

        /*
         * Se o nó de origem possuir um filho à esquerda, então o predecessor será o
         * maior valor a sua esquerda.
         */
        if (no.getEsquerdo() != null) {

            return this.maximo(no.getEsquerdo());
        }

        /*
         * Se o nó de origem não possuir um filho á esquerda, então o predecessor deverá
         * ser procurado em seus ancestrais, com a busca iniciando pelo nó pai.
         */
        NoAVL<G> pre = no.getPai();

        /*
         * Deslocamento até o nó mais superior do árvore.
         */
        while (pre != null) {

            /*
             * Se o conteúdo do nó predecessor for menor do que o do nó de origem, então
             * este será o nó predecessor.
             */
            if (pre.getConteudo().compareTo(no.getConteudo()) < 0) {

                return pre;
            }

            /*
             * Atualização do nó predecessor pelo seu pai.
             */
            pre = pre.getPai();
        }

        /*
         * Indicação de busca mal sucedida.NoAVL
         */
        return null;
    }
}