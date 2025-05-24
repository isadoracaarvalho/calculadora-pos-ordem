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

    public boolean isNumeric(String elemento) {
        try {
            Double.parseDouble(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double calcularPosOrdem(){
        while(!fila.isVazia()){
            String elemento = fila.dequeue();
            if (isNumeric(elemento)) {
                pilha.empilhar(Double.parseDouble(elemento));
            } else {
                Double elemento1 = pilha.desempilhar();
                Double elemento2 = pilha.desempilhar();
                switch (elemento) {
                    case "+":
                        pilha.empilhar(elemento2 + elemento1);
                        break;
                    case "-":
                        pilha.empilhar(elemento2 - elemento1);
                        break;
                    case "*":
                        pilha.empilhar(elemento2 * elemento1);
                        break;
                    case "/":
                        pilha.empilhar(elemento2 / elemento1);
                        break;
                    case "%":
                        pilha.empilhar(elemento2 % elemento1);
                        break;
                    default:
                        // aqui vamos puxar o erro de operador inválido
                }
            }
        }
        return pilha.desempilhar();
    }
}