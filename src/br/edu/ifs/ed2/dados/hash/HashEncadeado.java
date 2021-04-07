/**
 *
 */
package br.edu.ifs.ed2.dados.hash;

import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;
import br.edu.ifs.ed2.dados.lista.Lista;
import br.edu.ifs.ed2.dados.lista.ListaDupla;

/**
 *
 * @author Marlos Tacio Silva
 *
 */
public class HashEncadeado<G> extends Hash<G> {

    /**
     * Vetor que armazena os elementos da tabela.
     */
    private Lista<G> tabela[];

    /**
     * Construtor da classe.
     *
     * @param tamanho      Tamanho da tabela de espalhamento.
     *
     * @param chave        Estrat�gia para a constru��o de chaves.
     *
     * @param espalhamento Estrat�gia para a fun��o de espalhamento.
     *
     * @param colisao      Estrat�gia para o tratamento de colis�es.
     */
    @SuppressWarnings("unchecked")
    public HashEncadeado(int tamanho, EstrategiaChave<G> chave, EstrategiaEspalhamento<G> espalhamento, EstrategiaColisao<G> colisao) {

        /*
         * Invoca��o do construtor da super classe.
         */
        super(tamanho, chave, espalhamento, colisao);

        /*
         * Inicializa��o da tabela de espalhamento.
         */
        this.setTabela((Lista<G>[]) new Lista<?>[tamanho]);
    }

    /**
     *
     */
    @Override
    protected boolean finalizarInsercao(int indice, G conteudo) {

        /*
         * Verifica��o e, consequente, indica��o de inser��o mal sucedida.
         */
        if (indice < 0) {

            return false;
        }

        /*
         * Verifica��o e, consequente, inicializa��o da lista, caso seja nula.
         */
        if (this.getTabela()[indice] == null) {

            this.getTabela()[indice] = new ListaDupla<G>();
        }

        /*
         * Inser��o do elemento na lista.
         */
        this.getTabela()[indice].inserirFim(conteudo);

        /*
         * Indica��o de inser��o bem sucedida.
         */
        return true;
    }

    /**
     *
     */
    @Override
    protected boolean finalizarRemocao(int indice, G conteudo) {

        /*
         * Verifica��o e, consequente, indica��o de remo��o mal sucedida.
         */
        if (indice < 0) {

            return false;
        }

        /*
         * Remo��o do elemento e altera��o do estado para removido.
         */
        this.getTabela()[indice].remover(conteudo);

        /*
         * Indica��o de remo��o bem sucedida.
         */
        return true;
    }

    /**
     *
     */
    @Override
    public String toString() {

        /*
         * Inicializa��o de uma estrutura para constru��o da string.
         */
        StringBuilder s = new StringBuilder();

        /*
         * Varredura das c�lulas da tabela de espalhamento.
         */
        for (int i = 0; i < this.getTamanho(); ++i) {

            /*
             * Verifica��o e, consequente, representa��o de c�lula vazia.
             */
            if (this.getTabela()[i] == null) {

                s.append("-").append("\n");
                continue;
            }

            /*
             * Representa��o de c�lula ocupada.
             */
            s.append(this.getTabela()[i]).append("\n");
        }

        /*
         * Retorno da string que representa a tabela.
         */
        return s.toString();
    }

    /**
     * @return the tabela
     */
    public Lista<G>[] getTabela() {

        return this.tabela;
    }

    /**
     * @param tabela the tabela to set
     */
    public void setTabela(Lista<G> tabela[]) {

        this.tabela = tabela;
    }
}