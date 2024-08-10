import java.util.ArrayList;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String a[]) {

        Stream.of("A", "B", "C")
                .map(String::toLowerCase)
                .forEach((System.out::print));

        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("---------");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
