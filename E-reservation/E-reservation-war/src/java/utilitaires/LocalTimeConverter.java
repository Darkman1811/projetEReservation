/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;



import java.time.LocalTime;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author darkman
 */
@FacesConverter("localTimeConverter")
public class LocalTimeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocalTime localTime = LocalTime.parse(value);
        
        
      return localTime;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       LocalTime localTime=(LocalTime)value;
       if(localTime!=null){
        String time=localTime.toString();
        return time; 
       }
        return null;
    }
    
    
}
