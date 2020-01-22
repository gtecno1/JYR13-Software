/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trans.gru.pc;

/**
 *
 * @author black
 */
public class listaClientes1111 {
  
     private String cedula;
    private String edad;
       
        private String nombres;
          private String apellidos;
            private String telefono;
           
              private String direccion;
              private String dinero;

    public listaClientes1111(String cedula, String nombres, String apellidos,String edad, String telefono, String direccion,String dinero) {
        this.cedula = cedula;
       
        this.nombres = nombres;
        this.apellidos = apellidos;
         this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
         this.dinero = dinero;
        
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDinero() {
        return dinero;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEdad() {
        return edad;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }
              
     
             
}