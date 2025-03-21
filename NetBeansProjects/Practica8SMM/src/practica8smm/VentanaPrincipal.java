/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practica8smm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sm.jmaf.iu.HerramientaDibujo;
import sm.jmaf.iu.Lienzo2D;

/**
 *
 * @author juanmaaf
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private String texto_barra_estado;
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        
        texto_barra_estado = "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modo_dibujo = new javax.swing.ButtonGroup();
        barra_herramientas = new javax.swing.JToolBar();
        boton_nuevo = new javax.swing.JButton();
        boton_abrir = new javax.swing.JButton();
        boton_guardar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        boton_linea = new javax.swing.JToggleButton();
        boton_rectangulo = new javax.swing.JToggleButton();
        boton_elipse = new javax.swing.JToggleButton();
        boton_fantasma = new javax.swing.JToggleButton();
        boton_edicion = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        panel_color = new javax.swing.JPanel();
        boton_color = new javax.swing.JButton();
        boton_rellenar = new javax.swing.JToggleButton();
        boton_transparencia = new javax.swing.JToggleButton();
        boton_alisado = new javax.swing.JToggleButton();
        slider_grosor = new javax.swing.JSlider();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        boton_volcado = new javax.swing.JButton();
        barra_estado = new javax.swing.JLabel();
        escritorio = new javax.swing.JDesktopPane();
        menu_superior = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint Básico");

        barra_herramientas.setRollover(true);

        boton_nuevo.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica8SMM/iconos/nuevo.png")); // NOI18N
        boton_nuevo.setFocusable(false);
        boton_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_nuevoActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_nuevo);

        boton_abrir.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica8SMM/iconos/abrir.png")); // NOI18N
        boton_abrir.setFocusable(false);
        boton_abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_abrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_abrirActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_abrir);

        boton_guardar.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica8SMM/iconos/guardar.png")); // NOI18N
        boton_guardar.setFocusable(false);
        boton_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_guardar);
        barra_herramientas.add(jSeparator2);

        modo_dibujo.add(boton_linea);
        boton_linea.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica4SMM/iconos/linea.png")); // NOI18N
        boton_linea.setFocusable(false);
        boton_linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_lineaActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_linea);

        modo_dibujo.add(boton_rectangulo);
        boton_rectangulo.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica4SMM/iconos/rectangulo.png")); // NOI18N
        boton_rectangulo.setFocusable(false);
        boton_rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_rectanguloActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_rectangulo);

        modo_dibujo.add(boton_elipse);
        boton_elipse.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica4SMM/iconos/elipse.png")); // NOI18N
        boton_elipse.setFocusable(false);
        boton_elipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_elipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_elipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_elipseActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_elipse);

        modo_dibujo.add(boton_fantasma);
        boton_fantasma.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica7SMM/iconos/fantasma.png")); // NOI18N
        boton_fantasma.setFocusable(false);
        boton_fantasma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_fantasma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_fantasma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_fantasmaActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_fantasma);

        modo_dibujo.add(boton_edicion);
        boton_edicion.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica7SMM/iconos/seleccion.png")); // NOI18N
        boton_edicion.setFocusable(false);
        boton_edicion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_edicion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_edicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_edicionActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_edicion);
        barra_herramientas.add(jSeparator1);

        panel_color.setPreferredSize(new java.awt.Dimension(34, 32));
        panel_color.setLayout(new java.awt.BorderLayout());

        boton_color.setBackground(new java.awt.Color(0, 0, 0));
        boton_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_colorActionPerformed(evt);
            }
        });
        panel_color.add(boton_color, java.awt.BorderLayout.CENTER);

        barra_herramientas.add(panel_color);

        boton_rellenar.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica7SMM/iconos/rellenar.png")); // NOI18N
        boton_rellenar.setFocusable(false);
        boton_rellenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rellenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_rellenarActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_rellenar);

        boton_transparencia.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica7SMM/iconos/transparencia.png")); // NOI18N
        boton_transparencia.setFocusable(false);
        boton_transparencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_transparencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_transparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_transparenciaActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_transparencia);

        boton_alisado.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica7SMM/iconos/alisar.png")); // NOI18N
        boton_alisado.setFocusable(false);
        boton_alisado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_alisado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_alisado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_alisadoActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_alisado);

        slider_grosor.setMaximum(20);
        slider_grosor.setValue(5);
        slider_grosor.setPreferredSize(new java.awt.Dimension(50, 20));
        slider_grosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_grosorStateChanged(evt);
            }
        });
        barra_herramientas.add(slider_grosor);
        barra_herramientas.add(jSeparator3);

        boton_volcado.setIcon(new javax.swing.ImageIcon("/home/juanmaaf/NetBeansProjects/Practica8SMM/iconos/volcado.png")); // NOI18N
        boton_volcado.setFocusable(false);
        boton_volcado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_volcado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_volcado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volcadoActionPerformed(evt);
            }
        });
        barra_herramientas.add(boton_volcado);

        getContentPane().add(barra_herramientas, java.awt.BorderLayout.PAGE_START);

        barra_estado.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        barra_estado.setText("Barra de Estado");
        barra_estado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(barra_estado, java.awt.BorderLayout.PAGE_END);

        escritorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        getContentPane().add(escritorio, java.awt.BorderLayout.CENTER);

        menu_archivo.setText("Archivo");

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        menu_archivo.add(nuevo);

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        menu_archivo.add(abrir);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        menu_archivo.add(guardar);

        menu_superior.add(menu_archivo);

        setJMenuBar(menu_superior);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        // TODO add your handling code here:
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
            try{
                File f = dlg.getSelectedFile();
                BufferedImage img = ImageIO.read(f);
                VentanaInterna vi = new VentanaInterna();
                vi.getLienzo2D().setImage(img);
                this.escritorio.add(vi);
                vi.setTitle(f.getName());
                vi.setVisible(true);
            }catch(Exception ex){
                System.err.println("Error al leer la imagen");
            }
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        VentanaInterna vi=(VentanaInterna) escritorio.getSelectedFrame();
        if (vi != null) {
            BufferedImage img = vi.getLienzo2D().getPaintedImage();
            if (img != null) {
                JFileChooser dlg = new JFileChooser();
                int resp = dlg.showSaveDialog(this);
                if (resp == JFileChooser.APPROVE_OPTION) {
                    try {
                        File f = dlg.getSelectedFile();
                        ImageIO.write(img, "jpg", f);
                        vi.setTitle(f.getName());
                    } catch (Exception ex) {
                        System.err.println("Error al guardar la imagen");
                    }
                }
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        VentanaInterna vi = new VentanaInterna();
        escritorio.add(vi);
        vi.setVisible(true);
        BufferedImage img;
        img = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.WHITE); // Establecer el color de fondo blanco
        g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
        
        // Dibujar el marco alrededor de la imagen
        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, img.getWidth() - 1, img.getHeight() - 1);
        
        vi.getLienzo2D().setImage(img);
    }//GEN-LAST:event_nuevoActionPerformed

    private void boton_rectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rectanguloActionPerformed
        // TODO add your handling code here:
        if(boton_rectangulo.isSelected()){
            Lienzo2D lienzo = getSelectedLienzo();
            
            if(lienzo != null){
                lienzo.setHerramienta(HerramientaDibujo.RECTANGULO);
                barra_estado.setText("Modo Rectángulo");
                texto_barra_estado = "Modo Rectángulo. ";
                lienzo.setModo_edicion(boton_edicion.isSelected());
            }
        }
    }//GEN-LAST:event_boton_rectanguloActionPerformed

    private void boton_lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_lineaActionPerformed
        // TODO add your handling code here:
        if(boton_linea.isSelected()){
            Lienzo2D lienzo = getSelectedLienzo();
            
            if(lienzo != null){
                lienzo.setHerramienta(HerramientaDibujo.LINEA);
                barra_estado.setText("Modo Línea");
                texto_barra_estado = "Modo Línea. ";
                lienzo.setModo_edicion(boton_edicion.isSelected());
            }
        }
    }//GEN-LAST:event_boton_lineaActionPerformed

    private void boton_elipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_elipseActionPerformed
        // TODO add your handling code here:
        if(boton_elipse.isSelected()){
            Lienzo2D lienzo = getSelectedLienzo();
            
            if(lienzo != null){
                lienzo.setHerramienta(HerramientaDibujo.ELIPSE);
                barra_estado.setText("Modo Elipse");
                texto_barra_estado = "Modo Elipse. ";
                lienzo.setModo_edicion(boton_edicion.isSelected());
            }
        }
    }//GEN-LAST:event_boton_elipseActionPerformed

    private void boton_fantasmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_fantasmaActionPerformed
        // TODO add your handling code here:.
        if(boton_fantasma.isSelected()){
            Lienzo2D lienzo = getSelectedLienzo();
            
            if(lienzo != null){
                lienzo.setHerramienta(HerramientaDibujo.FANTASMA);
                barra_estado.setText("Modo Fantasma");
                texto_barra_estado = "Modo Fantasma ";
                lienzo.setModo_edicion(boton_edicion.isSelected());
            }
        }
    }//GEN-LAST:event_boton_fantasmaActionPerformed

    private void boton_edicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_edicionActionPerformed
        // TODO add your handling code here:
        Lienzo2D lienzo = getSelectedLienzo();
            
        if(lienzo != null){
            lienzo.setModo_edicion(boton_edicion.isSelected());
        }
    }//GEN-LAST:event_boton_edicionActionPerformed

    private void boton_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_colorActionPerformed
        // TODO add your handling code here:
        Lienzo2D lienzo = getSelectedLienzo();
        
        if(lienzo != null){
            Color color = JColorChooser.showDialog(this, "Elije un color", Color.BLACK);
            lienzo.setColor(color);
            boton_color.setBackground(color);
        }
    }//GEN-LAST:event_boton_colorActionPerformed

    private void boton_rellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rellenarActionPerformed
        // TODO add your handling code here:
        Lienzo2D lienzo = getSelectedLienzo();
            
        if(lienzo != null){
            lienzo.setRelleno(boton_rellenar.isSelected());
        }
    }//GEN-LAST:event_boton_rellenarActionPerformed

    private void boton_transparenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_transparenciaActionPerformed
        // TODO add your handling code here:
        Lienzo2D lienzo = getSelectedLienzo();
            
        if(lienzo != null){
            lienzo.setModo_transparencia(boton_transparencia.isSelected());
        }
    }//GEN-LAST:event_boton_transparenciaActionPerformed

    private void boton_alisadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_alisadoActionPerformed
        // TODO add your handling code here:
        Lienzo2D lienzo = getSelectedLienzo();
            
        if(lienzo != null){
            lienzo.setModo_alisado(boton_alisado.isSelected());
        }
    }//GEN-LAST:event_boton_alisadoActionPerformed

    private void slider_grosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_grosorStateChanged
        // TODO add your handling code here:
        Lienzo2D lienzo = getSelectedLienzo();
            
        if(lienzo != null){
            lienzo.setGrosor(slider_grosor.getValue());
        }
    }//GEN-LAST:event_slider_grosorStateChanged

    private void boton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_nuevoActionPerformed
        // TODO add your handling code here:
        nuevoActionPerformed(evt);
    }//GEN-LAST:event_boton_nuevoActionPerformed

    private void boton_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_abrirActionPerformed
        // TODO add your handling code here:
        abrirActionPerformed(evt);
    }//GEN-LAST:event_boton_abrirActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        guardarActionPerformed(evt);
    }//GEN-LAST:event_boton_guardarActionPerformed

    private void boton_volcadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volcadoActionPerformed
        // TODO add your handling code here:
        Lienzo2D lienzo = getSelectedLienzo();
        
        if(lienzo != null){
            lienzo.volcarFigura();
        }
    }//GEN-LAST:event_boton_volcadoActionPerformed

    private Lienzo2D getSelectedLienzo() {
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        return vi!=null ? vi.getLienzo2D() : null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JLabel barra_estado;
    private javax.swing.JToolBar barra_herramientas;
    private javax.swing.JButton boton_abrir;
    private javax.swing.JToggleButton boton_alisado;
    private javax.swing.JButton boton_color;
    private javax.swing.JToggleButton boton_edicion;
    private javax.swing.JToggleButton boton_elipse;
    private javax.swing.JToggleButton boton_fantasma;
    private javax.swing.JButton boton_guardar;
    private javax.swing.JToggleButton boton_linea;
    private javax.swing.JButton boton_nuevo;
    private javax.swing.JToggleButton boton_rectangulo;
    private javax.swing.JToggleButton boton_rellenar;
    private javax.swing.JToggleButton boton_transparencia;
    private javax.swing.JButton boton_volcado;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenuBar menu_superior;
    private javax.swing.ButtonGroup modo_dibujo;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JPanel panel_color;
    private javax.swing.JSlider slider_grosor;
    // End of variables declaration//GEN-END:variables
}
