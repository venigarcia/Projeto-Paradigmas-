
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import model.RestauranteModel;
import model.Cardapio;
import model.Mesa;
import model.Garcom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlos_vinicios
 */
public class NewPedido extends javax.swing.JFrame {
    private DefaultListModel cardapioModel;
    private RestauranteModel restaurante;
    private ArrayList<Cardapio> cardapio;
    private ArrayList<Cardapio> itensSelecionados;
    private ArrayList<Garcom> garcons;
    private ArrayList qtds;
    private Restaurante mainGui;

    /**
     * Creates new form NewPedido
     */
    public NewPedido(RestauranteModel restaurante, Restaurante r) {
        initComponents();
        this.restaurante = restaurante;
        this.cardapio = this.restaurante.getCardapio();
        this.garcons = this.restaurante.getGarcons();
        this.itensSelecionados = new ArrayList();
        this.qtds = new ArrayList();
        this.mainGui = r;
        feedCardapioList();
    }

    public NewPedido(RestauranteModel restaurante, int codMesa, int codGarcom) {
        initComponents();
        this.restaurante = restaurante;
        this.codGarcomText.setText(String.valueOf(codGarcom));
        this.codMesaText.setText(String.valueOf(codMesa));
        this.cardapio = this.restaurante.getCardapio();
        this.garcons = this.restaurante.getGarcons();
        this.itensSelecionados = new ArrayList();
        this.qtds = new ArrayList();
        feedCardapioList();
    }

    private void feedCardapioList() {
        String text;
        this.cardapioModel = new DefaultListModel();
        this.cardapioList.setModel(cardapioModel);
        for (int i = 0; i < this.cardapio.size(); i++) {
            text = this.cardapio.get(i).getCod() + " - " + this.cardapio.get(i).getDecricao() + " - " + this.cardapio.get(i).getPreco();
            cardapioModel.addElement(text);
        }
    }

