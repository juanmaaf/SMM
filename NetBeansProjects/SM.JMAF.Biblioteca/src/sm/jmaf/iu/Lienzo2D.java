/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sm.jmaf.iu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import sm.jmaf.eventos.LienzoEvent;
import sm.jmaf.eventos.LienzoListener;
import sm.jmaf.graficos.MiElipse;
import sm.jmaf.graficos.MiFantasma;
import sm.jmaf.graficos.MiLinea;
import sm.jmaf.graficos.MiRectangulo;
import sm.jmaf.graficos.MiShape;
import static sm.jmaf.iu.HerramientaDibujo.ELIPSE;
import static sm.jmaf.iu.HerramientaDibujo.FANTASMA;
import static sm.jmaf.iu.HerramientaDibujo.LINEA;
import static sm.jmaf.iu.HerramientaDibujo.RECTANGULO;



/**
 * Panel personalizado para dibujar figuras en un lienzo 2D.
 * Permite dibujar líneas, rectángulos, elipses y figuras tipo fantasma.
 * También proporciona funcionalidades como seleccionar figuras para moverlas,
 * establecer el grosor de línea, el color de relleno, la transparencia y el alisado.
 * 
 * Este panel maneja eventos de ratón para permitir al usuario dibujar y manipular las figuras.
 * 
 * @author juanmaaf
 */
public class Lienzo2D extends javax.swing.JPanel {
    private List<MiShape> vectorFiguras; // Vector que almacena las figuras dibujadas
    private MiShape forma; // Forma actualmente en proceso de dibujo
    private HerramientaDibujo herramienta; // Herramienta de dibujo seleccionada
    private Point punto_inicial; // Punto inicial para dibujar figuras
    private Point punto_desplazamiento; // Punto que reflejará la diferencia entre el punto inicial y el punto donde se pinche para evitar el salto en el desplazamiento
    private boolean relleno; // Indica si las figuras deben ser rellenadas
    private boolean modo_edicion; // Indica si se está editando
    private boolean modo_transparencia; // Indica si se aplica transparencia a las figuras
    private boolean modo_alisado; // Indica si se aplica alisado a las figuras
    
    private Color color; // Color de las figuras
    private int grosor; // Grosor de la línea de las figuras
    
    private BufferedImage img;
    
    private ArrayList<LienzoListener> lienzoEventListeners;
    
    /**
     * Crea un nuevo lienzo 2D.
     */
    public Lienzo2D() {
        initComponents();
        
        // Inicialización de variables
        vectorFiguras = new ArrayList<>();
        forma = null;
        punto_inicial = null;
        punto_desplazamiento = null;
        relleno = false;
        modo_edicion = false;
        modo_transparencia = false;
        modo_alisado = false;
        herramienta = null;
        
        color = Color.BLACK; // Color por defecto
        grosor = 1; // Grosor por defecto
        
        img = null;
        
        lienzoEventListeners = new ArrayList();
        
        this.setBackground(Color.white);
    }

    // Getters y setters para las propiedades del lienzo
    
    /**
     * Obtiene la herramienta de dibujo seleccionada.
     * 
     * @return La herramienta de dibujo seleccionada.
     */
    public HerramientaDibujo getHerramienta() {
        return herramienta;
    }

    /**
     * Establece la herramienta de dibujo seleccionada.
     * 
     * @param h La herramienta de dibujo a establecer.
     */
    public void setHerramienta(HerramientaDibujo h) {
        herramienta = h;
        
        if(forma != null){
            forma.setSeleccionada(false);
        }
    }

    /**
     * Obtiene si las figuras deben ser rellenadas.
     * 
     * @return true si las figuras deben ser rellenadas, false en caso contrario.
     */
    public boolean getRelleno() {
        return relleno;
    }

    /**
     * Establece si las figuras deben ser rellenadas.
     * 
     * @param r true para rellenar las figuras, false para dibujar solo el borde.
     */
    public void setRelleno(boolean r) {
        if(modo_edicion){
            if(forma != null){
                forma.setRellenar(r);
                repaint();
            }
        }
        else{
            relleno = r;
        }
    }

    /**
     * Obtiene si se está editando una figura.
     * 
     * @return true si se está editando una figura, false en caso contrario.
     */
    public boolean getModo_edicion() {
        return modo_edicion;
    }

