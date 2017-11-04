import java.util.Arrays;
import java.util.List;

public class Stream1 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1.2","2.2","3","4","5");

        stringList.stream()
                .mapToDouble(n-> Double.parseDouble(n) )
                .filter(n-> n%2 == 0)
                .forEach(System.out::println);
    }
}