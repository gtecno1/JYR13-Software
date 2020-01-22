/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * control.java
 *
 * Created on 07/01/2017, 10:59:22 AM
 */
package trans.gru.pc;
import CBD.CBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author GeAnJi
 */
public class control extends javax.swing.JFrame {
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
      DefaultTableModel model;
CBD cc= new CBD();
Connection cn= cc.Conectar();
int Ac,Ac2;
String cedu,a1, b1, c1, d1,e1,f1,act="0",carg, aa1, bb1, cc1, dd1 ;
String an="0",ag="0",ae="0",ael="0",bn="0",bg="0",be="0",bel="0",cn1="1",cg="0",ce="1",cel="0",dn="0",dg="0",de="0",del="0",acti="0";
Statement st = null; 

    /** Creates new form control */
    public control() {
        initComponents();
         this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        bloqueo();
        bloque();
        activi();
      usuario();
        cargarusuarios();
         txtcargo.setVisible(false);
           btaceptar.setVisible(false);
    }
    void bloque(){
    txtnuev.setEnabled(false);
         btgua.setEnabled(false);
          btneditar.setEnabled(false);
          btneli.setEnabled(false);
             
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
      psd4.setString(2, "GESTIÓN DE ROLES");
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
  
     void bloqueo(){
        Cha.setEnabled(false);
        chrecho.setEnabled(false);
         Chb.setEnabled(false);
          Chc.setEnabled(false);
           chre.setEnabled(false);
         chefa.setEnabled(false);
          chre2.setEnabled(false);
           Chd.setEnabled(false);
            Chd1.setEnabled(false);
             Chd2.setEnabled(false);
            chnuev.setEnabled(false);
            chgua.setEnabled(false);
              chedi.setEnabled(false);
               chEli.setEnabled(false);
                chnuev2.setEnabled(false);
                chgua2.setEnabled(false);
              chedi2.setEnabled(false);
               chEli2.setEnabled(false);
                chnuev3.setEnabled(false);
            chgua3.setEnabled(false);
              chedi3.setEnabled(false);
               chEli3.setEnabled(false);
               boxced.setEnabled(false);
               tablausuario.setEnabled(false);
                tablausuario.setVisible(false);
                
               
    }
      void bloqueo2(){
        Cha.setEnabled(false);
         Chb.setEnabled(false);
          Chc.setEnabled(false);
           chrecho.setEnabled(false);
           chre.setEnabled(false);
         chefa.setEnabled(false);
          chre2.setEnabled(false);
           Chd.setEnabled(false);
            Chd1.setEnabled(false);
             Chd2.setEnabled(false);
            chnuev.setEnabled(false);
            chgua.setEnabled(false);
              chedi.setEnabled(false);
               chEli.setEnabled(false);
                chnuev2.setEnabled(false);
                chgua2.setEnabled(false);
              chedi2.setEnabled(false);
               chEli2.setEnabled(false);
                chnuev3.setEnabled(false);
                chgua3.setEnabled(false);
              chedi3.setEnabled(false);
               chEli3.setEnabled(false);
               boxced.setEnabled(false);
              
               
    }
    void desbloqueo(){
        Cha.setEnabled(true);
         Chb.setEnabled(true);
          Chc.setEnabled(true);
           chrecho.setEnabled(true);
           chre.setEnabled(true);
         chefa.setEnabled(true);
          chre2.setEnabled(true);
           Chd.setEnabled(true);
           Chd1.setEnabled(true);
           Chd2.setEnabled(true);
            chnuev.setEnabled(true);
            chgua.setEnabled(true);
              chedi.setEnabled(true);
               chEli.setEnabled(true);
                chnuev2.setEnabled(true);
                chgua2.setEnabled(true);
              chedi2.setEnabled(true);
               chEli2.setEnabled(true);
                chnuev3.setEnabled(true);
                chgua3.setEnabled(true);
              chedi3.setEnabled(true);
               chEli3.setEnabled(true);
               boxced.setEnabled(true);
               tablausuario.setEnabled(true);
                tablausuario.setVisible(true);
                 txtnuev.setEnabled(true);
         btgua.setEnabled(true);
          btneditar.setEnabled(true);
          btneli.setEnabled(true);
    }
     void limpiar(){
        Cha.setSelected(false);
         Chb.setSelected(false);
          Chc.setSelected(false);
           chrecho.setSelected(false);
           chre.setSelected(false);
         chefa.setSelected(false);
          chre2.setSelected(false);
           Chd.setSelected(false);
           Chd1.setSelected(false);
           Chd2.setSelected(false);
            chnuev.setSelected(false);
            chgua.setSelected(false);
              chedi.setSelected(false);
               chEli.setSelected(false);
                chnuev2.setSelected(false);
                chgua2.setSelected(false);
              chedi2.setSelected(false);
               chEli2.setSelected(false);
               chnuev3.setSelected(false);
            chgua3.setSelected(false);
              chedi3.setSelected(false);
               chEli3.setSelected(false);
               boxced.setSelectedItem("--ROL--");
    }


     void cargarusuarios() {
       
       
        try{
            String [] titulos={"CEDULA","NOMBRE","APELLIDO","CARGO"};
            String [] registros= new String[4];
            model=new DefaultTableModel(null,titulos);
            
            String cons="select * from usuarios";
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next()){
                registros[0]=rs.getString("cedula");
                 registros[1]=rs.getString("nombres");
                  registros[2]=rs.getString("apellidos");
                   registros[3]=rs.getString("cargo");
               
                             
                 
              
                model.addRow(registros);      
                }
          tablausuario.setModel(model);
           tablausuario.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablausuario.getColumnModel().getColumn(1).setPreferredWidth(100);
             tablausuario.getColumnModel().getColumn(2).setPreferredWidth(100);
             
            }catch(Exception e){
                System.out.println(e.getMessage());
                 }
}
    void chk(){
        if(chnuev.isSelected()){
           an="1"; 
        }
        else{
         an="0";  
        }
        if(chgua.isSelected()){
           ag="1"; 
        }
        else{
         ag="0";  
        }
        if(chedi.isSelected()){
           ae="1"; 
        }
        else{
         ae="0";  
        }
        if(chEli.isSelected()){
           ael="1"; 
        }
        else{
         ael="0";  
        }
        
          if(chnuev2.isSelected()){
           bn="1"; 
        }
        else{
         bn="0";  
        }
        if(chgua2.isSelected()){
           bg="1"; 
        }
        else{
         bg="0";  
        }
        if(chedi2.isSelected()){
           be="1"; 
        }
        else{
         be="0";  
        }
        if(chEli2.isSelected()){
           bel="1"; 
        }
        else{
         bel="0";  
        }
        if(chnuev3.isSelected()){
           cn1="1"; 
        }
        else{
         cn1="0";  
        }
         if(chgua3.isSelected()){
           cg="1"; 
        }
        else{
         cg="0";  
        }
        if(chedi3.isSelected()){
           ce="1"; 
        }
        else{
         ce="0";  
        }
        if(chEli3.isSelected()){
           cel="1"; 
        }
        else{
         cel="0";  
        }
         if(chnuev3.isSelected()){
           cn1="1"; 
        }
        else{
         cn1="0";  
        }
         if(chgua3.isSelected()){
           cg="1"; 
        }
        else{
         cg="0";  
        }
        if(chedi3.isSelected()){
           ce="1"; 
        }
        else{
         ce="0";  
        }
        if(chEli3.isSelected()){
           cel="1"; 
        }
        else{
         cel="0";  
        }
          if(chre.isSelected()){
           dn="1"; 
        }
        else{
         dn="0";  
        }
        if(chefa.isSelected()){
          dg="1"; 
        }
        else{
         dg="0";  
        }
        if(chre2.isSelected()){
           de="1"; 
        }
        else{
         de="0";  
        }
        if(chrecho.isSelected()){
           del="1"; 
        }
        else{
         del="0";  
        }
    }
     void chkrol(){
        if(Cha.isSelected()){
           a1="1"; 
        }
        else{
         a1="0";  
        }
        if(Chb.isSelected()){
           b1="1"; 
        }
        else{
         b1="0";  
        }
        if(Chc.isSelected()){
           c1="1"; 
        }
        else{
         c1="0";  
        }
        if(Chd.isSelected()){
           d1="1"; 
        }
        else{
         d1="0";  
        }
         if(Chd1.isSelected()){
           e1="1"; 
        }
        else{
         e1="0";  
        }
          if(Chd2.isSelected()){
           f1="1"; 
        }
        else{
         f1="0";  
        }
    }
     
     
    void usuario(){
    
 try
    {
      
      String SQL = "select * from cargo"  ;
     
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
                
      while (rs.next())
      {
        
       String ce= rs.getString("idcar");
       
        boxced.addItem(ce);
        
         
      }
     
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
}
    void EdiSele(){
        if(an.equals("1")){
           chnuev.isSelected();
           chnuev.setSelected(true);
        }
        else{
         chnuev.setSelected(false); 
        }
        if(ag.equals("1")){
           
           chgua.isSelected();
           chgua.setSelected(true);
        }
        else{
        chgua.setSelected(false);
        }
        if(ae.equals("1")){
          
           chedi.isSelected();
           chedi.setSelected(true);
        }
        else{
       
         chedi.setSelected(false);
        }
        if(ael.equals("1")){
           
           chEli.isSelected();
           chEli.setSelected(true);
        }
        else{
         chEli.setSelected(false);
        }
        
          if(bn.equals("1")){
          
           chnuev2.isSelected();
           chnuev2.setSelected(true);
        }
        else{
       chnuev2.setSelected(false);
        }
        if(bg.equals("1")){
          
           chgua2.isSelected();
           chgua2.setSelected(true);
        }
        else{
         chgua2.setSelected(false);
        }
        if(be.equals("1")){
            chedi2.isSelected();
            chedi2.setSelected(true);
           
        }
        else{
         chedi2.setSelected(false);
        }
        if(bel.equals("1")){
            chEli2.isSelected();
            chEli2.setSelected(true);
          
        }
        else{
        chEli2.setSelected(false);
        }
         if(dn.equals("1")){
          
          chre.isSelected();
           chre.setSelected(true);
        }
        else{
       chre.setSelected(false);
        }
        if(dg.equals("1")){
          
          chefa.isSelected();
           chefa.setSelected(true);
        }
        else{
        chefa.setSelected(false);
        }
        if(de.equals("1")){
            chre2.isSelected();
           chre2.setSelected(true);
           
        }
        else{
         chre2.setSelected(false);
        }
        if(del.equals("1")){
            chrecho.isSelected();
           chrecho.setSelected(true);
           
        }
        else{
         chrecho.setSelected(false);
        }
        
    }
     void chedi(){
        if(a1.equals("1")){
            Cha.isSelected();
            Cha.setSelected(true);
           
        }
        else{
        Cha.setSelected(false);
        }
        if(b1.equals("1")){
            Chb.isSelected();
            Chb.setSelected(true);
           
        }
        else{
         Chb.setSelected(false);
        }
        if(c1.equals("1")){
            Chc.isSelected();
            Chc.setSelected(true);
           
        }
        else{
         Chc.setSelected(false);
        }
        if(d1.equals("1")){
            Chd.isSelected();
            Chd.setSelected(true);
          
        }
        else{
        Chd.setSelected(false);
        }
         if(e1.equals("1")){
            Chd1.isSelected();
            Chd1.setSelected(true);
          
        }
        else{
        Chd1.setSelected(false);
        }
          if(f1.equals("1")){
            Chd2.isSelected();
            Chd2.setSelected(true);
          
        }
        else{
        Chd2.setSelected(false);
        }
    }
      void Traer(){
             String  SQL,SQL1,SQL3;
 
   
      
        try {
            
          
             
             SQL1 = " SELECT * FROM rol WHERE cedula = " + cedu;
            SQL = " SELECT * FROM actividades WHERE cedula = " + cedu;
 SQL3 = " SELECT * FROM usuarios WHERE cedula = " + cedu;
           
            st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(SQL);
           rs.next();
           

           Statement st1 = null; 
            st1 = cn.createStatement();
            
            ResultSet rs2 = st1.executeQuery(SQL1);
           rs2.next();
           
           st1 = cn.createStatement();
            
            ResultSet rs3 = st1.executeQuery(SQL3);
           rs3.next();
           
      an=rs.getString("AN");
            ag=rs.getString("AG");
          ae=rs.getString("AE");
           
          ael=rs.getString("AEL");
            bn=rs.getString("BN");
          bg=rs.getString("BG");
         
            
           be=rs.getString("BE");
       bel=rs.getString("BEL");
         cn1=rs.getString("CN");
           cg=rs.getString("CG");
             ce=rs.getString("CE");
               cel=rs.getString("CEL");
               dn=rs.getString("DN");
           dg=rs.getString("DG");
             de=rs.getString("DE");
               del=rs.getString("DEL");
       
        a1=rs2.getString("a");
            b1=rs2.getString("b");
          c1=rs2.getString("c");
         
            
           d1=rs2.getString("d");
            e1=rs2.getString("e");
            f1=rs2.getString("f");
            
           String usu1=rs3.getString("cargo");
             boxced.setSelectedItem(usu1);
      
          
          EdiSele();  
          chedi();
          desbloqueo();
            
        } catch (SQLException ex) {
          
        }  // TODO add your handling code here:
        } 
     void editar(){
             String  SQL4;
 
   
      
        try {
            
            SQL4 = " SELECT * FROM usuarios WHERE cedula = " + cedu;
            
             Statement st4 = null; 
            st4 = cn.createStatement();
            
            ResultSet rs4 = st4.executeQuery(SQL4);
           rs4.next();
             String carg2=rs4.getString("cargo");
             if(Ac2==2){
             if(carg2.equals("Ninguno")){
                 bloqueo2();
                 JOptionPane.showMessageDialog(null,"ASIGNE ROL"); 
                 
             }
             else{
                Traer(); 
            
         }  
             
            
        }
             if(Ac2==1){
                  if(carg2.equals("Ninguno")){
                desbloqueo();        
             }
             else{
                       bloqueo2();
               JOptionPane.showMessageDialog(null,"YA POSEE ROL"); 
            
         }  
                    }  
                  
                  if(Ac2==3){
                      
                  
                    
                      an="0";
            ag="0";
          ae="0";
           
          ael="0";
            bn="0";
          bg="0";
         
            
           be="0";
       bel="0";
        
         cn1="0";
           cg="0";
             ce="0";
               cel="0";
               dn="0";
           dg="0";
             de="0";
               del="0";
        a1="0";
            b1="0";
          c1="0";
         
            
           d1="0";
           e1="0";
           f1="0";
          carg="Ninguno";
           int resp= JOptionPane.showConfirmDialog(this, "¿Deseas Eliminar rol?","Eliminar Dato",JOptionPane.YES_NO_OPTION);
                      
                if(resp==JOptionPane.YES_NO_OPTION){
                    
                       Eliminar();
                             
                        JOptionPane.showMessageDialog(this,"ROL ELIMINADO");
                        cargarusuarios();
                                      
         
            
       
            
                     
                  
    } } } 
                
         catch (SQLException ex) {
          
        }  // TODO add your handling code here:
        }
     void Guardar(){
              chk();  
chkrol();
carg=String.valueOf(boxced.getSelectedItem());

 
 
String SQL1,SQL2,SQL3;




PreparedStatement psd,psd1,psd3;
switch(Ac){
    
    case 1:
      
         break;
    case 2:
        if((a1.equals("0")) && (b1.equals("0")) && (c1.equals("0")) && (d1.equals("0")) && (e1.equals("0")) && (f1.equals("0"))){
          JOptionPane.showMessageDialog(null,"No a seleccionado un proceso");  
        }
        else{
        SQL1="UPDATE rol set a=?,b=?,c=?,d=?,e=?,f=?,activo=? WHERE cedula=? ";
try{
     psd = cn.prepareStatement(SQL1);
     psd.setString(1,a1);
        psd.setString(2,b1);
        psd.setString(3,c1);
         psd.setString(4,d1);
         psd.setString(5,e1);
         psd.setString(6,f1);
          psd.setString(7,act);
           psd.setString(8,cedu);
          
      
           int n=psd.executeUpdate();
           
           if(n>0){
              
              
            JOptionPane.showMessageDialog(null,"GUARDADO EXITOSO");     
           }
            } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al guardar rol");
        
    }  
            SQL2="UPDATE actividades set AN=?,AG=?,AE=?,AEL=?,BN=?,BG=?,BE=?,BEL=?,CN=?,CG=?,CE=?,CEL=?,DN=?,DG=?,DE=?,DEL=?,activo=? WHERE cedula=? ";
try{
     psd1 = cn.prepareStatement(SQL2);
     psd1.setString(1,an);
        psd1.setString(2,ag);
        psd1.setString(3,ae);
         psd1.setString(4,ael);
         psd1.setString(5,bn);
        psd1.setString(6,bg);
        psd1.setString(7,be);
         psd1.setString(8,bel);
         psd1.setString(9,cn1);
        psd1.setString(10,cg);
        psd1.setString(11,ce);
         psd1.setString(12,cel);
         psd1.setString(13,dn);
        psd1.setString(14,dg);
        psd1.setString(15,de);
         psd1.setString(16,del);
          psd1.setString(17,acti);
           psd1.setString(18,cedu);
          
      
      psd1.executeUpdate();
        } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al guardar actividades");
        
    }  
  SQL3="UPDATE usuarios set cargo=? WHERE cedula=? ";
try{
     psd3 = cn.prepareStatement(SQL3);
     psd3.setString(1,carg);
       
           psd3.setString(2,cedu);
          
      
           int n=psd3.executeUpdate();
           
           if(n>0){
              
              limpiar();
              bloqueo();
               cargarusuarios();
            JOptionPane.showMessageDialog(null,"GUARDADO CARGO");     
           }
          
} catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al guardar cargo");
        
    }}
        if(Ac2==2 && Ac2!=3){
          Acti="REGISTRO EDITADO";
            fpa();   
        }else{
          Acti="REGISTRO NUEVO";
            fpa();
        }
    break;
      } 
 } 
    void Eliminar(){
              chk();  
chkrol();

 
String SQL1,SQL2,SQL3;




PreparedStatement psd,psd1,psd3;
switch(Ac){
    
    case 1:
      
         break;
    case 2:
        
        SQL1="UPDATE rol set a=?,b=?,c=?,d=?,e=?,f=?,activo=? WHERE cedula=? ";
try{
     psd = cn.prepareStatement(SQL1);
     psd.setString(1,a1);
        psd.setString(2,b1);
        psd.setString(3,c1);
         psd.setString(4,d1);
         psd.setString(5,e1);
         psd.setString(6,f1);
          psd.setString(7,act);
           psd.setString(8,cedu);
          
      
           int n=psd.executeUpdate();
           
           if(n>0){
              
             
           }
            } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al editar rol");
        
    }  
            SQL2="UPDATE actividades set AN=?,AG=?,AE=?,AEL=?,BN=?,BG=?,BE=?,BEL=?,CN=?,CG=?,CE=?,CEL=?,DN=?,DG=?,DE=?,DEL=?,activo=? WHERE cedula=? ";
try{
     psd1 = cn.prepareStatement(SQL2);
     psd1.setString(1,an);
        psd1.setString(2,ag);
        psd1.setString(3,ae);
         psd1.setString(4,ael);
         psd1.setString(5,bn);
        psd1.setString(6,bg);
        psd1.setString(7,be);
         psd1.setString(8,bel);
         psd1.setString(9,cn1);
        psd1.setString(10,cg);
        psd1.setString(11,ce);
         psd1.setString(12,cel);
         psd1.setString(13,dn);
        psd1.setString(14,dg);
        psd1.setString(15,de);
         psd1.setString(16,del);
          psd1.setString(17,acti);
           psd1.setString(18,cedu);
          
      
      psd1.executeUpdate();
        } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al editar actividades");
        
    }  
  SQL3="UPDATE usuarios set cargo=? WHERE cedula=? ";
