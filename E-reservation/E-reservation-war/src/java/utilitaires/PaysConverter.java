/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;

import dataNew.Pays;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author darkman
 */
@FacesConverter("paysConverter")
public class PaysConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Pays pays = new Pays();
      pays.setId(Integer.valueOf(value));  
      return pays;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Pays pays=(Pays)value;
       if(pays!=null){
        String id=String.valueOf(pays.getId());
        return id; 
       }
        return null;
    }
    
    
}
