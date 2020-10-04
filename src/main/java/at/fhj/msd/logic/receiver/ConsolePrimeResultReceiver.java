package at.fhj.msd.logic.receiver;

public class ConsolePrimeResultReceiver extends AbstractPrimeResultReceiver {


    public ConsolePrimeResultReceiver(){}

    @Override
    public void startPrimeCalculation() {
        super.startPrimeCalculation();
        System.out.println("==== Finding primes ====");
    }

    @Override
    public void foundPrime(long number) throws PrimeOutputException {
        super.foundPrime(number);
        System.out.println("> Found " + number);
    }

    @Override
    public void endPrimeCalculation() {
        float time = stopClock();
        System.out.printf("==== Found: %d primes in %f ms === ",getCount(),time);
    }

    @Override
    public void close() throws Exception {

    }
}
