import java.awt.Color;
import java.util.Random;
import model.RestauranteModel;
import model.Cardapio;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos_vinicios
 */
public class NewCardapioItem extends javax.swing.JDialog {
    private RestauranteModel restaurante;
    private Boolean alterar = false;
    private ArrayList<Cardapio> cardapio;
    private int indexAlter;
    
    /**
     * Creates new form NewCardapioItem
     */
    public NewCardapioItem(RestauranteModel restaurante) {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo( null );
        this.getContentPane().setBackground(new Color(205, 179, 159));
        Random rand = new Random();
        int cod = 1000 + rand.nextInt(1000);
        this.codText.setText(String.valueOf(cod));
        this.restaurante = restaurante;
    }
    
    public NewCardapioItem(RestauranteModel restaurante, int index){
        initComponents();
        this.setModal(true);
        this.setModal(true);
        this.setLocationRelativeTo( null );
        this.restaurante = restaurante;
        this.cardapio = this.restaurante.getCardapio();
        this.alterar = true;
        this.codText.setText(String.valueOf(this.cardapio.get(index).getCod()));
        this.descText.setText(this.cardapio.get(index).getDecricao());
        this.precoText.setText(String.valueOf(this.cardapio.get(index).getPreco()));
        this.indexAlter = index;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        codText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        precoText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descText = new javax.swing.JTextArea();
        salvarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo item");
        setMaximumSize(new java.awt.Dimension(470, 382));
        setMinimumSize(new java.awt.Dimension(470, 382));
        setPreferredSize(new java.awt.Dimension(470, 362));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Cod.");

        codText.setBackground(new java.awt.Color(234, 221, 212));
        codText.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        codText.setToolTipText("");
        codText.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Preço");

        precoText.setBackground(new java.awt.Color(234, 221, 212));
        precoText.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Descrição");

        descText.setBackground(new java.awt.Color(234, 221, 212));
        descText.setColumns(1);
        descText.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        descText.setLineWrap(true);
        descText.setRows(6);
        jScrollPane1.setViewportView(descText);

        salvarButton.setBackground(new java.awt.Color(33, 12, 18));
        salvarButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        salvarButton.setForeground(new java.awt.Color(255, 255, 255));
        salvarButton.setText("Salvar");
        salvarButton.setMaximumSize(new java.awt.Dimension(85, 40));
        salvarButton.setMinimumSize(new java.awt.Dimension(85, 40));
        salvarButton.setPreferredSize(new java.awt.Dimension(85, 40));
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setBackground(new java.awt.Color(33, 12, 18));
        cancelarButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        cancelarButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelarButton.setText("Cancelar");
        cancelarButton.setMaximumSize(new java.awt.Dimension(85, 40));
        cancelarButton.setMinimumSize(new java.awt.Dimension(85, 40));
        cancelarButton.setPreferredSize(new java.awt.Dimension(85, 40));
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precoText)
                                    .addComponent(codText)))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(precoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
        String codItem = this.codText.getText();
        String descricao = this.descText.getText();
        String preco = this.precoText.getText();
        if(!alterar){
            this.restaurante.addCardapio(Integer.parseInt(codItem), descricao, Float.parseFloat(preco));
        }else{
            this.cardapio.get(this.indexAlter).setDecricao(descricao);
            this.cardapio.get(this.indexAlter).setPreco(Float.parseFloat(preco));
        }
        this.restaurante.gravarCardapio();
        this.dispose();
    }//GEN-LAST:event_salvarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField codText;
    private javax.swing.JTextArea descText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField precoText;
    private javax.swing.JButton salvarButton;
    // End of variables declaration//GEN-END:variables
}
