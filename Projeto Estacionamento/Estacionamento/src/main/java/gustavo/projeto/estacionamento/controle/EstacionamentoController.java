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
package gustavo.projeto.estacionamento.controle;

import gustavo.projeto.estacionamento.negocio.Movimentacao;
import gustavo.projeto.estacionamento.negocio.Vaga;
import gustavo.projeto.estacionamento.negocio.Veiculo;
import gustavo.projeto.estacionamento.persistencia.DAOEstacionamento;
import gustavo.projeto.estacionamento.utilitario.EstacionamentoUtil;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Gustavo.Batista 
 */
public class EstacionamentoController {

    /**
     * Faz a comunicação entre o banco de dados e a aplicação e todo seu controle
     * ao processar a entrada
     * 
     * @param placa Placa do veiculo
     * @param marca Marca do veiculo
     * @param modelo Modelo do veiculo
     * @param cor Cor do veiculo
     * @throws EstacionamentoException Quando estacionamento estiver lotado
     * @throws gustavo.projeto.estacionamento.controle.VeiculoException Quando o
     * padrao da placa for invalido
     */
    public void processarEntrada(String placa, String marca, String modelo, String cor) throws EstacionamentoException, VeiculoException {

        //Verificar se o estacionamento está lotado
        if (!Vaga.temVagaLivre()) {
            throw new EstacionamentoException("Estacionamento Lotado!");
        }

        //Verificar o padrão de String da placa
        if (!EstacionamentoUtil.validarPadraoPlaca(placa)) {
            throw new VeiculoException("Placa Informada Inválida!");
        }

        //Verificar se não há outro veículo com a mesma placa
        DAOEstacionamento daoVerificador = new DAOEstacionamento();
        Movimentacao verificador = daoVerificador.buscarMovimentacaoAberta(placa);

        if (verificador != null) {
            throw new VeiculoException("Placa Informada já cadastrada!");
        }

        //Criar uma instancia do veiculo
        Veiculo veiculo = new Veiculo(placa, marca, modelo, cor);

        //Criar a movimentacao vinculando o veiculo com data de entrada corrente
        Movimentacao movimentacao = new Movimentacao(veiculo, LocalDateTime.now());

        //Registrar na base de dados a informacao
        DAOEstacionamento dao = new DAOEstacionamento();
        dao.criar(movimentacao);

        //Atualizar o numero de vagas
        Vaga.entrou();

        //Fim
    }

    /**
     * Faz a comunicação entre o banco de dados e a aplicação e todo seu controle
     * ao processar a saída
     * 
     * @param placa Placa do veiculo que estiver saindo
     * @return Uma instancia da movimentacao com os dados atualizados de valores
     * @throws VeiculoException Quando a placa estiver incorreta
     * @throws gustavo.projeto.estacionamento.controle.EstacionamentoException
     * Quando o veiculo com a placa informada nao é localizado no estacionamento
     */
    public Movimentacao processarSaida(String placa) throws VeiculoException, EstacionamentoException {

        //Validar a placa
        if (!EstacionamentoUtil.validarPadraoPlaca(placa)) {
            throw new VeiculoException("Placa Inválida");
        }

        //Buscar a movimentacao aberta baseada na placa
        DAOEstacionamento dao = new DAOEstacionamento();
        Movimentacao movimentacao = dao.buscarMovimentacaoAberta(placa);

        //Verifica se o veiculo está no registrado no estacionamento
        if (movimentacao == null) {
            throw new EstacionamentoException("Veículo não encontrado!");
        }

        //Fazer o calculo do valor a ser pago
        movimentacao.setDataHoraSaida(LocalDateTime.now());
        EstacionamentoUtil.calcularValorPago(movimentacao);

        //Atualizar os dados da movimentacao
        dao.atualizar(movimentacao);

        //Atualizar o status da vaga
        Vaga.saiu();

        //Fim
        return movimentacao;
    }

    /**
     * Realiza o fluxo de emissão de relatório de faturamento baseado no mês e
     * ano informado
     *
     * @param data Data (mês e ano) de emissão desejado
     * @return Lista de movimentações que atendem ao filtro
     */
    public List<Movimentacao> emitirRelatorio(LocalDateTime data) {
        DAOEstacionamento dao = new DAOEstacionamento();
        return dao.consultarMovimentacoes(data);
    }

    /**
     * Retorna a lista de movimentações já cadastradas no Banco de dados
     * 
     * @return Lista de movimentações cadastradas préviamente no banco de dados
     */
    public int inicializarOcupadas() {
        DAOEstacionamento dao = new DAOEstacionamento();
        return dao.getOcupadas();
    }
}
