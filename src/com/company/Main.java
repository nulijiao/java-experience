package com.company;
import java.sql.SQLOutput;
import java.util.*;


/**
 *
 */

public class Main {
    private String a = "eee";

    public void say(int a, int...b) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hell" + 'o';

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        Main e = new Main();
        e.say(1, 2, 3);
        System.out.println(e.a);
        for(int i : b) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
	// write your code here8
        Scanner scan = new Scanner(System.in);
        final Object a = new Object();
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hell" + 'o';

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);

        System.out.println(a);

        // Read a full line of input from stdin and save it to our variable, inputString.
        String inputString = scan.nextLine();
        // reverse此方法返回StringBuffer對象的顛倒順序
        String reverse = new StringBuffer(inputString).reverse().toString();

        System.out.println(inputString.equals(reverse));


    }
}


