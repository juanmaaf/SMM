/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practica3smm;

import java.awt.Color;

/**
 *
 * @author juanmaaf
 */
public class VentanaPrincipalEjemplo extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipalEjemplo() {
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

        boton = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(formListener);
        getContentPane().setLayout(new java.awt.FlowLayout());

        boton.setText("Botón");
        boton.addMouseMotionListener(formListener);
        boton.addMouseListener(formListener);
        getContentPane().add(boton);

        boton2.setText("Botón2");
        boton2.addMouseListener(formListener);
        boton2.addActionListener(formListener);
        getContentPane().add(boton2);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener, java.awt.event.MouseMotionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == boton2) {
                VentanaPrincipalEjemplo.this.boton2ActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == boton) {
                VentanaPrincipalEjemplo.this.botonMouseClicked(evt);
            }
            else if (evt.getSource() == boton2) {
                VentanaPrincipalEjemplo.this.boton2MouseClicked(evt);
            }
            else if (evt.getSource() == VentanaPrincipalEjemplo.this) {
                VentanaPrincipalEjemplo.this.formMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == boton) {
                VentanaPrincipalEjemplo.this.botonMouseEntered(evt);
            }
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == boton) {
                VentanaPrincipalEjemplo.this.botonMouseExited(evt);
            }
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }

        public void mouseDragged(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == boton) {
                VentanaPrincipalEjemplo.this.botonMouseDragged(evt);
            }
        }

        public void mouseMoved(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    private void botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseClicked
        // TODO add your handling code here:
        boton.setBackground(Color.red);
    }//GEN-LAST:event_botonMouseClicked

    private void botonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseEntered
        // TODO add your handling code here:
        boton.setBackground(Color.blue);
    }//GEN-LAST:event_botonMouseEntered

    private void botonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseExited
        // TODO add your handling code here:
        boton.setBackground(Color.green);
    }//GEN-LAST:event_botonMouseExited

    private void botonMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseDragged
        // TODO add your handling code here:
        boton.setBackground(Color.yellow);                                 
    }//GEN-LAST:event_botonMouseDragged

    private void boton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseClicked
        // TODO add your handling code here:
        boton2.setBackground(Color.black);
    }//GEN-LAST:event_boton2MouseClicked

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        // TODO add your handling code here:
        boton2.setBackground(Color.orange);
    }//GEN-LAST:event_boton2ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        this.setTitle("Prácticas SMM");
    }//GEN-LAST:event_formMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JButton boton2;
    // End of variables declaration//GEN-END:variables
}
