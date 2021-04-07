/**
 *
 */
package br.edu.ifs.ed2.dados.lista;

import br.edu.ifs.ed2.dados.no.NoDuplo;

/**
 * Classe que implementa as opera��es de uma lista com encadeamento duplo
 *
 * @author Marlos Tacio Silva
 *
 */
public class ListaDupla<G> implements Lista<G> {

    /**
     * Inicio da lista
     */
    private NoDuplo<G> inicio;

    /**
     * Fim da lista
     */
    private NoDuplo<G> fim;

    /**
     *
     */
    @Override
    public Lista<G> inserirInicio(G conteudo) {

        /*
         * Define um novo n� a ser inserido na lista
         */
        NoDuplo<G> novo = new NoDuplo<G>(conteudo);

        /*
         * Se a lista est� vazia ent�o inserir o novo elemento no in�cio e no fim da
         * lista
         */
        if (this.estaVazia()) {

            return this.setInicio(novo).setFim(novo);
        }

        /*
         * Insere o novo elemento no in�cio da lista
         */
        novo.setPosterior(this.getInicio());

        /*
         * Estabelece o novo elemento como in�cio da lista
         */
        return this.setInicio(novo);
    }

    /**
     *
     */
    @Override
    public Lista<G> inserirFim(G conteudo) {

        /*
         * Define um novo n� a ser inserido na lista
         */
        NoDuplo<G> novo = new NoDuplo<G>(conteudo);

        /*
         * Se a lista est� vazia ent�o inserir o novo elemento no in�cio e no fim da
         * lista
         */
        if (this.estaVazia()) {

            return this.setInicio(novo).setFim(novo);
        }

        /*
         * Insere o novo n� no fim da lista
         */
        novo.setAnterior(this.getFim());

        /*
         * Estabelece o novo elemento como fim da lista
         */
        return this.setFim(novo);
    }

    /**
     *
     */
    @Override
    public boolean remover(G conteudo) {

        NoDuplo<G> aux = this.buscar(conteudo);

        /*
         * Elemento n�o foi encontrado
         */
        if (aux == null) {

            return false;
        }

        /*
         * Se o elemento a ser removido estiver no in�cio da lista
         */
        if (aux.equals(this.getInicio())) {

            return this.removerInicio();
        }

        /*
         * Se o elemento a ser removido estiver no fim da lista
         */
        if (aux.equals(this.getFim())) {

            return this.removerFim();
        }

        /*
         * Se o elemento a ser removido estiver entre o in�cio e o fim da lista
         */
        aux.getAnterior().setPosterior(aux.getPosterior());

        return true;
    }

    /**
     *
     */
    @Override
    public boolean removerInicio() {

        /*
         * Verifica se a lista est� vazia
         */
        if (this.estaVazia()) {

            return false;
        }

        /*
         * Verifica se a lista possui apenas um elemento
         */
        if (this.getInicio().equals(this.getFim())) {

            this.limpar();
            return true;
        }

        /*
         * Estabelece que o novo in�cio da lista ser� o segundo elemento
         */
        this.setInicio(this.getInicio().getPosterior());
        this.getInicio().setAnterior(null);

        return true;

    }

    /**
     *
     */
    @Override
    public boolean removerFim() {

        /*
         * Verifica se a lista est� vazia
         */
        if (this.estaVazia()) {

            return false;
        }

        /*
         * Verifica se a lista possui apenas um elemento
         */
        if (this.getInicio().equals(this.getFim())) {

            this.limpar();
            return true;
        }

        /*
         * Estabelece que o novo fim da lista ser� o pen�ltimo elemento
         */
        this.setFim(this.getFim().getAnterior());
        this.getFim().setPosterior(null);

        return true;
    }

    /**
     *
     */
    @Override
    public NoDuplo<G> buscar(G conteudo) {

        NoDuplo<G> aux = this.getInicio();

        /*
         * Percorre toda a lista em busca do elemento
         */
        while (aux != null) {

            if (aux.getConteudo().equals(conteudo)) {

                return aux;
            }

            aux = aux.getPosterior();
        }

        /*
         * Se o elemento n�o for encontrado
         */
        return null;
    }

    /**
     *
     */
    @Override
    public boolean estaVazia() {

        return this.getInicio() == null && this.getFim() == null;
    }

    /**
     *
     */
    @Override
    public Lista<G> limpar() {

        return this.setInicio(null).setFim(null);
    }

    /**
     * M�todo que retorna uma refer�ncia para o in�cio da lista
     *
     * @return O primeiro elemento da lista
     */
    public NoDuplo<G> getInicio() {

        return this.inicio;
    }

    /**
     * M�todo que altera o in�cio da lista
     *
     * @param inicio Elemento que ser� inserido no in�cio da lista
     *
     * @return Uma refer�ncia para a lista (encadeamento de opera��es)
     */
    private ListaDupla<G> setInicio(NoDuplo<G> inicio) {

        this.inicio = inicio;

        return this;
    }

    /**
     * M�todo que retorna uma refer�ncia para o fim da lista
     *
     * @return O �ltimo elemento da lista
     */
    public NoDuplo<G> getFim() {

        return this.fim;
    }

    /**
     * M�todo que altera o fim da lista
     *
     * @param fim Elemento que ser� inserido no fim da lista
     *
     * @return Uma refer�ncia para a lista (encadeamento de opera��es)
     */
    private ListaDupla<G> setFim(NoDuplo<G> fim) {

        this.fim = fim;

        return this;
    }

    /**
     * M�todo que retorna uma representa��o da lista no formato texto (string)
     */
    @Override
    public String toString() {

        /*
         * Se a lista estiver vazia
         */
        if (this.estaVazia()) {

            return "*";
        }

        NoDuplo<G> aux = this.getInicio();
        StringBuilder s = new StringBuilder().append("* <-> ");

        /*
         * Percorre toda a lista e concatena cada elemento em um string
         */
        while (aux != null) {

            s.append(aux.getConteudo()).append(" <-> ");
            aux = aux.getPosterior();
        }

        return s.append("*").toString();
    }
}
