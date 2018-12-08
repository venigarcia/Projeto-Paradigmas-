import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.RestauranteModel;
import model.Mesa;
import model.Garcom;
import model.Atendimento;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos_vinicios
 */
public class Restaurante extends javax.swing.JFrame {

    private final RestauranteModel restaurante;
    private final Date data;
    private final Boolean stateMesas[];
    private final int indexsMesas[];
    private ArrayList<Garcom> garcons;
    private ArrayList<Mesa> mesas;
    private ArrayList<Atendimento> atendimentos;
    private float totalValor =0;

    /**
     * Creates new form Restaurante
     */
    public Restaurante() {
        initComponents();
        setLocationRelativeTo( null );
        
        this.restaurante = new RestauranteModel();
        this.restaurante.resgatarGarcons();
        this.restaurante.resgatarCardapio();
        this.restaurante.resgatarAtendimentos();
        this.data = Calendar.getInstance().getTime();
        this.dataLabel.setText(new SimpleDateFormat("dd/MM/yyyy").format(this.data));
        this.stateMesas = new Boolean[9];
        this.indexsMesas = new int[9];
        initMesas();
        setTotalCaixa();
    }

    private void initMesas() {
        for (int i = 0; i < 9; i++) {
            stateMesas[i] = false;
        }
    }

    private Garcom selecCodGarcom() {
        String codGarcomText;
        int codGarcom, i;
        Garcom garcom = null;
        do {
            codGarcomText = JOptionPane.showInputDialog(null, "Código do garçom:", "Seleção de Garçom", -1); //cria a caixa de dialogo com os valores semelhantes encontrados
            if (codGarcomText != null && !"".equals(codGarcomText)) {
                codGarcom = Integer.parseInt(codGarcomText);
            } else {
                break;
            }
            for (i = 0; i < this.garcons.size(); i++) {
                if (this.garcons.get(i).getCod() == codGarcom) {
                    garcom = this.garcons.get(i);
                    break;
                }
            }
        } while (garcom == null);
        return garcom;
    }

    private int selecQtdClientes() {
        String respQtdText;
        int respQtd = -1;
        do {
            respQtdText = JOptionPane.showInputDialog(null, "Quantidade de clientes:", "Clientes", -1);
            if (respQtdText != null && !"".equals(respQtdText)) {
                respQtd = Integer.parseInt(respQtdText);
            } else {
                break;
            }
        } while (respQtd > 4 || respQtd < 0);
        return respQtd;
    }

