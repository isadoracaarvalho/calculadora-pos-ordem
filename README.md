# 📟 Calculadora Pós-Ordem

Este projeto é uma aplicação web desenvolvida em Java com Spring Boot que permite realizar cálculos de expressões matemáticas na notação pós-ordem (notação polonesa reversa - NPR), utilizando conceitos de estrutura de dados, como pilha e fila dinâmica.

O projeto foi desenvolvido como parte da disciplina de Estrutura de Dados, com o objetivo de aplicar na prática conceitos fundamentais da programação e organização de dados.

## 🔧 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Thymeleaf
- HTML, CSS

## 🏁 Como Executar

1. Clone o repositório: ```git clone https://github.com/seu-usuario/calculadora-pos-ordem.git```
3. Navegue até o diretório: ```./mvnw spring-boot:run```
4. Execute a aplicação: ```cd calculadora-pos-ordem```

ou rodando na sua IDE.

4. Acesse no navegador: http://localhost:8080/

## ✅ Exemplos de Entradas Válidas

| Expressão | Descrição | Resultado |
|------------|-----------|-----------|
| `3 4 +` | Soma de 3 e 4 | 7 |
| `10 2 /` | 10 dividido por 2 | 5 |
| `5 1 2 + 4 * + 3 -` | (5 + ((1 + 2) * 4) - 3) | 14 |
| `7 2 - 3 *` | (7 - 2) * 3 | 15 |
| `8 2 5 * + 1 3 2 * + 4 - /` | ((8 + (2 * 5)) / (1 + (3 * 2) - 4)) | 6 |

## 🚫 Exemplos de Falhas e Tratamentos

| Entrada | Erro | Mensagem |
|---------|------|----------|
| `10 0 /` | Divisão (resto divisão) por zero | Erro: Divisão por zero. |
| `4 5 $` | Operador inválido | Expressão inválida: Operador desconhecido '$'. |
| `2 +` | Operação mal formada | Expressão inválida: quantidade de elementos insuficientes. |
| `5 5 + +` | Operador excedente | Expressão inválida: quantidade de elementos insuficientes. |
| (vazio) | Entrada vazia | Erro: A entrada não pode ser vazia. |

## 📜 Regras para Uso Correto

- ✅ Sempre separe números e operadores com **espaço**.
- ✅ Utilize apenas os operadores: **+ - * /**
- ❌ Não utilize parênteses ou vírgulas.
- ✅ Suporta números inteiros e decimais (ex.: `5.5 2 +`).

## 🙋‍♀️ Desenvolvido por
- Isadora Carvalho
- Udimile Macedo
  
Curso de Engenharia de Software – Universidade Católica do Salvador (UCSal)

