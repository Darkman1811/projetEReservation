/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;

import dataNew.Ville;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author darkman
 */
@FacesConverter("villeConverter")
public class VilleConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Ville ville = new Ville();
      ville.setId(Integer.valueOf(value));      
      return ville;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Ville ville=(Ville)value;
       if(ville!=null){
        String id=String.valueOf(ville.getId());
        return id; 
       }
        return null;
    }
    
    
}
