package unam.ciencias.computoconcurrente;

public class MultMatrix implements Runnable{
    private int id;
    private int threads;
    private static int[] posiblesMinimos; // Arreglo para que cada hilo guarde su minimo encontrado
    private static int[] matrixGlobal; 
    private static int secciones; 


    public MultMatrix(int id, int threads){
        this.id = id;
        this.threads = threads;
    }

    public MultMatrix() {
        this.threads = 1;
    }

    public MultMatrix(int threads) {
        this.threads = threads;
    }


    // public double findAverage(int[][] matrix) throws InterruptedException{
    //     int suma_parcial = 0;
    //     int contador = 0;
    //     for (int i = id; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix.length; j++) {
    //             suma_parcial+=matrix[i][j];
    //             contador++;
    //             System.out.print(contador);
    //         }
    //     }
    //     System.out.print(contador);
    //     return (float) suma_parcial/contador;       
    // }

    public int[][] multiplica(int[][] matrix1, int[][] matrix2){
        int[][] c = new int[matrix1.length][matrix2[0].length];

        for (int i = id; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    // aquí se multiplica la matriz
                    c[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return c;
    }

    @Override
    public void run() {
        Thread[] hilos = new Thread[threads];		//crea el arreglo de hilos
		for(int i=0; i<threads; i++){				//para cada hilo a lanzar
			hilos[i] = new Thread(new MultMatrix(i, threads));	//crea el hilo con los datos necesarios
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