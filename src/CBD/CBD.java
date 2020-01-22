/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CBD;


import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author black
 */
public class CBD {
    
    public String bd="transportes";
    public String Us="root";
    public String Co="";
    public String Url="jdbc:mysql://localhost/"+bd;;
    public String Com= null;
    
    public CBD(){
        
    }
    
    public Connection Conectar(){
        
       Connection link= null;
       try{
           Class.forName("org.gjt.mm.mysql.Driver");
           link=DriverManager.getConnection(this.Url,this.Us,this.Co);
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
       return link; 
    }
    
}
