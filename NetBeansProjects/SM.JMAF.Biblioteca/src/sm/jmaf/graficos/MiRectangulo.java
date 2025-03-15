/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.jmaf.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Esta clase representa un rectángulo en un entorno gráfico.
 * Extiende la clase abstracta MiShape e implementa métodos para
 * dibujar el rectángulo, verificar si contiene un punto y establecer
 * su ubicación.
 * 
 * @author juanmaaf
 */
public class MiRectangulo extends MiShape{
    private Rectangle2D.Float forma; // La forma rectangular
    
    /**
     * Crea un nuevo rectángulo con las coordenadas y dimensiones especificadas.
     * 
     * @param x La coordenada x del rectángulo.
     * @param y La coordenada y del rectángulo.
     * @param w El ancho del rectángulo.
     * @param h La altura del rectángulo.
     */
    public MiRectangulo(float x, float y, float w, float h){
        forma = new Rectangle2D.Float(x, y, w, h);
    }
    
    /**
     * Verifica si el rectángulo contiene el punto especificado.
     * 
     * @param p El punto a verificar.
     * @return true si el rectángulo contiene el punto, false en caso contrario.
     */
    @Override
    public boolean contains(Point2D p) {
        return forma.contains(p);
    }

    /**
     * Establece la ubicación del rectángulo.
     * 
     * @param p La nueva ubicación del rectángulo.
     */
    @Override
    public void setLocation(Point2D p) {
        forma.setFrame(p.getX(), p.getY(), forma.width, forma.height);    
    }
    
    /**
    * Obtiene la ubicación del rectángulo.
    * 
    * @return La ubicación del rectángulo.
    */
    @Override
    public Point2D getLocation(){
        return new Point2D.Float((float) forma.getX(), (float) forma.getY()); // Devuelve la esquina superior izquierda del rectángulo como su ubicación
    }

    /**
     * Establece los límites del rectángulo a partir de las coordenadas de sus diagonales.
     * 
     * @param x La coordenada x del primer punto de la diagonal.
     * @param y La coordenada y del primer punto de la diagonal.
     * @param x0 La coordenada x del segundo punto de la diagonal.
     * @param y0 La coordenada y del segundo punto de la diagonal.
     */
    public void setFrameFromDiagonal(int x, int y, int x0, int y0) {
        forma.setFrameFromDiagonal(x, y, x0, y0);
    }
    
    /**
     * Dibuja el rectángulo en el contexto gráfico especificado.
     * 
     * @param g2d El contexto gráfico en el que se dibuja el rectángulo.
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

    
}