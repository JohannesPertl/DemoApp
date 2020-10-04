package at.fhj.msd;


import at.fhj.msd.logic.BruteForcePrimeCalculator;
import at.fhj.msd.logic.receiver.ConsolePrimeResultReceiver;
import at.fhj.msd.logic.receiver.PrimeOutputException;
import at.fhj.msd.logic.receiver.PrimeResultReceiver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrimeFinderApplication {
    private static final Logger LOGGER = LogManager.getLogger(PrimeFinderApplication.class);

    private static void printUsage(){
        System.out.println("Usage: <start> <end>");

    }
    public static void main(String[] args) {
        LOGGER.info("Starting application");
        if(args.length != 2){
            printUsage();
            return;
        }

        try{
            int start = Integer.parseInt((args[0]));
            int end = Integer.parseInt((args[1]));
            BruteForcePrimeCalculator calc = new BruteForcePrimeCalculator();
            PrimeResultReceiver receiver = new ConsolePrimeResultReceiver();
            calc.findPrimes(start,end,receiver );
        }
        catch (NumberFormatException e){
            System.out.println("start and end value must be numbers");
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid input: " + e.getMessage());
            printUsage();
        }
        catch(PrimeOutputException e){
            LOGGER.error("Error while writing prime numbers",e);
            System.out.println("Error while writing to output");
        }
        catch (Exception e){
            LOGGER.error("Unspecified error",e);
            System.out.println("Unknown error");
        }



    }
}
