/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.ciencias.computoconcurrente;

import java.util.Random;

/**
 *
 * @author link
 */
public class Escritor extends Thread {
    int veces;
    int escritor;
    Lector_Escritor LE;
    private Random generator = new Random();

    public Escritor(int escritor, int veces, Lector_Escritor LE) {
        this.escritor=escritor;
        this.veces = veces;
        this.LE = LE;
    }
    public void run() {
        for (int i = 0; i<veces; i++) {
            try {
                Thread.sleep(generator.nextInt(500));
            } catch (java.lang.InterruptedException e) {
                System.err.println("Error en escritor");
            }
            LE.escribir(escritor);
    }
  }
}
