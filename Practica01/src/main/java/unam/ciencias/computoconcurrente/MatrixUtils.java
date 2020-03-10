package unam.ciencias.computoconcurrente;

public class MatrixUtils implements Runnable{
    private int id;
    private int threads;
    private static int[] posiblesMinimos; // Arreglo para que cada hilo guarde su minimo encontrado
    private static int[] matrixGlobal; 
    private static int secciones; 


    public MatrixUtils(int id, int threads){
        this.id = id;
        this.threads = threads;
    }

    public MatrixUtils() {
        this.threads = 1;
    }

    public MatrixUtils(int threads) {
        this.threads = threads;
    }


    public double findAverage(int[][] matrix) throws InterruptedException{
        int suma_parcial = 0;
        int contador = 0;
        for (int i = id; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                suma_parcial+=matrix[i][j];
                contador++;
                System.out.print(contador);
            }
        }
        System.out.print(contador);
        return (float) suma_parcial/contador;

       
    }

    /**
     * Metodo que recorre una matriz de dos dimensiones 
     * @param matrix - matriz de dos dimensiones 
     * @return promedio - promedio de la matriz
     */
    public double Average(int[][] matrix){

        int suma = 0;
        for (int i = id; i < matrix.length; i++) {
            suma+= 1;
        }
        return 1.0;
}


    @Override
    public void run() {
        Thread[] hilos = new Thread[threads];		//crea el arreglo de hilos
		for(int i=0; i<threads; i++){				//para cada hilo a lanzar
			hilos[i] = new Thread(new MatrixUtils(i, threads));	//crea el hilo con los datos necesarios
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
