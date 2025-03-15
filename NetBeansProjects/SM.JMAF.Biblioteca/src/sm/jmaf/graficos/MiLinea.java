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
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Esta clase representa una línea en un entorno gráfico.
 * Extiende la clase abstracta MiShape e implementa métodos para
 * dibujar la línea, verificar si contiene un punto y establecer
 * su ubicación.
 * 
 * @author juanmaaf
 */
public class MiLinea extends MiShape{
    private Line2D.Float forma; // La forma de la línea
    
    /**
     * Crea una nueva línea con las coordenadas especificadas.
     * 
     * @param x1 La coordenada x del primer punto de la línea.
     * @param y1 La coordenada y del primer punto de la línea.
     * @param x2 La coordenada x del segundo punto de la línea.
     * @param y2 La coordenada y del segundo punto de la línea.
     */
    public MiLinea(float x1, float y1, float x2, float y2) {
        forma = new Line2D.Float(x1,y1,x2,y2);
    }
    
    /**
     * Crea una nueva línea con los puntos especificados.
     * 
     * @param p1 El primer punto de la línea.
     * @param p2 El segundo punto de la línea.
     */
    public MiLinea(Point2D p1, Point2D p2){
        forma = new Line2D.Float(p1, p2);
    }
    
    /**
     * Obtiene el primer punto de la línea.
     * 
     * @return El primer punto de la línea.
     */
    public Point2D getP1(){
        return forma.getP1();
    }
    
    /**
     * Obtiene el segundo punto de la línea.
     * 
     * @return El segundo punto de la línea.
     */
    public Point2D getP2(){
        return forma.getP2();
    }
    
    /**
     * Obtiene la coordenada x del primer punto de la línea.
     * 
     * @return La coordenada x del primer punto de la línea.
     */
    public float getX1(){
        return (float) forma.getP1().getX();
    }
    
    /**
     * Obtiene la coordenada y del primer punto de la línea.
     * 
     * @return La coordenada y del primer punto de la línea.
     */
    public float getY1(){
        return (float) forma.getP1().getY();
    }
    
    /**
     * Obtiene la coordenada x del segundo punto de la línea.
     * 
     * @return La coordenada x del segundo punto de la línea.
     */
    public float getX2(){
        return (float) forma.getP2().getX();
    }
    
    /**
     * Obtiene la coordenada y del segundo punto de la línea.
     * 
     * @return La coordenada y del segundo punto de la línea.
     */
    public float getY2(){
        return (float) forma.getP2().getY();
    }
    
    /**
     * Calcula la distancia de un punto a la línea.
     * 
     * @param p El punto.
     * @return La distancia del punto a la línea.
     */
    public double ptLineDist(Point2D p){
        return forma.ptLineDist(p);
    }
    
    /**
     * Establece los puntos que definen la línea.
     * 
     * @param p1 El primer punto.
     * @param p2 El segundo punto.
     */
    public void setLine(Point2D p1, Point2D p2){
        forma.setLine(p1,p2);
    }
    
    /**
     * Verifica si un punto está cerca de la línea.
     * 
     * @param p El punto a verificar.
     * @return true si el punto está cerca de la línea, false en caso contrario.
     */
    public boolean isNear(Point2D p){
        if(this.getP1().equals(this.getP2())) return this.getP1().distance(p)<=2.0; //p1=p2
        return this.ptLineDist(p)<=2.0; // p1!=p2
    }
    
    /**
     * Verifica si la línea contiene el punto especificado.
     * 
     * @param p El punto a verificar.
     * @return true si la línea contiene el punto, false en caso contrario.
     */
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }
        
    /**
     * Establece la ubicación de la línea.
     * 
     * @param pos La nueva ubicación de la línea.
     */
    @Override
    public void setLocation(Point2D pos){
        double dx=pos.getX()-this.getX1();
        double dy=pos.getY()-this.getY1();
        Point2D newp2 = new Point2D.Double(this.getX2()+dx,this.getY2()+dy);
        this.setLine(pos,newp2);
    }
    
    /**
    * Obtiene la ubicación de la línea.
    * 
    * @return La ubicación de la línea.
    */
    @Override
    public Point2D getLocation(){
        return forma.getP1(); // Devuelve el punto inicial de la línea como su ubicación
    }
    
    /**
     * Dibuja la línea en el contexto gráfico especificado.
     * 
     * @param g2d El contexto gráfico en el que se dibuja la línea.
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
        
        g2d.draw(forma);
    }
    
}
