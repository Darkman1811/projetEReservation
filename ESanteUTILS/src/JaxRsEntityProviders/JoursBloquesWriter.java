/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxRsEntityProviders;

import dataNew.JoursBloques;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author darkman
 */
@Provider
@Produces("application/xml")

public class JoursBloquesWriter implements MessageBodyWriter<JoursBloques> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     System.out.println("is readable");
        return JoursBloques.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(JoursBloques t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     System.out.println("getsize");
        return t.toString().length();
    }

    @Override
    public void writeTo(JoursBloques t, Class<?> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, Object> mm, OutputStream outputStream) throws IOException, WebApplicationException {
        try {
            //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            StringWriter sw=new StringWriter();
            
            JAXBContext context=JAXBContext.newInstance(JoursBloques.class);
            Marshaller m=context.createMarshaller();
            m.marshal(t, sw);
           /* System.out.println("Marshaling to String:");
              System.out.println(sw.toString());
           */
            outputStream.write(sw.toString().getBytes());
            
        } catch (JAXBException ex) {
           // Logger.getLogger(JoursBloquesWriter.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        System.out.println("dodo");
    }
    
}
