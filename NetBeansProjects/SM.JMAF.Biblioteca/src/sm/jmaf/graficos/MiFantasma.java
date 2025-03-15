/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.jmaf.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Esta clase representa un fantasma en un entorno gráfico.
 * Extiende la clase abstracta MiShape e implementa métodos para
 * dibujar el fantasma, verificar si contiene un punto y establecer
 * su ubicación.
 * 
 * El fantasma está compuesto por un círculo grande que representa
 * su cabeza, dos círculos más pequeños que representan los ojos y
 * un rectángulo que representa su cuerpo.
 * 
 * @author juanmaaf
 */
public class MiFantasma extends MiShape{
    private Area forma; // La forma del fantasma
    
    /**
     * Crea un nuevo fantasma con la posición especificada.
     * 
     * @param p La posición del fantasma.
     */
    public MiFantasma(Point2D p) {
        
        // Crear la cabeza del fantasma (círculo grande)
        Ellipse2D.Float circulo = new Ellipse2D.Float();
        circulo.setFrame(p.getX(), p.getY(), 50, 50);
        forma = new Area(circulo);

        // Crear los ojos del fantasma (dos círculos pequeños)
        Ellipse2D.Float ojo1 = new Ellipse2D.Float();
        ojo1.setFrame(p.getX() + 10, p.getY()+20, 10, 10);
        Area areaOjo1 = new Area(ojo1);

        Ellipse2D.Float ojo2 = new Ellipse2D.Float();
        ojo2.setFrame(p.getX() + 30, p.getY()+20, 10, 10);
        Area areaOjo2 = new Area(ojo2);
        
        // Crear el cuerpo del fantasma (rectángulo)
        Rectangle2D.Float rectangulo = new Rectangle2D.Float();
        rectangulo.setFrame(p.getX(), p.getY() + 25, 50, 50);
        Area cuerpo = new Area(rectangulo);

        // Combinar las áreas para formar la figura del fantasma
        forma.add(cuerpo); // Añadir el cuerpo
        forma.subtract(areaOjo1); // Eliminar el área del ojo 1
        forma.subtract(areaOjo2); // Eliminar el área del ojo 2
        
    }
    
    /**
     * Dibuja el fantasma en el contexto gráfico especificado.
     * 
     * @param g2d El contexto gráfico en el que se dibuja el fantasma.
     */
    @Override
    public void draw(Graphics2D g2d) {
        // Si la figura está seleccionada, dibuja una elipse roja y discontinua alrededor de ella
        if (getSeleccionada()) {
            Ellipse2D.Float elipse = new Ellipse2D.Float((float) getLocation().getX() - 5, (float) getLocation().getY() - 5, 12, 12);
            g2d.setColor(Color.RED);
            
            // Definir el patrón de trazo para hacer la elipse discontinua
            float[] patron = {4.0f, 3.0f};

            // Crear el objeto BasicStroke para un trazo discontinuo
            Stroke trazo = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.0f, patron, 0.0f);

            g2d.setStroke(trazo);
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
            g2d.draw(elipse);
        }
        
        g2d.setStroke(getStroke());
        g2d.setPaint(getRelleno());
        g2d.setComposite(getTransparencia());
        g2d.setRenderingHints(getAlisado());
        
        if(getRellenar())
            g2d.fill(forma);
        else
            g2d.draw(forma);
    }

    /**
     * Verifica si el fantasma contiene el punto especificado.
     * 
     * @param p El punto a verificar.
     * @return true si el fantasma contiene el punto, false en caso contrario.
     */
    @Override
    public boolean contains(Point2D p) {
        return forma.contains(p);
    }

    /**
     * Establece la ubicación del fantasma.
     * 
     * @param p La nueva ubicación del fantasma.
     */
    @Override
    public void setLocation(Point2D p) {
        float dX = (float) (p.getX() - forma.getBounds2D().getX());
        float dY = (float) (p.getY() - forma.getBounds2D().getY());
        
        // Actualizar la ubicación del fantasma
        forma.transform(AffineTransform.getTranslateInstance(dX, dY));
    }
    
    /**
    * Obtiene la ubicación del fantasma.
    * 
    * @return La ubicación del fantasma.
    */
    @Override
    public Point2D getLocation(){
        // Obtiene las coordenadas del punto superior izquierdo del rectángulo que engloba al fantasma
        float x = (float) forma.getBounds2D().getX();
        float y = (float) forma.getBounds2D().getY();

        return new Point2D.Float(x, y); // Devuelve las coordenadas del punto superior izquierdo del rectángulo
    }
    
}
