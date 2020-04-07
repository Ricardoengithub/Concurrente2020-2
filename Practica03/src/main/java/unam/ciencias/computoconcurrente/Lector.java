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
public class Lector extends Thread{
    int veces;
    int lector;
    Lector_Escritor LE;
    private Random generator = new Random();

    public Lector(int lector, int veces, Lector_Escritor LE) {
        this.veces = veces;
        this.lector= lector;
        this.LE = LE;
    }
    public void run() {
        for (int i = 0; i<veces; i++) {
	try {
            Thread.sleep(generator.nextInt(500));
        }catch (java.lang.InterruptedException e) {
            System.err.println("Error en lector");
        }
        LE.leer(lector);
    }
  }
    
}
