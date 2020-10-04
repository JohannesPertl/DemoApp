package at.fhj.msd.logic.receiver;

public abstract class AbstractPrimeResultReceiver implements PrimeResultReceiver {
    private long time =0;
    private long count = 0;

    public AbstractPrimeResultReceiver(){ }

    protected boolean isRunning(){
        return time > 0;
    }
    protected void startClock(){
        time = System.nanoTime();
    }

    @Override
    public void foundPrime(long number) throws PrimeOutputException {
        count++;
    }

    protected long getCount() {
        return count;
    }

    @Override
    public void startPrimeCalculation() {
        if(isRunning()){
            throw new IllegalStateException("Writer is currently being used");
        }
        startClock();
    }

    protected float stopClock(){
        float ms = (System.nanoTime() - time)/1_000_000;
        time = 0;
        return ms;
    }

}
