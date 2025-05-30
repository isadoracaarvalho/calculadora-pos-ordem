package com.project.calculadoraposordem.models;

import java.util.NoSuchElementException;

public class FilaDinamica<T>{

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    // indica se a fila esta vazia
    public boolean isVazia(){
        return inicio == null;
    }

    // enfileira um elemento
    public void enqueue(T elemento){
        No<T> no = new No<>(elemento);
        if(isVazia()) {
            inicio = no;
        } else {
            fim.proximo = no;
        }
        fim = no;
        tamanho++;
    }

    // desenfileira um elemento
    public T dequeue(){
        if(isVazia()){
            throw new NoSuchElementException("A fila está vazia");
        }
        T removido = inicio.elemento;
        inicio = inicio.proximo;
        tamanho--;
        return removido;
    }

    public int getTamanho() {
        return tamanho;
    }

    // imprime os elementos da fila
    public void imprimeElementos(){
        if(isVazia()){
            System.out.println("Fila Vazia");
        }

        No<T> no = inicio;
        while(no != null){
            System.out.println(no.elemento);
            no = no.proximo;
        }
    }
}
