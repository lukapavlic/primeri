package si.um.feri.napredneniti;

import java.util.concurrent.Callable;

public class Fibonacci implements Callable<Long> {

    public Fibonacci(long n) {
        this.n=n;
    }

    long n;
    
    public long izracun(long st) {
        if (st==1) return 1;
        if (st<1) return 0;
        return izracun(st-1)+izracun(st-2);
    }
    
    @Override
    public Long call() throws Exception {
        return izracun(n);
    }
  
}
