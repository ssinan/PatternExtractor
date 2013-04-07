/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patternextractor;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.event.GraphEvent.Edge;
import edu.uci.ics.jung.graph.event.GraphEvent.Vertex;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.samples.PluggableRendererDemo;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.util.VertexShapeFactory;
import java.awt.BorderLayout;
import java.awt.Shape;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import simpleformat.FileFormatNotSupportedException;
import simpleformat.Tokenizer;
import simpleformat.Xmi2SimpleFormat;
import javax.swing.Box;
import org.apache.commons.collections15.Transformer;
import pattern.AuthorityClassFinder;
import pattern.CycleClassFinder;
import pattern.DependencyPatternClassFinder;
import pattern.HubClassFinder;
import pattern.MyClust;
import simpleformat.SimpleFormat2Graph;

/**
 *
 * @author saricas
 */
public class MainWindow extends javax.swing.JFrame {
    
    Thread importingThread = null;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jFileChooser1.setAcceptAllFileFilterUsed(false);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("patternextractor/Bundle"); // NOI18N
        jFileChooser1.setDialogTitle(bundle.getString("MainWindow.jFileChooser1.dialogTitle")); // NOI18N
        jFileChooser1.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("XMI File", "xmi"));

        jDialog1.setMaximumSize(new java.awt.Dimension(350, 100));
        jDialog1.setMinimumSize(new java.awt.Dimension(350, 100));
        jDialog1.setPreferredSize(new java.awt.Dimension(350, 100));
        jDialog1.setResizable(false);
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                onDialogClosed(evt);
            }
        });
        jDialog1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText(bundle.getString("MainWindow.jLabel1.text")); // NOI18N
        jDialog1.getContentPane().add(jLabel1, new java.awt.GridBagConstraints());
        jDialog1.getContentPane().add(jProgressBar1, new java.awt.GridBagConstraints());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("MainWindow.title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(507, 345));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 518, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 313, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);

        jMenu1.setText(bundle.getString("MainWindow.jMenu1.text")); // NOI18N

        jMenuItem2.setText(bundle.getString("MainWindow.jMenuItem2.text")); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText(bundle.getString("MainWindow.jMenuItem3.text")); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText(bundle.getString("MainWindow.jMenuItem1.text")); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText(bundle.getString("MainWindow.jMenu2.text")); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            final File file = jFileChooser1.getSelectedFile();
            System.out.println("importing: " + file.getName());
            jProgressBar1.setToolTipText("importing: " + file.getName());
            jLabel1.setText("importing: " + file.getName());

            jDialog1.setVisible(true);
            this.validate();
            
            importingThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ByteArrayOutputStream os = null;
                    try {

                        jPanel1.removeAll();
                        MainWindow.this.validate();
                        
                        jProgressBar1.setValue(33);
                        jProgressBar1.setToolTipText("Applying XSL transformation...");
                        jLabel1.setText("Applying XSL transformation...");
                        os = Xmi2SimpleFormat.transform(file);
                        jProgressBar1.setValue(66);
                        Tokenizer t = new Tokenizer(os);
                        jProgressBar1.setToolTipText("Tokenizer working...");
                        jLabel1.setText("Tokenizer working...");
                        jProgressBar1.setValue(100);
                        List<simpleformat.Class> list = t.tokenize();
                        jProgressBar1.setToolTipText("Done.");
                        jLabel1.setText("Done.");
                        
                        
                        // Graph<V, E> where V is the type of the vertices
                        // and E is the type of the edges
                        Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
                        // Add some vertices. From above we defined these to be type Integer.
                        g.addVertex((Integer)1);
                        g.addVertex((Integer)2);
                        g.addVertex((Integer)3);
                        // Add some edges. From above we defined these to be of type String
                        // Note that the default is for undirected edges.
                        g.addEdge("Edge-A", 1, 2); // Note that Java 1.5 auto-boxes primitives
                        g.addEdge("Edge-B", 2, 3);
                        // Let's see what we have. Note the nice output from the
                        // SparseMultigraph<V,E> toString() method
                        System.out.println("The graph g = " + g.toString());
                        
                        // find dependency patterns
                        List<DependencyPatternClassFinder> dpcfList = new ArrayList<DependencyPatternClassFinder>();
                        dpcfList.add(new AuthorityClassFinder(list, t.getEdgeCount(), 0.1f));
                        dpcfList.add(new HubClassFinder(list, t.getEdgeCount(), 0.1f));
                        dpcfList.add(new CycleClassFinder(list));
                        
                        for (DependencyPatternClassFinder dpcf : dpcfList) {
                            dpcf.find();
                        }
                        
                        // find bridges
                        ByteArrayOutputStream grph = new ByteArrayOutputStream();
                        SimpleFormat2Graph sf2g = new SimpleFormat2Graph(os);
                        sf2g.write(grph);
                        
                        List<Integer[]> bridges = new ArrayList<Integer[]>();
                        MyClust bridgeCluster = new MyClust(grph, "1", "2", "1");
                        Map<Integer[], Integer[]> bridgeMap = bridgeCluster.getBridgeNodes();
                        for (Integer[] set : bridgeMap.values()) {
                            if (set.length > 2) {
                                bridges.add(set);
                            }
                        }
                        
                        
                        
                        // create jung graph then display it
                        Graph<simpleformat.Class, String> g2 = new SparseMultigraph<simpleformat.Class, String>();
                        for (simpleformat.Class c : list) {
                            g2.addVertex(c);
                            for (simpleformat.Class o : c.getOutList()) {
                                g2.addEdge(c.getName() + "-" + o.getName(), c, o);
                            }
                        }
                        System.out.println("The graph g2 = " + g2.toString());
                        
                        FRLayout l = new FRLayout<simpleformat.Class, String>(g2);
                        VisualizationViewer vv = new VisualizationViewer(l);
                        
                        
                        vv.getRenderContext().setVertexShapeTransformer(new Transformer() {

                            @Override
                            public Object transform(Object o) {
                                simpleformat.Class c = (simpleformat.Class)o;
                                switch (c.getType())
                                {
                                    case simpleformat.Class.AUTHORITY:
                                    case simpleformat.Class.HUB:
                                    case simpleformat.Class.CYCLE:
                                        return new VertexShapeFactory<simpleformat.Class>().getRegularPolygon(c, 3);
                                    case simpleformat.Class.BRIDGE:
                                        return new VertexShapeFactory<simpleformat.Class>().getRectangle(c);
                                    case simpleformat.Class.ISLAND:
                                        return new VertexShapeFactory<simpleformat.Class>().getEllipse(c);
                                    default:
                                        return new VertexShapeFactory<simpleformat.Class>().getEllipse(c);
                                }
                            }
                        });
                        
                        jPanel1.setLayout(new BorderLayout());
                        jPanel1.add(vv, BorderLayout.CENTER);
                        jPanel1.setVisible(true);
                        
                        MainWindow.this.validate();
                        
                        jDialog1.setVisible(false);
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileFormatNotSupportedException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TransformerConfigurationException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TransformerException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            os.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            importingThread.start();

        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void onDialogClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onDialogClosed
        // TODO add your handling code here:
        importingThread.interrupt();
    }//GEN-LAST:event_onDialogClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            // set the look and feel
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
