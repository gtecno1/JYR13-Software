/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trans.gru.pc;

/**
 *
 * @author black
 */
public class auditoriar {
  
    private String ce;
    private String nombre; 
    private String en;
    private String sa;
    private String fecha;

    public auditoriar(String ce, String nombre, String en, String sa, String fecha) {
        this.ce = ce;
        this.nombre = nombre;
        this.en = en;
        this.sa = sa;
        this.fecha = fecha;
    }

    public String getCe() {
        return ce;
    }

    public String getEn() {
        return en;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSa() {
        return sa;
    }
   

   

  
}
