package net.webfuse.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ListUtil {

    public static String toString(Object... objs) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < objs.length; i++) {
            if (i != 0)
                buffer.append(",");
            buffer.append(objs[i]);
        }
        return buffer.toString();
    }

    public static <T> List<T> merge(List<T> list, List<T>... lists) {
        return merge(new ArrayList<>(), list, lists);
    }

    public static <T> List<T> merge(List<T> target, List<T> list, List<T>... lists) {
        target.addAll(list);
        for (int i = 0; i < lists.length; i++) {
            target.addAll(lists[i]);
        }
        return target;
    }

    public static <T> List<T> merge(Supplier<List<T>> supplier, List<T> list, List<T>... lists) {
        return merge(supplier.get(), list, lists);
    }

    

}