    private void changeMesaStatus(int index, Boolean status) {
        switch (index) {
            case 0:
                if (status) {
                    this.mesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
            case 1:
                if (status) {
                    this.mesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
            case 2:
                if (status) {
                    this.mesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
            case 3:
                if (status) {
                    this.mesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
            case 4:
                if (status) {
                    this.mesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
            case 5:
                if (status) {
                    this.mesa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
            case 6:
                if (status) {
                    this.mesa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
            case 7:
                if (status) {
                    this.mesa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
            case 8:
                if (status) {
                    this.mesa9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png")));
                } else {
                    this.mesa9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaF.png")));
                }
                break;
        }
        setTotalCaixa();
    }
    
    private void mesaClicked(java.awt.event.MouseEvent evt, int index) {
        int respQtd;
        Garcom garcom;
        this.garcons = this.restaurante.getGarcons();
        if (!this.stateMesas[index]) {
            garcom = selecCodGarcom();
            if (garcom != null) {
                respQtd = selecQtdClientes();
                if (respQtd > 0) {
                    this.indexsMesas[index] = this.restaurante.getMesas().size();
                    Random rand = new Random();
                    int cod = 100 + rand.nextInt(1000);
                    this.restaurante.addMesas(respQtd, false, garcom, cod);
                    changeMesaStatus(index, false);
                    this.stateMesas[index] = true;
                }
            }
        } else {
            this.mesas = this.restaurante.getMesas();
            if (SwingUtilities.isRightMouseButton(evt)) {
                System.out.println(this.mesas.get(this.indexsMesas[index]).getCod());
                new controleMesa(this.restaurante, this, this.mesas.get(this.indexsMesas[index]), index).setVisible(true);
            } else {
                new NewPedido(this.restaurante, this.mesas.get(this.indexsMesas[index]).getCod(), this.mesas.get(this.indexsMesas[index]).getGarcom().getCod()).setVisible(true);
            }
        }
    }
    
    public void liberarMesa(int index) {
        this.stateMesas[index] = false;
        changeMesaStatus(index, true);
    }
    
    public void setTotalCaixa(){
        this.totalValor = 0;
        this.atendimentos = this.restaurante.getAtendimento();
        for(int i = 0; i < this.atendimentos.size(); i++){
            this.totalValor+=this.atendimentos.get(i).getTotal();
        }
        this.totalCaixa.setText("R$ " + String.format("%.2f", totalValor));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        toolBarjPanel = new javax.swing.JPanel();
        newPedido = new javax.swing.JButton();
        dataLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        totalCaixa = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        mesasjPanel = new javax.swing.JPanel();
        mesa1 = new javax.swing.JLabel();
        mesa2 = new javax.swing.JLabel();
        mesa3 = new javax.swing.JLabel();
        mesa4 = new javax.swing.JLabel();
        mesa5 = new javax.swing.JLabel();
        mesa6 = new javax.swing.JLabel();
        mesa7 = new javax.swing.JLabel();
        mesa8 = new javax.swing.JLabel();
        mesa9 = new javax.swing.JLabel();
        backgroundImg = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cadFunc = new javax.swing.JMenuItem();
        alteraFunc = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cadCardapio = new javax.swing.JMenuItem();
        alterCardapio = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        gorjetasGarcom = new javax.swing.JMenuItem();
        totalDia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurante");
        setBackground(new java.awt.Color(205, 179, 159));
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(1150, 850));

        toolBarjPanel.setBackground(new java.awt.Color(205, 179, 159));
        toolBarjPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        toolBarjPanel.setPreferredSize(new java.awt.Dimension(10, 200));

        newPedido.setText("Novo Pedido");
        newPedido.setPreferredSize(new java.awt.Dimension(99, 40));
        newPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newPedidoMouseClicked(evt);
            }
        });

        dataLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataLabel.setText("Data");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total em caixa:");

        totalCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCaixa.setText("R$ 2000,00");

        close.setText("Encerrar");
        close.setMaximumSize(new java.awt.Dimension(99, 40));
        close.setMinimumSize(new java.awt.Dimension(99, 40));
        close.setPreferredSize(new java.awt.Dimension(99, 40));

        javax.swing.GroupLayout toolBarjPanelLayout = new javax.swing.GroupLayout(toolBarjPanel);
        toolBarjPanel.setLayout(toolBarjPanelLayout);
        toolBarjPanelLayout.setHorizontalGroup(
            toolBarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarjPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(toolBarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(totalCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(693, 693, 693))
        );
        toolBarjPanelLayout.setVerticalGroup(
            toolBarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarjPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(newPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
                .addComponent(dataLabel)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalCaixa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mesasjPanel.setBackground(new java.awt.Color(205, 179, 159));
        mesasjPanel.setAlignmentX(0.0F);
        mesasjPanel.setAlignmentY(0.0F);
        mesasjPanel.setLayout(new java.awt.GridBagLayout());

        mesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 48, 0, 0);
        mesasjPanel.add(mesa1, gridBagConstraints);

        mesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 112, 0, 0);
        mesasjPanel.add(mesa2, gridBagConstraints);

        mesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa3MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 115, 0, 24);
        mesasjPanel.add(mesa3, gridBagConstraints);

        mesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa4MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(69, 48, 0, 0);
        mesasjPanel.add(mesa4, gridBagConstraints);

        mesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa5MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(69, 112, 0, 0);
        mesasjPanel.add(mesa5, gridBagConstraints);

        mesa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(69, 115, 0, 24);
        mesasjPanel.add(mesa6, gridBagConstraints);

        mesa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa7MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(105, 48, 22, 0);
        mesasjPanel.add(mesa7, gridBagConstraints);

        mesa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa8MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(105, 112, 22, 0);
        mesasjPanel.add(mesa8, gridBagConstraints);

        mesa9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaT.png"))); // NOI18N
        mesa9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mesa9MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(105, 115, 22, 24);
        mesasjPanel.add(mesa9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        mesasjPanel.add(backgroundImg, gridBagConstraints);

        jMenu1.setText("Menu");

        cadFunc.setText("Cadastro de Funcionário");
        cadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadFuncActionPerformed(evt);
            }
        });
        jMenu1.add(cadFunc);

        alteraFunc.setText("Alterar Funcionário");
        alteraFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alteraFuncActionPerformed(evt);
            }
        });
        jMenu1.add(alteraFunc);

