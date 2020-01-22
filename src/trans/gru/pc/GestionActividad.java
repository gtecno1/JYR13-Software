
package trans.gru.pc;

import CBD.CBD;

import java.awt.Color;
import java.awt.Font;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.swing.JFrame;

import javax.swing.JOptionPane;


public class GestionActividad
  extends JFrame
{
  CBD cc = new CBD();
  Connection cn = this.cc.Conectar();
  String cod;
  Statement st = null;
  String Hora;
  String fech;
  int v;
  double c;
  double m;
  int Ac;
  String a1;
  String b1;
  String c1;
  String d1;
  String cedu;
  String Acti;
  String fe;
  String fe2;
  String por3;
  String k;
  String h;
  String ch1;
  int up4=0,az=0,bz=0,cz=0,dz=0,ez=0,fz=0,gz=0,hz=0,yz=0,nz=0,kz=0,za=0,zs=0,zd=0,zf=0;
  String[] registros2 = new String[3];
 
  
  public static String fechaActual1()
  {
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("    dd-MM-yyy");
    return formatoFecha.format(fecha);
  }
  
  public static String fechaActual2()
  {
    Date fecha2 = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyyy");
    return formatoFecha.format(fecha2);
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
  
  public GestionActividad()
  {
    initComponents();
     this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    nuevob();
    activi();
    chofer();
   jb2.setText(fechaActual1());
  }
  
  void nuevo()
  {
    this.boxseg.setEnabled(true);
    this.boxmar.setEnabled(true);
    this.boxmod.setEnabled(true);
    this.boxcol.setEnabled(true);
    this.Spaño.setEnabled(true);
    this.txtpla.setEnabled(true);
    this.txtnom.setEnabled(true);
   
   
    this.AreLugA.setEnabled(true);
    this.AreD.setEnabled(true);
    this.AreF.setEnabled(true);
    this.txtC.setEnabled(true);
    this.boxCho.setEnabled(true);
    this.txtCosto.setEnabled(true);
    jb1.setEnabled(true);
    Nomb.setEnabled(true);
  }
  
  void nuevol()
  {
    this.jb1.setText("");
    this.boxseg.setSelectedItem("--Seguros--");
    this.boxmar.setSelectedItem("--Marca--");
    this.boxmod.setText("--Modelo--");
    this.boxcol.setSelectedItem("--Color--");
    
    this.txtpla.setText("");
    this.txtnom.setText("");
  
    this.AreLugA.setText("");
    this.AreD.setText("");
    this.AreF.setText("");
    this.txtC.setText("");
    this.boxCho.setSelectedItem("--Chofer--");
    this.txtCosto.setText("");
    jb1.setText("");
    Nomb.setText("");
  }
  
  void nuevob()
  {
    this.boxseg.setEnabled(false);
    this.boxmar.setEnabled(false);
    this.boxmod.setEnabled(false);
    this.boxcol.setEnabled(false);
    this.Spaño.setEnabled(false);
    this.txtpla.setEnabled(false);
    this.txtnom.setEnabled(false);
  
    this.AreLugA.setEnabled(false);
    this.AreD.setEnabled(false);
    this.AreF.setEnabled(false);
    this.txtC.setEnabled(false);
    this.boxCho.setEnabled(false);
    this.txtCosto.setEnabled(false);
    
   
  }
  
  void chofer()
  {
    try
    {
      String SQL = "select * from cedulach";
      
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      while (rs.next())
      {
        this.registros2[2] = rs.getString("cedulas");
        
        this.boxCho.addItem(this.registros2[2]);
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  void suma()
  {
    try
    {
      String SQL2 = "SELECT MAX(id)  FROM  servicio";
      
      Statement st2 = null;
      st2 = this.cn.createStatement();
      ResultSet rs = st2.executeQuery(SQL2);
      rs.next();
      int q = rs.getInt("MAX(id)");
      this.v = (10 + q);
      
      this.jb1.setText(String.valueOf(this.v));
    }
    catch (SQLException ex) {}
  }
  
  void porc()
  {
    try
    {
      String SQL = "select * from porcent where idp =1";
      
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      while (rs.next()) {
        this.por3 = rs.getString("porI");
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
    String ca = this.txtCosto.getText();
    double b = Double.valueOf(ca).doubleValue();
    
    int r1 = 100;
    int r = r1 - Integer.valueOf(this.por3).intValue();
    
    double a = Double.valueOf(this.por3).doubleValue();
    double o = Double.valueOf(r).doubleValue();
    this.m = (o / 100.0D);
    this.c = (a / 100.0D);
    double l = this.m * b;
    double z = this.c * b;
    double jd = 0.0D;
    this.cod = String.valueOf(this.boxCho.getSelectedItem());
    try
    {
      String sql2 = "select SUM(gananciachofer) FROM dinero where CONCAT (idchofer)  LIKE '%" + this.cod + "%' ";
      Statement st1 = this.cn.createStatement();
      ResultSet rs1 = st1.executeQuery(sql2);
      while (rs1.next()) {
        jd = rs1.getDouble("SUM(gananciachofer)");
      }
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Error PARA TRAER CHOFER");
    }
    Double jc = Double.valueOf(z + jd);
    this.ch1 = String.valueOf(jc);
    this.h = String.valueOf(l);
    
    this.k = String.valueOf(z);
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
      psd4.setString(2, "GESTIÓN DE SERVICIO");
      psd4.setString(3, this.Acti);
      psd4.setString(4, this.Hora);
      psd4.setString(5, this.fech);
      
      up4 = psd4.executeUpdate();
     
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Error PROCESO/ACTIVIDAD");
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
        this.a1 = rs.getString("AN");
        this.b1 = rs.getString("AG");
        this.c1 = rs.getString("AE");
        this.d1 = rs.getString("AEL");
        this.cedu = rs.getString("cedula");
      }
      if (this.a1.equals("1")) {
        this.btnN.setEnabled(true);
      }
      if (this.b1.equals("1")) {
        this.btnG.setEnabled(true);
      }
      if (this.c1.equals("1")) {
        this.btnE.setEnabled(true);
      }
      if (this.d1.equals("1")) {
        this.btnEl.setEnabled(true);
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  


 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnom = new javax.swing.JTextField();
        txttel1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreLugA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpla = new javax.swing.JTextField();
        jb2 = new javax.swing.JTextField();
        boxseg = new javax.swing.JComboBox();
        Spaño = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jb1 = new javax.swing.JTextField();
        boxmar = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        boxmod = new javax.swing.JTextField();
        boxcol = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreD = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreF = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        boxCho = new javax.swing.JComboBox();
        Nomb = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        txtC = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnE = new javax.swing.JButton();
        btnEl = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        btnG = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(20, 136, 238));

        jPanel1.setBackground(new java.awt.Color(149, 200, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtnom.setFont(new java.awt.Font("Monospaced", 1, 12));
        txtnom.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        txttel1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txttel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        AreLugA.setColumns(20);
        AreLugA.setFont(new java.awt.Font("Monospaced", 1, 12));
        AreLugA.setRows(5);
        AreLugA.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(AreLugA);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NOMBRE DE PROPIETARIO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TELEFONO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LUGAR DEL ACCIDENTE");

        jPanel3.setBackground(new java.awt.Color(149, 200, 248));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE VEHICULO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CODIGO DE REGISTRO:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("AÑO");

        txtpla.setFont(new java.awt.Font("Monospaced", 1, 14));
        txtpla.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jb2.setBackground(new java.awt.Color(149, 200, 248));
        jb2.setEditable(false);
        jb2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jb2.setForeground(new java.awt.Color(255, 255, 255));
        jb2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jb2.setBorder(null);

        boxseg.setFont(new java.awt.Font("Tahoma", 1, 12));
        boxseg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SEGUROS--", "VENEASISTENCIA", "S.CARACAS", "LA VITALICIA", "MAPFRE ASISTENCIA", "NET ASISTENCIA", "S.CONSTITUCION.S.LA PREVISORA", "IKE ASISTENCIA" }));

        Spaño.setFont(new java.awt.Font("Monospaced", 1, 18));
        Spaño.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(50), null, null, Integer.valueOf(1)));
        Spaño.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODELO");

        jb1.setBackground(new java.awt.Color(149, 200, 248));
        jb1.setFont(new java.awt.Font("Arial Narrow", 1, 18));
        jb1.setForeground(new java.awt.Color(255, 255, 255));
        jb1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jb1.setBorder(null);
        jb1.setOpaque(false);

        boxmar.setFont(new java.awt.Font("Tahoma", 1, 12));
        boxmar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--MARCA--", "9ff ", "Abarth ", "Abt ", "AC Propulsion ", "AC Schnitzer ", "AC ", "Acoma ", "Acrea ", "Acura ", "A:level ", "Adams Probe ", "Aero Willys ", "Aixam ", "Aleko ", "Alessi ", "Alfa Romeo ", "Allard ", "Alpina ", "Alvis ", "AMC ", "American Bamtan ", "Amoritz ", "Anadol ", "Anibal ", "Anteros ", "Apal ", "Apollo ", "Aptera ", "AQC ", "Aquila ", "Arash ", "Arex ", "Argyll ", "ARH ", "Ariel Atom ", "Arkley ", "Armstrong Siddeley ", "Arnold Bristol ", "ARO ", "Arrinera ", "Arta Garaiya ", "Artega ", "Artés ", "Asardo ", "Ascari ", "Ashok Leyland ", "Asia Motors ", "ASL ", "Aspid ", "Aston Martin ", "Astra ", "Atalanta ", "ATS ", "Auburn ", "Audi ", "Austin ", "Auto Avio ", "Autobacs ", "Autobianchi ", "Autocars ", "Autozam ", "Auverland ", "Avia ", "Aymesa ", "B. engineering ", "Bac ", "Bag Splitz ", "Bajaj ", "Ballot ", "Bandini ", "Baojun ", "Bargon ", "Baw ", "Beck ", "Bell Aurens ", "Bell-Ross ", "Bellier ", "Belumbury ", "Bentley ", "Berkeley ", "Bertone ", "BF Performance ", "Bill Tomas ", "Birkin ", "Bitter ", "Bizzarrini ", "Blakely ", "Bmw ", "Bohse ", "Bolwell ", "Bond ", "Borgward ", "Brabham ", "Brabus ", "Breckland ", "Bricklin ", "Brilliance ", "Bristol ", "Brokernet ", "Bucciali ", "Bufori ", "Bugatti ", "Buick ", "Bulldog ", "Burgfalke ", "BYD ", "Cadillac ", "Callaway ", "Camo Marauder ", "Campagna ", "Caparo ", "Capstone ", "Carbontech ", "Cardi ", "Carice ", "Carlsson ", "Carver One ", "Casalini ", "Case ", "Castagna ", "Caterham ", "Caterpillar ", "Chana ", "Changan ", "Changfeng ", "Checker ", "Chery ", "Chevrolet ", "Chrysler ", "Citröen ", "Cizeta ", "Clan ", "Clenet ", "Climax ", "Clua ", "Coda ", "Comarth ", "Condor Aguzzoli ", "Connaught ", "Conquest Knight ", "Corbin ", "Cord ", "Covini ", "Crosley ", "Cross Lander ", "Cunninham ", "Dacia ", "Daewoo ", "DAF ", "Daihatsu ", "Dare ", "Darl´Mat ", "Dartmoor ", "Dartz ", "Datsun ", "David Brown Automotive ", "Davis ", "DB ", "DC Desing ", "DDR ", "De Dion ", "De La Chapelle ", "De Macross ", "De Tomaso ", "Dean Jefries ", "Delage ", "Delahaye ", "Delfino ", "Delorean ", "Deronda ", "Derways ", "Desoto ", "Detroit Electric ", "Devaux ", "Devel ", "Devon ", "Diatto ", "Didia ", "Divco ", "DKW ", "Dodge ", "Dome ", "Dongfeng ", "Donkervoort ", "Duesenberg ", "Ebbro Btec ", "EDAG ", "Edo ", "Edsel ", "Eagle ", "Elfin ", "Elio Motors ", "Elva ", "Emme ", "Enzman ", "ERF ", "Ermini ", "Eterniti ", "EuropeStar ", "Evante ", "Evans ", "E-Wolf ", "Exagon ", "Facel Vega ", "Fairthorpe ", "Falcon ", "falhke ", "Faralli & Mazzanti ", "Farbio ", "Farboud ", "Farus ", "Faw ", "Felino ", "Fenix Automotive ", "Ferrari ", "Ferves ", "Fiat ", "Fiberfab ", "Fioravanti ", "Fisher ", "Fisker ", "Flajole ", "FM Auto ", "Force ", "Ford ", "Fornasari ", "Four Stroke ", "Fournier ", "FPV ", "Francis Lombardi ", "Franklin ", "FreeStream ", "Freightliner ", "Gaz ", "Galloper ", "GD ", "Geely ", "Geiger ", "Gemballa ", "Genevart ", "Genty ", "Ghia ", "Gibbs ", "Gillet ", "Ginetta ", "Glas ", "Glasspar ", "GM ", "GMC ", "Gonow ", "Gordini ", "Gordon Kleebe ", "Gordon Murray ", "Graham-Paige ", "Great Wall ", "Grecav ", "Griffith ", "GTA ", "GTM ", "Gumpert ", "Gurgel ", "GWA ", "Haima ", "Hamann ", "Heffner Performance ", "Henry J ", "Hennessey ", "Heuliez ", "Hillman ", "Hindustan ", "Hino ", "Hispano Suiza ", "HMC ", "Hoftetter ", "Holden ", "Hommell ", "Honda ", "Hongqi ", "Horch ", "Hotchkiss ", "HSV ", "HTT ", "Hulme ", "Humber ", "Hummer ", "Hurtan ", "Hyundai ", "Icona ", "identity ", "Idries ", "IED ", "IMSA ", "Imperia ", "Infiniti ", "Innocenti ", "Innotech ", "International ", "International Haverter ", "Invicta ", "Iran Khodro ", "Irmscher ", "Isdera ", "Iso ", "Isotta ", "Isuzu ", "ItalDesing ", "Iveco ", "Izaro ", "JAC ", "Jaguar ", "Jakusa ", "Javan ", "JBA ", "JDM ", "Jeep ", "Jensen ", "Jimenez Novia ", "Jiotto ", "Joss ", "Jösse ", "Justicialista ", "K1 ", "Kaipan ", "Kaiser ", "Kawasaki ", "Keating ", "Keinath ", "Kenworth ", "Kia ", "Kleemann ", "Kodiak ", "Koeningsegg ", "Korres ", "KTM ", "La salle ", "Lada ", "Ladalat ", "Laforza ", "Lagonda ", "Lamborghini ", "Lanchester ", "Lancia ", "Land Rover ", "Landwind ", "Laraki ", "LCC ", "LDV ", "Le Marquis ", "Le Blanc ", "Lea Francis ", "Leopard ", "Leyland ", "Lexus ", "Liege ", "Lightburn ", "Lightning ", "Ligier ", "Lincoln ", "Lister ", "Lloyd ", "LM Sovra ", "LMX ", "Lobini ", "Locus ", "Lola ", "Lombardi ", "Loremo ", "Lotec ", "Lotus ", "Lucra ", "Luxgen ", "Lyonheart ", "Mahindra ", "Maico ", "Magna Steyr ", "Man ", "Manganese ", "Manic ", "Mansory ", "Marcadier ", "Marcos ", "Marlin ", "Marmon ", "Marussia ", "Maserati ", "Mastretta ", "Mathis ", "Matra ", "Maybach ", "MAZ ", "Mazda ", "Mazel ", "MB Roadcars ", "MCA ", "McLaren ", "MCV ", "Mega ", "Melkus ", "Mercedez Benz ", "Mercer ", "Mercury ", "Meyers ", "MG ", "MHV ", "Mindset ", "Minerva ", "Mini ", "Mitchell ", "Mitsubishi ", "Mitsuoka ", "MMI ", "Mohs Ostentatine ", "Monteverdi ", "Morgan ", "Mosler ", "Mostro Di Potenza ", "Mullen ", "Nami ", "Nardi Española ", "Nash ", "Nismo ", "Nissan ", "Noble ", "Nova ", "NSU ", "Obvio ", "Oldsmobile ", "Oltcit ", "Opel ", "Orca ", "OSI ", "Osca ", "Packard ", "Pagani ", "Panhard ", "Panoz ", "Panther ", "Parradine ", "Pars Khodro ", "Pegas ", "Pegaso ", "Pemblenton ", "Penske ", "Perodua ", "Peugeot ", "PGO ", "Pierce Arrow ", "Pilgrim ", "Pininfarina ", "Plymount ", "Poncin ", "Pontiac ", "Porsche ", "Praga ", "Prince ", "Proton ", "Protoscar ", "PTG ", "Puma Car ", "Puritalia ", "Qiantu ", "Quoros ", "Quimera ", "Qvale ", "Radical ", "Rambler ", "Rapier Automotive ", "Reliant ", "Renaissance ", "Renauld ", "Renauld Alpine ", "Rene Bonnet ", "RENNtech ", "Reo ", "Rezvani ", "Riley & Scott ", "Riley ", "Rimac ", "Rinho ", "Rinspeed ", "Robur ", "Roding ", "Rolls Royce ", "Ronart ", "Rossion ", "Roush ", "Rover ", "Royale ", "RSC ", "Russo-Baltique ", "Ruf ", "Saab ", "Saipa ", "Saleem ", "Salmson ", "Samsung ", "Santa Matilde ", "Santana ", "Saturn ", "Savage ", "Sbarro ", "Scania ", "Schuppan ", "Scion ", "Seat ", "Secma ", "Shacman ", "Shayton ", "Shelby SuperCars SSC ", "Siata ", "Simca ", "Singer ", "Skoda ", "Smart ", "Soueast ", "Spada ", "Spartan ", "Spectre ", "SpeedArt ", "Sportec ", "Spyker ", "Ssang Yong ", "Stand Craft ", "Startech ", "Stealth ", "Sterling ", "Steyr ", "Strathcarron ", "Strosek ", "Studebaker ", "Studio Torino ", "Stutz ", "Subaru ", "Sunbean ", "Sunred ", "Superlite ", "Suzuki ", "Suzusho ", "Syrena ", "Tagaz ", "Talbot ", "Tata ", "Tatra ", "tavria ", "Tauro ", "Tazzari ", "TechArt ", "Tesla ", "Tornado ", "Toroidion ", "Toyota ", "Trabant ", "Tramontana ", "TranStar ", "Trident ", "Triumph ", "Troller ", "Tucker ", "Tushek ", "TVR ", "UAZ ", "Ultima ", "UMM ", "Unipower ", "URI ", "URO ", "Valmet ", "Vanden Plas ", "Vandenbrink ", "Vanwall ", "Vauxhall ", "Vaydor ", "VDS ", "Vector ", "Velam Isseta ", "Velanturi ", "Vemac ", "Vemag ", "Vencer ", "Venirauto ", "Venturi ", "Venucia ", "Veritas ", "Vespa Automovile ", "Vidi ", "Vision ", "Voisin ", "Volga ", "Volkswagen ", "Volvo ", "Vortex ", "Vuhl ", "Vulcan ", "Wald ", "Walley Larson ", "Wanderer ", "Wartburg ", "Weineck ", "Western Star ", "Westfield ", "Wiesmann ", "Willy's ", "Wolseley ", "W-Motors ", "Yamaha ", "Yes ", "Yo-Auto ", "Yo-Mobile ", "Yugo ", "Zagato ", "Zap ", "Zarooq ", "Zavasta ", "ZAZ ", "Zender ", "Zenos ", "Zenvo ", "Zeus Twelve ", "Zil ", "Zimmer ", "Zinoro ", "Zolfe ", "Zotye ", "total parcial:622" }));
        boxmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxmarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PLACA");

        boxmod.setFont(new java.awt.Font("Monospaced", 1, 14));
        boxmod.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        boxcol.setFont(new java.awt.Font("Tahoma", 1, 12));
        boxcol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--COLOR--", "Rojo", "Azul", "Blanco", "Negro", "Amarillo", "Naranja", "Verde", "Plateado" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxmar, 0, 244, Short.MAX_VALUE)
                            .addComponent(boxseg, 0, 244, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxmod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtpla, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jb2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(boxcol, 0, 244, Short.MAX_VALUE)
                .addGap(103, 103, 103))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Spaño, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addGap(164, 164, 164))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxmar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxmod, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxseg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpla, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(boxcol, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addComponent(Spaño, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DESTINO DEL VEHICULO");

        AreD.setColumns(20);
        AreD.setFont(new java.awt.Font("Monospaced", 1, 12));
        AreD.setRows(5);
        AreD.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(AreD);

        AreF.setColumns(20);
        AreF.setFont(new java.awt.Font("Monospaced", 1, 12));
        AreF.setRows(5);
        AreF.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(AreF);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FALLAS DEL VEHICULO");

        boxCho.setFont(new java.awt.Font("Tahoma", 1, 12));
        boxCho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--CHOFER--" }));
        boxCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxChoActionPerformed(evt);
            }
        });

        Nomb.setBackground(new java.awt.Color(149, 200, 248));
        Nomb.setEditable(false);
        Nomb.setFont(new java.awt.Font("Monospaced", 1, 14));
        Nomb.setBorder(null);
        Nomb.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("COSTO");

        txtCosto.setFont(new java.awt.Font("Monospaced", 1, 12));
        txtCosto.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        txtC.setFont(new java.awt.Font("Monospaced", 1, 12));
        txtC.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("NOMBRE DE CHOFER");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CODIGO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxCho, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCosto)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Nomb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txttel1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nomb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxCho, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(215, 215, 215))
        );

        jLabel11.setBackground(new java.awt.Color(149, 200, 248));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("GESTIÓN DE SERVICIO");
        jLabel11.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(149, 200, 248));

        btnE.setBackground(new java.awt.Color(0, 0, 0));
        btnE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11));
        btnE.setForeground(new java.awt.Color(255, 255, 255));
        btnE.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\edit.png")); // NOI18N
        btnE.setText("EDITAR");
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        btnEl.setBackground(new java.awt.Color(0, 0, 0));
        btnEl.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11));
        btnEl.setForeground(new java.awt.Color(255, 255, 255));
        btnEl.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\trash full.png")); // NOI18N
        btnEl.setText("ELIMINAR");
        btnEl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElActionPerformed(evt);
            }
        });

        btnN.setBackground(new java.awt.Color(0, 0, 0));
        btnN.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11));
        btnN.setForeground(new java.awt.Color(255, 255, 255));
        btnN.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\plus.png")); // NOI18N
        btnN.setText("NUEVO");
        btnN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNActionPerformed(evt);
            }
        });

        btnG.setBackground(new java.awt.Color(0, 0, 0));
        btnG.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btnG.setForeground(new java.awt.Color(255, 255, 255));
        btnG.setIcon(new javax.swing.ImageIcon("C:\\Users\\android\\Documents\\iconos\\install.png")); // NOI18N
        btnG.setText("GUARDAR");
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnN, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnG, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btnE, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEl, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(99, 99, 99))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnN, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEl, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void boxmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxmarActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_boxmarActionPerformed

