package net.webfuse;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
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

        //所有的lambda表达式都是延迟执行的
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


        //groupingBy方法，对具有相同特性的值进行分组
        //当分类函数式一个predicate函数（即返回一个布尔值的函数）时，流元素会被分为两组列表：一组是函数会返回true的元素，另一组返回false的元素。
        //在这种情况下，使用partitioningBy会比groupingBy更有效率。

    }

    public void aboutTime() {

        Instant start = Instant.now();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        timeElapsed.toMillis();
        timeElapsed.toDays();
        timeElapsed.plusDays(1).getSeconds();
        start.plusMillis(1);

        // 以下是来自廖雪峰的博客
        // Java 8新增了LocalDate和LocalTime接口，为什么要搞一套全新的处理日期和时间的API？因为旧的java.util.Date实在是太难用了。
        // java.util.Date月份从0开始，一月是0，十二月是11，变态吧！java.time.LocalDate月份和星期都改成了enum，就不可能再用错了。
        // java.util.Date和SimpleDateFormatter都不是线程安全的，而LocalDate和LocalTime和最基本的String一样，是不变类型，不但线程安全，而且不能修改。
        // java.util.Date是一个“万能接口”，它包含日期、时间，还有毫秒数，如果你只想用java.util.Date存储日期，或者只存储时间，那么，只有你知道哪些部分的数据是有用的，哪些部分的数据是不能用的。在新的Java 8中，日期和时间被明确划分为LocalDate和LocalTime，LocalDate无法包含时间，LocalTime无法包含日期。当然，LocalDateTime才能同时包含日期和时间。
        // 新接口更好用的原因是考虑到了日期时间的操作，经常发生往前推或往后推几天的情况。用java.util.Date配合Calendar要写好多代码，而且一般的开发人员还不一定能写对。

        // 取当前日期：
        LocalDate today = LocalDate.now(); // -> 2014-12-24
        // 根据年月日取日期，12月就是12：
        LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25
        // 根据字符串取：
        LocalDate endOfFeb = LocalDate.parse("2014-02-28"); // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        LocalDate.parse("2014-02-29"); // 无效日期无法通过：DateTimeParseException: Invalid date

        // LocalTime只包含时间，以前用java.util.Date怎么才能只表示时间呢？答案是，假装忽略日期。
        // LocalTime包含毫秒：
        LocalTime now = LocalTime.now(); // 11:09:09.240

        //你可能想清除毫秒数：
        LocalTime now1 = LocalTime.now().withNano(0); // 11:09:09

        //构造时间也很简单：
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00

        //日期校正器
        //TemporalAdjusters类提供了很多静态方法来进行常用的校正。你可以将一个校正放的结果传递给with方法。
        LocalDate firstTuesday = LocalDate.of(2018, 2, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)); //计算2月的第一个星期二

        //实现自己的校验器
        TemporalAdjuster NEXT_WORKDAY = TemporalAdjusters.ofDateAdjuster(w -> {
            LocalDate result = w;
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);
            return result;
        });
        LocalDate backToWork = LocalDate.now().with(NEXT_WORKDAY);

        //格式化与解析
        // String formatted =  DateTimeFormatter.ISO_DATE_TIME.format();
    }


    public void aboutConcurrency() {
        //原子性 lambda
        // ConcurrentHashMap
        ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap();
        map.putIfAbsent("", new LongAdder());
        map.get("").increment();

        //批量数据操作有三类：
        //1)search会对每个键和（或）值应用一个函数，直到函数返回一个非null的结果。然后search会终止并返回该函数的结果。
        //2)reduce会通过提供的累积函数，将所有的键和（或）值组合起来。
        //3)forEach会对所有的键和（或）值应用一个函数。

        //在使用这几种操作时，你需要指定一个并行阈值。如果映射包含的元素数量超过了这个阈值，批量操作就以并行方式执行。
        //如果你希望批量数据操作在一个线程中运行，请使用Long.MAX_VALUE作为阈值。
        //如果你希望批量数据操作尽可能使用更多的线程，则应该使用1作为阈值。

        Set<String> words = map.keySet();

        //并行数组操作
        //静态方法Arrays.parallelSort可以对原始类型数组或者对象数组进行排序。
        try {
            String contents = new String(Files.readAllBytes(Paths.get("")), StandardCharsets.UTF_8);
            String[] words1 = contents.split("");
            Arrays.parallelSort(words1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //可完成的Future
        //Future<T>接口用来表示一个在将来某个时间点可用的、类型为T的值。
    }

    public void aboutOthers() {

        String joined = String.join("/", "usr", "local", "bin");
        String ids = String.join(", ", ZoneId.getAvailableZoneIds());

        Objects.isNull("");
        Objects.nonNull("");
    }

}
