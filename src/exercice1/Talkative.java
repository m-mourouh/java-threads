package exercice1;

public class Talkative implements  Runnable{

    private int n;


    public Talkative(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            System.out.println("Thread " + n + ": " + i);
        };
            System.out.println("Thead " + n + " finished");
    }
}