    /**
     * Establece si se está editando una figura.
     * 
     * @param m true para activar el modo edicion, false para desactivarlo.
     */
    public void setModo_edicion(boolean m) {
        modo_edicion = m;
    }

    /**
     * Obtiene si se aplica transparencia a las figuras.
     * 
     * @return true si se aplica transparencia a las figuras, false en caso contrario.
     */
    public boolean getModo_transparencia() {
        return modo_transparencia;
    }

    /**
     * Establece si se aplica transparencia a las figuras.
     * 
     * @param m true para aplicar transparencia, false para desactivarla.
     */
    public void setModo_transparencia(boolean m) {
        if(modo_edicion){
            if(forma != null){
                forma.setTransparencia(m);
                repaint();
            }
        }
        else{
            modo_transparencia = m;
        }
    }

    /**
     * Obtiene si se aplica alisado a las figuras.
     * 
     * @return true si se aplica alisado a las figuras, false en caso contrario.
     */
    public boolean getModo_alisado() {
        return modo_alisado;
    }

    /**
     * Establece si se aplica alisado a las figuras.
     * 
     * @param m true para aplicar alisado, false para desactivarlo.
     */
    public void setModo_alisado(boolean m) {
        if(modo_edicion){
            if(forma != null){
                forma.setAlisado(m);
                repaint();
            }
        }
        else{
            modo_alisado = m;
        }
    }
    
    /**
     * Establece el color de las figuras.
     * 
     * @param c El color a establecer.
     */
    public void setColor(Color c) {
        if(modo_edicion){
            if(forma != null){
                forma.setRelleno(c);
                repaint();
            }
        }
        else{
            color = c;
        }
    }
    
    /**
     * Establece el grosor de la línea de las figuras.
     * 
     * @param g El grosor de la línea a establecer.
     */
    public void setGrosor(int g) {
        if(modo_edicion){
            if(forma != null){
                forma.setGrosor(g);
                repaint();
            }
        }
        else{
            grosor = g;
        }
    }
    
    /**
     * Establece la imagen de fondo del lienzo.
     * 
     * @param img La imagen de fondo a establecer.
     */
    public void setImage(BufferedImage img) {
        this.img = img;
        
        if (img != null) {
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        }
    }

    /**
     * Obtiene la imagen de fondo del lienzo.
     * 
     * @return La imagen de fondo.
     */
    public BufferedImage getImage() {
        return img;
    }

    /**
     * Obtiene el grosor de la línea de las figuras.
     * 
     * @return El grosor de la línea.
     */
    public int getGrosor() {
        return grosor;
    }

    /**
     * Obtiene el color de las figuras.
     * 
     * @return El color de las figuras.
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Método para determinar la figura seleccionada en un punto dado.
     * 
     * @param p El punto en el lienzo.
     * @return La figura seleccionada en el punto, o null si no hay ninguna.
     */
    private MiShape figuraSeleccionada(Point2D p){
        for(MiShape s:vectorFiguras)
            if(s.contains(p)) return s;
        return null;
    }
    
