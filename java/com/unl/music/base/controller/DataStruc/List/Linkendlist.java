package com.unl.music.base.controller.DataStruc.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.checkerframework.checker.units.qual.t;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.unl.music.base.controller.excepcion.ListEmptyException;

public class Linkendlist<E> {
    private Node<E> head;
    private Node<E> last;
    private Integer length;

    // getter and setter
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer lenth) {
        this.length = lenth;
    }

    public Linkendlist() {
        this.head = null;
        this.last = null;
        this.length = 0;
    }

    public Boolean isEmpty() {
        return head == null || length == 0;
    }

    private Node<E> getNode(Integer pos) throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Indice Fuera de rango");
            // System.out.println("lista vacia");
            // return null;
        } else if (pos < 0 || pos >= length) {
            throw new ListEmptyException("Indice Fuera de rango");
            // System.out.println("Fuera de rango");
            // return null;
        } else if (pos == 0) {
            return head;
        } else if ((length.intValue() - 1) == pos.intValue()) {
            return last;
        } else {
            Node<E> search = head;
            Integer cont = 0;
            while (cont < pos) {
                search = search.getNext();
                cont++;
            }
            return search;
        }
    }


    public E get(Integer pos) throws ListEmptyException {
        return getNode(pos).getData();
    }

    private void addFirst(E data) {
        if (isEmpty()) {
            Node<E> aux = new Node<>(data);
            head = aux;
            last = aux;
            length++;
        } else {
            Node<E> head_old = head;
            Node<E> aux = new Node<>(data, head_old);
            head = aux;

        }
        length++;
    }

    private void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node<E> aux = new Node<>(data);
            last.setNext(aux);
            last = aux;
            length++;
        }
    }

    public void add(E data, Integer pos) throws ListEmptyException {
        if (pos == 0) {
            addFirst(data);
        } else if (length.intValue() == pos.intValue()) {
            addLast(data);
        } else {
            Node<E> search_preview = getNode(pos - 1);
            Node<E> search = getNode(pos);
            Node<E> aux = new Node<>(data, search);
            search_preview.setNext(aux);
            length++;
        }
    }

    public void add(E data) {
        addLast(data);
    }

    


/*public static int contarLineas(String nombreArchivo) {
int contador = 0;
try (BufferedReader br = new BufferedReader(new
FileReader(nombreArchivo))) {
while (br.readLine() != null) {
contador++;
}
} catch (IOException e) {
System.out.println("Error al contar líneas del archivo: " +
e.getMessage());
}
return contador;
}


public static int[] leerArchivo(String nombreArchivo) {
int cantidadNumeros = contarLineas(nombreArchivo);
int[] numeros = new int[cantidadNumeros];
try (BufferedReader br = new BufferedReader(new
FileReader(nombreArchivo))) {
String linea;
int i = 0;
while ((linea = br.readLine()) != null && i < cantidadNumeros) {
numeros[i++] = Integer.parseInt(linea.trim());
}
} catch (IOException e) {
System.out.println("Error al leer el archivo: " +
e.getMessage());
}
return numeros;
}

public static boolean esPrimo(int numero) {
    if (numero < 2) return false;
    for (int i = 2; i <= Math.sqrt(numero); i++) {
    if (numero % i == 0) return false;
    }
    return true;
    }
    public static int[] obtenerPrimos(int[] numeros) {
    // Primero contar cuántos primos hay
    int contador = 0;
    for (int num : numeros) {
    if (esPrimo(num)) {
    contador++;
    }
    }
    // Crear arreglo del tamaño exacto
    int[] primos = new int[contador];
    int index = 0;
    for (int num : numeros) {
    if (esPrimo(num)) {
    primos[index++] = num;
    }
    }
    return primos;
    }

        public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] numeros = Primos.leerArchivo("data.txt");
int[] primos = Primos.obtenerPrimos(numeros);
System.out.println("Primos encontrados:");
for (int primo : primos) {
System.out.println(primo);
}
long endTime = System.currentTimeMillis() - startTime;
System.out.println("Cantidad de números primos encontrados: " +
primos.length);
System.out.println("Duración: " + endTime + " milisegundos.");

}*/

  /*public static void main(String[] args) throws ListEmptyException {
        Linkendlist<Double> lista = new Linkendlist<>();
        try {
            System.out.println("Hola");
            // lista.update(10.00, 0);

            lista.add(56.7);
            lista.add(65.7);
            lista.add(1.0, 0);
            lista.add(4.7);
            // System.out.println(lista.print());
            lista.add(9.0, 3);
            System.out.println(lista.print());
            System.out.println(lista.get(lista.getLength()-1));
            System.out.println("Actualizar");
            lista.update(10.00, 3);
            System.out.println(lista.print());

        } catch (Exception e) {
            System.out.println("Error: " + e);
            // TODO: handle exception
        }
        System.out.println(lista.print());
        System.out.println("Final");
    }
*/


}
