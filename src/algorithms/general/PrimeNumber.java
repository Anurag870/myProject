package algorithms.general;

import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Stack;


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



    static String find_phone_number(String text) {
        //Pattern pattern = Pattern.compile("^[1-9]\d{3}-\d{3}-\d{4}");
        //Matcher matcher = pattern.matcher(text);
        return "";

    }


    /*
     * Complete the function below.
     */
    static String solution(int[] array) {
        ArrayList<String> s = new ArrayList<String>();
        String toAdd = "";
        for (int i = 0; i < array.length; i++) {
            int len = 0;
            int j;
            int start = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] == array[start] + 1) {
                    len++;
                    start++;
                } else{
                    break;
                }

            }

            if (len >= 2) {
                toAdd = Integer.toString(array[i]) + "-" + array[j - 1];
                i = j - 1;
            } else {
                toAdd = Integer.toString(array[i]);
            }
            s.add(toAdd);
        }
        String sCompacted = String.join(",", s);
        return sCompacted;

    }

}