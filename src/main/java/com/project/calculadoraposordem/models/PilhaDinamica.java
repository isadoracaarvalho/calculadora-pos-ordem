package com.project.calculadoraposordem.models;

public class PilhaDinamica<T>{

    private No<T> topo;

    // indica se a pilha esta vazia
    public boolean isVazia(){
        return topo == null;
    }

    // empilha um elemento
    public void empilhar(T elemento){
        No<T> no = new No<>(elemento);
        no.setProximo(topo);
        topo = no;
    }

    // desempilha um elemento e retorna
    public T desempilhar(){
        if(isVazia()){
            return null;
        }
        No<T> no = topo;
        topo = topo.getProximo();
        return no.getElemento();
    }

    // retorna o topo sem remover
    public T peek(){
        if(isVazia()){
            return null;
        }
        return topo.getElemento();
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
