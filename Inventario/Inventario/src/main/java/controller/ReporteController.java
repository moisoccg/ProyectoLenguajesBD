
package controller;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


@Named(value = "reporteController")
@SessionScoped
public class ReporteController implements Serializable {

    /**
     * Creates a new instance of ReporteController
     */
    public ReporteController() {
    }
    
    public void descargarPdf() {
        try {
            Conexion consulta = new Conexion();
            File jasper = new File(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRealPath("/Reportes/PRODUCTOSXVENCER.jasper"));
            JasperPrint reporteJasper
                    = JasperFillManager.fillReport(
                            jasper.getPath(), null, consulta.getConnection());
            HttpServletResponse respuesta
                    = (HttpServletResponse) FacesContext.getCurrentInstance()
                            .getExternalContext().getResponse();
            respuesta.addHeader("Content-disposition", "attachment; filename=PorVencer.pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cantidadMinima() {
        try {
            Conexion consulta = new Conexion();
            File jasper = new File(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRealPath("/Reportes/CANTIDADMINIMA.jasper"));
            JasperPrint reporteJasper
                    = JasperFillManager.fillReport(
                            jasper.getPath(), null, consulta.getConnection());
            HttpServletResponse respuesta
                    = (HttpServletResponse) FacesContext.getCurrentInstance()
                            .getExternalContext().getResponse();
            respuesta.addHeader("Content-disposition", "attachment; filename=CantidadMinima.pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reporteGeneral() {
        try {
            Conexion consulta = new Conexion();
            File jasper = new File(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRealPath("/Reportes/REPORTEGENERAL2.jasper"));
            JasperPrint reporteJasper
                    = JasperFillManager.fillReport(
                            jasper.getPath(), null, consulta.getConnection());
            HttpServletResponse respuesta
                    = (HttpServletResponse) FacesContext.getCurrentInstance()
                            .getExternalContext().getResponse();
            respuesta.addHeader("Content-disposition", "attachment; filename=ReporteGeneral.pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void verOrden(int idOrden) {
        try {
            Conexion consulta = new Conexion();
            File jasper = new File(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRealPath("/Reportes/verOrden.jasper"));  //crear JASPER
            JasperPrint reporteJasper
                    = JasperFillManager.fillReport(
                            jasper.getPath(), null, consulta.getConnection());
            HttpServletResponse respuesta
                    = (HttpServletResponse) FacesContext.getCurrentInstance()
                            .getExternalContext().getResponse();
            respuesta.addHeader("Content-disposition", "attachment; filename=Orden"+idOrden+".pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
