package exercice2;

public class Sommeur implements Runnable{
    private int[] t;
    private int start;
    private int end;
    private int somme;

    public Sommeur(int[] t, int start, int end) {
        this.t = t;
        this.start = start;
        this.end = end;
        this.somme = 0;
    }

    public int getSomme(){
        return this.somme;
    }
    @Override
    public void run() {
        for(int i = start; i < end; i++){
            try {
                this.somme += this.t[i];
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
    }
}
