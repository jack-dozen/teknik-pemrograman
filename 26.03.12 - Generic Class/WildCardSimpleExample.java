// ===================================
// === No. 6 Java Generic WildCard ===
// ===================================
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Wildcard Arguments With An Unknown Type
 * @author javaguides.net
 **/
public class WildCardSimpleExample {

    public static void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("ArrayList Collection:");
        collection.add("Budi");
        collection.add("Yanti");
        collection.add("Jamal");
        printCollection(collection);

        Collection<String> collection2 = new LinkedList<>();
        collection2.add("LinkedList Collection");
        collection2.add("Pisang Ijo");
        collection2.add("Bala Bala");
        collection2.add("Cendol");
        printCollection(collection2);

        Collection<String> collection3 = new HashSet<>();
        collection3.add("HashSet Collection");
        collection3.add("Hash");
        collection3.add("Set");
        collection3.add("Collection");
        printCollection(collection3);

        Collection<Integer> collection4 = new ArrayList<>();
        collection4.add(6);
        collection4.add(7);
        collection4.add(6);
        collection4.add(7);
        printCollection(collection4);
    }
}