private void btnNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNActionPerformed
 nuevo();

    nuevol();
    suma();
    Ac = 1;
}//GEN-LAST:event_btnNActionPerformed

private void btnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGActionPerformed
 String Acum = "0";
 int up=0,up1=0,up2=0; 
 String Plac,Seg,Mar,Mod,Col,Cho, año, Nom,Laci ,Lida , Fa , Cod , f,Tel1="23445556677777"; 
    
    Plac = txtpla.getText();
    Seg = String.valueOf(boxseg.getSelectedItem());
    Mar = String.valueOf(boxmar.getSelectedItem());
     Mod = boxmod.getText();
   Col = String.valueOf(boxcol.getSelectedItem());
    Cho = String.valueOf(boxCho.getSelectedItem());
    año = String.valueOf(Spaño.getValue());
     Nom = txtnom.getText();
    Laci = AreLugA.getText();
   Lida = AreD.getText();
    Fa = AreF.getText();
    Cod = txtC.getText();
     f = txtCosto.getText();
    int co = Integer.valueOf(jb1.getText()).intValue();
    
   
    String SQL1;
    PreparedStatement psd;
    
 
  
 
  
 

 
   
 
    switch (this.Ac)
    {
    case 1: 
      
     
        if((Mod.isEmpty())||( Plac.isEmpty())||( Nom.isEmpty() )|| (Laci.isEmpty() )|| (Lida.isEmpty()) || (Fa.isEmpty()) || (Cod.isEmpty() ) || (f.isEmpty())){
        
          JOptionPane.showMessageDialog(null, "Error mensaje");  
        }
        
        else{
      SQL1 = "INSERT INTO servicio (id,seguro,marca,modelo,color,año,placa,nombre,telefono,Laccidente,Ldestino,Fallas,codigo,chofer,costo,fecha,fecha2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      try
      {
        psd = this.cn.prepareStatement(SQL1);
        psd.setInt(1, this.v);
        psd.setString(2, Seg);
        psd.setString(3, Mar);
        psd.setString(4, Mod);
        psd.setString(5, Col);
        psd.setString(6, año);
        psd.setString(7, Plac);
        
        psd.setString(8, Nom);
        psd.setString(9, Tel1);
        psd.setString(10, Laci);
        psd.setString(11, Lida);
        psd.setString(12, Fa);
        psd.setString(13, Cod);
        psd.setString(14, Cho);
        psd.setString(15, f);
        psd.setString(16, this.jb2.getText());
        psd.setString(17, this.fe = fechaActual2());
        
         up = psd.executeUpdate();
       
      }
      catch (SQLException ex)
      {
        JOptionPane.showMessageDialog(null, "Error Servicio");
      }
      String SQL20 = "INSERT INTO dinero (idservicio,Seguro,cosservicio,gananciaempresa,idchofer,gananciachofer,porcentajeganchofer,fecha,fecha2) VALUES (?,?,?,?,?,?,?,?,?)";
      try
     {
        porc();
        PreparedStatement psd2 = cn.prepareStatement(SQL20);
        psd2.setInt(1, v);
        psd2.setString(2, Seg);
        
        psd2.setString(3, f);
        psd2.setString(4, h);
        psd2.setString(5, Cho);
        psd2.setString(6, k);
        
        psd2.setString(7, por3);
        psd2.setString(8, jb2.getText());
        
        psd2.setString(9, fe = fechaActual2());
        
       up1 = psd2.executeUpdate();
       
        SQL1 = "UPDATE chofer set dineroCh=? WHERE cedula=? ";
        try
        {
          psd = this.cn.prepareStatement(SQL1);
          
          psd.setString(1, ch1);
          psd.setString(2, Cho);
          up2=psd.executeUpdate();
         
        }
        catch (SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error Dinero y Chofer   ");
        }
        
        
      }
      catch (SQLException ex)
      {
        JOptionPane.showMessageDialog(null, "Error");
      }
         if ((up == 1) && (up1 == 1) && (up2 == 1 ) )
        {
          nuevol();
          nuevob();
          this.Acti = "REGISTRO NUEVO";
          fpa();
          JOptionPane.showMessageDialog(null, "Guardado Exitoso");
        }
        }
        break;
    case 2: 
      SQL1 = "UPDATE servicio set id=?,seguro=?,marca=?,modelo=?,color=?,año=?,placa=?,nombre=?,telefono=?,Laccidente=?,Ldestino=?,Fallas=?,codigo=?,chofer=?,costo=?,fecha=?,fecha2=? WHERE id=? ";
      try
      {
        psd = this.cn.prepareStatement(SQL1);
        psd.setInt(1, co);
        psd.setString(2, Seg);
        psd.setString(3, Mar);
        psd.setString(4, Mod);
        psd.setString(5, Col);
        psd.setString(6, año);
        psd.setString(7, Plac);
        
        psd.setString(8, Nom);
        psd.setString(9, Tel1);
        psd.setString(10, Laci);
        psd.setString(11, Lida);
        psd.setString(12, Fa);
        psd.setString(13, Cod);
        psd.setString(14, Cho);
        psd.setString(15, f);
        psd.setString(16, this.fe2);
        psd.setString(17, this.fe);
        psd.setString(18, this.cod);
        
        int n = psd.executeUpdate();
        if (n > 0)
        {
          nuevol();
          nuevob();
          this.Acti = "REGISTRO EDITADO";
          fpa();
          JOptionPane.showMessageDialog(null, "Guardado Exitoso");
        }
      }
      catch (SQLException ex)
      {
        JOptionPane.showMessageDialog(null, "Error");
      }
    
      break;
    }
}//GEN-LAST:event_btnGActionPerformed

