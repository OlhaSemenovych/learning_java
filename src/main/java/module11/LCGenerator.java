package module11;

public class LCGenerator {

    private long currentRandomNumber;
    private final long a;
    private long c;
    private final long m;

    public LCGenerator(long a, long c, long m, long seed) {
        currentRandomNumber = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public LCGenerator random(long c) {
        this.c = c;
        return this;
    }

    public long nextRandom() {
        currentRandomNumber = (a * currentRandomNumber + c) % m;
        return currentRandomNumber;
    }

}
