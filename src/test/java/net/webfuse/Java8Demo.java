package net.webfuse;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    public void aboutStreamAPI() {
        List<String> words = new ArrayList<>();
        long count = words.parallelStream().filter(w -> w.length() > 12).count();

        //Stream遵循“做什么，而不是怎么去做”的原则。
        //在使用Stream时候，你会通过三个阶段来建立一个操作流水线：
        //1-创建一个Stream
        //2-在一个或多个步骤中，指定将初始Stream转换为另一个Stream的中间操作
        //3-使用一个终止操作来产生一个结果。该操作会强制它之前的延迟操作立即执行。在这之后，该Stream操作就不会再被使用了。

        Stream<String> wordStream = Stream.of(new String[]{});
        Stream<String> song = Stream.of("", "", "");

        Stream<String> echos = Stream.generate(() -> "Echo"); //创建一个含有常亮值的Stream
        Stream<Double> randoms = Stream.generate(Math::random); //创建一个含有随机数的Stream
        //iterate方法接受一个“种子”的值和一个函数作为参数
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));


        //流转换是指从一个流中读取数据，并将转换后的数据写入到另一个流中。
        //filter方法的参数是一个Predicate<T>对象——即一个从T到boolean的函数。
        //我们使用map方法对流中的值进行某种形式的转换，它会对每个元素应用一个函数，并将返回的值收集到一个新的流中。

        //distinct方法会根据原始流中的元素返回一个具有相同顺序、抑制了重复元素的新流。

        //聚合方法：如果你希望对元素求和，或者以其他方式将流中的元素组合为一个值
        //    - count方法：返回流中元素的总数
        //    - max方法：返回流中最大值
        //    - min方法：返回流中最小值
        //    - reduce方法： 提供聚合操作

        //Optional<T>对象或者是对一个T类型对象的封装，或者表示不是任何对象。
        // if(optionalValue.ifPresent()) optionalValue.get().someMethod();
        // optionalValue.ifPresent(v->results::add);
        // Optional<Boolean> added = optionalValue.map(results::add);   //返回一个值
        // optionalValue.orElse("");
        // optionalValue.orElseGet(()->System.out.print("...."));
        // optionalValue.orElseThrow(NoSuchElementException:new);
        // 可以使用Optional.of(result)或者Optional.empty()来创建一个Optional对象
        // ofNullable方法中，如果obj不为null,那么Optional.ofNullable(obj)会返回Optional.of(obj),否则会返回Optional.empty()。
        //使用flatMap来组合可选函数。Optional<U> u =  s.f().flatMap(T::g);

        //以下3个是等效的
        HashSet<String> res = wordStream.collect(HashSet::new, HashSet::add, HashSet::addAll);
        List<String> res1 = wordStream.collect(Collectors.toList());
        Set<String> res2 = wordStream.collect(Collectors.toSet());

        //将字符串连接起来
        String str = wordStream.collect(Collectors.joining());

        //将字符串连接起来，中间以,隔开
        String str1 = wordStream.collect(Collectors.joining(", "));

        //使用(Int|Double|Long)SummaryStatistics来获得一个流的总和、平均值、最大值或最小值
        IntSummaryStatistics summary = wordStream.collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();

        //将一个Stream对象中的元素收集到一个map中
        //Map<Integer,String> idToName = peopleStream.collect(Collectors.toMap(Person::getId,Person::getName));

        //上面的转换成Map中，如果存在相同的键异常，我们可以重写方法搞定。
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(Collectors.toMap(
                l -> l.getDisplayLanguage(),
                l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> existingValue
        ));

    }


}
