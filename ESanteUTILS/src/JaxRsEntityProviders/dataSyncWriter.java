/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxRsEntityProviders;

import Sync.DataSync;
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

public class dataSyncWriter implements MessageBodyWriter<DataSync> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
     //Quelle type de données doit etre converti par ce MessageBodyWriter
        return DataSync.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(DataSync t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        //Méthodologie d'évaluation par la taille de l'élément à envoyer
        return 0;
    }

    @Override
    public void writeTo(DataSync t, Class<?> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, Object> mm, OutputStream outputStream) throws IOException, WebApplicationException {
        try {
            //Convertion effectif
            
            StringWriter sw=new StringWriter();            
            JAXBContext context=JAXBContext.newInstance(DataSync.class);
            Marshaller m=context.createMarshaller();
            m.marshal(t, sw);
            outputStream.write(sw.toString().getBytes());
            
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
