package algorithms.general;

import java.util.stream.IntStream;

/**
 * Created by anurag on 04/11/17.
 */
public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrimeFunctional(1));
        System.out.println(isPrimeFunctional(2));
        System.out.println(isPrimeFunctional(5));
        System.out.println(isPrimeFunctional(13));
        System.out.println(isPrimeFunctional(53));
        System.out.println(isPrimeFunctional(75));

    }

    private static boolean isPrime(final int number){
        for(int i = 2; i < number; i++ ){
            if (number % i == 0){
                return false;
            }
        }
        return (number > 1);
    }

    private static boolean isPrimeFunctional(final int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

}
