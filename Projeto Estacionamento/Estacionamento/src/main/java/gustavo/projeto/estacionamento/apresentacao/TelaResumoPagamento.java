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
import javax.swing.JFrame;

/**
 *
 * @author Gustavo.Batista 
 */
public class TelaResumoPagamento extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form TelaResumoPagamento
     */
    public TelaResumoPagamento() {
        initComponents();

        setLocationRelativeTo(null);
        btnOk.addActionListener(this);
    }

    TelaResumoPagamento(Movimentacao movimentacao) {
        initComponents();

        setLocationRelativeTo(null);
        btnOk.addActionListener(this);

        String sPlaca = movimentacao.getVeiculo().getPlaca();
        lblValPlaca.setText(sPlaca);

        String sEntrada = EstacionamentoUtil.getDisplayData(movimentacao.getDataHoraEntrada());
        lblValDataEntrada.setText(sEntrada);

        String sSaida = EstacionamentoUtil.getDisplayData(movimentacao.getDataHoraSaida());
        lblValDataSaida.setText(sSaida);

        String sValor = "R$ " + movimentacao.getValor();
        lblValValor.setText(sValor);
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
        lblPlaca = new javax.swing.JLabel();
        lblDataEntrada = new javax.swing.JLabel();
        lblDataSaida = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblValPlaca = new javax.swing.JLabel();
        lblValDataEntrada = new javax.swing.JLabel();
        lblValDataSaida = new javax.swing.JLabel();
        lblValValor = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resumo de Pagamento");
        setResizable(false);

        lblPlaca.setBackground(new java.awt.Color(255, 255, 0));
        lblPlaca.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblPlaca.setForeground(new java.awt.Color(0, 0, 0));
        lblPlaca.setText("Placa:");
        lblPlaca.setOpaque(true);

        lblDataEntrada.setBackground(new java.awt.Color(255, 255, 0));
        lblDataEntrada.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblDataEntrada.setForeground(new java.awt.Color(0, 0, 0));
        lblDataEntrada.setText("Entrada:");
        lblDataEntrada.setOpaque(true);

        lblDataSaida.setBackground(new java.awt.Color(255, 255, 0));
        lblDataSaida.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblDataSaida.setForeground(new java.awt.Color(0, 0, 0));
        lblDataSaida.setText("Sa??da:");
        lblDataSaida.setOpaque(true);

        lblValor.setBackground(new java.awt.Color(255, 255, 0));
        lblValor.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblValor.setForeground(new java.awt.Color(0, 0, 0));
        lblValor.setText("Valor:");
        lblValor.setOpaque(true);

        lblValPlaca.setBackground(new java.awt.Color(255, 255, 255));
        lblValPlaca.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblValPlaca.setForeground(new java.awt.Color(0, 0, 0));
        lblValPlaca.setText("[placa]");
        lblValPlaca.setOpaque(true);

        lblValDataEntrada.setBackground(new java.awt.Color(255, 255, 255));
        lblValDataEntrada.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblValDataEntrada.setForeground(new java.awt.Color(0, 0, 0));
        lblValDataEntrada.setText("[data_entrada]");
        lblValDataEntrada.setOpaque(true);

        lblValDataSaida.setBackground(new java.awt.Color(255, 255, 255));
        lblValDataSaida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblValDataSaida.setForeground(new java.awt.Color(0, 0, 0));
        lblValDataSaida.setText("[data_saida]");
        lblValDataSaida.setOpaque(true);

        lblValValor.setBackground(new java.awt.Color(255, 255, 255));
        lblValValor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblValValor.setForeground(new java.awt.Color(0, 0, 0));
        lblValValor.setText("[valor]");
        lblValValor.setOpaque(true);

        btnOk.setText("Ok");
        btnOk.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(lblValPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblDataEntrada)
                        .addGap(193, 193, 193)
                        .addComponent(lblValDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(lblValDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(lblValValor, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblValPlaca)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblValDataEntrada)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblValDataSaida)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblValValor)))
                .addGap(69, 69, 69)
                .addComponent(btnOk)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(TelaResumoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaResumoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaResumoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaResumoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaResumoPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDataEntrada;
    private javax.swing.JLabel lblDataSaida;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblValDataEntrada;
    private javax.swing.JLabel lblValDataSaida;
    private javax.swing.JLabel lblValPlaca;
    private javax.swing.JLabel lblValValor;
    private javax.swing.JLabel lblValor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent evento) {
        String cmd = evento.getActionCommand();
        JFrame tela = null;

        if (cmd.equals("Ok")) {
            tela = new TelaInicialMovimentacao();
        }

        tela.setVisible(true);
        this.dispose();
    }
}
