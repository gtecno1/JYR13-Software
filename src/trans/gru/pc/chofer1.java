/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * chofer1.java
 *
 * Created on 10-ago-2016, 15:39:53
 */
package trans.gru.pc;

import CBD.CBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author black
 */
public class chofer1 extends javax.swing.JFrame {
int Ac;
String a,b,c,d,e,cedu,Acti;
DefaultTableModel model;
CBD cc= new CBD();
Connection cn= cc.Conectar();
String cod;
Statement st = null;
 String Hora,fech;
      public static String fechaActual1()
  {
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("    dd-MM-yyy");
    return formatoFecha.format(fecha);
  }
         
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
    /** Creates new form chofer1 */
    public chofer1() {
        initComponents();
         this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         btnn.setEnabled(false);   
     
       btng.setEnabled(false);   
     
       
       btned.setEnabled(false);   
     
        
       btnel.setEnabled(false);  
       jButton2.setEnabled(false);
        nuevob();
        activi();
        cargar("");
    }
    
void nuevo(){
    txtci.setEnabled(true);
   txtno.setEnabled(true);
   txtap.setEnabled(true);
   txttl.setEnabled(true);
   spedad.setEnabled(true);
  txtdir.setEnabled(true);
  
    
}
void nuevol(){
    txtci.setText("0");
   txtno.setText("");
   txtap.setText("");
   txttl.setText("0");
  
  txtdir.setText("");
    
}
void nuevob(){
    
  txtci.setEnabled(false);
   txtno.setEnabled(false);
   txtap.setEnabled(false);
   txttl.setEnabled(false);
   spedad.setEnabled(false);
  txtdir.setEnabled(false);  
   
    
}
 void cargar(String valor)
  {
    try
    {
      String[] titulos = {"CEDULA","NOMBRES","APELLIDOS","EDAD","TELFENO","DIRECCION","DINERO"};
      
      String[] registros = new String[7];
      this.model = new DefaultTableModel((Object[][])null, titulos);
      
      String cons = "select * from chofer where  cedula LIKE '%" + valor + "%'"  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(cons);
                
      while (rs.next())
      {
        registros[0] = rs.getString("cedula");
        registros[1] = rs.getString("nombres");
        registros[2] = rs.getString("apellidos");
        registros[3] = rs.getString("edad");
        registros[4] = rs.getString("telefono");
        registros[5] = rs.getString("direccion");
         registros[6] = rs.getString("dineroCh");
        
               
                 
       
        this.model.addRow(registros);
      }
     
   
  
  String sql2="select SUM(dineroCh) FROM  chofer where CONCAT (cedula)  LIKE '%"+valor+"%' ";
  
             Statement st0 = cn.createStatement();
               ResultSet rs0=st0.executeQuery(sql2);
               while(rs0.next()){
                 
                  TOTA.setText(rs0.getString("SUM(dineroCh)"));
        
          
                   
               }
               
                
      this.coDinero.setModel(this.model);
      
      
      this.coDinero.getColumnModel().getColumn(0).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(1).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  void data(){
        
       
      String a  =txtbusq.getText();
      
    
             
                
                cargar(a);
                
     }
   void activi(){
          try { 
     String SQL = "select * from actividades WHERE activo= '"+1+"' "  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
                
      while (rs.next())
      {
        
       a= rs.getString("BN");
       b= rs.getString("BG");
       c= rs.getString("BE");
       d= rs.getString("BEL");
        e= rs.getString("DEL");
       
       cedu= rs.getString("cedula");
       
       
        
        
         
      }
      if(a.equals("1")){
       btnn.setEnabled(true);   
      }
       if(b.equals("1")){
       btng.setEnabled(true);   
      }
        if(c.equals("1")){
       btned.setEnabled(true);   
      }
         if(d.equals("1")){
       btnel.setEnabled(true);   
      }
          if(e.equals("1")){
       jButton2.setEnabled(true);   
      }
        
    
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

}
   void fpa(){
           
           PreparedStatement psd1,psd2,psd4;
  reloj();
   fech=fechaActual1(); 
 
   String SQL4="INSERT proact  (ce,pro,act,hor,fecha) VALUES (?,?,?,?,?)";
    try{
         
         
        psd4=cn.prepareStatement(SQL4);
         psd4.setString(1,cedu);
        psd4.setString(2,"GESTIÓN DE CHOFERES");
        psd4.setString(3,Acti);
         psd4.setString(4,Hora);
          psd4.setString(5, fech);
          
           
           int Up=psd4.executeUpdate();
           if(Up==1){
              
               JOptionPane.showMessageDialog(null,"GUARDADO PROACT");
           }
          } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error proact");
          
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
        btnn = new javax.swing.JButton();
        btng = new javax.swing.JButton();
        btned = new javax.swing.JButton();
        btnel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtci = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtap = new javax.swing.JTextField();
        spedad = new javax.swing.JSpinner();
        txttl = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdir = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ser = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtbusq = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        coDinero = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TOTA = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(20, 136, 238));

        btnn.setBackground(new java.awt.Color(0, 0, 0));
        btnn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11));
        btnn.setForeground(new java.awt.Color(255, 255, 255));
        btnn.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\plus.png")); // NOI18N
        btnn.setText("NUEVO");
        btnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnActionPerformed(evt);
            }
        });

        btng.setBackground(new java.awt.Color(0, 0, 0));
        btng.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11));
        btng.setForeground(new java.awt.Color(255, 255, 255));
        btng.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\install.png")); // NOI18N
        btng.setText("GUARDAR");
        btng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngActionPerformed(evt);
            }
        });

        btned.setBackground(new java.awt.Color(0, 0, 0));
        btned.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11));
        btned.setForeground(new java.awt.Color(255, 255, 255));
        btned.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\edit.png")); // NOI18N
        btned.setText("EDITAR");
        btned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedActionPerformed(evt);
            }
        });

        btnel.setBackground(new java.awt.Color(0, 0, 0));
        btnel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11));
        btnel.setForeground(new java.awt.Color(255, 255, 255));
        btnel.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\trash full.png")); // NOI18N
        btnel.setText("ELIMINAR");
        btnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnn, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(btng, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addComponent(btned, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addComponent(btnel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btng, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btned, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(149, 200, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE CHOFER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtci.setFont(new java.awt.Font("Monospaced", 1, 14));
        txtci.setText("cedula");
        txtci.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        txtno.setFont(new java.awt.Font("Monospaced", 1, 14));
        txtno.setText("nombres");
        txtno.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        txtap.setFont(new java.awt.Font("Monospaced", 1, 14));
        txtap.setText("apellidos");
        txtap.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        spedad.setFont(new java.awt.Font("Tahoma", 1, 14));
        spedad.setModel(new javax.swing.SpinnerNumberModel(18, 18, 60, 1));

        txttl.setFont(new java.awt.Font("Monospaced", 1, 14));
        txttl.setText("telefono");
        txttl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        txtdir.setColumns(20);
        txtdir.setFont(new java.awt.Font("Monospaced", 1, 14));
        txtdir.setRows(5);
        txtdir.setText("direccion");
        txtdir.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtdir);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DIRECCION");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TELEFONO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("EDAD");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("APELLIDOS");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NOMBRES");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CEDULA");

        jPanel3.setBackground(new java.awt.Color(20, 136, 238));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        txtbusq.setFont(new java.awt.Font("Monospaced", 1, 14));
        txtbusq.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        txtbusq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusqKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CEDULA");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\search.png")); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(txtbusq, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel8)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbusq, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(20, 136, 238));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\new doc.png")); // NOI18N
        jButton2.setText("Generar Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        coDinero.setFont(new java.awt.Font("Tahoma", 1, 14));
        coDinero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        coDinero.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(coDinero);

        jPanel5.setBackground(new java.awt.Color(20, 136, 238));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("GAN.TOTAL:");

        TOTA.setFont(new java.awt.Font("Tahoma", 1, 12));
        TOTA.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TOTA, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TOTA, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 498, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addComponent(txtap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtci, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(spedad, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(txttl, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                            .addComponent(txtno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(ser, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtci, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spedad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(ser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setBackground(new java.awt.Color(149, 200, 248));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTIÒN DE CHOFERES");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnActionPerformed
nuevo();
nuevol();

Ac=1;
}//GEN-LAST:event_btnnActionPerformed

private void btngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngActionPerformed
String nom,ape,dir,edad1,din="0";
int tel=0,ci=0;

ci=Integer.valueOf(txtci.getText());

edad1=String.valueOf(spedad.getValue());
nom=txtno.getText();
ape=txtap.getText();
dir=txtdir.getText();
 tel=Integer.valueOf(txttl.getText());
String SQL1;




PreparedStatement psd,psd1;
switch(Ac){
    
    case 1:
         if((ci==0)||(nom.isEmpty())||(ape.isEmpty())||(dir.isEmpty())||(tel==0))
       {
          
           
         JOptionPane.showMessageDialog(null,"Por favor llene todos los campos.!");
       }
       else
       {
        SQL1="INSERT INTO chofer (cedula,nombres,apellidos,edad,telefono,direccion,dineroCh) VALUES (?,?,?,?,?,?,?)";
    try{
        psd=cn.prepareStatement(SQL1);
         psd.setInt(1,ci);
        psd.setString(2,nom);
        psd.setString(3,ape);
         psd.setString(4,edad1);
          psd.setInt(5,tel);
           psd.setString(6,dir);
            psd.setString(7,din);
           
           int Up=psd.executeUpdate();
           if(Up==1){
               nuevol();
               nuevob();
               Acti="REGISTRO NUEVO";
               fpa();
               JOptionPane.showMessageDialog(null,"Guardado Exitoso");
           }
           
        String  SQL2="INSERT INTO cedulach(cedulas) VALUES (?)"; 
        try{
          psd1=cn.prepareStatement(SQL2);
          psd1.setInt(1, ci);
           psd1.executeUpdate();
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error En cedulach");
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error datos");
        
    }
    }
    break;
    case 2:
           if((ci==0)||(nom.isEmpty())||(ape.isEmpty())||(dir.isEmpty())||(tel==0))
       {
          
           
         JOptionPane.showMessageDialog(null,"Por favor llene todos los campos.!");
       }
       else
       {
        SQL1="UPDATE chofer set cedula=?,nombres=?,apellidos=?,edad=?,telefono=?,direccion=? WHERE cedula=? ";
try{
     psd = cn.prepareStatement(SQL1);
    
       psd.setInt(1,ci);
        psd.setString(2,nom);
        psd.setString(3,ape);
         psd.setString(4,edad1);
          psd.setInt(5,tel);
           psd.setString(6,dir);
           
           psd.setString(7,cod);
           int n=psd.executeUpdate();
           
           if(n>0){
                nuevol();
               nuevob();
              Acti="REGISTRO EDITADO";
                fpa();
            JOptionPane.showMessageDialog(null,"Guardado Exitoso");     
           }
           
} catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error datos");
        
    } }
    break;



}
// TODO add your handling code here:
}//GEN-LAST:event_btngActionPerformed

private void btnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedActionPerformed

String SQL1;
nuevo();
nuevol();
Ac=2;
 cod= JOptionPane.showInputDialog("Introdusca codigo:");
 
     if(( cod.isEmpty()))
       {
          
           
         JOptionPane.showMessageDialog(null,"Por favor llene todos los campos.!");
       }
       else
       {
    
try{
    
   SQL1="SELECT * FROM chofer WHERE cedula="+ cod;
       st = this.cn.createStatement();
           ResultSet rs = st.executeQuery(SQL1);
           rs.next();
            txtci.setText(rs.getString("cedula"));
    spedad.setValue(rs.getInt("edad"));
   txtno.setText(rs.getString("nombres"));
   txtap.setText(rs.getString("apellidos"));
   txttl.setText(String.valueOf(rs.getInt("telefono")));
   txtdir.setText(rs.getString("direccion"));
   
   
      
}
  catch (SQLException ex) {}}
  
}//GEN-LAST:event_btnedActionPerformed

private void btnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelActionPerformed
String SQL1;
nuevo();
nuevol();
Ac=2;
 cod= JOptionPane.showInputDialog("Introdusca codigo:");
  
     if(( cod.isEmpty()))
       {
          
           
         JOptionPane.showMessageDialog(null,"Por favor llene todos los campos.!");
       }
       else
       {
    
try{
    
   SQL1="SELECT * FROM chofer WHERE cedula="+ cod;
       st = this.cn.createStatement();
           ResultSet rs = st.executeQuery(SQL1);
           rs.next();
            txtci.setText(rs.getString("cedula"));
    spedad.setValue(rs.getInt("edad"));
   txtno.setText(rs.getString("nombres"));
   txtap.setText(rs.getString("apellidos"));
   txttl.setText(String.valueOf(rs.getInt("telefono")));
   txtdir.setText(rs.getString("direccion"));
   
   
      
int resp = JOptionPane.showConfirmDialog(this, "Deseas Eliminarlo", "Eliminar Dato", 0);
      if (resp == 0) {
   try
        {
          PreparedStatement psd = null;
          SQL1 = " DELETE FROM chofer WHERE cedula ='" + cod + "'";
          psd = this.cn.prepareStatement(SQL1);
          psd.execute();
          psd.close();
          nuevol();
               nuevob();
               Acti="REGISTRO ELIMINADO";
                 fpa();
          JOptionPane.showMessageDialog(this, "REGISTRO ELIMINADO");
          
        }
        
        catch (SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error SQL no se Eliminaron");
        }
      }else{
     JOptionPane.showMessageDialog(null, "No existe");
} 
    
 }catch (SQLException ex) {} }
  

}//GEN-LAST:event_btnelActionPerformed

private void txtbusqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusqKeyReleased

}//GEN-LAST:event_txtbusqKeyReleased

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
data();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
List lista= new ArrayList();
for(int i=0;i<coDinero.getRowCount();i++){    
  listaClientes1111 clientes= new  listaClientes1111 (coDinero.getValueAt(i,0).toString(),coDinero.getValueAt(i,1).toString(),coDinero.getValueAt(i,2).toString(),coDinero.getValueAt(i,3).toString(),coDinero.getValueAt(i,4).toString(),coDinero.getValueAt(i,5).toString(),coDinero.getValueAt(i,6).toString());  
lista.add(clientes);
}
        try{
            
             String fileJasper = "C:\\REPORTES\\report44.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(fileJasper);
            Map parametro=new HashMap();
            parametro.put("cedula",txtbusq.getText());
            JasperPrint Jprint= JasperFillManager.fillReport(reporte,parametro,new JRBeanCollectionDataSource(lista));
             Acti="REPORTE";
            fpa();
            JasperViewer.viewReport(Jprint,false);
            
        } catch (JRException ex) {
            Logger.getLogger(chofer1.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO 
}//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(chofer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chofer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chofer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chofer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new chofer1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TOTA;
    private javax.swing.JButton btned;
    private javax.swing.JButton btnel;
    private javax.swing.JButton btng;
    private javax.swing.JButton btnn;
    private javax.swing.JTable coDinero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel ser;
    private javax.swing.JSpinner spedad;
    private javax.swing.JTextField txtap;
    private javax.swing.JTextField txtbusq;
    private javax.swing.JTextField txtci;
    private javax.swing.JTextArea txtdir;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txttl;
    // End of variables declaration//GEN-END:variables
}
