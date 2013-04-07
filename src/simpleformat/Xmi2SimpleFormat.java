/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleformat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author saricas
 */
public class Xmi2SimpleFormat {

    public static File XSL = new File("./src/simpleformat/xmi2simpleformat.xsl");

    public static ByteArrayOutputStream transform(File xmlFile) throws TransformerConfigurationException, TransformerException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        javax.xml.transform.Source xsltSource =
                new javax.xml.transform.stream.StreamSource(XSL);
        javax.xml.transform.Source xmlSource =
                new javax.xml.transform.stream.StreamSource(xmlFile);
        javax.xml.transform.Result result;

        result = new javax.xml.transform.stream.StreamResult(os);

        // create an instance of TransformerFactory
        javax.xml.transform.TransformerFactory transFact =
                javax.xml.transform.TransformerFactory.newInstance();

        javax.xml.transform.Transformer trans =
                transFact.newTransformer(xsltSource);

        trans.transform(xmlSource, result);

        System.out.println("Transformation completed.");
        return os;
    }
}