private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
 nuevo();
    nuevol();
    this.Ac = 2;
    this.cod = JOptionPane.showInputDialog("Introdusca codigo:");
    try
    {
      String SQL1 = "SELECT * FROM servicio WHERE id=" + this.cod;
      this.st = this.cn.createStatement();
      ResultSet rs = this.st.executeQuery(SQL1);
      rs.next();
      this.jb1.setText(rs.getString("id"));
      this.boxseg.setSelectedItem(rs.getString("seguro"));
      this.boxmar.setSelectedItem(rs.getString("marca"));
      this.boxmod.setText(rs.getString("modelo"));
      this.boxcol.setSelectedItem(rs.getString("color"));
      this.Spaño.setValue(Integer.valueOf(rs.getInt("año")));
      this.txtpla.setText(rs.getString("placa"));
      this.txtnom.setText(rs.getString("nombre"));
     
      this.AreLugA.setText(rs.getString("Laccidente"));
      this.AreD.setText(rs.getString("Ldestino"));
      this.AreF.setText(rs.getString("Fallas"));
      this.txtC.setText(rs.getString("codigo"));
      this.boxCho.setSelectedItem(rs.getString("chofer"));
      this.txtCosto.setText(String.valueOf(rs.getInt("costo")));
      this.fe2 = rs.getString("fecha");
      this.fe = rs.getString("fecha2");
    }
    catch (SQLException ex) {}
}//GEN-LAST:event_btnEActionPerformed

