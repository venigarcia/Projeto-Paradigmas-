/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos_vinicios
 */
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class NewPedido extends javax.swing.JFrame {
    private DefaultListModel cardapioModel;
    /**
     * Creates new form NewPedido
     */
    public NewPedido() {
        initComponents();
        feedCardapioList();
    }
    
    private void feedCardapioList(){
        this.cardapioModel = new DefaultListModel();
        this.cardapioList.setModel(cardapioModel);
        //substituir essa parte pelo retorno dado pela classe
        cardapioModel.addElement("1245 - Hamburguer");
        cardapioModel.addElement("6724 - Cachorro Quente");
        cardapioModel.addElement("8754 - Espaguete");
        cardapioModel.addElement("6589 - Lasanha");
        cardapioModel.addElement("4523 - Pizza");
        cardapioModel.addElement("8744 - Carne de Sol");
        cardapioModel.addElement("8541 - Frango a passarinha");
        cardapioModel.addElement("2487 - Torta de camarão");
        cardapioModel.addElement("2494 - Torta de carne");
        cardapioModel.addElement("6849 - Feijoada");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        garcomjLabel = new javax.swing.JLabel();
        codGarcomText = new javax.swing.JTextField();
        mesajLabel = new javax.swing.JLabel();
        codMesaText = new javax.swing.JTextField();
        savejButton = new javax.swing.JButton();
        canceljButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cardapioList = new javax.swing.JList<>();
        jcardapioLabel1 = new javax.swing.JLabel();
        buscarjButton = new javax.swing.JButton();
        buscarText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Pedido");
        setLocation(new java.awt.Point(400, 100));
        setResizable(false);

        garcomjLabel.setText("Código Garçom");
        garcomjLabel.setToolTipText("");

        codGarcomText.setToolTipText("");

        mesajLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mesajLabel.setText("Código Mesa");
        mesajLabel.setToolTipText("");

        savejButton.setText("Salvar");
        savejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejButtonActionPerformed(evt);
            }
        });

        canceljButton.setText("Cancelar");
        canceljButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canceljButtonMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(cardapioList);

        jcardapioLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jcardapioLabel1.setText("Cardápio");

        buscarjButton.setText("Buscar");
        buscarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(garcomjLabel)
                            .addComponent(mesajLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codMesaText)
                            .addComponent(codGarcomText)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(savejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(canceljButton)
                                .addGap(0, 130, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buscarText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarjButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcardapioLabel1)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(garcomjLabel)
                    .addComponent(codGarcomText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesajLabel)
                    .addComponent(codMesaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jcardapioLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savejButton)
                    .addComponent(canceljButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejButtonActionPerformed
        //aqui fica todo o código de captura dos itens selecionados e campos de textos
    }//GEN-LAST:event_savejButtonActionPerformed

    private void canceljButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canceljButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_canceljButtonMouseClicked
    
    private ArrayList selecaoParam(String textBusca){
        int i;
        ArrayList busca = new ArrayList(); //cria um array para armazenar o resultado da busca
        for(i=0; i < cardapioModel.size(); i++){ //realiza a busca dentro do model
            String item = (String) this.cardapioModel.get(i);
            if(item.contains(textBusca)){
                busca.add(i);
            }
        }
        return busca;
    }
    
    private void buscarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarjButtonActionPerformed
        //filtra a lista com base no código ou texto dado
        String textBusca = this.buscarText.getText();
        String option;
        int i, j;
        ArrayList resp;
        int[] itens = new int[this.cardapioList.getSelectedIndices().length + 1]; //cria um vetor para armazenar os indices já selecionados
        for(i=0;i<this.cardapioList.getSelectedIndices().length; i++) //joga todos os indices anteriores para o novo array
            itens[i] = this.cardapioList.getSelectedIndices()[i];
        resp = selecaoParam(textBusca);
        if( resp.size() > 1){
            String textMessage = "Foram encontrados mais de uma referência para busca, selecione e digite o código correspondente:\n";
            for(j=0; j < resp.size(); j++)
                textMessage = textMessage + cardapioModel.get((int)resp.get(j)) + "\n";
            option = JOptionPane.showInputDialog(textMessage);
            resp = selecaoParam(option);
        }
        itens[i] = (int)resp.get(0);
        this.cardapioList.setSelectedIndices(itens);
        this.buscarText.setText("");
    }//GEN-LAST:event_buscarjButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarText;
    private javax.swing.JButton buscarjButton;
    private javax.swing.JButton canceljButton;
    private javax.swing.JList<String> cardapioList;
    private javax.swing.JTextField codGarcomText;
    private javax.swing.JTextField codMesaText;
    private javax.swing.JLabel garcomjLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jcardapioLabel1;
    private javax.swing.JLabel mesajLabel;
    private javax.swing.JButton savejButton;
    // End of variables declaration//GEN-END:variables
}
