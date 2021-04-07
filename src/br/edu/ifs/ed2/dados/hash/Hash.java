/**
 *
 */
package br.edu.ifs.ed2.dados.hash;

import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * Classe abstrata que estabelece as opera��es de uma tabela de espalhamento.
 *
 * @author Marlos Tacio Silva.
 *
 */
public abstract class Hash<G> {

    /**
     * Tamanho da tabela de espalhamento.
     */
    private int tamanho;

    /**
     * Estrat�gia para a constru��o das chaves de cada conte�do.
     */
    private EstrategiaChave<G> chave;

    /**
     * Estrat�gia para o tratamento de colis�es.
     */
    private EstrategiaColisao<G> colisao;

    /**
     * Estrat�gia para o c�lculo da fun��o de espalhamento.
     */
    private EstrategiaEspalhamento<G> espalhamento;

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
    public Hash(int tamanho, EstrategiaChave<G> chave, EstrategiaEspalhamento<G> espalhamento, EstrategiaColisao<G> colisao) {

        /*
         * Estabelecimento do tamanho da tabela.
         */
        this.setTamanho(tamanho);

        /*
         * Estabelecimento das estrat�gias de constru��o da chave, fun��o de
         * espalhamento e tratamento de colis�es.
         */
        this.setChave(chave);
        this.setColisao(colisao);
        this.setEspalhamento(espalhamento);
    }

    /**
     * M�todo para a inser��o de um elemento na tabela de espalhamento. Tal m�todo
     * diz respeito a fase final do processo de inser��o de elementos de uma tabela
     * de espalhamento. Essa fase deve ser implementada nas classes concretas, haja
     * vista que depende da estrutura de endere�amento da tabela de espalhamento
     * (e.g., endere�amento aberto, endere�amento encadeado).
     *
     * @param indice   Endere�o em que o conte�do ser� inserido.
     *
     * @param conteudo Conte�do a ser inserido na tabela.
     *
     * @return Verdadeiro, em caso de inser��o bem sucedida, ou Falso, em caso de
     *         inser��o mal sucedida.
     */
    protected abstract boolean finalizarInsercao(int indice, G conteudo);

    /**
     * M�todo para a remo��o de um elemento na tabela de espalhamento. Tal m�todo
     * diz respeito a fase final do processo de remo��o de elementos de uma tabela
     * de espalhamento. Essa fase deve ser implementada nas classes concretas, haja
     * vista que depende da estrutura de endere�amento da tabela de espalhamento
     * (e.g., endere�amento aberto, endere�amento encadeado).
     *
     * @param indice   Endere�o do conte�do a ser removido.
     *
     * @param conteudo Conte�do a ser removido na tabela.
     *
     * @return Verdadeiro, em caso de remo��o bem sucedida, ou Falso, em caso de
     *         remo��o mal sucedida.
     */
    protected abstract boolean finalizarRemocao(int indice, G conteudo);

    /**
     * M�todo para a inser��o de um elemento na tabela de espalhamento.
     *
     * @param conteudo Conte�do a ser inserido na tabela.
     *
     * @return Verdadeiro, em caso de inser��o bem sucedida, ou Falso, em caso de
     *         inser��o mal sucedida.
     */
    public boolean inserir(G conteudo) {

        /*
         * Constru��o da chave a partir do conte�do a ser inserido.
         */
        int chave = this.getChave().gerarChave(conteudo);

        /*
         * C�lculo do �ndice inicial em que o conte�do ser� inserido.
         */
        int indice = this.getEspalhamento().calcularIndice(chave, this.getTamanho());

        /*
         * C�lculo do �ndice final com base em eventuais colis�es.
         */
        int indiceFinal = this.getColisao().obterIndice(indice, this);

        /*
         * Inser��o do elemento na tabela de espalhamento.
         */
        return this.finalizarInsercao(indiceFinal, conteudo);

    }

    /**
     * M�todo para a busca de um elemento na tabela de espalhamento.
     *
     * @param conteudo Conte�do a ser buscado na tabela.
     *
     * @return �ndice da tabela em que o conte�do est� inserido, em caso de busca
     *         bem sucedida, ou -1, em caso de busca mal sucedida.
     */
    public int buscar(G conteudo) {

        /*
         * Constru��o da chave a partir do conte�do a ser buscado.
         */
        int chave = this.getChave().gerarChave(conteudo);

        /*
         * C�lculo do �ndice inicial do conte�do a ser buscado.
         */
        int indice = this.getEspalhamento().calcularIndice(chave, this.getTamanho());

        /*
         * Obten��o do �ndice final com base em eventuais colis�es.
         */
        return this.getColisao().obterIndice(indice, this, conteudo);
    }

    /**
     * M�todo para a remo��o de um elemento na tabela de espalhamento.
     *
     * @param conteudo Conte�do a ser removido da tabela.
     *
     * @return Verdadeiro, em caso de remo��o bem sucedida, ou Falso, em caso de
     *         remo��o mal sucedida.
     */
    public boolean remover(G conteudo) {

        /*
         * Obten��o do �ndice do conte�do.
         */
        int indice = this.buscar(conteudo);

        /*
         * Remo��o do elemento na tabela de espalhamento.
         */
        return this.finalizarRemocao(indice, conteudo);
    }

    /**
     * M�todo que retorna o tamanho da tabela.
     *
     * @return Tamanho da tabela.
     */
    public int getTamanho() {

        return this.tamanho;
    }

    /**
     * M�todo que altera o tamanho da tabela.
     *
     * @param tamanho Novo valor para o tamanho da tabela.
     */
    protected void setTamanho(int tamanho) {

        this.tamanho = tamanho;
    }

    /**
     * M�todo que retorna a estrat�gia de constru��o de chaves.
     *
     * @return Estrat�gia de constru��o de chaves.
     */
    public EstrategiaChave<G> getChave() {

        return this.chave;
    }

    /**
     * M�todo que altera a estrat�gia de constru��o de chaves.
     *
     * @param chave Nova estrat�gia de constru��o de chaves.
     */
    protected void setChave(EstrategiaChave<G> chave) {

        this.chave = chave;
    }

    /**
     * M�todo que retorna a estrat�gia de tratamento de colis�es.
     *
     * @return Estrat�gia de tratamento de colis�es.
     */
    public EstrategiaColisao<G> getColisao() {

        return this.colisao;
    }

    /**
     * M�todo que altera a estrat�gia de tratamento de colis�es.
     *
     * @param colisao Nova estrat�gia de tratamento de colis�es.
     */
    protected void setColisao(EstrategiaColisao<G> colisao) {

        this.colisao = colisao;
    }

    /**
     * M�todo que retorna a estrat�gia de espalhamento dos elementos na tabela.
     *
     * @return Estrat�gia de espalhamento dos elementos.
     */
    public EstrategiaEspalhamento<G> getEspalhamento() {

        return this.espalhamento;
    }

    /**
     * M�todo que altera a estrat�gia de espalhamento dos elementos na tabela.
     *
     * @param espalhamento Nova estrat�gia de espalhamento dos elementos.
     */
    protected void setEspalhamento(EstrategiaEspalhamento<G> espalhamento) {

        this.espalhamento = espalhamento;
    }
}
