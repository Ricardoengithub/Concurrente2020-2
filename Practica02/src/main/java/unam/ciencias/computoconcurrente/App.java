package unam.ciencias.computoconcurrente;

import java.util.Random;

public class App {

    public static void main(String[] args) throws InterruptedException {
        int numFilos = 5;
        int runTime = 200000; // número arbitrario

        boolean comieron = false;
        if (args.length > 0){
            try{
            runTime = Integer.parseInt(args[0]);
            if (runTime <= 0) {
                runTime = 200000;
            }
            } catch(NumberFormatException nfe){nfe.printStackTrace();}
        } 

        if(args.length > 1){
                    try{
                        numFilos = Integer.parseInt(args[1]);
                    } catch(NumberFormatException nfe){nfe.printStackTrace();}
        }

        System.out.printf("Filósofos llegando a la cena: %d\n", numFilos);
        Random random = new Random(runTime);
        long tiempoPensando  = (long) (Math.random() * runTime); // el tiempo para pensar de cada filósofo
        long tiempoComiendo = (long) (Math.random() * runTime); // el tiempo para comer de cada filósofo

        DiningServer ds = new DiningServer(numFilos);

        Filosofo estadoFilosofo[] = new Filosofo[numFilos];


        for (int x = 0; x < numFilos; x++)
            estadoFilosofo[x] = new Filosofo(x, tiempoPensando, tiempoComiendo, ds);
        System.out.println("Todos los filósofos se han sentado en la mesa");


        while(comieron == false){
            System.out.print("");
            for(int i = 0; i < numFilos; i++){
                if(estadoFilosofo[i].comio() == false){
                    break;
                }
                if(estadoFilosofo[i].comio() == true && i == numFilos-1){
                    System.out.println("++++++++++++++++");
                    System.out.println("Ya comieron todos");
                    System.out.println("++++++++++++++++");
                    comieron = true;
                }
            }
        }
              
    }
}