private void btnElActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElActionPerformed
 nuevo();
    nuevol();
    this.cod = JOptionPane.showInputDialog("Introdusca codigo:");
    try
    {
      String SQL = "SELECT * FROM servicio WHERE id=" + this.cod;
      this.st = this.cn.createStatement();
      ResultSet rs = this.st.executeQuery(SQL);
      rs.next();
      this.jb1.setText(rs.getString("id"));
      this.boxseg.setSelectedItem(rs.getString("seguro"));
      this.boxmar.setSelectedItem(rs.getString("marca"));
      this.boxmod.setText(rs.getString("modelo"));
      this.boxcol.setSelectedItem(rs.getString("color"));
      this.Spaño.setValue(Integer.valueOf(rs.getInt("año")));
      this.txtpla.setText(rs.getString("placa"));
      this.txtnom.setText(rs.getString("nombre"));
     
      this.AreLugA.setText(rs.getString("Laccidente"));
      this.AreD.setText(rs.getString("Ldestino"));
      this.AreF.setText(rs.getString("Fallas"));
      this.txtC.setText(rs.getString("codigo"));
      this.boxCho.setSelectedItem(rs.getString("chofer"));
      this.txtCosto.setText(String.valueOf(rs.getInt("costo")));
      int resp = JOptionPane.showConfirmDialog(this, "Deseas Eliminarlo", "Eliminar Dato", 0);
      if (resp == 0) {
        try
        {
          PreparedStatement psd = null;
          SQL = " DELETE FROM servicio WHERE id ='" + this.cod + "'";
          psd = this.cn.prepareStatement(SQL);
          psd.execute();
          psd.close();
          nuevol();
          nuevob();
          JOptionPane.showMessageDialog(this, "REGISTRO ELIMINADO");
        }
        catch (SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error SQL no se Eliminaron");
        }
      } else {
        JOptionPane.showMessageDialog(null, "No existe");
      }
    }
    catch (SQLException ex) {}
  
}//GEN-LAST:event_btnElActionPerformed

