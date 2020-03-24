package unam.ciencias.computoconcurrente;

import java.util.Random;
/**
 *  Cada filósofo se ejecuta en un hilo.
 */
public class Filosofo implements Runnable {
    public static int DEFAULT_TABLE_SIZE = 5;

    protected int id;

    
	private long tiempoPensar; // el tiempo que estará pensando
	private long tiempoComer; // el tiempo que estará comiendo
	private DiningServer ds;
	private  Random random;

    public boolean comio;
	
	public Filosofo(int id, long tiempoPensar, long tiempoComer, DiningServer ds) {
	    this.id = id;
	    this.tiempoPensar = tiempoPensar;
	    this.tiempoComer = tiempoComer;
	    this.ds = ds;
	    this.random = new Random();
        this.comio = false;
	    System.out.printf("Este es el filosofo %d.\n", this.id);
	    new Thread(this).start();
	}

	/**
	 * el filósofo piensa y su hilo se bloquea durante el tiempo que piense 
	 */
	private void piensa() {
	    // no ver la siguiente linea
	    long tiempoPensando = ((long) (random.nextInt((int)tiempoPensar)/10));
	    System.out.printf("Tiempo: %d, el filósofo %d está pensando por %d ms \n",
			      System.currentTimeMillis(), this.id, tiempoPensando);
	    try {
		Thread.sleep(tiempoPensando);
	    } catch(InterruptedException ie) {ie.printStackTrace();}
	}

	/**
	 * el filósofo come y su hilo se bloquea durante el tiempo que coma
	 */
	private void come() {
	    long tiempoComiendo = ((long) (random.nextInt((int)tiempoComer))/10);
	    System.out.printf("Tiempo: %d, el filósofo %d está comiendo por %d ms \n",
			      System.currentTimeMillis(), this.id, tiempoComiendo);
                  this.comio = true;
	    try {
		Thread.sleep(tiempoComiendo);
	    } catch(InterruptedException ie) {ie.printStackTrace();}
	}

    public boolean comio(){
        if(this.comio == true){
            return true;
        }else{
            return false;
        }
    }


    @Override
	public void run() {
	    while (true) {
		this.piensa();
		System.out.printf("Tiempo: %d, el filósofo %d quiere comer \n",System.currentTimeMillis(),id);
		ds.tomaTenedor(this.id); // intenta tomar los tenedores
		this.come(); //si logra tomarlos, come
		ds.regresaTenedor(this.id); // devuelve los tenedores después de comer
	    }
	}
}