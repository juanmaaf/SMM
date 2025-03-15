/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package practicafinalsmm;

import java.awt.image.BufferedImage;
import sm.jmaf.iu.Lienzo2D;

/**
 *
 * @author juanmaaf
 */
public class VentanaInterna extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInterna
     */
    public VentanaInterna() {
        initComponents();
        
        setSize(300, 300);
    }
    
    public VentanaInterna(BufferedImage img) {
        initComponents();
        
        lienzo.setImage(img);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_panel = new javax.swing.JScrollPane();
        lienzo = new sm.jmaf.iu.Lienzo2D();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        scroll_panel.setViewportView(lienzo);

        getContentPane().add(scroll_panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public Lienzo2D getLienzo2D() {
        return lienzo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sm.jmaf.iu.Lienzo2D lienzo;
    private javax.swing.JScrollPane scroll_panel;
    // End of variables declaration//GEN-END:variables
}
