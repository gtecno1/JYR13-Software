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
import net.sf.jasperreports.view.JasperViewer;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author black
 */
public class CosultaServicio extends javax.swing.JFrame {
DefaultTableModel model;
CBD cc= new CBD();
Connection cn= cc.Conectar();
Statement st = null;
 String j,g,ak,bk,cedu,fac;
 String a,b,cd,d,e,f,k,h,ih,t,s,l,m,y,r;
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
    public CosultaServicio() {
        initComponents();
         this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cargar5("","","","","");
         rbtn.setEnabled(false); 
         jButton3.setEnabled(false); 
         activi();
    
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
      psd4.setString(2, "Consulta de SERVICIO");
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
  
     void sumafa()
  {
    try
    {
      String SQL2 = "SELECT MAX(factuid)  FROM  fac";
      
      Statement st2 = null;
      st2 = this.cn.createStatement();
      ResultSet rs = st2.executeQuery(SQL2);
      rs.next();
      int q = rs.getInt("MAX(factuid)");
      int v = (10 + q);
      
     faj.setText( fac=(String.valueOf(v)));
    }
    catch (SQLException ex) {}
  }
      void guardarfa()
  {
    try
    {
      String SQL2 = "INSERT INTO fac (factuid) VALUES (?)";
      PreparedStatement psd;
      psd=cn.prepareStatement(SQL2);
         psd.setString(1,faj.getText());
 
          psd.executeUpdate();
    }
    catch (SQLException ex) {
        
        
    }
  }
      
     
 /*void cargar2(String valor,String valor2)
  {
    try
    {
       String[] titulos = {"ID SERVICIO","SEGURO","MARCA","MODELO","COLOR","AÑO","PLACA","PROPIETARIO","TELEFONO","LUGAR ACC","LUGAR DES","FALLAS","CHOFER","COSTO","FECHA"};
      String[] registros = new String[15];
      this.model = new DefaultTableModel((Object[][])null, titulos);
      
      String cons = "select * from servicio where id LIKE '%" + valor + "%' AND costo LIKE '%" + valor2 + "%' or  fecha2 between "+j+" and "+g+"  "  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(cons);
                
      while (rs.next())
      {
           registros[0] = rs.getString("id");
        registros[1] = rs.getString("Seguro");
        registros[2] = rs.getString("marca");
        registros[3] = rs.getString("modelo");
        registros[4] = rs.getString("color");
        registros[5] = rs.getString("año");
        registros[6] = rs.getString("placa");
        registros[7] = rs.getString("nombre");
         registros[8] = rs.getString("telefono");
          registros[9] = rs.getString("Laccidente");
           registros[10] = rs.getString("Ldestino");
            registros[11] = rs.getString("Fallas");
             registros[12] = rs.getString("chofer");
              registros[13] = rs.getString("costo");
               registros[14] = rs.getString("fecha");
               
       
       
        this.model.addRow(registros);
        String sql="SELECT count(*)  FROM servicio where fecha2 between "+j+" and "+g+" ";
   
  
  String sql2="select SUM(costo) FROM  servicio where  fecha2 between "+j+" and "+g+" ";
    
  
             Statement st0 = cn.createStatement();
               ResultSet rs0=st0.executeQuery(sql);
               while(rs0.next()){
                 
                  Nuser.setText(rs0.getString("count(*)"));
        
          
                   
               }
               Statement st1 = cn.createStatement();
               ResultSet rs1=st1.executeQuery(sql2);
               while(rs1.next()){
                 
                  Costser.setText(rs1.getString("SUM(costo)"));
                    
                                  
               }
                
        
      }
      this.coDinero.setModel(this.model);
      this.coDinero.getColumnModel().getColumn(0).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(1).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(2).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(3).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(4).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(5).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(6).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(7).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(8).setPreferredWidth(100); 
      this.coDinero.getColumnModel().getColumn(9).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(10).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.coDinero.getColumnModel().getColumn(12).setPreferredWidth(100);
         this.coDinero.getColumnModel().getColumn(13).setPreferredWidth(100);
          this.coDinero.getColumnModel().getColumn(14).setPreferredWidth(100);
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }*/
     void cargar(String valor)
  {
    try
    {
      String[] titulos = {"Codigo","Seguro","Marca","Modelo","Color","Año","Placa","Propietario","Telefono","Lugar Acc","Lugar Des","Fallas","Chofer","Costo","Fecha"};
      
      String[] registros = new String[15];
      this.model = new DefaultTableModel((Object[][])null, titulos);
      
      String cons = "select * from servicio where  id LIKE '%" + valor + "%'"  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(cons);
                
      while (rs.next())
      {
        registros[0] = rs.getString("id");
        registros[1] = rs.getString("Seguro");
        registros[2] = rs.getString("marca");
        registros[3] = rs.getString("modelo");
        registros[4] = rs.getString("color");
        registros[5] = rs.getString("año");
        registros[6] = rs.getString("placa");
        registros[7] = rs.getString("nombre");
         registros[8] = rs.getString("telefono");
          registros[9] = rs.getString("Laccidente");
           registros[10] = rs.getString("Ldestino");
            registros[11] = rs.getString("Fallas");
             registros[12] = rs.getString("chofer");
              registros[13] = rs.getString("costo");
               registros[14] = rs.getString("fecha");
               
                 
       
        this.model.addRow(registros);
       
      }
      String sql="SELECT count(*)  FROM servicio where CONCAT (id) LIKE '%"+valor+"%' ";
   
  
  String sql2="select SUM(costo) FROM  servicio where CONCAT (id)  LIKE '%"+valor+"%' ";
  
             Statement st0 = cn.createStatement();
               ResultSet rs0=st0.executeQuery(sql);
               while(rs0.next()){
                 
                  Nuser.setText(rs0.getString("count(*)"));
        
          
                   
               }
               Statement st1 = cn.createStatement();
               ResultSet rs1=st1.executeQuery(sql2);
               while(rs1.next()){
                 
                  Costser.setText(rs1.getString("SUM(costo)"));
                    
                                  
               }
                
      this.coDinero.setModel(this.model);
      
      
      this.coDinero.getColumnModel().getColumn(0).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(1).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(2).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(3).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(4).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(5).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(6).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(7).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(8).setPreferredWidth(100); 
      this.coDinero.getColumnModel().getColumn(9).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(10).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.coDinero.getColumnModel().getColumn(12).setPreferredWidth(100);
         this.coDinero.getColumnModel().getColumn(13).setPreferredWidth(100);
          this.coDinero.getColumnModel().getColumn(14).setPreferredWidth(100);
      
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
      void cargar5(String valor,String valor1,String valor2,String valor3,String valor4)
  {
    try
    {
      String[] titulos = {"Codigo","Seguro","Marca","Modelo","Color","Año","Placa","Propietario","Telefono","Lugar Acc","Lugar Des","Fallas","Chofer","Costo","Fecha"};
      
      String[] registros = new String[15];
      this.model = new DefaultTableModel((Object[][])null, titulos);
      
      String cons = "select * from servicio where Seguro LIKE '%" + valor + "%' AND marca LIKE '%" + valor1 + "%' AND color LIKE '%" + valor2 + "%' AND año LIKE '%" + valor3 + "%' AND fecha LIKE '%" + valor4 + "%'"  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(cons);
                
      while (rs.next())
      {
        registros[0] = rs.getString("id");
        registros[1] = rs.getString("Seguro");
        registros[2] = rs.getString("marca");
        registros[3] = rs.getString("modelo");
        registros[4] = rs.getString("color");
        registros[5] = rs.getString("año");
        registros[6] = rs.getString("placa");
        registros[7] = rs.getString("nombre");
         registros[8] = rs.getString("telefono");
          registros[9] = rs.getString("Laccidente");
           registros[10] = rs.getString("Ldestino");
            registros[11] = rs.getString("Fallas");
             registros[12] = rs.getString("chofer");
              registros[13] = rs.getString("costo");
               registros[14] = rs.getString("fecha");
               
                 
       
        this.model.addRow(registros);
       
      }
      String sql="SELECT count(*)  FROM servicio where  Seguro LIKE '%"+valor+"%' and marca  LIKE '%"+valor1+"%' and color LIKE '%"+valor2+"%' and año LIKE '%"+valor3+"%' and fecha LIKE '%"+valor4+"%'  ";
   
  
  String sql2="select SUM(costo) FROM  servicio where Seguro LIKE '%"+valor+"%' and marca  LIKE '%"+valor1+"%' and color LIKE '%"+valor2+"%' and año LIKE '%"+valor3+"%' and fecha LIKE '%"+valor4+"%' ";
    
  
             Statement st0 = cn.createStatement();
               ResultSet rs0=st0.executeQuery(sql);
               while(rs0.next()){
                 
                  Nuser.setText(rs0.getString("count(*)"));
        
          
                   
               }
               Statement st1 = cn.createStatement();
               ResultSet rs1=st1.executeQuery(sql2);
               while(rs1.next()){
                 
                  Costser.setText(rs1.getString("SUM(costo)"));
                    
                                  
               }
       this.coDinero.setModel(this.model);
      
      this.coDinero.getColumnModel().getColumn(0).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(1).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(2).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(3).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(4).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(5).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(6).setPreferredWidth(50);
      this.coDinero.getColumnModel().getColumn(7).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(8).setPreferredWidth(100); 
      this.coDinero.getColumnModel().getColumn(9).setPreferredWidth(100);
      this.coDinero.getColumnModel().getColumn(10).setPreferredWidth(100);
       this.coDinero.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.coDinero.getColumnModel().getColumn(12).setPreferredWidth(100);
         this.coDinero.getColumnModel().getColumn(13).setPreferredWidth(100);
          this.coDinero.getColumnModel().getColumn(14).setPreferredWidth(100);
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
    
       
      String as  =String.valueOf(boxseg.getSelectedItem());
      String bs  =String.valueOf(boxmar.getSelectedItem());
      String cs  =String.valueOf(boxcol.getSelectedItem());
      String ds  =String.valueOf(Spaño.getValue());
      String es  =j;
     
      
    
             
                
                cargar5(as,bs,cs,ds,es);
                
     }
        void activi(){
          try { 
     String SQL = "select * from actividades WHERE activo= '"+1+"' "  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
                
      while (rs.next())
      {
        
       ak= rs.getString("DN");
       bk= rs.getString("DG");
      
       
       cedu= rs.getString("cedula");
       
       
        
        
         
      }
      if(ak.equals("1")){
      rbtn.setEnabled(true);
           
      }
        if(bk.equals("1")){
        jButton3.setEnabled(true);          
         
      }
      
        
    
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
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

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dat = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        boxseg = new javax.swing.JComboBox();
        boxmar = new javax.swing.JComboBox();
        boxcol = new javax.swing.JComboBox();
        Spaño = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
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
        rbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        faj = new javax.swing.JLabel();
        jbr = new javax.swing.JLabel();

        jLabel4.setBackground(new java.awt.Color(149, 200, 248));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FECHA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(149, 200, 248));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA  D E  S E R V I C I O");
        jLabel1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(149, 200, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSQUEDA AVANZADA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        dat.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        dat.setDateFormatString("dd-MM-yyy");
        dat.setFont(new java.awt.Font("Monospaced", 1, 14));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\search.png")); // NOI18N
        jButton2.setText("BUSAR");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.setPreferredSize(new java.awt.Dimension(127, 47));
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

        boxmar.setFont(new java.awt.Font("Tahoma", 1, 12));
        boxmar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--MARCA--", "9ff ", "Abarth ", "Abt ", "AC Propulsion ", "AC Schnitzer ", "AC ", "Acoma ", "Acrea ", "Acura ", "A:level ", "Adams Probe ", "Aero Willys ", "Aixam ", "Aleko ", "Alessi ", "Alfa Romeo ", "Allard ", "Alpina ", "Alvis ", "AMC ", "American Bamtan ", "Amoritz ", "Anadol ", "Anibal ", "Anteros ", "Apal ", "Apollo ", "Aptera ", "AQC ", "Aquila ", "Arash ", "Arex ", "Argyll ", "ARH ", "Ariel Atom ", "Arkley ", "Armstrong Siddeley ", "Arnold Bristol ", "ARO ", "Arrinera ", "Arta Garaiya ", "Artega ", "Artés ", "Asardo ", "Ascari ", "Ashok Leyland ", "Asia Motors ", "ASL ", "Aspid ", "Aston Martin ", "Astra ", "Atalanta ", "ATS ", "Auburn ", "Audi ", "Austin ", "Auto Avio ", "Autobacs ", "Autobianchi ", "Autocars ", "Autozam ", "Auverland ", "Avia ", "Aymesa ", "B. engineering ", "Bac ", "Bag Splitz ", "Bajaj ", "Ballot ", "Bandini ", "Baojun ", "Bargon ", "Baw ", "Beck ", "Bell Aurens ", "Bell-Ross ", "Bellier ", "Belumbury ", "Bentley ", "Berkeley ", "Bertone ", "BF Performance ", "Bill Tomas ", "Birkin ", "Bitter ", "Bizzarrini ", "Blakely ", "Bmw ", "Bohse ", "Bolwell ", "Bond ", "Borgward ", "Brabham ", "Brabus ", "Breckland ", "Bricklin ", "Brilliance ", "Bristol ", "Brokernet ", "Bucciali ", "Bufori ", "Bugatti ", "Buick ", "Bulldog ", "Burgfalke ", "BYD ", "Cadillac ", "Callaway ", "Camo Marauder ", "Campagna ", "Caparo ", "Capstone ", "Carbontech ", "Cardi ", "Carice ", "Carlsson ", "Carver One ", "Casalini ", "Case ", "Castagna ", "Caterham ", "Caterpillar ", "Chana ", "Changan ", "Changfeng ", "Checker ", "Chery ", "Chevrolet ", "Chrysler ", "Citröen ", "Cizeta ", "Clan ", "Clenet ", "Climax ", "Clua ", "Coda ", "Comarth ", "Condor Aguzzoli ", "Connaught ", "Conquest Knight ", "Corbin ", "Cord ", "Covini ", "Crosley ", "Cross Lander ", "Cunninham ", "Dacia ", "Daewoo ", "DAF ", "Daihatsu ", "Dare ", "Darl´Mat ", "Dartmoor ", "Dartz ", "Datsun ", "David Brown Automotive ", "Davis ", "DB ", "DC Desing ", "DDR ", "De Dion ", "De La Chapelle ", "De Macross ", "De Tomaso ", "Dean Jefries ", "Delage ", "Delahaye ", "Delfino ", "Delorean ", "Deronda ", "Derways ", "Desoto ", "Detroit Electric ", "Devaux ", "Devel ", "Devon ", "Diatto ", "Didia ", "Divco ", "DKW ", "Dodge ", "Dome ", "Dongfeng ", "Donkervoort ", "Duesenberg ", "Ebbro Btec ", "EDAG ", "Edo ", "Edsel ", "Eagle ", "Elfin ", "Elio Motors ", "Elva ", "Emme ", "Enzman ", "ERF ", "Ermini ", "Eterniti ", "EuropeStar ", "Evante ", "Evans ", "E-Wolf ", "Exagon ", "Facel Vega ", "Fairthorpe ", "Falcon ", "falhke ", "Faralli & Mazzanti ", "Farbio ", "Farboud ", "Farus ", "Faw ", "Felino ", "Fenix Automotive ", "Ferrari ", "Ferves ", "Fiat ", "Fiberfab ", "Fioravanti ", "Fisher ", "Fisker ", "Flajole ", "FM Auto ", "Force ", "Ford ", "Fornasari ", "Four Stroke ", "Fournier ", "FPV ", "Francis Lombardi ", "Franklin ", "FreeStream ", "Freightliner ", "Gaz ", "Galloper ", "GD ", "Geely ", "Geiger ", "Gemballa ", "Genevart ", "Genty ", "Ghia ", "Gibbs ", "Gillet ", "Ginetta ", "Glas ", "Glasspar ", "GM ", "GMC ", "Gonow ", "Gordini ", "Gordon Kleebe ", "Gordon Murray ", "Graham-Paige ", "Great Wall ", "Grecav ", "Griffith ", "GTA ", "GTM ", "Gumpert ", "Gurgel ", "GWA ", "Haima ", "Hamann ", "Heffner Performance ", "Henry J ", "Hennessey ", "Heuliez ", "Hillman ", "Hindustan ", "Hino ", "Hispano Suiza ", "HMC ", "Hoftetter ", "Holden ", "Hommell ", "Honda ", "Hongqi ", "Horch ", "Hotchkiss ", "HSV ", "HTT ", "Hulme ", "Humber ", "Hummer ", "Hurtan ", "Hyundai ", "Icona ", "identity ", "Idries ", "IED ", "IMSA ", "Imperia ", "Infiniti ", "Innocenti ", "Innotech ", "International ", "International Haverter ", "Invicta ", "Iran Khodro ", "Irmscher ", "Isdera ", "Iso ", "Isotta ", "Isuzu ", "ItalDesing ", "Iveco ", "Izaro ", "JAC ", "Jaguar ", "Jakusa ", "Javan ", "JBA ", "JDM ", "Jeep ", "Jensen ", "Jimenez Novia ", "Jiotto ", "Joss ", "Jösse ", "Justicialista ", "K1 ", "Kaipan ", "Kaiser ", "Kawasaki ", "Keating ", "Keinath ", "Kenworth ", "Kia ", "Kleemann ", "Kodiak ", "Koeningsegg ", "Korres ", "KTM ", "La salle ", "Lada ", "Ladalat ", "Laforza ", "Lagonda ", "Lamborghini ", "Lanchester ", "Lancia ", "Land Rover ", "Landwind ", "Laraki ", "LCC ", "LDV ", "Le Marquis ", "Le Blanc ", "Lea Francis ", "Leopard ", "Leyland ", "Lexus ", "Liege ", "Lightburn ", "Lightning ", "Ligier ", "Lincoln ", "Lister ", "Lloyd ", "LM Sovra ", "LMX ", "Lobini ", "Locus ", "Lola ", "Lombardi ", "Loremo ", "Lotec ", "Lotus ", "Lucra ", "Luxgen ", "Lyonheart ", "Mahindra ", "Maico ", "Magna Steyr ", "Man ", "Manganese ", "Manic ", "Mansory ", "Marcadier ", "Marcos ", "Marlin ", "Marmon ", "Marussia ", "Maserati ", "Mastretta ", "Mathis ", "Matra ", "Maybach ", "MAZ ", "Mazda ", "Mazel ", "MB Roadcars ", "MCA ", "McLaren ", "MCV ", "Mega ", "Melkus ", "Mercedez Benz ", "Mercer ", "Mercury ", "Meyers ", "MG ", "MHV ", "Mindset ", "Minerva ", "Mini ", "Mitchell ", "Mitsubishi ", "Mitsuoka ", "MMI ", "Mohs Ostentatine ", "Monteverdi ", "Morgan ", "Mosler ", "Mostro Di Potenza ", "Mullen ", "Nami ", "Nardi Española ", "Nash ", "Nismo ", "Nissan ", "Noble ", "Nova ", "NSU ", "Obvio ", "Oldsmobile ", "Oltcit ", "Opel ", "Orca ", "OSI ", "Osca ", "Packard ", "Pagani ", "Panhard ", "Panoz ", "Panther ", "Parradine ", "Pars Khodro ", "Pegas ", "Pegaso ", "Pemblenton ", "Penske ", "Perodua ", "Peugeot ", "PGO ", "Pierce Arrow ", "Pilgrim ", "Pininfarina ", "Plymount ", "Poncin ", "Pontiac ", "Porsche ", "Praga ", "Prince ", "Proton ", "Protoscar ", "PTG ", "Puma Car ", "Puritalia ", "Qiantu ", "Quoros ", "Quimera ", "Qvale ", "Radical ", "Rambler ", "Rapier Automotive ", "Reliant ", "Renaissance ", "Renauld ", "Renauld Alpine ", "Rene Bonnet ", "RENNtech ", "Reo ", "Rezvani ", "Riley & Scott ", "Riley ", "Rimac ", "Rinho ", "Rinspeed ", "Robur ", "Roding ", "Rolls Royce ", "Ronart ", "Rossion ", "Roush ", "Rover ", "Royale ", "RSC ", "Russo-Baltique ", "Ruf ", "Saab ", "Saipa ", "Saleem ", "Salmson ", "Samsung ", "Santa Matilde ", "Santana ", "Saturn ", "Savage ", "Sbarro ", "Scania ", "Schuppan ", "Scion ", "Seat ", "Secma ", "Shacman ", "Shayton ", "Shelby SuperCars SSC ", "Siata ", "Simca ", "Singer ", "Skoda ", "Smart ", "Soueast ", "Spada ", "Spartan ", "Spectre ", "SpeedArt ", "Sportec ", "Spyker ", "Ssang Yong ", "Stand Craft ", "Startech ", "Stealth ", "Sterling ", "Steyr ", "Strathcarron ", "Strosek ", "Studebaker ", "Studio Torino ", "Stutz ", "Subaru ", "Sunbean ", "Sunred ", "Superlite ", "Suzuki ", "Suzusho ", "Syrena ", "Tagaz ", "Talbot ", "Tata ", "Tatra ", "tavria ", "Tauro ", "Tazzari ", "TechArt ", "Tesla ", "Tornado ", "Toroidion ", "Toyota ", "Trabant ", "Tramontana ", "TranStar ", "Trident ", "Triumph ", "Troller ", "Tucker ", "Tushek ", "TVR ", "UAZ ", "Ultima ", "UMM ", "Unipower ", "URI ", "URO ", "Valmet ", "Vanden Plas ", "Vandenbrink ", "Vanwall ", "Vauxhall ", "Vaydor ", "VDS ", "Vector ", "Velam Isseta ", "Velanturi ", "Vemac ", "Vemag ", "Vencer ", "Venirauto ", "Venturi ", "Venucia ", "Veritas ", "Vespa Automovile ", "Vidi ", "Vision ", "Voisin ", "Volga ", "Volkswagen ", "Volvo ", "Vortex ", "Vuhl ", "Vulcan ", "Wald ", "Walley Larson ", "Wanderer ", "Wartburg ", "Weineck ", "Western Star ", "Westfield ", "Wiesmann ", "Willy's ", "Wolseley ", "W-Motors ", "Yamaha ", "Yes ", "Yo-Auto ", "Yo-Mobile ", "Yugo ", "Zagato ", "Zap ", "Zarooq ", "Zavasta ", "ZAZ ", "Zender ", "Zenos ", "Zenvo ", "Zeus Twelve ", "Zil ", "Zimmer ", "Zinoro ", "Zolfe ", "Zotye ", "total parcial:622" }));
        boxmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxmarActionPerformed(evt);
            }
        });

        boxcol.setFont(new java.awt.Font("Tahoma", 1, 12));
        boxcol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--COLOR--", "Rojo", "Azul", "Blanco", "Negro", "Amarillo", "Naranja", "Verde", "Plateado" }));

        Spaño.setFont(new java.awt.Font("Monospaced", 1, 18));
        Spaño.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1900), Integer.valueOf(1900), null, Integer.valueOf(1)));
        Spaño.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AÑO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(boxseg, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Spaño, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxmar, 0, 165, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxcol, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxseg, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxmar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxcol, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spaño, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel2.setBackground(new java.awt.Color(149, 200, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSQUEDA POR ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
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
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(txtbusq, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addGap(64, 64, 64))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbusq, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(149, 200, 248));

        coDinero.setFont(new java.awt.Font("Tahoma", 1, 10));
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

        jPanel3.setBackground(new java.awt.Color(20, 136, 238));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("SERVICIOS TOTALES");

        Nuser.setFont(new java.awt.Font("Tahoma", 1, 14));
        Nuser.setText("jLabel8");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("COSTO TOTAL");

        Costser.setFont(new java.awt.Font("Tahoma", 1, 14));
        Costser.setText("jLabel7");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Nuser, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Costser, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nuser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Costser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        rbtn.setBackground(new java.awt.Color(0, 0, 0));
        rbtn.setForeground(new java.awt.Color(255, 255, 255));
        rbtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\copy doc.png")); // NOI18N
        rbtn.setText("Generar Factura");
        rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\new doc.png")); // NOI18N
        jButton3.setText("Genarar Reporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(rbtn)
                                .addGap(26, 26, 26)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                                .addComponent(jbr)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(faj)
                                .addGap(122, 122, 122)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(jbr))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(faj)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

private void rbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActionPerformed
sumafa();
    List lista= new ArrayList();
for(int i=0;i<coDinero.getRowCount();i++){    
  listaClientes1 clientes= new  listaClientes1 (coDinero.getValueAt(i,0).toString(),coDinero.getValueAt(i,14).toString(),coDinero.getValueAt(i,6).toString(),coDinero.getValueAt(i,7).toString(),coDinero.getValueAt(i,13).toString(),Costser.getText().toString(),faj.getText().toString());  
lista.add(clientes);
}
        try{
            
             String fileJasper = "C:\\REPORTES\\report2.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(fileJasper);
            Map parametro=new HashMap();
            parametro.put("seguro",boxseg.getSelectedItem());
            JasperPrint Jprint= JasperFillManager.fillReport(reporte,parametro,new JRBeanCollectionDataSource(lista));
           Acti="FACTURA-"+faj.getText();
           fpa();
            guardarfa();
            JasperViewer.viewReport(Jprint,false);
           
        } catch (JRException ex) {
            Logger.getLogger(CosultaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_rbtnActionPerformed

private void boxmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxmarActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_boxmarActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
List lista= new ArrayList();
for(int i=0;i<coDinero.getRowCount();i++){    
  listaClientes11 clientes= new  listaClientes11 (coDinero.getValueAt(i,0).toString(),coDinero.getValueAt(i,1).toString(),coDinero.getValueAt(i,2).toString(),coDinero.getValueAt(i,3).toString(),coDinero.getValueAt(i,4).toString(),coDinero.getValueAt(i,5).toString(),coDinero.getValueAt(i,6).toString(),coDinero.getValueAt(i,7).toString(),coDinero.getValueAt(i,12).toString(),coDinero.getValueAt(i,13).toString(),coDinero.getValueAt(i,14).toString());  
lista.add(clientes);
}
        try{
            
             String fileJasper = "C:\\REPORTES\\report12.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(fileJasper);
            Map parametro=new HashMap();
            parametro.put("seguro",boxseg.getSelectedItem());
            JasperPrint Jprint= JasperFillManager.fillReport(reporte,parametro,new JRBeanCollectionDataSource(lista));
          Acti="REPORTE";
            fpa();
          
            JasperViewer.viewReport(Jprint,false);
            
        } catch (JRException ex) {
            Logger.getLogger(CosultaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(CosultaServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CosultaServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CosultaServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CosultaServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CosultaServicio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Costser;
    private javax.swing.JLabel Nuser;
    private javax.swing.JSpinner Spaño;
    private javax.swing.JComboBox boxcol;
    private javax.swing.JComboBox boxmar;
    private javax.swing.JComboBox boxseg;
    private javax.swing.JTable coDinero;
    private com.toedter.calendar.JDateChooser dat;
    private javax.swing.JLabel faj;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbr;
    private javax.swing.JButton rbtn;
    private javax.swing.JTextField txtbusq;
    // End of variables declaration//GEN-END:variables
}
