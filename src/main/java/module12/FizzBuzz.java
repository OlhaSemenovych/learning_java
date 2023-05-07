package module12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private final int n;
    private final AtomicInteger counter;

    public FizzBuzz(int n) {
        this.n = n;
        this.counter = new AtomicInteger(1);
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (counter.get() <= n) {
            if (counter.get() % 3 == 0 && counter.get() % 5 != 0) {
                printFizz.run();
                counter.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (counter.get() <= n) {
            if (counter.get() % 3 != 0 && counter.get() % 5 == 0) {
                printBuzz.run();
                counter.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzBuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (counter.get() <= n) {
            if (counter.get() % 3 == 0 && counter.get() % 5 == 0) {
                printFizzBuzz.run();
                counter.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (counter.get() <= n) {
            if (counter.get() % 3 != 0 && counter.get() % 5 != 0) {
                printNumber.accept(counter.get());
                counter.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }

}