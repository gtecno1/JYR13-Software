/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trans.gru.pc;

/**
 *
 * @author black
 */
public class listaClientes11 {
  
     private String id;
    private String seguro;
       
        private String marca;
          private String modelo;
            private String color;
           
              private String año;
               private String placa;
                private String nombre;
           private String chofer;
     private String costo;
 private String fecha;

    public listaClientes11(String id, String seguro, String marca, String modelo, String color, String año, String placa, String nombre, String chofer, String costo, String fecha) {
        this.id = id;
        this.seguro = seguro;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.año = año;
        this.placa = placa;
        this.nombre = nombre;
        this.chofer = chofer;
        this.costo = costo;
        this.fecha = fecha;
    }

    public String getAño() {
        return año;
    }

    public String getChofer() {
        return chofer;
    }

    public String getColor() {
        return color;
    }

    public String getCosto() {
        return costo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public String getSeguro() {
        return seguro;
    }
   
}
   
