/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxRsEntityProviders;

import Sync.DataSync;
import dataNew.JoursBloques;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author darkman
 */
@Provider
@Consumes("application/xml")
public class dataSyncReader implements MessageBodyReader<DataSync>{

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        
     return DataSync.class.isAssignableFrom(type);
    }

    @Override
    public DataSync readFrom(Class<DataSync> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream inputStream) throws IOException, WebApplicationException {
         DataSync dataSync=new DataSync();
         
        try {
            JAXBContext context=JAXBContext.newInstance(DataSync.class);
            Unmarshaller um=context.createUnmarshaller();
            dataSync=(DataSync)um.unmarshal(inputStream);
         
            return dataSync;
            
        } catch (JAXBException ex) {
            Logger.getLogger(dataSyncReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataSync;   
    }
    
}
