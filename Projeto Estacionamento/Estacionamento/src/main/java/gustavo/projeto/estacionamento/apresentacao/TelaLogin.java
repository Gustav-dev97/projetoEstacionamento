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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo.Batista 
 */
public class TelaLogin extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();

        txtSenha.setVisible(false);
        senha.setVisible(false);
        senha.addActionListener(this);
        operacional.addActionListener(this);
        relatorio.addActionListener(this);
        continuar.addActionListener(this);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel(){

            //Plano de fundo (@Gustav-dev97)
            public void paintComponent(Graphics g){

                ImageIcon im = new ImageIcon("parkingLotGustavo.jpg");
                Image i = im.getImage();

                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
            }
        };
        continuar = new javax.swing.JButton();
        txtSenha = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        relatorio = new javax.swing.JRadioButton();
        operacional = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));

        continuar.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        continuar.setText("Continuar");
        continuar.setToolTipText("");
        continuar.setActionCommand("continuar");
        continuar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        txtSenha.setBackground(new java.awt.Color(255, 255, 0));
        txtSenha.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 0, 0));
        txtSenha.setText("Senha: ");
        txtSenha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtSenha.setOpaque(true);

        relatorio.setBackground(new java.awt.Color(0, 0, 0));
        grupo.add(relatorio);
        relatorio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        relatorio.setForeground(new java.awt.Color(255, 255, 0));
        relatorio.setText("Relatório");
        relatorio.setActionCommand("relatorio");
        relatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioActionPerformed(evt);
            }
        });

        operacional.setBackground(new java.awt.Color(0, 0, 0));
        grupo.add(operacional);
        operacional.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        operacional.setForeground(new java.awt.Color(255, 255, 0));
        operacional.setSelected(true);
        operacional.setText("Operacional");
        operacional.setToolTipText("");
        operacional.setActionCommand("operacional");
        operacional.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        operacional.setRequestFocusEnabled(false);
        operacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacionalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(operacional, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(txtSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(continuar)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operacional)
                    .addComponent(relatorio))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(continuar)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relatorioActionPerformed

    private void operacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacionalActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_operacionalActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_continuarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuar;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton operacional;
    private javax.swing.JRadioButton relatorio;
    private javax.swing.JPasswordField senha;
    private javax.swing.JLabel txtSenha;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent evento) {
        String cmd = evento.getActionCommand();
        JFrame tela = null;

        if (cmd.equals("operacional")) {
            txtSenha.setVisible(false);
            senha.setVisible(false);

        } else if (cmd.equals("relatorio")) {
            txtSenha.setVisible(true);
            senha.setVisible(true);

        } else if (cmd.equals("continuar")) {
            if (operacional.isSelected()) {
                tela = new TelaInicialMovimentacao();

            } else {
                String password = new String(senha.getPassword());
                if (password.equals("gu1234")) {
                    tela = new TelaInicialRelatorio();

                } else {
                    JOptionPane.showMessageDialog(null, "Senha Inválida", "Falha Login", JOptionPane.ERROR_MESSAGE);
                    senha.setText(null);
                    return;
                }
            }

            tela.setVisible(true);
            this.dispose();
        }
    }
}