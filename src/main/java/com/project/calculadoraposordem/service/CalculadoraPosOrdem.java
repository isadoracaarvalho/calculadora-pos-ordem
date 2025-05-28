package com.project.calculadoraposordem.service;

import com.project.calculadoraposordem.exceptions.DivisaoPorZeroException;
import com.project.calculadoraposordem.exceptions.ExpressaoInvalidaException;
import com.project.calculadoraposordem.models.FilaDinamica;
import com.project.calculadoraposordem.models.PilhaDinamica;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

@Service
public class CalculadoraPosOrdem {



    public CalculadoraPosOrdem() {
    }


    public boolean isNumeric(String elemento) {
        try {
            Double.parseDouble(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%");
    }

    public double calcular(String expressao) {
        FilaDinamica<String> fila = new FilaDinamica<>();
        PilhaDinamica<Double> pilha = new PilhaDinamica<>();

        if (expressao == null || expressao.trim().isEmpty()) {
            throw new ExpressaoInvalidaException("Expressão não pode ser vazia ou nula.");
        }

        String[] elementos = expressao.split("\\s+");
        if (elementos.length == 0 || (elementos.length == 1 && elementos[0].trim().isEmpty())) {
            throw new ExpressaoInvalidaException("Expressão não pode ser vazia ou nula.");
        }

        for (String e : elementos) {
            if (!e.isEmpty()) {
                fila.enqueue(e);
            }
        }

        while (!fila.isVazia()) {
            String elemento;
            try {
                elemento = fila.dequeue();
            } catch (NoSuchElementException e) {
                throw new ExpressaoInvalidaException("Erro inesperado ao ler elementos da expressão");
            }

            if (isNumeric(elemento)) {
                pilha.empilhar(Double.parseDouble(elemento));
            } else if (isOperator(elemento)) {
                if (pilha.getTamanho() < 2) {
                    throw new ExpressaoInvalidaException("Expressão inválida: Operação '" + elemento + "' sem elementos suficientes.");
                }
                Double operando1;
                Double operando2;

                try {
                    operando1 = pilha.desempilhar();
                    operando2 = pilha.desempilhar();
                } catch (EmptyStackException e) {
                    throw new ExpressaoInvalidaException("Expressão inválida: Operação '" + elemento + "' sem elementos suficientes.");
                }

                double resultadoOperacao;

                switch (elemento) {
                    case "+":
                        resultadoOperacao = operando2 + operando1;
                        break;
                    case "-":
                        resultadoOperacao = operando2 - operando1;
                        break;
                    case "*":
                        resultadoOperacao = operando2 * operando1;
                        break;
                    case "/":
                        if (operando1 == 0) {
                            throw new DivisaoPorZeroException("Erro: Divisão por zero.");
                        }
                        resultadoOperacao = operando2 / operando1;
                        break;
                    case "%":
                        if (operando1 == 0) {
                            throw new DivisaoPorZeroException("Erro: Resto da divisão por zero.");
                        }
                        resultadoOperacao = operando2 % operando1;
                        break;
                    default:
                        throw new ExpressaoInvalidaException("Expressão inválida: Operador desconhecido '" + elemento + "'.");
                }
                pilha.empilhar(resultadoOperacao);
            } else {
                throw new ExpressaoInvalidaException("Expressão inválida: Caractere ou token desconhecido '" + elemento + "'.");
            }
        }

        if (pilha.isVazia()) {
            throw new ExpressaoInvalidaException("Expressão inválida: Nenhum resultado final na pilha. Refaça a operação.");
        }
        if (pilha.getTamanho() > 1) {
            throw new ExpressaoInvalidaException("Expressão inválida: Quantidade de elementos excedentes.");
        }

        try {
            return pilha.desempilhar();
        } catch (EmptyStackException e) {
            throw new ExpressaoInvalidaException("Erro inesperado ao obter o resultado final da pilha.");
        }
    }
}