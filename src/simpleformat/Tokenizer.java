/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simpleformat;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sinan
 */
public class Tokenizer {

    private static String SEPARATOR = " -> ";
    private ByteArrayOutputStream os;
    private List<Class> classList;
    private int edgeCount;

    public Tokenizer() {
        classList = new ArrayList<Class>();
        edgeCount = 0;
    }

    public Tokenizer(ByteArrayOutputStream os) {
        this.os = os;
        classList = new ArrayList<Class>();
        edgeCount = 0;
    }

    /**
     * @return the os
     */
    public ByteArrayOutputStream getFile() {
        return os;
    }

    public List<Class> tokenize() throws FileNotFoundException,
            IOException, FileFormatNotSupportedException {
        
        if (classList.size() > 0)
            return classList;
        
        InputStream istream = new ByteInputStream(os.toByteArray(), os.size());
        DataInputStream in = new DataInputStream(istream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String strLine;
        while ((strLine = br.readLine()) != null) {

            if (!strLine.contains(SEPARATOR)) {
                throw new FileFormatNotSupportedException();
            }

            String[] klasses = strLine.split(SEPARATOR);
            if (klasses.length != 2) {
                throw new FileFormatNotSupportedException();
            }

            Class c1 = new Class(klasses[0]);
            Class c2 = new Class(klasses[1]);
            if (classList.contains(c1)) {
                c1 = classList.get(classList.indexOf(c1));
            }
            if (classList.contains(c2)) {
                c2 = classList.get(classList.indexOf(c2));
            }

            boolean newEdge = false;
            if (c1.addOutClass(c2))
                newEdge = true;
            if (c2.addInClass(c1))
                newEdge = true;
            if (newEdge)
                edgeCount++;

            if (!classList.contains(c1)) {
                classList.add(c1);
            }
            if (!classList.contains(c2)) {
                classList.add(c2);
            }
        }
        
        // set default tags
        for (int i=0; i<classList.size(); i++) {
            classList.get(i).setTag(i);
        }

        in.close();
        return classList;
    }

    /**
     * @return the edgeCount
     */
    public int getEdgeCount() {
        return edgeCount;
    }

}
