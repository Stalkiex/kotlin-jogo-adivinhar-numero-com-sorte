package jogoAdivinhar

//Treino com Jogo (Range, Listas, etc) - Adivinhar um número entre extremos - Número com sorte


// Calcula a distância percentual entre o palpite e o número real
fun calcularPercentagemAproximacao(valor: Int, limInf: Double, limSup: Double): Pair<Double, Double> {
    val intervalo = limSup - limInf
    val distInf = valor - limInf
    val distSup = limSup - valor
    return Pair((distInf / intervalo) * 100, (distSup / intervalo) * 100)
}

// Transforma o número calculado numa dica de texto
fun transformarPercentagemFrase(percentagem: Double): String {
    return when {
        percentagem in 0.0..10.0 -> "Muito perto"
        percentagem in 11.0..50.0 -> "Longe"
        else -> "Estás na lua"
    }
}


// Cria a lista com base no início, fim e no salto ("step")
fun preencheLista(limiteInicial: Int, limiteFinal: Int, valorSalto: Int): MutableList<Int> {
    val listagem: MutableList<Int> = mutableListOf()
    for (i in limiteInicial..limiteFinal step valorSalto) {
        listagem.add(i)
    }
    return listagem
}


// Escolhe aleatoriamente um número da lista que foi criada
fun sortearPosicao(listagem: MutableList<Int>): Int {
    return if (listagem.isNotEmpty()) listagem.random() else 0
}



// FASE A: O objetivo é cercar o número num intervalo
fun executarFaseA(numeroSorteado: Int): Int {
    var pontos = 100
    println("\n--- FASE A: ADIVINHA O INTERVALO ---")
    while (true) {
        print("Sugere o limite inferior: ")
        val inf = readln().toIntOrNull() ?: 0
        print("Sugere o limite superior: ")
        val sup = readln().toIntOrNull() ?: 0

        if (numeroSorteado in inf..sup) {
            println("Sucesso! O número está dentro desse intervalo.")
            return pontos
        } else {
            pontos--
            val dica = if (numeroSorteado < inf) "à esquerda" else "à direita"
            println("Falhaste! O número está $dica do teu intervalo. Pontos: $pontos")
        }
    }
}

// FASE B: O objetivo é adivinhar o valor do salto original
fun executarFaseB(saltoReal: Int): Int {
    var pontos = 20
    println("\n--- FASE B: ADIVINHA O SALTO ---")
    while (pontos > 0) {
        print("Qual foi o salto usado? ")
        val palpite = readln().toIntOrNull() ?: 0
        if (palpite == saltoReal) return pontos
        pontos--
        println("Errado! Pontos: $pontos")
    }
    return 0
}







// FASE C: O objetivo é o número exato, com dicas de "Quente ou Frio"
fun executarFaseC(numeroSorteado: Int, limiteMin: Int, limiteMax: Int): Int {
    var pontos = 20
    println("\n--- FASE C: O NÚMERO COM SORTE ---")
    while (pontos > 0) {
        print("Qual é o número com sorte? ")
        val palpite = readln().toIntOrNull() ?: 0

        if (palpite == numeroSorteado) return pontos

        pontos -= 2
        // Cálculo da distância 
        val dist = Math.abs(numeroSorteado - palpite).toDouble()
        val amplitude = (limiteMax - limiteMin).toDouble()
        val frase = transformarPercentagemFrase((dist / amplitude) * 100)
        println("Erraste! Estás: $frase. Pontos: $pontos")
    }
    return 0
}



fun main() {
    // Entradas do Utilizador
    println("     CONFIGURAÇÃO DO JOGO     ")
    print("Limite inicial: ")
    val de = readln().toIntOrNull() ?: 1
    print("Limite final: ")
    val ate = readln().toIntOrNull() ?: 10
    print("Valor do salto: ")
    val passo = readln().toIntOrNull() ?: 1

    // Preparação
    val listagemReal = preencheLista(de, ate, passo)
    val numeroComSorte = sortearPosicao(listagemReal)

    // Limpar o ecrã
    repeat(50) { println() }

    // Execução das Fases
    if (numeroComSorte != 0) {
        val pontosA = executarFaseA(numeroComSorte)
        val pontosB = executarFaseB(passo)
        val pontosC = executarFaseC(numeroComSorte, de, ate)

        // Resultado Final
        println("\n      FIM DE JOGO      ")
        println("Pontuação Total: ${pontosA + pontosB + pontosC}")
        println("O número secreto era: $numeroComSorte")
    } else {
        println("Erro ao gerar a lista de jogo.")
    }
}