    private ArrayList selecaoParam(String textBusca) {
        int i;
        ArrayList busca = new ArrayList(); //cria um array para armazenar o resultado da busca
        for (i = 0; i < cardapioModel.size(); i++) { //realiza a busca dentro do model
            String item = (String) this.cardapioModel.get(i);
            if (item.contains(textBusca)) {
                busca.add(i);
            }
        }
        return busca;
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
        adicionarjButton = new javax.swing.JButton();
        quantidadeSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();

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
        savejButton.setMaximumSize(new java.awt.Dimension(85, 40));
        savejButton.setMinimumSize(new java.awt.Dimension(85, 40));
        savejButton.setPreferredSize(new java.awt.Dimension(85, 40));
        savejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejButtonActionPerformed(evt);
            }
        });

        canceljButton.setText("Cancelar");
        canceljButton.setMaximumSize(new java.awt.Dimension(85, 40));
        canceljButton.setMinimumSize(new java.awt.Dimension(85, 40));
        canceljButton.setPreferredSize(new java.awt.Dimension(85, 40));
        canceljButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canceljButtonMouseClicked(evt);
            }
        });

        cardapioList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(cardapioList);

        jcardapioLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jcardapioLabel1.setText("Cardápio");

        buscarjButton.setText("Buscar");
        buscarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarjButtonActionPerformed(evt);
            }
        });

        adicionarjButton.setText("Adicionar");
        adicionarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarjButtonActionPerformed(evt);
            }
        });

        quantidadeSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        jLabel3.setText("Quantidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcardapioLabel1)
                .addGap(192, 192, 192))
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
                            .addComponent(codGarcomText)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buscarText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(quantidadeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adicionarjButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(savejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(canceljButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 120, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarjButton)
                    .addComponent(quantidadeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savejButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canceljButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejButtonActionPerformed
        int i, codMesa;
        String label = "Deseja adicionar os seguintes intens?\n";
        Mesa mesa = null;
        Garcom garcom = null;
        ArrayList<Mesa> mesas = this.restaurante.getMesas();
        if (this.itensSelecionados.size() > 0) {
            for (i = 0; i < this.itensSelecionados.size(); i++) {
                label = label + this.itensSelecionados.get(i).getCod() + " - " + this.itensSelecionados.get(i).getDecricao() + " - " + this.itensSelecionados.get(i).getPreco() + " - qtd: " + this.qtds.get(i) + "\n";
            }
            if (JOptionPane.showConfirmDialog(null, label, "Adicionar itens",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (!"".equals(this.codMesaText.getText())) {
                    codMesa = Integer.parseInt(this.codMesaText.getText());
                    for (i = 0; i < mesas.size(); i++) {
                        if (mesas.get(i).getCod() == codMesa) {
                            mesa = mesas.get(i);
                            break;
                        }
                    }
                    if (mesa != null) {
                        for (i = 0; i < this.itensSelecionados.size(); i++) {
                            mesa.addItem(this.cardapio, this.itensSelecionados.get(i).getCod(), (int) this.qtds.get(i));
                        }
                    }
                } else {
                    String codGarcom = this.codGarcomText.getText();
                    if (!"".equals(codGarcom)) {
                        for (i = 0; i < this.garcons.size(); i++) {
                            if (this.garcons.get(i).getCod() == Integer.parseInt(codGarcom)) {
                                garcom = this.garcons.get(i);
                                break;
                            }
                        }
                        mesa = new Mesa(1, true, garcom, 100);
                        for (i = 0; i < this.itensSelecionados.size(); i++) {
                            mesa.addItem(this.cardapio, this.itensSelecionados.get(i).getCod(), (int) this.qtds.get(i));
                        }
                        String resp = JOptionPane.showInputDialog(null, "Quanto gostou do atendimento:\n1-Péssimo\n2-Ruim\n3-Médio\n4-Bom\n5-Muito Bom", "Avaliação", -1);
                        if (resp != null && !"".equals(resp)) {
                            mesa.fecharConta(this.restaurante, Integer.parseInt(resp));
                            this.restaurante.gravarAtendimentos();
                            this.mainGui.setTotalCaixa();
                            this.dispose();
                        }
                    }
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_savejButtonActionPerformed

    private void canceljButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canceljButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_canceljButtonMouseClicked

    private void buscarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarjButtonActionPerformed
        //filtra a lista com base no código ou texto dado
        String textBusca = this.buscarText.getText();
        String option;
        int i;
        ArrayList resp;
        resp = selecaoParam(textBusca);
        if (resp.size() > 1) {
            String textMessage = "Foram encontrados mais de uma referência para busca, selecione e digite o código correspondente:\n";
            for (i = 0; i < resp.size(); i++) {
                textMessage = textMessage + cardapioModel.get((int) resp.get(i)) + "\n";
            }
            option = JOptionPane.showInputDialog(null, textMessage, "Opções", -1); //cria a caixa de dialogo com os valores semelhantes encontrados
            resp = selecaoParam(option);
        }
        this.cardapioList.setSelectedIndex((int) resp.get(0)); //seta o indice selecionado
        this.buscarText.setText(""); //limpa o campo de busca
    }//GEN-LAST:event_buscarjButtonActionPerformed

    private void adicionarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarjButtonActionPerformed
        this.itensSelecionados.add(this.cardapio.get(this.cardapioList.getSelectedIndex()));
        this.qtds.add(this.quantidadeSpinner.getValue());
        this.quantidadeSpinner.setValue(1);
        this.cardapioList.setSelectedIndex(-1);
    }//GEN-LAST:event_adicionarjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarjButton;
    private javax.swing.JTextField buscarText;
    private javax.swing.JButton buscarjButton;
    private javax.swing.JButton canceljButton;
    private javax.swing.JList<String> cardapioList;
    private javax.swing.JTextField codGarcomText;
    private javax.swing.JTextField codMesaText;
    private javax.swing.JLabel garcomjLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jcardapioLabel1;
    private javax.swing.JLabel mesajLabel;
    private javax.swing.JSpinner quantidadeSpinner;
    private javax.swing.JButton savejButton;
    // End of variables declaration//GEN-END:variables
}