try{
     psd3 = cn.prepareStatement(SQL3);
     psd3.setString(1,carg);
       
           psd3.setString(2,cedu);
          
      
           int n=psd3.executeUpdate();
           
           if(n>0){
              
              limpiar();
              bloqueo();
               
           }
          
} catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al editar usuarios");
        
    }
  Acti="REGISTRO ELIMINADO";
            fpa();
              
    break;
      } 
 } 
    void cargoN(){
       String caN =String.valueOf(boxced.getSelectedItem());
       if(caN.equals("Nuevo")){
           txtcargo.setVisible(true);
           btaceptar.setVisible(true);
       }
       else{
        txtcargo.setVisible(false);
           btaceptar.setVisible(false);    
       }
    }
    void aceptar(){
        String v=txtcargo.getText();
      PreparedStatement  psd3;
           String SQL3="INSERT INTO cargo(idcar) VALUES (?)  ";
try{
     psd3 = cn.prepareStatement(SQL3);
     psd3.setString(1,v);
       
           
          
      
           int n=psd3.executeUpdate();
           
           if(n>0){
        
     boxced.addItem(v);
       txtcargo.setVisible(false);
       txtcargo.setText("");
       btaceptar.setVisible(false);
       
           }
          
} catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al guardar cargo");
        
    }
}
     void activi()
  {
    try
    {
      String SQL = "select * from actividades WHERE activo= '1' ";
      
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      while (rs.next())
      {
        this.aa1 = rs.getString("CN");
        this.bb1 = rs.getString("CG");
        this.cc1 = rs.getString("CE");
        this.dd1 = rs.getString("CEL");
        this.cedu = rs.getString("cedula");
      }
      if (this.aa1.equals("1")) {
        this.txtnuev.setEnabled(true);
      }
      if (this.bb1.equals("1")) {
        this.btgua.setEnabled(true);
      }
      if (this.cc1.equals("1")) {
        this.btneditar.setEnabled(true);
      }
      if (this.dd1.equals("1")) {
        this.btneli.setEnabled(true);
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

        jPanel1 = new javax.swing.JPanel();
        chgua2 = new javax.swing.JCheckBox();
        chEli2 = new javax.swing.JCheckBox();
        chnuev2 = new javax.swing.JCheckBox();
        chedi2 = new javax.swing.JCheckBox();
        chEli = new javax.swing.JCheckBox();
        chedi = new javax.swing.JCheckBox();
        chgua = new javax.swing.JCheckBox();
        chnuev = new javax.swing.JCheckBox();
        chnuev3 = new javax.swing.JCheckBox();
        chedi3 = new javax.swing.JCheckBox();
        chEli3 = new javax.swing.JCheckBox();
        chgua3 = new javax.swing.JCheckBox();
        chre = new javax.swing.JCheckBox();
        chefa = new javax.swing.JCheckBox();
        chre2 = new javax.swing.JCheckBox();
        chrecho = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        Chd = new javax.swing.JCheckBox();
        Chc = new javax.swing.JCheckBox();
        Chb = new javax.swing.JCheckBox();
        Cha = new javax.swing.JCheckBox();
        Chd1 = new javax.swing.JCheckBox();
        Chd2 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btgua = new javax.swing.JButton();
        btneli = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtnuev = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbfunc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuario = new javax.swing.JTable();
        boxced = new javax.swing.JComboBox();
        btaceptar = new javax.swing.JButton();
        txtcargo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(149, 200, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTIVIDADES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        chgua2.setFont(new java.awt.Font("Tahoma", 1, 12));
        chgua2.setText("Guardar");

        chEli2.setFont(new java.awt.Font("Tahoma", 1, 12));
        chEli2.setText("Eliminar");

        chnuev2.setFont(new java.awt.Font("Tahoma", 1, 12));
        chnuev2.setText("Nuevo");
        chnuev2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chnuev2ActionPerformed(evt);
            }
        });

        chedi2.setFont(new java.awt.Font("Tahoma", 1, 12));
        chedi2.setText("Editar");

        chEli.setFont(new java.awt.Font("Tahoma", 1, 12));
        chEli.setText("Eliminar");

        chedi.setFont(new java.awt.Font("Tahoma", 1, 12));
        chedi.setText("Editar");

        chgua.setFont(new java.awt.Font("Tahoma", 1, 12));
        chgua.setText("Guardar");

        chnuev.setFont(new java.awt.Font("Tahoma", 1, 12));
        chnuev.setText("Nuevo");
        chnuev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chnuevActionPerformed(evt);
            }
        });

        chnuev3.setFont(new java.awt.Font("Tahoma", 1, 12));
        chnuev3.setText("Nuevo");
        chnuev3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chnuev3ActionPerformed(evt);
            }
        });

        chedi3.setFont(new java.awt.Font("Tahoma", 1, 12));
        chedi3.setText("Editar");

        chEli3.setFont(new java.awt.Font("Tahoma", 1, 12));
        chEli3.setText("Eliminar");

        chgua3.setFont(new java.awt.Font("Tahoma", 1, 12));
        chgua3.setText("Guardar");

        chre.setFont(new java.awt.Font("Tahoma", 1, 12));
        chre.setText("Reporte");
        chre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chreActionPerformed(evt);
            }
        });

        chefa.setFont(new java.awt.Font("Tahoma", 1, 12));
        chefa.setText("Factura");
        chefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chefaActionPerformed(evt);
            }
        });

        chre2.setFont(new java.awt.Font("Tahoma", 1, 12));
        chre2.setText("Reporte");
        chre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chre2ActionPerformed(evt);
            }
        });

        chrecho.setFont(new java.awt.Font("Tahoma", 1, 12));
        chrecho.setText("Reporte");
        chrecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chrechoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chre)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chnuev2, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chnuev3, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addGap(21, 21, 21))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chnuev, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chefa)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chgua2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                        .addGap(37, 37, 37))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chgua3, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                        .addGap(36, 36, 36))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chgua, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                        .addGap(36, 36, 36)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chedi3, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(chEli3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(chedi2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(chedi, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                                .addGap(19, 19, 19)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chEli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                            .addComponent(chEli2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))))
                        .addGap(4, 4, 4)
                        .addComponent(chrecho)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chre2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(365, 365, 365))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chnuev)
                    .addComponent(chgua)
                    .addComponent(chedi)
                    .addComponent(chEli))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chre)
                    .addComponent(chefa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chnuev2)
                    .addComponent(chEli2)
                    .addComponent(chgua2)
                    .addComponent(chrecho)
                    .addComponent(chedi2))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chnuev3)
                    .addComponent(chgua3)
                    .addComponent(chedi3)
                    .addComponent(chEli3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(chre2)
                .addGap(17, 17, 17))
        );

        jPanel2.setBackground(new java.awt.Color(149, 200, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROCESOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        Chd.setFont(new java.awt.Font("Tahoma", 1, 12));
        Chd.setText("Auditoria de Usuarios");

        Chc.setFont(new java.awt.Font("Tahoma", 1, 12));
        Chc.setText("Gestion de Chofer");

        Chb.setFont(new java.awt.Font("Tahoma", 1, 12));
        Chb.setText("Consulta de Servicio");

        Cha.setFont(new java.awt.Font("Tahoma", 1, 12));
        Cha.setText("Gestion de Servicio");
        Cha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChaActionPerformed(evt);
            }
        });

        Chd1.setFont(new java.awt.Font("Tahoma", 1, 12));
        Chd1.setText("Gestión de Roles");

        Chd2.setFont(new java.awt.Font("Tahoma", 1, 12));
        Chd2.setText("Consulta de Dinero");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cha)
                    .addComponent(Chb)
                    .addComponent(Chc)
                    .addComponent(Chd)
                    .addComponent(Chd1)
                    .addComponent(Chd2))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cha)
                .addGap(18, 18, 18)
                .addComponent(Chb)
                .addGap(18, 18, 18)
                .addComponent(Chc)
                .addGap(18, 18, 18)
                .addComponent(Chd)
                .addGap(18, 18, 18)
                .addComponent(Chd1)
                .addGap(18, 18, 18)
                .addComponent(Chd2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(149, 200, 248));
        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GESTIÓN DE ROLES");
        jLabel7.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(149, 200, 248));

        btgua.setBackground(new java.awt.Color(0, 0, 0));
        btgua.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btgua.setForeground(new java.awt.Color(255, 255, 255));
        btgua.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\install.png")); // NOI18N
        btgua.setText("guardar");
        btgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguaActionPerformed(evt);
            }
        });

        btneli.setBackground(new java.awt.Color(0, 0, 0));
        btneli.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btneli.setForeground(new java.awt.Color(255, 255, 255));
        btneli.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\trash full.png")); // NOI18N
        btneli.setText("eliminar");
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(0, 0, 0));
        btneditar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btneditar.setForeground(new java.awt.Color(255, 255, 255));
        btneditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\edit.png")); // NOI18N
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Recarga");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtnuev.setBackground(new java.awt.Color(0, 0, 0));
        txtnuev.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        txtnuev.setForeground(new java.awt.Color(255, 255, 255));
        txtnuev.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\plus.png")); // NOI18N
        txtnuev.setText("nuevo");
        txtnuev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnuevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(txtnuev, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btgua, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btneli, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneli, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btgua, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnuev, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(149, 200, 248));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USUARIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lbfunc.setBackground(new java.awt.Color(149, 200, 248));
        lbfunc.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbfunc.setForeground(new java.awt.Color(255, 255, 255));
        lbfunc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbfunc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbfunc.setOpaque(true);

        tablausuario.setFont(new java.awt.Font("Tahoma", 1, 14));
        tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablausuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablausuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablausuarioMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tablausuario);

        boxced.setFont(new java.awt.Font("Tahoma", 1, 12));
        boxced.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--ROL--", "Nuevo" }));
        boxced.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxcedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boxcedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxcedMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boxcedMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boxcedMouseReleased(evt);
            }
        });
        boxced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxcedActionPerformed(evt);
            }
        });
        boxced.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxcedKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxcedKeyReleased(evt);
            }
        });

        btaceptar.setBackground(new java.awt.Color(0, 0, 0));
        btaceptar.setText("aceptar");
        btaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(boxced, 0, 235, Short.MAX_VALUE)
                .addGap(214, 214, 214)
                .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btaceptar)
                .addGap(69, 69, 69))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbfunc, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(541, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbfunc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxced, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btaceptar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguaActionPerformed

    Guardar();
}//GEN-LAST:event_btguaActionPerformed

