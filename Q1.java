import java.util.Arrays;
import java.util.Random;

public class ArraySumParallelSerial {
    public static void main(String[] args) {
        // Initialize the array with some values
        double[] arr = new double[5];
        Arrays.fill(arr, 1.0);

        // Multiply every value in the array with a random value between 0.1 and 0.9
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= rand.nextDouble() * 0.8 + 0.1;
            // System.out.println(i + " -> " + arr[i]);
        }

        // Calculate the sum of the array in serial
        long startSerial = System.currentTimeMillis();
        double sumSerial = Arrays.stream(arr).sum();
        long endSerial = System.currentTimeMillis();
        long serialTime = endSerial - startSerial;

        // Calculate the sum of the array in parallel
        long startParallel = System.currentTimeMillis();
        double sumParallel = Arrays.stream(arr).parallel().sum();
        long endParallel = System.currentTimeMillis();
        long parallelTime = endParallel - startParallel;

        // Print the results
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sum in serial: " + sumSerial);
        System.out.println("Sum in parallel: " + sumParallel);
        System.out.println("Time difference: " + (parallelTime - serialTime) + " ms");
        System.out.println("Conclusion: Sum in " + (parallelTime <= serialTime ? "Parallel" : "Serial") + " cost less time.");
    }
}


