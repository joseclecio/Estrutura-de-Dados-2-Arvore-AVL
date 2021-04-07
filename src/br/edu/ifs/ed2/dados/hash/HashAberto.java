/**
 *
 */
package br.edu.ifs.ed2.dados.hash;

import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * Classe que estabelece as opera��es de uma tabela de espalhamento com
 * endere�amento aberto.
 *
 * @author Marlos Tacio Silva.
 *
 */
public class HashAberto<G> extends Hash<G> {

    /**
     * Vetor que armazena os elementos da tabela.
     */
    private G tabela[];

    /**
     * Vetor auxiliar que armazena os estados de cada c�lula da tabela de
     * espalhamento: null - Livre; O - Ocupado; R - Removido.
     */
    private String estado[];

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
    public HashAberto(int tamanho, EstrategiaChave<G> chave, EstrategiaEspalhamento<G> espalhamento, EstrategiaColisao<G> colisao) {

        /*
         * Invoca��o do construtor da super classe.
         */
        super(tamanho, chave, espalhamento, colisao);

        /*
         * Inicializa��o dos vetores de estado e conte�do da tabela de espalhamento.
         */
        this.setEstado(new String[tamanho]);
        this.setTabela((G[]) new Object[tamanho]);
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
         * Inser��o do elemento e altera��o do estado para ocupado.
         */
        this.getEstado()[indice] = "O";
        this.getTabela()[indice] = conteudo;

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
        this.getEstado()[indice] = "R";
        this.getTabela()[indice] = null;

        /*
         * Indica��o de remo��o bem sucedida.
         */
        return true;
    }

    /**
     * M�todo que retorna um vetor com os conte�dos da tabela de espalhamento.
     *
     * @return Conte�do da tabela de espalhamento.
     */
    public G[] getTabela() {

        return this.tabela;
    }

    /**
     * M�todo que altera o vetor de elementos da tabela de espalhamento.
     *
     * @param tabela Novo vetor de elementos da tabela.
     */
    private void setTabela(G tabela[]) {

        this.tabela = tabela;
    }

    /**
     * M�todo que retorna um vetor com os estados das c�lulas da tabela de
     * espalhamento: : null - Livre; O - Ocupado; R - Removido.
     *
     * @return Conte�do da tabela de espalhamento.
     */
    public String[] getEstado() {

        return this.estado;
    }

    /**
     * M�todo que altera o vetor de estados da tabela de espalhamento.
     *
     * @param tabela Novo vetor de estados da tabela.
     */
    private void setEstado(String estado[]) {

        this.estado = estado;
    }

    /**
     * M�todo que retorna uma representa��o da tabela no formato texto (string).
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
             * Verifica��o e, consequente, representa��o de c�lula removida.
             */
            if (this.getTabela()[i].equals("R")) {

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
}