private void chnuevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chnuevActionPerformed

}//GEN-LAST:event_chnuevActionPerformed

private void chnuev2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chnuev2ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chnuev2ActionPerformed

private void tablausuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuarioMouseClicked
  int i = tablausuario.getSelectedRow();  
      cedu=(String) tablausuario.getValueAt(i,0); 
      limpiar();
      editar();
       
       
          
              // TODO add your handling code here:
}//GEN-LAST:event_tablausuarioMouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
cargarusuarios();// TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
tablausuario.setVisible(true);
tablausuario.setEnabled(true);
Ac2=2;
Ac=2;
lbfunc.setVisible(true);
lbfunc.setText("EDICIÓN DE ROL");
}//GEN-LAST:event_btneditarActionPerformed

private void txtnuevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnuevActionPerformed
desbloqueo();
limpiar();
lbfunc.setVisible(true);
lbfunc.setText("ASIGNACIÓN DE ROL");
   Ac=2;
    Ac2=1;
    
}//GEN-LAST:event_txtnuevActionPerformed

private void tablausuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuarioMouseEntered
// TODO add your handling code here:
}//GEN-LAST:event_tablausuarioMouseEntered

private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
desbloqueo();
limpiar();

   Ac=2;
    Ac2=3; 
    lbfunc.setVisible(true);
