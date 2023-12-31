import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Albergue {
    /**
     * Lista que contiene todos los animales que se encuentran refugiados
     */
    private List<Animal> animalesRescatados;
    /**
     * Capacidad maxima del albergue
     */
    private static final int CAPACIDAD_ALBERGUE = 40;



    public Albergue(){
        // Crea el arreglo de animales y lo inicializa
        animalesRescatados = new ArrayList<>();
    }
    public void agregarAnimal(Animal animal) {
        if (hayEspacioDisponible()) {
            animalesRescatados.add(animal);
            JOptionPane.showMessageDialog(null,"Animal agregado al albergue: " + animal.getNombreAnimal());
        } else {
            JOptionPane.showMessageDialog(null,"No hay espacio disponible en el albergue.");
        }
    }
    public void adoptarAnimal(Animal animal) {
        if (animalesRescatados.remove(animal)) {
            JOptionPane.showMessageDialog(null,"Animal eliminado del albergue: " + animal.getNombreAnimal());
        } else {
            JOptionPane.showMessageDialog(null,"El animal no se encuentra en el albergue.");
        }
    }

    public List<Animal> getListaAnimalesRescatados(){
        return animalesRescatados;
    }

    /**
     * Indica si el albergue esta lleno.
     */
    public boolean hayEspacioDisponible() {
        return animalesRescatados.size() < CAPACIDAD_ALBERGUE;
    }
    public Animal buscarAnimal(String pID){
        Animal animalBuscado = null;

        boolean encontre = false;
        int animales = animalesRescatados.size( );
        for( int i = 0; i < animales && !encontre; i++ )
        {
            Animal a = animalesRescatados.get( i );
            if( a.getId().equals( pID ) )
            {
                animalBuscado= a;
                encontre = true;
            }
        }
        return animalBuscado;
    }
}
