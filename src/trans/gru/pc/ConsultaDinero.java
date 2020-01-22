/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultaDinero.java
 *
 * Created on 22-ago-2016, 21:54:46
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author black
 */
public class ConsultaDinero extends javax.swing.JFrame {
DefaultTableModel model;
CBD cc= new CBD();
Connection cn= cc.Conectar();
Statement st = null;
 String j,g,a,cedu;
  String Hora;
  String fech;
  String Acti;
  public static String fechaActual1()
  {
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("    dd-MM-yyy");
    return formatoFecha.format(fecha);
  }
  

  
  void reloj()
  {
    Calendar car = Calendar.getInstance();
    
    String ap = String.valueOf(car.get(9));
    String mp;
   
    if (ap.equals("0")) {
      mp = "AM";
    } else {
      mp = "PM";
    }
    this.Hora = (car.get(10) + ":" + car.get(12) + ":" + car.get(13) + " " + mp);
  }
    /** Creates new form ConsultaDinero */
    public ConsultaDinero() {
        initComponents();
         this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jButton3.setEnabled(false);   
        activi();
        cargar("");
        cargar3("","","");
    
    }
     void fpa()
  {
    reloj();
    this.fech = fechaActual1();
    
    String SQL4 = "INSERT proact  (ce,pro,act,hor,fecha) VALUES (?,?,?,?,?)";
    try
    {
      PreparedStatement psd4 = this.cn.prepareStatement(SQL4);
      psd4.setString(1, this.cedu);
      psd4.setString(2, "Consulta de DINERO");
      psd4.setString(3, this.Acti);
      psd4.setString(4, this.Hora);
      psd4.setString(5, this.fech);
      
      psd4.executeUpdate();
     
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Error PROCESO/ACTIVIDAD");
    }
  }
  
