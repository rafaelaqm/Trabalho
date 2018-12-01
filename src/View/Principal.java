/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Funcionario;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Principal extends javax.swing.JFrame {

    public Principal(Funcionario funcionario) {
        initComponents();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        if (funcionario.getCpf().equals("vendedor")){
            mniCliente.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_principal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mniCliente = new javax.swing.JMenuItem();
        mniFuncionario = new javax.swing.JMenuItem();
        mniProduto = new javax.swing.JMenuItem();
        mniVenda = new javax.swing.JMenuItem();
        mnuSair = new javax.swing.JMenu();
        mnlSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Autopeças");

        javax.swing.GroupLayout pnl_principalLayout = new javax.swing.GroupLayout(pnl_principal);
        pnl_principal.setLayout(pnl_principalLayout);
        pnl_principalLayout.setHorizontalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnl_principalLayout.setVerticalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        mnuArquivo.setText("Arquivo");

        mniCliente.setText("Cliente");
        mniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniClienteActionPerformed(evt);
            }
        });
        mnuArquivo.add(mniCliente);

        mniFuncionario.setText("Funcionario");
        mniFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFuncionarioActionPerformed(evt);
            }
        });
        mnuArquivo.add(mniFuncionario);

        mniProduto.setText("Produto");
        mniProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProdutoActionPerformed(evt);
            }
        });
        mnuArquivo.add(mniProduto);

        mniVenda.setText("Venda");
        mniVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVendaActionPerformed(evt);
            }
        });
        mnuArquivo.add(mniVenda);

        jMenuBar1.add(mnuArquivo);

        mnuSair.setText("Sair");

        mnlSair.setText("Sair");
        mnlSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnlSairActionPerformed(evt);
            }
        });
        mnuSair.add(mnlSair);

        jMenuBar1.add(mnuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFuncionarioActionPerformed
        FuncionarioView funcionario = new FuncionarioView();
        pnl_principal.removeAll();
        pnl_principal.add(funcionario);
        pnl_principal.updateUI();
    }//GEN-LAST:event_mniFuncionarioActionPerformed

    private void mnlSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnlSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_mnlSairActionPerformed

    private void mniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniClienteActionPerformed
        ClienteView cliente = new ClienteView();
        pnl_principal.removeAll();
        pnl_principal.add(cliente);
        pnl_principal.updateUI();
    }//GEN-LAST:event_mniClienteActionPerformed

    private void mniProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProdutoActionPerformed
        ProdutoView peca = new ProdutoView();
        pnl_principal.removeAll();
        pnl_principal.add(peca);
        pnl_principal.updateUI();
    }//GEN-LAST:event_mniProdutoActionPerformed

    private void mniVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVendaActionPerformed
        VendaView venda = new VendaView();
        pnl_principal.removeAll();
        pnl_principal.add(venda);
        pnl_principal.updateUI();
    }//GEN-LAST:event_mniVendaActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniCliente;
    private javax.swing.JMenuItem mniFuncionario;
    private javax.swing.JMenuItem mniProduto;
    private javax.swing.JMenuItem mniVenda;
    private javax.swing.JMenuItem mnlSair;
    private javax.swing.JMenu mnuArquivo;
    private javax.swing.JMenu mnuSair;
    private javax.swing.JPanel pnl_principal;
    // End of variables declaration//GEN-END:variables
}
