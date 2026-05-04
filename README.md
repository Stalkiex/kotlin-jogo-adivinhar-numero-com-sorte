# Jogo para Adivinhar: O Número com Sorte

Um jogo de consola interativo desenvolvido em *Kotlin* que desafia a lógica e intuição matemática. O jogo gera uma lista de números com base em parâmetros definidos pelo utilizador e escolhe um "Número com Sorte" secreto. O objetivo é descobrir qual é esse número através de três fases de dedução!

## Como Funciona:

O jogo está dividido na configuração inicial e em três fases de adivinhação, com um sistema de pontuação que penaliza os erros.

### Configuração Inicial:
O jogador (ou o "Game Master") define as regras do jogo introduzindo:
* O limite inicial da lista.
* O limite final da lista.
* O valor do salto (step).
* *O ecrã é limpo para esconder as configurações antes do jogo começar.*

### Fase A: Adivinha o Intervalo (100 Pontos)
O objetivo não é adivinhar logo o número, mas sim "cercá-lo".
* Sugere um limite inferior e superior.
* Recebe dicas de orientação (se o número está "à esquerda" ou "à direita").
* Perde-se 1 ponto por cada tentativa falhada.

### Fase B: Adivinha o Salto (20 Pontos)
* Descobre qual foi o salto (step) utilizado na configuração inicial para construir a lista de números.
* -se 1 ponto por cada palpite errado.

### Fase C: O Número com Sorte (20 Pontos)
A derradeira fase! Aqui tem de se adivinhar o número exato.
* Usa um sistema de dicas estilo "Quente ou Frio" baseado na distância.
* As dicas variam entre: "Muito perto", "Longe" ou "Estás na lua".
* Perde-se 2 pontos por cada palpite errado.

## Fim do Jogo:
No final, o jogo revela o número secreto e apresenta a *Pontuação Total*, que é a soma dos pontos que foram mantidos ao longo das três fases.

## Necessário para fazer:
- Kotlin (Lógica de programação, manipulação de listas, range, funções, e loops).

## Como Executar:
Basta clonar este repositório, abri-lo numa IDE que suporte Kotlin (como o IntelliJ IDEA) e correr o ficheiro "Main.kt".
