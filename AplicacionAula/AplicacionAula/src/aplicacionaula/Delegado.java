/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacionaula;

/**
 *
 * @author juanmaaf
 */
public class Delegado extends Alumno{
    
    public Delegado(String nom) {
        super(nom);
    }
    
    @Override
    public void pregunta(String pregunta){
        System.out.println(nombre+" tiene una duda como delegado:  "+pregunta);
    }
}

