package at.fhj.msd;

import at.fhj.msd.logic.BruteForcePrimeCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BruteForcePrimeCalculatorMock extends BruteForcePrimeCalculator {
    @Override
    protected boolean isPrime(long n) {
        return super.isPrime(n);
    }
}

public class BruteForcePrimeCalculatorTest {

    private BruteForcePrimeCalculatorMock mockCalculator = new BruteForcePrimeCalculatorMock();

    private long[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151,
            157, 163, 167, 173, 179, 181, 191, 193, 197, 199
    };

    private long[] notPrimes = {
            4, 6, 8, 12, 14, 18, 20, 24, 30, 32, 38, 42, 44, 48, 54, 60,
            62, 68, 72, 74, 80, 84, 90, 98, 102, 104, 108, 110, 114, 128, 132, 138, 140,
            150, 152, 158, 164, 168, 174, 180, 182, 192, 194, 198, 200
    };

    private long[] notPrimesNegative = {-10, -9, -8, -7, -6, -5, -4, -3, -2};

    @Test
    void isPrimeShouldBeTrue() {
        for (long prime : primes) {
            boolean isPrime = mockCalculator.isPrime(prime);
            Assertions.assertTrue(isPrime);
        }
    }

    @Test
    void isPrimeShouldBeFalse() {
        for (long notPrime : notPrimes) {
            boolean isPrime = mockCalculator.isPrime(notPrime);
            Assertions.assertFalse(isPrime);
        }
    }

    @Test
    void isNegativeNumberPrimeShouldBeFalse() {
        for (long notPrime : notPrimesNegative) {
            boolean isPrime = mockCalculator.isPrime(notPrime);
            Assertions.assertFalse(isPrime);
        }
    }

    @Test
    void is1PrimeShouldBeFalse() {
        boolean isPrime = mockCalculator.isPrime(1);
        Assertions.assertFalse(isPrime);
    }
}
