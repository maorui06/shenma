package org.example.xdiamond.util;

/**
 * 使每个线程拥有自己的totalCount变量
 * 
 * @author zongying.zhao
 * @version $Id: TotalCountHolder.java, v 0.1 2017年8月22日 下午6:09:21 zongying.zhao Exp $
 */
public class TotalCountHolder {

    private static ThreadLocal<Integer> holder = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void set(int value) {
        holder.set(value);
    }

    public static int get() {
        return holder.get();
    }

    public static void remove() {
        holder.remove();
    }
}
