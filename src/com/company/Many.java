package com.company;

public class Many {

    int a = 1;

    void b(){
        System.out.println(2);

    }
    void h(){
        System.out.println("kkk");
    }

}

class B extends  Many{

    int a = 10;

    void b(){
        System.out.println(22);

    }
    public static void main(String[] args) {
        // 父引用可以看出方法遵循new属性和静态方法遵循引用类型
        Many a = new B();
        System.out.println(a.a);
        a.b();
        a.h();
    }

}

/*
*
*
* 这时候 由于 编译时a引用 具体指向的是哪个类型对象不知道（因为 new 是在运行时产生的）所以编译时绑定，a的属性就是根据已经知道a引用的类型来，所以a获得属性的就近原则对象永远是Many这时候 由于 运行时a引用 具体指向的是哪个类型对象知道了，是指向b（因为 new 是在运行时产生的）所以运行时绑定，a的普通方法就是根据已经知道a具体指向的类型来，所以a获得方法的就近原则对象永远是B----------------------------这里就叫多态所谓的就近原则，以B为例，如果就近原则的对象是B，如果B和父类有同名的东西，那么就用B的，如果B的父类和B的父类的父类有同名的东西（B没有），就用B的父类的
多态就一句话：多态时普通方法在运行时绑定这个行为产生的结果，绑定遵循最近原则
普通方法是什么？
1.什么是普通方法：下面都不是普通方法final方法是在编译时内嵌调用，所以是在编译时绑定的属性也是编译时绑定的static方法也是编译时绑定的，因为static是在类的方法区中的静态代码private是隐式的final方法局部变量不用说了，他的作用域就说明他和多态没有关系其他的就是普通方法了
编译时候确定的就不是普通方法

*
*
* */
