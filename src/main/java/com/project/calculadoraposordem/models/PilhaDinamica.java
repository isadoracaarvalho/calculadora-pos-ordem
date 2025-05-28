package com.project.calculadoraposordem.models;

import java.util.EmptyStackException;

public class PilhaDinamica<T>{

    private No<T> topo;
    private int tamanho;

    public PilhaDinamica() {
        this.tamanho = 0;
    }

    // indica se a pilha esta vazia
    public boolean isVazia(){
        return topo == null;
    }

    // empilha um elemento
    public void empilhar(T elemento){
        No<T> no = new No<>(elemento);
        no.setProximo(topo);
        topo = no;
        tamanho++;
    }

    // desempilha um elemento e retorna
    public T desempilhar(){
        if(isVazia()){
            throw new EmptyStackException();
        }
        No<T> no = topo;
        topo = topo.getProximo();
        tamanho--;
        return no.getElemento();
    }

    // retorna o topo sem remover
    public T peek(){
        if(isVazia()){
            throw new EmptyStackException();
        }
        return topo.getElemento();
    }

    public int getTamanho() {
        return tamanho;
    }

    // imprime os elementos da pilha
    public void imprimeElementos(){
        if(isVazia()){
            System.out.println("Pilha Vazia");
        }
        No<T> no = topo;
        while(no != null){
            System.out.println(no.getElemento());
            no = no.getProximo();
        }
    }
}