    /**
     * Método para manejar el evento de presionar el botón del ratón.
     * 
     * @param evt El evento de ratón.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        // Para la entrega final he configurado correctamente el mover sin el salto de la Práctica 5
        if(modo_edicion){
            if (forma != null) {
                forma.setSeleccionada(false);
            }
            
            forma = figuraSeleccionada(evt.getPoint());
            
            if (forma != null) {
                Point2D.Float puntoFloat = (Point2D.Float) forma.getLocation();
                punto_inicial = new Point((int) puntoFloat.getX(), (int) puntoFloat.getY());
                forma.setSeleccionada(true);
                
                punto_desplazamiento = new Point((int)(evt.getX() - puntoFloat.getX()), (int)(evt.getY() - puntoFloat.getY()));
                
                repaint();
            }
        }
        else{
            if(herramienta != null){
                punto_inicial = evt.getPoint();
        
                switch (herramienta) {
                    case LINEA:
                        forma = new MiLinea(punto_inicial, punto_inicial);
                        break;
                    case RECTANGULO:
                        forma = new MiRectangulo(punto_inicial.x, punto_inicial.y, 0, 0);
                        break;
                    case ELIPSE:
                        forma = new MiElipse(punto_inicial.x, punto_inicial.y, 0, 0);
                        break;
                    case FANTASMA:
                        forma = new MiFantasma(evt.getPoint());
                        repaint();
                        break;
                    default:
                        break;
                }

                forma.setGrosor(grosor);
                forma.setRelleno(color);
                forma.setTransparencia(modo_transparencia);
                forma.setAlisado(modo_alisado);
                forma.setRellenar(relleno);

                vectorFiguras.add(forma);
                notifyShapeAddedEvent( new LienzoEvent(this, forma) );
            }
        }
    }//GEN-LAST:event_formMousePressed
    
    /**
     * Método para manejar el evento de arrastrar el ratón.
     * 
     * @param evt El evento de ratón.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        if(modo_edicion && forma != null){
            Point2D.Double punto_mover = new Point2D.Double(evt.getPoint().getX() - punto_desplazamiento.getX(), evt.getPoint().getY() - punto_desplazamiento.getY());
            forma.setLocation(punto_mover);
        }
        else{
            if (forma instanceof MiLinea) {
                MiLinea line = (MiLinea) forma;
                line.setLine(punto_inicial, evt.getPoint());
            } else if (forma instanceof MiRectangulo) {
                MiRectangulo rectangulo = (MiRectangulo) forma;
                rectangulo.setFrameFromDiagonal(punto_inicial.x, punto_inicial.y, evt.getX(), evt.getY());
            } else if (forma instanceof MiElipse) {
                MiElipse elipse = (MiElipse) forma;
                elipse.setFrameFromDiagonal(punto_inicial.x, punto_inicial.y, evt.getX(), evt.getY());
            }
        }
        repaint();
    }//GEN-LAST:event_formMouseDragged

   
    /**
     * Método para dibujar las figuras en el lienzo.
     * 
     * @param g El contexto gráfico en el que se dibujan las figuras.
     */
    @Override
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        // Establecer el área de recorte para que coincida con el área de la imagen
        Rectangle clipRect = new Rectangle(0, 0, img.getWidth(), img.getHeight());
        g2d.clip(clipRect);
    
        if(img!=null) g2d.drawImage(img,0,0,this);
        
        
        for(MiShape s: vectorFiguras) {
            s.draw(g2d);
        }
    }
    
    /**
     * Obtiene la imagen pintada en el lienzo, incluyendo las figuras.
     * 
     * @return La imagen pintada en el lienzo.
     */
    public BufferedImage getPaintedImage(){
    // Código para crear una nueva imagen que
    // contenga la imagen actual más las figuras
        BufferedImage imgout = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        Graphics2D g2dImagen = imgout.createGraphics();
        if(img!=null) g2dImagen.drawImage(img,0,0,this);
        
        for(MiShape s: vectorFiguras) {
            s.draw(g2dImagen);
        }
        
        return imgout;
    }
    
    /**
     * Vuelca la figura seleccionada al lienzo y la elimina del vector de figuras.
     */
    public void volcarFigura() {
        if (forma != null && forma.getSeleccionada()) {
            Graphics2D g2d = img.createGraphics();
            forma.setSeleccionada(false);
            forma.draw(g2d);
            vectorFiguras.remove(forma);
            forma = null;
            repaint();
        }
    }

    /**
     * Añade un listener para eventos del lienzo.
     * 
     * @param listener El listener a añadir.
     */
    public void addLienzoListener(LienzoListener listener) {
        if (listener != null) {
            lienzoEventListeners.add(listener);
        }
    }

    /**
     * Notifica a los listeners que se ha añadido una nueva figura.
     * 
     * @param evt El evento que contiene la figura añadida.
     */
    private void notifyShapeAddedEvent(LienzoEvent evt) {
        if (!lienzoEventListeners.isEmpty()) {
            for (LienzoListener listener : lienzoEventListeners) {
                listener.shapeAdded(evt);
            }
        }
    }

    /**
     * Notifica a los listeners que se ha seleccionado una nueva figura.
     * 
     * @param evt El evento que contiene la figura seleccionada.
     */
    private void notifyShapeSelectedEvent(LienzoEvent evt) {
        if (!lienzoEventListeners.isEmpty()) {
            for (LienzoListener listener : lienzoEventListeners) {
                listener.shapeSelected(evt);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
