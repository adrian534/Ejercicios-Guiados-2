package cola;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cola<String> tareas = new Cola<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU DE  TAREAS =====");
            System.out.println("1. Crear y agregar tareas iniciales");
            System.out.println("2. Solicitar tamaño de la cola");
            System.out.println("3. Consultar frente de la cola");
            System.out.println("4. Quitar tarea 1 y mostrar tarea ejecutada");
            System.out.println("5. Quitar tarea 2 y mostrar tarea ejecutada");
            System.out.println("6. Mostrar estado final de la cola");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    
                    tareas.insertar("Preparar café");
                    tareas.insertar("Revisar emails");
                    tareas.insertar("Iniciar proyecto");
                    break;

                case 2:
                    System.out.println(" Tamaño actual de la cola: " + tareas.getTamano());
                    break;

                case 3:
                    String frente = tareas.frente();
                    if (frente != null)
                        System.out.println(" Frente de la cola: " + frente);
                    break;

                case 4:
                    tareas.quitar();
                    break;

                case 5:
                    tareas.quitar();
                    break;

                case 6:
                    tareas.frente();
                    break;

                case 0:
                    System.out.println(" Saliendo del programa...");
                    break;

                default:
                    System.out.println(" Opción invalida. Intente nuevamente.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
   

package cola;

/**
 *
 * @author gaell
 */
public class Cola <T>{
    private Nodo <T> cabeza;
    private Nodo <T> cola;
    private int tamaño;
    
    public Cola (){
    this.cabeza= null;
    this.cola = null;
    this.tamaño= 0;}

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public Nodo<T> getCola() {
        return cola;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void setCola(Nodo<T> cola) {
        this.cola = cola;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
   public boolean colaVacia (){
   return cabeza ==null;
   } 
    public void insertar(T elemento) {
    Nodo<T> nuevoNodo = new Nodo<>(elemento);
    
    if (colaVacia()) { // Caso 1: La cola está vacía
        cabeza = nuevoNodo;
        cola = nuevoNodo;
    } else { // Caso 2: La cola NO está vacía
        // El nodo actual que era el 'final' ahora apunta al nuevo nodo
        this.cola.setSiguiente(nuevoNodo);
        // El puntero 'cola' (final) se mueve al nuevo nodo
        this.cola = nuevoNodo;
    }
    
    tamaño++; //Incrementar Tamaño
    System.out.println("-> Insertado: " + elemento);
}
    public T quitar() {
    if (colaVacia()) {
        System.out.println("Error: La cola está vacía.");
        return null;
    }
    
    T datoQuitado = this.cabeza.getDato(); // Guardamos el dato a devolver
    
    this.cabeza = this.cabeza.getSiguiente(); // Cabeza siguiente nodo
    
    if (this.cabeza == null) { // Actualiza si no hay elementos
        this.cola = null;
    }
    
    tamaño--;
    return datoQuitado;
}
  /*  
 * Operation: Frente (Peek)  
 * Devuelve el elemento del FRENTE sin retirarlo.  
 */
public T frente() {  
    if (colaVacia()) {  
        System.out.println("Error: La cola está vacía");  
        return null;
    }  
    return this.cabeza.getDato();  
}
// Método auxiliar para ver el tamaño
// (aunque no sea una operación base del TAD)
public int getTamano() {
    return tamaño;
}
  
}

package cola;

/**
 *
 * @author joel adrian caballero lugo 
 * 24/10/2025
 * paso 1 crear nodo
 */
public class Nodo <T> {
    private T dato;
    private Nodo siguiente;
    
    public Nodo (T data){
    dato = data; 
    siguiente = null;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }
    
}