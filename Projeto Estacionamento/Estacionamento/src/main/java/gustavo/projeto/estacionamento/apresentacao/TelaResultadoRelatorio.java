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
package gustavo.projeto.estacionamento.apresentacao;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import gustavo.projeto.estacionamento.negocio.Movimentacao;
import gustavo.projeto.estacionamento.utilitario.EstacionamentoUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Gustavo.Batista 
 */
public class TelaResultadoRelatorio extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form TelaResultadoRelatorio
     *
     */
    public TelaResultadoRelatorio() {

    }

    TelaResultadoRelatorio(TelaInicialRelatorio aThis, List<Movimentacao> movimentacoes, LocalDateTime data) {
        initComponents();

        setLocationRelativeTo(null);
        btnSair.addActionListener(this);
        btnVoltar.addActionListener(this);

        String textoFaturamento = EstacionamentoUtil.gerarTextoFaturamento(data, movimentacoes);
        lblTextoFaturamento.setText(textoFaturamento);

        Object[][] conteudoFaturamento = preencherTabela(movimentacoes);
        tblFaturamento.setModel(new javax.swing.table.DefaultTableModel(conteudoFaturamento, new String[]{
            "Placa", "Entrada", "Saída", "Valor"
        }));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){

            //Plano de fundo (@Gustav-dev97)
            public void paintComponent(Graphics g){

                ImageIcon im = new ImageIcon("parkingLotGustavo.jpg");
                Image i = im.getImage();

                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
            }
        };
        btnSair = new javax.swing.JButton();
        lblTextoFaturamento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFaturamento = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Relatório de Faturamento");
        setResizable(false);

        btnSair.setText("Sair");
        btnSair.setActionCommand("sair");

        lblTextoFaturamento.setBackground(new java.awt.Color(255, 255, 255));
        lblTextoFaturamento.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblTextoFaturamento.setForeground(new java.awt.Color(0, 0, 0));
        lblTextoFaturamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoFaturamento.setText("[Faturamento]");
        lblTextoFaturamento.setOpaque(true);

        tblFaturamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Placa", "Entrada", "Saída", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFaturamento);

        btnVoltar.setText("Voltar");
        btnVoltar.setActionCommand("voltar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTextoFaturamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTextoFaturamento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnSair))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaResultadoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaResultadoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaResultadoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaResultadoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaResultadoRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTextoFaturamento;
    private javax.swing.JTable tblFaturamento;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent evento) {
        String cmd = evento.getActionCommand();
        JFrame tela = null;

        if (cmd.equals("voltar")) {
            tela = new TelaInicialRelatorio();

        } else {
            tela = new TelaLogin();
        }

        tela.setVisible(true);
        this.dispose();
    }

    private Object[][] preencherTabela(List<Movimentacao> movimentacoes) {
        Object[][] conteudo = new Object[movimentacoes.size()][4];

        for (int i = 0; i < movimentacoes.size(); i++) {
            conteudo[i][0] = movimentacoes.get(i).getVeiculo().getPlaca();
            conteudo[i][1] = EstacionamentoUtil.getDisplayData(movimentacoes.get(i).getDataHoraEntrada());
            conteudo[i][2] = EstacionamentoUtil.getDisplayData(movimentacoes.get(i).getDataHoraSaida());
            conteudo[i][3] = movimentacoes.get(i).getValor();
        }

        return conteudo;
    }
}
