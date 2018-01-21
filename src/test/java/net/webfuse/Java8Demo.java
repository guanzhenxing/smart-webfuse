package net.webfuse;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Java8Demo {

    /**
     * 带有参数变量的表达式都被称为lambda表达式
     * lambda表达式：基本型为 (形参列表)->{方法体}
     * 方法引用： ::操作符将方法名和对象或类的名字分割开来
     */
    public void aboutLambda() {
        Comparator<String> comp = (str1, str2) -> 0;

        new Thread(() -> {
            for (int i = 0; i < 100; i++)
                System.out.println("Lambda Expression");
        }).start();

        //函数式接口：对于只包含一个抽象方法的接口，你可以通过lambda表达式来创建该接口的对象。
        Arrays.sort(new String[]{"a", "b"}, comp);

        //方法引用等同于提供方法参数的lambda表达式
        Arrays.asList("", "").stream().forEach(System.out::print);//情况1：对象::实例方法
        Arrays.asList(1, 2).stream().map(Math::abs).collect(Collectors.toList());//情况2：类::静态方法
        Arrays.sort(new String[]{"", ""}, Comparator.comparingInt(String::length)); //情况3：类::实例方法。第一个参数会成为执行方法的对象.String::length 等于 (x)->x.length()
        String[] arr = Arrays.asList("", "").stream().toArray(String[]::new);   //情况4：类::new

    }

}
