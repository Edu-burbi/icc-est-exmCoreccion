package Controllers;

import Models.Persona;

/**
 * Controlador para manejar la lógica de operaciones sobre arrays de Carross.
 * 
 * 
 * Generar los metdoos necesarions para ordenar un array de personas por edad en
 * orden descendente
 * y para la busqueda binaria de una persona por edad.
 * 
 */




public class PersonaController {
    public void ordenarEdades(Persona[] personas){
        for (int i = 0 ; i < personas.length; i++){
            int maxIndex = i;
            for (int j = i + 1 ; j < personas.length ; j++){
                if(personas[j].getEdad() > personas[maxIndex].getEdad()){
                    maxIndex = j;   
                }
            }
            Persona temp = personas[i];
            personas[i] = personas[maxIndex];
            personas[maxIndex] = temp;
        }
    }




    public int buscarEdadesBinaria(Persona[] personas, int edad){
        int inicio = 0;
        int fin = personas.length -1;

        while(inicio <= fin){
            int medio = (inicio + fin) / 2;
            if(personas[medio].getEdad() == edad){
                return medio;
            }else if (personas[medio].getEdad() < edad) {
                fin = medio -1;
            }else{
                inicio = medio + 1;
            }
        }
        return -1;
    }




    public void ordenarNombre(Persona[] personas){
        for (int i = 0 ; i < personas.length ; i++){
            Persona key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getNombre().compareTo(key.getNombre()) > 0) {
                personas[j + 1] = personas[j];
                j --;
            }
            personas[j + 1] = key;
        }
    }




    public int busquedaBinariaPorNombre(Persona[] personas, String nombre){
        int inicio = 0;
        int fin = personas.length -1;
        while(inicio <= fin){
            int medio = (inicio + fin)/2;
            int comparacion = personas[medio].getNombre().compareTo(nombre);
            if(comparacion == 0){
                return medio;                
            }else if (comparacion > 0){
                fin = medio - 1; 
            }else{
                inicio = medio + 1;
            }
        }
        return -1;
    }
}