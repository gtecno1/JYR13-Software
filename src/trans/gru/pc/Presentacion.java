/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Presentacion2.java
 *
 * Created on 04-ago-2016, 19:57:41
 */
package trans.gru.pc;

import com.sun.awt.AWTUtilities;
import java.awt.Color;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.Timer;


/**
 *
 * @author GERALDO J
 */
public class Presentacion extends javax.swing.JFrame  {
Timer contador;
  int a;
  Thread Hilo2;
  Thread Hilo1;
  int velocidad = 60;
  int y = 280;
  private int x = 420;
    /** Creates new form Presentacion2 */
    public Presentacion() {
       setUndecorated(true);
        initComponents();
        
         
   
 
    
  setOpacity(0.9F);
    AWTUtilities.setWindowOpaque(this, false);
   
  
    setSize(this.x, this.y);
    
    setTitle("Bienvenido al sistema  ");
    setLocationRelativeTo(null);
    this.contador = new Timer(50, new claseTimer());
    this.contador.start();
    }

 
  
     
    
  public class claseTimer
    implements ActionListener
  {
    public claseTimer() {}
    
    public void actionPerformed(ActionEvent e)
    {
      Presentacion.this.a = Presentacion.this.ProgressBar.getValue();
      Presentacion.this.ProgressBar.setForeground(Color.red);
      if (Presentacion.this.a < 100)
      {
        Presentacion.this.a += 1;
        if (Presentacion.this.a <= 10)
        {
          Presentacion.this.txt.setText("verificando.");
          File ruta = new File("C:/Users/android/Documents/iconos/po1.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        if ((Presentacion.this.a > 10) && (Presentacion.this.a <= 20))
        {
          Presentacion.this.txt.setText("verificando..");
          File ruta = new File("C:/Users/android/Documents/iconos/po2.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        if ((Presentacion.this.a > 20) && (Presentacion.this.a <= 30))
        {
          Presentacion.this.txt.setText("verificando...");
          File ruta = new File("C:/Users/android/Documents/iconos/po3.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        if ((Presentacion.this.a > 30) && (Presentacion.this.a <= 40))
        {
          Presentacion.this.txt.setText("ajustando.");
          File ruta = new File("C:/Users/android/Documents/iconos/po4.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        if ((Presentacion.this.a > 40) && (Presentacion.this.a <= 50)) {
          Presentacion.this.txt.setText("ajustando..");
        }
        if ((Presentacion.this.a > 50) && (Presentacion.this.a <= 60))
        {
          Presentacion.this.txt.setText("datos.");
          File ruta = new File("C:/Users/android/Documents/iconos/po5.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        if ((Presentacion.this.a > 60) && (Presentacion.this.a <= 70)) {
          Presentacion.this.txt.setText("datos..");
           File ruta = new File("C:/Users/android/Documents/iconos/po6.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        if ((Presentacion.this.a > 70) && (Presentacion.this.a <= 80)) {
          Presentacion.this.txt.setText("datos...");
           File ruta = new File("C:/Users/android/Documents/iconos/po6.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        if ((Presentacion.this.a > 80) && (Presentacion.this.a <= 90)) {
          Presentacion.this.txt.setText("datos.");
           File ruta = new File("C:/Users/android/Documents/iconos/po7.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        if ((Presentacion.this.a > 90) && (Presentacion.this.a <= 100)) {
          Presentacion.this.txt.setText("listo");
           File ruta = new File("C:/Users/android/Documents/iconos/po7.png");
            String d=(String.valueOf(ruta));
            Image foto= getToolkit().getImage(d);
            jLabel1.setIcon(new ImageIcon(foto));
        }
        Presentacion.this.ProgressBar.setValue(Presentacion.this.a);
      }
      else
      {
        Presentacion.this.contador.stop();
         ingreso f = new ingreso();
        f.setVisible(true);
        Presentacion.this.cerrar();
        
       
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

        jPanel1 = new javax.swing.JPanel();
        txt = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(null);

        txt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt);
        txt.setBounds(10, 10, 100, 16);
        jPanel1.add(ProgressBar);
        ProgressBar.setBounds(50, 210, 330, 10);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2016-2017");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 220, 90, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RIF: j-29620907-3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(310, 10, 110, 14);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 430, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
             new Presentacion().setVisible(true);
            }
        });
        
    }
    
     void cerrar()
  {
    try
    {
      setVisible(true);
      for (int i = 0; i < 7; i++)
      {
        Thread.sleep(this.velocidad);
        setSize(this.x, this.y);
        setLocationRelativeTo(null);
        this.x -= 100;
        if (this.x == 900) {
          for (int j = 0; j < 6; j++)
          {
            Thread.sleep(this.velocidad);
            setSize(this.x, this.y);
            setLocationRelativeTo(null);
            this.y -= 100;
          }
        }
      }
    }
    catch (InterruptedException e) {}
    dispose();
  
  
  }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
