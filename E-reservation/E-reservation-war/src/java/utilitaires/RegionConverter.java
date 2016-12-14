/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;

import dataNew.Region;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author darkman
 */
@FacesConverter("regionConverter")
public class RegionConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Region region = new Region();
      region.setId(Integer.valueOf(value));      
      return region;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Region region=(Region)value;
       if(region!=null){
        String id=String.valueOf(region.getId());
        return id; 
       }
        return null;
    }
    
    
}
