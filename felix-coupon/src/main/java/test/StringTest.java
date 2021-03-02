package test;

/**
 * @ClassName StringTest
 * @Description TODO
 * @Author yeyifei
 * @Date 2020/11/14 1:23 PM
 * @Version 1.0
 **/
public class StringTest {
    // Concatenates to String
    public static void concat1(String s1)
    {
        s1 = s1 + "forgeeks";
        System.out.println("innerString:"+s1);
    }

    public static void main(String[] args) {
        System.out.println( Runtime.getRuntime().availableProcessors());
        String s1 = "Geeks";
        concat1(s1);  // s1 is not changed
        System.out.println("String: " + s1);

        String s2 = "Hello";
        s2 = s2 + "world";
        System.out.println("s2="+s2);
    }
}
