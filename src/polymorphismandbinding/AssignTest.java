package polymorphismandbinding;

/**
 * Created by Cloud on 24/05/2015.
 */
public class AssignTest {
    public static void main(String[] args) {
        AssignTest aTest = new AssignTest();
        System.out.println(aTest.compareAndSwap(4, 4, 8));
    }

    public int compareAndSwap(Integer word, Integer testval, Integer newval) {
        Integer oldval;
        oldval = word;
        if (oldval == testval) {
            System.out.println("HERE");
            word = 9;
        }
        return oldval;
    }

    public void P(int i) {
        while (true) {

        }
    }
}
