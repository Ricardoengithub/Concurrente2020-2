package unam.ciencias.computoconcurrente;

import java.util.Arrays;

public class Graph implements Runnable{
    private int id;
    private int threads;
    private static int[] posiblesMinimos; // Arreglo para que cada hilo guarde su minimo encontrado
    private static int[] matrixGlobal; 
    private static int secciones; 


    public Graph(int id, int threads){
        this.id = id;
        this.threads = threads;
    }

    public Graph() {
        this.threads = 1;
    }

    public Graph(int threads) {
        this.threads = threads;
    }


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

  int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
        int V = dist.length;
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 

    void printSolution(int dist[], int n) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < dist.length; i++) 
            System.out.println(i + " tt " + dist[i]); 
    } 

    public int maximum(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public int diametro(int[][] graph, int src) 
    { 
        int V = graph.length;
        int dist[] = new int[V]; // The output array. dist[i] will hold 
        // the shortest distance from src to i 
  
        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[V]; 
  
        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < V; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        // Distance of source vertex from itself is always 0 
        dist[src] = 0; 
  
        // Find shortest path for all vertices 
        for (int count = 0; count < V - 1; count++) { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, sptSet); 
  
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = id; v < V; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph[u][v] != 0 &&  
                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 


        //printSolution(dist, graph.length); 
        return maximum(dist);
  
    }

    public int findDiametro(int[][] matrix, int src) throws InterruptedException{
        int[] paths = new int[matrix.length];
        for (int i = id; i < matrix.length; i++) {
            paths[i] = diametro(matrix,i);
        }
        return maximum(paths);
    }

 

    @Override
    public void run() {
        Thread[] hilos = new Thread[threads];		//crea el arreglo de hilos
		for(int i=0; i<threads; i++){				//para cada hilo a lanzar
			hilos[i] = new Thread(new Graph(i, threads));	//crea el hilo con los datos necesarios
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