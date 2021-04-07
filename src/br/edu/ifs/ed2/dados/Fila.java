/**
 *
 */
package br.edu.ifs.ed2.dados;

import br.edu.ifs.ed2.dados.lista.ListaDupla;
import br.edu.ifs.ed2.dados.no.NoDuplo;

/**
 * Classe que implementa as opera��es de uma fila
 *
 * @author Marlos Tacio Silva
 *
 */
public class Fila<G> {

    /**
     * Lista duplamente encadeada para a implementa��o das opera��es da fila
     */
    private ListaDupla<G> lista;

    /**
     * Construtor que inicializa os atributos da classe
     */
    public Fila() {

        /*
         * Inicializa��o da lista
         */
        this.setLista(new ListaDupla<G>());
    }

    /**
     * M�todo para a inser��o de um elemento na fila
     *
     * @param conteudo Conte�do a ser inserido na fila
     *
     * @return Uma refer�ncia para a fila (encadeamento de opera��es)
     */
    public Fila<G> inserir(G conteudo) {

        /*
         * Inser��o do elemento no fim da lista
         */
        this.getLista().inserirFim(conteudo);

        return this;
    }

    /**
     * M�todo para a obten��o do primeiro elemento da fila
     *
     * @return Uma refer�ncia para o inicio da fila em caso de lista n�o vazia e
     *         nulo caso contr�rio
     */
    public G obterInicio() {

        /*
         * Verifica se a lista est� vazia
         */
        if (this.lista.estaVazia()) {

            return null;
        }

        /*
         * Retorna o �ltimo elemento da lista
         */
        return this.getLista().getInicio().getConteudo();
    }

    /**
     * M�todo para a remo��o de um elemento da fila
     *
     * @return Verdadeiro em caso de remo��o bem sucedida e falso caso contr�rio
     */
    public boolean remover() {

        /*
         * Remover o elemento do inicio da lista
         */
        return this.getLista().removerInicio();
    }

    /**
     * M�todo que remove todos os elementos da fila
     *
     * @return Uma refer�ncia para a fila (encadeamento de opera��es)
     */
    public Fila<G> limpar() {

        /*
         * Limpa a lista
         */
        this.lista.limpar();

        return this;
    }

    /**
     * M�todo que retorna uma representa��o da fila no formato texto (string)
     */
    @Override
    public String toString() {

        NoDuplo<G> aux = this.lista.getInicio();
        StringBuilder s = new StringBuilder();

        /*
         * Percorre toda a lista e concatena cada elemento em um string
         */
        while (aux != null) {

            s.append(aux.getConteudo()).append(" -> ");
            aux = aux.getPosterior();
        }

        return s.append("*").toString();
    }

    /**
     * M�todo que retorna uma refer�ncia para a lista encadeada
     *
     * @return Refer�ncia para a lista encadeada
     */
    private ListaDupla<G> getLista() {

        return this.lista;
    }

    /**
     * M�todo que altera a lista encadeada
     *
     * @param lista Lista a ser inserida
     *
     * @return Uma refer�ncia para a fila (encadeamento de opera��es)
     */
    private Fila<G> setLista(ListaDupla<G> lista) {

        this.lista = lista;

        return this;
    }
}
