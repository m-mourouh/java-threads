package exercice2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int threadsNumber = 4;
        int chuckSize = nums.length / threadsNumber;

        ExecutorService pool = Executors.newFixedThreadPool(threadsNumber); //Fix pool to 4 threads
        Sommeur[] sommeurs = new Sommeur[threadsNumber];

        // create and submit tasks to threads
        for (int i = 0; i < threadsNumber; i++) {

            int start = i * chuckSize;
            int end = (i == threadsNumber - 1) ? nums.length : (i + 1) * chuckSize;

            sommeurs[i] = new Sommeur(nums, start, end);
            pool.submit(sommeurs[i]);
        }
        //Wait until all tasks have been completed
        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("An error occurred while waiting for thread completion.");
            e.printStackTrace();
        }

        // Calculate total sum
        int totalSum = 0;
        for (Sommeur sommeur : sommeurs) {
            totalSum += sommeur.getSomme();
        }

        System.out.println("The sum total of the table is : " + totalSum);
    }
}