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
package gustavo.projeto.estacionamento.persistencia;

import gustavo.projeto.estacionamento.controle.EstacionamentoException;
import gustavo.projeto.estacionamento.negocio.Movimentacao;
import gustavo.projeto.estacionamento.negocio.Vaga;
import gustavo.projeto.estacionamento.negocio.Veiculo;
import gustavo.projeto.estacionamento.utilitario.EstacionamentoUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo.Batista 
 */
public class DAOEstacionamento {

    /**
     * Registra o veículo informado no banco de dados com base na placa, marca,
     * modelo, cor e horário de entrada além de atualizar o número de vagas
     * ocupadas
     *
     * @param movimentacao Instancia de movimentacao
     * @throws EstacionamentoException Se houver erro de registro
     */
    public void criar(Movimentacao movimentacao) throws EstacionamentoException {
        String cmd1 = EstacionamentoUtil.get("insertMov");
        String cmd2 = EstacionamentoUtil.get("atualizaVaga");

        Connection conexao = null;
        try {
            conexao = getConnection();
            conexao.setAutoCommit(false);

            PreparedStatement stmt = conexao.prepareStatement(cmd1);
            stmt.setString(1, movimentacao.getVeiculo().getPlaca());
            stmt.setString(2, movimentacao.getVeiculo().getMarca());
            stmt.setString(3, movimentacao.getVeiculo().getModelo());
            stmt.setString(4, movimentacao.getVeiculo().getCor());
            stmt.setString(5, EstacionamentoUtil.getDataAsString(movimentacao.getDataHoraEntrada()));

            stmt.execute();
            stmt = conexao.prepareStatement(cmd2);
            stmt.setInt(1, Vaga.ocupadas() + 1);
            stmt.execute();

            conexao.commit();

        } catch (SQLException e) {
            try {
                e.printStackTrace();
                conexao.rollback();
                throw new EstacionamentoException("Erro ao registrar veiculo");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Registra o horário de saída de um veículo do estacionamento no banco de
     * dados, atualiza o numero de vagas ocupadas e retorna o valor a pagar para
     * o veículo em questão
     *
     * @param movimentacao Instancia da movimentação do veículo
     * @throws EstacionamentoException Exception lançada quando o causador é o
     * estacionamento
     */
    public void atualizar(Movimentacao movimentacao) throws EstacionamentoException {
        String cmd1 = EstacionamentoUtil.get("updateMov");
        String cmd2 = EstacionamentoUtil.get("atualizaVaga");

        Connection conexao = null;
        try {
            conexao = getConnection();
            conexao.setAutoCommit(false);

            PreparedStatement stmt = conexao.prepareStatement(cmd1);
            stmt.setDouble(1, movimentacao.getValor());
            stmt.setString(2, EstacionamentoUtil.getDataAsString(movimentacao.getDataHoraSaida()));
            stmt.setString(3, movimentacao.getVeiculo().getPlaca());

            stmt.execute();
            stmt = conexao.prepareStatement(cmd2);
            stmt.setInt(1, Vaga.ocupadas() - 1);
            stmt.execute();

            conexao.commit();

        } catch (SQLException e) {
            try {
                e.printStackTrace();
                conexao.rollback();
                throw new EstacionamentoException("Erro ao atualizar o status do veiculo");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Busca o veículo no banco de dados pela placa
     *
     * @param placa A placa do veiculo
     * @return Retorna a movimentacao ou Null se não houver
     */
    public Movimentacao buscarMovimentacaoAberta(String placa) {
        String cmd = EstacionamentoUtil.get("getMovAberta");
        Connection conexao = null;
        Movimentacao movimentacao = null;

        try {
            conexao = getConnection();
            PreparedStatement ps = conexao.prepareStatement(cmd);
            ps.setString(1, placa);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                String rplaca = resultado.getString("placa");
                String rdataEntrada = resultado.getString("data_entrada");
                Veiculo veiculo = new Veiculo(rplaca);
                movimentacao = new Movimentacao(veiculo, EstacionamentoUtil.getDate(rdataEntrada));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conexao);
        }

        return movimentacao;
    }

    /**
     * Consulta as movimentações abertas no banco de dados 
     * 
     * @param data Data de consulta
     * @return Lista de movimentações do ano e mês informados
     */
    public List<Movimentacao> consultarMovimentacoes(LocalDateTime data) {
        Connection conexao = null;
        String cmd = EstacionamentoUtil.get("selectMovRelatorio");
        List<Movimentacao> movimentacoes = new ArrayList<>();

        try {
            conexao = getConnection();

            PreparedStatement ps = conexao.prepareStatement(cmd);
            ps.setString(1, data.toString());
            data = data.with(TemporalAdjusters.lastDayOfMonth());
            ps.setString(2, data.toString());

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                String placa = resultado.getString("placa");
                LocalDateTime entrada = EstacionamentoUtil.getDate(resultado.getString("data_entrada"));
                LocalDateTime saida = EstacionamentoUtil.getDate(resultado.getString("data_saida"));
                double valor = resultado.getDouble("valor");

                Veiculo veiculo = new Veiculo(placa);
                Movimentacao movimentacao = new Movimentacao(veiculo, entrada);
                movimentacao.setDataHoraSaida(saida);
                movimentacao.setValor(valor);

                movimentacoes.add(movimentacao);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conexao);
        }
        return movimentacoes;
    }

    /**
     * Retorna a conexão com o banco de dados
     *
     * @return conexao Retorna conexao com o banco de dados
     * @throws SQLException Retorna a Exception em caso de falha com o banco de
     * dados
     */
    public Connection getConnection() throws SQLException {
        String url = EstacionamentoUtil.get("url");
        String usuario = EstacionamentoUtil.get("usuario");
        String senha = EstacionamentoUtil.get("senha");

        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        return conexao;
    }

    /**
     *  Encerra conexao com o banco de dados
     * 
     * @param conexao Conexao com o banco de dados
     */
    public static void closeConnection(Connection conexao) {
        if (conexao != null) {

            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retorna o numero de vagas ocupadas
     * 
     * @return ocupadas Número de vagas ocupadas
     */
    public int getOcupadas() {
        int ocupadas = 0;
        Connection conexao = null;
        String cmd = EstacionamentoUtil.get("consultaOcupadas");

        try {
            conexao = getConnection();
            PreparedStatement ps = conexao.prepareStatement(cmd);

            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                ocupadas = resultado.getInt("ocupadas");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection(conexao);
        }

        return ocupadas;
    }
}
