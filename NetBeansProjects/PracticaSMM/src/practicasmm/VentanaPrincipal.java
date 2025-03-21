/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practicasmm;

/**
 *
 * @author juanmaaf
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setSize(500,500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemAbrir = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        submenuImprimir = new javax.swing.JMenu();
        itemImpresora = new javax.swing.JMenuItem();
        itemFichero = new javax.swing.JMenuItem();
        editar = new javax.swing.JMenu();
        itemCopiar = new javax.swing.JMenuItem();
        itemCortar = new javax.swing.JMenuItem();
        itemPegar = new javax.swing.JMenuItem();
        ver = new javax.swing.JMenu();
        itemBarraEstado = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        archivo.setText("Archivo");

        itemNuevo.setText("Nuevo");
        archivo.add(itemNuevo);

        itemAbrir.setText("Abrir");
        archivo.add(itemAbrir);

        itemGuardar.setText("Guardar");
        archivo.add(itemGuardar);

        submenuImprimir.setText("Imprimir");

        itemImpresora.setText("Impresora");
        submenuImprimir.add(itemImpresora);

        itemFichero.setText("Fichero");
        itemFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFicheroActionPerformed(evt);
            }
        });
        submenuImprimir.add(itemFichero);

        archivo.add(submenuImprimir);

        menu.add(archivo);

        editar.setText("Editar");

        itemCopiar.setText("Copiar");
        editar.add(itemCopiar);

        itemCortar.setText("Cortar");
        editar.add(itemCortar);

        itemPegar.setText("Pegar");
        editar.add(itemPegar);

        menu.add(editar);

        ver.setText("Ver");

        itemBarraEstado.setSelected(true);
        itemBarraEstado.setText("Barra de estado");
        ver.add(itemBarraEstado);

        menu.add(ver);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFicheroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemFicheroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu archivo;
    private javax.swing.JMenu editar;
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JCheckBoxMenuItem itemBarraEstado;
    private javax.swing.JMenuItem itemCopiar;
    private javax.swing.JMenuItem itemCortar;
    private javax.swing.JMenuItem itemFichero;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemImpresora;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemPegar;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu submenuImprimir;
    private javax.swing.JMenu ver;
    // End of variables declaration//GEN-END:variables
}
