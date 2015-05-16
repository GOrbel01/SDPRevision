package javatests.lambdas;

/**
 * Created by Cloud on 15/05/2015.
 */
public class LambdaTest {
    public static void main(String[] args) {
        FuncTest isEven = ((n) -> n % 2 == 0);
        FuncTest isOdd = (n) -> n % 2 == 1;

        NumFunc factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };

        StringFunc first2Last2 = (a, b) -> {
            String one;
            String two;
            if (a.length() >= 2) {
                one = a.charAt(0) + "" + a.charAt(1);
            }
            else {
                one = a;
            }
            if (b.length() >= 2) {
                two = b.charAt(b.length()-2) + "" + b.charAt(b.length()-1);
            }
            else {
                two = b;
            }
            return one + two;
        };

        int num1 = 4;
        int num2 = 5;

        System.out.println(isEven.numTest(num1));
        System.out.println(isEven.numTest(num2));
        System.out.println(isOdd.numTest(num1));
        System.out.println(isOdd.numTest(num2));
        System.out.println(factorial.func(5));
        System.out.println(first2Last2.func("Able", "Willing"));
        String s1 = testLambdaParam(first2Last2, "Jazz", "Pack");
        System.out.println(s1);
        System.out.println(testLambdaReturn().func("Pie", "tiful"));
    }

    public static String testLambdaParam(StringFunc fc, String s1, String s2) {
        return fc.func(s1, s2);
    }

    public static StringFunc testLambdaReturn() {
        return (s1, s2) -> s1.replaceFirst("e", s2);
    }
}
