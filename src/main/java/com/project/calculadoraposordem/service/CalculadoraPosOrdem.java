package com.project.calculadoraposordem.service;

import com.project.calculadoraposordem.models.FilaDinamica;
import com.project.calculadoraposordem.models.PilhaDinamica;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraPosOrdem {

    FilaDinamica<String> fila = new FilaDinamica<>();
    PilhaDinamica<Double> pilha =  new PilhaDinamica<>();

    public CalculadoraPosOrdem() {
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
