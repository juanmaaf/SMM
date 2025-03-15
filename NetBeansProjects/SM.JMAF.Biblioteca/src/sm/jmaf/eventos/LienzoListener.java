/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sm.jmaf.eventos;

import java.util.EventListener;

/**
 * Interfaz para notificar eventos relacionados con figuras en un lienzo.
 * 
 * Esta interfaz define métodos para manejar la adición y selección de figuras en un lienzo.
 * Las clases que deseen recibir notificaciones sobre estos eventos deben implementar esta interfaz.
 * 
 * @see LienzoEvent
 * @see java.util.EventListener
 * @author juanmaaf
 */
public interface LienzoListener extends EventListener {
    
    /**
     * Método llamado cuando se añade una nueva figura al lienzo.
     * 
     * @param evt El evento que contiene información sobre la figura añadida.
     */
    public void shapeAdded(LienzoEvent evt);

    /**
     * Método llamado cuando se selecciona una figura en el lienzo.
     * 
     * @param evt El evento que contiene información sobre la figura seleccionada.
     */
    public void shapeSelected(LienzoEvent evt);
}
