package com.project.calculadoraposordem.service;

import com.project.calculadoraposordem.models.FilaDinamica;
import com.project.calculadoraposordem.models.PilhaDinamica;

public class CalculadoraPosOrdem {

    FilaDinamica<String> fila;
    PilhaDinamica<Double> pilha;

    public CalculadoraPosOrdem(FilaDinamica<String> fila, PilhaDinamica<Double> pilha) {
        this.fila = fila;
        this.pilha = pilha;
    }

    public void inserirExpressao(String expressao) {
        String[] elementos = expressao.split(" ");
        for (String e : elementos) {
            fila.enqueue(e);
        }
    }

    public double calcularPosOrdem(){
        while(!fila.isVazia()){
            String elemento = fila.dequeue();
            if (!elemento.equals("+") && !elemento.equals("-") && !elemento.equals("*") && !elemento.equals("/") && !elemento.equals("%")) {
                pilha.empilhar(Double.parseDouble(elemento));
            } else if (elemento.equals("+")) {
                Double elemento1 = pilha.desempilhar();
                Double elemento2 = pilha.desempilhar();
                pilha.empilhar(elemento2 + elemento1);
            } else if (elemento.equals("-")) {
                Double elemento1 = pilha.desempilhar();
                Double elemento2 = pilha.desempilhar();
                pilha.empilhar(elemento2 - elemento1);
            } else if (elemento.equals("*")) {
                Double elemento1 = pilha.desempilhar();
                Double elemento2 = pilha.desempilhar();
                pilha.empilhar(elemento1 * elemento2);
            } else if (elemento.equals("/")){
                Double elemento1 = pilha.desempilhar();
                Double elemento2 = pilha.desempilhar();
                pilha.empilhar(elemento2 / elemento1);
            } else if (elemento.equals("%")) {
                Double elemento1 = pilha.desempilhar();
                Double elemento2 = pilha.desempilhar();
                pilha.empilhar(elemento2 % elemento1);
            }
        }
        return pilha.desempilhar();
    }

}
