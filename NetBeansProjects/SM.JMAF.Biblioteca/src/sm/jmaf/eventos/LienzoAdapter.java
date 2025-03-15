/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.jmaf.eventos;

/**
 * Adaptador para la interfaz LienzoListener.
 * Esta clase proporciona implementaciones vacías para los métodos definidos
 * en LienzoListener, permitiendo que las subclases sobrescriban solo los métodos
 * que les interesan.
 * 
 * @author juanmaaf
 */
public class LienzoAdapter implements LienzoListener {
    
    /**
     * Método llamado cuando se añade una nueva figura al lienzo.
     * Esta implementación está vacía y puede ser sobrescrita por subclases.
     * 
     * @param evt El evento que contiene la información de la figura añadida.
     */
    @Override
    public void shapeAdded(LienzoEvent evt) {
        // Implementación vacía, puede ser sobrescrita por subclases.
    }

    /**
     * Método llamado cuando se selecciona una figura en el lienzo.
     * Esta implementación está vacía y puede ser sobrescrita por subclases.
     * 
     * @param evt El evento que contiene la información de la figura seleccionada.
     */
    @Override
    public void shapeSelected(LienzoEvent evt) {
        // Implementación vacía, puede ser sobrescrita por subclases.
    }
}