private void boxChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxChoActionPerformed
 String dk = String.valueOf(this.boxCho.getSelectedItem());
    try
    {
      String SQL = "select * from chofer where cedula=" + dk;
      
      Statement st = this.cn.createStatement();
      ResultSet rs = st.executeQuery(SQL);
      while (rs.next()) {
        this.Nomb.setText(rs.getString("nombres"));
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }// TODO add your handling code here:
}//GEN-LAST:event_boxChoActionPerformed

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
            java.util.logging.Logger.getLogger(GestionActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GestionActividad().setVisible(true);
            }
        });
    }
    
       
           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreD;
    private javax.swing.JTextArea AreF;
    private javax.swing.JTextArea AreLugA;
    private javax.swing.JTextField Nomb;
    private javax.swing.JSpinner Spaño;
    private javax.swing.JComboBox boxCho;
    private javax.swing.JComboBox boxcol;
    private javax.swing.JComboBox boxmar;
    private javax.swing.JTextField boxmod;
    private javax.swing.JComboBox boxseg;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnEl;
    private javax.swing.JButton btnG;
    private javax.swing.JButton btnN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jb1;
    private javax.swing.JTextField jb2;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtpla;
    private javax.swing.JTextField txttel1;
    // End of variables declaration//GEN-END:variables
 }
