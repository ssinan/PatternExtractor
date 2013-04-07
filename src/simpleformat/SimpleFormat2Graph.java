/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleformat;

import java.io.*;
import java.util.List;
import simpleformat.FileFormatNotSupportedException;
import simpleformat.Tokenizer;
import simpleformat.Class;

/**
 *
 * @author saricas
 */
public class SimpleFormat2Graph {
    
    private ByteArrayOutputStream os;

    public SimpleFormat2Graph(ByteArrayOutputStream os) {
        this.os = os;
    }

    public void write(ByteArrayOutputStream outfile) throws FileNotFoundException,
            IOException, FileFormatNotSupportedException {

        Tokenizer tokenizer = new Tokenizer(os);
        List<Class> classList = tokenizer.tokenize();

        int edgeCount = tokenizer.getEdgeCount();
        int vertexCount = classList.size();

        // set integer tags since cluto works with ints
        for (int i = 0; i < classList.size(); i++) {
            classList.get(i).setTag(i + 1);
        }

        DataOutputStream out = new DataOutputStream(outfile);
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(out));

        wr.write(String.valueOf(vertexCount) + " " + String.valueOf(edgeCount));

        for (int i = 0; i < vertexCount; i++) {
            wr.newLine();
            // only use in or out list
            List<Class> outList = classList.get(i).getOutList();
            for (int j = 0; j < vertexCount; j++) {
                boolean contains = false;
                for (Class c : outList) {
                    if (c.getTag() == j) {
                        contains = true;
                        break;
                    }
                }
                if (contains)
                    wr.append("1 ");
                else
                    wr.append("0 ");
            }
        }

        wr.newLine();
        wr.close();
    }
    
}
