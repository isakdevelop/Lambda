import java.util.Scanner;

import static com.dennis.api.enums.NavigationOfConsumer.select_consumer;
import static com.dennis.api.enums.NavigationOfFunction.select;
import static com.dennis.api.enums.NavigationOfPredicate.navigate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (navigate(sc)) {
        }
//        while(select(sc).equals("SUCCESS")) {
//            select(sc);
//        }
//        while (true) {
//            select_consumer(sc);
//        }  Consumer
    }
}