        jSeparator1.setToolTipText("Cardápio");
        jMenu1.add(jSeparator1);

        cadCardapio.setText("Cadastrar Cardápio");
        cadCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadCardapioActionPerformed(evt);
            }
        });
        jMenu1.add(cadCardapio);

        alterCardapio.setText("Alterar Cardápio");
        alterCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterCardapioActionPerformed(evt);
            }
        });
        jMenu1.add(alterCardapio);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatório");

        gorjetasGarcom.setText("Total de gorjetas");
        gorjetasGarcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gorjetasGarcomActionPerformed(evt);
            }
        });
        jMenu2.add(gorjetasGarcom);

        totalDia.setText("Total do dia");
        totalDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalDiaActionPerformed(evt);
            }
        });
        jMenu2.add(totalDia);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBarjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mesasjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mesasjPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(toolBarjPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPedidoMouseClicked
        new NewPedido(this.restaurante, this).setVisible(true);
    }//GEN-LAST:event_newPedidoMouseClicked

    private void cadCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadCardapioActionPerformed
        new NewCardapioItem(this.restaurante).setVisible(true);
    }//GEN-LAST:event_cadCardapioActionPerformed

    private void cadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadFuncActionPerformed
        new NewFuncionario(this.restaurante).setVisible(true);
    }//GEN-LAST:event_cadFuncActionPerformed

    private void alteraFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alteraFuncActionPerformed
        new NewAlteracao("funcionário", this.restaurante).setVisible(true);
    }//GEN-LAST:event_alteraFuncActionPerformed

    private void alterCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterCardapioActionPerformed
        new NewAlteracao("item do cardápio", this.restaurante).setVisible(true);
    }//GEN-LAST:event_alterCardapioActionPerformed

    private void gorjetasGarcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gorjetasGarcomActionPerformed
        new NewAlteracao("gorjeta", this.restaurante).setVisible(true);
    }//GEN-LAST:event_gorjetasGarcomActionPerformed

    private void totalDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalDiaActionPerformed
        new TotalDia(this.restaurante).setVisible(true);
    }//GEN-LAST:event_totalDiaActionPerformed

    private void mesa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa1MouseClicked
        mesaClicked(evt, 0);
    }//GEN-LAST:event_mesa1MouseClicked

    private void mesa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa2MouseClicked
        mesaClicked(evt, 1);
    }//GEN-LAST:event_mesa2MouseClicked

    private void mesa3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa3MouseClicked
        mesaClicked(evt, 2);
    }//GEN-LAST:event_mesa3MouseClicked

    private void mesa4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa4MouseClicked
        mesaClicked(evt, 3);
    }//GEN-LAST:event_mesa4MouseClicked

    private void mesa5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa5MouseClicked
        mesaClicked(evt, 4);
    }//GEN-LAST:event_mesa5MouseClicked

    private void mesa6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa6MouseClicked
        mesaClicked(evt, 5);
    }//GEN-LAST:event_mesa6MouseClicked

    private void mesa7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa7MouseClicked
        mesaClicked(evt, 6);
    }//GEN-LAST:event_mesa7MouseClicked

    private void mesa8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa8MouseClicked
        mesaClicked(evt, 7);
    }//GEN-LAST:event_mesa8MouseClicked

    private void mesa9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesa9MouseClicked
        mesaClicked(evt, 8);
    }//GEN-LAST:event_mesa9MouseClicked

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
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaurante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem alterCardapio;
    private javax.swing.JMenuItem alteraFunc;
    private javax.swing.JLabel backgroundImg;
    private javax.swing.JMenuItem cadCardapio;
    private javax.swing.JMenuItem cadFunc;
    private javax.swing.JButton close;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JMenuItem gorjetasGarcom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel mesa1;
    private javax.swing.JLabel mesa2;
    private javax.swing.JLabel mesa3;
    private javax.swing.JLabel mesa4;
    private javax.swing.JLabel mesa5;
    private javax.swing.JLabel mesa6;
    private javax.swing.JLabel mesa7;
    private javax.swing.JLabel mesa8;
    private javax.swing.JLabel mesa9;
    private javax.swing.JPanel mesasjPanel;
    private javax.swing.JButton newPedido;
    private javax.swing.JPanel toolBarjPanel;
    private javax.swing.JLabel totalCaixa;
    private javax.swing.JMenuItem totalDia;
    // End of variables declaration//GEN-END:variables
}
