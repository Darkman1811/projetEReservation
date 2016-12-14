/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;

import dataNew.Structure;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author darkman
 */
@FacesConverter("structureConverter")
public class StructureConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Structure structure = new Structure();
      structure.setId(Integer.valueOf(value));      
      return structure;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Structure structure=(Structure)value;
       if(structure!=null){
        String id=String.valueOf(structure.getId());
        return id; 
       }
        return null;
    }
    
    
}
