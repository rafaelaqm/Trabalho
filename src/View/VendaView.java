package View;

import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Model.Cliente;
import Model.Funcionario;
import Model.Produto;
import Model.Venda;
import Model.VendaItens;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.swing.SwingConstants;
import javax.swing.table.*;


public class VendaView extends javax.swing.JInternalFrame {
    Venda venda;
    VendaDAO vendaDAO;
    VendaItens VendaItens;
    Produto produto;
    ProdutoDAO produtoDAO;
    Funcionario funcionario;
    FuncionarioDAO funcionarioDAO;
    Cliente cliente;
    ClienteDAO clienteDAO;
    List<Cliente> listaClientes;
    List<Produto> listaProdutos;
    List<Funcionario> listaVendedores;
    
    public VendaView() {
        initComponents();
        this.setVisible(true);
        venda = new Venda();
        cliente = new Cliente();
        clienteDAO = new ClienteDAO();
        produto = new Produto();
        produtoDAO = new ProdutoDAO();
        funcionario = new Funcionario();
        funcionarioDAO = new FuncionarioDAO();
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();
        listaVendedores = new ArrayList<>();
        PreencheComboVendedor();
        atualizarTabelaItens();
    }

    public void atualizarTabelaCliente() {
        cliente = new Cliente();
        try{
            if (txtNomeBusca.getText().isEmpty()){
                listaClientes = clienteDAO.ListaCliente();
            } else{
                listaClientes = clienteDAO.ListaClienteNome(txtNomeBusca.getText());
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String dados[][] = new String[listaClientes.size()][4];
        int i = 0;
        for (Cliente cliente: listaClientes){
            dados[i][0]=String.valueOf(cliente.getCodigo());
            dados[i][1]=cliente.getNome();
            dados[i][2]=cliente.getRua();
            dados[i][3]=cliente.getBairro();
            i++;
        }
        
        String tituloColuna[] = {"Código", "Nome", "Endereço", "Bairro"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        tblCliente.setModel(new DefaultTableModel(dados,tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false,false,false,false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
        });
        
        tblCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblCliente.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblCliente.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblCliente.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tblCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tblCliente.setRowHeight(25);
        tblCliente.updateUI();
    }
    
    public void atualizarTabelaProduto() {
        produto = new Produto();
        try{
            if (txtDescritivoBusca.getText().isEmpty()){
                listaProdutos = produtoDAO.ListaProduto();
            } else{
                listaProdutos = produtoDAO.ListaProdutoNome(txtDescritivoBusca.getText());
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String dados[][] = new String[listaProdutos.size()][4];
        int i = 0;
        for (Produto produto: listaProdutos){
            dados[i][0]=String.valueOf(produto.getCodigo());
            dados[i][1]=produto.getDescritivoCompleto();
            dados[i][2]=String.valueOf(produto.getPrecoVenda());
            dados[i][3]=String.valueOf(produto.getSaldo());
            i++;
        }
        
        String tituloColuna[] = {"Código", "Descritivo", "Vr. Venda", "Saldo"};
        DefaultTableModel tabelaProduto = new DefaultTableModel();
        tabelaProduto.setDataVector(dados, tituloColuna);
        tblProduto.setModel(new DefaultTableModel(dados,tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false,false,false,false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
        });
        
        tblProduto.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(400);
        tblProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tblProduto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tblProduto.setRowHeight(25);
        tblProduto.updateUI();
    }
    
    public void PreencheComboVendedor(){
        try {
            listaVendedores = funcionarioDAO.ListaVendedor();
        } catch (SQLException ex) {
            Logger.getLogger(VendaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Funcionario funcionario : listaVendedores){
            cboVendedor.addItem(funcionario.getNome());
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

        diagBuscaCliente = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        txtNomeBusca = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnSelecionarCliente = new javax.swing.JButton();
        diagBuscaProduto = new javax.swing.JDialog();
        jLabel14 = new javax.swing.JLabel();
        txtDescritivoBusca = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        btnSelecionarProduto = new javax.swing.JButton();
        btnFinalizarVenda = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboVendedor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        lblTotalVenda = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        txtDescritivoProduto = new javax.swing.JTextField();
        txtCodProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscaProduto = new javax.swing.JButton();
        txtQtd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecoUnit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPrecoTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnAdicionarItem = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();

        diagBuscaCliente.setMinimumSize(new java.awt.Dimension(590, 400));

        jLabel11.setText("Nome");

        txtNomeBusca.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeBuscaCaretUpdate(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Consultar Clientes");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCliente.setPreferredSize(new java.awt.Dimension(150, 64));
        jScrollPane3.setViewportView(tblCliente);

        jLabel13.setText("Digite o nome completo ou parte do mesmo para consultar");

        btnSelecionarCliente.setText("Selecionar");
        btnSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diagBuscaClienteLayout = new javax.swing.GroupLayout(diagBuscaCliente.getContentPane());
        diagBuscaCliente.getContentPane().setLayout(diagBuscaClienteLayout);
        diagBuscaClienteLayout.setHorizontalGroup(
            diagBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagBuscaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diagBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(diagBuscaClienteLayout.createSequentialGroup()
                        .addGroup(diagBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(diagBuscaClienteLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelecionarCliente))
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
        );
        diagBuscaClienteLayout.setVerticalGroup(
            diagBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagBuscaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(diagBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNomeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        diagBuscaProduto.setMinimumSize(new java.awt.Dimension(590, 400));

        jLabel14.setText("Descritivo");

        txtDescritivoBusca.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDescritivoBuscaCaretUpdate(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Consultar Produtos");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduto.setPreferredSize(new java.awt.Dimension(150, 64));
        jScrollPane4.setViewportView(tblProduto);

        jLabel16.setText("Digite o nome completo ou parte do mesmo para consultar");

        btnSelecionarProduto.setText("Selecionar");
        btnSelecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diagBuscaProdutoLayout = new javax.swing.GroupLayout(diagBuscaProduto.getContentPane());
        diagBuscaProduto.getContentPane().setLayout(diagBuscaProdutoLayout);
        diagBuscaProdutoLayout.setHorizontalGroup(
            diagBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagBuscaProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diagBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(diagBuscaProdutoLayout.createSequentialGroup()
                        .addGroup(diagBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(diagBuscaProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescritivoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelecionarProduto))
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
        );
        diagBuscaProdutoLayout.setVerticalGroup(
            diagBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagBuscaProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(diagBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDescritivoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarProduto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1024, 509));

        btnFinalizarVenda.setText("Finalizar Venda");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(768, 300));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Registrar Venda");

        jLabel1.setText("Vendedor");

        jLabel2.setText("Cód Cliente");

        jLabel4.setText("Nome do Cliente");

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lblTotalVenda.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotalVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarCliente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(lblTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscarCliente)
                                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addComponent(lblTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVenda.setPreferredSize(new java.awt.Dimension(150, 64));
        jScrollPane2.setViewportView(tblVenda);

        jLabel7.setText("Descritivo do Produto");

        jLabel6.setText("Cód Produtos");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Seleção de Itens");

        btnBuscaProduto.setText("Buscar");
        btnBuscaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaProdutoActionPerformed(evt);
            }
        });

        txtQtd.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtQtdCaretUpdate(evt);
            }
        });

        jLabel8.setText("Quantidade");

        jLabel9.setText("Preço Unit.");

        jLabel10.setText("Preço Total");

        btnAdicionarItem.setText("Adicionar Item");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        btnRemoverItem.setText("Remover Item");
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDescritivoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscaProduto))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAdicionarItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemoverItem)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescritivoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarItem)
                    .addComponent(btnRemoverItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        atualizarTabelaCliente();
        diagBuscaCliente.setVisible(true);
        diagBuscaCliente.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtNomeBuscaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeBuscaCaretUpdate
        atualizarTabelaCliente();
    }//GEN-LAST:event_txtNomeBuscaCaretUpdate

    private void btnSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarClienteActionPerformed
        txtCodCliente.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 0).toString());
        txtNomeCliente.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 1).toString());
        cliente = new Cliente();
        cliente.setCodigo(Integer.parseInt(txtCodCliente.getText()));
        cliente.setNome(txtNomeCliente.getText());
        diagBuscaCliente.dispose();
    }//GEN-LAST:event_btnSelecionarClienteActionPerformed

    private void txtQtdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtQtdCaretUpdate
        txtPrecoTotal.setText(String.valueOf(Float.valueOf(txtQtd.getText())*Float.valueOf(txtPrecoUnit.getText())));
    }//GEN-LAST:event_txtQtdCaretUpdate

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        VendaItens = new VendaItens();
        VendaItens.setProduto(produto);
        VendaItens.setPreco(Float.valueOf(txtPrecoUnit.getText()));
        VendaItens.setQtd(Float.valueOf(txtQtd.getText()));
        VendaItens.setPrecoTotalItem(Float.valueOf(txtPrecoTotal.getText()));
        venda.getVendaItens().add(VendaItens);
        atualizarTabelaItens();
        lblTotalVenda.setText(String.valueOf(totalVenda()));
        txtPrecoUnit.setText("");
        txtQtd.setText("");
        txtPrecoTotal.setText("");
        txtCodProduto.setText("");
        txtDescritivoProduto.setText("");
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private float totalVenda(){
        float total=0;
        for (VendaItens vi : venda.getVendaItens()){
            total += vi.getPrecoTotalItem();
        }
        return total;
    }
    
    public void atualizarTabelaItens() {
        String dados[][] = new String[venda.getVendaItens().size()][4];
        int i = 0;
        for (VendaItens vi : venda.getVendaItens()) {
            dados[i][0] = vi.getProduto().getDescritivoCompleto();
            dados[i][1] = String.valueOf(vi.getQtd());
            dados[i][2] = String.valueOf(vi.getPreco());
            dados[i][3] = String.valueOf(vi.getPrecoTotalItem());
            i++;
        }
        String tituloColuna[] = {"Produto","Qtd","Preço Unit.","Preço Total"};
        DefaultTableModel tabelaItens = new DefaultTableModel();
        tabelaItens.setDataVector(dados, tituloColuna);
        tblVenda.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblVenda.getColumnModel().getColumn(0).setPreferredWidth(300);
        tblVenda.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblVenda.getColumnModel().getColumn(2).setPreferredWidth(300);
        tblVenda.getColumnModel().getColumn(3).setPreferredWidth(300);

        tblVenda.setRowHeight(25);
        tblVenda.updateUI();
    }
    
    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        venda.getVendaItens().remove(tblVenda.getSelectedRow());
        atualizarTabelaItens();
        lblTotalVenda.setText(String.valueOf(totalVenda()));
    }//GEN-LAST:event_btnRemoverItemActionPerformed

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);
        venda.setTotalVenda(Float.valueOf(lblTotalVenda.getText()));
        //vendaDAO.salvar(venda);
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void txtDescritivoBuscaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDescritivoBuscaCaretUpdate
        atualizarTabelaProduto();
    }//GEN-LAST:event_txtDescritivoBuscaCaretUpdate

    private void btnSelecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarProdutoActionPerformed
        txtCodProduto.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(), 0).toString());
        txtDescritivoProduto.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(), 1).toString());
        txtPrecoUnit.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(), 2).toString());
        produto = new Produto();
        produto.setCodigo(Integer.parseInt(txtCodProduto.getText()));
        produto.setDescritivoCompleto(txtDescritivoProduto.getText());
        diagBuscaProduto.dispose();
    }//GEN-LAST:event_btnSelecionarProdutoActionPerformed

    private void btnBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaProdutoActionPerformed
        atualizarTabelaProduto();
        diagBuscaProduto.setVisible(true);
        diagBuscaProduto.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnBuscaProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnBuscaProduto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnSelecionarCliente;
    private javax.swing.JButton btnSelecionarProduto;
    private javax.swing.JComboBox<String> cboVendedor;
    private javax.swing.JDialog diagBuscaCliente;
    private javax.swing.JDialog diagBuscaProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTotalVenda;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTable tblVenda;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtDescritivoBusca;
    private javax.swing.JTextField txtDescritivoProduto;
    private javax.swing.JTextField txtNomeBusca;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtPrecoTotal;
    private javax.swing.JTextField txtPrecoUnit;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}
