/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.jmaf.eventos;

import java.awt.Shape;
import java.util.EventObject;
import sm.jmaf.graficos.MiShape;

/**
 * Evento personalizado para representar acciones en el lienzo,
 * como la adición o selección de figuras.
 * 
 * Esta clase extiende de EventObject y encapsula información
 * sobre la figura que ha generado el evento.
 * 
 * @see java.util.EventObject
 * @see MiShape
 * 
 * @author juanmaaf
 */
public class LienzoEvent extends EventObject {
    private MiShape forma;

    /**
     * Crea un nuevo evento de lienzo.
     * 
     * @param source El objeto que ha generado el evento.
     * @param forma La figura asociada con el evento.
     */
    public LienzoEvent(Object source, MiShape forma) {
        super(source);
        this.forma = forma;
    }

    /**
     * Obtiene la figura asociada con el evento.
     * 
     * @return La figura asociada con el evento.
     */
    public MiShape getForma() {
        return forma;
    }
}
