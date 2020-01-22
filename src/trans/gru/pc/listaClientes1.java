/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trans.gru.pc;

/**
 *
 * @author black
 */
public class listaClientes1 {
  
    private String codigo;
    private String fecha;
   
    
    private String placa;
    private String nombre;
    private String costo;
    private String costototal;
     private String fac;

    public listaClientes1(String codigo, String fecha, String placa, String nombre, String costo, String costototal ,String fac) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.placa = placa;
        this.nombre = nombre;
        this.costo = costo;
        this.costototal = costototal;
        this.fac = fac;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCosto() {
        return costo;
    }

    public String getCostototal() {
        return costototal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public String getFecha() {
        return fecha;
    }

     public String getFac() {
        return fac;
    }
      

   

    

  
}
