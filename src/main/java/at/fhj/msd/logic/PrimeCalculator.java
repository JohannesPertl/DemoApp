package at.fhj.msd.logic;

import at.fhj.msd.logic.receiver.PrimeOutputException;
import at.fhj.msd.logic.receiver.PrimeResultReceiver;

public interface PrimeCalculator {
    void findPrimes(int start, int end, PrimeResultReceiver writer) throws PrimeOutputException;
}
