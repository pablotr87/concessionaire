package com.pablotr87.concessionaire.controller;

import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

/**
 * Abstract class that contains common variables and methods.
 * @author pablotr87
 */
public abstract class BaseController {

    protected MessageSource messageSource;
        
    public BaseController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    /**
     * Metodo que implementaran las clases hijas y resolveran el listado a 
     * exportar a excel
     * @param order
     * @param sort
     * @param search
     * @param filter
     * @param locale 
     * @return
     */
    public abstract List<?> getListadoToExport(String order, String sort, String search, String filter, Locale locale);
    
    /**
     * Nombre del fichero que queremos dar nuestro fichero excel
     * 
     * @return
     */
    public abstract String getNombreFicheroExport();
 
    /**
     * ExportaciXXXn de ficheros excel.
     * 
     * @param model
     * @param cabecera
     * @param identificadores
     * @param order
     * @param search
     * @param filter
     * @param sort
     * @param locale
     * @return
     */
    @RequestMapping(value = "/exportarFicheroExcel",  method = RequestMethod.GET, 
                                produces = {"application/vnd.ms-excel; charset=UTF-8"})
    public final String exportToExcel(Model model,  @RequestParam List<String> cabecera,
                                             @RequestParam List<String> identificadores,
                                             @RequestParam (required = false) String order,
                                             @RequestParam (required = false) String search,
                                             @RequestParam (required = false) String filter,
                                             @RequestParam (required = false) String sort,
                                             Locale locale) {
        
        model.addAttribute("listado", getListadoToExport(order, sort, search, filter, locale));
        model.addAttribute("cabecera", cabecera);
        model.addAttribute("identificadores", identificadores);
        model.addAttribute("nombreFichero", getNombreFicheroExport());
        return "excelView";
    }
}
