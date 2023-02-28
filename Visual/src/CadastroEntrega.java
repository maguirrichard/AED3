
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class CadastroEntrega extends javax.swing.JFrame {

    /**
     * Creates new form CriarConta
     */
    
    private Usuario u;
    private static ArquivoIndexado<Entrega> arquivo;
    private int help;
    
    public CadastroEntrega() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public CadastroEntrega(Usuario u) {
        this.u = u;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Object [] opcoes = {"Entregador", "Empresa 1", "Empresa 2"};
        Object resposta;
        resposta = JOptionPane.showInputDialog(null, "Selecione sua funcao", "Voce eh:", JOptionPane.PLAIN_MESSAGE,null, opcoes, "Entregador");
        System.out.println(resposta);
        initComponents(u, resposta);
    }
    
    private void initComponents(Usuario u, Object resposta){
        if(resposta.equals("Entregador")){
            jTFTransp.setText(u.getNome());
            jTFTransp.setEditable(false);
        }
        else if(resposta.equals("Empresa 1")){
            jTFEmpr1.setText(u.getNome());
            jTFEmpr1.setEditable(false);
        }
        else{
            jTFEmpr2.setText(u.getNome());
            jTFEmpr2.setEditable(false);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFTransp = new javax.swing.JTextField();
        jTFEmpr1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFProd = new javax.swing.JTextField();
        jTFEnd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBCadastrar = new javax.swing.JButton();
        jTFEmpr2 = new javax.swing.JTextField();
        jBVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Criar Entrega");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Transportador:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Empresa Env.:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Empresa Entr.:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Produto:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Endereço:");

        jBCadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jTFEmpr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmpr2ActionPerformed(evt);
            }
        });

        jBVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBVoltar.setText("Voltar");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFEnd)
                            .addComponent(jTFProd)
                            .addComponent(jTFTransp)
                            .addComponent(jTFEmpr1)
                            .addComponent(jTFEmpr2))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBVoltar)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFTransp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFEmpr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFEmpr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrar)
                    .addComponent(jBVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        String transp = jTFTransp.getText();
        String empr1 = jTFEmpr1.getText();
        String empr2 = jTFEmpr2.getText();
        String prod = jTFProd.getText();
        String end = jTFEnd.getText();

        try {
            arquivo = new ArquivoIndexado<>(Entrega.class, "entrega.db", "entrega1.idx", "entrega2.idx");
            Entrega e;
            e = new Entrega(transp, empr1, empr2, prod, end);
            int cod = arquivo.incluir(e);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTFTransp.setText(" ");
        jTFEmpr1.setText(" ");
        jTFEmpr2.setText("");
        jTFProd.setText(" ");
        jTFEnd.setText(" ");
        this.dispose();
        EntregaTela p;
        try {
            p = new EntregaTela(u);
            p.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(CadastroEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jTFEmpr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmpr2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmpr2ActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        this.dispose();
        EntregaTela p;
        try {
            p = new EntregaTela(u);
            p.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(CadastroEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTFEmpr1;
    private javax.swing.JTextField jTFEmpr2;
    private javax.swing.JTextField jTFEnd;
    private javax.swing.JTextField jTFProd;
    private javax.swing.JTextField jTFTransp;
    // End of variables declaration//GEN-END:variables
}