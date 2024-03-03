package exercice1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        //Generate 10 threads
        for(int i = 1; i <= 10; i++){
            threads.add(new Thread((new Talkative(i))));
        }

        threads.forEach(Thread::start);
    }
}
