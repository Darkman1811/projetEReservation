/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author darkman
 */
@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocalDate localDate = LocalDate.parse(value);
        
      return localDate;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       LocalDate localDate=(LocalDate)value;
       if(localDate!=null){
        String date=localDate.toString();
        return date; 
       }
        return null;
    }
    
    
}
