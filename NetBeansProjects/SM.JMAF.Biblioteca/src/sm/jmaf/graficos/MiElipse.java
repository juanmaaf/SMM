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

/**
 * Esta clase representa una elipse en un entorno gráfico.
 * Extiende la clase abstracta MiShape e implementa métodos para
 * dibujar la elipse, verificar si contiene un punto y establecer
 * su ubicación.
 * 
 * @author juanmaaf
 */
public class MiElipse extends MiShape{
    private Ellipse2D.Float forma; // La forma de la elipse
    
    /**
     * Crea una nueva elipse con las coordenadas y dimensiones especificadas.
     * 
     * @param x La coordenada x de la esquina superior izquierda del rectángulo que circunscribe la elipse.
     * @param y La coordenada y de la esquina superior izquierda del rectángulo que circunscribe la elipse.
     * @param w El ancho de la elipse.
     * @param h La altura de la elipse.
     */
    public MiElipse(float x, float y, float w, float h) {
        forma = new Ellipse2D.Float(x, y, w, h);
    }
        
    /**
     * Establece la ubicación de la elipse.
     * 
     * @param pos La nueva ubicación de la elipse.
     */
    @Override
    public void setLocation(Point2D pos){
        forma.setFrame(pos.getX(), pos.getY(), forma.width, forma.height);
    }
    
    /**
    * Obtiene la ubicación de la elipse.
    * 
    * @return La ubicación de la elipse.
    */
   @Override
   public Point2D getLocation(){
       // Obtiene las coordenadas de la esquina superior izquierda del rectángulo que circunscribe la elipse
       float x = (float) forma.getX();
       float y = (float) forma.getY();

       return new Point2D.Float(x, y); // Devuelve las coordenadas de la esquina superior izquierda del rectángulo
   }

    /**
     * Establece los límites de la elipse a partir de las coordenadas de sus diagonales.
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
     * Dibuja la elipse en el contexto gráfico especificado.
     * 
     * @param g2d El contexto gráfico en el que se dibuja la elipse.
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
     * Verifica si la elipse contiene el punto especificado.
     * 
     * @param p El punto a verificar.
     * @return true si la elipse contiene el punto, false en caso contrario.
     */
    @Override
    public boolean contains(Point2D p) {
        return forma.contains(p);
    }

    
}