lbfunc.setText("ELIMINACIÓN DE ROL");
         
}//GEN-LAST:event_btneliActionPerformed

private void boxcedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxcedActionPerformed
cargoN();// TODO add your handling code here:
}//GEN-LAST:event_boxcedActionPerformed

private void boxcedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxcedMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_boxcedMouseClicked

private void boxcedMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxcedMouseReleased
// TODO add your handling code here:
}//GEN-LAST:event_boxcedMouseReleased

private void boxcedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxcedKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_boxcedKeyReleased

private void boxcedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxcedMouseEntered
// TODO add your handling code here:
}//GEN-LAST:event_boxcedMouseEntered

private void boxcedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxcedMousePressed
// TODO add your handling code here:
}//GEN-LAST:event_boxcedMousePressed

private void boxcedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxcedMouseExited
// TODO add your handling code here:
}//GEN-LAST:event_boxcedMouseExited

private void boxcedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxcedKeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_boxcedKeyPressed

private void btaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaceptarActionPerformed
aceptar();// TODO add your handling code here:
}//GEN-LAST:event_btaceptarActionPerformed

private void ChaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_ChaActionPerformed

private void chnuev3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chnuev3ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chnuev3ActionPerformed

private void chreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chreActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chreActionPerformed

private void chefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chefaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chefaActionPerformed

