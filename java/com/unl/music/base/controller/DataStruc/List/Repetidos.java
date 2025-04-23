package com.unl.music.base.controller.DataStruc.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.unl.music.base.controller.DataStruc.List.Linkendlist;
import com.unl.music.base.controller.excepcion.ListEmptyException;

public class Repetidos {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Linkendlist<String> lista = new Linkendlist<>();
        HashMap<String, Integer> contador = new HashMap<>();
        int totalRepetidos = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
                contador.put(linea, contador.getOrDefault(linea, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        for (int repeticiones : contador.values()) {
            if (repeticiones > 1) {
                totalRepetidos += repeticiones;
            }
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Cantidad total de elementos repetidos: " + totalRepetidos);
        System.out.println("Duración: " + endTime + " milisegundos.");
    }
}
