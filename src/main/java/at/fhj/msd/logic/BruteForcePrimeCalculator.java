package at.fhj.msd.logic;


import at.fhj.msd.logic.receiver.PrimeOutputException;
import at.fhj.msd.logic.receiver.PrimeResultReceiver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BruteForcePrimeCalculator implements PrimeCalculator {
    private static final Logger LOGGER = LogManager.getLogger(BruteForcePrimeCalculator.class);

    public BruteForcePrimeCalculator() {
    }

    protected boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void findPrimes(int start, int end, PrimeResultReceiver writer) throws PrimeOutputException {
        if (start > end) {
            throw new IllegalArgumentException("end must be greater than start");
        }
        if (start < 1) {
            throw new IllegalArgumentException("Start value must be great than 1");
        }
        writer.startPrimeCalculation();
        for (long i = start; i <= end; i++) {
            LOGGER.debug("Checking for prime at '{}'", i);
            if (isPrime(i)) {
                LOGGER.debug("Found prime at '{}'", i);
                writer.foundPrime(i);
            }
        }
        writer.endPrimeCalculation();
    }

}
