package Tmp;

import java.util.List;

public class Test1 {
    public static String ROUTINGKEY_EMAIL = "Inform.#.email.#";
    public static String ROUTINGKEY_SMS = "Inform.#.sms.#";
    /**
     * 当发送 Inform.email 只匹配 ROUTINGKEY_EMAIL
     * 当发送 Inform.sms 只匹配 ROUTINGKEY_SMS
     * 当发送 Inform.email.sms 或者 Inform.sms.email ROUTINGKEY_EMAIL和 ROUTINGKEY_SMS 都能匹配到
     */

    public static void main(String[] args) {
        System.out.println("执行后的结果为 ： " + dowork());
    }
    public static int dowork(){
        try {
            int i=10/0; //会抛出异常
             System.out.println("i=" + i);
        } catch (ArithmeticException e) { //捕获异常捕获ArithmeticException
            System.out.println("ArithmeticException: " + e);
            return 0;
        }catch (Exception e) {//捕获Exceptior
             System.out.println("Exception: " + e);
             return 1;
        } finally {
            System.out.println("Finally");
            return 2;
        }
    }

    /**   输出结果
     *
     * ArithmeticException: java.lang.ArithmeticException: / by zero
     * Finally
     * 执行后的结果为 ： 2
     */


}