    void activi(){
          try { 
     String SQL = "select * from actividades WHERE activo= '"+1+"' "  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
                
      while (rs.next())
      {
        
       a= rs.getString("DE");
      
       
       cedu= rs.getString("cedula");
       
       
        
        
         
      }
      if(a.equals("1")){
       jButton3.setEnabled(true);   
      }
      
        
    
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

}

     void cargar(String valor)
  {
    try
    {
      String[] titulos = {"ID SERVICIO","SEGURO","CI CHOFER","COSTO","G DE EMPRESA","G DE CHOFER","% DE CHOFER","FECHA"};
      
      String[] registros = new String[8];
      this.model = new DefaultTableModel((Object[][])null, titulos);
      
      String cons = "select * from dinero where  idservicio LIKE '%" + valor + "%'"  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(cons);
                
      while (rs.next())
      {
        registros[0] = rs.getString("idservicio");
        registros[1] = rs.getString("Seguro");
        registros[2] = rs.getString("idchofer");
        registros[3] = rs.getString("cosservicio");
        registros[4] = rs.getString("gananciaempresa");
        registros[5] = rs.getString("gananciachofer");
        registros[6] = rs.getString("porcentajeganchofer");
        registros[7] = rs.getString("fecha");
       
        this.model.addRow(registros);
      }
      String sql="SELECT count(*)  FROM dinero where CONCAT (idservicio) LIKE '%"+valor+"%' ";
   
  
  String sql2="select SUM(cosservicio) FROM  dinero where CONCAT (idservicio)  LIKE '%"+valor+"%' ";
    
   String sql3="select SUM(gananciaempresa) FROM  dinero where CONCAT (idservicio)  LIKE '%"+valor+"%' ";              
    String sql4="select SUM(gananciachofer) FROM  dinero where CONCAT (idservicio)  LIKE '%"+valor+"%' ";           
             Statement st0 = cn.createStatement();
               ResultSet rs0=st0.executeQuery(sql);
               while(rs0.next()){
                 
                  Nuser.setText(rs0.getString("count(*)"));
        
          
                   
               }
               Statement st1 = cn.createStatement();
               ResultSet rs1=st1.executeQuery(sql2);
               while(rs1.next()){
                 
                  Costser.setText(rs1.getString("SUM(cosservicio)"));
                    
                                  
               }
                 Statement st2 = cn.createStatement();
               ResultSet rs2=st2.executeQuery(sql3);
               while(rs2.next()){
                 
                  gemp.setText(rs2.getString("SUM(gananciaempresa)"));
                    
                                  
               }
                 Statement st3 = cn.createStatement();
               ResultSet rs3=st3.executeQuery(sql4);
               while(rs3.next()){
                 
                  gacho.setText(rs3.getString("SUM(gananciachofer)"));
                    
                                  
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
  
        void cargar3(String valor,String valor1,String valor2)
  {
    try
    {
      String[] titulos = {"ID SERVICIO","SEGURO","CI CHOFER","COSTO","G DE EMPRESA","G DE CHOFER","% DE CHOFER","FECHA"};
      
      String[] registros = new String[8];
      this.model = new DefaultTableModel((Object[][])null, titulos);
      
      String cons = "select * from dinero where  Seguro LIKE '%" + valor + "%' and idchofer LIKE '%" + valor1 + "%' and fecha LIKE '%" + valor2 + "%'"  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(cons);
                
      while (rs.next())
      {
        registros[0] = rs.getString("idservicio");
        registros[1] = rs.getString("Seguro");
        registros[2] = rs.getString("idchofer");
        registros[3] = rs.getString("cosservicio");
        registros[4] = rs.getString("gananciaempresa");
        registros[5] = rs.getString("gananciachofer");
        registros[6] = rs.getString("porcentajeganchofer");
        registros[7] = rs.getString("fecha");
       
        this.model.addRow(registros);
      }
       String sql="SELECT count(*)  FROM dinero where Seguro LIKE '%" + valor + "%' and idchofer LIKE '%" + valor1 + "%' and fecha LIKE '%" + valor2 + "%' ";
   
  
  String sql2="select SUM(cosservicio) FROM  dinero where Seguro LIKE '%" + valor + "%' and idchofer LIKE '%" + valor1 + "%' and fecha LIKE '%" + valor2 + "%' ";
    
   String sql3="select SUM(gananciaempresa) FROM  dinero where Seguro LIKE '%" + valor + "%' and idchofer LIKE '%" + valor1 + "%' and fecha LIKE '%" + valor2 + "%' ";              
    String sql4="select SUM(gananciachofer) FROM  dinero where Seguro LIKE '%" + valor + "%' and idchofer LIKE '%" + valor1 + "%' and fecha LIKE '%" + valor2 + "%' ";           
             Statement st0 = cn.createStatement();
               ResultSet rs0=st0.executeQuery(sql);
               while(rs0.next()){
                 
                  Nuser.setText(rs0.getString("count(*)"));
        
          
                   
               }
               Statement st1 = cn.createStatement();
               ResultSet rs1=st1.executeQuery(sql2);
               while(rs1.next()){
                 
                  Costser.setText(rs1.getString("SUM(cosservicio)"));
                    
                                  
               }
                 Statement st2 = cn.createStatement();
               ResultSet rs2=st2.executeQuery(sql3);
               while(rs2.next()){
                 
                  gemp.setText(rs2.getString("SUM(gananciaempresa)"));
                    
                                  
               }
                 Statement st3 = cn.createStatement();
               ResultSet rs3=st3.executeQuery(sql4);
               while(rs3.next()){
                 
                  gacho.setText(rs3.getString("SUM(gananciachofer)"));
                    
                                  
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
      void data2(){
        
       
          Date date=dat.getDate();
 String j= String.valueOf(date);
if(j.equals("null")){
    
   j=""; 
}
else{
     
String Captura=dat.getDateFormatString();
SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyy");
 j=sdf.format(date);  
    
}
      String a  =String.valueOf(boxseg.getSelectedItem());
       String b  =txtchof.getText();
        String c  =j;
      
    
             
                
                cargar3(a,b,c);
                
     }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dat = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        boxseg = new javax.swing.JComboBox();
        txtchof = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtbusq = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coDinero = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Nuser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Costser = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        gacho = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gemp = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(149, 200, 248));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE DINERO");
        jLabel1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(149, 200, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSQUEDA AVANZADA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        dat.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        dat.setDateFormatString("dd-MM-yyy");
        dat.setFont(new java.awt.Font("Monospaced", 1, 14));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\search.png")); // NOI18N
        jButton2.setText("BUSAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        boxseg.setFont(new java.awt.Font("Tahoma", 1, 14));
        boxseg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SEGUROS--", "dd" }));
        boxseg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxsegActionPerformed(evt);
            }
        });

        txtchof.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CEDULA DE CHOFER");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("FECHA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boxseg, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtchof, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel4)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxseg, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtchof, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(149, 200, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSQUEDA ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txtbusq.setFont(new java.awt.Font("Monospaced", 1, 14));
        txtbusq.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        txtbusq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusqKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID SERVICIO");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\search.png")); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(txtbusq, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbusq, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(20, 136, 238));

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
        jScrollPane1.setViewportView(coDinero);

        jPanel3.setBackground(new java.awt.Color(149, 200, 248));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SERVICIOS TOTALES");

        Nuser.setFont(new java.awt.Font("Tahoma", 1, 14));
        Nuser.setForeground(new java.awt.Color(255, 255, 255));
        Nuser.setText("jLabel8");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("COSTO TOTAL");

        Costser.setFont(new java.awt.Font("Tahoma", 1, 14));
        Costser.setForeground(new java.awt.Color(255, 255, 255));
        Costser.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("G.CH TOTAL");

        gacho.setFont(new java.awt.Font("Tahoma", 1, 14));
        gacho.setForeground(new java.awt.Color(255, 255, 255));
        gacho.setText("jLabel6");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("G.EMP TOTAL");

        gemp.setFont(new java.awt.Font("Tahoma", 1, 14));
        gemp.setForeground(new java.awt.Color(255, 255, 255));
        gemp.setText("jLabel6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nuser, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addComponent(Costser, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addGap(47, 47, 47))
                    .addComponent(gacho, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addComponent(gemp, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addGap(66, 66, 66))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gemp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Nuser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(gacho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Costser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\new doc.png")); // NOI18N
        jButton3.setText("Generar Reporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtbusqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusqKeyReleased

}//GEN-LAST:event_txtbusqKeyReleased

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
data();

}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
data2();
}//GEN-LAST:event_jButton2ActionPerformed

private void boxsegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxsegActionPerformed

    
}//GEN-LAST:event_boxsegActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
List lista= new ArrayList();
for(int i=0;i<coDinero.getRowCount();i++){    
  listaClientes111 clientes= new  listaClientes111 (coDinero.getValueAt(i,0).toString(),coDinero.getValueAt(i,1).toString(),coDinero.getValueAt(i,2).toString(),coDinero.getValueAt(i,3).toString(),coDinero.getValueAt(i,4).toString(),coDinero.getValueAt(i,5).toString(),coDinero.getValueAt(i,6).toString(),coDinero.getValueAt(i,7).toString());  
lista.add(clientes);
}
        try{
            
             String fileJasper = "C:\\REPORTES\\report3.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(fileJasper);
            Map parametro=new HashMap();
            parametro.put("idservicio",txtbusq.getText());
            JasperPrint Jprint= JasperFillManager.fillReport(reporte,parametro,new JRBeanCollectionDataSource(lista));
             Acti="REPORTE";
            fpa();
          
            JasperViewer.viewReport(Jprint,false);
            
        } catch (JRException ex) {
            Logger.getLogger(CosultaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaDinero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Costser;
    private javax.swing.JLabel Nuser;
    private javax.swing.JComboBox boxseg;
    private javax.swing.JTable coDinero;
    private com.toedter.calendar.JDateChooser dat;
    private javax.swing.JLabel gacho;
    private javax.swing.JLabel gemp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtbusq;
    private javax.swing.JTextField txtchof;
    // End of variables declaration//GEN-END:variables
}
