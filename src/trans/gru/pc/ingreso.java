/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ingreso.java
 *
 * Created on 07/01/2017, 12:36:31 AM
 */
package trans.gru.pc;

import CBD.CBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author GeAnJi
 */
public class ingreso extends javax.swing.JFrame {
    
  
String SQL1,SQL4;
CBD cc= new CBD();
Connection cn= cc.Conectar(); 
Statement st = null; 
String Hora;
  void reloj()
  {
      String mp,ap;
     Calendar car=Calendar.getInstance();
    
     
      ap =String.valueOf( car.get(car.AM_PM));
     if(ap.equals("0")){
         mp="AM";
     }
     else{
         mp="PM";
     }
    Hora=car.get(car.HOUR)+":"+car.get(car.MINUTE)+":"+car.get(car.SECOND)+" "+mp;
   
  }
    /** Creates new form ingreso */
    public ingreso() {
        setUndecorated(true);
        initComponents();
        
         this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     reloj();
     Bloquear();
    }
    void limpiar(){
        txtusu.setText("");
        txtcon.setText("");
    }
     void Bloquear(){
        txtusu.setEnabled(false);
        txtcon.setEnabled(false);
    }
      void desbloquear(){
        txtusu.setEnabled(true);
        txtcon.setEnabled(true);
    }
void guardar(){
    String ce2,nom2;
 
     String usuario1=txtusu.getText();
     String password=txtcon.getText();
     PreparedStatement psd1,psd2,psd3,psd4;
       if((usuario1.isEmpty())||(password.isEmpty()))
       {
           limpiar();
           Bloquear();
           
         JOptionPane.showMessageDialog(null,"Por favor llene todos los campos.!");
       }
       else
       {
         
         
       try
       {
       
         CBD cc0= new CBD();
Connection cn0= cc0.Conectar(); 

     Statement st0 = (Statement) cn0.createStatement();
 
         ResultSet rs = st0.executeQuery("SELECT * FROM usuarios  WHERE usuario ='"+usuario1+"' AND  contraseña='"+password+"'");
         rs.last();

         int encontrado=rs.getRow();
        
         if(encontrado==1)
         {
           
         try{
             CBD cc1= new CBD();
   Connection cn1= cc1.Conectar(); 
Statement st1 = null; 
   SQL1="SELECT * FROM usuarios WHERE usuario ='"+usuario1+"' AND  contraseña='"+password+"' ";
       st1 = cn1.createStatement();
           ResultSet rs1 = st1.executeQuery(SQL1);
           rs1.next();
          
          ce2=rs1.getString("cedula");
            nom2=rs1.getString("nombres");
          
              CBD cc2= new CBD();
   Connection cn2= cc2.Conectar(); 


         String Ac="1",IAc="0";    
        String  SQL="UPDATE rol set activo=? WHERE cedula=? ";
     psd2 = cn2.prepareStatement(SQL);
     psd2.setString(1,Ac);
        psd2.setString(2,ce2);
        
        
           int n=psd2.executeUpdate();
 new Thread(new correcto()).start();


 
 
 
        SQL4="INSERT ensa  (ce,nombre,en,sa,fecha) VALUES (?,?,?,?,?)";
    try{
        
         
        psd4=cn.prepareStatement(SQL4);
         psd4.setString(1,ce2);
        psd4.setString(2,nom2);
        psd4.setString(3,Hora);
         psd4.setString(4,"No a salido");
          psd4.setString(5,"No registrado");
          
           
           int Up=psd4.executeUpdate();
           if(Up==1){
              
             
           } 
            }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al guardar entrada");
        }
           
  

               
             
                 
       
               CBD cc5= new CBD();
   Connection cn5= cc5.Conectar(); 

          String  SQL3="UPDATE rol set activo=? WHERE cedula=? ";

     psd3 = cn5.prepareStatement(SQL3);
     psd3.setString(1,IAc);
        psd3.setString(2,ce2);
        
          psd3.executeUpdate(); 
            
           
      } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al activar usuario");
          
      }         
        
          
             
          
   
 this.dispose();
         }
         else
         {
            JOptionPane.showMessageDialog(null,"Contraseña o usuario incorrectos");
        txtusu.setText("");
        txtcon.setText("");
        Bloquear();
         }

         rs.close();
         st.close();
       }
       catch (Exception e)
      {
      }
       } 
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtusu = new javax.swing.JTextField();
        txtcon = new javax.swing.JPasswordField();
        btnace = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(20, 136, 238));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(149, 200, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario y Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txtusu.setFont(new java.awt.Font("Monospaced", 1, 12));
        txtusu.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        txtusu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusuMouseClicked(evt);
            }
        });
        txtusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuActionPerformed(evt);
            }
        });
        txtusu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusuKeyPressed(evt);
            }
        });

        txtcon.setFont(new java.awt.Font("Monospaced", 1, 12));
        txtcon.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcon, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusu, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtusu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtcon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnace.setBackground(new java.awt.Color(0, 0, 0));
        btnace.setForeground(new java.awt.Color(255, 255, 255));
        btnace.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\bt.png")); // NOI18N
        btnace.setContentAreaFilled(false);
        btnace.setPressedIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\bn2.png")); // NOI18N
        btnace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\g.png")); // NOI18N
        jLabel1.setText("Salir");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\llave2.png")); // NOI18N
        jLabel2.setText("Cuenta");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(20, 136, 238));
        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INGRESO DE USUARIO");
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(87, 87, 87)
                .addComponent(btnace, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(351, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnace, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(128, 128, 128)
                    .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtusuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuKeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_txtusuKeyPressed

private void txtusuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuMouseClicked
desbloquear();// TODO add your handling code here:
}//GEN-LAST:event_txtusuMouseClicked

private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
dispose();
}//GEN-LAST:event_jLabel1MouseClicked

private void btnaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceActionPerformed
 guardar();
}//GEN-LAST:event_btnaceActionPerformed

private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
new rusuario().setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jLabel2MouseClicked

private void txtusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtusuActionPerformed

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
            java.util.logging.Logger.getLogger(ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ingreso().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton btnace;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtcon;
    private javax.swing.JTextField txtusu;
    // End of variables declaration//GEN-END:variables
}
