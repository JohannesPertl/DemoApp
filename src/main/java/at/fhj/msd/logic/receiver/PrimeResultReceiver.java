package at.fhj.msd.logic.receiver;

public interface PrimeResultReceiver extends AutoCloseable {
    void startPrimeCalculation();

    void foundPrime(long number) throws PrimeOutputException;

    void endPrimeCalculation();

}
