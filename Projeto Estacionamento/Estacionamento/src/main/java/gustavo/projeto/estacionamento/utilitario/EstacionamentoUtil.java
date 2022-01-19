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
package gustavo.projeto.estacionamento.utilitario;

import gustavo.projeto.estacionamento.negocio.Movimentacao;
import gustavo.projeto.estacionamento.negocio.Tarifario;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representa uma classe de apoio às demais do sistema
 *
 * @author Gustavo.Batista 
 */
public class EstacionamentoUtil {

    /**
     * Valida a placa com o padrão LLL-NNNN L = Letra N = Numero
     *
     * @param placa Placa do veiculo
     * @return true se atender o padrão caso contrario retorna false
     */
    public static boolean validarPadraoPlaca(String placa) {
        String padrao = "[A-Z][A-Z][A-Z]-\\d\\d\\d\\d";
        Pattern p = Pattern.compile(padrao);
        Matcher m = p.matcher(placa);
        return m.matches();
    }

    /**
     * Recupera uma propriedade do arquivo de configuração de uma aplicação
     * configuration.txt
     *
     * @param propriedade
     * @return valor associado a propriedade
     */
    public static String get(String propriedade) {
        Properties prop = new Properties();
        String valor = null;

        try {
            prop.load(EstacionamentoUtil.class.getResourceAsStream("/recursos/configuration.txt")); 
            //prop.load(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\Estacionamento\\src\\main\\java\\recursos\\configuration.txt")) - Caso o código acima falhe;
            valor = prop.getProperty(propriedade);
        } catch (IOException e) {
            assert false : "Configuração não carregada";
        }
        return valor;

    }

    /**
     * Retorna a conversão de data e horário de um veículo como uma String 
     * 
     * @param dataHoraEntrada Data e horário de entrada do veiculo
     * @return dataHoraEntrada Retorna a data e o horário de entrada como uma
     * String
     */
    public static String getDataAsString(LocalDateTime dataHoraEntrada) {
        return dataHoraEntrada.toString();
    }

    /**
     * Calcula o valor a ser pago pela hora de entrada e saída e tabela de
     * tarifário
     *
     * @param movimentacao Instancia do veículo no estacionamento
     */
    public static void calcularValorPago(Movimentacao movimentacao) {
        LocalDateTime inicio = movimentacao.getDataHoraEntrada();
        LocalDateTime fim = movimentacao.getDataHoraSaida();
        double valor = 0;

        long diffHoras = inicio.until(fim, ChronoUnit.HOURS);

        if (diffHoras > 0) {
            valor += Tarifario.VALOR_HORA;
            fim.minus(1, ChronoUnit.HOURS);
        }

        long diffMinutos = inicio.until(fim, ChronoUnit.MINUTES);

        valor += (diffMinutos / Tarifario.INCREMENTO_MINUTOS) * Tarifario.VALOR_INCREMENTAL;

        movimentacao.setValor(valor);
    }

    /**
     * Retorna a data de entrada com o padrão de data-hora do MySQL
     * 
     * @param rdataEntrada Data de entrada do veículo
     * @return LocalDateTime.parse Data de entrada com o padrão de
     * data-hora do MySQL
     */
    public static LocalDateTime getDate(String rdataEntrada) {
        return LocalDateTime.parse(rdataEntrada, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     *  Retorna a conversão data/horário americano para o padrão brasileiro
     * 
     * @param data Data no padrão americano
     * @return Data no formato brasileiro
     */
    public static String getDisplayData(LocalDateTime data) {

        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    /**
     * Gera o texto de faturamento 
     * 
     * @param data Data da movimentação
     * @param movimentacoes Lista das movimentações
     * @return Texto de Faturamento
     */
    public static String gerarTextoFaturamento(LocalDateTime data, List<Movimentacao> movimentacoes) {
        double totalFaturado = 0;
        String texto = "";

        for (Movimentacao movimentacao : movimentacoes) {
            totalFaturado += movimentacao.getValor();
        }

        String sAno = "" + data.getYear();
        String sMes = data.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

        texto = "Faturamento do mês de " + sMes;
        texto += " de " + sAno + " foi de R$ " + totalFaturado;

        return texto;
    }

}
