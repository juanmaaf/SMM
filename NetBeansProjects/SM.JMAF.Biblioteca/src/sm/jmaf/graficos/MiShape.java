/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.jmaf.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;



/**
 * Esta clase representa una figura geométrica en un entorno gráfico.
 * Proporciona métodos para configurar propiedades básicas de la figura,
 * como el grosor del trazo, la transparencia, el suavizado, el relleno y 
 * la ubicación. Además, define métodos abstractos que deben ser implementados
 * por las clases que hereden de esta para dibujar la figura y verificar si 
 * contiene un punto.
 * 
 * @author juanmaaf
 */
public abstract class MiShape {
    private Stroke stroke = new BasicStroke(); // El trazo utilizado para dibujar la figura
    private Composite transparencia = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f); // La transparencia de la figura
    private RenderingHints alisado = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); // El suavizado de la figura
    private Paint relleno = Color.BLACK; // El color de relleno de la figura
    private boolean seleccionada = false;
    
    private boolean rellenar = false; // Indica si la figura debe rellenarse o no

    /**
     * Obtiene el trazo utilizado para dibujar la figura.
     * 
     * @return El trazo utilizado para dibujar la figura.
     */
    public Stroke getStroke() {
        return stroke;
    }

    /**
     * Obtiene la transparencia de la figura.
     * 
     * @return La transparencia de la figura.
     */
    public Composite getTransparencia() {
        return transparencia;
    }

    /**
     * Obtiene el suavizado de la figura.
     * 
     * @return El suavizado de la figura.
     */
    public RenderingHints getAlisado() {
        return alisado;
    }
    
    /**
     * Obtiene el color de relleno de la figura.
     * 
     * @return El color de relleno de la figura.
     */
    public Paint getRelleno(){
        return relleno;
    }
    
    /**
     * Indica si la figura debe rellenarse o no.
     * 
     * @return true si la figura debe rellenarse, false en caso contrario.
     */
    public boolean getRellenar(){
        return rellenar;
    }
    
    public boolean getSeleccionada(){
        return seleccionada;
    }
    
    /**
     * Establece el grosor del trazo.
     * 
     * @param grosor El grosor del trazo.
     */
    public void setGrosor(int grosor){
        stroke = new BasicStroke(grosor);
    }
    
    /**
     * Establece la transparencia de la figura.
     * 
     * @param t true si se desea aplicar transparencia, false en caso contrario.
     */
    public void setTransparencia(boolean t){
        if(t)
            transparencia = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
    }
    
    /**
     * Establece el suavizado de la figura.
     * 
     * @param a true si se desea aplicar suavizado, false en caso contrario.
     */
    public void setAlisado(boolean a){
        if(a)
            alisado = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
    
    /**
     * Establece el color de relleno de la figura.
     * 
     * @param p El color de relleno de la figura.
     */
    public void setRelleno(Paint p){
        relleno = p;
    }
    
    /**
     * Establece si la figura debe rellenarse o no.
     * 
     * @param r true si la figura debe rellenarse, false en caso contrario.
     */
    public void setRellenar(boolean r){
        rellenar = r;
    }
    
    public void setSeleccionada(boolean s){
        seleccionada = s;
    }
    
    /**
     * Dibuja la figura en el contexto gráfico especificado.
     * 
     * @param g2d El contexto gráfico en el que se dibuja la figura.
     */
    abstract public void draw(Graphics2D g2d);
    
    /**
     * Establece la ubicación de la figura.
     * 
     * @param p La ubicación de la figura.
     */
    abstract public void setLocation(Point2D p);
    
    /**
    * Obtiene la ubicación de la figura.
    * 
    * @return La ubicación de la figura.
    */
    abstract public Point2D getLocation();


    /**
     * Verifica si la figura contiene el punto especificado.
     * 
     * @param p El punto a verificar.
     * @return true si la figura contiene el punto, false en caso contrario.
     */
    abstract public boolean contains(Point2D p);
}