package com.company;

import java.util.*;

public class Hash {
    /*
    * hashMap  内置的数据结构key->value具有O1的时间复杂度这也是Java内置的数据结构
    *
    * */
    public static void getKuohao(String kuohao) {
        String[] arr = kuohao.split("");
        Stack<String> st = new Stack<String>();
        for (String s : arr) {
            if(!s.equals("(") && !s.equals("[") && !s.equals(")") && !s.equals("]") && !s.equals("{") && !s.equals("}")){
                System.out.println("输入有误，请输入括号字符");
                return;
            }

            if(s.equals("(") || s.equals("[") || s.equals("{")) {
                System.out.println("123");
                st.push(s);
            }
            else {
                if(st.empty()) {
                    System.out.println("empty");
                    continue;
                }
                String str = st.peek();
                if(str.equals("[") && s.equals("]")) {
                    st.pop();
                    System.out.println("找到【】匹配");
                    continue;
                }
                if(str.equals("(") && s.equals(")")) {
                    st.pop();
                    System.out.println("找到()匹配");
                    continue;
                }
                if(str.equals("{") && s.equals("}")) {
                    st.pop();
                    System.out.println("找到{}匹配");
                    continue;
                }
                st.push(s);
            }



        }



    }
    public static void main(String[] args) {
        HashMap <String, String> map = new HashMap <String, String>();
        HashMap map1 = new HashMap();
        System.out.println(map1);

//        增加元素
        map1.put("123", "hahaha");
        map1.put(1, "hahaha");
        map1.put(2.888, 3);
        System.out.println(map1);
        map.put("xiaoming", "hehehe");

        //  先判断再读取， 语意比较好可以判断读处是否包含
        if(map.containsKey("baiyuejiao")) {
            System.out.println(map.get(null));
        }
        // key 值覆盖
        map.put("baiyuejiao", "hahaha1");
        System.out.println(map.get("baiyuejiao"));
        getKuohao("{[{()}]}");
        // 删除元素

        map.remove("baiyuejiao");
        // 读取元素即使不存在也不会报错为 null
        System.out.println(map.get("baiyuejiao"));

        Stack<Integer> st = new Stack<Integer>();
        st.push(9);
        st.push(10);
        System.out.println(st.pop());
        // 栈顶元素
        System.out.println(st.peek());
        // 是否是空
        System.out.println(st.empty());
        // 队列 尖括号是类型, Queue是接口 LinkedList 类实现了  Queue
        Queue<Integer> queue = new LinkedList<Integer>();
        ((LinkedList<Integer>) queue).add(1);
        queue.isEmpty();

    }
}
