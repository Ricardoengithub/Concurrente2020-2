package unam.ciencias.computoconcurrente;

public class App {

    private static Lector_Escritor LE = new Lector_Escritor();
    public static int DEFAULT_NUMERO_ESCRITORES = 5;
    public static int DEFAULT_NUMERO_LECTORES = 5;
    int veces = 7;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {            
            if(args.length > 1){
                        try{
                            DEFAULT_NUMERO_LECTORES = Integer.parseInt(args[0]);
                            DEFAULT_NUMERO_ESCRITORES = Integer.parseInt(args[1]);
                            System.out.println(args[0]);
                            System.out.println(args[1]);
                        } catch(NumberFormatException nfe){nfe.printStackTrace();}
            }else{
                System.out.println("Faltan datos o sobran, iniciando DEFAULT");
            }

            Lector listaLectores[] = new Lector[DEFAULT_NUMERO_LECTORES];
            Escritor listaEscritores[] = new Escritor[DEFAULT_NUMERO_ESCRITORES];

            int veces = 7;
            for(int x = 0; x < DEFAULT_NUMERO_LECTORES; x++){
                listaLectores[x] = new Lector(x+1, veces, LE);
                listaLectores[x].start();
            }

            for (int x = 0; x < DEFAULT_NUMERO_ESCRITORES; x++){
                listaEscritores[x] = new Escritor(x+1, veces, LE);                
                listaEscritores[x].start();                
            }


    }

}
