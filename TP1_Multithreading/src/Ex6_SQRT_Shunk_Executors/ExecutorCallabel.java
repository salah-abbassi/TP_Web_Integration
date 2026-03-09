package Ex6_SQRT_Shunk_Executors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class ExecutorCallabel {
        public static void main(String[] args) throws Exception {
            ExecutorService pool = newFixedThreadPool(5);
            int chunkSize = 10000;
            List<Future<List<String>>> futures = new ArrayList<>();

            long t0 = System.currentTimeMillis();

            for (int start = 0; start <= 50000; start += chunkSize) {
                int end = Math.min(50000, start + chunkSize - 1);
                final int s = start;
                final int e = end;
                futures.add(pool.submit(() -> {
                    List<String> lines = new ArrayList<>(e - s + 1);
                    for (int i = s; i <= e; i++) {
                        double r = Sqrt_Newtonienne.sqrt(i);
                        lines.add("sqrt(" + i + ") = " + r);
                    }
                    return lines;
                }));
            }

            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.MINUTES);


            for (Future<List<String>> f : futures) {

                List<String> lines = f.get();
                for (String line : lines) {
                    System.out.println(line);
                    }
                }

            long t1 = System.currentTimeMillis();

            System.out.println("Temps ExecutorService + Callable/Future (ms) = " + (t1 - t0));
        }
}