private void chre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chre2ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chre2ActionPerformed

private void chrechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chrechoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chrechoActionPerformed

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
            java.util.logging.Logger.getLogger(control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new control().setVisible(true);
               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Cha;
    private javax.swing.JCheckBox Chb;
    private javax.swing.JCheckBox Chc;
    private javax.swing.JCheckBox Chd;
    private javax.swing.JCheckBox Chd1;
    private javax.swing.JCheckBox Chd2;
    private javax.swing.JComboBox boxced;
    private javax.swing.JButton btaceptar;
    private javax.swing.JButton btgua;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneli;
    private javax.swing.JCheckBox chEli;
    private javax.swing.JCheckBox chEli2;
    private javax.swing.JCheckBox chEli3;
    private javax.swing.JCheckBox chedi;
    private javax.swing.JCheckBox chedi2;
    private javax.swing.JCheckBox chedi3;
    private javax.swing.JCheckBox chefa;
    private javax.swing.JCheckBox chgua;
    private javax.swing.JCheckBox chgua2;
    private javax.swing.JCheckBox chgua3;
    private javax.swing.JCheckBox chnuev;
    private javax.swing.JCheckBox chnuev2;
    private javax.swing.JCheckBox chnuev3;
    private javax.swing.JCheckBox chre;
    private javax.swing.JCheckBox chre2;
    private javax.swing.JCheckBox chrecho;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbfunc;
    private javax.swing.JTable tablausuario;
    private javax.swing.JTextField txtcargo;
    private javax.swing.JButton txtnuev;
    // End of variables declaration//GEN-END:variables
}
