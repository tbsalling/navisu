/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.terrevirtuelle.navisu.nmea.controller.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Serge Morvan
 */
public class Reader {

    Class claz;
    Object object;

    public Reader() {

    }

    public Reader(Class claz) {
        this.claz = claz;
    }

    public Object read(String fileName) {
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(fileName));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        JAXBContext jAXBContext = null;
        Unmarshaller unmarshaller = null;
        try {
            jAXBContext = JAXBContext.newInstance(claz);
            unmarshaller = jAXBContext.createUnmarshaller();
            object = unmarshaller.unmarshal(inputFile);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return object;
    }
}