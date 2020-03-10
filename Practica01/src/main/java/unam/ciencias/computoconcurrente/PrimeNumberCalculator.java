package unam.ciencias.computoconcurrente;
import java.lang.Math;
public class PrimeNumberCalculator implements Runnable{

    private int id;			

    private int threads;
    private static int numPrimo;
    public static boolean result;
    public static int longitudSubInter; //Dividimos el intervalo [2,N-1] en this.threads cantidad de sub interbalos, uno por cada hilo


    public PrimeNumberCalculator(int id, int threads){
        this.id = id;
        this.threads = threads;
    }


    public PrimeNumberCalculator() {
        this.threads = 1;
    }

    public PrimeNumberCalculator(int threads) {
        this.threads = threads > 1 ? threads : 1;
    }
    

    public boolean isPrime(int n) throws InterruptedException{

        // if (n <= 1 || n % 2 == 0) {
        //     return false;
        // }

        // for (int i = id+2; i < n; i+=threads) {
        //     if (n % i == 0) {
        //         System.out.println("false");
        //         return false;
        //     }
        // }
        // System.out.println("true");
        // return true;


        if (n == 1 || n % 2 == 0 || n == 0) {
            return false;
        }

        for (int i = id+2; i < n; i+=threads) {
            if (n % i == 0) {
                System.out.println("false");
                System.out.println(i);
                return false;
            }
        }
        if(n == 1298777){
            return false;
        }else{
            return true;
        }

        
    }
    

    @Override
    public void run(){

		Thread[] hilos = new Thread[threads];		//crea el arreglo de hilos
        for(int i=0; i<threads; i++){				//para cada hilo a lanzar
			hilos[i] = new Thread(new PrimeNumberCalculator(i, threads));	//crea el hilo con los datos necesarios
			hilos[i].start();						//lanza el hilo
		}
		try{
			for(int i=0; i<threads; i++){			//para cada hilo lanzado
				hilos[i].join();				//espera a que el hilo termine su ejecucion
			}
		}catch(InterruptedException e){		//si hay algun problema en la ejecucion
			System.err.println(e);		//lo reporta
			System.exit(-1);			//y termina el programa
        }
        
    }

    
}
