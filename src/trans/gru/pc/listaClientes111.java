/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trans.gru.pc;

/**
 *
 * @author black
 */
public class listaClientes111 {
  
     private String idservi;
    private String seguro;
       
        private String idchofer;
          private String cosservicio;
            private String gananciaem;
           
              private String gchofer;
               private String porcho;
                private String fecha;

    public listaClientes111(String idservi, String seguro, String idchofer, String cosservicio, String gananciaem, String gchofer, String porcho, String fecha) {
        this.idservi = idservi;
        this.seguro = seguro;
        this.idchofer = idchofer;
        this.cosservicio = cosservicio;
        this.gananciaem = gananciaem;
        this.gchofer = gchofer;
        this.porcho = porcho;
        this.fecha = fecha;
    }

    public String getCosservicio() {
        return cosservicio;
    }

    public String getFecha() {
        return fecha;
    }

    public String getGananciaem() {
        return gananciaem;
    }

    public String getGchofer() {
        return gchofer;
    }

    public String getIdchofer() {
        return idchofer;
    }

    public String getIdservi() {
        return idservi;
    }

    public String getPorcho() {
        return porcho;
    }

    public String getSeguro() {
        return seguro;
    }

   
           
   
}