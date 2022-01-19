/*
 * The MIT License
 *
 * Copyright 2021 Gustavo.Batista <gustavo.dev97@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package gustavo.projeto.estacionamento.negocio;

import gustavo.projeto.estacionamento.controle.EstacionamentoController;

/**
 * Representa as informaçoes relativas às vagas do estacionamento e status de
 * sua ocupação.
 *
 * @author Gustavo.Batista 
 */
public class Vaga {

    public static int TOTAL_VAGAS = 100;
    private static int vagasOcupadas = inicializarOcupadas();

    /**
     * Verifica se existe alguma vaga livre no estacionamento.
     *
     * @return true se possuir vaga livre e false se estiverem todas ocupadas.
     */
    public static boolean temVagaLivre() {
        return (vagasOcupadas < TOTAL_VAGAS);
    }

    /**
     * Usado para buscar o status atual das vagas do estacionamento
     *
     * @return Vagas do banco de dados mesmo após encerramento do programa
     */
    public static int inicializarOcupadas() {
        EstacionamentoController controle = new EstacionamentoController();
        return controle.inicializarOcupadas();
    }

    /**
     * Retorna o numero de vagas ocupadas no estacionamento
     *
     * @return Numero total de vagas ocupadas no instante
     */
    public static int ocupadas() {
        return Vaga.vagasOcupadas;
    }

    /**
     * Retorna o número de vagas livres do estacionamento
     *
     * @return número de vagas dísponiveis no instante
     */
    public static int livres() {
        return TOTAL_VAGAS - Vaga.vagasOcupadas;
    }

    /**
     * Atualiza o número de vagas ocupadas após a entrada de um veículo
     */
    public static void entrou() {
        Vaga.vagasOcupadas++;
    }

    /**
     * Atualiza o número de vagas ocupadas após a saida de um veículo
     */
    public static void saiu() {
        Vaga.vagasOcupadas--;
    }
}
